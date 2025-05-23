package com.tencent.gamecenter.wadl.sdk.common.d;

import cooperation.qqcircle.report.datong.QCircleDaTongConstant;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes6.dex */
public class h implements com.tencent.gamecenter.wadl.sdk.common.d.a, com.tencent.gamecenter.wadl.sdk.common.d.c {

    /* renamed from: e, reason: collision with root package name */
    private static h f107123e = new h();

    /* renamed from: b, reason: collision with root package name */
    private d f107125b;

    /* renamed from: a, reason: collision with root package name */
    private Map<String, com.tencent.gamecenter.wadl.sdk.common.d.j.a> f107124a = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private Runnable f107126c = new b();

    /* renamed from: d, reason: collision with root package name */
    private Runnable f107127d = new c();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class a implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f107128d;

        a(int i3) {
            this.f107128d = i3;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.tencent.gamecenter.wadl.sdk.common.e.b.a("Wadl-cloud-PlatformMgr", "onHttpUsed:" + this.f107128d);
            h.this.f107125b.a(this.f107128d);
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes6.dex */
    class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.b();
        }
    }

    h() {
        a(new com.tencent.gamecenter.wadl.sdk.common.d.j.c());
        a(new com.tencent.gamecenter.wadl.sdk.common.d.j.b());
        a(new com.tencent.gamecenter.wadl.sdk.common.d.j.d.a());
        a(this.f107126c, 30000L);
        a(this.f107127d, 30000L);
    }

    public static h e() {
        return f107123e;
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void b() {
        this.f107125b.b();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void c() {
        this.f107125b.c();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.c
    public void d() {
        Iterator<com.tencent.gamecenter.wadl.sdk.common.d.j.a> it = this.f107124a.values().iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    public e f() {
        return (e) this.f107124a.get("accessscheduler");
    }

    public f g() {
        return (f) this.f107124a.get(QCircleDaTongConstant.ElementParamValue.SETTINGS);
    }

    public void a() {
        g e16 = g.e();
        this.f107125b = e16;
        e16.a(this);
        this.f107125b.a();
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.a
    public void a(int i3) {
        com.tencent.gamecenter.wadl.sdk.common.a.g().post(new a(i3));
    }

    private void a(com.tencent.gamecenter.wadl.sdk.common.d.j.a aVar) {
        this.f107124a.put(aVar.c(), aVar);
    }

    private void a(Runnable runnable, long j3) {
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, String str2) {
        a(this.f107126c, com.tencent.gamecenter.wadl.sdk.common.b.g.a("app_ipc_timertask_gap", 0, 3600000, 60000));
        Iterator<com.tencent.gamecenter.wadl.sdk.common.d.j.a> it = this.f107124a.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, str2);
        }
    }

    @Override // com.tencent.gamecenter.wadl.sdk.common.d.b
    public void a(String str, byte[] bArr, String str2) {
        a(this.f107127d, com.tencent.gamecenter.wadl.sdk.common.b.g.a("app_ipc_timertask_gap", 0, 3600000, 60000));
        Iterator<com.tencent.gamecenter.wadl.sdk.common.d.j.a> it = this.f107124a.values().iterator();
        while (it.hasNext()) {
            it.next().a(str, bArr, str2);
        }
    }
}
