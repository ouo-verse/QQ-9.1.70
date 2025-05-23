package com.xiaomi.push;

import java.io.ByteArrayOutputStream;

/* compiled from: P */
/* loaded from: classes28.dex */
public class fz {

    /* renamed from: a, reason: collision with root package name */
    private final ByteArrayOutputStream f388934a;

    /* renamed from: b, reason: collision with root package name */
    private final ht f388935b;

    /* renamed from: c, reason: collision with root package name */
    private hn f388936c;

    public fz(ic icVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.f388934a = byteArrayOutputStream;
        ht htVar = new ht(byteArrayOutputStream);
        this.f388935b = htVar;
        this.f388936c = icVar.a(htVar);
    }

    public byte[] a(hq hqVar) {
        this.f388934a.reset();
        hqVar.b(this.f388936c);
        return this.f388934a.toByteArray();
    }
}
