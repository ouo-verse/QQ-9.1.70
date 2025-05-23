package com.tencent.qcircle.weseevideo.model.utils;

import android.support.annotation.Nullable;
import com.tencent.qcircle.tavcut.util.Logger;
import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: P */
/* loaded from: classes22.dex */
public class MD5Util {
    private static final String[] strDigits = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    /* JADX WARN: Code restructure failed: missing block: B:0:?, code lost:
    
        r3 = r3;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static String byteToArrayString(byte b16) {
        int i3;
        if (b16 < 0) {
            i3 = b16 + 256;
        }
        StringBuilder sb5 = new StringBuilder();
        String[] strArr = strDigits;
        sb5.append(strArr[i3 / 16]);
        sb5.append(strArr[i3 % 16]);
        return sb5.toString();
    }

    private static String byteToString(byte[] bArr) {
        StringBuilder sb5 = new StringBuilder();
        for (byte b16 : bArr) {
            sb5.append(byteToArrayString(b16));
        }
        return sb5.toString();
    }

    public static String getMD5Code(String str) {
        try {
            return byteToString(MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5).digest(str.getBytes(Charset.defaultCharset())));
        } catch (NoSuchAlgorithmException e16) {
            Logger.e(e16);
            return null;
        }
    }

    @Nullable
    public static String getUrlStrMd5(String str) {
        try {
            return getMD5Code(URLEncoder.encode(str, "utf-8"));
        } catch (Exception unused) {
            return null;
        }
    }
}
