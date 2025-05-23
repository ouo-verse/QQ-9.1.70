package com.tencent.bugly.proguard;

import com.tencent.mobileqq.text.EmotcationConstants;
import org.jf.dexlib2.analysis.RegisterType;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class f {

    /* renamed from: b, reason: collision with root package name */
    private static final char[] f98502b = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a, reason: collision with root package name */
    public static final byte[] f98501a = new byte[0];

    public static String a(byte[] bArr) {
        if (bArr != null && bArr.length != 0) {
            char[] cArr = new char[bArr.length * 2];
            for (int i3 = 0; i3 < bArr.length; i3++) {
                byte b16 = bArr[i3];
                int i16 = i3 * 2;
                char[] cArr2 = f98502b;
                cArr[i16 + 1] = cArr2[b16 & RegisterType.DOUBLE_HI];
                cArr[i16 + 0] = cArr2[((byte) (b16 >>> 4)) & RegisterType.DOUBLE_HI];
            }
            return new String(cArr);
        }
        return null;
    }
}
