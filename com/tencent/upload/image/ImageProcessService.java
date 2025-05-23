package com.tencent.upload.image;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcelable;
import android.os.Process;
import android.os.RemoteException;
import android.text.TextUtils;
import com.tencent.ams.mosaic.MosaicConstants$JsFunction;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.upload.utils.FileUtils;
import com.tencent.upload.utils.UploadLog;
import java.io.File;

/* loaded from: classes27.dex */
public class ImageProcessService extends Service {
    static IPatchRedirector $redirector_ = null;
    public static final int BITMAP_TO_FILE_FAIL = 16777216;
    public static final int BITMAP_TO_FILE_SUCCESS = 8388608;
    public static final int CLOSE_EXCEPTION = 4194304;
    public static final int COMPRESS_EXCEPTION = 2097152;
    public static final int CREATE_BITMAP = 16384;
    public static final int CREATE_BITMAP2 = 65536;
    public static final int CREATE_BITMAP2_OOM = 131072;
    public static final int CREATE_BITMAP_OOM = 32768;
    public static final int DECODE_BITMAP_SIZE = 4;
    public static final int DECODE_BITMAP_SIZE_0 = 2;
    public static final int DECODE_FILE2 = 32;
    public static final int DECODE_FILE2_OOM = 64;
    public static final int DECODE_FILE_OOM = 16;
    public static final int DECODE_FILE_WITH_RETRY = 256;
    public static final int DECODE_FILE_WITH_RETRY_FAIL = 512;
    public static final int EMPTY_SAVE_PATH = 1048576;
    public static final int EXIF_NULL = 2048;
    public static final String KEY_MSG_COMPRESS = "KEY_MSG_COMPRESS";
    public static final String KEY_USE_NEW_COPY_EXIF = "KEY_USE_NEW_COMPRESS";
    static final Milestone MILESTONE;
    public static final int MSG_COPY_AND_COMPRESS_IMAGE_REQUEST = 1;
    public static final int MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE = 101;
    public static final int MSG_OBTAIN_PID_REQUEST = 2;
    public static final int MSG_OBTAIN_PID_RESPONSE = 102;
    public static final int MSG_PROCESS_TIMEOUT = 100;
    public static final int POST_ROTATE = 4096;
    public static final int START_COMPRESS_FILE = 1;
    public static final int START_DECODE_FILE_WITH_RETRY = 8;
    public static final int START_DECODE_FILE_WITH_RETRY2 = 128;
    public static final int START_ROTATE = 1024;
    public static final int START_TRANSFORM_BITMAP = 8192;
    public static final String TAG = "ImageProcessService";
    public static final int TRANSFORM_BITMAP_END = 262144;
    public static final int TRANSFORM_BITMAP_FAIL = 524288;
    static String sMsg;
    IncomingHandler mIncomingHandler;
    Messenger mMessenger;

    /* loaded from: classes27.dex */
    static class IncomingHandler extends Handler {
        static IPatchRedirector $redirector_;

        IncomingHandler() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
                return;
            }
            int i3 = message.what;
            if (i3 != 1) {
                if (i3 != 2) {
                    super.handleMessage(message);
                    return;
                }
                UploadLog.i(ImageProcessService.TAG, "receive MSG_OBTAIN_PID_REQUEST");
                try {
                    Message obtain = Message.obtain((Handler) null, 102);
                    obtain.arg1 = Process.myPid();
                    message.replyTo.send(obtain);
                    UploadLog.v(ImageProcessService.TAG, "send MSG_OBTAIN_PID_RESPONSE flowId=" + message.arg1);
                    return;
                } catch (RemoteException e16) {
                    UploadLog.e(ImageProcessService.TAG, "send MSG_OBTAIN_PID_RESPONSE:" + e16);
                    return;
                }
            }
            UploadLog.d(ImageProcessService.TAG, "receive MSG_COPY_AND_COMPRESS_IMAGE_REQUEST request flowId=" + message.arg1);
            Milestone milestone = ImageProcessService.MILESTONE;
            milestone.reset();
            ImageProcessService.sMsg = null;
            Message obtain2 = Message.obtain((Handler) null, 101);
            obtain2.arg1 = message.arg1;
            message.getData().setClassLoader(ImageProcessData.class.getClassLoader());
            Parcelable parcelable = message.getData().getParcelable(ImageProcessService.KEY_MSG_COMPRESS);
            if (parcelable instanceof ImageProcessData) {
                ImageProcessData imageProcessData = (ImageProcessData) parcelable;
                UploadLog.d(ImageProcessService.TAG, "compressFile start. " + imageProcessData.toString());
                if (!FileUtils.isFileExist(imageProcessData.targetFilePath)) {
                    UploadLog.d(ImageProcessService.TAG, "targetFilePath not exist begin compress");
                    str = ImageProcessUtil.compressFile(imageProcessData.originalFilePath, imageProcessData.targetFilePath, imageProcessData.targetWidth, imageProcessData.targetHeight, imageProcessData.targetQuality, imageProcessData.autoRotate, imageProcessData.compressToWebp, message.getData().getBoolean(ImageProcessService.KEY_USE_NEW_COPY_EXIF));
                } else {
                    UploadLog.d(ImageProcessService.TAG, "compressFile exist no need compress");
                    str = imageProcessData.targetFilePath;
                }
                UploadLog.d(ImageProcessService.TAG, "compressFile end. targetFile=" + str);
                if (!TextUtils.isEmpty(str) && new File(str).exists()) {
                    imageProcessData.originalFilePath = str;
                }
                if (TextUtils.isEmpty(ImageProcessService.sMsg)) {
                    imageProcessData.f383918msg = null;
                } else {
                    imageProcessData.f383918msg = "imageCompressCode=" + milestone.getMilestoneValue() + " errorMsg=" + ImageProcessService.sMsg;
                }
                obtain2.getData().putParcelable(ImageProcessService.KEY_MSG_COMPRESS, imageProcessData);
            }
            try {
                message.replyTo.send(obtain2);
                UploadLog.v(ImageProcessService.TAG, "send MSG_COPY_AND_COMPRESS_IMAGE_RESPONSE flowId=" + message.arg1);
            } catch (RemoteException e17) {
                UploadLog.e(ImageProcessService.TAG, ImageProcessService.TAG, e17);
            }
            try {
                LockMethodProxy.sleep(300L);
            } catch (InterruptedException unused) {
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10591);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 7)) {
            redirector.redirect((short) 7);
        } else {
            MILESTONE = new Milestone();
        }
    }

    public ImageProcessService() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (IBinder) iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent);
        }
        UploadLog.d(TAG, "onBind");
        return this.mMessenger.getBinder();
    }

    @Override // android.app.Service
    public void onCreate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.mIncomingHandler = new IncomingHandler();
            this.mMessenger = new Messenger(this.mIncomingHandler);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            UploadLog.d(TAG, MosaicConstants$JsFunction.FUNC_ON_DESTROY);
            super.onDestroy();
        }
    }

    @Override // android.app.Service
    public void onRebind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) intent);
        } else {
            UploadLog.v(TAG, "onRebind");
            super.onRebind(intent);
        }
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) intent)).booleanValue();
        }
        UploadLog.d(TAG, "onUnbind");
        this.mIncomingHandler.removeMessages(1);
        return super.onUnbind(intent);
    }
}
