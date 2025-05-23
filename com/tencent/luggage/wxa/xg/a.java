package com.tencent.luggage.wxa.xg;

import com.tencent.luggage.wxa.tn.w;
import com.tencent.luggage.wxa.xg.g;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes9.dex */
public abstract class a implements h {

    /* renamed from: b, reason: collision with root package name */
    public volatile boolean f144903b;

    /* renamed from: c, reason: collision with root package name */
    public g.e f144904c;

    /* renamed from: d, reason: collision with root package name */
    public g.d f144905d;

    /* renamed from: e, reason: collision with root package name */
    public g.f f144906e;

    /* renamed from: f, reason: collision with root package name */
    public g.b f144907f;

    /* renamed from: g, reason: collision with root package name */
    public g.InterfaceC6908g f144908g;

    /* renamed from: h, reason: collision with root package name */
    public g.a f144909h;

    /* renamed from: i, reason: collision with root package name */
    public g.i f144910i;

    /* renamed from: j, reason: collision with root package name */
    public g.h f144911j;

    /* renamed from: a, reason: collision with root package name */
    public int f144902a = 0;

    /* renamed from: k, reason: collision with root package name */
    public final Set f144912k = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: l, reason: collision with root package name */
    public final Set f144913l = Collections.newSetFromMap(new ConcurrentHashMap());

    /* renamed from: m, reason: collision with root package name */
    public final Set f144914m = Collections.newSetFromMap(new ConcurrentHashMap());

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(double d16) {
        a(-1010, -1010);
    }

    public void b(int i3) {
        this.f144902a = i3;
    }

    public void c() {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnSeekComplete");
        synchronized (this) {
            if (this.f144903b) {
                return;
            }
            g.InterfaceC6908g interfaceC6908g = this.f144908g;
            if (interfaceC6908g != null) {
                interfaceC6908g.a(this);
            }
            Iterator it = this.f144913l.iterator();
            while (it.hasNext()) {
                ((g.InterfaceC6908g) it.next()).a(this);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public int getState() {
        return this.f144902a;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void release() {
        this.f144903b = true;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public /* synthetic */ void setMinBufferDuration(long j3) {
        r41.a.b(this, j3);
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String str, String str2, String str3, boolean z16) {
        a(-1010, -1010);
    }

    public void b() {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnPrepared");
        synchronized (this) {
            if (this.f144903b) {
                return;
            }
            g.f fVar = this.f144906e;
            if (fVar != null) {
                fVar.a(this);
            }
            Iterator it = this.f144912k.iterator();
            while (it.hasNext()) {
                ((g.f) it.next()).a(this);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(String str, String str2, g.c cVar) {
        a(str, str2);
        if (cVar != null) {
            cVar.a();
        }
    }

    public void a() {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnCompletion");
        synchronized (this) {
            if (this.f144903b) {
                return;
            }
            g.b bVar = this.f144907f;
            if (bVar != null) {
                bVar.a(this);
            }
            Iterator it = this.f144914m.iterator();
            while (it.hasNext()) {
                ((g.b) it.next()).a(this);
            }
        }
    }

    public void c(int i3, int i16) {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnVideoSizeChanged, width:%d, height:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        synchronized (this) {
            if (this.f144903b) {
                return;
            }
            g.i iVar = this.f144910i;
            if (iVar != null) {
                iVar.a(this, i3, i16);
            }
        }
    }

    public boolean b(int i3, int i16) {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnInfo, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        synchronized (this) {
            if (this.f144903b) {
                return false;
            }
            g.e eVar = this.f144904c;
            return eVar != null && eVar.a(this, i3, i16);
        }
    }

    public void a(int i3) {
        synchronized (this) {
            if (this.f144903b) {
                return;
            }
            g.a aVar = this.f144909h;
            if (aVar != null) {
                aVar.a(this, i3);
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.f fVar) {
        this.f144912k.add(fVar);
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.InterfaceC6908g interfaceC6908g) {
        this.f144913l.add(interfaceC6908g);
    }

    @Override // com.tencent.luggage.wxa.xg.h
    public void b(g.b bVar) {
        this.f144914m.add(bVar);
    }

    public boolean a(int i3, int i16) {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnError, what:%d, extra:%d", Integer.valueOf(i3), Integer.valueOf(i16));
        synchronized (this) {
            if (this.f144903b) {
                return false;
            }
            g.d dVar = this.f144905d;
            return dVar != null && dVar.a(this, i3, i16);
        }
    }

    public void a(String str) {
        w.d("MicroMsg.SameLayer.BaseMediaPlayer", "notifyOnDownStreamChanged, selectIndex:%s", str);
        synchronized (this) {
            if (this.f144903b) {
            }
        }
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.e eVar) {
        this.f144904c = eVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.d dVar) {
        this.f144905d = dVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.f fVar) {
        this.f144906e = fVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.b bVar) {
        this.f144907f = bVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.InterfaceC6908g interfaceC6908g) {
        this.f144908g = interfaceC6908g;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.a aVar) {
        this.f144909h = aVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.i iVar) {
        this.f144910i = iVar;
    }

    @Override // com.tencent.luggage.wxa.xg.g
    public void a(g.h hVar) {
        this.f144911j = hVar;
    }
}
