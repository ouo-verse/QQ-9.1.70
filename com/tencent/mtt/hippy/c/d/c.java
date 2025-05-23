package com.tencent.mtt.hippy.c.d;

import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private final List<a> f337158a = new ArrayList();

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(a aVar) {
        this.f337158a.add(aVar);
        return this.f337158a.size() - 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a(int i3) {
        return this.f337158a.get(i3);
    }
}
