package cooperation.qzone.networkedmodule;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.component.network.downloader.DownloadResult;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzonePreDownloadManager;
import cooperation.qzone.thread.QzoneHandlerThreadFactory;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QzoneModuleDownloadManager implements Handler.Callback {
    public static final int MSG_DOWNLOAD_ABORT = 7;
    public static final int MSG_DOWNLOAD_CANCEL = 4;
    public static final int MSG_DOWNLOAD_CANCELED = 5;
    public static final int MSG_DOWNLOAD_FAILED = 3;
    public static final int MSG_DOWNLOAD_MODULE = 1;
    public static final int MSG_DOWNLOAD_PROGRESS = 6;
    public static final int MSG_DOWNLOAD_SUCCESS = 2;
    private static String TAG = "QzoneModuleDownloadManager";
    private Context mContext;
    private Map<String, DownloadTask> taskMap = new ConcurrentHashMap();
    private Downloader.DownloadListener mDowndloadListener = new Downloader.DownloadListener() { // from class: cooperation.qzone.networkedmodule.QzoneModuleDownloadManager.1
        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadCanceled(String str) {
            Message obtain = Message.obtain(QzoneModuleDownloadManager.this.mHandler);
            obtain.what = 5;
            obtain.obj = str;
            obtain.sendToTarget();
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadFailed(String str, DownloadResult downloadResult) {
            Message obtain = Message.obtain(QzoneModuleDownloadManager.this.mHandler);
            obtain.what = 3;
            obtain.obj = str;
            obtain.sendToTarget();
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadProgress(String str, long j3, float f16) {
            DownloadTask downloadTask = (DownloadTask) QzoneModuleDownloadManager.this.taskMap.get(str);
            if (downloadTask != null) {
                downloadTask.obj = Float.valueOf(f16);
            }
            Message obtain = Message.obtain(QzoneModuleDownloadManager.this.mHandler);
            obtain.what = 6;
            obtain.obj = downloadTask;
            obtain.sendToTarget();
        }

        @Override // com.tencent.component.network.downloader.Downloader.DownloadListener
        public void onDownloadSucceed(String str, DownloadResult downloadResult) {
            Message obtain = Message.obtain(QzoneModuleDownloadManager.this.mHandler);
            obtain.what = 2;
            obtain.obj = str;
            obtain.sendToTarget();
        }
    };
    private QzonePreDownloadManager mDownloader = QzonePreDownloadManager.getInstance();
    private Handler mHandler = new Handler(QzoneHandlerThreadFactory.getHandlerThreadLooper(QzoneHandlerThreadFactory.NormalThread), this);

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes38.dex */
    public static class DownloadTask {
        ModuleDownloadListener listener;
        String moduleId;
        Object obj;
        boolean priority;
        QzoneModuleRecord record;
        boolean startImmediately;
        long startTimeStamp;

        DownloadTask() {
        }
    }

    public QzoneModuleDownloadManager(Context context) {
        this.mContext = context.getApplicationContext();
    }

    private void onHandleDownload(DownloadTask downloadTask) {
        String str = downloadTask.record.mUrl;
        if (this.taskMap.containsKey(str)) {
            return;
        }
        this.taskMap.put(str, downloadTask);
        QzoneModuleRecord qzoneModuleRecord = downloadTask.record;
        String moduleSavePath = QzoneModuleConst.getModuleSavePath(this.mContext, qzoneModuleRecord);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 1, "----------savePath--" + moduleSavePath);
        }
        File file = new File(moduleSavePath);
        if (file.exists()) {
            String str2 = qzoneModuleRecord.mMD5;
            if (!TextUtils.isEmpty(str2)) {
                long j3 = qzoneModuleRecord.mModuleFileLength;
                if (j3 == 0 || j3 != file.length()) {
                    if (QLog.isColorLevel()) {
                        QLog.d(TAG, 1, "before download-- orgMD5: " + str2 + " , downloadFilePath: " + file.getPath());
                    }
                    File file2 = new File(moduleSavePath);
                    if (file2.exists()) {
                        file2.delete();
                    }
                    QLog.i(TAG, 1, "check download cache failed: md5 verify is not passed.");
                }
            }
            QLog.i(TAG, 1, "download succeed: from cache.");
            QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(qzoneModuleRecord);
            ModuleDownloadListener moduleDownloadListener = downloadTask.listener;
            if (moduleDownloadListener != null) {
                moduleDownloadListener.onDownloadSucceed(downloadTask.moduleId);
                this.taskMap.remove(str);
                return;
            }
        }
        QLog.i(TAG, 1, "start download--" + downloadTask.moduleId + ",priority: " + downloadTask.priority + " ,startImmediately: " + downloadTask.startImmediately);
        downloadTask.startTimeStamp = System.nanoTime();
        this.mDownloader.download(str, moduleSavePath, downloadTask.priority, downloadTask.startImmediately, this.mDowndloadListener);
    }

    private void onHandleSuccess(String str) {
        String str2;
        DownloadTask downloadTask = this.taskMap.get(str);
        if (downloadTask != null) {
            String moduleSavePath = QzoneModuleConst.getModuleSavePath(this.mContext, downloadTask.record);
            QzoneModuleRecord qzoneModuleRecord = downloadTask.record;
            if (QLog.isDevelopLevel()) {
                QLog.d(TAG, 1, "download complete: " + moduleSavePath);
            }
            String str3 = qzoneModuleRecord.mMD5;
            if (!TextUtils.isEmpty(str3)) {
                str2 = MD5Utils.encodeFileHexStr(moduleSavePath);
            } else {
                str2 = "";
            }
            long nanoTime = (System.nanoTime() - downloadTask.startTimeStamp) / 1000000;
            if (!TextUtils.isEmpty(str3) && !str3.equalsIgnoreCase(str2)) {
                if (QLog.isDevelopLevel()) {
                    QLog.d(TAG, 1, "download complete-- orgMD5: " + str3 + " , downloadMD5: " + str2);
                }
                File file = new File(moduleSavePath);
                if (file.exists()) {
                    file.delete();
                }
                QLog.i(TAG, 1, "download failed: md5 verify is not passed.");
                ModuleDownloadListener moduleDownloadListener = downloadTask.listener;
                if (moduleDownloadListener != null) {
                    moduleDownloadListener.onDownloadFailed(downloadTask.moduleId);
                }
                QzoneModuleReport.reportDownloadRes(qzoneModuleRecord, false, nanoTime);
            } else {
                QzoneModuleConfigManager.getInstance().updateConfigAfterDownloaded(qzoneModuleRecord);
                try {
                    if (QzoneModuleConst.QZONE_MODULES_NEED_INSTALL.contains(qzoneModuleRecord.mModuleId)) {
                        new DexClassLoader(moduleSavePath, this.mContext.getApplicationContext().getDir("dex", 0).getAbsolutePath(), moduleSavePath, this.mContext.getApplicationContext().getClassLoader());
                    }
                } catch (Throwable th5) {
                    QLog.e(TAG, 1, "after download,new DexClassLoader error: ", th5);
                }
                ModuleDownloadListener moduleDownloadListener2 = downloadTask.listener;
                if (moduleDownloadListener2 != null) {
                    moduleDownloadListener2.onDownloadSucceed(downloadTask.moduleId);
                }
                QzoneModuleReport.reportDownloadRes(qzoneModuleRecord, true, nanoTime);
            }
        }
        this.taskMap.remove(str);
    }

    public void abortDownloadModule(String str) {
        DownloadTask downloadTask;
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null || !this.taskMap.containsKey(moduleRecord.mUrl) || (downloadTask = this.taskMap.get(moduleRecord.mUrl)) == null) {
            return;
        }
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 7;
        obtain.obj = downloadTask;
        obtain.sendToTarget();
    }

    public void cancelDownloadModule(String str) {
        DownloadTask downloadTask;
        QzoneModuleRecord moduleRecord = QzoneModuleConfigManager.getInstance().getModuleRecord(str);
        if (moduleRecord == null || !this.taskMap.containsKey(moduleRecord.mUrl) || (downloadTask = this.taskMap.get(moduleRecord.mUrl)) == null) {
            return;
        }
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 4;
        obtain.obj = downloadTask;
        obtain.sendToTarget();
    }

    public boolean downloadModule(QzoneModuleRecord qzoneModuleRecord, ModuleDownloadListener moduleDownloadListener) {
        return downloadModule(qzoneModuleRecord, false, moduleDownloadListener);
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        switch (message.what) {
            case 1:
                onHandleDownload((DownloadTask) message.obj);
                return true;
            case 2:
                onHandleSuccess((String) message.obj);
                return true;
            case 3:
                String str = (String) message.obj;
                DownloadTask downloadTask = this.taskMap.get(str);
                if (downloadTask != null) {
                    QLog.e(TAG, 1, "download failed: " + downloadTask.moduleId);
                    ModuleDownloadListener moduleDownloadListener = downloadTask.listener;
                    if (moduleDownloadListener != null) {
                        moduleDownloadListener.onDownloadFailed(downloadTask.moduleId);
                    }
                    QzoneModuleReport.reportDownloadRes(downloadTask.record, false, (System.nanoTime() - downloadTask.startTimeStamp) / 1000000);
                }
                this.taskMap.remove(str);
                return true;
            case 4:
                DownloadTask downloadTask2 = (DownloadTask) message.obj;
                QLog.w(TAG, 1, "cancel download: " + downloadTask2.moduleId);
                this.mDownloader.cancel(downloadTask2.record.mUrl, this.mDowndloadListener);
                return true;
            case 5:
                String str2 = (String) message.obj;
                DownloadTask downloadTask3 = this.taskMap.get(str2);
                if (downloadTask3 != null) {
                    QLog.w(TAG, 1, "download canceled: " + downloadTask3.moduleId);
                    ModuleDownloadListener moduleDownloadListener2 = downloadTask3.listener;
                    if (moduleDownloadListener2 != null) {
                        moduleDownloadListener2.onDownloadCanceled(downloadTask3.moduleId);
                    }
                }
                this.taskMap.remove(str2);
                return true;
            case 6:
                DownloadTask downloadTask4 = (DownloadTask) message.obj;
                if (downloadTask4 == null || downloadTask4.listener == null) {
                    return true;
                }
                downloadTask4.listener.onDownloadProgress(downloadTask4.moduleId, ((Float) downloadTask4.obj).floatValue());
                return true;
            case 7:
                DownloadTask downloadTask5 = (DownloadTask) message.obj;
                QLog.w(TAG, 1, "abort download: " + downloadTask5.moduleId);
                this.mDownloader.abort(downloadTask5.record.mUrl, this.mDowndloadListener);
                return true;
            default:
                return false;
        }
    }

    public boolean downloadModule(QzoneModuleRecord qzoneModuleRecord, boolean z16, ModuleDownloadListener moduleDownloadListener) {
        return downloadModule(qzoneModuleRecord, z16, false, moduleDownloadListener);
    }

    public boolean downloadModule(QzoneModuleRecord qzoneModuleRecord, boolean z16, boolean z17, ModuleDownloadListener moduleDownloadListener) {
        if (qzoneModuleRecord == null) {
            return false;
        }
        DownloadTask downloadTask = new DownloadTask();
        downloadTask.moduleId = qzoneModuleRecord.mModuleId;
        downloadTask.record = qzoneModuleRecord;
        downloadTask.listener = moduleDownloadListener;
        downloadTask.priority = z16;
        downloadTask.startImmediately = z17;
        Message obtain = Message.obtain(this.mHandler);
        obtain.what = 1;
        obtain.obj = downloadTask;
        obtain.sendToTarget();
        return true;
    }
}
