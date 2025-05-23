package com.tencent.weiyun.cmd;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.data.DirItem;
import com.tencent.weiyun.data.FileItem;
import com.tencent.weiyun.data.PoiItem;
import com.tencent.weiyun.utils.WyLog;

/* compiled from: P */
/* loaded from: classes27.dex */
class WeiyunNative {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "WeiyunNative";
    protected static boolean sIsLoaded;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(10498);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 13)) {
            redirector.redirect((short) 13);
        } else {
            sIsLoaded = false;
            loadLibrary(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WeiyunNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean loadLibrary(String str) {
        boolean z16 = true;
        if (sIsLoaded) {
            return true;
        }
        boolean z17 = false;
        try {
            if (TextUtils.isEmpty(str)) {
                System.loadLibrary("wlc_data_cmd_qq_v1.0.1");
            } else {
                System.load(str);
            }
            try {
                WyLog.v(TAG, "System.loadLibrary wlc_data_cmd_qq_v1.0.1 finish.");
            } catch (Exception e16) {
                e = e16;
                z17 = true;
                WyLog.e(TAG, "System.loadLibrary failed..", e);
                z16 = z17;
                WyLog.i(TAG, "loadLibrary libwlc_data_cmd_qq_v1.0.1.so result " + z16 + ", path=" + str);
                sIsLoaded = z16;
                return z16;
            } catch (UnsatisfiedLinkError e17) {
                e = e17;
                z17 = true;
                WyLog.e(TAG, "System.loadLibrary failed..", e);
                z16 = z17;
                WyLog.i(TAG, "loadLibrary libwlc_data_cmd_qq_v1.0.1.so result " + z16 + ", path=" + str);
                sIsLoaded = z16;
                return z16;
            }
        } catch (Exception e18) {
            e = e18;
        } catch (UnsatisfiedLinkError e19) {
            e = e19;
        }
        WyLog.i(TAG, "loadLibrary libwlc_data_cmd_qq_v1.0.1.so result " + z16 + ", path=" + str);
        sIsLoaded = z16;
        return z16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeCheckShareFile(DirItem[] dirItemArr, FileItem[] fileItemArr, String[] strArr, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeDeleteDirFile(DirItem[] dirItemArr, FileItem[] fileItemArr, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeFetchFileList(int i3, boolean z16, int i16, int i17, int i18, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeFetchFileListRecursively(int i3, int i16, int i17, int i18, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeFetchPOI(PoiItem[] poiItemArr, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeFetchPicVideoInfo(long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeFetchUserInfo(long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeModifyFile(FileItem fileItem, FileItem fileItem2, long j3);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeRegisterContext(WeiyunSDKContext weiyunSDKContext);

    /* JADX INFO: Access modifiers changed from: protected */
    public native void nativeReset();

    /* JADX INFO: Access modifiers changed from: protected */
    public native String nativeVersion();
}
