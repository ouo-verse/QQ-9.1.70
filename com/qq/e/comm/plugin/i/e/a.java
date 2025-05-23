package com.qq.e.comm.plugin.i.e;

import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.f;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.i.i;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
abstract class a {

    /* renamed from: a, reason: collision with root package name */
    protected final h f39526a;

    /* renamed from: b, reason: collision with root package name */
    protected final com.qq.e.comm.plugin.i.c f39527b;

    /* renamed from: c, reason: collision with root package name */
    protected long f39528c;

    /* renamed from: d, reason: collision with root package name */
    protected e f39529d;

    /* renamed from: e, reason: collision with root package name */
    protected com.qq.e.comm.plugin.i.b.a f39530e;

    /* renamed from: f, reason: collision with root package name */
    protected b.a f39531f;

    /* renamed from: g, reason: collision with root package name */
    protected String f39532g;

    /* renamed from: h, reason: collision with root package name */
    protected final long f39533h = com.qq.e.comm.plugin.j.c.a("minPartialDownloadSize", 2097152);

    public a(e eVar, com.qq.e.comm.plugin.i.b.a aVar, b.a aVar2, h hVar, com.qq.e.comm.plugin.i.c cVar) {
        this.f39528c = eVar.d();
        this.f39529d = eVar;
        this.f39530e = aVar;
        this.f39531f = aVar2;
        this.f39526a = hVar;
        this.f39532g = f.a(hVar.c());
        this.f39527b = cVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public List<i> a(long j3) {
        com.qq.e.comm.plugin.i.b.a aVar;
        if (this.f39526a == null || (aVar = this.f39530e) == null || this.f39527b == null) {
            return null;
        }
        List<i> a16 = aVar.a(this.f39532g);
        if (a16.isEmpty()) {
            int a17 = this.f39527b.a();
            int i3 = 0;
            while (i3 < a17) {
                long j16 = j3 / a17;
                long j17 = j16 * i3;
                a16.add(new i(i3, this.f39532g, this.f39526a.c(), j17, i3 == a17 + (-1) ? j3 : (j16 + j17) - 1, 0L));
                i3++;
            }
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public i a(long j3, long j16) {
        h hVar = this.f39526a;
        if (hVar == null) {
            return null;
        }
        i iVar = new i(0, this.f39532g, hVar.c());
        iVar.c(j3);
        iVar.a(j16);
        return iVar;
    }
}
