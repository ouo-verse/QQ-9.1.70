package com.tencent.mapsdk.internal;

import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public final class rw implements fs, TencentMap.OnCameraChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public ne f150153a;

    /* renamed from: b, reason: collision with root package name */
    public final rv f150154b;

    public rw(ne neVar, lu luVar) {
        this.f150153a = neVar;
        this.f150154b = new rv(this.f150153a, luVar);
    }

    private void c() {
        ne neVar = this.f150153a;
        if (neVar == null) {
            return;
        }
        neVar.f149398k.a(this);
        try {
            this.f150154b.start();
        } catch (Exception unused) {
        }
    }

    private void d() {
        this.f150154b.a();
    }

    private void e() {
        b();
    }

    public final void a() {
        this.f150154b.b();
        u();
    }

    public final void b() {
        ne neVar = this.f150153a;
        if (neVar == null) {
            return;
        }
        neVar.f149398k.b(this);
        this.f150154b.c();
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public final void onCameraChange(CameraPosition cameraPosition) {
        synchronized (this.f150154b) {
            this.f150154b.notify();
        }
    }

    @Override // com.tencent.mapsdk.internal.fs
    public final void u() {
        synchronized (this.f150154b) {
            this.f150154b.notify();
        }
    }

    private void a(rt rtVar) {
        List<rt> list;
        if (rtVar == null || (list = this.f150154b.f150144a) == null) {
            return;
        }
        list.add(rtVar);
    }

    private void b(rt rtVar) {
        List<rt> list;
        if (rtVar == null || (list = this.f150154b.f150144a) == null) {
            return;
        }
        list.remove(rtVar);
    }

    @Override // com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener
    public final void onCameraChangeFinished(CameraPosition cameraPosition) {
    }
}
