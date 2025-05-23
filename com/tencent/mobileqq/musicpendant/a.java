package com.tencent.mobileqq.musicpendant;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes15.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f251952a;

    /* renamed from: b, reason: collision with root package name */
    private static final byte[] f251953b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(73252);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        f251952a = new byte[]{65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 99, 100, 101, 102, 103, 104, 105, 106, 107, Constants.SDK_SEND_CHANNEL_DATA_TYPE, Constants.CHANNEL_DATATYPE_NETWORK_BANDWIDTH, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, PublicAccountH5AbilityPluginImpl.OPENIMG, PublicAccountH5AbilityPluginImpl.OPENCAMERA, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CAMERA_CAPTURE, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 120, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_QUESTION, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 43, 47};
        f251953b = new byte[128];
        for (int i3 = 0; i3 < 128; i3++) {
            f251953b[i3] = -1;
        }
        for (int i16 = 65; i16 <= 90; i16++) {
            f251953b[i16] = (byte) (i16 - 65);
        }
        for (int i17 = 97; i17 <= 122; i17++) {
            f251953b[i17] = (byte) ((i17 - 97) + 26);
        }
        for (int i18 = 48; i18 <= 57; i18++) {
            f251953b[i18] = (byte) ((i18 - 48) + 52);
        }
        byte[] bArr = f251953b;
        bArr[43] = 62;
        bArr[47] = 63;
    }

    public static byte[] a(String str) {
        byte[] bArr;
        if (str == null) {
            return null;
        }
        String d16 = d(str);
        if (d16.charAt(d16.length() - 2) == '=') {
            bArr = new byte[(((d16.length() / 4) - 1) * 3) + 1];
        } else if (d16.charAt(d16.length() - 1) == '=') {
            bArr = new byte[(((d16.length() / 4) - 1) * 3) + 2];
        } else {
            bArr = new byte[(d16.length() / 4) * 3];
        }
        int i3 = 0;
        int i16 = 0;
        while (i3 < d16.length() - 4) {
            byte[] bArr2 = f251953b;
            byte b16 = bArr2[d16.charAt(i3)];
            byte b17 = bArr2[d16.charAt(i3 + 1)];
            byte b18 = bArr2[d16.charAt(i3 + 2)];
            byte b19 = bArr2[d16.charAt(i3 + 3)];
            bArr[i16] = (byte) ((b16 << 2) | (b17 >> 4));
            bArr[i16 + 1] = (byte) ((b17 << 4) | (b18 >> 2));
            bArr[i16 + 2] = (byte) (b19 | (b18 << 6));
            i3 += 4;
            i16 += 3;
        }
        if (d16.charAt(d16.length() - 2) == '=') {
            byte[] bArr3 = f251953b;
            bArr[bArr.length - 1] = (byte) ((bArr3[d16.charAt(d16.length() - 3)] >> 4) | (bArr3[d16.charAt(d16.length() - 4)] << 2));
        } else if (d16.charAt(d16.length() - 1) == '=') {
            byte[] bArr4 = f251953b;
            byte b26 = bArr4[d16.charAt(d16.length() - 4)];
            byte b27 = bArr4[d16.charAt(d16.length() - 3)];
            byte b28 = bArr4[d16.charAt(d16.length() - 2)];
            bArr[bArr.length - 2] = (byte) ((b26 << 2) | (b27 >> 4));
            bArr[bArr.length - 1] = (byte) ((b28 >> 2) | (b27 << 4));
        } else {
            byte[] bArr5 = f251953b;
            byte b29 = bArr5[d16.charAt(d16.length() - 4)];
            byte b36 = bArr5[d16.charAt(d16.length() - 3)];
            byte b37 = bArr5[d16.charAt(d16.length() - 2)];
            byte b38 = bArr5[d16.charAt(d16.length() - 1)];
            bArr[bArr.length - 3] = (byte) ((b29 << 2) | (b36 >> 4));
            bArr[bArr.length - 2] = (byte) ((b36 << 4) | (b37 >> 2));
            bArr[bArr.length - 1] = (byte) (b38 | (b37 << 6));
        }
        return bArr;
    }

    public static byte[] b(byte[] bArr) {
        byte[] bArr2;
        byte[] c16 = c(bArr);
        if (c16[c16.length - 2] == 61) {
            bArr2 = new byte[(((c16.length / 4) - 1) * 3) + 1];
        } else if (c16[c16.length - 1] == 61) {
            bArr2 = new byte[(((c16.length / 4) - 1) * 3) + 2];
        } else {
            bArr2 = new byte[(c16.length / 4) * 3];
        }
        int i3 = 0;
        int i16 = 0;
        while (i3 < c16.length - 4) {
            byte[] bArr3 = f251953b;
            byte b16 = bArr3[c16[i3]];
            byte b17 = bArr3[c16[i3 + 1]];
            byte b18 = bArr3[c16[i3 + 2]];
            byte b19 = bArr3[c16[i3 + 3]];
            bArr2[i16] = (byte) ((b16 << 2) | (b17 >> 4));
            bArr2[i16 + 1] = (byte) ((b17 << 4) | (b18 >> 2));
            bArr2[i16 + 2] = (byte) (b19 | (b18 << 6));
            i3 += 4;
            i16 += 3;
        }
        if (c16[c16.length - 2] == 61) {
            byte[] bArr4 = f251953b;
            bArr2[bArr2.length - 1] = (byte) ((bArr4[c16[c16.length - 3]] >> 4) | (bArr4[c16[c16.length - 4]] << 2));
        } else if (c16[c16.length - 1] == 61) {
            byte[] bArr5 = f251953b;
            byte b26 = bArr5[c16[c16.length - 4]];
            byte b27 = bArr5[c16[c16.length - 3]];
            byte b28 = bArr5[c16[c16.length - 2]];
            bArr2[bArr2.length - 2] = (byte) ((b26 << 2) | (b27 >> 4));
            bArr2[bArr2.length - 1] = (byte) ((b28 >> 2) | (b27 << 4));
        } else {
            byte[] bArr6 = f251953b;
            byte b29 = bArr6[c16[c16.length - 4]];
            byte b36 = bArr6[c16[c16.length - 3]];
            byte b37 = bArr6[c16[c16.length - 2]];
            byte b38 = bArr6[c16[c16.length - 1]];
            bArr2[bArr2.length - 3] = (byte) ((b29 << 2) | (b36 >> 4));
            bArr2[bArr2.length - 2] = (byte) ((b36 << 4) | (b37 >> 2));
            bArr2[bArr2.length - 1] = (byte) (b38 | (b37 << 6));
        }
        return bArr2;
    }

    private static byte[] c(byte[] bArr) {
        byte[] bArr2 = new byte[bArr.length];
        int i3 = 0;
        for (int i16 = 0; i16 < bArr.length; i16++) {
            if (g(bArr[i16])) {
                bArr2[i3] = bArr[i16];
                i3++;
            }
        }
        byte[] bArr3 = new byte[i3];
        System.arraycopy(bArr2, 0, bArr3, 0, i3);
        return bArr3;
    }

    private static String d(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (g((byte) str.charAt(i3))) {
                stringBuffer.append(str.charAt(i3));
            }
        }
        return stringBuffer.toString();
    }

    public static byte[] e(byte[] bArr) {
        byte[] bArr2;
        int length = bArr.length % 3;
        if (length == 0) {
            bArr2 = new byte[(bArr.length * 4) / 3];
        } else {
            bArr2 = new byte[((bArr.length / 3) + 1) * 4];
        }
        int length2 = bArr.length - length;
        int i3 = 0;
        int i16 = 0;
        while (i3 < length2) {
            int i17 = bArr[i3] & 255;
            int i18 = bArr[i3 + 1] & 255;
            int i19 = bArr[i3 + 2] & 255;
            byte[] bArr3 = f251952a;
            bArr2[i16] = bArr3[(i17 >>> 2) & 63];
            bArr2[i16 + 1] = bArr3[((i17 << 4) | (i18 >>> 4)) & 63];
            bArr2[i16 + 2] = bArr3[((i18 << 2) | (i19 >>> 6)) & 63];
            bArr2[i16 + 3] = bArr3[i19 & 63];
            i3 += 3;
            i16 += 4;
        }
        if (length != 1) {
            if (length == 2) {
                int i26 = bArr[bArr.length - 2] & 255;
                int i27 = bArr[bArr.length - 1] & 255;
                int length3 = bArr2.length - 4;
                byte[] bArr4 = f251952a;
                bArr2[length3] = bArr4[(i26 >>> 2) & 63];
                bArr2[bArr2.length - 3] = bArr4[((i26 << 4) | (i27 >>> 4)) & 63];
                bArr2[bArr2.length - 2] = bArr4[(i27 << 2) & 63];
                bArr2[bArr2.length - 1] = 61;
            }
        } else {
            int i28 = bArr[bArr.length - 1] & 255;
            int length4 = bArr2.length - 4;
            byte[] bArr5 = f251952a;
            bArr2[length4] = bArr5[(i28 >>> 2) & 63];
            bArr2[bArr2.length - 3] = bArr5[(i28 << 4) & 63];
            bArr2[bArr2.length - 2] = 61;
            bArr2[bArr2.length - 1] = 61;
        }
        return bArr2;
    }

    public static String f(String str) {
        if (str == null) {
            return null;
        }
        try {
            return new String(e(str.getBytes("UTF-8")), "UTF-8");
        } catch (Exception unused) {
            return null;
        }
    }

    private static boolean g(byte b16) {
        if (b16 == 61) {
            return true;
        }
        if (b16 >= 0 && b16 < 128 && f251953b[b16] != -1) {
            return true;
        }
        return false;
    }
}
