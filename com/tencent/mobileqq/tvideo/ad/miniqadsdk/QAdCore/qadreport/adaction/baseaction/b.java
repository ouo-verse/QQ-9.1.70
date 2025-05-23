package com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction;

import android.content.Context;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.d;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.core.g;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class b {

    /* renamed from: a, reason: collision with root package name */
    protected wv2.a f303963a;

    /* renamed from: b, reason: collision with root package name */
    protected Context f303964b;

    /* renamed from: c, reason: collision with root package name */
    protected volatile a f303965c;

    /* renamed from: d, reason: collision with root package name */
    protected Map<String, Object> f303966d = new HashMap();

    /* renamed from: e, reason: collision with root package name */
    protected Map<String, String> f303967e = new HashMap();

    /* renamed from: f, reason: collision with root package name */
    protected boolean f303968f;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
        void a(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a aVar);
    }

    public b(Context context, wv2.a aVar) {
        this.f303964b = null;
        this.f303963a = aVar;
        this.f303964b = context;
        j(aVar.f446587w);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(d dVar, g gVar) {
        wv2.a aVar;
        if (dVar != null && (aVar = this.f303963a) != null && aVar.f446590z) {
            dVar.t(gVar);
        }
    }

    public abstract void c(d dVar, g gVar);

    public wv2.a d() {
        return this.f303963a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    public void e(d dVar, g gVar) {
        dw2.a aVar = new dw2.a(this.f303964b, this.f303963a);
        if (dVar instanceof ew2.b) {
            ((ew2.b) dVar).a(2);
        }
        aVar.k(this.f303968f);
        aVar.i(this.f303965c);
        aVar.c(dVar, gVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(String str, String str2) {
        dw2.a aVar = new dw2.a(this.f303964b, this.f303963a);
        aVar.k(this.f303968f);
        aVar.i(this.f303965c);
        aVar.l(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(int i3) {
        h(i3, null);
    }

    public void h(int i3, Object obj) {
        com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a c16 = com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadreport.adaction.baseaction.a.c(i3, obj);
        a aVar = this.f303965c;
        if (aVar != null) {
            aVar.a(c16);
        }
    }

    public void i(a aVar) {
        this.f303965c = aVar;
    }

    public void j(Map<String, String> map) {
        this.f303967e = map;
    }

    public void k(boolean z16) {
        this.f303968f = z16;
    }

    public void a(d dVar) {
    }
}
