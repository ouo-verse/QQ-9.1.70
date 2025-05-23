package com.tencent.biz;

import android.graphics.Rect;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

/* compiled from: P */
/* loaded from: classes2.dex */
public class l {

    /* renamed from: a, reason: collision with root package name */
    public int[] f78567a;

    /* renamed from: b, reason: collision with root package name */
    public int[] f78568b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f78569c;

    /* renamed from: d, reason: collision with root package name */
    public Rect f78570d = new Rect();

    private static boolean a(int i3) {
        if (i3 != 0 && (i3 & 1) == 0) {
            return true;
        }
        return false;
    }

    public static l b(byte[] bArr) {
        ByteBuffer order = ByteBuffer.wrap(bArr).order(ByteOrder.nativeOrder());
        if (order.get() == 0) {
            return null;
        }
        l lVar = new l();
        lVar.f78568b = new int[order.get()];
        lVar.f78569c = new int[order.get()];
        lVar.f78567a = new int[order.get()];
        if (!a(lVar.f78568b.length) || !a(lVar.f78569c.length)) {
            return null;
        }
        order.getInt();
        order.getInt();
        lVar.f78570d.left = order.getInt();
        lVar.f78570d.right = order.getInt();
        lVar.f78570d.top = order.getInt();
        lVar.f78570d.bottom = order.getInt();
        order.getInt();
        c(lVar.f78568b, order);
        c(lVar.f78569c, order);
        c(lVar.f78567a, order);
        return lVar;
    }

    private static void c(int[] iArr, ByteBuffer byteBuffer) {
        int length = iArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = byteBuffer.getInt();
        }
    }
}
