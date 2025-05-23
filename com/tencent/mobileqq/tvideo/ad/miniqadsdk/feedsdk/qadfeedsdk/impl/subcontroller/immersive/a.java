package com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.qadfeedsdk.impl.subcontroller.immersive;

import com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.g;
import ww2.e;

/* compiled from: P */
/* loaded from: classes19.dex */
public class a extends e<uw2.c> implements com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a {

    /* renamed from: e, reason: collision with root package name */
    private uw2.a f304147e;

    public a(uw2.c cVar) {
        super(cVar);
    }

    private void n() {
        uw2.a aVar = this.f304147e;
        if (aVar != null) {
            aVar.K();
        }
    }

    private void o(com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
        if (bVar instanceof g) {
            boolean z16 = ((g) bVar).f304140a;
            ((uw2.c) this.f446619d).f(!z16);
            uw2.a aVar = this.f304147e;
            if (aVar != null) {
                aVar.N(z16);
            }
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.a
    public void d(int i3, com.tencent.mobileqq.tvideo.ad.miniqadsdk.QAdCore.qadcore.event.b bVar) {
        if (i3 != 3) {
            if (i3 != 4) {
                if (i3 != 5) {
                    if (i3 != 6) {
                        if (i3 != 12) {
                            if (i3 == 13) {
                                n();
                                return;
                            }
                            return;
                        }
                        o(bVar);
                        return;
                    }
                    ((uw2.c) this.f446619d).k().replay();
                    return;
                }
                uw2.a aVar = this.f304147e;
                if (aVar != null) {
                    aVar.M();
                    return;
                }
                return;
            }
            ((uw2.c) this.f446619d).k().start();
            return;
        }
        ((uw2.c) this.f446619d).k().pause();
    }

    public void p(com.tencent.mobileqq.tvideo.ad.miniqadsdk.feedsdk.immersiveAd.c cVar) {
        cVar.t(this);
    }

    public void q(uw2.a aVar) {
        this.f304147e = aVar;
    }
}
