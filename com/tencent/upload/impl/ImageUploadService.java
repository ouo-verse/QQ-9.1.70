package com.tencent.upload.impl;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.upload.common.UploadConfiguration;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.image.ImageCompressManager;
import com.tencent.upload.image.ImageCompressRecord;
import com.tencent.upload.image.ImageProcessProxy;
import com.tencent.upload.uinterface.AbstractUploadTask;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.uinterface.TaskTypeConfig;
import com.tencent.upload.uinterface.Utility;
import com.tencent.upload.uinterface.data.BatchControlTask;
import com.tencent.upload.uinterface.data.ImageUploadTask;
import com.tencent.upload.utils.Const;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import com.tencent.upload.utils.pool.ThreadPool;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: P */
/* loaded from: classes27.dex */
public class ImageUploadService extends BaseUploadService {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ImageUploadService";
    private static final int WHAT_START_ASYNC_SEND = 1000;
    private static final AtomicInteger sBatchIdGenerator;
    private int mCompressServicePid;
    private ImageProcessProxy mCompressServiceProxy;
    private SparseArray<AbstractUploadTask> mCompressingTasks;
    ImageCompressManager.ImageCompressorCallback mCompressorCallback;
    private Handler mHandler;
    ImageProcessProxy.ImageCompressorCallback mImageProcessorCallback;
    private CopyOnWriteArrayList<AbstractUploadTask> mReadyTasks;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10770);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
        } else {
            sBatchIdGenerator = new AtomicInteger(10000);
        }
    }

    public ImageUploadService(ThreadPool threadPool) {
        super(threadPool);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) threadPool);
            return;
        }
        this.mCompressServicePid = 0;
        this.mCompressorCallback = new ImageCompressManager.ImageCompressorCallback() { // from class: com.tencent.upload.impl.ImageUploadService.2
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageUploadService.this);
                }
            }

            @Override // com.tencent.upload.image.ImageCompressManager.ImageCompressorCallback
            public void onCompressFinish(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                } else {
                    ImageUploadService.this.mHandler.post(new Runnable(i3, str, str2) { // from class: com.tencent.upload.impl.ImageUploadService.2.1
                        static IPatchRedirector $redirector_;
                        final /* synthetic */ int val$flowId;
                        final /* synthetic */ String val$reportMsg;
                        final /* synthetic */ String val$targetFilePath;

                        {
                            this.val$flowId = i3;
                            this.val$targetFilePath = str;
                            this.val$reportMsg = str2;
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 != null && iPatchRedirector3.hasPatch((short) 1)) {
                                iPatchRedirector3.redirect((short) 1, this, AnonymousClass2.this, Integer.valueOf(i3), str, str2);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector3 = $redirector_;
                            if (iPatchRedirector3 == null || !iPatchRedirector3.hasPatch((short) 2)) {
                                ImageUploadService.this.handleImageCompressFinish(this.val$flowId, this.val$targetFilePath, this.val$reportMsg);
                            } else {
                                iPatchRedirector3.redirect((short) 2, (Object) this);
                            }
                        }
                    });
                }
            }
        };
        this.mImageProcessorCallback = new ImageProcessProxy.ImageCompressorCallback() { // from class: com.tencent.upload.impl.ImageUploadService.3
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageUploadService.this);
                }
            }

            @Override // com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback
            public void onCompressFinish(int i3, String str, String str2) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    ImageUploadService.this.handleImageCompressFinish(i3, str, str2);
                } else {
                    iPatchRedirector2.redirect((short) 2, this, Integer.valueOf(i3), str, str2);
                }
            }

            @Override // com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback
            public void onPidObtained(int i3) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 4)) {
                    ImageUploadService.this.mCompressServicePid = i3;
                    UploadLog.d(ImageUploadService.TAG, "ImageProcessProxy Service return Pid: " + i3);
                    return;
                }
                iPatchRedirector2.redirect((short) 4, (Object) this, i3);
            }

            @Override // com.tencent.upload.image.ImageProcessProxy.ImageCompressorCallback
            public void onServiceConnected() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this);
                } else {
                    UploadLog.d(ImageUploadService.TAG, "ImageProcessProxy Service Connectted!");
                }
            }
        };
        this.mTaskManager = new UploadTaskManager(threadPool, BaseUploadService.getParallelFileNumber());
        this.mCompressingTasks = new SparseArray<>();
        this.mReadyTasks = new CopyOnWriteArrayList<>();
        this.mCompressServiceProxy = ImageProcessProxy.getInstance();
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("image-upload-service");
        baseHandlerThread.start();
        this.mHandler = new Handler(baseHandlerThread.getLooper());
    }

    private boolean compressUploadTask(AbstractUploadTask abstractUploadTask) {
        int i3;
        boolean z16;
        String filePath = abstractUploadTask.getFilePath();
        if (!TextUtils.isEmpty(filePath) && new File(filePath).exists()) {
            if (ImageCompressor.isGifPicture(filePath)) {
                ImageCompressor.processGif(abstractUploadTask);
                this.mTaskManager.sendAsync(abstractUploadTask);
                return false;
            }
            boolean z17 = abstractUploadTask instanceof ImageUploadTask;
            if (z17) {
                ImageUploadTask imageUploadTask = (ImageUploadTask) abstractUploadTask;
                boolean z18 = imageUploadTask.autoRotate;
                i3 = imageUploadTask.iUploadType;
                z16 = z18;
            } else {
                i3 = 0;
                z16 = false;
            }
            IUploadConfig.UploadImageSize uploadImageSize = ImageCompressor.getUploadImageSize(abstractUploadTask, i3);
            if (uploadImageSize == null) {
                return false;
            }
            abstractUploadTask.mTargetSize = uploadImageSize;
            abstractUploadTask.md5 = FileUtils.getMd5ByFile_REAL(new File(filePath));
            TaskTypeConfig mTaskTypeConfig = abstractUploadTask.getMTaskTypeConfig();
            boolean z19 = (mTaskTypeConfig != null && mTaskTypeConfig.uploadType == 0) && Utility.needCompress2Webp(UploadGlobalConfig.getConfig().getCompressToWebpFlag(), i3);
            if (z17) {
                ((ImageUploadTask) abstractUploadTask).compressStartTime = System.currentTimeMillis();
            }
            this.mCompressingTasks.append(abstractUploadTask.flowId, abstractUploadTask);
            UploadLog.d(TAG, "compressUploadTask  flowId: " + abstractUploadTask.flowId + ", add task to mCompressingTasks");
            return compressUploadTask(abstractUploadTask.flowId, abstractUploadTask.getFilePath(), abstractUploadTask.getMd5(), uploadImageSize, z16, z19);
        }
        Const.UploadRetCode uploadRetCode = Const.UploadRetCode.FILE_NOT_EXIST;
        abstractUploadTask.onError(uploadRetCode.getCode(), uploadRetCode.getDesc());
        UploadLog.e(TAG, "upload error path invalid !");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized boolean driveNextBatch() {
        UploadLog.d(TAG, "driveNext -- ");
        if (this.mReadyTasks.size() <= 0) {
            return false;
        }
        int batchControlNumber = BaseUploadService.getBatchControlNumber();
        UploadLog.d(TAG, "ready:" + this.mReadyTasks.size() + " compressing:" + this.mCompressingTasks.size() + " batchMaxNum:" + batchControlNumber);
        ArrayList<AbstractUploadTask> arrayList = new ArrayList();
        if (this.mReadyTasks.size() >= batchControlNumber) {
            for (int i3 = 0; i3 < batchControlNumber; i3++) {
                arrayList.add(this.mReadyTasks.get(i3));
            }
        } else {
            arrayList.addAll(this.mReadyTasks);
        }
        this.mReadyTasks.removeAll(arrayList);
        int incrementAndGet = sBatchIdGenerator.incrementAndGet();
        for (AbstractUploadTask abstractUploadTask : arrayList) {
            if (abstractUploadTask != null) {
                abstractUploadTask.setBatchId(incrementAndGet);
            }
        }
        BatchControlTask batchControlTask = new BatchControlTask(arrayList, this.mTaskManager);
        batchControlTask.setBatchId(incrementAndGet);
        this.mTaskManager.sendAsync(batchControlTask);
        UploadLog.d(TAG, "driveNext end -- send taskId:" + batchControlTask.getTaskId() + " batchId:" + incrementAndGet + " contain:" + batchControlTask.printAllTaskInBatchControl());
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleImageCompressFinish(int i3, String str, String str2) {
        AbstractUploadTask abstractUploadTask = this.mCompressingTasks.get(i3);
        UploadLog.d(TAG, "onCompressFinish task = " + abstractUploadTask);
        if (abstractUploadTask != null) {
            if (abstractUploadTask instanceof ImageUploadTask) {
                ((ImageUploadTask) abstractUploadTask).compressEndTime = System.currentTimeMillis();
            }
            UploadLog.d(TAG, "Image compress complete,  originPath: " + abstractUploadTask.getFilePath() + " tmpPath: " + str + " reportMsg: " + str2);
            if (TextUtils.isEmpty(str)) {
                UploadLog.d(TAG, "targetFilePath is empty !");
                str = abstractUploadTask.getFilePath();
            } else {
                File file = new File(str);
                if (!file.exists()) {
                    UploadLog.d(TAG, "targetFilePath file invalid !");
                    str = abstractUploadTask.getFilePath();
                } else if (file.length() <= 0) {
                    UploadLog.d(TAG, "targetFilePath file size == 0 !");
                    str = abstractUploadTask.getFilePath();
                }
            }
            abstractUploadTask.setTmpFilePath(str);
            UploadLog.d(TAG, "taskId:" + abstractUploadTask.flowId + ", final upload targetFilePath:" + str);
            if (abstractUploadTask.needWaitBatch()) {
                this.mCompressingTasks.remove(i3);
                this.mReadyTasks.add(abstractUploadTask);
                if (this.mReadyTasks.size() >= BaseUploadService.getBatchControlNumber() || this.mCompressingTasks.size() == 0) {
                    driveNextBatch();
                    return;
                }
                return;
            }
            this.mTaskManager.sendAsync(abstractUploadTask);
            this.mCompressingTasks.remove(i3);
        }
    }

    private boolean isUseNewPicCompressStrategy() {
        boolean isSwitchOn = UploadGlobalConfig.getConfig().isSwitchOn(Const.SwitchConfigKey.UPLOAD_PIC_COMPRESS_USE_NEW_STRATEGY);
        UploadLog.d(TAG, "isUseNewPicCompressStrategy isUseNewPicCompress: " + isSwitchOn);
        return isSwitchOn;
    }

    private void sendTask(AbstractUploadTask abstractUploadTask) {
        if (abstractUploadTask instanceof ImageUploadTask) {
            UploadLog.w(TAG, "sendTask add task to queue: " + abstractUploadTask.flowId);
            this.mHandler.removeMessages(1000);
            this.mReadyTasks.add(abstractUploadTask);
            Message obtain = Message.obtain(this.mHandler, new Runnable() { // from class: com.tencent.upload.impl.ImageUploadService.1
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                        iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageUploadService.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector = $redirector_;
                    if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                        iPatchRedirector.redirect((short) 2, (Object) this);
                        return;
                    }
                    boolean z16 = true;
                    while (z16) {
                        z16 = ImageUploadService.this.driveNextBatch();
                    }
                }
            });
            obtain.what = 1000;
            this.mHandler.sendMessageDelayed(obtain, 100L);
            return;
        }
        this.mTaskManager.sendAsync(abstractUploadTask);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cc  */
    @Override // com.tencent.upload.impl.BaseUploadService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean cancel(AbstractUploadTask abstractUploadTask) {
        AbstractUploadTask abstractUploadTask2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        boolean z16 = false;
        if (abstractUploadTask == null) {
            return false;
        }
        UploadLog.w(TAG, "cancel task flowId: " + abstractUploadTask.flowId + ", path:" + abstractUploadTask.uploadFilePath);
        if (this.mCompressingTasks.get(abstractUploadTask.flowId) != null) {
            if (isUseNewPicCompressStrategy()) {
                ImageCompressManager.getInstance().cancel(abstractUploadTask.flowId);
            } else {
                this.mCompressServiceProxy.cancel(abstractUploadTask.flowId);
            }
            this.mCompressingTasks.remove(abstractUploadTask.flowId);
            UploadLog.w(TAG, "cancel task from compress queue! flowId:" + abstractUploadTask.flowId + ", path:" + abstractUploadTask.uploadFilePath);
        } else {
            Iterator<AbstractUploadTask> it = this.mReadyTasks.iterator();
            while (true) {
                if (it.hasNext()) {
                    abstractUploadTask2 = it.next();
                    if (abstractUploadTask2.flowId == abstractUploadTask.flowId) {
                        break;
                    }
                } else {
                    abstractUploadTask2 = null;
                    break;
                }
            }
            if (abstractUploadTask2 != null) {
                this.mReadyTasks.remove(abstractUploadTask2);
                UploadLog.w(TAG, "cancel task from ready queue! flowId:" + abstractUploadTask.flowId + ", path:" + abstractUploadTask.uploadFilePath);
            }
            if (!z16) {
                this.mTaskManager.cancelTask(abstractUploadTask);
            }
            driveNextBatch();
            return true;
        }
        z16 = true;
        if (!z16) {
        }
        driveNextBatch();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public void cancelAllTasks() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        this.mTaskManager.cancelAllTasks();
        this.mCompressingTasks.clear();
        this.mReadyTasks.clear();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public void close() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        UploadLog.d(TAG, "close()  | mReadyTasks.size = " + this.mReadyTasks.size() + " | mCompressingTasks.size = " + this.mCompressingTasks.size());
        this.mTaskManager.close();
        if (isUseNewPicCompressStrategy()) {
            ImageCompressManager.getInstance().release();
        } else {
            closeCompressProcess();
        }
    }

    public void closeCompressProcess() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (this.mCompressServicePid == 0) {
            return;
        }
        if (isUploadIdle()) {
            ImageProcessProxy.close();
            SystemMethodProxy.killProcess(this.mCompressServicePid);
            UploadLog.d(TAG, "kill compress process Pid:" + this.mCompressServicePid);
            this.mCompressServicePid = 0;
            return;
        }
        UploadLog.w(TAG, "closeCompressProcess... isUploadIdle:false");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public boolean isUploadIdle() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.mCompressingTasks.size() == 0 && this.mTaskManager.getRemainTaskSize() == 0 && this.mReadyTasks.size() == 0) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.upload.impl.BaseUploadService
    public boolean upload(AbstractUploadTask abstractUploadTask) {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) abstractUploadTask)).booleanValue();
        }
        if (abstractUploadTask == null) {
            UploadLog.e(TAG, "upload task == null !");
            return false;
        }
        UploadLog.w(TAG, "upload task flowId: " + abstractUploadTask.flowId + " type:" + abstractUploadTask.getClass().getSimpleName());
        abstractUploadTask.onUploadProcessStart();
        if (abstractUploadTask instanceof ImageUploadTask) {
            if (((ImageUploadTask) abstractUploadTask).iUploadType != 3) {
                z16 = true;
            } else {
                z16 = false;
            }
            abstractUploadTask.keepTmpFile(UploadGlobalConfig.needKeepImageTmpFile());
        } else {
            z16 = false;
        }
        synchronized (this.mCompressingTasks) {
            if (z16) {
                if (UploadConfiguration.isPictureNeedToCompress(abstractUploadTask.getFilePath())) {
                    if (compressUploadTask(abstractUploadTask)) {
                        abstractUploadTask.needCompress = true;
                    } else {
                        abstractUploadTask.needCompress = false;
                        UploadLog.w(TAG, "upload task: " + abstractUploadTask.flowId + " compressUploadTask == false");
                    }
                    return true;
                }
            }
            abstractUploadTask.needCompress = false;
            UploadLog.w(TAG, "upload task: " + abstractUploadTask.flowId + " is not need compress | needCompress:" + z16);
            sendTask(abstractUploadTask);
            return true;
        }
    }

    private final boolean compressUploadTask(int i3, String str, String str2, IUploadConfig.UploadImageSize uploadImageSize, boolean z16, boolean z17) {
        UploadLog.d(TAG, "compressUploadTask[flowId: " + i3 + ", path: " + str + ", md5: " + str2 + ", targetSize: " + uploadImageSize + ", autoRotate: " + z16 + ", compressToWebp: " + z17 + "]");
        ImageCompressRecord imageCompressRecord = new ImageCompressRecord(i3, str, str2, uploadImageSize, z16, z17);
        if (isUseNewPicCompressStrategy()) {
            ImageCompressManager.getInstance().compressFile(imageCompressRecord, this.mCompressorCallback);
            return true;
        }
        this.mCompressServiceProxy.compressFile(imageCompressRecord, this.mImageProcessorCallback);
        return true;
    }
}
