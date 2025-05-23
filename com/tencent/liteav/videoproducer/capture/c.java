package com.tencent.liteav.videoproducer.capture;

import com.tencent.liteav.base.util.Size;
import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class c implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final c f119642a = new c();

    c() {
    }

    public static Comparator a() {
        return f119642a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ((Size) obj2).getArea() - ((Size) obj).getArea();
    }
}
