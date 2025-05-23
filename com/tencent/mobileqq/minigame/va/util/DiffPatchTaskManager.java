package com.tencent.mobileqq.minigame.va.util;

import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes33.dex */
public class DiffPatchTaskManager {
    private static final String TAG = "MiniGameVADiffPatchTaskManager";
    private static DiffPatchTaskManager sInstance;
    private final ConcurrentHashMap<String, DiffPatchTask> taskMap = new ConcurrentHashMap<>();

    /* loaded from: classes33.dex */
    public interface DiffPatchCallback {
        void onFail(String str);

        void onSuccess(String str);
    }

    DiffPatchTaskManager() {
    }

    private void createDiffPatchTask(MiniGameDownloadData miniGameDownloadData, final DiffPatchCallback diffPatchCallback, String str, final MiniGameDiffPatchInfo miniGameDiffPatchInfo) {
        DiffPatchTask diffPatchTask = new DiffPatchTask(miniGameDownloadData);
        this.taskMap.put(miniGameDiffPatchInfo.getDiffTaskKey(), diffPatchTask);
        diffPatchTask.addDiffPatchListener(new DiffPatchCallback() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.1
            @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
            public void onFail(String str2) {
                diffPatchCallback.onFail(str2);
                DiffPatchTaskManager.this.taskMap.remove(miniGameDiffPatchInfo.getDiffTaskKey());
            }

            @Override // com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager.DiffPatchCallback
            public void onSuccess(String str2) {
                diffPatchCallback.onSuccess(str2);
                DiffPatchTaskManager.this.taskMap.remove(miniGameDiffPatchInfo.getDiffTaskKey());
            }
        });
        diffPatchTask.startDiffPatch(str);
    }

    public static synchronized DiffPatchTaskManager getTaskManager() {
        DiffPatchTaskManager diffPatchTaskManager;
        synchronized (DiffPatchTaskManager.class) {
            if (sInstance == null) {
                sInstance = new DiffPatchTaskManager();
            }
            diffPatchTaskManager = sInstance;
        }
        return diffPatchTaskManager;
    }

    public void onDestroy() {
        this.taskMap.clear();
    }

    public void startPatch(MiniGameDownloadData miniGameDownloadData, DiffPatchCallback diffPatchCallback, String str) {
        if (miniGameDownloadData == null || miniGameDownloadData.getDiffPatchInfo() == null) {
            return;
        }
        MiniGameDiffPatchInfo diffPatchInfo = miniGameDownloadData.getDiffPatchInfo();
        DiffPatchTask diffPatchTask = this.taskMap.get(diffPatchInfo.getDiffTaskKey());
        if (diffPatchTask == null) {
            QLog.i(TAG, 1, "startPatch crate new diff patch task");
            createDiffPatchTask(miniGameDownloadData, diffPatchCallback, str, diffPatchInfo);
        } else {
            if (!diffPatchTask.isValidTask()) {
                diffPatchTask.clear();
                QLog.i(TAG, 1, "startPatch find same task, but invalid! create new diff patch task");
                this.taskMap.remove(diffPatchInfo.getDiffTaskKey());
                createDiffPatchTask(miniGameDownloadData, diffPatchCallback, str, diffPatchInfo);
                return;
            }
            QLog.i(TAG, 1, "startPatch find same task, addDiffPatchListener");
            diffPatchTask.addDiffPatchListener(diffPatchCallback);
        }
    }
}
