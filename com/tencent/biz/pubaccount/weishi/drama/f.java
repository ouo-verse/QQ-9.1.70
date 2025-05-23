package com.tencent.biz.pubaccount.weishi.drama;

import com.tencent.biz.pubaccount.weishi.player.l;
import com.tencent.biz.pubaccount.weishi.util.x;
import mqq.util.WeakReference;

/* compiled from: P */
/* loaded from: classes32.dex */
public class f implements com.tencent.biz.pubaccount.weishi.player.f {

    /* renamed from: a, reason: collision with root package name */
    private WeakReference<c> f80689a;

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void a(com.tencent.biz.pubaccount.weishi.player.e eVar, boolean z16) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSDramaPlayerStatusListenerImpl.java][onVideoStop] title:");
        l lVar = eVar.f81127c;
        if (lVar != null) {
            str = lVar.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.j("WSDramaPlayerStatusListenerImpl", sb5.toString());
        c cVar = this.f80689a.get();
        if (cVar != null) {
            vz.a.m(cVar, eVar, z16);
            cVar.a(eVar, z16);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void e(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSDramaPlayerStatusListenerImpl.java][onVideoStart] title:");
        l lVar = eVar.f81127c;
        if (lVar != null) {
            str = lVar.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.j("WSDramaPlayerStatusListenerImpl", sb5.toString());
        c cVar = this.f80689a.get();
        if (cVar != null) {
            vz.a.l(cVar, eVar, cVar.X());
            cVar.d(eVar);
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void h(com.tencent.biz.pubaccount.weishi.player.e eVar) {
        String str;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("[WSDramaPlayerStatusListenerImpl.java][onCompletion] title:");
        l lVar = eVar.f81127c;
        if (lVar != null) {
            str = lVar.f81175j;
        } else {
            str = "";
        }
        sb5.append(str);
        x.j("WSDramaPlayerStatusListenerImpl", sb5.toString());
        c cVar = this.f80689a.get();
        if (cVar != null) {
            vz.a.m(cVar, eVar, true);
            cVar.S0(eVar);
        }
    }

    public void j(c cVar) {
        this.f80689a = new WeakReference<>(cVar);
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void b(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void d(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void f(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void i(com.tencent.biz.pubaccount.weishi.player.e eVar) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void g(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3) {
    }

    @Override // com.tencent.biz.pubaccount.weishi.player.f
    public void c(com.tencent.biz.pubaccount.weishi.player.e eVar, int i3, int i16, String str) {
    }
}
