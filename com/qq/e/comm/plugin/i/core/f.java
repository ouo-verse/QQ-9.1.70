package com.qq.e.comm.plugin.i.core;

import com.qq.e.comm.plugin.i.b.a;
import com.qq.e.comm.plugin.i.d.b;
import com.qq.e.comm.plugin.i.e;
import com.qq.e.comm.plugin.i.i;
import com.qq.e.comm.util.GDTLogger;
import java.io.File;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f extends c {

    /* renamed from: d, reason: collision with root package name */
    private final f f39488d;

    /* renamed from: e, reason: collision with root package name */
    private volatile boolean f39489e;

    /* renamed from: f, reason: collision with root package name */
    private volatile boolean f39490f;

    /* renamed from: g, reason: collision with root package name */
    private volatile boolean f39491g;

    public f(e eVar, a aVar, i iVar, b.a aVar2, f fVar) {
        super(eVar, iVar, aVar2, aVar);
        this.f39489e = false;
        this.f39490f = false;
        this.f39491g = false;
        this.f39471b = true;
        this.f39488d = fVar;
    }

    @Override // com.qq.e.comm.plugin.i.core.c, com.qq.e.comm.plugin.i.d.b
    public boolean d() {
        f fVar = this;
        while (!fVar.f39491g) {
            fVar = fVar.k();
            if (fVar == null) {
                return false;
            }
        }
        return true;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void e() {
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PartialDownloadTask afterDownload :");
        if (h() != null) {
            j3 = h().a();
        } else {
            j3 = -1;
        }
        sb5.append(j3);
        GDTLogger.d(sb5.toString());
        this.f39490f = false;
        this.f39489e = true;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void f() {
        long j3;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("PartialDownloadTask beforeDownload :");
        if (h() != null) {
            j3 = h().d();
        } else {
            j3 = -1;
        }
        sb5.append(j3);
        GDTLogger.d(sb5.toString());
        this.f39490f = true;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected void g() {
        this.f39490f = false;
        this.f39489e = false;
        this.f39491g = true;
    }

    @Override // com.qq.e.comm.plugin.i.core.c
    protected int j() {
        return 206;
    }

    public f k() {
        return this.f39488d;
    }

    public boolean l() {
        return this.f39489e;
    }

    public boolean m() {
        return new File(this.f39470a.b(), this.f39470a.a() + ".part").exists();
    }

    public boolean n() {
        if (new File(this.f39470a.b(), this.f39470a.a()).exists()) {
            return false;
        }
        if ((this.f39490f || this.f39489e) && !this.f39491g) {
            return false;
        }
        return true;
    }
}
