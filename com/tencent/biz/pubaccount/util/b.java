package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.pluginsdk.PluginBaseInfoHelper;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.zip.GZIPOutputStream;
import javax.crypto.Cipher;

/* compiled from: P */
/* loaded from: classes4.dex */
public class b {
    public static byte[] a(byte[] bArr) {
        byte[] bArr2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            bArr2 = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return bArr2;
        } catch (IOException e16) {
            e16.printStackTrace();
            return bArr2;
        }
    }

    public static byte[] b(boolean z16, byte[] bArr, String str) throws Exception {
        int i3;
        String str2;
        byte[] doFinal;
        if (bArr != null) {
            if (z16) {
                str2 = "RSA/ECB/PKCS1Padding";
                i3 = 117;
            } else {
                i3 = 128;
                str2 = "RSA";
            }
            PublicKey generatePublic = KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(PluginBaseInfoHelper.Base64Helper.decode(str, 0)));
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, generatePublic);
            int length = bArr.length;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int i16 = 0;
            while (true) {
                int i17 = length - i16;
                if (i17 > 0) {
                    if (i17 > i3) {
                        doFinal = cipher.doFinal(bArr, i16, i3);
                    } else {
                        doFinal = cipher.doFinal(bArr, i16, i17);
                    }
                    byteArrayOutputStream.write(doFinal, 0, doFinal.length);
                    i16 += i3;
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    return byteArray;
                }
            }
        } else {
            throw new IllegalArgumentException("encryptByPublicKey data null");
        }
    }
}
