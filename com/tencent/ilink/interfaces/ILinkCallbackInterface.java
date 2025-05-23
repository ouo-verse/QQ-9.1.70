package com.tencent.ilink.interfaces;

import android.util.Log;
import com.google.protobuf.InvalidProtocolBufferException;
import com.tencent.luggage.wxa.s0.b;
import com.tencent.mobileqq.msf.core.auth.e;
import java.nio.charset.StandardCharsets;

/* compiled from: P */
/* loaded from: classes7.dex */
class ILinkCallbackInterface {
    private static final String TAG = "ILinkCallbackInterface";

    /* compiled from: P */
    /* loaded from: classes7.dex */
    public enum EnContactOpCode {
        CONTACT_ADD(1),
        CONTACT_UPDATE(2),
        CONTACT_DELETE(3);

        private int mValue;

        EnContactOpCode(int i3) {
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

    public static void onAvatarUpdate(int i3, String str) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onAvatarUpdate(i3, str);
        }
    }

    public static void onCloseSdkAccount(int i3) {
        Log.d(TAG, "onCloseSdkAccount");
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onCloseSdkAccount(i3);
        }
    }

    public static void onContactUpdate(int i3, String str, byte[] bArr) {
        try {
            b a16 = b.a(bArr);
            if (a16 != null) {
                IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
                if (iLinkCallback != null) {
                    iLinkCallback.onContactUpdate(i3, str, a16);
                }
            } else {
                Log.e(TAG, "onContactUpdate contact is null!");
            }
        } catch (InvalidProtocolBufferException e16) {
            e16.printStackTrace();
        }
    }

    public static void onContactVerifyRequestUpdate(String str, byte[] bArr) {
        if (bArr != null) {
            Log.d(TAG, "onContactVerifyRequestUpdate profileLocal" + bArr);
            IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
            if (iLinkCallback != null) {
                iLinkCallback.onContactVerifyRequestUpdate(str, bArr);
                return;
            }
            return;
        }
        Log.e(TAG, "onContactVerifyRequestUpdate profile is null !");
    }

    public static void onContactsCleared() {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onContactsCleared();
        }
    }

    public static void onCreateRoom(int i3, long j3) {
        Log.d(TAG, "onCreateRoom errCode:" + i3 + " roomId:" + j3 + "  groupid: " + e.f247445e);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onCreateRoom(i3, j3, e.f247445e);
        }
    }

    public static void onDeviceShadowUpdate(byte[] bArr) {
        Log.d(TAG, "onDeviceShadowUpdate" + new String(bArr, StandardCharsets.UTF_8));
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onDeviceShadowUpdate(bArr);
        }
    }

    public static void onGetDeviceShadow(int i3, int i16, byte[] bArr) {
        Log.d(TAG, "onGetDeviceShadow" + new String(bArr, StandardCharsets.UTF_8));
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onGetDeviceShadow(i3, i16, bArr);
        }
    }

    public static void onGetPublicAccountQrCode(int i3, String str, int i16, int i17) {
        Log.d(TAG, "onGetPublicAccountQrCode  errCode = " + i3 + " qrcodePath:" + str + " expireTime:" + i16);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onGetPublicAccountQrCode(i3, str, i16, i17);
        }
    }

    public static void onGetThingTicket(int i3, String str, int i16, int i17) {
        Log.d(TAG, "onGetThingTicket  errCode = " + i3 + " thingTicket:" + str + " expireTime:" + i16);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onGetThingTicket(i3, str, i16, i17);
        }
    }

    public static void onHandleContactVerifyRequestComplete(String str, int i3) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onHandleContactVerifyRequestComplete(str, i3);
        }
    }

    public static void onInitContacts(int i3) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onInitContacts(i3);
        }
    }

    public static void onInitContactsComplete(int i3) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onInitContactsComplete(i3);
        }
    }

    public static void onLoginComplete(int i3) {
        Log.d(TAG, "onLoginComplete errCode:" + i3);
        ILinkAppImInterfaceService.getInstance().cancelInterfaceTimer();
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onLoginComplete(i3);
        }
    }

    public static void onLogoutComplete(int i3) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onLogoutComplete(i3);
        }
    }

    public static void onNetStatusChanged(int i3) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onNetStatusChanged(i3);
        }
    }

    public static void onNicknameUpdate(int i3, String str) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onNicknameUpdate(i3, str);
        }
    }

    public static void onReceiveCertainMessage(int i3, byte[] bArr) {
        Log.d(TAG, "onReceiveCertainMessage cmdid:" + i3 + " message=" + bArr);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveCertainMessage(i3, bArr);
        }
    }

    public static void onReceiveILinkThirdNotify(int i3, String str) {
        Log.d(TAG, "onReceiveILinkThirdNotify  cmdid = " + i3);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveILinkThirdNotify(i3, str);
        }
    }

    public static void onReceiveILinkVoipNotify(long j3, String str, String str2, String str3, boolean z16, int i3) {
        Log.d(TAG, "onReceiveILinkVoipNotify  roomId = " + j3 + " groupId = " + str + " fromIlinkId:" + str2 + " fromOpenid " + str3 + " callType:" + i3);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveILinkVoipNotify(j3, str, str2, str3, z16, i3);
        }
    }

    public static void onReceiveMessage(String str, String str2, String str3, String str4, int i3) {
        Log.d(TAG, "onReceiveMessage fromIlinkId:" + str + " content:" + str4);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReceiveMessage(str, str2, str3, str4, i3);
        }
    }

    public static void onReportDataWithCacheKey(int i3) {
        Log.d(TAG, "onReportDataWithCacheKey");
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onReportDataWithCacheKey(i3);
        }
    }

    public static void onSendMsgResult(int i3, String str) {
        Log.d(TAG, "onSendMsgResult errCode:" + i3 + " msgid=" + str);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onSendMsgResult(i3, str);
        }
    }

    public static void onThingTicketAndQrCodeTimeout() {
        Log.d(TAG, "onThingTicketAndQrCodeTimeout");
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onThingTicketAndQrCodeTimeout();
        }
    }

    public static void onUpdateContactAlias(int i3, String str, String str2) {
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onUpdateContactAlias(i3, str, str2);
        }
    }

    public static void onUpdateDeviceShadow(int i3, int i16, byte[] bArr) {
        Log.d(TAG, "onUpdateDeviceShadow" + new String(bArr, StandardCharsets.UTF_8));
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onUpdateDeviceShadow(i3, i16, bArr);
        }
    }

    public static void onVoipHanguped(String str, String str2, String str3, int i3) {
        Log.d(TAG, "onVoipHanguped");
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onVoipHanguped(str, str2, str3, i3);
        }
    }

    public static void onCreateRoom(int i3, long j3, String str) {
        Log.d(TAG, "onCreateRoom errCode:" + i3 + " roomId:" + j3 + "  groupid: " + str);
        IILinkCallback iLinkCallback = ILinkAppImInterfaceService.getInstance().getILinkCallback();
        if (iLinkCallback != null) {
            iLinkCallback.onCreateRoom(i3, j3, str);
        }
    }

    public static void onHangupVoipComplete(int i3, String str) {
    }

    public static void onInviteVoipComplete(int i3, String str, String str2) {
    }
}
