package com.tencent.luggage.wxa.qm;

import com.tencent.luggage.wxa.tn.w;
import java.net.URL;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class h implements b {

    /* renamed from: a, reason: collision with root package name */
    public com.tencent.luggage.wxa.rb.d f138939a;

    @Override // com.tencent.luggage.wxa.qm.b
    public String a(String str) {
        return str;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void b(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void c(com.tencent.luggage.wxa.rb.d dVar) {
        this.f138939a = dVar;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void f(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public boolean g(com.tencent.luggage.wxa.rb.d dVar) {
        this.f138939a = dVar;
        return true;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void h(com.tencent.luggage.wxa.rb.d dVar) {
        com.tencent.luggage.wxa.rb.d dVar2 = this.f138939a;
        if (dVar2 != null && dVar2.a(dVar)) {
            this.f138939a.c(dVar);
        } else {
            this.f138939a = dVar;
        }
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public URL b(String str) {
        return new URL(str);
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public com.tencent.luggage.wxa.rb.d c() {
        return this.f138939a;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public boolean f(int i3) {
        return true;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void a(com.tencent.luggage.wxa.rb.d dVar, int i3) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public boolean b() {
        return k.g().b();
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void a(List list, boolean z16) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public boolean a(int i3) {
        return false;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public com.tencent.luggage.wxa.rb.d a(List list, int i3) {
        if (list != null && list.size() != 0 && i3 < list.size()) {
            this.f138939a = (com.tencent.luggage.wxa.rb.d) list.get(i3);
            w.d("MicroMsg.Music.MusicBaseLogic", "startPlayNewMusicList:%d", Integer.valueOf(i3));
            return this.f138939a;
        }
        w.d("MicroMsg.Music.MusicBaseLogic", "music wrapper list error");
        return null;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void a() {
        k.g().a();
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void d(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void e(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public com.tencent.luggage.wxa.rb.d i(com.tencent.luggage.wxa.rb.d dVar) {
        return dVar;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void j(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void k(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void l(com.tencent.luggage.wxa.rb.d dVar) {
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public com.tencent.luggage.wxa.rb.d m(com.tencent.luggage.wxa.rb.d dVar) {
        return dVar;
    }

    @Override // com.tencent.luggage.wxa.qm.b
    public void n(com.tencent.luggage.wxa.rb.d dVar) {
    }
}
