package com.tencent.weiyun.uploader.xplatform;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.weiyun.uploader.module.XpLog;
import com.tencent.weiyun.utils.Singleton;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class UploadNative {
    static IPatchRedirector $redirector_ = null;
    private static final String TAG = "UploadNative";
    private static Singleton<UploadNative, Void> sInstance;
    private static boolean sIsLoaded;
    private boolean mIsInit;

    /* compiled from: P */
    /* loaded from: classes27.dex */
    public static final class CanceledFlag {
        static IPatchRedirector $redirector_;
        private volatile boolean isCanceled;

        CanceledFlag() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }

        public boolean isCanceled() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this)).booleanValue();
            }
            return this.isCanceled;
        }

        public void setCanceled(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, z16);
            } else {
                this.isCanceled = z16;
            }
        }

        public CanceledFlag(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                this.isCanceled = z16;
            } else {
                iPatchRedirector.redirect((short) 2, (Object) this, z16);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(13514);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 16)) {
            redirector.redirect((short) 16);
            return;
        }
        sIsLoaded = false;
        loadLibrary(null);
        sInstance = new Singleton<UploadNative, Void>() { // from class: com.tencent.weiyun.uploader.xplatform.UploadNative.1
            static IPatchRedirector $redirector_;

            {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.tencent.weiyun.utils.Singleton
            public UploadNative create(Void r46) {
                IPatchRedirector iPatchRedirector = $redirector_;
                return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? new UploadNative() : (UploadNative) iPatchRedirector.redirect((short) 2, (Object) this, (Object) r46);
            }
        };
    }

    public UploadNative() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mIsInit = false;
        }
    }

    public static UploadNative getInstance() {
        return sInstance.get(null);
    }

    private static boolean loadLibrary(String str) {
        boolean z16 = true;
        if (sIsLoaded) {
            return true;
        }
        boolean z17 = false;
        try {
            if (TextUtils.isEmpty(str)) {
                System.loadLibrary("wlc_upload_uni_v1.0.1");
            } else {
                System.load(str);
            }
            try {
                XpLog.v(TAG, "System.loadLibrary wlc_upload_uni_v1.0.1 finish.");
            } catch (Exception e16) {
                e = e16;
                z17 = true;
                XpLog.e(TAG, "System.loadLibrary failed..", e);
                z16 = z17;
                XpLog.i(TAG, "loadLibrary libwlc_upload_uni_v1.0.1.so result " + z16 + ", path=" + str);
                sIsLoaded = z16;
                return z16;
            } catch (UnsatisfiedLinkError e17) {
                e = e17;
                z17 = true;
                XpLog.e(TAG, "System.loadLibrary failed..", e);
                z16 = z17;
                XpLog.i(TAG, "loadLibrary libwlc_upload_uni_v1.0.1.so result " + z16 + ", path=" + str);
                sIsLoaded = z16;
                return z16;
            }
        } catch (Exception e18) {
            e = e18;
        } catch (UnsatisfiedLinkError e19) {
            e = e19;
        }
        XpLog.i(TAG, "loadLibrary libwlc_upload_uni_v1.0.1.so result " + z16 + ", path=" + str);
        sIsLoaded = z16;
        return z16;
    }

    private native Object[] nativeCalSliceSha1(String str, CanceledFlag canceledFlag);

    private native String nativeCreateXpUploadTask(long j3, String str, long j16, String str2, String str3, String str4, int i3, int i16, String[] strArr, long[] jArr);

    private native void nativeInit(String str, String str2, String str3, String str4, String str5, boolean z16, UploadSDKContext uploadSDKContext, int i3);

    private native void nativeReportError(long j3, String str, String str2, String str3, int i3, boolean z16, long j16, long j17, long j18, boolean z17, int i16);

    private native void nativeSetHttpProxy(String str, int i3, String str2, String str3);

    private native void nativeSetIpConfig(String str, String str2);

    private native void nativeSetNetType(int i3);

    private native void nativeSpeedDown();

    private native void nativeStartTask(String str);

    private native void nativeStopTask(String str);

    private native void nativeTrialSpeedUp(int i3);

    private native void nativeVipSpeedUp();

    public String[] calSliceSha1(String str, CanceledFlag canceledFlag) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (String[]) iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) canceledFlag);
        }
        if (TextUtils.isEmpty(str)) {
            XpLog.w(TAG, "calSliceSha1: the param filePath should be valid.");
            return null;
        }
        if (this.mIsInit) {
            Object[] nativeCalSliceSha1 = nativeCalSliceSha1(str, canceledFlag);
            if (nativeCalSliceSha1 == null) {
                return null;
            }
            String[] strArr = new String[nativeCalSliceSha1.length];
            int length = nativeCalSliceSha1.length;
            int i3 = 0;
            int i16 = 0;
            while (i3 < length) {
                strArr[i16] = (String) nativeCalSliceSha1[i3];
                i3++;
                i16++;
            }
            return strArr;
        }
        XpLog.e(TAG, "UploadSdk hasn't be init.");
        return null;
    }

    public String createUploadTask(long j3, String str, long j16, String str2, String str3, String str4, int i3, int i16, String[] strArr, long[] jArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, this, Long.valueOf(j3), str, Long.valueOf(j16), str2, str3, str4, Integer.valueOf(i3), Integer.valueOf(i16), strArr, jArr);
        }
        if (this.mIsInit) {
            return nativeCreateXpUploadTask(j3, str, j16, str2, str3, str4, i3, i16, strArr, jArr);
        }
        XpLog.e(TAG, "UploadSdk hasn't be init.");
        return null;
    }

    public void init(String str, String str2, String str3, String str4, String str5, boolean z16, UploadSDKContext uploadSDKContext) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, str, str2, str3, str4, str5, Boolean.valueOf(z16), uploadSDKContext);
        } else if (!this.mIsInit) {
            synchronized (this) {
                if (!this.mIsInit) {
                    nativeInit(str, str2, str3, str4, str5, z16, uploadSDKContext, UploadSDKContext.getLogLevel());
                    this.mIsInit = true;
                }
            }
        }
    }

    public boolean isLoaded() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return sIsLoaded;
    }

    public boolean loadLibFromPath(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str)).booleanValue();
        }
        if (sIsLoaded) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return loadLibrary(str);
    }

    public boolean reportError(long j3, String str, String str2, String str3, int i3, boolean z16, long j16, long j17, long j18, boolean z17, int i16) {
        UploadNative uploadNative;
        String str4;
        String str5;
        String str6;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return ((Boolean) iPatchRedirector.redirect((short) 15, this, Long.valueOf(j3), str, str2, str3, Integer.valueOf(i3), Boolean.valueOf(z16), Long.valueOf(j16), Long.valueOf(j17), Long.valueOf(j18), Boolean.valueOf(z17), Integer.valueOf(i16))).booleanValue();
        }
        if (this.mIsInit) {
            if (str == null) {
                str4 = "";
            } else {
                str4 = str;
            }
            if (str2 == null) {
                str5 = "";
            } else {
                str5 = str2;
            }
            if (str3 == null) {
                str6 = "";
            } else {
                str6 = str3;
            }
            uploadNative = this;
            uploadNative.nativeReportError(j3, str4, str5, str6, i3, z16, j16, j17, j18, z17, i16);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
            uploadNative = this;
        }
        return uploadNative.mIsInit;
    }

    public boolean setHttpProxy(String str, int i3, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Boolean) iPatchRedirector.redirect((short) 9, this, str, Integer.valueOf(i3), str2, str3)).booleanValue();
        }
        if (this.mIsInit) {
            nativeSetHttpProxy(str, i3, str2, str3);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean setIpConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return ((Boolean) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).booleanValue();
        }
        if (this.mIsInit) {
            nativeSetIpConfig(str, str2);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean setNetType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, i3)).booleanValue();
        }
        if (this.mIsInit) {
            nativeSetNetType(i3);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean speedDown() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        if (this.mIsInit) {
            nativeSpeedDown();
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean startTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str)).booleanValue();
        }
        if (this.mIsInit) {
            nativeStartTask(str);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean stopTask(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) str)).booleanValue();
        }
        if (this.mIsInit) {
            nativeStopTask(str);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean trialSpeedUp(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, i3)).booleanValue();
        }
        if (this.mIsInit) {
            nativeTrialSpeedUp(i3);
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }

    public boolean vipSpeedUp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Boolean) iPatchRedirector.redirect((short) 12, (Object) this)).booleanValue();
        }
        if (this.mIsInit) {
            nativeVipSpeedUp();
        } else {
            XpLog.e(TAG, "UploadSdk hasn't be init.");
        }
        return this.mIsInit;
    }
}
