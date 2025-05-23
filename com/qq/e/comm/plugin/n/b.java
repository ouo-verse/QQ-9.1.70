package com.qq.e.comm.plugin.n;

import com.qq.e.comm.pi.WRI;

/* compiled from: P */
/* loaded from: classes3.dex */
public class b implements WRI {

    /* renamed from: a, reason: collision with root package name */
    private final com.qq.e.comm.plugin.n.a.a f39694a;

    public b(String str, long j3) {
        this.f39694a = new com.qq.e.comm.plugin.n.a.a(str, j3);
    }

    @Override // com.qq.e.comm.pi.WRI
    public void report(String str, int i3) {
        this.f39694a.a(str, i3);
    }
}
