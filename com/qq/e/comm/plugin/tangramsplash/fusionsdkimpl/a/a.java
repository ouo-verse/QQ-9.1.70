package com.qq.e.comm.plugin.tangramsplash.fusionsdkimpl.a;

import com.qq.e.comm.plugin.base.ad.model.r;
import com.tencent.ams.fusion.service.resdownload.d;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends com.qq.e.comm.plugin.i.a {

    /* renamed from: a, reason: collision with root package name */
    private final d f40003a;

    /* renamed from: b, reason: collision with root package name */
    private final r f40004b;

    public a(d dVar, r rVar) {
        this.f40003a = dVar;
        this.f40004b = rVar;
    }

    @Override // com.qq.e.comm.plugin.i.a
    public void a(boolean z16) {
        d dVar = this.f40003a;
        if (dVar != null && this.f40004b != null && dVar.e() == 3) {
            c.a(this.f40003a, this.f40004b);
        }
        super.a(z16);
    }

    @Override // com.qq.e.comm.plugin.i.a, com.tencent.ams.fusion.service.resdownload.a
    public void e() {
        d dVar = this.f40003a;
        if (dVar != null && this.f40004b != null && dVar.e() == 3) {
            c.a(this.f40003a, this.f40004b);
        }
        super.e();
    }
}
