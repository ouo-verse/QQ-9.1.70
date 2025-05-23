package com.tencent.ilink.dev.interfaces;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ILinkDevInterface {

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum EnAccountState {
        ACCOUNT_LOGGED_OUT(0),
        ACCOUNT_LOGGING_IN(1),
        ACCOUNT_LOGGED_IN(2),
        ACCOUNT_UNREGISTERED(3);

        private int mValue;

        EnAccountState(int i3) {
            this.mValue = i3;
        }

        @Override // java.lang.Enum
        public String toString() {
            return String.valueOf(this.mValue);
        }

        public int toValue() {
            return this.mValue;
        }
    }

    public static native void cancelLogin();

    public static native void changeDomain(int i3);

    public static native int getAccountState();

    public static native String getIlinkId();

    public static native String getToken();

    public static native long getUin();

    public static native void init(byte[] bArr, int i3, String str, String str2, int i16, int i17, int i18, boolean z16);

    public static native void initLog(String str, int i3);

    public static native void login();

    public static native void logout(boolean z16);

    public static native int sendDevRequest(byte[] bArr);

    public static native String sendIotMessage(String str, String str2, String str3, String str4);

    public static native int startUploadLog(byte[] bArr);

    public static native void stopUploadLog();

    public static native void uninit();

    public static native void uninitLog();

    public static native void updateDeviceParams(byte[] bArr);
}
