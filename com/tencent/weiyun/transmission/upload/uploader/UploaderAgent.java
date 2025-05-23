package com.tencent.weiyun.transmission.upload.uploader;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.perf.block.LockMethodProxy;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.transmission.ErrorCode;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.transmission.utils.handler.ReleaseLooperHandler;
import com.tencent.weiyun.uploader.IUploader;
import com.tencent.weiyun.uploader.UploadRequest;
import com.tencent.weiyun.uploader.UploadResponse;
import com.tencent.weiyun.uploader.Uploader;
import com.tencent.weiyun.uploader.xplatform.UploadNative;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes27.dex */
public class UploaderAgent implements Handler.Callback {
    static IPatchRedirector $redirector_ = null;
    private static final long LARGE_MIN_SPLIT_SIZE = 655360;
    private static final long MAX_SPLIT_NUM = 100;
    private static final int MSG_MISSING_UPLOAD = 32;
    private static final int MSG_SECOND_UPLOAD = 31;
    private static final long SMALL_FILE_THRESHOLD = 1048576;
    private static final long SMALL_MIN_SPLIT_SIZE = 65536;
    private static final String TAG = "UploaderAgent";
    private final Context mContext;
    private final ReleaseLooperHandler mHandler;
    private IUploader mUploaderInner;

    public UploaderAgent(Context context, ReleaseLooperHandler releaseLooperHandler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) releaseLooperHandler);
            return;
        }
        Uploader.init(new UploaderConfig(), new UploaderLog());
        this.mContext = context;
        initDefaultUploader();
        this.mHandler = releaseLooperHandler;
        releaseLooperHandler.addCallback(this);
    }

    private void initDefaultUploader() {
        if (UploadNative.getInstance().isLoaded()) {
            this.mUploaderInner = new Uploader(this.mContext, "common_uploader", null);
        }
    }

    public String[] calSliceSha1(String str, UploadNative.CanceledFlag canceledFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String[]) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) canceledFlag);
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return null;
        }
        return iUploader.calSliceSha1(str, canceledFlag);
    }

    public boolean cancel(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this, (Object) uploadRequest)).booleanValue();
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return false;
        }
        iUploader.cancel(uploadRequest);
        return true;
    }

    public void cancelAll() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.cancelAll();
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        long j3;
        long j16;
        long j17;
        long j18;
        float f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, (Object) this, (Object) message)).booleanValue();
        }
        int i3 = message.what;
        if (i3 == 31) {
            UploadRequest uploadRequest = (UploadRequest) message.obj;
            if (uploadRequest == null) {
                return true;
            }
            ((HashMap) uploadRequest.businessData()).put("second_upload", Boolean.toString(true));
            long size = uploadRequest.size();
            if (uploadRequest.listener() != null) {
                if (size < 1048576) {
                    j3 = 65536;
                } else {
                    j3 = LARGE_MIN_SPLIT_SIZE;
                }
                long j19 = size / 100;
                if (j3 > j19) {
                    j16 = j3;
                } else {
                    j16 = j19;
                }
                long elapsedRealtime = SystemClock.elapsedRealtime();
                long j26 = size;
                while (j26 > 0) {
                    if (j26 < j16) {
                        j17 = j26;
                    } else {
                        j17 = j16;
                    }
                    long j27 = j26 - j17;
                    long j28 = size - j27;
                    long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                    if (j28 > 0 && elapsedRealtime2 > 0) {
                        j18 = (((float) j28) / 1024.0f) / (((float) elapsedRealtime2) / 1000.0f);
                    } else {
                        j18 = 0;
                    }
                    IUploader.IUploadListener listener = uploadRequest.listener();
                    if (size == 0) {
                        f16 = 1.0f;
                    } else {
                        f16 = ((float) j28) / ((float) size);
                    }
                    long j29 = size;
                    listener.onUploadProgress(uploadRequest, size, f16, j18, 0L, 0L);
                    try {
                        LockMethodProxy.sleep(50L);
                        j26 = j27;
                        size = j29;
                    } catch (InterruptedException e16) {
                        TsLog.e(TAG, e16);
                    }
                }
                uploadRequest.listener().onUploadFinished(uploadRequest, true, null);
            }
            return true;
        }
        if (i3 != 32) {
            return false;
        }
        UploadRequest uploadRequest2 = (UploadRequest) message.obj;
        if (uploadRequest2 != null && uploadRequest2.listener() != null) {
            uploadRequest2.listener().onUploadFinished(uploadRequest2, false, new UploadResponse.Builder().code(ErrorCode.CMD_INVALID_RSP).errMsg("Uploader missing..").request(uploadRequest2).build());
        }
        return true;
    }

    public void loadLibFromPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else if (!UploadNative.getInstance().isLoaded() && !TextUtils.isEmpty(str) && UploadNative.getInstance().loadLibFromPath(str)) {
            initDefaultUploader();
        }
    }

    public void saveDirectIpFromWns(Map<String, Map<String, Object>> map) {
        Map<String, Object> map2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) map);
            return;
        }
        if (this.mUploaderInner != null && map != null && (map2 = map.get("PhotoSvrList")) != null) {
            String str = (String) map2.get("OptimumIP_WY_HTTP_Upload");
            String str2 = (String) map2.get("BackupIP_WY_HTTP_Upload");
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                this.mUploaderInner.setIpConfig(str, str2);
            }
        }
    }

    public void secondUpload(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) uploadRequest);
        } else {
            if (uploadRequest == null) {
                return;
            }
            this.mHandler.sendMessage(Message.obtain(null, 31, uploadRequest));
        }
    }

    public void setHttpProxy(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, Integer.valueOf(i3), str2, str3);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.setHttpProxy(str, i3, str2, str3);
    }

    public void setNetType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.setNetType(i3);
    }

    public void setSpareUploader(IUploader iUploader) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) iUploader);
        } else if (this.mUploaderInner == null && iUploader != null) {
            this.mUploaderInner = iUploader;
        }
    }

    public void speedDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.speedDown();
    }

    public void trialSpeedUp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, i3);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.trialSpeedUp(i3);
    }

    public boolean upload(UploadRequest uploadRequest) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, (Object) uploadRequest)).booleanValue();
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            if (uploadRequest != null) {
                this.mHandler.sendMessage(Message.obtain(null, 32, uploadRequest));
                return false;
            }
            return false;
        }
        return iUploader.upload(uploadRequest);
    }

    public void vipSpeedUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        IUploader iUploader = this.mUploaderInner;
        if (iUploader == null) {
            return;
        }
        iUploader.vipSpeedUp();
    }
}
