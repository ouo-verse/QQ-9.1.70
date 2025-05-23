package com.tencent.luggage.wxa.rm;

import android.os.Looper;
import androidx.core.content.ContextCompat;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.luggage.wxa.p9.h;
import com.tencent.luggage.wxa.sm.d;
import com.tencent.luggage.wxa.tn.i0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.tn.z;
import java.util.Iterator;
import java.util.LinkedList;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class a implements com.tencent.luggage.wxa.sm.d {

    /* renamed from: w, reason: collision with root package name */
    private static final String f139828w = "MicroMsg.Music.BaseMusicPlayer";

    /* renamed from: k, reason: collision with root package name */
    protected boolean f139829k;

    /* renamed from: m, reason: collision with root package name */
    private boolean f139831m;

    /* renamed from: n, reason: collision with root package name */
    protected com.tencent.luggage.wxa.qm.e f139832n;

    /* renamed from: o, reason: collision with root package name */
    protected com.tencent.luggage.wxa.qm.b f139833o;

    /* renamed from: u, reason: collision with root package name */
    protected d.a f139839u;

    /* renamed from: l, reason: collision with root package name */
    protected String f139830l = "";

    /* renamed from: p, reason: collision with root package name */
    protected long f139834p = 0;

    /* renamed from: q, reason: collision with root package name */
    protected long f139835q = 0;

    /* renamed from: r, reason: collision with root package name */
    protected long f139836r = 0;

    /* renamed from: s, reason: collision with root package name */
    protected long f139837s = 0;

    /* renamed from: t, reason: collision with root package name */
    private final i0.b[] f139838t = {null};

    /* renamed from: v, reason: collision with root package name */
    protected LinkedList<d.a> f139840v = new LinkedList<>();

    /* compiled from: P */
    /* renamed from: com.tencent.luggage.wxa.rm.a$a, reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C6690a implements i0.b {
        public C6690a() {
        }

        @Override // com.tencent.luggage.wxa.tn.i0.b
        public void a(int i3) {
            if (i3 != 0) {
                if ((i3 == 1 || i3 == 2) && a.this.i()) {
                    a aVar = a.this;
                    aVar.f139829k = true;
                    aVar.pause();
                    return;
                }
                return;
            }
            a aVar2 = a.this;
            if (aVar2.f139829k) {
                aVar2.f139829k = false;
                aVar2.a();
            }
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.qb.b bVar) {
    }

    public void b(com.tencent.luggage.wxa.rb.d dVar) {
        String str;
        Object[] objArr = new Object[1];
        if (dVar == null || (str = dVar.f139441c) == null) {
            str = "";
        }
        objArr[0] = str;
        w.d(f139828w, "onCompleteEvent: %s", objArr);
        this.f139830l = "ended";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 7;
        aVar.f137470b = dVar;
        aVar.f137473e = "ended";
        aVar.f137472d = getDuration();
        h.a aVar2 = hVar.f137468d;
        aVar2.f137471c = dVar.f139441c;
        aVar2.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.d(dVar);
        }
    }

    public void c(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onErrorEvent");
        a(dVar, -1);
    }

    public void d(com.tencent.luggage.wxa.rb.d dVar) {
        String str;
        Object[] objArr = new Object[1];
        if (dVar == null || (str = dVar.f139441c) == null) {
            str = "";
        }
        objArr[0] = str;
        w.d(f139828w, "onPauseEvent: %s", objArr);
        this.f139830l = "pause";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 3;
        aVar.f137470b = dVar;
        aVar.f137473e = "pause";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.e(dVar);
        }
    }

    public void e(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onPrepareEvent %b", Boolean.valueOf(i()));
        this.f139830l = "canplay";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 9;
        aVar.f137470b = dVar;
        aVar.f137473e = "canplay";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.k(dVar);
        }
    }

    public void f(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onPreparingEvent %b", Boolean.valueOf(i()));
        this.f139830l = "waiting";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 11;
        aVar.f137470b = dVar;
        aVar.f137473e = "waiting";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.f(dVar);
        }
    }

    public void g(com.tencent.luggage.wxa.rb.d dVar) {
        String str;
        Object[] objArr = new Object[1];
        if (dVar == null || (str = dVar.f139441c) == null) {
            str = "";
        }
        objArr[0] = str;
        w.d(f139828w, "onResumeEvent: %s", objArr);
        this.f139830l = "play";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 1;
        aVar.f137470b = dVar;
        aVar.f137473e = "play";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.l(dVar);
        }
    }

    public void h(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onSeekToEvent");
        this.f139830l = "seeked";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 8;
        aVar.f137470b = dVar;
        aVar.f137473e = "seeked";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.n(dVar);
        }
    }

    public void i(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onSeekingEvent");
        this.f139830l = "seeking";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 12;
        aVar.f137470b = dVar;
        aVar.f137473e = "seeking";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.b(dVar);
        }
    }

    public void j(com.tencent.luggage.wxa.rb.d dVar) {
        w.d(f139828w, "onStartEvent %b", Boolean.valueOf(i()));
        this.f139830l = "play";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 0;
        aVar.f137470b = dVar;
        aVar.f137473e = "play";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.a(dVar);
        }
    }

    public void k(com.tencent.luggage.wxa.rb.d dVar) {
        String str;
        Object[] objArr = new Object[1];
        if (dVar == null || (str = dVar.f139441c) == null) {
            str = "";
        }
        objArr[0] = str;
        w.d(f139828w, "onStopEvent: %s", objArr);
        this.f139830l = "stop";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 2;
        aVar.f137470b = dVar;
        aVar.f137473e = "stop";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.f137468d.f137475g = s();
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.j(dVar);
        }
    }

    public void l(com.tencent.luggage.wxa.rb.d dVar) {
        String str;
        Object[] objArr = new Object[1];
        if (dVar == null || (str = dVar.f139441c) == null) {
            str = "";
        }
        objArr[0] = str;
        w.d(f139828w, "onStopForReportEvent: %s", objArr);
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 18;
        aVar.f137470b = dVar;
        hVar.a(Looper.getMainLooper());
    }

    public boolean m(com.tencent.luggage.wxa.rb.d dVar) {
        if (dVar != null) {
            return dVar.Y;
        }
        return true;
    }

    public void n(com.tencent.luggage.wxa.rb.d dVar) {
    }

    public String o() {
        return this.f139830l;
    }

    public abstract void p();

    public void q() {
        synchronized (this.f139838t) {
            i0.b bVar = this.f139838t[0];
            if (bVar != null) {
                ((i0) com.tencent.luggage.wxa.eo.g.a(i0.class)).b(bVar);
                this.f139838t[0] = null;
            }
        }
    }

    public boolean r() {
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null && bVar.b()) {
            return true;
        }
        return false;
    }

    public boolean s() {
        boolean z16 = this.f139831m;
        this.f139831m = false;
        return z16;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(com.tencent.luggage.wxa.rb.d dVar) {
        p();
    }

    public void m() {
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.a();
        }
    }

    public void n() {
        if (ContextCompat.checkSelfPermission(z.c(), DeviceInfoUtil.PERMISSION_READ_PHONE) != 0) {
            w.b(f139828w, "addPhoneStatusWatcher() not have read_phone_state perm");
            return;
        }
        i0.b[] bVarArr = this.f139838t;
        if (bVarArr[0] != null) {
            return;
        }
        synchronized (bVarArr) {
            i0.b[] bVarArr2 = this.f139838t;
            if (bVarArr2[0] != null) {
                return;
            }
            bVarArr2[0] = new C6690a();
            ((i0) com.tencent.luggage.wxa.eo.g.a(i0.class)).a(this.f139838t[0]);
        }
    }

    public void a(com.tencent.luggage.wxa.rb.d dVar, int i3) {
        w.d(f139828w, "onErrorEvent with errCode:%d", Integer.valueOf(i3));
        this.f139830l = "error";
        com.tencent.luggage.wxa.p9.h hVar = new com.tencent.luggage.wxa.p9.h();
        h.a aVar = hVar.f137468d;
        aVar.f137469a = 4;
        aVar.f137470b = dVar;
        aVar.f137473e = "error";
        aVar.f137472d = getDuration();
        hVar.f137468d.f137474f = k();
        hVar.f137468d.f137477i = com.tencent.luggage.wxa.sm.e.b(i3);
        hVar.f137468d.f137478j = com.tencent.luggage.wxa.sm.e.a(i3);
        hVar.a(Looper.getMainLooper());
        com.tencent.luggage.wxa.qm.b bVar = this.f139833o;
        if (bVar != null) {
            bVar.a(dVar, i3);
        }
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void c(d.a aVar) {
        this.f139839u = aVar;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public int d() {
        return this.f139840v.size();
    }

    public void b(boolean z16) {
        this.f139831m = z16;
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void b(d.a aVar) {
        if (aVar != null && this.f139840v.contains(aVar)) {
            this.f139840v.remove(aVar);
        }
    }

    public void a(com.tencent.luggage.wxa.rb.d dVar, int i3, int i16) {
        w.d(f139828w, "onErrorEvent");
        a(dVar, -1);
    }

    @Override // com.tencent.luggage.wxa.sm.d
    public void a(d.a aVar) {
        if (aVar == null || this.f139840v.contains(aVar)) {
            return;
        }
        this.f139840v.add(aVar);
    }

    public void a(int i3, int i16) {
        d.a aVar = this.f139839u;
        if (aVar != null) {
            aVar.a(i3, i16);
        }
        Iterator<d.a> it = this.f139840v.iterator();
        while (it.hasNext()) {
            it.next().a(i3, i16);
        }
    }
}
