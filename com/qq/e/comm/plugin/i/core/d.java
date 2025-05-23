package com.qq.e.comm.plugin.i.core;

import android.text.TextUtils;
import com.qq.e.comm.managers.thread.GdtSDKThreadManager;
import com.qq.e.comm.plugin.i.d.a;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.d.c;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.h;
import com.qq.e.comm.plugin.k.g;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.oskplayer.cache.FileDataSink;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: P */
/* loaded from: classes3.dex */
public class d implements a.InterfaceC0286a, b.a, c {

    /* renamed from: a, reason: collision with root package name */
    private h f39477a;

    /* renamed from: b, reason: collision with root package name */
    private com.qq.e.comm.plugin.i.b.a f39478b;

    /* renamed from: c, reason: collision with root package name */
    private String f39479c;

    /* renamed from: d, reason: collision with root package name */
    private com.qq.e.comm.plugin.i.c f39480d;

    /* renamed from: e, reason: collision with root package name */
    private c.a f39481e;

    /* renamed from: f, reason: collision with root package name */
    private List<com.qq.e.comm.plugin.i.a> f39482f;

    /* renamed from: g, reason: collision with root package name */
    private int f39483g;

    /* renamed from: h, reason: collision with root package name */
    private com.qq.e.comm.plugin.i.d f39484h;

    /* renamed from: i, reason: collision with root package name */
    private e f39485i;

    /* renamed from: j, reason: collision with root package name */
    private a f39486j;

    /* renamed from: k, reason: collision with root package name */
    private List<b> f39487k;

    public d(h hVar, com.qq.e.comm.plugin.i.b.a aVar, String str, com.qq.e.comm.plugin.i.c cVar, c.a aVar2, com.qq.e.comm.plugin.i.a aVar3) {
        this.f39477a = hVar;
        this.f39478b = aVar;
        this.f39479c = str;
        this.f39480d = cVar;
        this.f39481e = aVar2;
        n();
        if (!this.f39482f.contains(aVar3)) {
            this.f39482f.add(aVar3);
        }
    }

    private void A() {
        this.f39478b.b(this.f39479c);
    }

    private void B() {
        com.qq.e.comm.plugin.i.c cVar = this.f39480d;
        if (cVar != null && cVar.e() != null) {
            GDTLogger.d("DownloaderImpldo clean task");
            e eVar = this.f39485i;
            if (eVar != null && eVar.b() != null && !TextUtils.isEmpty(this.f39485i.a())) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(new File(this.f39485i.b(), this.f39485i.a()));
                cVar.e().a(arrayList);
            }
            b a16 = com.qq.e.comm.plugin.i.c.a.a(cVar.e());
            if (a16 != null) {
                GdtSDKThreadManager.getInstance().runOnThread(2, a16);
            } else {
                GDTLogger.d("DownloaderImpldo clean task : can't get cleanTask");
            }
        }
    }

    private void n() {
        this.f39485i = new e(this.f39477a.b(), this.f39477a.c(), this.f39477a.a());
        this.f39487k = new CopyOnWriteArrayList();
        this.f39482f = new CopyOnWriteArrayList();
    }

    private boolean o() {
        for (b bVar : this.f39487k) {
            if (bVar instanceof f) {
                f fVar = (f) bVar;
                if (fVar.m()) {
                    GDTLogger.d("DownloaderImpl partFile exist finished :" + fVar.h().b());
                    GDTLogger.d("DownloaderImpl partFile exist end :" + fVar.h().a());
                    while (true) {
                        fVar = fVar.k();
                        if (fVar != null) {
                            if (fVar.n()) {
                                GDTLogger.d("DownloaderImpl execute PartialDownloadTask download :" + fVar.h());
                                GdtSDKThreadManager.getInstance().runOnThread(2, fVar);
                            }
                        } else {
                            return true;
                        }
                    }
                } else {
                    if (fVar.n()) {
                        GDTLogger.d("DownloaderImpl execute PartialDownloadTask download :" + fVar.h());
                        GdtSDKThreadManager.getInstance().runOnThread(2, fVar);
                        return true;
                    }
                    GDTLogger.d("DownloaderImpl can not execute PartialDownloadTask :" + fVar.h().b());
                    return true;
                }
            }
        }
        return false;
    }

    private void p() {
        try {
            h hVar = this.f39477a;
            if (hVar != null && this.f39480d != null) {
                this.f39486j = new a(hVar.c(), this, this.f39480d.c(), this.f39480d.d(), this.f39477a.d());
                GdtSDKThreadManager.getInstance().runOnThread(2, this.f39486j);
                return;
            }
            GDTLogger.e("\u65b0\u5efa\u4e0b\u8f7d\u4efb\u52a1\uff1a\u4f20\u5165downloadConfig or request is null");
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }

    private void q() {
        r();
        Iterator<b> it = this.f39487k.iterator();
        while (it.hasNext()) {
            GdtSDKThreadManager.getInstance().runOnThread(2, it.next());
        }
    }

    private void r() {
        this.f39487k.clear();
        List<b> a16 = com.qq.e.comm.plugin.i.c.b.a(this.f39485i, this.f39478b, this, this.f39477a, this.f39480d);
        if (g.a(a16)) {
            this.f39487k.addAll(a16);
        }
    }

    private void s() {
        for (com.qq.e.comm.plugin.i.a aVar : this.f39482f) {
            if (aVar != null) {
                b(aVar);
            }
        }
        c.a aVar2 = this.f39481e;
        if (aVar2 != null) {
            aVar2.a(this.f39483g, this.f39477a, this.f39485i, this.f39484h);
        }
    }

    private boolean t() {
        return new File(this.f39485i.b(), this.f39485i.a() + FileDataSink.TEMP_FILE).renameTo(new File(this.f39485i.b(), this.f39485i.a()));
    }

    private boolean u() {
        return new File(this.f39485i.b(), this.f39485i.a() + ".part").renameTo(new File(this.f39485i.b(), this.f39485i.a()));
    }

    private boolean v() {
        boolean z16 = true;
        for (b bVar : this.f39487k) {
            if (bVar instanceof f) {
                f fVar = (f) bVar;
                do {
                    if (z16 && fVar.l()) {
                        z16 = true;
                    } else {
                        z16 = false;
                    }
                    fVar = fVar.k();
                } while (fVar != null);
            }
        }
        return z16;
    }

    private boolean w() {
        for (b bVar : this.f39487k) {
            if (bVar != null && !bVar.c()) {
                return false;
            }
        }
        return true;
    }

    private boolean x() {
        for (b bVar : this.f39487k) {
            if (bVar != null && bVar.d()) {
                return true;
            }
        }
        return false;
    }

    private boolean y() {
        for (b bVar : this.f39487k) {
            if (bVar != null && bVar.b()) {
                return false;
            }
        }
        return true;
    }

    private boolean z() {
        for (b bVar : this.f39487k) {
            if (bVar != null && bVar.b()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.i.d.c
    public boolean a() {
        int i3 = this.f39483g;
        return i3 == 101 || i3 == 102 || i3 == 103 || i3 == 104;
    }

    public boolean b() {
        return this.f39483g == 105;
    }

    public boolean c() {
        if (this.f39483g == 109) {
            return true;
        }
        return false;
    }

    public boolean d() {
        boolean z16 = true;
        if (!e() && !c()) {
            if (a() || b()) {
                z16 = false;
            }
            GDTLogger.d("DownloaderImpl can start " + z16 + " status :" + this.f39483g);
            return z16;
        }
        GDTLogger.d("DownloaderImpl can start status :" + this.f39483g);
        return true;
    }

    public boolean e() {
        for (b bVar : this.f39487k) {
            if (bVar instanceof f) {
                f fVar = (f) bVar;
                while (fVar.l()) {
                    fVar = fVar.k();
                    if (fVar == null) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    @Override // com.qq.e.comm.plugin.i.d.c
    public void f() {
        GDTLogger.d("DownloaderImpl start download :" + this.f39483g);
        if (o()) {
            return;
        }
        this.f39483g = 101;
        s();
        p();
    }

    @Override // com.qq.e.comm.plugin.i.d.c
    public void g() {
        a aVar = this.f39486j;
        if (aVar != null) {
            aVar.a();
        }
        Iterator<b> it = this.f39487k.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public void h() {
        this.f39481e.a(this.f39479c, this);
    }

    @Override // com.qq.e.comm.plugin.i.d.a.InterfaceC0286a
    public void i() {
        this.f39483g = 102;
        s();
    }

    @Override // com.qq.e.comm.plugin.i.d.a.InterfaceC0286a
    public void j() {
        this.f39483g = 107;
        s();
        h();
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void k() {
        if (w() && t()) {
            GDTLogger.d("DownloaderImpl onDownloadCompleted:" + this.f39477a.c());
            A();
            this.f39483g = 105;
            s();
            h();
            B();
        }
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void l() {
        if (y()) {
            this.f39483g = 106;
            s();
            h();
        }
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void m() {
        if (z()) {
            A();
            this.f39483g = 107;
            s();
            h();
        }
    }

    @Override // com.qq.e.comm.plugin.i.d.a.InterfaceC0286a
    public void a(long j3, boolean z16) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append("DownloaderImpl onConnected:");
        h hVar = this.f39477a;
        sb5.append(hVar != null ? hVar.c() : "");
        GDTLogger.d(sb5.toString());
        this.f39483g = 103;
        this.f39485i.a(z16);
        this.f39485i.a(j3);
        s();
        q();
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void b(com.qq.e.comm.plugin.i.d dVar) {
        if (x()) {
            GDTLogger.e("DownloaderImpl onDownloadFailed :" + dVar);
            this.f39483g = 108;
            this.f39484h = dVar;
            s();
            h();
        }
    }

    private void b(com.qq.e.comm.plugin.i.a aVar) {
        switch (this.f39483g) {
            case 101:
                aVar.a();
                return;
            case 102:
                aVar.b();
                return;
            case 103:
                aVar.a(this.f39485i.d(), this.f39485i.f());
                return;
            case 104:
                aVar.a(this.f39485i.e(), this.f39485i.d(), this.f39485i.c());
                return;
            case 105:
                aVar.a(false);
                return;
            case 106:
                aVar.c();
                return;
            case 107:
                aVar.b(false);
                return;
            case 108:
                aVar.a(this.f39484h, false);
                return;
            default:
                return;
        }
    }

    @Override // com.qq.e.comm.plugin.i.d.a.InterfaceC0286a
    public void a(com.qq.e.comm.plugin.i.d dVar) {
        this.f39483g = 108;
        this.f39484h = dVar;
        s();
        h();
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void a(long j3, long j16) {
        this.f39483g = 104;
        this.f39485i.b(j3);
        this.f39485i.a(j16);
        this.f39485i.a((int) ((100 * j3) / j16));
        s();
    }

    @Override // com.qq.e.comm.plugin.i.d.b.a
    public void a(long j3) {
        if (v() && u()) {
            GDTLogger.d("DownloaderImpl RealComplete :" + this.f39477a.c());
            this.f39483g = 105;
        } else {
            this.f39483g = 109;
        }
        s();
        if (this.f39483g == 105) {
            h();
        }
    }

    public void a(com.qq.e.comm.plugin.i.a aVar) {
        if (this.f39482f.contains(aVar)) {
            return;
        }
        this.f39482f.add(aVar);
    }
}
