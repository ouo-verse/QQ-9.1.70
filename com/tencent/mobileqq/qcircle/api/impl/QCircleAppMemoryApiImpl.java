package com.tencent.mobileqq.qcircle.api.impl;

import android.os.Debug;
import androidx.annotation.NonNull;
import com.google.gson.Gson;
import com.tencent.mobileqq.qcircle.api.IQCircleAppMemoryApi;
import com.tencent.mobileqq.utils.SdCardUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.richframework.thread.RFWThreadManager;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes16.dex */
public class QCircleAppMemoryApiImpl implements IQCircleAppMemoryApi {
    private static final String DUMP_DIR_NAME = "qcircle_dump";
    private static final String DUMP_JAVA_FILE_SUFFIX = ".hprof";
    private static final String DUMP_NATIVE_FILE_SUFFIX = ".json";
    private static final String FILE_DIR = "Android/data/com.tencent.mobileqq/";
    private static final String TAG = "QCircleAppMemoryApiImpl";
    private static final String TIME_FORMAT = "yy-MM-dd_HH.mm.ss";
    private final String mRootPath;

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class StartJavaMemoryMonitorTask implements Runnable {
        private WeakReference<QCircleAppMemoryApiImpl> mMemoryApiImplWeak;

        public StartJavaMemoryMonitorTask(QCircleAppMemoryApiImpl qCircleAppMemoryApiImpl) {
            this.mMemoryApiImplWeak = new WeakReference<>(qCircleAppMemoryApiImpl);
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleAppMemoryApiImpl qCircleAppMemoryApiImpl;
            WeakReference<QCircleAppMemoryApiImpl> weakReference = this.mMemoryApiImplWeak;
            if (weakReference == null) {
                qCircleAppMemoryApiImpl = null;
            } else {
                qCircleAppMemoryApiImpl = weakReference.get();
            }
            if (qCircleAppMemoryApiImpl != null) {
                File file = new File(qCircleAppMemoryApiImpl.mRootPath + File.separator + qCircleAppMemoryApiImpl.buildJavaDumpFileName());
                if (!qCircleAppMemoryApiImpl.checkAndCreateFileExists(file)) {
                    QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[dump] create file fail...", new Exception());
                    return;
                }
                String absolutePath = file.getAbsolutePath();
                boolean dump = QCircleAppMemoryApiImpl.dump(absolutePath);
                QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[dump] isDumpSuccess: " + dump + " | path: " + absolutePath);
                if (dump) {
                    qCircleAppMemoryApiImpl.notifyJavaDumpTaskFinish(absolutePath);
                    return;
                } else {
                    qCircleAppMemoryApiImpl.notifyJavaDumpTaskFail(absolutePath);
                    return;
                }
            }
            QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[run] memoryApi should not be null.");
        }
    }

    /* compiled from: P */
    /* loaded from: classes16.dex */
    private static class StartNativeMemoryMonitorTask implements Runnable {
        private static final String TAG = "NativeDumpTask";
        private WeakReference<QCircleAppMemoryApiImpl> mMemoryApiImplWeak;

        public StartNativeMemoryMonitorTask(QCircleAppMemoryApiImpl qCircleAppMemoryApiImpl) {
            this.mMemoryApiImplWeak = new WeakReference<>(qCircleAppMemoryApiImpl);
        }

        @Override // java.lang.Runnable
        public void run() {
            QCircleAppMemoryApiImpl qCircleAppMemoryApiImpl;
            WeakReference<QCircleAppMemoryApiImpl> weakReference = this.mMemoryApiImplWeak;
            if (weakReference == null) {
                qCircleAppMemoryApiImpl = null;
            } else {
                qCircleAppMemoryApiImpl = weakReference.get();
            }
            if (qCircleAppMemoryApiImpl != null) {
                File file = new File(qCircleAppMemoryApiImpl.mRootPath + File.separator + qCircleAppMemoryApiImpl.buildNativeDumpFileName());
                if (!qCircleAppMemoryApiImpl.checkAndCreateFileExists(file)) {
                    QLog.e(TAG, 1, "[run] create file fail...", new Exception());
                    return;
                }
                String absolutePath = file.getAbsolutePath();
                try {
                    jd2.b.a(absolutePath);
                    qCircleAppMemoryApiImpl.notifyNativeDumpTaskFinish(absolutePath);
                    return;
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, th5, new Object[0]);
                    qCircleAppMemoryApiImpl.notifyNativeDumpTaskFail(absolutePath);
                    return;
                }
            }
            QLog.e(TAG, 1, "[run] memory api should not be null.");
        }
    }

    public QCircleAppMemoryApiImpl() {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(SdCardUtil.getSdCardDirectory());
        String str = File.separator;
        sb5.append(str);
        sb5.append(FILE_DIR);
        sb5.append(str);
        sb5.append(DUMP_DIR_NAME);
        this.mRootPath = sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildJavaDumpFileName() {
        return getFormatTime(System.currentTimeMillis(), TIME_FORMAT) + DUMP_JAVA_FILE_SUFFIX;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String buildNativeDumpFileName() {
        return getFormatTime(System.currentTimeMillis(), TIME_FORMAT) + ".json";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkAndCreateFileExists(File file) {
        if (file == null) {
            QLog.e(TAG, 1, "[checkAndCreateFileExists] file should not be null.");
            return false;
        }
        try {
            File parentFile = file.getParentFile();
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            if (!file.exists()) {
                file.createNewFile();
            }
            return true;
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean dump(String str) {
        try {
            Debug.dumpHprofData(str);
            return true;
        } catch (IOException e16) {
            QLog.e(TAG, 1, e16, new Object[0]);
            return false;
        }
    }

    private String getFormatTime(long j3, @NonNull String str) {
        if (j3 <= 0) {
            return null;
        }
        return new SimpleDateFormat(str, Locale.US).format(new Date(j3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJavaDumpTaskFail(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleAppMemoryApiImpl.1
            @Override // java.lang.Runnable
            public void run() {
                QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[notifyJavaDumpTaskFail] dump fail, path: " + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyJavaDumpTaskFinish(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleAppMemoryApiImpl.2
            @Override // java.lang.Runnable
            public void run() {
                QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[notifyJavaDumpTaskFinish] dump file path: " + str);
                QQToast.makeText(BaseApplication.getContext(), "\u6293\u53d6hprof\u6587\u4ef6\u6210\u529f!!!", 1).show();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNativeDumpTaskFail(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleAppMemoryApiImpl.3
            @Override // java.lang.Runnable
            public void run() {
                QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[notifyNativeDumpTaskFail] dump fail, path: " + str);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void notifyNativeDumpTaskFinish(final String str) {
        RFWThreadManager.getUIHandler().post(new Runnable() { // from class: com.tencent.mobileqq.qcircle.api.impl.QCircleAppMemoryApiImpl.4
            @Override // java.lang.Runnable
            public void run() {
                QLog.e(QCircleAppMemoryApiImpl.TAG, 1, "[notifyNativeDumpTaskFinish] dump file path: " + str);
                QQToast.makeText(BaseApplication.getContext(), "\u6293\u53d6native json\u6587\u4ef6\u6210\u529f!!!", 1).show();
            }
        });
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleAppMemoryApi
    public void dumpJava(IQCircleAppMemoryApi.CallbackBack callbackBack) {
        QQToast.makeText(BaseApplication.getContext(), "\u5f00\u59cbjava dump\uff0c\u8bf7\u7b49\u5f85!!!", 1).show();
        RFWThreadManager.getInstance().execOnFileThread(new StartJavaMemoryMonitorTask(this));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleAppMemoryApi
    public void dumpNative(IQCircleAppMemoryApi.CallbackBack callbackBack) {
        QQToast.makeText(BaseApplication.getContext(), "\u5f00\u59cbnative dump\uff0c\u8bf7\u7b49\u5f85!!!", 1).show();
        RFWThreadManager.getInstance().execOnFileThread(new StartNativeMemoryMonitorTask(this));
    }

    @Override // com.tencent.mobileqq.qcircle.api.IQCircleAppMemoryApi
    public String getMemoryInfoJson() {
        try {
            return new Gson().toJson(com.tencent.mobileqq.perf.process.backgroud.counter.a.f257838a.a());
        } catch (Throwable th5) {
            QLog.e(TAG, 1, th5, new Object[0]);
            return null;
        }
    }
}
