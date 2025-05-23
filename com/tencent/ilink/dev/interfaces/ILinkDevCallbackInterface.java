package com.tencent.ilink.dev.interfaces;

import android.util.Log;

/* compiled from: P */
/* loaded from: classes7.dex */
class ILinkDevCallbackInterface {
    private static final String TAG = "ILinkDevCbkInterface";

    public static void onFinishGetStrategy() {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onFinishGetStrategy();
        }
    }

    public static void onLoginComplete(int i3, int i16) {
        Log.d(TAG, "onLoginComplete errCode:" + i3);
        ILinkDevInterfaceService.getInstance().cancelInterfaceTimer();
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onDevLoginComplete(i3, i16);
        }
    }

    public static void onLogoutComplete(int i3) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onDevLogoutComplete(i3);
        }
    }

    public static void onNetStatusChanged(int i3) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onNetStatusChanged(i3);
        }
    }

    public static void onReceiveMessage(int i3, byte[] bArr) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveMessage(i3, bArr);
        }
    }

    public static void onReceivePullLogCmd(byte[] bArr) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceivePullLogCmd(bArr);
        }
    }

    public static void onReceiveResponse(int i3, int i16, byte[] bArr) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveResponse(i3, i16, bArr);
        }
    }

    public static void onSendMsgResult(int i3, String str) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onSendMsgResult(i3, str);
        }
    }

    public static void onUploadLogComplete(int i3) {
        IILinkDevCallback iLinkCallback = ILinkDevInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onUploadLogComplete(i3);
        }
    }
}
