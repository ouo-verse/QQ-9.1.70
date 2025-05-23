package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl;

import com.tencent.qqlive.playerinterface.QAdVideoItem;
import java.util.List;
import kt3.h;

/* compiled from: P */
/* loaded from: classes19.dex */
public abstract class f extends QAdAbstractMgrListener {
    private void o(int i3, int i16, int i17, h hVar, boolean z16) {
        if (i3 == 3) {
            p(10005, yu2.b.c(z16, i16), i17, "", hVar);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void a(int i3, long j3) {
        super.a(i3, j3);
        if (i3 == 3) {
            p(10004, 0, 0, "", null);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void c(int i3, int i16, int i17, h hVar) {
        super.c(i3, i16, i17, hVar);
        o(i3, i16, i17, hVar, true);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void e(int i3, long j3, List<QAdVideoItem> list) {
        super.e(i3, j3, list);
        if (i3 == 3) {
            p(10008, 0, 0, "", null);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void f(int i3) {
        super.f(i3);
        p(10007, 0, 0, "", null);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void h(int i3, long j3) {
        super.h(i3, j3);
        if (i3 == 3) {
            p(10005, 0, 0, "", null);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.b
    public void k(int i3, Object obj) {
        super.k(i3, obj);
        if (i3 == 3) {
            p(10008, 0, 0, "", obj);
        } else if (i3 == 23) {
            p(10019, 0, 0, "", obj);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void l(int i3, int i16, int i17, h hVar) {
        super.l(i3, i16, i17, hVar);
        o(i3, i16, i17, hVar, false);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.impl.QAdAbstractMgrListener, kt3.d
    public void onAdCountDownStart(int i3, long j3, long j16) {
        super.onAdCountDownStart(i3, j3, j16);
        p(10006, 0, 0, "", null);
    }

    protected abstract void p(int i3, int i16, int i17, String str, Object obj);
}
