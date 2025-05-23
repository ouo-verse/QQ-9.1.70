package com.tencent.ilink.interfaces;

import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes7.dex */
public class ILinkAppImInterface {
    public static native void cancelLogin();

    public static native void closeSdkAccount();

    public static native void deleteContactByIlinkimId(String str);

    public static native ArrayList<byte[]> getAllContacts();

    public static native ArrayList<byte[]> getAllUnVerifyRequests();

    public static native byte[] getContactByIlinkimId(String str);

    public static native int getDeviceShadow();

    public static native void getImTicket(int i3);

    public static native byte[] getProfile();

    public static native void getPublicAccountQrCode(int i3);

    public static native long getUin();

    public static native void handleContactVerifyRequest(String str, boolean z16);

    public static native int init(String str, String str2, boolean z16);

    public static native void initContacts();

    public static native void login();

    public static native void logout(boolean z16);

    public static native void reportDataWithCacheKey(String str, byte[] bArr, int i3);

    public static native String sendImageMessage(String str, byte[] bArr);

    public static native String sendIotMessage(String str, String str2, String str3);

    public static native String sendTextMessage(String str, String str2);

    public static native String sendVideoMessage(String str, byte[] bArr);

    public static native void setVoipAppid(String str);

    public static native void startAutoSync(int i3);

    public static native void uninit();

    public static native void updateAvatar(String str);

    public static native void updateContactAlias(String str, String str2);

    public static native int updateDeviceShadow(byte[] bArr);

    public static native void updateNickname(String str);
}
