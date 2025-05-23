package com.tencent.qphone.base.util;

import android.content.Context;
import android.os.SystemClock;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.msf.service.MsfService;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes22.dex */
public abstract class CodecWarpper {
    public static final int CODE_FAIL = -1;
    public static final int CODE_FAIL_DECRYPT_DATA_LEN_ERROR = -5;
    public static final int CODE_FAIL_DECRYPT_EMPTY = -4;
    public static final int CODE_FAIL_DECRYPT_ONCE = -2;
    public static final int CODE_FAIL_DECRYPT_TWICE = -3;
    public static final int CODE_FAIL_PBUNPACK = -8;
    public static final int CODE_FAIL_ZLIB_DATA_LEN_SHORT = -6;
    public static final int CODE_FAIL_ZLIB_UNCOMPRESS_ERROR = -7;
    public static final int CODE_SUCC_DECRYPT_ONCE = 1;
    public static final int CODE_SUCC_DECRYPT_TWICE = 2;
    private static final String EVENT_NAME_NO_LOGIN_SEND_WITH_NO_WHITE = "evt_noLoginSendWithNoWhiteList";
    private static final String REPORT_PARAM_KEY_CMD = "report_param_key_cmd";
    public static final String REPORT_PARAM_KEY_TIME = "report_param_key_time";
    private static int checkedSOVersion = 0;
    public static boolean isLoaded = false;
    public static int soLoadResultCode = 0;
    public static String tag = "MSF.C.CodecWarpper";
    protected boolean mIsMain;
    private static final Object mLockObj = new Object();
    public static final AtomicBoolean isInitNoLoginWhiteList = new AtomicBoolean(false);

    /* compiled from: P */
    /* loaded from: classes22.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f344406a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f344407b;

        a(String str, String str2) {
            this.f344406a = str;
            this.f344407b = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            HashMap hashMap = new HashMap();
            hashMap.put("param_uin", this.f344406a);
            hashMap.put(CodecWarpper.REPORT_PARAM_KEY_CMD, this.f344407b);
            hashMap.put(CodecWarpper.REPORT_PARAM_KEY_TIME, String.valueOf(System.currentTimeMillis()));
            com.tencent.mobileqq.msf.core.c0.j statReporter = MsfService.getCore().getStatReporter();
            if (statReporter != null) {
                statReporter.a(CodecWarpper.EVENT_NAME_NO_LOGIN_SEND_WITH_NO_WHITE, true, 0L, 0L, (Map<String, String>) hashMap, true, false);
            }
        }
    }

    static {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int msfLoadSo = StringUtils.msfLoadSo(tag, "codecwrapperV2");
        soLoadResultCode = msfLoadSo;
        isLoaded = StringUtils.getLoadResult(msfLoadSo);
        QLog.e(tag, 1, "loadso codecwrapperV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        if (!isLoaded) {
            try {
                isLoaded = StringUtils.loadLibrary(tag, "codecwrapperV2", BaseApplication.getContext());
                MsfCore.sCore.bLoadUseTxlib = isLoaded;
            } catch (Throwable th5) {
                isLoaded = false;
                th5.printStackTrace();
            }
            QLog.e(tag, 1, "loadso again codecwrapperV2 " + isLoaded + " by txlib. cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
        }
        checkSOAppId();
        checkSOVersion();
    }

    public static void checkSOAppId() {
        try {
            int appId = BaseApplication.getContext().getAppId();
            boolean h16 = com.tencent.mobileqq.msf.core.m.i().h();
            initAppId(appId, h16);
            if (appId == 0) {
                com.tencent.mobileqq.msf.core.c0.j.a(appId, h16);
            }
            QLog.i(tag, 1, "checkSO appIdFromAppSetting = " + appId + "appIdFromNative = " + getAppid());
        } catch (UnsatisfiedLinkError e16) {
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            QLog.e(tag, 1, "initAppId UnsatisfiedLinkError. ", e16);
        } catch (Throwable th5) {
            QLog.e(tag, 1, "initAppId error. ", th5);
        }
    }

    public static void checkSOVersion() {
        try {
            checkedSOVersion = getSOVersion();
            QLog.d(tag, 1, "checkSO version=" + checkedSOVersion);
        } catch (UnsatisfiedLinkError e16) {
            try {
                int versionCode = getVersionCode();
                if (versionCode != 8 && versionCode != 9) {
                    if (versionCode == 10 || versionCode == 11) {
                        checkedSOVersion = 595;
                    }
                    QLog.d(tag, 1, "set so version to " + checkedSOVersion + " with error ", e16);
                    com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
                }
                checkedSOVersion = 591;
                QLog.d(tag, 1, "set so version to " + checkedSOVersion + " with error ", e16);
                com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            } catch (Throwable unused) {
                checkedSOVersion = 591;
                QLog.e(tag, 1, "set so version to 591 with deep error ", e16);
            }
        } catch (Throwable th5) {
            QLog.e(tag, 1, "set so version failed ", th5);
        }
    }

    private static native void closeReceData();

    private static native synchronized byte[] encodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte b18, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z16);

    private static native synchronized byte[] encodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte[] bArr2, boolean z16);

    private static native synchronized byte[] encodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z16);

    public static native int getAppid();

    public static native int getCurrentSSOVersion(boolean z16);

    public static native byte[] getFileStoreKey();

    public static native int getMaxPackageSize();

    public static native long getPacketLossLength(int i3);

    public static native int getSOVersion();

    public static int getSharedObjectVersion() {
        return checkedSOVersion;
    }

    public static native int getSocketRemainRecvBuffSize(int i3);

    public static native int getSocketRemainSendBuffSize(int i3);

    public static native long getSocketTotalRetrans(int i3);

    public static native int getVersionCode();

    private static native synchronized void initAppId(int i3, boolean z16);

    public static byte[] nativeEncodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z16) {
        try {
            return encodeRequest(i3, str, str2, str3, str4, str5, bArr, i16, i17, str6, b16, b17, bArr2, bArr3, bArr4, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "nativeEncodeRequest 2 exception", e16);
            }
            return null;
        }
    }

    public static int nativeGetCurrentSSOVersionCode(boolean z16) {
        try {
            return getCurrentSSOVersion(z16);
        } catch (UnsatisfiedLinkError e16) {
            QLog.d(tag, 1, "nativeGetCurrentSSOVersionCode error, ", e16);
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            return 0;
        }
    }

    public static byte[] nativeGetFileStoreKey() {
        try {
            return getFileStoreKey();
        } catch (UnsatisfiedLinkError e16) {
            QLog.d(tag, 1, "nativeGetFileStoreKey error, ", e16);
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            return null;
        }
    }

    public static void nativeInitNoLoginWhiteList(HashSet<String> hashSet) {
        if (isInitNoLoginWhiteList.compareAndSet(false, true)) {
            try {
                setNoLoginCmd((String[]) new ArrayList(hashSet).toArray(new String[0]));
            } catch (UnsatisfiedLinkError e16) {
                QLog.d(tag, 1, "nativeIsAllowNoLoginSend error, ", e16);
                com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            }
        }
    }

    public static void nativeOnConnClose(boolean z16) {
        onConnClose(z16);
    }

    public static FromServiceMsg nativeParseData(byte[] bArr) {
        FromServiceMsg fromServiceMsg = new FromServiceMsg();
        try {
            return parseData(bArr);
        } catch (Exception e16) {
            QLog.d(tag, 1, "nativeParseData error", e16);
            return fromServiceMsg;
        }
    }

    public static void nativeRemoveAccountKey(String str) {
        removeAccountKey(str);
    }

    public static void nativeSetAccountKey(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, String str2) {
        StringBuilder sb5 = new StringBuilder("nativeSetAccountKey ");
        sb5.append(",uin=");
        sb5.append(MsfSdkUtils.getShortUin(str));
        MsfSdkUtils.printBytes(",A1=", bArr, sb5);
        MsfSdkUtils.printBytes(",A2=", bArr2, sb5);
        MsfSdkUtils.printBytes(",A3=", bArr3, sb5);
        MsfSdkUtils.printBytes(",D1=", bArr4, sb5);
        MsfSdkUtils.printBytes(",D2=", bArr5, sb5);
        MsfSdkUtils.printBytes(",S2=", bArr6, sb5);
        MsfSdkUtils.printBytes(",key=", bArr7, sb5);
        MsfSdkUtils.printBytes(",cookie=", bArr8, sb5);
        QLog.d(tag, 1, sb5.toString());
        setAccountKey(str, bArr, bArr2, bArr3, bArr4, bArr5, bArr6, bArr7, bArr8, str2);
    }

    public static void nativeSetIsSupportNewSSO(boolean z16, boolean z17) {
        try {
            setIsSupportNewSSO(z16, z17);
            QLog.d(tag, 1, "[nativeSetIsSupportNewSSOVersion], isSupportNewSSOVersion: " + z16);
        } catch (Throwable th5) {
            QLog.d(tag, 1, "setIsSupportNewSSO error", th5);
        }
    }

    public static void nativeSetKsid(byte[] bArr) {
        try {
            setKsid(bArr);
        } catch (UnsatisfiedLinkError unused) {
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, "");
        }
    }

    public static void nativeSetNoLoginWithNoAccountInfoSwitch(boolean z16) {
        try {
            setNoLoginWithNoAccountInfoSwitch(z16);
        } catch (UnsatisfiedLinkError e16) {
            QLog.d(tag, 1, "setNoLoginWithNoAccountInfoSwitch error, ", e16);
            com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
        }
    }

    public static void nativeSetUseSimpleHead(String str, boolean z16, boolean z17) {
        setUseSimpleHead(str, z16, z17);
    }

    private static native synchronized void onConnClose(boolean z16);

    public static void onNoLoginMsgSendWithNoWhiteList(String str, String str2) {
        com.tencent.mobileqq.msf.core.q.q().post(new a(str, str2));
    }

    private native void onReceData(byte[] bArr, int i3, boolean z16);

    private static native FromServiceMsg parseData(byte[] bArr);

    private static native synchronized void removeAccountKey(String str);

    private static native synchronized void setAccountKey(String str, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5, byte[] bArr6, byte[] bArr7, byte[] bArr8, String str2);

    public static native synchronized void setIsSupportNewSSO(boolean z16, boolean z17);

    private static native synchronized void setKsid(byte[] bArr);

    public static native void setMaxPackageSize(int i3);

    private static native void setNoLoginCmd(String[] strArr);

    private static native void setNoLoginWithNoAccountInfoSwitch(boolean z16);

    private static native synchronized void setUseSimpleHead(String str, boolean z16, boolean z17);

    public native void init(Context context, boolean z16, boolean z17);

    public void nativeClearReceData() {
        if (QLog.isColorLevel()) {
            QLog.i(tag, 2, "nativeClearReceData");
        }
        synchronized (mLockObj) {
            try {
                closeReceData();
            } catch (UnsatisfiedLinkError e16) {
                com.tencent.mobileqq.msf.core.c0.j.a("codecwrapperV2", isLoaded, soLoadResultCode, e16.getMessage());
            }
        }
    }

    public void nativeOnReceData(byte[] bArr, int i3) {
        synchronized (mLockObj) {
            onReceData(bArr, i3, this.mIsMain);
        }
    }

    public abstract void onInvalidData(int i3, int i16, String str);

    public void onInvalidDataNative(int i3) {
        onInvalidData(-5, i3, MsfService.getCore().getMainAccount());
    }

    public abstract void onInvalidSign();

    public abstract void onResponse(int i3, Object obj, int i16, byte[] bArr);

    public abstract int onSSOPingResponse(byte[] bArr, int i3);

    public static byte[] nativeEncodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte b18, byte[] bArr2, byte[] bArr3, byte[] bArr4, boolean z16) {
        try {
            return encodeRequest(i3, str, str2, str3, str4, str5, bArr, i16, i17, str6, b16, b17, b18, bArr2, bArr3, bArr4, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "nativeEncodeRequest 1 exception", e16);
            }
            return null;
        }
    }

    public static byte[] nativeEncodeRequest(int i3, String str, String str2, String str3, String str4, String str5, byte[] bArr, int i16, int i17, String str6, byte b16, byte b17, byte[] bArr2, boolean z16) {
        try {
            return encodeRequest(i3, str, str2, str3, str4, str5, bArr, i16, i17, str6, b16, b17, bArr2, z16);
        } catch (Exception e16) {
            if (QLog.isColorLevel()) {
                QLog.i(tag, 2, "nativeEncodeRequest 3 exception", e16);
            }
            return null;
        }
    }
}
