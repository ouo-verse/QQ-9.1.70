package com.tencent.av;

import com.tencent.av.perfstat.MemoryPerfStat;
import com.tencent.avcore.jni.NtrtcVideoRender;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class c implements com.tencent.avcore.camera.callback.c {

    /* renamed from: d, reason: collision with root package name */
    protected com.tencent.av.utils.p f73476d = null;

    /* renamed from: e, reason: collision with root package name */
    protected int f73477e = 0;

    /* renamed from: f, reason: collision with root package name */
    protected boolean f73478f = false;

    /* renamed from: h, reason: collision with root package name */
    private com.tencent.av.opengl.effects.i f73479h = null;

    private void d(byte[] bArr) {
        if (this.f73477e <= 30 && !this.f73478f) {
            int i3 = 0;
            while (i3 <= 10 && bArr[(int) (Math.random() * bArr.length)] == 0) {
                i3++;
            }
            if (i3 < 10) {
                this.f73478f = true;
            }
            this.f73477e++;
        }
        if (this.f73477e == 30 && !this.f73478f) {
            g();
        }
    }

    public abstract void e();

    public float[] f() {
        return com.tencent.avcore.camera.util.b.a();
    }

    public abstract void g();

    public void h(com.tencent.av.opengl.effects.i iVar) {
        if (QLog.isColorLevel()) {
            QLog.i("CameraDataProcess", 2, "setEffects, effects[" + iVar + "]");
        }
        this.f73479h = iVar;
    }

    @Override // com.tencent.avcore.camera.callback.c
    public void onPreviewData(com.tencent.avcore.camera.data.c cVar) {
        com.tencent.av.utils.p pVar;
        if (cVar.j()) {
            cVar.l();
            if (QLog.isColorLevel()) {
                QLog.e("OnPreviewData", 2, "onPreviewData data is null");
                return;
            }
            return;
        }
        byte[] bArr = cVar.f77441a;
        if (bArr != null) {
            d(bArr);
        }
        if (cVar.f77455o != null && this.f73479h == null) {
            e();
        }
        com.tencent.av.opengl.effects.i iVar = this.f73479h;
        boolean z16 = true;
        if (iVar == null ? cVar.f77455o == null : !iVar.b() && cVar.f77455o == null) {
            z16 = false;
        }
        if (com.tencent.av.utils.p.f()) {
            pVar = new com.tencent.av.utils.p(this.f73476d, cVar.f77450j);
            pVar.p(cVar.f(), cVar.f77442b, cVar.f77443c, cVar.f77444d, cVar.f77445e, cVar.f77446f, cVar.f77448h, cVar.f77447g, z16);
            pVar.m();
        } else {
            pVar = null;
        }
        this.f73476d = pVar;
        if (z16) {
            cVar.f77452l = pVar;
            com.tencent.av.opengl.effects.i iVar2 = this.f73479h;
            if (iVar2 != null) {
                iVar2.d(cVar);
                return;
            } else {
                cVar.l();
                return;
            }
        }
        if (pVar != null) {
            pVar.h();
        }
        NtrtcVideoRender.getInstance().sendCameraFrame(cVar.f77441a, com.tencent.avcore.camera.b.f77380w, cVar.f77442b, cVar.f77443c, cVar.f77445e, cVar.f77446f, System.currentTimeMillis(), cVar.f77447g, f(), null, 0, 0, cVar.f77451k);
        com.tencent.avcore.camera.util.a.d().g(cVar.f77441a, 0);
        MemoryPerfStat.f().i(0);
        cVar.l();
    }
}
