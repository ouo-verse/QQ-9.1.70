package com.tencent.upload.image;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageCompressManager {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ImageCompressManager";
    private static volatile ImageCompressManager sManager;
    private ExecutorService mExecutorService;
    private final LinkedBlockingQueue<ImageCompressRecord> mPendingRecords;
    private ImageCompressorCallback mProcessCallback;
    private final SparseArray<ImageCompressRecord> mRecordMap;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface ImageCompressorCallback {
        void onCompressFinish(int i3, String str, String str2);
    }

    ImageCompressManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mPendingRecords = new LinkedBlockingQueue<>();
            this.mRecordMap = new SparseArray<>();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void finishTask(int i3) {
        UploadLog.d(TAG, "finishTask , flowId=" + i3);
        ImageCompressRecord imageCompressRecord = this.mRecordMap.get(i3);
        this.mRecordMap.remove(i3);
        this.mPendingRecords.remove(imageCompressRecord);
    }

    private ExecutorService getExecutorService() {
        ExecutorService executorService = this.mExecutorService;
        if (executorService == null || executorService.isShutdown()) {
            this.mExecutorService = ProxyExecutors.newSingleThreadExecutor();
        }
        return this.mExecutorService;
    }

    public static ImageCompressManager getInstance() {
        if (sManager == null) {
            synchronized (ImageCompressManager.class) {
                if (sManager == null) {
                    sManager = new ImageCompressManager();
                }
            }
        }
        return sManager;
    }

    private void next() {
        getExecutorService().submit(new Runnable(new int[]{0}) { // from class: com.tencent.upload.image.ImageCompressManager.3
            static IPatchRedirector $redirector_;
            final /* synthetic */ int[] val$nextTaskId;

            {
                this.val$nextTaskId = r5;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageCompressManager.this, (Object) r5);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                    iPatchRedirector.redirect((short) 2, (Object) this);
                    return;
                }
                UploadLog.d(ImageCompressManager.TAG, "next() , taskCount = " + ImageCompressManager.this.mPendingRecords.size());
                ImageCompressRecord imageCompressRecord = (ImageCompressRecord) ImageCompressManager.this.mPendingRecords.peek();
                if (imageCompressRecord != null) {
                    this.val$nextTaskId[0] = imageCompressRecord.flowId;
                    ImageCompressManager.this.runCompressFileTask(imageCompressRecord);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runCompressFileTask(ImageCompressRecord imageCompressRecord) {
        boolean z16;
        UploadLog.d(TAG, "runCompressFileTask  task = " + imageCompressRecord);
        if (imageCompressRecord == null) {
            return;
        }
        String tempFilePath = FileUtils.getTempFilePath(UploadGlobalConfig.getContext(), imageCompressRecord.path, imageCompressRecord.md5, imageCompressRecord.flowId);
        UploadLog.d(TAG, "runCompressFileTask  targetFile:" + tempFilePath);
        if (!FileUtils.isFileExist(tempFilePath)) {
            UploadLog.d(TAG, "runCompressFileTask  targetFilePath not exist begin compress");
            if (UploadGlobalConfig.getConfig() != null && UploadGlobalConfig.getConfig().useNewCopyExif()) {
                z16 = true;
            } else {
                z16 = false;
            }
            boolean z17 = z16;
            String str = imageCompressRecord.path;
            IUploadConfig.UploadImageSize uploadImageSize = imageCompressRecord.mSize;
            tempFilePath = ImageProcessUtil.compressFile(str, tempFilePath, uploadImageSize.width, uploadImageSize.height, uploadImageSize.quality, imageCompressRecord.autoRotate, imageCompressRecord.compressToWebp, z17);
        } else {
            UploadLog.d(TAG, "runCompressFileTask  compressFile exist no need compress");
        }
        UploadLog.d(TAG, "runCompressFileTask  compressFile end. targetFile=" + tempFilePath);
        String str2 = imageCompressRecord.path;
        if (TextUtils.isEmpty(tempFilePath) || !new File(tempFilePath).exists()) {
            tempFilePath = str2;
        }
        String str3 = "imageCompressCode=" + ImageProcessService.MILESTONE.getMilestoneValue() + " errorMsg=" + ImageProcessService.sMsg;
        UploadLog.d(TAG, "runCompressFileTask " + str3);
        finishTask(imageCompressRecord.flowId);
        ImageCompressorCallback imageCompressorCallback = this.mProcessCallback;
        if (imageCompressorCallback != null) {
            imageCompressorCallback.onCompressFinish(imageCompressRecord.flowId, tempFilePath, str3);
        }
        next();
    }

    public void cancel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            getExecutorService().submit(new Runnable(i3) { // from class: com.tencent.upload.image.ImageCompressManager.1
                static IPatchRedirector $redirector_;
                final /* synthetic */ int val$taskId;

                {
                    this.val$taskId = i3;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageCompressManager.this, i3);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    UploadLog.i(ImageCompressManager.TAG, "cancel , taskId=" + this.val$taskId);
                    ImageCompressRecord imageCompressRecord = (ImageCompressRecord) ImageCompressManager.this.mRecordMap.get(this.val$taskId);
                    if (imageCompressRecord != null) {
                        ImageCompressManager.this.finishTask(imageCompressRecord.flowId);
                    }
                }
            });
            next();
        }
    }

    public void compressFile(ImageCompressRecord imageCompressRecord, ImageCompressorCallback imageCompressorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) imageCompressRecord, (Object) imageCompressorCallback);
        } else {
            getExecutorService().submit(new Runnable(imageCompressRecord, imageCompressorCallback) { // from class: com.tencent.upload.image.ImageCompressManager.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ ImageCompressorCallback val$callback;
                final /* synthetic */ ImageCompressRecord val$t;

                {
                    this.val$t = imageCompressRecord;
                    this.val$callback = imageCompressorCallback;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, ImageCompressManager.this, imageCompressRecord, imageCompressorCallback);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (this.val$t == null) {
                        UploadLog.e(ImageCompressManager.TAG, "compressFile t == null");
                        return;
                    }
                    UploadLog.i(ImageCompressManager.TAG, "compressFile , taskId=" + this.val$t.flowId);
                    ImageCompressManager.this.mProcessCallback = this.val$callback;
                    if (ImageCompressManager.this.mRecordMap.get(this.val$t.flowId) == null) {
                        ImageCompressManager.this.mPendingRecords.add(this.val$t);
                        SparseArray sparseArray = ImageCompressManager.this.mRecordMap;
                        ImageCompressRecord imageCompressRecord2 = this.val$t;
                        sparseArray.put(imageCompressRecord2.flowId, imageCompressRecord2);
                        return;
                    }
                    UploadLog.i(ImageCompressManager.TAG, "mRecordMap has added task :" + this.val$t.flowId);
                }
            });
            next();
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        UploadLog.d(TAG, "release");
        this.mPendingRecords.clear();
        this.mRecordMap.clear();
        ExecutorService executorService = this.mExecutorService;
        if (executorService != null) {
            executorService.shutdown();
        }
    }
}
