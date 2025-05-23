package com.tencent.weiyun.cmd;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.utils.WyLog;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes27.dex */
abstract class WeiyunSDKContext {
    static IPatchRedirector $redirector_ = null;
    public static final int LOGIN_TYPE_QQ = 0;
    public static final int LOGIN_TYPE_WECHAT = 1;
    private static final int LOG_LEVEL_DEBUG = 0;
    private static final int LOG_LEVEL_ERROR = 3;
    private static final int LOG_LEVEL_INFO = 1;
    private static final int LOG_LEVEL_WARNING = 2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public WeiyunSDKContext() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public abstract String getAccessToken();

    public abstract String getCachePath();

    public abstract String getDeviceId();

    public abstract String getDeviceInfo();

    public abstract String getDeviceName();

    public String getDocumentPath() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "";
    }

    public abstract int getLoginType();

    public int getNetworkStatus() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return 0;
    }

    public abstract int getNetworkType();

    public abstract String getOpenID();

    public abstract String getOpenKey();

    public int getPlatform() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Integer) iPatchRedirector.redirect((short) 4, (Object) this)).intValue();
        }
        return 0;
    }

    public abstract String getRefreshToken();

    public abstract long[] getScreenSize();

    public long getUin() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        if (TextUtils.isEmpty(getOpenID())) {
            return 0L;
        }
        return r0.hashCode();
    }

    public abstract String getWifiBssid();

    protected void onCallback(long j3, long j16, int i3, boolean z16, int i16, String str, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), Boolean.valueOf(z16), Integer.valueOf(i16), str, Boolean.valueOf(z17));
        } else {
            WeiyunClient.getInstance().onNativeCallback(j3, j16, i3, z16, i16, str, z17);
        }
    }

    public native void recvResponse(int i3, byte[] bArr, long j3, int i16);

    public abstract void sendRequest(String str, byte[] bArr, long j3, int i3);

    public void traceLog(int i3, byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3, (Object) bArr);
            return;
        }
        if (bArr != null && bArr.length > 0) {
            try {
                String str = new String(Arrays.copyOf(bArr, bArr.length), "UTF-8");
                if (i3 != 0) {
                    if (i3 != 1) {
                        if (i3 != 2) {
                            if (i3 == 3) {
                                WyLog.e(str);
                                return;
                            }
                            return;
                        }
                        WyLog.w(str);
                        return;
                    }
                    WyLog.i(str);
                    return;
                }
                WyLog.d(str);
            } catch (UnsupportedEncodingException e16) {
                WyLog.e("traceLog convert String error", e16);
            }
        }
    }
}
