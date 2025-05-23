package com.tencent.biz.qqcircle.utils;

import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.lang.ref.WeakReference;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSAsyncUtils {

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static class BackgroundTask<PARAM, RESULT> implements Runnable {
        private static final String TAG = "BackgroundTask";
        private final WeakReference<Callback<PARAM, RESULT>> mCallbackWeak;
        private MainPostTask mMainPostTask;
        private PARAM[] mParams;

        public BackgroundTask(Callback<PARAM, RESULT> callback, PARAM... paramArr) {
            this.mCallbackWeak = new WeakReference<>(callback);
            this.mParams = paramArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            Callback<PARAM, RESULT> callback;
            WeakReference<Callback<PARAM, RESULT>> weakReference = this.mCallbackWeak;
            RESULT result = null;
            if (weakReference == null) {
                callback = null;
            } else {
                callback = weakReference.get();
            }
            if (callback == null) {
                QLog.e(TAG, 1, "[run] current callback should not be null.");
                return;
            }
            try {
                result = callback.doBackgroundAction(this.mParams);
            } catch (Throwable th5) {
                QLog.e(TAG, 1, th5, new Object[0]);
            }
            this.mMainPostTask = new MainPostTask(callback, result);
            RFWThreadManager.getUIHandler().post(this.mMainPostTask);
        }
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    private static class MainPostTask<PARAM, RESULT> implements Runnable {
        private static final String TAG = "MainPostTask";
        private final WeakReference<Callback<PARAM, RESULT>> mCallbackWeak;
        private RESULT mResult;

        public MainPostTask(Callback<PARAM, RESULT> callback, RESULT result) {
            this.mCallbackWeak = new WeakReference<>(callback);
            this.mResult = result;
        }

        @Override // java.lang.Runnable
        public void run() {
            Callback<PARAM, RESULT> callback;
            WeakReference<Callback<PARAM, RESULT>> weakReference = this.mCallbackWeak;
            if (weakReference == null) {
                callback = null;
            } else {
                callback = weakReference.get();
            }
            if (callback == null) {
                QLog.e(TAG, 1, "[run] current callback should not be null.");
            } else {
                callback.doMainAction(this.mResult);
            }
        }
    }

    public static <PARAM, RESULT> void executeSerial(Callback<PARAM, RESULT> callback, PARAM... paramArr) {
        RFWThreadManager.getInstance().getSerialThreadHandler().post(new BackgroundTask(callback, paramArr));
    }

    public static <PARAM, RESULT> void executeSub(Callback<PARAM, RESULT> callback, PARAM... paramArr) {
        RFWThreadManager.getInstance().execOnSubThread(new BackgroundTask(callback, paramArr));
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public static abstract class Callback<PARAM, RESULT> {
        public abstract RESULT doBackgroundAction(PARAM... paramArr);

        public void doMainAction(RESULT result) {
        }
    }
}
