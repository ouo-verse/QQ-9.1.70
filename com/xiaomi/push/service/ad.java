package com.xiaomi.push.service;

import android.text.TextUtils;
import android.util.Base64;
import com.tencent.biz.pubaccount.util.api.IPublicAccountH5AbilityPlugin;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountH5AbilityPluginImpl;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.gamematrix.gmcg.webrtc.gamepad.api.Constants;
import cooperation.qzone.QZoneHelper;
import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ad {

    /* renamed from: a, reason: collision with root package name */
    private static final byte[] f389567a;

    /* renamed from: b, reason: collision with root package name */
    private static RSAPublicKey f389568b;

    static {
        byte[] bArr = {48, -127, -97, 48, 13, 6, 9, 42, -122, 72, -122, -9, 13, 1, 1, 1, 5, 0, 3, -127, -115, 0, 48, -127, -119, 2, -127, -127, 0, -109, -38, -114, 26, -72, 78, RegisterType.UNINIT_REF, 70, -90, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER, -30, 36, 85, -3, -43, 123, 61, -98, 4, -16, 67, RegisterType.CONFLICTED, -90, -73, -5, -89, 36, 44, -27, 59, -123, 72, -73, -48, 49, 13, RegisterType.UNINIT_REF, 50, -27, -82, RegisterType.REFERENCE, -28, 84, 0, -41, RegisterType.UNINIT_REF, 69, -39, 7, 82, 56, 79, -37, 40, 85, 107, Constants.VIRTUAL_GAMEPAD_PARAMS_RESP, 33, 123, -34, -49, PublicAccountH5AbilityPluginImpl.OPENIMG, -11, 49, 28, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -74, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_UGC, -122, -29, -84, 82, QZoneHelper.QzoneJsRequestCodeConstants.REQUEST_CODE_REFRESH_FEEDS, -122, 42, -40, -79, RegisterType.REFERENCE, -116, -42, 101, -70, 44, 11, 62, -49, -3, -22, -2, 66, 90, -116, -75, -99, WadlProxyConsts.REQUEST_CODE_INSTALL_PERMISSION, IPublicAccountH5AbilityPlugin.REQ_CODE_DELIVER_TopicPic, 69, 10, -81, -57, 89, -23, -36, -60, -81, 67, -114, 10, 79, 100, 29, 47, -24, Constants.NOTIFICATION_BACKGROUND_PUSH_STREAM, -66, -7, 87, RegisterType.UNINIT_REF, -125, -91, -43, -103, 67, -20, 41, IPublicAccountH5AbilityPlugin.REQ_CODE_COMMENT_EDITOR, -37, -11, 2, 3, 1, 0, 1};
        f389567a = bArr;
        try {
            f389568b = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(bArr));
        } catch (Throwable unused) {
            jz4.c.B("rsa key pair init failure!!!");
        }
    }

    public static String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(1, f389568b);
            return Base64.encodeToString(b(cipher, 1, str.getBytes("UTF-8"), f389568b.getModulus().bitLength()), 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static byte[] b(Cipher cipher, int i3, byte[] bArr, int i16) {
        int i17;
        byte[] doFinal;
        if (cipher != null && bArr != null) {
            if (i3 == 2) {
                i17 = i16 / 8;
            } else {
                i17 = (i16 / 8) - 11;
            }
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                int i18 = 0;
                int i19 = 0;
                while (bArr.length > i18) {
                    if (bArr.length - i18 > i17) {
                        doFinal = cipher.doFinal(bArr, i18, i17);
                    } else {
                        doFinal = cipher.doFinal(bArr, i18, bArr.length - i18);
                    }
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i19++;
                    i18 = i19 * i17;
                }
                return byteArrayOutputStream.toByteArray();
            } catch (Exception e16) {
                throw new RuntimeException(e16);
            }
        }
        return null;
    }
}
