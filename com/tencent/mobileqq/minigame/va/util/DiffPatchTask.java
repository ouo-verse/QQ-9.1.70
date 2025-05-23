package com.tencent.mobileqq.minigame.va.util;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.minibox.business.api.MiniBoxSDK;
import com.tencent.mobileqq.filemanager.util.q;
import com.tencent.mobileqq.minigame.api.IMiniGameVAUtilsApi;
import com.tencent.mobileqq.minigame.config.MiniGameVAInterceptConfig;
import com.tencent.mobileqq.minigame.va.MiniGameDiffPatchInfo;
import com.tencent.mobileqq.minigame.va.MiniGameDownloadData;
import com.tencent.mobileqq.minigame.va.util.DiffPatchTaskManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes33.dex */
public class DiffPatchTask {
    private static final byte[] LOCK = new byte[0];
    private static final String TAG = "MiniGameVADiffPatchTask";
    private static final long TIME_OUT_INTERVAL = 1800000;
    private File destApkFile;
    private MiniGameDiffPatchInfo diffPatchInfo;
    private MiniGameDownloadData downloadData;
    private boolean isStartOnForeground;
    private String reportFrom;
    private long reportStartTime;
    private List<DiffPatchTaskManager.DiffPatchCallback> callbacks = new ArrayList();
    private ji3.b izPlanDiffPathListener = new ji3.b() { // from class: com.tencent.mobileqq.minigame.va.util.DiffPatchTask.1
        @Override // ji3.b
        public void onFail(String str, String str2) {
            MiniGameVAUtil.showDebugToast("\u6587\u4ef6\u6587\u4ef6\u5931\u8d25");
            long uptimeMillis = SystemClock.uptimeMillis();
            q.c(DiffPatchTask.this.destApkFile);
            QLog.i(DiffPatchTask.TAG, 1, "hDiffPatch errorCode=$errorCode, msg=$errorMessage");
            DiffPatchTask.this.callbackOnFail("hDiffPatch errorCode=$errorCode, msg=$errorMessage");
            DiffPatchUtil.INSTANCE.reportDiffPatchResult(DiffPatchTask.this.downloadData, str, str2, uptimeMillis - DiffPatchTask.this.reportStartTime, 0L, 0L, 0L, DiffPatchTask.this.reportFrom, DiffPatchTask.this.isStartOnForeground);
        }

        @Override // ji3.b
        public void onSuccess(long j3) {
            long j16;
            String str;
            long uptimeMillis = SystemClock.uptimeMillis();
            QLog.i(DiffPatchTask.TAG, 1, "hDiffPatch success, cost:" + j3);
            if (DiffPatchTask.this.diffPatchInfo.getNewApkDataSize() != DiffPatchTask.this.destApkFile.length()) {
                QLog.i(DiffPatchTask.TAG, 1, "onSuccess, but file length not match, diffPatchInfo" + DiffPatchTask.this.diffPatchInfo + " newApkFile.length():" + DiffPatchTask.this.destApkFile.length());
                MiniGameVAUtil.showDebugToast("\u6587\u4ef6\u5408\u5e76\u5931\u8d25\uff0c\u957f\u5ea6\u4e0d\u4e00\u81f4 newApkFile.length:" + DiffPatchTask.this.destApkFile.length() + " diffPatchInfo.newApkDataSize:" + DiffPatchTask.this.diffPatchInfo.getNewApkDataSize());
                DiffPatchTask.this.callbackOnFail("file length not match!");
                DiffPatchUtil.INSTANCE.reportDiffPatchResult(DiffPatchTask.this.downloadData, "-101", "file length check fail", uptimeMillis - DiffPatchTask.this.reportStartTime, 0L, DiffPatchTask.this.destApkFile.length(), DiffPatchTask.this.diffPatchInfo.getNewApkDataSize(), DiffPatchTask.this.reportFrom, DiffPatchTask.this.isStartOnForeground);
                q.c(DiffPatchTask.this.destApkFile);
                return;
            }
            MiniGameVAInterceptConfig miniGameVAInterceptConfig = (MiniGameVAInterceptConfig) ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadConfig(MiniGameVAInterceptConfig.CONFIG_ID);
            if (miniGameVAInterceptConfig == null || !miniGameVAInterceptConfig.getDiffPatchMD5CheckEnable()) {
                j16 = 0;
            } else {
                long uptimeMillis2 = SystemClock.uptimeMillis();
                try {
                    str = com.tencent.qqprotect.singleupdate.a.d(DiffPatchTask.this.destApkFile);
                } catch (IOException e16) {
                    QLog.e(DiffPatchTask.TAG, 1, "onSuccess but ", e16);
                    str = null;
                }
                j16 = System.currentTimeMillis() - uptimeMillis2;
                if (!TextUtils.equals(str, DiffPatchTask.this.diffPatchInfo.getNewMd5())) {
                    MiniGameVAUtil.showDebugToast("\u6587\u4ef6\u5408\u5e76\u5b8c\u6210\uff0cMD5\u6821\u9a8c\u5931\u8d25");
                    DiffPatchTask.this.callbackOnFail("diff apk md5 check failed.");
                    DiffPatchUtil.INSTANCE.reportDiffPatchResult(DiffPatchTask.this.downloadData, "-100", "md5 check fail", uptimeMillis - DiffPatchTask.this.reportStartTime, j16, 0L, 0L, DiffPatchTask.this.reportFrom, DiffPatchTask.this.isStartOnForeground);
                    q.c(DiffPatchTask.this.destApkFile);
                    return;
                }
            }
            long j17 = j16;
            long uptimeMillis3 = SystemClock.uptimeMillis();
            File file = new File(DiffPatchTask.this.downloadData.getApkPath());
            boolean c16 = q.c(file);
            boolean renameTo = DiffPatchTask.this.destApkFile.renameTo(file);
            QLog.i(DiffPatchTask.TAG, 1, "diff complete, md5 calculate cost=" + (SystemClock.uptimeMillis() - uptimeMillis3) + " delete:" + c16 + " rename:" + renameTo);
            if (renameTo) {
                DiffPatchTask.this.callbackOnSuccess(file.getAbsolutePath());
            } else {
                DiffPatchTask diffPatchTask = DiffPatchTask.this;
                diffPatchTask.callbackOnSuccess(diffPatchTask.destApkFile.getAbsolutePath());
            }
            DiffPatchUtil.INSTANCE.reportDiffPatchResult(DiffPatchTask.this.downloadData, "0", "", uptimeMillis - DiffPatchTask.this.reportStartTime, j17, 0L, 0L, DiffPatchTask.this.reportFrom, DiffPatchTask.this.isStartOnForeground);
        }
    };

    public DiffPatchTask(MiniGameDownloadData miniGameDownloadData) {
        this.downloadData = miniGameDownloadData;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnFail(String str) {
        synchronized (LOCK) {
            Iterator<DiffPatchTaskManager.DiffPatchCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onFail(str);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callbackOnSuccess(String str) {
        synchronized (LOCK) {
            Iterator<DiffPatchTaskManager.DiffPatchCallback> it = this.callbacks.iterator();
            while (it.hasNext()) {
                it.next().onSuccess(str);
            }
        }
    }

    public void addDiffPatchListener(DiffPatchTaskManager.DiffPatchCallback diffPatchCallback) {
        synchronized (LOCK) {
            this.callbacks.add(diffPatchCallback);
        }
    }

    public void clear() {
        synchronized (LOCK) {
            this.callbacks.clear();
        }
    }

    public boolean isValidTask() {
        return this.reportStartTime != 0 && SystemClock.uptimeMillis() - this.reportStartTime < 1800000;
    }

    public void startDiffPatch(String str) {
        MiniGameDiffPatchInfo diffPatchInfo = this.downloadData.getDiffPatchInfo();
        if (diffPatchInfo == null) {
            callbackOnFail("diffPatchInfo is null.");
            return;
        }
        this.diffPatchInfo = diffPatchInfo;
        String apkPath = MiniBoxSDK.getApkPath(BaseApplication.getContext(), this.downloadData.getPkgName());
        QLog.i(TAG, 1, "startDiffPatch baseApkPath.length:" + q.m(apkPath));
        if (!q.p(apkPath)) {
            callbackOnFail("MiniBox get base Apk Path failed.");
            return;
        }
        String apkPath2 = this.downloadData.getApkPath();
        if (!q.p(apkPath2)) {
            callbackOnFail("cannot find patch file.");
            return;
        }
        File file = new File(apkPath2);
        if (file.length() == diffPatchInfo.getNewApkDataSize()) {
            QLog.i(TAG, 1, "startDiffPatch had diff patch!, return");
            callbackOnSuccess(file.getAbsolutePath());
            return;
        }
        if (((IMiniGameVAUtilsApi) QRoute.api(IMiniGameVAUtilsApi.class)).isApkDownloadInnerStorageEnable()) {
            this.destApkFile = new File(MobileQQ.sMobileQQ.getCacheDir(), diffPatchInfo.getNewMd5());
        } else {
            this.destApkFile = new File(MobileQQ.sMobileQQ.getExternalCacheDir(), diffPatchInfo.getNewMd5());
        }
        q.c(this.destApkFile);
        DiffPatchUtil.INSTANCE.reportBeginPatch(this.downloadData, str);
        this.reportStartTime = SystemClock.uptimeMillis();
        this.reportFrom = str;
        this.isStartOnForeground = com.tencent.mobileqq.qmethodmonitor.a.a(BaseApplication.getContext());
        ((IZPlanApi) QRoute.api(IZPlanApi.class)).hDiffPatch(apkPath, apkPath2, this.destApkFile.getAbsolutePath(), this.izPlanDiffPathListener);
    }
}
