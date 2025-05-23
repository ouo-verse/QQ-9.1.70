package com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.QAdVideoFunnelUtil;
import com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.report.funnel.videofunnel.funnelconstants.VideoFunnelConstant;
import com.tencent.qqlive.ona.protocol.jce.AdInsideVideoRequest;
import com.tencent.qqlive.ona.protocol.jce.AdTempletItem;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;
import pw2.y;
import wu2.a;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c extends QAdBaseVideoController {

    /* renamed from: c0, reason: collision with root package name */
    private ArrayList<AdTempletItem> f303576c0;

    public c(Context context) {
        super(context);
        this.O = new d(context);
        QAdBaseVideoController.Z = "QAdMidrollController";
    }

    private void U1(int i3, int i16, int i17, @QAdVideoFunnelUtil.OrderInfoType int i18) {
        CopyOnWriteArrayList<com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.data.c> copyOnWriteArrayList;
        int i19;
        if (this.f303576c0 != null && (copyOnWriteArrayList = this.f303540g) != null && copyOnWriteArrayList.size() != 0) {
            String g16 = QAdVideoFunnelUtil.g(i3, this.f303554u.size(), this.f303540g, i18);
            if (!TextUtils.isEmpty(g16)) {
                if (i18 == 2) {
                    i19 = 7;
                } else {
                    i19 = 8;
                }
                wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_REAL_ORDER_EXPOSURE_FAIL, new wu2.a().j().d(i17).g(i19).f(g16).e(i16).h(), null, this.Q);
            }
        }
    }

    public void T1(AdInsideVideoRequest adInsideVideoRequest, ArrayList<AdTempletItem> arrayList) {
        if (adInsideVideoRequest != null && arrayList != null) {
            this.f303576c0 = arrayList;
            S0(adInsideVideoRequest);
            M1();
            this.A = true;
            if (y.h(A0(this.f303576c0))) {
                R(true);
                return;
            }
            return;
        }
        iu2.a aVar = new iu2.a(201, "transform adid from video vid failed.");
        this.f303538e = aVar;
        V0(aVar);
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController
    public void X0(Object obj) {
        if (this.f303576c0 != null) {
            wu2.c.i(VideoFunnelConstant.MidReportEvent.AD_MID_EMPTY_EXPOSURE, new a.C11510a().g(9).h(), obj, this.Q);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController
    public void a1(int i3, int i16) {
        int max = Math.max(this.f303551r, 0);
        synchronized (this.f303554u) {
            U1(max, i3, i16, 2);
        }
        synchronized (this.f303555v) {
            U1(max, i3, i16, 3);
        }
    }

    @Override // com.tencent.mobileqq.tvideo.ad.miniqadsdk.MediaAd.controller.QAdBaseVideoController
    protected void w1() {
        this.f303558y = 3;
    }
}
