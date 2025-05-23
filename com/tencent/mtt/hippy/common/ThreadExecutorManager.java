package com.tencent.mtt.hippy.common;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mtt.hippy.HippyEngine;
import com.tencent.mtt.hippy.common.ThreadExecutor;
import com.tencent.mtt.hippy.utils.LogUtils;
import java.util.ArrayList;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThreadExecutorManager implements ThreadExecutor.UncaughtExceptionHandler {
    private static ThreadExecutorManager sInstance;
    private final HashMap<Integer, ThreadExecutor> mThreadExecutorMap = new HashMap<>();
    private final HashMap<Integer, ArrayList<Integer>> mEngineMap = new HashMap<>();

    ThreadExecutorManager() {
    }

    private void destroyThreadExecutor(Integer num) {
        if (this.mThreadExecutorMap.containsKey(num)) {
            ThreadExecutor threadExecutor = this.mThreadExecutorMap.get(num);
            if (threadExecutor != null) {
                threadExecutor.destroy();
            }
            this.mThreadExecutorMap.remove(num);
        }
    }

    public static ThreadExecutorManager getInstance() {
        if (sInstance == null) {
            synchronized (ThreadExecutorManager.class) {
                if (sInstance == null) {
                    sInstance = new ThreadExecutorManager();
                }
            }
        }
        return sInstance;
    }

    private synchronized void handleExceptionImpl(Thread thread, Throwable th5, Integer num) {
        if (num.intValue() < 0) {
            return;
        }
        destroyThreadExecutor(num);
        this.mEngineMap.remove(num);
    }

    public synchronized void add(HippyEngine hippyEngine) {
        Integer valueOf = Integer.valueOf(hippyEngine.getGroupId());
        if (valueOf.intValue() < 0) {
            return;
        }
        try {
            if (this.mThreadExecutorMap.get(valueOf) == null) {
                ThreadExecutor threadExecutor = new ThreadExecutor(valueOf.intValue());
                threadExecutor.setUncaughtExceptionHandler(this);
                this.mThreadExecutorMap.put(valueOf, threadExecutor);
            }
            Integer valueOf2 = Integer.valueOf(hippyEngine.getId());
            ArrayList<Integer> arrayList = this.mEngineMap.get(valueOf);
            if (arrayList == null) {
                ArrayList<Integer> arrayList2 = new ArrayList<>();
                arrayList2.add(valueOf2);
                this.mEngineMap.put(valueOf, arrayList2);
            } else if (!arrayList.contains(valueOf2)) {
                arrayList.add(valueOf2);
            } else {
                LogUtils.e(HippyQQConstants.HIPPY_TAG, "add same engine twice");
            }
        } catch (Exception e16) {
            LogUtils.d("ThreadExecutorManager", "add: " + e16.getMessage());
        }
    }

    public synchronized ThreadExecutor getThreadExecutor(int i3) {
        return this.mThreadExecutorMap.get(Integer.valueOf(i3));
    }

    @Override // com.tencent.mtt.hippy.common.ThreadExecutor.UncaughtExceptionHandler
    public void handleThreadUncaughtException(Thread thread, Throwable th5, Integer num) {
        handleExceptionImpl(thread, th5, num);
    }

    public synchronized void remove(HippyEngine hippyEngine) {
        ArrayList<Integer> arrayList;
        Integer valueOf = Integer.valueOf(hippyEngine.getGroupId());
        if (valueOf.intValue() < 0) {
            return;
        }
        try {
            arrayList = this.mEngineMap.get(valueOf);
        } catch (Exception e16) {
            LogUtils.d("ThreadExecutorManager", "remove: " + e16.getMessage());
        }
        if (arrayList == null) {
            destroyThreadExecutor(valueOf);
            return;
        }
        arrayList.remove(Integer.valueOf(hippyEngine.getId()));
        if (arrayList.size() <= 0) {
            this.mEngineMap.remove(valueOf);
            destroyThreadExecutor(valueOf);
        }
    }
}
