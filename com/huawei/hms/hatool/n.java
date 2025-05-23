package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;
import com.huawei.secure.android.common.encrypt.utils.HexUtil;
import java.nio.charset.Charset;

/* compiled from: P */
/* loaded from: classes2.dex */
public class n {

    /* renamed from: a, reason: collision with root package name */
    public static final Charset f37185a = Charset.forName("UTF-8");

    public static Pair<byte[], String> a(String str) {
        if (str == null || str.length() < 32) {
            return new Pair<>(new byte[0], str);
        }
        String substring = str.substring(0, 32);
        return new Pair<>(HexUtil.hexStr2ByteArray(substring), str.substring(32));
    }

    public static String b(String str, String str2) {
        return HexUtil.byteArray2HexStr(AesCbc.encrypt(str.getBytes(f37185a), HexUtil.hexStr2ByteArray(str2)));
    }

    public static String a(String str, String str2) {
        Pair<byte[], String> a16 = a(str);
        return new String(AesCbc.decrypt(HexUtil.hexStr2ByteArray((String) a16.second), HexUtil.hexStr2ByteArray(str2), (byte[]) a16.first), f37185a);
    }

    public static String a(byte[] bArr, String str) {
        String str2;
        if (bArr == null || bArr.length == 0 || str == null) {
            str2 = "cbc encrypt(byte) param is not right";
        } else {
            byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
            if (hexStr2ByteArray.length >= 16) {
                return HexUtil.byteArray2HexStr(AesCbc.encrypt(bArr, hexStr2ByteArray));
            }
            str2 = "key length is not right";
        }
        v.b("AesCipher", str2);
        return "";
    }
}
