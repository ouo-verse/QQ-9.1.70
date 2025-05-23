package com.tencent.qqnt.shortvideo;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length > 0) {
            StringBuilder sb5 = new StringBuilder();
            for (byte b16 : bArr) {
                sb5.append(String.format("%02X", Byte.valueOf(b16)));
            }
            return sb5.toString();
        }
        return "";
    }
}
