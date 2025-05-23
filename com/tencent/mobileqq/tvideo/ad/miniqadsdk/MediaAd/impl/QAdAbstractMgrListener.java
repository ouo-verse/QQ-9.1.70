package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.util.List;
import kt3.h;
import pw2.n;

/* compiled from: P */
/* loaded from: classes19.dex */
public class QAdAbstractMgrListener implements kt3.d, b {

    /* renamed from: a, reason: collision with root package name */
    protected volatile kt3.d f303622a;

    @Override // kt3.d
    public void a(int i3, long j3) {
        n.e("[QAd]QAdAbstractMgrListener", "call-ad onAdPrepared");
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.a(i3, j3);
        }
    }

    @Override // kt3.d
    public void b(int i3) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.b(i3);
        }
    }

    @Override // kt3.d
    public void c(int i3, int i16, int i17, h hVar) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.c(i3, i16, i17, hVar);
        }
    }

    @Override // kt3.d
    public void d(int i3, long j3, boolean z16, boolean z17, int i16) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.d(i3, j3, z16, z17, i16);
        }
    }

    @Override // kt3.d
    public void e(int i3, long j3, List<QAdVideoItem> list) {
        n.e("[QAd]QAdAbstractMgrListener", "call-ad onAdReceived");
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.e(i3, j3, list);
        }
    }

    @Override // kt3.d
    public void f(int i3) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.f(i3);
        }
    }

    @Override // kt3.d
    public Object g(int i3, String str, Object obj) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            return dVar.g(i3, str, obj);
        }
        return null;
    }

    @Override // kt3.d
    public void h(final int i3, final long j3) {
        yu2.f.f().c(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener.1
            @Override // java.lang.Runnable
            public void run() {
                kt3.d dVar = QAdAbstractMgrListener.this.f303622a;
                if (dVar != null) {
                    dVar.h(i3, j3);
                }
            }
        });
    }

    @Override // kt3.d
    public void i(int i3, long j3, long j16) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.i(i3, j3, j16);
        }
    }

    @Override // kt3.d
    public void j(boolean z16, com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.g gVar) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.j(z16, gVar);
        }
    }

    @Override // kt3.d
    public void l(int i3, int i16, int i17, h hVar) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.l(i3, i16, i17, hVar);
        }
    }

    @Override // kt3.d
    public void m(final int i3, final long j3) {
        yu2.f.f().c(new Runnable() { // from class: com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener.2
            @Override // java.lang.Runnable
            public void run() {
                kt3.d dVar = QAdAbstractMgrListener.this.f303622a;
                if (dVar != null) {
                    dVar.m(i3, j3);
                }
            }
        });
    }

    @Override // kt3.d
    public void onAdCountDown(int i3, long j3, long j16) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.onAdCountDown(i3, j3, j16);
        }
    }

    @Override // kt3.d
    public void onAdCountDownStart(int i3, long j3, long j16) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.onAdCountDownStart(i3, j3, j16);
        }
    }

    @Override // kt3.d
    public void onWarnerTipClick(int i3) {
        kt3.d dVar = this.f303622a;
        if (dVar != null) {
            dVar.onWarnerTipClick(i3);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.b
    public void k(int i3, Object obj) {
    }
}
