package com.tencent.rdelivery.reshub.util.zip;

import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
public abstract class b implements d<File> {

    /* renamed from: c, reason: collision with root package name */
    private static long f364610c = 100;

    /* renamed from: a, reason: collision with root package name */
    private long f364611a;

    /* renamed from: b, reason: collision with root package name */
    private long f364612b;

    public b(long j3, long j16) {
        long j17 = f364610c;
        this.f364611a = j3 < j17 ? j17 : j3;
        this.f364612b = j16;
    }

    protected abstract void b(e eVar, File file);

    @Override // com.tencent.rdelivery.reshub.util.zip.d
    /* renamed from: c, reason: merged with bridge method [inline-methods] */
    public final void a(e eVar, File file, long j3) {
        if (j3 > this.f364611a) {
            eVar.pause(this.f364612b);
        }
        b(eVar, file);
    }
}
