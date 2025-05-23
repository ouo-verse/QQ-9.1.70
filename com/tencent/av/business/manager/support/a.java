package com.tencent.av.business.manager.support;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.avcore.util.AVCoreLog;

/* compiled from: P */
/* loaded from: classes3.dex */
public class a extends com.tencent.av.business.manager.a {

    /* renamed from: h, reason: collision with root package name */
    private Object f73445h;

    /* renamed from: i, reason: collision with root package name */
    private b[] f73446i;

    /* renamed from: m, reason: collision with root package name */
    private c f73447m;

    public a(VideoAppInterface videoAppInterface) {
        super(videoAppInterface);
        this.f73445h = new Object();
        this.f73446i = new b[20];
        this.f73447m = new c(videoAppInterface);
    }

    private b l(VideoAppInterface videoAppInterface, int i3) {
        b bVar;
        b dVar;
        long currentTimeMillis = System.currentTimeMillis();
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    bVar = this.f73447m;
                } else {
                    dVar = new SupportFace(videoAppInterface);
                }
            } else {
                dVar = new d(videoAppInterface);
            }
            bVar = dVar;
        } else {
            bVar = null;
        }
        if (bVar != null) {
            bVar.b();
        }
        AVCoreLog.printColorLog("EffectSupportManager", "create Manager,cost time:" + (System.currentTimeMillis() - currentTimeMillis));
        return bVar;
    }

    private b m(int i3) {
        b bVar;
        b bVar2 = this.f73446i[i3];
        if (bVar2 != null) {
            return bVar2;
        }
        synchronized (this.f73445h) {
            bVar = this.f73446i[i3];
            if (bVar == null && (bVar = l(this.f73316e, i3)) != null) {
                this.f73446i[i3] = bVar;
            }
        }
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public boolean i(String str) {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void j(long j3, int i3, String str, String str2) {
        AVCoreLog.printColorLog("EffectSupportManager", "EffectFaceSupportManager onSessionStatusChanged " + i3);
        if (i3 != 1) {
            if (i3 == 3) {
                p();
                return;
            }
            return;
        }
        q(255);
    }

    public boolean n(int i3, String str) {
        b m3 = m(i3);
        if (m3 != null) {
            return m3.a(str);
        }
        return true;
    }

    public boolean o(int i3, int i16, String str) {
        b m3 = m(i3);
        if (m3 != null) {
            return m3.c(i16, str);
        }
        return false;
    }

    public void p() {
        for (int i3 = 0; i3 < 20; i3++) {
            b m3 = m(i3);
            if (m3 != null) {
                m3.d();
            }
        }
    }

    public void q(int i3) {
        b m3;
        for (int i16 = 0; i16 < 20; i16++) {
            if ((i3 == 255 || i3 == i16) && (m3 = m(i16)) != null) {
                m3.e();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.av.business.manager.a
    public void g() {
    }
}
