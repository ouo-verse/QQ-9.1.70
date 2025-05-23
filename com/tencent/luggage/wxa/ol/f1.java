package com.tencent.luggage.wxa.ol;

import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class f1 {
    public static final String a() {
        String h16 = com.tencent.luggage.wxa.db.a.h();
        com.tencent.luggage.wxa.cp.x.m(h16);
        return com.tencent.luggage.wxa.cp.x.b(h16, true);
    }

    public static final byte[] a(ByteBuffer byteBuffer) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        byte[] bArr = new byte[byteBuffer.remaining()];
        byteBuffer.get(bArr);
        return bArr;
    }
}
