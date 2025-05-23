package com.qzone.reborn.feedx.widget.header;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.qzone.common.business.result.QZoneResult;
import com.qzone.module.personalitycomponent.coverWidget.VasADFrameLayout;
import com.qzone.proxy.personalitycomponent.manager.QzoneWidgetService;
import com.qzone.proxy.personalitycomponent.model.WidgetQzoneVipData;
import com.qzone.proxy.personalitycomponent.ui.QZoneWidgetControllerDecorator;
import com.qzone.reborn.feedx.widget.header.aj;
import com.qzone.widget.QzoneZipAnimateUtil;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.tianshu.data.TianShuReportData;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.api.IVasAdv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.richframework.thread.RFWThreadManager;
import cooperation.qzone.zipanimate.AnimationDrawableLoadedListener;
import mqq.app.MobileQQ;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes37.dex */
public class aj extends d {
    private com.qzone.reborn.feedx.viewmodel.w C;
    private boolean D;
    private Object E;
    private final AnimationDrawableLoadedListener F;

    /* renamed from: f, reason: collision with root package name */
    private QZoneWidgetControllerDecorator f56183f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f56184h;

    /* renamed from: i, reason: collision with root package name */
    private AnimationDrawable f56185i;

    /* renamed from: m, reason: collision with root package name */
    private VasADFrameLayout f56186m;

    public aj(View view) {
        super(view);
        this.F = new a();
        this.f56183f = (QZoneWidgetControllerDecorator) view.findViewById(R.id.mzv);
        this.f56186m = (VasADFrameLayout) view.findViewById(R.id.f162846my2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation D() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(1.0f, 0.0f));
        animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, 0.0f, -this.f56184h.getHeight()));
        animationSet.setRepeatMode(2);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setDuration(300L);
        animationSet.setAnimationListener(new b());
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Animation E() {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(new AlphaAnimation(0.0f, 1.0f));
        animationSet.addAnimation(new TranslateAnimation(0.0f, 0.0f, this.f56183f.getHeight(), 0.0f));
        animationSet.setRepeatMode(2);
        animationSet.setInterpolator(new LinearInterpolator());
        animationSet.setDuration(300L);
        return animationSet;
    }

    private void F(Object obj) {
        this.f56184h.setImageDrawable(null);
        this.f56184h.setVisibility(8);
        this.f56183f.setVisibility(0);
        this.f56183f.update(obj);
    }

    private void G(Handler handler, int i3) {
        f6.a.c(this.f56183f);
        ImageView imageView = (ImageView) d().findViewById(R.id.mzw);
        this.f56184h = imageView;
        imageView.getLayoutParams().height = com.qzone.util.ar.e(100.0f);
        this.f56184h.getLayoutParams().width = com.qzone.util.ar.e(136.0f);
        this.f56184h.setScaleType(ImageView.ScaleType.FIT_XY);
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56183f;
        if (qZoneWidgetControllerDecorator == null || qZoneWidgetControllerDecorator.isInitiated()) {
            return;
        }
        this.f56183f.init(g(), handler, i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void H(WidgetQzoneVipData widgetQzoneVipData, View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!TextUtils.isEmpty(widgetQzoneVipData.advLink)) {
            yo.d.d(widgetQzoneVipData.advLink, g(), null);
        } else {
            yo.d.d(widgetQzoneVipData.vipurl, g(), null);
        }
        K(widgetQzoneVipData, Boolean.TRUE);
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void I(Object obj) {
        this.E = obj;
        if ((obj instanceof WidgetQzoneVipData) && this.C.M2()) {
            WidgetQzoneVipData widgetQzoneVipData = (WidgetQzoneVipData) obj;
            if (!TextUtils.isEmpty(widgetQzoneVipData.widgetAdAnimation)) {
                L(widgetQzoneVipData);
                return;
            } else {
                this.f56186m.k(Boolean.TRUE, widgetQzoneVipData.isVip);
                F(this.E);
                return;
            }
        }
        F(this.E);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void J(int i3) {
        final Object widgetInfoFromCache = QzoneWidgetService.getInstance().getWidgetInfoFromCache(i3, false, this.C.getMUin());
        if (widgetInfoFromCache == null || this.f56183f == null) {
            return;
        }
        RFWThreadManager.getInstance().runOnUiThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ad
            @Override // java.lang.Runnable
            public final void run() {
                aj.this.I(widgetInfoFromCache);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K(WidgetQzoneVipData widgetQzoneVipData, Boolean bool) {
        String str;
        TianShuReportData tianShuReportData = new TianShuReportData();
        tianShuReportData.mAppId = "tianshu.64";
        tianShuReportData.mPageId = "tianshu.64";
        long serverTimeMillis = NetConnInfoCenter.getServerTimeMillis() / 1000;
        tianShuReportData.mTraceId = MobileQQ.sMobileQQ.peekAppRuntime().getCurrentAccountUin() + "_" + serverTimeMillis;
        tianShuReportData.mTraceNum = 1;
        tianShuReportData.mActionValue = 1;
        tianShuReportData.mOperTime = serverTimeMillis;
        if (bool.booleanValue()) {
            tianShuReportData.mActionId = 102;
        } else {
            tianShuReportData.mActionId = 101;
        }
        tianShuReportData.mTriggerInfo = widgetQzoneVipData.advTraceInfo;
        try {
            str = new JSONObject(((IVasAdv) QRoute.api(IVasAdv.class)).readQzoneWidgetCache()).optString("adId");
        } catch (Exception e16) {
            com.tencent.xaction.log.b.c("QZoneUserHomeCoverWidgetElement", 1, "json error", e16);
            str = "";
        }
        tianShuReportData.mItemId = str;
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(tianShuReportData);
    }

    private void L(final WidgetQzoneVipData widgetQzoneVipData) {
        com.tencent.xaction.log.b.a("QZoneUserHomeCoverWidgetElement", 1, "showWidgetAnimation: " + widgetQzoneVipData.widgetAdAnimation);
        QzoneZipAnimateUtil.j(widgetQzoneVipData.widgetAdAnimation, "widget_ad_animation", widgetQzoneVipData.widgetAdAnimation.hashCode() + "", ViewUtils.dpToPx(100.0f), ViewUtils.dpToPx(130.0f), 110, this.F);
        this.f56184h.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.reborn.feedx.widget.header.ae
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                aj.this.H(widgetQzoneVipData, view);
            }
        });
        this.f56183f.setVisibility(8);
    }

    public void N(final int i3) {
        RFWThreadManager.getInstance().execOnSubThread(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ac
            @Override // java.lang.Runnable
            public final void run() {
                aj.this.J(i3);
            }
        });
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void a0(QZoneResult qZoneResult) {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56183f;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.getWidgetBase().r();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    protected String j() {
        return "QZoneUserHomeCoverWidgetElement";
    }

    @Override // com.qzone.reborn.feedx.widget.header.d
    public void l() {
        G(f(), 1000);
        this.C = (com.qzone.reborn.feedx.viewmodel.w) k(com.qzone.reborn.feedx.viewmodel.w.class);
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onDestroy() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56183f;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onDestory();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onHandleMessage(Message message) {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator;
        int i3 = message.what;
        if (i3 == 1000055) {
            N(1000);
        } else if (i3 == 20140716 && (qZoneWidgetControllerDecorator = this.f56183f) != null) {
            qZoneWidgetControllerDecorator.requestLayout();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onPause() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56183f;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onPause();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void onResume() {
        QZoneWidgetControllerDecorator qZoneWidgetControllerDecorator = this.f56183f;
        if (qZoneWidgetControllerDecorator != null) {
            qZoneWidgetControllerDecorator.onResume();
        }
    }

    @Override // com.qzone.reborn.feedx.widget.header.d, com.qzone.reborn.feedx.widget.header.b
    public void delayShow() {
        N(1000);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class a extends AnimationDrawableLoadedListener {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void e() {
            aj.this.f56185i.stop();
            aj.this.f56184h.startAnimation(aj.this.D());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void f() {
            if (aj.this.E instanceof WidgetQzoneVipData) {
                WidgetQzoneVipData widgetQzoneVipData = (WidgetQzoneVipData) aj.this.E;
                long j3 = widgetQzoneVipData.showAdvDuration > 0 ? ((WidgetQzoneVipData) aj.this.E).showAdvDuration : 4500L;
                boolean z16 = widgetQzoneVipData.keepShowAdv != 0;
                if (aj.this.D) {
                    return;
                }
                aj.this.D = true;
                aj.this.f56184h.setVisibility(0);
                aj.this.f56184h.setImageDrawable(aj.this.f56185i);
                aj.this.f56185i.start();
                aj.this.K(widgetQzoneVipData, Boolean.FALSE);
                if (z16) {
                    return;
                }
                aj.this.f().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ah
                    @Override // java.lang.Runnable
                    public final void run() {
                        aj.a.this.e();
                    }
                }, j3);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void g(com.tencent.mobileqq.vas.ui.c cVar) {
            cVar.stop();
            aj.this.f56184h.startAnimation(aj.this.D());
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void h(final com.tencent.mobileqq.vas.ui.c cVar) {
            if (aj.this.E instanceof WidgetQzoneVipData) {
                WidgetQzoneVipData widgetQzoneVipData = (WidgetQzoneVipData) aj.this.E;
                long j3 = widgetQzoneVipData.showAdvDuration > 0 ? ((WidgetQzoneVipData) aj.this.E).showAdvDuration : 4500L;
                boolean z16 = widgetQzoneVipData.keepShowAdv != 0;
                if (aj.this.D) {
                    return;
                }
                aj.this.D = true;
                aj.this.f56184h.setImageDrawable(cVar.getDrawable());
                aj.this.f56184h.setVisibility(0);
                aj.this.K(widgetQzoneVipData, Boolean.FALSE);
                if (z16) {
                    return;
                }
                aj.this.f().postDelayed(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ai
                    @Override // java.lang.Runnable
                    public final void run() {
                        aj.a.this.g(cVar);
                    }
                }, j3);
            }
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedSuccess(AnimationDrawable animationDrawable) {
            aj.this.f56185i = animationDrawable;
            aj.this.f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.ag
                @Override // java.lang.Runnable
                public final void run() {
                    aj.a.this.f();
                }
            });
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onNewLoadSuccess(final com.tencent.mobileqq.vas.ui.c cVar) {
            aj.this.f().post(new Runnable() { // from class: com.qzone.reborn.feedx.widget.header.af
                @Override // java.lang.Runnable
                public final void run() {
                    aj.a.this.h(cVar);
                }
            });
        }

        @Override // cooperation.qzone.zipanimate.AnimationDrawableLoadedListener
        public void onLoadedFailed() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes37.dex */
    public class b implements Animation.AnimationListener {
        b() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            aj.this.D = false;
            aj.this.f56184h.setVisibility(8);
            if (aj.this.E == null || aj.this.f56183f == null) {
                return;
            }
            aj.this.f56183f.setVisibility(0);
            aj.this.f56183f.update(aj.this.E);
            if ((aj.this.E instanceof WidgetQzoneVipData) && aj.this.C.M2()) {
                aj.this.f56186m.k(Boolean.TRUE, ((WidgetQzoneVipData) aj.this.E).isVip);
            }
            aj.this.f56183f.startAnimation(aj.this.E());
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
