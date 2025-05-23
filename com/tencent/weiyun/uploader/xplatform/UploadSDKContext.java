package com.tencent.weiyun.uploader.xplatform;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.uploader.module.XpConfig;
import com.tencent.weiyun.uploader.module.XpLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadSDKContext {
    static IPatchRedirector $redirector_ = null;
    private static final int LOG_LEVEL_DEBUG = 3;
    private static final int LOG_LEVEL_ERROR = 1;
    private static final int LOG_LEVEL_INFO = 2;
    private final IUploadSDKCallback mCallback;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public interface IUploadSDKCallback {
        void uploadCancelled(String str);

        void uploadFinish(String str, int i3, String str2);

        void uploadProgress(String str, long j3, long j16, long j17, long j18, long j19);
    }

    public UploadSDKContext(IUploadSDKCallback iUploadSDKCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) iUploadSDKCallback);
        } else {
            this.mCallback = iUploadSDKCallback;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getLogLevel() {
        int logLevel = XpLog.getLogLevel();
        if (logLevel <= 2) {
            return 3;
        }
        if (logLevel == 3) {
            return 2;
        }
        if (logLevel <= 5) {
            return 1;
        }
        return 0;
    }

    public int getApn() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this)).intValue();
        }
        return XpConfig.getIsp();
    }

    public void traceLogEx(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3, (Object) bArr);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            try {
                String str = new String(Arrays.copyOf(bArr, bArr.length), "UTF-8");
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 == 3) {
                            XpLog.d(str);
                            return;
                        }
                        return;
                    }
                    XpLog.i(str);
                    return;
                }
                XpLog.e(str);
            } catch (UnsupportedEncodingException e16) {
                XpLog.e("traceLogEx convert String error", e16);
            }
        }
    }

    public void uploadCancelled(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mCallback.uploadCancelled(str);
        }
    }

    public void uploadFinish(String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), str2);
        } else {
            this.mCallback.uploadFinish(str, i3, str2);
        }
    }

    public void uploadProgress(String str, long j3, long j16, long j17, long j18, long j19) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, Long.valueOf(j3), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Long.valueOf(j19));
        } else {
            this.mCallback.uploadProgress(str, j3, j16, j17, j18, j19);
        }
    }
}
