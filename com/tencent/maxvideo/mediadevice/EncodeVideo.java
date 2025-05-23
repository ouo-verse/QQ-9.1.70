package com.tencent.maxvideo.mediadevice;

import android.os.Handler;
import android.os.Message;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes9.dex */
public class EncodeVideo {
    static IPatchRedirector $redirector_;
    private Handler mHandler;
    public String mReportMsg;

    public EncodeVideo(Handler handler) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) handler);
        } else {
            this.mHandler = handler;
        }
    }

    public static native void cancelCurrentEncoder();

    private void doNotify(Message message) {
        Handler handler = this.mHandler;
        if (handler != null) {
            try {
                handler.sendMessage(message);
            } catch (Exception unused) {
            }
        }
    }

    private void notifyEncodeProgress(int i3) {
        Message obtain = Message.obtain();
        obtain.what = 2;
        obtain.arg1 = i3;
        doNotify(obtain);
    }

    public static native void setMosaicData(byte[] bArr, int i3);

    public void onEncodeProgressCallback(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            notifyEncodeProgress(i3);
        }
    }

    public void setReportMsg(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        } else {
            this.mReportMsg = str;
        }
    }

    public native int startEncode(String str, String str2, String str3, String str4);

    public native int startPartEncode(String str, long j3, long j16, String str2, long j17, long j18, String str3, String str4, int[] iArr);

    public native int startQQEncode(String str, String str2, String str3, String str4, int[] iArr);
}
