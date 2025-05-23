package com.tencent.upload.image;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.upload.common.UploadGlobalConfig;
import com.tencent.upload.uinterface.IUploadConfig;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes27.dex */
public class ImageProcessProxy {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "ImageProcessProxy";
    private static volatile ImageProcessProxy sProxy = null;
    protected static final int sfWaitBindTime = 10000;
    volatile boolean mBound;
    private final ServiceConnection mConnection;
    private Context mContext;
    private final IncomingHandler mIncomingHandler;
    private byte[] mLock;
    private final Messenger mMessenger;
    private final LinkedBlockingQueue<ImageCompressRecord> mPendingRecords;
    ImageCompressorCallback mProcessCallback;
    private final SparseArray<ImageCompressRecord> mRecordMap;
    Messenger mService;
    private volatile boolean mServiceBusy;

    /* loaded from: classes27.dex */
    public interface ImageCompressorCallback {
        void onCompressFinish(int i3, String str, String str2);

        void onPidObtained(int i3);

        void onServiceConnected();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"HandlerLeak"})
    /* loaded from: classes27.dex */
    public class IncomingHandler extends Handler {
        static IPatchRedirector $redirector_;

        public IncomingHandler() {
            super(Looper.getMainLooper());
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) ImageProcessProxy.this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            String str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            switch (message.what) {
                case 100:
                    int i3 = message.arg1;
                    ImageCompressRecord imageCompressRecord = (ImageCompressRecord) ImageProcessProxy.this.mRecordMap.get(i3);
                    if (imageCompressRecord != null) {
                        str = "MSG_PROCESS_TIMEOUT timeout flowId:" + i3 + " path:" + imageCompressRecord.path;
                        ImageProcessProxy.this.finishTask(i3);
                        ImageCompressorCallback imageCompressorCallback = ImageProcessProxy.this.mProcessCallback;
                        if (imageCompressorCallback != null) {
                            imageCompressorCallback.onCompressFinish(i3, imageCompressRecord.path, "original path");
                        }
                    } else {
                        str = "MSG_PROCESS_TIMEOUT removed time out task flowId: " + i3;
                    }
                    UploadLog.v(ImageProcessProxy.TAG, str);
                    ImageProcessProxy.this.mServiceBusy = false;
                    ImageProcessProxy.this.next();
                    return;
                case 101:
                    UploadLog.v(ImageProcessProxy.TAG, "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST response flowId=" + message.arg1);
                    message.getData().setClassLoader(ImageProcessData.class.getClassLoader());
                    Parcelable parcelable = message.getData().getParcelable(ImageProcessService.KEY_MSG_COMPRESS);
                    String str3 = null;
                    if (parcelable instanceof ImageProcessData) {
                        ImageProcessData imageProcessData = (ImageProcessData) parcelable;
                        String str4 = imageProcessData.originalFilePath;
                        if (!TextUtils.isEmpty(imageProcessData.f383918msg)) {
                            UploadLog.d(ImageProcessProxy.TAG, imageProcessData.f383918msg);
                            str3 = imageProcessData.f383918msg;
                        }
                        str2 = str3;
                        str3 = str4;
                    } else {
                        str2 = null;
                    }
                    int i16 = message.arg1;
                    if (((ImageCompressRecord) ImageProcessProxy.this.mRecordMap.get(i16)) != null) {
                        removeMessages(100);
                        ImageProcessProxy.this.finishTask(message.arg1);
                        ImageProcessProxy.this.mServiceBusy = false;
                        ImageCompressorCallback imageCompressorCallback2 = ImageProcessProxy.this.mProcessCallback;
                        if (imageCompressorCallback2 != null) {
                            imageCompressorCallback2.onCompressFinish(i16, str3, str2);
                        }
                        ImageProcessProxy.this.next();
                        return;
                    }
                    UploadLog.v(ImageProcessProxy.TAG, "removed task flowId: " + i16);
                    return;
                case 102:
                    UploadLog.v(ImageProcessProxy.TAG, "receive MSG_OBTAIN_PID_RESPONSE pid:" + message.arg1);
                    ImageCompressorCallback imageCompressorCallback3 = ImageProcessProxy.this.mProcessCallback;
                    if (imageCompressorCallback3 != null) {
                        imageCompressorCallback3.onPidObtained(message.arg1);
                    }
                    ImageProcessProxy.this.next();
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    ImageProcessProxy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.mLock = new byte[0];
        IncomingHandler incomingHandler = new IncomingHandler();
        this.mIncomingHandler = incomingHandler;
        this.mMessenger = new Messenger(incomingHandler);
        this.mService = null;
        this.mServiceBusy = false;
        this.mConnection = new ServiceConnection() { // from class: com.tencent.upload.image.ImageProcessProxy.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ImageProcessProxy.this);
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this, (Object) componentName, (Object) iBinder);
                    return;
                }
                UploadLog.d(ImageProcessProxy.TAG, "onServiceConnected");
                ImageProcessProxy.this.mService = new Messenger(iBinder);
                ImageProcessProxy.this.mBound = true;
                Message obtain = Message.obtain((Handler) null, 2);
                obtain.replyTo = ImageProcessProxy.this.mMessenger;
                try {
                    Messenger messenger = ImageProcessProxy.this.mService;
                    if (messenger != null) {
                        messenger.send(obtain);
                    }
                } catch (Exception e16) {
                    UploadLog.w(ImageProcessProxy.TAG, "obtain pid", e16);
                }
                ImageCompressorCallback imageCompressorCallback = ImageProcessProxy.this.mProcessCallback;
                if (imageCompressorCallback != null) {
                    imageCompressorCallback.onServiceConnected();
                }
                synchronized (ImageProcessProxy.this.mLock) {
                    ImageProcessProxy.this.mLock.notify();
                }
            }

            @Override // android.content.ServiceConnection
            public void onServiceDisconnected(ComponentName componentName) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 3)) {
                    iPatchRedirector2.redirect((short) 3, (Object) this, (Object) componentName);
                    return;
                }
                UploadLog.d(ImageProcessProxy.TAG, "onServiceDisconnected");
                ImageProcessProxy.this.mBound = false;
                ImageProcessProxy.this.mService = null;
            }
        };
        this.mContext = UploadGlobalConfig.getContext();
        this.mPendingRecords = new LinkedBlockingQueue<>();
        this.mRecordMap = new SparseArray<>();
    }

    private boolean asyncCopyAndCompressFile(int i3, String str, String str2, int i16, int i17, int i18, boolean z16, boolean z17) {
        Messenger messenger;
        UploadLog.d(TAG, "send MSG_COPY_AND_COMPRESS_IMAGE_REQUEST mBound = " + this.mBound + " flowId=" + i3 + " originalFilePath = " + str + " md5 = " + str2 + " targetWidth = " + i16 + " targetHeight = " + i17 + " quality = " + i18 + " autoRotate = " + z16 + " compressToWebp = " + z17);
        if (!this.mBound) {
            return false;
        }
        Message obtain = Message.obtain((Handler) null, 1);
        obtain.arg1 = i3;
        obtain.replyTo = this.mMessenger;
        String tempFilePath = FileUtils.getTempFilePath(this.mContext, str, str2, i3);
        UploadLog.d(TAG, "targetFile:" + tempFilePath);
        if (TextUtils.isEmpty(tempFilePath)) {
            return false;
        }
        obtain.getData().putParcelable(ImageProcessService.KEY_MSG_COMPRESS, new ImageProcessData(i3, str, tempFilePath, i16, i17, i18, z16, z17, null));
        IUploadConfig config = UploadGlobalConfig.getConfig();
        if (config != null) {
            obtain.getData().putBoolean(ImageProcessService.KEY_USE_NEW_COPY_EXIF, config.useNewCopyExif());
        } else {
            obtain.getData().putBoolean(ImageProcessService.KEY_USE_NEW_COPY_EXIF, false);
        }
        try {
            messenger = this.mService;
        } catch (Exception e16) {
            UploadLog.w(TAG, "ImageCompressor", e16);
        }
        if (messenger != null) {
            messenger.send(obtain);
            return true;
        }
        UploadLog.e(TAG, "mService == null");
        return false;
    }

    public static void close() {
        UploadLog.d(TAG, "close");
        if (sProxy != null) {
            sProxy.release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void finishTask(int i3) {
        UploadLog.d(TAG, "ImageProcessProxy finishTask flowId=" + i3);
        ImageCompressRecord imageCompressRecord = this.mRecordMap.get(i3);
        this.mRecordMap.remove(i3);
        this.mPendingRecords.remove(imageCompressRecord);
    }

    public static ImageProcessProxy getInstance() {
        if (sProxy == null) {
            synchronized (ImageProcessProxy.class) {
                if (sProxy == null) {
                    sProxy = new ImageProcessProxy();
                }
            }
        }
        return sProxy;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void next() {
        ImageCompressRecord peek;
        UploadLog.d(TAG, "next mServiceBusy = " + this.mServiceBusy + " mBound = " + this.mBound);
        if (!this.mServiceBusy && (peek = this.mPendingRecords.peek()) != null) {
            this.mServiceBusy = true;
            int i3 = peek.flowId;
            String str = peek.path;
            String str2 = peek.md5;
            IUploadConfig.UploadImageSize uploadImageSize = peek.mSize;
            if (asyncCopyAndCompressFile(i3, str, str2, uploadImageSize.width, uploadImageSize.height, uploadImageSize.quality, peek.autoRotate, peek.compressToWebp)) {
                Message obtain = Message.obtain(this.mIncomingHandler, 100);
                obtain.arg1 = peek.flowId;
                this.mIncomingHandler.sendMessageDelayed(obtain, 10000L);
            } else {
                this.mServiceBusy = false;
            }
        }
    }

    private void release() {
        UploadLog.d(TAG, "release");
        if (!this.mBound) {
            return;
        }
        this.mBound = false;
        this.mPendingRecords.clear();
        this.mRecordMap.clear();
        this.mContext.unbindService(this.mConnection);
    }

    public void cancel(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
            return;
        }
        UploadLog.d(TAG, "ImageProcessProxy cancel taskId=" + i3);
        ImageCompressRecord imageCompressRecord = this.mRecordMap.get(i3);
        if (imageCompressRecord != null) {
            finishTask(imageCompressRecord.flowId);
        }
        next();
    }

    public void compressFile(ImageCompressRecord imageCompressRecord, ImageCompressorCallback imageCompressorCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) imageCompressRecord, (Object) imageCompressorCallback);
            return;
        }
        if (!this.mBound) {
            initService();
        }
        this.mProcessCallback = imageCompressorCallback;
        compressFile(imageCompressRecord);
    }

    public boolean initService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (this.mBound) {
            return true;
        }
        UploadLog.v(TAG, "ImageProcessProxy start bindService");
        synchronized (this.mLock) {
            this.mContext.bindService(new Intent(this.mContext, (Class<?>) ImageProcessService.class), this.mConnection, 1);
            try {
                this.mLock.wait(10000L);
            } catch (InterruptedException unused) {
            }
        }
        UploadLog.v(TAG, "ImageProcessProxy end bindService mBound = " + this.mBound);
        return this.mBound;
    }

    public synchronized void compressFile(ImageCompressRecord imageCompressRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) imageCompressRecord);
            return;
        }
        if (this.mRecordMap.get(imageCompressRecord.flowId) == null) {
            this.mPendingRecords.add(imageCompressRecord);
            this.mRecordMap.put(imageCompressRecord.flowId, imageCompressRecord);
        } else {
            UploadLog.d(TAG, "mRecordMap has added task :" + imageCompressRecord.flowId);
        }
        next();
    }
}
