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
public class a implements d, d.a<Object> {
    private int C;
    private volatile n.a<?> D;
    private File E;

    /* renamed from: d, reason: collision with root package name */
    private final List<com.bumptech.glide.load.c> f31641d;

    /* renamed from: e, reason: collision with root package name */
    private final e<?> f31642e;

    /* renamed from: f, reason: collision with root package name */
    private final d.a f31643f;

    /* renamed from: h, reason: collision with root package name */
    private int f31644h;

    /* renamed from: i, reason: collision with root package name */
    private com.bumptech.glide.load.c f31645i;

    /* renamed from: m, reason: collision with root package name */
    private List<t.n<File, ?>> f31646m;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(e<?> eVar, d.a aVar) {
        this(eVar.c(), eVar, aVar);
    }

    private boolean b() {
        if (this.C < this.f31646m.size()) {
            return true;
        }
        return false;
    }

    @Override // com.bumptech.glide.load.engine.d
    public boolean a() {
        while (true) {
            boolean z16 = false;
            if (this.f31646m != null && b()) {
                this.D = null;
                while (!z16 && b()) {
                    List<t.n<File, ?>> list = this.f31646m;
                    int i3 = this.C;
                    this.C = i3 + 1;
                    this.D = list.get(i3).a(this.E, this.f31642e.s(), this.f31642e.f(), this.f31642e.k());
                    if (this.D != null && this.f31642e.t(this.D.f435125c.a())) {
                        this.D.f435125c.b(this.f31642e.l(), this);
                        z16 = true;
                    }
                }
                return z16;
            }
            int i16 = this.f31644h + 1;
            this.f31644h = i16;
            if (i16 >= this.f31641d.size()) {
                return false;
            }
            com.bumptech.glide.load.c cVar = this.f31641d.get(this.f31644h);
            File b16 = this.f31642e.d().b(new b(cVar, this.f31642e.o()));
            this.E = b16;
            if (b16 != null) {
                this.f31645i = cVar;
                this.f31646m = this.f31642e.j(b16);
                this.C = 0;
            }
        }
    }

    @Override // com.bumptech.glide.load.data.d.a
    public void c(@NonNull Exception exc) {
        this.f31643f.d(this.f31645i, exc, this.D.f435125c, DataSource.DATA_DISK_CACHE);
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
        this.f31643f.c(this.f31645i, obj, this.D.f435125c, DataSource.DATA_DISK_CACHE, this.f31645i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(List<com.bumptech.glide.load.c> list, e<?> eVar, d.a aVar) {
        this.f31644h = -1;
        this.f31641d = list;
        this.f31642e = eVar;
        this.f31643f = aVar;
    }
}
