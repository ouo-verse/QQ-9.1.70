package com.tencent.luggage.wxa.tn;

import com.tencent.soter.core.keystore.KeyPropertiesCompact;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class y {

    /* renamed from: a, reason: collision with root package name */
    public static char[] f141765a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b, reason: collision with root package name */
    public static ThreadLocal f141766b = new a();

    /* compiled from: P */
    /* loaded from: classes8.dex */
    public class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public MessageDigest initialValue() {
            try {
                return MessageDigest.getInstance(KeyPropertiesCompact.DIGEST_MD5);
            } catch (NoSuchAlgorithmException e16) {
                throw new RuntimeException("Initialize MD5 failed.", e16);
            }
        }
    }

    public static String a(String str) {
        return b(str.getBytes());
    }

    public static String b(byte[] bArr) {
        return a(((MessageDigest) f141766b.get()).digest(bArr));
    }

    public static String a(byte[] bArr) {
        return a(bArr, 0, bArr.length);
    }

    public static String a(byte[] bArr, int i3, int i16) {
        StringBuffer stringBuffer = new StringBuffer(i16 * 2);
        int i17 = i16 + i3;
        while (i3 < i17) {
            a(bArr[i3], stringBuffer);
            i3++;
        }
        return stringBuffer.toString();
    }

    public static void a(byte b16, StringBuffer stringBuffer) {
        char[] cArr = f141765a;
        char c16 = cArr[(b16 & 240) >> 4];
        char c17 = cArr[b16 & RegisterType.DOUBLE_HI];
        stringBuffer.append(c16);
        stringBuffer.append(c17);
    }
}
