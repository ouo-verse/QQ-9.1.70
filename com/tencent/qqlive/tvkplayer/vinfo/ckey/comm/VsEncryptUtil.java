package com.tencent.qqlive.tvkplayer.vinfo.ckey.comm;

import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import com.tencent.mobileqq.wink.storage.kv.MaskType;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: P */
/* loaded from: classes23.dex */
public class VsEncryptUtil {
    public static String getAesKeyAPPLOCAL() {
        byte[] bArr = {76, 75, 72, 68, 71, 100, 104, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 41, 40, 42, 38, 94, 37, 36, 35};
        byte[] bArr2 = {IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 105, 100, 101, PublicAccountH5AbilityPluginImpl.OPENIMG, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 104, 105, 101, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 100};
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3 % 11]);
        }
        return new String(bArr);
    }

    public static String getAesKeySDCRD() {
        byte[] bArr = {33, MaskType.MASK_TYPE_EXTERNAL, 35, 36, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, IPublicAccountH5AbilityPlugin.REQ_CODE_AQ_INVITE_FRIEND, 104, 100, MaskType.MASK_TYPE_EXTERNAL, 68, 69, 82, 101, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 42};
        byte[] bArr2 = {IPublicAccountH5AbilityPlugin.REQ_CODE_SELECT_AND_UPLOAD_AVATAR, 105, 100, 101, PublicAccountH5AbilityPluginImpl.OPENIMG, IPublicAccountH5AbilityPlugin.REQ_CODE_UGC_CHOOSE_VIDEO_FROM_ALBUM, 104, 105, 101, Constants.SDK_SEND_CHANNEL_DATA_TYPE, 100};
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[i3] = (byte) (bArr[i3] ^ bArr2[i3 % 11]);
        }
        return new String(bArr);
    }

    public static byte[] vsAesDecrypt(String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (str == null || bArr == null || str.length() != 16) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(2, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] vsAesEncrypt(String str, byte[] bArr) throws Exception, NoSuchAlgorithmException {
        if (str == null || bArr == null || str.length() != 16) {
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str.getBytes(), KeyPropertiesCompact.KEY_ALGORITHM_AES);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(str.getBytes()));
        return cipher.doFinal(bArr);
    }

    public static byte[] vsDecryptAPPLOCAL(byte[] bArr) {
        try {
            return vsAesDecrypt(getAesKeyAPPLOCAL(), bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] vsDecryptSDCARD(byte[] bArr) {
        try {
            return vsAesDecrypt(getAesKeySDCRD(), bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] vsEncryptAPPLOCAL(byte[] bArr) {
        try {
            return vsAesEncrypt(getAesKeyAPPLOCAL(), bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] vsEncryptSDCARD(byte[] bArr) {
        try {
            return vsAesEncrypt(getAesKeySDCRD(), bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
