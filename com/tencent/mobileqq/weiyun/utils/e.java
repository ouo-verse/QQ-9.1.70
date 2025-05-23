package com.tencent.mobileqq.weiyun.utils;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.weiyun.utils.Utils;

/* compiled from: P */
/* loaded from: classes20.dex */
public class e {
    static IPatchRedirector $redirector_;

    public static String a(ByteStringMicro byteStringMicro) {
        return Utils.bytes2HexStr(byteStringMicro.toByteArray());
    }

    public static ByteStringMicro b(String str) {
        return ByteStringMicro.copyFrom(Utils.hexStr2Bytes(str));
    }

    public static byte[] c(String str) {
        int length = str.length();
        byte[] bArr = new byte[length / 2];
        for (int i3 = 0; i3 < length; i3 += 2) {
            bArr[i3 / 2] = (byte) ((Character.digit(str.charAt(i3), 16) << 4) + Character.digit(str.charAt(i3 + 1), 16));
        }
        return bArr;
    }
}
