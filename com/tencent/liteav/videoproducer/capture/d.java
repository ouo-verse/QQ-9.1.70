package com.tencent.liteav.videoproducer.capture;

import java.util.Comparator;

/* compiled from: P */
/* loaded from: classes7.dex */
final /* synthetic */ class d implements Comparator {

    /* renamed from: a, reason: collision with root package name */
    private static final d f119643a = new d();

    d() {
    }

    public static Comparator a() {
        return f119643a;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        com.tencent.liteav.videoproducer.a.a aVar = (com.tencent.liteav.videoproducer.a.a) obj;
        com.tencent.liteav.videoproducer.a.a aVar2 = (com.tencent.liteav.videoproducer.a.a) obj2;
        int i3 = aVar.f119572a;
        int i16 = aVar2.f119572a;
        if (i3 < i16) {
            return -1;
        }
        if (i3 == i16) {
            return aVar.f119573b - aVar2.f119573b;
        }
        return 1;
    }
}
