package com.tencent.mobileqq.qqlive.api.impl.upload;

import android.graphics.Bitmap;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask;
import com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload;
import com.tencent.mobileqq.qqlive.callback.upload.IQQLiveUploadBitmapCallback;
import com.tencent.mobileqq.qqlive.data.common.QQLiveError;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapParams;
import com.tencent.mobileqq.qqlive.data.upload.QQLiveUploadBitmapResult;
import com.tencent.mobileqq.winkpublish.TaskInfo;
import com.tencent.mobileqq.winkpublish.WinkPublishHelper2;
import com.tencent.mobileqq.winkpublish.WinkPublishServiceProxy2;
import com.tencent.mobileqq.winkpublish.api.ITaskListener;
import com.tencent.mobileqq.winkpublish.model.params.ImageParams;
import com.tencent.mobileqq.winkpublish.model.params.WinkPublishParams;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qqlive.common.api.AegisLogger;
import cooperation.qqcircle.report.QCirclePublishQualityReporter;
import java.io.File;
import java.util.ArrayList;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveModuleFileUploadImpl implements IQQLiveModuleFileUpload {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "Open_Live|QQLiveModuleFileUploadImpl";
    private File appCacheFile;
    private ConcurrentHashMap<Integer, QQLiveUploadBitmapParams> doingTask;
    private boolean isDestroyed;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class QQLiveFileOnStorePhotoCallback implements StoreFileTask.OnStorePhotoCallback {
        static IPatchRedirector $redirector_;
        private int bitmapHashCode;
        private IQQLiveUploadBitmapCallback callback;
        private ITaskListener.Stub mUploadCallback;
        private QQLiveUploadBitmapParams params;
        private WinkPublishServiceProxy2 winkPublishService;
        private TaskInfo winkTaskInfo;

        public QQLiveFileOnStorePhotoCallback(int i3, QQLiveUploadBitmapParams qQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback iQQLiveUploadBitmapCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, QQLiveModuleFileUploadImpl.this, Integer.valueOf(i3), qQLiveUploadBitmapParams, iQQLiveUploadBitmapCallback);
                return;
            }
            this.winkPublishService = null;
            this.mUploadCallback = new ITaskListener.Stub() { // from class: com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl.QQLiveFileOnStorePhotoCallback.2
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFileOnStorePhotoCallback.this);
                    }
                }

                private void removeCallback() {
                    QQLiveModuleFileUploadImpl.this.doingTask.remove(Integer.valueOf(QQLiveFileOnStorePhotoCallback.this.bitmapHashCode));
                    QQLiveFileOnStorePhotoCallback.this.winkPublishService.removeTaskListener(QQLiveFileOnStorePhotoCallback.this.mUploadCallback);
                    QQLiveFileOnStorePhotoCallback.this.winkPublishService = null;
                }

                @Override // com.tencent.mobileqq.winkpublish.api.ITaskListener
                public void onTaskChange(TaskInfo taskInfo) throws RemoteException {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) taskInfo);
                        return;
                    }
                    AegisLogger.d(QQLiveModuleFileUploadImpl.TAG, "onTaskChange", "taskInfo:" + taskInfo);
                    if (QQLiveFileOnStorePhotoCallback.this.winkTaskInfo != null && taskInfo != null && QQLiveFileOnStorePhotoCallback.this.winkTaskInfo.getTaskId() == taskInfo.getTaskId()) {
                        if (taskInfo.isFinish() && taskInfo.getMediaInfos().size() > 0 && (taskInfo.getMediaInfos().get(0).getUploadResult() instanceof ImageResult)) {
                            QQLiveUploadBitmapResult qQLiveUploadBitmapResult = new QQLiveUploadBitmapResult(0, true, "");
                            qQLiveUploadBitmapResult.reqParams = QQLiveFileOnStorePhotoCallback.this.params;
                            qQLiveUploadBitmapResult.url = ((ImageResult) taskInfo.getMediaInfos().get(0).getUploadResult()).getOriginUrl();
                            if (QQLiveFileOnStorePhotoCallback.this.callback != null) {
                                QQLiveFileOnStorePhotoCallback.this.callback.onUploadResult(qQLiveUploadBitmapResult);
                            }
                            removeCallback();
                            return;
                        }
                        if (taskInfo.isCancelled()) {
                            QQLiveFileOnStorePhotoCallback qQLiveFileOnStorePhotoCallback = QQLiveFileOnStorePhotoCallback.this;
                            QQLiveModuleFileUploadImpl.this.errorCallback(qQLiveFileOnStorePhotoCallback.bitmapHashCode, "onTaskChange result code failed:" + taskInfo.getErrCode(), QQLiveFileOnStorePhotoCallback.this.callback);
                            removeCallback();
                        }
                    }
                }
            };
            this.bitmapHashCode = i3;
            this.callback = iQQLiveUploadBitmapCallback;
            this.params = qQLiveUploadBitmapParams;
        }

        @Override // com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.OnStorePhotoCallback
        public void onFail(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
                return;
            }
            QQLiveModuleFileUploadImpl.this.errorCallback(this.bitmapHashCode, "store failed:" + str, this.callback);
        }

        @Override // com.tencent.mobileqq.qqlive.api.impl.upload.bitmap.StoreFileTask.OnStorePhotoCallback
        public void onSuccess(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
                return;
            }
            AegisLogger.i(QQLiveModuleFileUploadImpl.TAG, "onSuccess", "store success:" + str);
            if (QQLiveModuleFileUploadImpl.this.isDestroyed) {
                QQLiveModuleFileUploadImpl.this.errorCallback(this.bitmapHashCode, "stored, module destroyed", this.callback);
            } else {
                WinkPublishHelper2.INSTANCE.bindService(10, new WinkPublishHelper2.Callback(str) { // from class: com.tencent.mobileqq.qqlive.api.impl.upload.QQLiveModuleFileUploadImpl.QQLiveFileOnStorePhotoCallback.1
                    static IPatchRedirector $redirector_;
                    final /* synthetic */ String val$photoPath;

                    {
                        this.val$photoPath = str;
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQLiveFileOnStorePhotoCallback.this, (Object) str);
                        }
                    }

                    @Override // com.tencent.mobileqq.winkpublish.WinkPublishHelper2.Callback
                    public void onServiceConnected(@NotNull WinkPublishServiceProxy2 winkPublishServiceProxy2) {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                            QQLiveFileOnStorePhotoCallback.this.winkPublishService = winkPublishServiceProxy2;
                            QQLiveFileOnStorePhotoCallback.this.winkPublishService.addTaskListener2(QQLiveFileOnStorePhotoCallback.this.mUploadCallback);
                            ImageParams imageParams = new ImageParams(this.val$photoPath, 3, 0, 0, 0L, 0, 0, 0L, "", null);
                            ArrayList arrayList = new ArrayList();
                            arrayList.add(imageParams);
                            WinkPublishParams winkPublishParams = new WinkPublishParams(10, UUID.randomUUID().toString(), QCirclePublishQualityReporter.getTraceId(), true, 23, arrayList, null, null, null, null);
                            QQLiveFileOnStorePhotoCallback.this.winkTaskInfo = WinkPublishHelper2.INSTANCE.getService(10).addTask(winkPublishParams);
                            return;
                        }
                        iPatchRedirector2.redirect((short) 2, (Object) this, (Object) winkPublishServiceProxy2);
                    }
                });
            }
        }
    }

    public QQLiveModuleFileUploadImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.doingTask = new ConcurrentHashMap<>();
            this.isDestroyed = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void errorCallback(int i3, String str, IQQLiveUploadBitmapCallback iQQLiveUploadBitmapCallback) {
        if (iQQLiveUploadBitmapCallback != null) {
            iQQLiveUploadBitmapCallback.onUploadResult(new QQLiveUploadBitmapResult(QQLiveError.UPLOAD_BITMAP_FAILED, false, str));
            if (i3 != -1) {
                this.doingTask.remove(Integer.valueOf(i3));
            }
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.isDestroyed = true;
        this.doingTask.clear();
        this.appCacheFile = null;
    }

    public String getTargetPath(int i3, QQLiveUploadBitmapParams qQLiveUploadBitmapParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) qQLiveUploadBitmapParams);
        }
        if (this.appCacheFile == null) {
            return null;
        }
        return new File(this.appCacheFile, "qqlive_" + i3 + "_" + qQLiveUploadBitmapParams.format + ".jpg").getAbsolutePath();
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void init(IQQLiveSDK iQQLiveSDK) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iQQLiveSDK);
            return;
        }
        try {
            this.appCacheFile = iQQLiveSDK.getAppRuntime().getApp().getCacheDir();
        } catch (Throwable th5) {
            AegisLogger.e(TAG, "init", "getCacheDir error, ", th5);
            this.appCacheFile = null;
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.IQQLiveModule
    public void reset() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqlive.api.upload.IQQLiveModuleFileUpload
    public void uploadBitmap(Bitmap bitmap, QQLiveUploadBitmapParams qQLiveUploadBitmapParams, IQQLiveUploadBitmapCallback iQQLiveUploadBitmapCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, bitmap, qQLiveUploadBitmapParams, iQQLiveUploadBitmapCallback);
            return;
        }
        if (bitmap != null && qQLiveUploadBitmapParams != null) {
            if (!TextUtils.isEmpty(qQLiveUploadBitmapParams.roomId) && !TextUtils.isEmpty(qQLiveUploadBitmapParams.format)) {
                int hashCode = bitmap.hashCode();
                QQLiveUploadBitmapParams qQLiveUploadBitmapParams2 = this.doingTask.get(Integer.valueOf(hashCode));
                if (qQLiveUploadBitmapParams2 != null && qQLiveUploadBitmapParams2.equals(qQLiveUploadBitmapParams)) {
                    errorCallback(-1, "already uploading...", iQQLiveUploadBitmapCallback);
                    return;
                }
                String targetPath = getTargetPath(hashCode, qQLiveUploadBitmapParams);
                if (TextUtils.isEmpty(targetPath)) {
                    errorCallback(-1, "targetPath is null or empty:" + targetPath, iQQLiveUploadBitmapCallback);
                    return;
                }
                this.doingTask.put(Integer.valueOf(hashCode), qQLiveUploadBitmapParams);
                new StoreFileTask(bitmap, targetPath).start(new QQLiveFileOnStorePhotoCallback(hashCode, qQLiveUploadBitmapParams, iQQLiveUploadBitmapCallback));
                return;
            }
            errorCallback(-1, "params invalid", iQQLiveUploadBitmapCallback);
            return;
        }
        errorCallback(-1, "check param null", iQQLiveUploadBitmapCallback);
    }
}
