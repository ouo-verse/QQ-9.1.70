package com.huawei.hms.push;

import com.tencent.mobileqq.text.EmotcationConstants;

/* compiled from: P */
/* loaded from: classes2.dex */
public abstract class w {

    /* renamed from: a, reason: collision with root package name */
    public static final char[] f37491a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', EmotcationConstants.SYS_EMOTCATION_MODULO_OFFSET, 'B', 'C', 'D', 'E', 'F'};

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        return new String(bArr, x.f37492a);
    }
}
