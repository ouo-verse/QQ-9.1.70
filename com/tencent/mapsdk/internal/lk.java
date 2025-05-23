package com.tencent.mapsdk.internal;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class lk {

    /* renamed from: a, reason: collision with root package name */
    public static final int f149199a = 1;

    /* renamed from: b, reason: collision with root package name */
    public static final int f149200b = 0;

    /* renamed from: c, reason: collision with root package name */
    public final Rect f149201c = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public int[] f149202d;

    /* renamed from: e, reason: collision with root package name */
    public int[] f149203e;

    /* renamed from: f, reason: collision with root package name */
    public int[] f149204f;

    private static void a(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = byteBuffer.getInt();
        }
    }

    private static void a(int i3) {
        if (i3 == 0 || (i3 & 1) != 0) {
            throw new RuntimeException("invalid nine-patch: ".concat(String.valueOf(i3)));
        }
    }

    private static lk a(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        lk lkVar = new lk();
        lkVar.f149202d = new int[order.get()];
        lkVar.f149203e = new int[order.get()];
        lkVar.f149204f = new int[order.get()];
        a(lkVar.f149202d.length);
        a(lkVar.f149203e.length);
        order.getInt();
        order.getInt();
        lkVar.f149201c.left = order.getInt();
        lkVar.f149201c.right = order.getInt();
        lkVar.f149201c.top = order.getInt();
        lkVar.f149201c.bottom = order.getInt();
        order.getInt();
        a(lkVar.f149202d, order);
        a(lkVar.f149203e, order);
        a(lkVar.f149204f, order);
        return lkVar;
    }
}
