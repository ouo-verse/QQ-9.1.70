package com.tencent.biz.pubaccount.weishi.recommend.holder;

import UserGrowth.stSimpleMetaFeed;
import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.ad.tangram.util.AdExposureChecker;
import com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment;
import com.tencent.ad.tangram.views.feedback.AdFeedbackParams;
import com.tencent.biz.pubaccount.weishi.event.WSGridAdCardExposeEvent;
import com.tencent.biz.pubaccount.weishi.event.WSSimpleBaseEvent;
import com.tencent.gdtad.IGdtAdAPI;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import tencent.gdt.access;

/* compiled from: P */
/* loaded from: classes32.dex */
public class WSGridAdItemView extends com.tencent.biz.pubaccount.weishi.baseui.a<stSimpleMetaFeed> implements View.OnClickListener, wz.c<WSGridAdCardExposeEvent> {
    private stSimpleMetaFeed C;
    private GdtAd D;
    private access.AdGetRsp E;
    private RelativeLayout F;
    AdFeedbackDialogFragment.Listener G;
    private access.UserActionReportInfo H;
    private AdExposureChecker.ExposureCallback I;
    private AdExposureChecker J;

    /* renamed from: i, reason: collision with root package name */
    private com.tencent.biz.pubaccount.weishi.t f81433i;

    /* renamed from: m, reason: collision with root package name */
    private d f81434m;

    public WSGridAdItemView(Context context, View view, com.tencent.biz.pubaccount.weishi.t tVar, d dVar) {
        super(context, view);
        this.D = new GdtAd();
        this.G = new AdFeedbackDialogFragment.Listener() { // from class: com.tencent.biz.pubaccount.weishi.recommend.holder.e
            @Override // com.tencent.ad.tangram.views.feedback.AdFeedbackDialogFragment.Listener
            public final void onResult(AdFeedbackDialogFragment.Result result) {
                WSGridAdItemView.this.q(result);
            }
        };
        this.H = null;
        this.I = new AdExposureChecker.ExposureCallback() { // from class: com.tencent.biz.pubaccount.weishi.recommend.holder.f
            @Override // com.tencent.ad.tangram.util.AdExposureChecker.ExposureCallback
            public final void onExposure(WeakReference weakReference) {
                WSGridAdItemView.this.r(weakReference);
            }
        };
        this.J = null;
        this.f81433i = tVar;
        this.f81434m = dVar;
        o();
    }

    private boolean n() {
        GdtAd gdtAd = this.D;
        return gdtAd == null || !gdtAd.isValid();
    }

    private void o() {
        g(R.id.p2n, new d10.a(this.f80416f, this.f80414d, this.f81433i));
        g(R.id.p2r, new d10.b(this.f80416f));
        g(R.id.p2t, new d10.d(this.f80416f));
        g(R.id.p2u, new d10.c(this.f80416f));
    }

    private boolean p() {
        return this.f80414d.getGlobalVisibleRect(new Rect());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void q(AdFeedbackDialogFragment.Result result) {
        com.tencent.biz.pubaccount.weishi.t tVar;
        if (result.action != 3 || (tVar = this.f81433i) == null) {
            return;
        }
        tVar.q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void r(WeakReference weakReference) {
        if (this.D.isValid()) {
            com.tencent.biz.pubaccount.weishi.util.f fVar = com.tencent.biz.pubaccount.weishi.util.f.f81762a;
            fVar.e(this.D.getUrlForImpression());
            fVar.h(0, 4, this.D.info);
        }
    }

    private void s() {
        AdFeedbackParams adFeedbackParams = new AdFeedbackParams();
        adFeedbackParams.activity = new WeakReference<>((Activity) this.f80416f);
        adFeedbackParams.listener = new WeakReference<>(this.G);
        adFeedbackParams.f61346ad = this.D;
        adFeedbackParams.styleId = 0;
        try {
            ((IGdtAdAPI) QRoute.api(IGdtAdAPI.class)).showFeedbackDialogFragment(adFeedbackParams);
        } catch (Throwable th5) {
            QLog.e("WSGridAdItemView", 1, "openFeedBack", th5);
        }
    }

    private void u() {
        RelativeLayout relativeLayout = this.F;
        if (relativeLayout == null) {
            return;
        }
        stSimpleMetaFeed stsimplemetafeed = this.C;
        relativeLayout.setVisibility(stsimplemetafeed != null && stsimplemetafeed.waterFallCardStyle.cardType == 13 ? 0 : 8);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void a() {
        ImageView imageView = (ImageView) this.f80414d.findViewById(R.id.p2p);
        this.F = (RelativeLayout) this.f80414d.findViewById(R.id.p2s);
        imageView.setOnClickListener(this);
        this.f80414d.setOnClickListener(this);
    }

    @Override // wz.c
    public void b(WSSimpleBaseEvent wSSimpleBaseEvent) {
        if ((wSSimpleBaseEvent instanceof WSGridAdCardExposeEvent) && p()) {
            if (((WSGridAdCardExposeEvent) wSSimpleBaseEvent).getIsRefresh()) {
                ThreadManagerV2.executeDelay(new Runnable() { // from class: com.tencent.biz.pubaccount.weishi.recommend.holder.WSGridAdItemView.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.tencent.biz.pubaccount.weishi.util.f.f81762a.g(WSGridAdItemView.this.D, ((com.tencent.biz.pubaccount.weishi.baseui.a) WSGridAdItemView.this).f80414d, WSGridAdItemView.this.H);
                        WSGridAdItemView.this.J.startCheck();
                    }
                }, 16, null, false, 200L);
            } else {
                com.tencent.biz.pubaccount.weishi.util.f.f81762a.g(this.D, this.f80414d, this.H);
                this.J.startCheck();
            }
        }
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void c() {
        wz.b.b().f(this);
    }

    @Override // wz.c
    public ArrayList<Class<WSGridAdCardExposeEvent>> getEventClass() {
        ArrayList<Class<WSGridAdCardExposeEvent>> arrayList = new ArrayList<>();
        arrayList.add(WSGridAdCardExposeEvent.class);
        return arrayList;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        d dVar;
        if (n()) {
            return;
        }
        if (view.getId() == R.id.p2p) {
            s();
            return;
        }
        com.tencent.biz.pubaccount.weishi.util.f fVar = com.tencent.biz.pubaccount.weishi.util.f.f81762a;
        fVar.c(this.D, this.f80414d);
        if (this.E.action_report_infos.get().size() > 0) {
            fVar.e(this.E.action_report_infos.get(0).click_url.get());
        }
        AdExposureChecker.onClick(this.f80416f, this.D, new WeakReference(this.I));
        if (this.f81433i == null || (dVar = this.f81434m) == null) {
            return;
        }
        com.tencent.biz.pubaccount.weishi.verticalvideo.advcard.a.e(this.C, dVar.getAdapterPosition() - this.f81433i.getHeaderExtraViewCount(), this.f81433i.F);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public void setData(stSimpleMetaFeed stsimplemetafeed) {
        this.C = stsimplemetafeed;
        access.AdGetRsp e16 = com.tencent.biz.pubaccount.weishi.util.d.f81760a.e(stsimplemetafeed.waterAdItem);
        this.E = e16;
        if (e16.qq_ad_get_rsp.pos_ads_info.isEmpty() || this.E.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.isEmpty()) {
            return;
        }
        this.D = new GdtAd(this.E.qq_ad_get_rsp.pos_ads_info.get(0).ads_info.get(0));
        u();
        super.setData(stsimplemetafeed);
        if (!this.E.action_report_infos.get().isEmpty()) {
            this.H = this.E.action_report_infos.get(0);
        }
        AdExposureChecker adExposureChecker = new AdExposureChecker(this.D, new WeakReference(this.f80414d));
        this.J = adExposureChecker;
        adExposureChecker.setCallback(new WeakReference<>(this.I));
        wz.b.b().d(this);
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void d() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.a, com.tencent.biz.pubaccount.weishi.baseui.c
    public void recycle() {
    }

    @Override // com.tencent.biz.pubaccount.weishi.baseui.c
    public void e(int i3) {
    }
}
