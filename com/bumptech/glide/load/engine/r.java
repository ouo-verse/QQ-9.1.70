package com.bumptech.glide.load.engine;

import androidx.annotation.NonNull;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.data.d;
import com.bumptech.glide.load.engine.d;
import java.io.File;
import java.util.List;
import t.n;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes.dex */
public class r implements d, d.a<Object> {
    private int C;
    private volatile n.a<?> D;
    private File E;
    private s F;

    /* renamed from: d, reason: collision with root package name */
    private final d.a f31754d;

    /* renamed from: e, reason: collision with root package name */
    private final e<?> f31755e;

    /* renamed from: f, reason: collision with root package name */
    private int f31756f;

    /* renamed from: h, reason: collision with root package name */
    private int f31757h = -1;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.c f31758i;

    /* renamed from: m, reason: collision with root package name */
    private List<t.n<File, ?>> f31759m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(e<?> eVar, d.a aVar) {
        this.f31755e = eVar;
        this.f31754d = aVar;
    }

    private boolean b() {
        if (this.C < this.f31759m.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.d
    public boolean a() {
        List<com.bumptech.glide.load.c> c16 = this.f31755e.c();
        boolean z16 = false;
        if (c16.isEmpty()) {
            return false;
        }
        List<Class<?>> m3 = this.f31755e.m();
        if (m3.isEmpty()) {
            if (File.class.equals(this.f31755e.q())) {
                return false;
            }
            throw new IllegalStateException("Failed to find any load path from " + this.f31755e.i() + " to " + this.f31755e.q());
        }
        while (true) {
            if (this.f31759m != null && b()) {
                this.D = null;
                while (!z16 && b()) {
                    List<t.n<File, ?>> list = this.f31759m;
                    int i3 = this.C;
                    this.C = i3 + 1;
                    this.D = list.get(i3).a(this.E, this.f31755e.s(), this.f31755e.f(), this.f31755e.k());
                    if (this.D != null && this.f31755e.t(this.D.f435125c.a())) {
                        this.D.f435125c.b(this.f31755e.l(), this);
                        z16 = true;
                    }
                }
                return z16;
            }
            int i16 = this.f31757h + 1;
            this.f31757h = i16;
            if (i16 >= m3.size()) {
                int i17 = this.f31756f + 1;
                this.f31756f = i17;
                if (i17 >= c16.size()) {
                    return false;
                }
                this.f31757h = 0;
            }
            com.bumptech.glide.load.c cVar = c16.get(this.f31756f);
            Class<?> cls = m3.get(this.f31757h);
            this.F = new s(this.f31755e.b(), cVar, this.f31755e.o(), this.f31755e.s(), this.f31755e.f(), this.f31755e.r(cls), cls, this.f31755e.k());
            File b16 = this.f31755e.d().b(this.F);
            this.E = b16;
            if (b16 != null) {
                this.f31758i = cVar;
                this.f31759m = this.f31755e.j(b16);
                this.C = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f31754d.d(this.F, exc, this.D.f435125c, DataSource.RESOURCE_DISK_CACHE);
    }

    @Override // com.bumptech.glide.load.engine.d
    public void cancel() {
        n.a<?> aVar = this.D;
        if (aVar != null) {
            aVar.f435125c.cancel();
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void d(Object obj) {
        this.f31754d.c(this.f31758i, obj, this.D.f435125c, DataSource.RESOURCE_DISK_CACHE, this.F);
    }
}
