package com.qzone.cover.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import androidx.lifecycle.Lifecycle;
import com.qzone.business.vip.QZoneVIPUtils;
import com.qzone.common.account.LoginData;
import com.qzone.common.activities.base.ak;
import com.qzone.misc.network.report.ClickReport;
import com.qzone.proxy.personalitycomponent.adapter.PersonalityConfig;
import com.qzone.proxy.vipcomponent.VipComponentProxy;
import com.qzone.proxy.vipcomponent.model.QzoneVipInfo;
import com.qzone.util.ar;
import com.qzone.util.l;
import com.tencent.ad.tangram.statistics.AdReporterForEffect;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasHybridRoute;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import common.config.service.QzoneConfig;
import cooperation.qzone.util.QZLog;
import cooperation.vip.manager.MonitorManager;
import cooperation.vip.vipcomponent.QQUnionIconInfo;
import cooperation.vip.vipcomponent.util.VipResourcesListener;
import java.lang.ref.WeakReference;
import yo.d;
import yo.f;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneVipDecorator extends QzoneComponentDecorator {
    private volatile Drawable M;
    private volatile Drawable N;
    private volatile Drawable P;
    private QzoneComponentDecorator Q;
    private x6.a R;
    private boolean S;
    private boolean T;
    private int U;
    private int V;
    protected QzoneVipInfo W;

    /* renamed from: a0, reason: collision with root package name */
    protected int f46773a0;

    /* renamed from: b0, reason: collision with root package name */
    protected int f46774b0;

    /* renamed from: c0, reason: collision with root package name */
    protected int f46775c0;

    /* renamed from: d0, reason: collision with root package name */
    protected int f46776d0;

    /* renamed from: e0, reason: collision with root package name */
    protected int f46777e0;

    /* renamed from: f0, reason: collision with root package name */
    protected int f46778f0;

    /* renamed from: g0, reason: collision with root package name */
    protected int f46779g0;

    /* renamed from: h0, reason: collision with root package name */
    protected float f46780h0;

    /* renamed from: i0, reason: collision with root package name */
    protected int f46781i0;

    /* renamed from: j0, reason: collision with root package name */
    protected int f46782j0;

    /* renamed from: k0, reason: collision with root package name */
    private Drawable f46783k0;

    /* renamed from: l0, reason: collision with root package name */
    private Handler f46784l0;

    /* renamed from: m0, reason: collision with root package name */
    private Lifecycle f46785m0;

    /* renamed from: n0, reason: collision with root package name */
    VipResourcesListener f46786n0;

    /* renamed from: o0, reason: collision with root package name */
    private Drawable.Callback f46787o0;

    /* renamed from: p0, reason: collision with root package name */
    private View.OnClickListener f46788p0;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements Drawable.Callback {
        b() {
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void invalidateDrawable(Drawable drawable) {
            QzoneVipDecorator.this.invalidate();
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void scheduleDrawable(Drawable drawable, Runnable runnable, long j3) {
            QzoneVipDecorator.this.scheduleDrawable(drawable, runnable, j3);
        }

        @Override // android.graphics.drawable.Drawable.Callback
        public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
            QzoneVipDecorator.this.unscheduleDrawable(drawable, runnable);
        }
    }

    public QzoneVipDecorator(Context context) {
        super(context);
        this.R = null;
        this.S = true;
        this.U = ar.d(120.0f);
        this.V = ar.e(35.0f);
        this.f46773a0 = ar.d(26.0f);
        this.f46774b0 = ar.d(27.0f);
        this.f46775c0 = ar.d(24.0f);
        this.f46776d0 = ar.d(24.0f);
        this.f46777e0 = ar.d(49.0f);
        this.f46778f0 = ar.d(17.0f);
        this.f46779g0 = ar.d(38.0f);
        this.f46780h0 = ar.d(9.0f);
        this.f46781i0 = ar.d(2.0f);
        this.f46782j0 = ar.d(10.0f);
        this.f46784l0 = new Handler(Looper.getMainLooper());
        this.f46786n0 = new a();
        this.f46787o0 = new b();
        this.f46788p0 = new View.OnClickListener() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4
            private boolean a() {
                return QzoneVipDecorator.this.S;
            }

            private void b() {
                QzoneVipDecorator.this.S = false;
                if (QzoneVipDecorator.this.f46784l0 != null) {
                    QzoneVipDecorator.this.f46784l0.postDelayed(new Runnable() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QzoneVipDecorator.this.S = true;
                        }
                    }, 1500L);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeakReference<Activity> weakReference;
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneVipDecorator qzoneVipDecorator = QzoneVipDecorator.this;
                if (qzoneVipDecorator.W != null && (weakReference = qzoneVipDecorator.f46741d) != null && weakReference.get() != null) {
                    Activity activity = QzoneVipDecorator.this.f46741d.get();
                    if (QzoneVipDecorator.this.Q != null && QzoneVipDecorator.this.Q.b()) {
                        QzoneVipDecorator.this.Q.e();
                    } else if (a()) {
                        String str = "1";
                        if (QzoneVipDecorator.this.W.isQQUnionVip()) {
                            if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                d.d(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HOME_URL, QzoneConfig.DEFAULT_UNION_VIP_HOME_URL), "{aid}", "jhan_dhytxgj"), activity, null);
                                ClickReport.m("124", "2", "3");
                            } else {
                                d.p(activity, f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_PAY_URL, QzoneConfig.DEFAULT_UNION_VIP_PAY_URL), "{openUin}", LoginData.getInstance().getUin()), "{openMonth}", 3L), "{aid}", "jhan_dhytxgj"), -1, null, null, null);
                                if (QzoneVipDecorator.this.T) {
                                    str = "2";
                                }
                                ClickReport.m("124", "2", str);
                            }
                        } else {
                            b();
                            int comDiamondType = QzoneVipDecorator.this.W.getComDiamondType();
                            if (comDiamondType != 3 && comDiamondType != 6) {
                                String string = QzoneVipDecorator.this.getContext().getResources().getString(QzoneVipDecorator.this.A() ? R.string.h_9 : R.string.gpz);
                                if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                    if (!QzoneVipDecorator.this.A()) {
                                        Intent p16 = ak.p(activity, "jhan_touxiangzengsong", comDiamondType, string, true, Long.parseLong(QzoneVipDecorator.this.f46742e), QzoneVipDecorator.this.A());
                                        if (comDiamondType == 0) {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.f224276ih));
                                        } else {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.h__));
                                        }
                                        ak.Q(activity, p16, 101);
                                        ClickReport.s("", "", "", AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 5);
                                    } else {
                                        vo.c.R(activity, QzoneVipDecorator.this.f46742e);
                                    }
                                } else {
                                    String stringDataSet = com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-07-12", "qzone_kuikly_pay_url").getStringDataSet("avatar_vip_url", "");
                                    if (!stringDataSet.isEmpty()) {
                                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(activity, stringDataSet);
                                    } else {
                                        ak.Q(activity, ak.p(activity, "jhan_touxiang", comDiamondType, string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 101);
                                    }
                                }
                                QzoneVipDecorator.this.D();
                            } else {
                                ClickReport.m(PersonalityConfig.ACTION_TYPE_STAR_VIP, "1", "2");
                                QZoneVIPUtils.a(QzoneVipDecorator.this.getContext(), "jhan_xztouxiang");
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void D() {
        String str = "1";
        if (!this.T) {
            ClickReport.q("302", "807", "1", true);
            return;
        }
        if (!this.f46743f) {
            str = "2";
        }
        ClickReport.p("308", "11", "8", str, true);
    }

    private void E() {
        String str = "1";
        if (!this.T) {
            ClickReport.q("302", "806", "1", true);
            return;
        }
        if (!this.f46743f) {
            str = "2";
        }
        ClickReport.p("308", "11", "11", str, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String t() {
        QzoneVipInfo qzoneVipInfo = this.W;
        if (qzoneVipInfo != null) {
            int vipType = qzoneVipInfo.getVipType();
            int vipLevel = this.W.getVipLevel();
            switch (vipType) {
                case 0:
                    return l.a(R.string.f172603sf2);
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                    return com.qzone.util.a.a(l.a(R.string.sfb), l.a(R.string.sf9) + vipLevel + l.a(R.string.sf7));
            }
        }
        return l.a(R.string.sf6);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String v(int i3) {
        String str;
        x6.a aVar = this.R;
        if (aVar == null) {
            str = null;
        } else if (aVar.gender == 1) {
            str = String.format(getResources().getString(i3), l.a(R.string.f172604sf3));
        } else {
            str = String.format(getResources().getString(i3), l.a(R.string.sf_));
        }
        return str != null ? str : String.format(getResources().getString(i3), l.a(R.string.sf5));
    }

    private void x(QQUnionIconInfo qQUnionIconInfo, int i3) {
        String str;
        int i16 = qQUnionIconInfo.mIconWidth;
        if (i16 > 0) {
            this.f46773a0 = ar.e(i16 / 2.0f);
        }
        int i17 = qQUnionIconInfo.mIconHeight;
        if (i17 > 0) {
            this.f46774b0 = ar.e(i17 / 2.0f);
        }
        String str2 = qQUnionIconInfo.mIconUrl;
        this.N = null;
        QzoneComponentDecorator.K = null;
        this.P = null;
        this.M = getContext().getResources().getDrawable(i3);
        this.f46781i0 = (QzoneComponentDecorator.H - this.f46774b0) / 2;
        if (this.f46783k0 == null || !str2.equals(((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getAnimationResZipUrl(this.f46783k0))) {
            if (this.f46783k0 != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46783k0);
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f46783k0);
                this.f46783k0 = null;
            }
            this.f46783k0 = ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).getZipAnimationDrawable();
            if (this.f46785m0 != null) {
                ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).bindLifeCycle(this.f46783k0, this.f46785m0);
            }
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setAnimationRes(this.f46783k0, str2, 10);
            this.f46783k0.setCallback(this.f46787o0);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setScale(this.f46783k0, ar.l() / 720.0f);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).clearFirstFrame(this.f46783k0);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setRepeatAnimation(this.f46783k0, true);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).setShowLastFrameWhenStop(this.f46783k0, true);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f46783k0);
        }
        if (!this.T) {
            str = "1";
        } else if (this.f46743f) {
            str = "5";
        } else {
            str = "6";
        }
        ClickReport.j(LoginData.getInstance().getUin(), "", "", "", true, "124", "1", str);
    }

    private void y() {
        if (this.f46783k0 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46783k0);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.f46783k0);
            this.f46783k0 = null;
        }
        int vipType = this.W.getVipType();
        int vipLevel = this.W.getVipLevel();
        boolean isAnnualVip = this.W.isAnnualVip();
        this.W.isAnnualVipEver();
        boolean isCustomDiamond = this.W.isCustomDiamond();
        String customDiamondUrl = this.W.getCustomDiamondUrl();
        if (isCustomDiamond && !TextUtils.isEmpty(customDiamondUrl)) {
            this.f46781i0 = ar.d(4.0f);
        } else if (vipLevel == 9) {
            this.f46781i0 = ar.d(3.0f);
        } else if (!TextUtils.isEmpty(this.W.getPersonalizedYellowVipUrl())) {
            if (A()) {
                this.f46781i0 = ar.d(3.0f);
            }
        } else {
            this.f46781i0 = ar.d(2.0f);
        }
        if (vipType == 1) {
            E();
            this.P = null;
            QzoneComponentDecorator.K = getContext().getResources().getDrawable(R.drawable.f162366gj0);
            if (isCustomDiamond && !TextUtils.isEmpty(customDiamondUrl)) {
                this.M = getContext().getResources().getDrawable(R.drawable.gjn);
            } else {
                this.M = getContext().getResources().getDrawable(R.drawable.g7m);
            }
            this.N = VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(vipLevel, 1, isAnnualVip, isCustomDiamond, customDiamondUrl, 4, 100, this.W.getPersonalizedYellowVipUrl(), this.f46786n0);
            return;
        }
        if (vipType != 2) {
            return;
        }
        E();
        this.P = null;
        QzoneComponentDecorator.K = getContext().getResources().getDrawable(R.drawable.f162366gj0);
        if (isCustomDiamond && !TextUtils.isEmpty(customDiamondUrl)) {
            this.M = getContext().getResources().getDrawable(R.drawable.gjn);
        } else {
            this.M = getContext().getResources().getDrawable(R.drawable.g7m);
        }
        this.N = VipComponentProxy.f50997g.getUiInterface().getYellowVipIcon(vipLevel, 2, isAnnualVip, isCustomDiamond, customDiamondUrl, 4, 100, this.W.getPersonalizedYellowVipUrl(), this.f46786n0);
    }

    public boolean A() {
        QzoneVipInfo qzoneVipInfo = this.W;
        return (qzoneVipInfo == null || qzoneVipInfo.getVipType() == 0) ? false : true;
    }

    public void B() {
        if (this.f46783k0 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.f46783k0);
        }
    }

    public void C() {
        if (this.f46783k0 != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.f46783k0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator
    public void f() {
        if (QZLog.isColorLevel()) {
            QZLog.d("QzoneVipDecorator", 2, "updateData");
        }
        boolean z16 = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DISABLE_SHOW_VIP_INFO, 0) == 0;
        this.W = VipComponentProxy.f50997g.getServiceInterface().getVipInfo(this.f46742e.toString());
        if (!this.f46743f) {
            this.R = z5.a.f().g(Long.parseLong(this.f46742e));
        }
        try {
        } catch (Exception e16) {
            MonitorManager.f().h(10, 9, " prepare resouce exception " + e16, false);
            QZLog.e("QzoneVipDecorator", "prepareResource, run exception", e16);
        } catch (OutOfMemoryError e17) {
            MonitorManager.f().h(10, 6, " prepare resouce oom " + e17, false);
            QZLog.e("QzoneVipDecorator", "prepareResource, run error", e17);
        }
        if (!z16) {
            postInvalidate();
            return;
        }
        if (this.W.isShowNewVip()) {
            QQUnionIconInfo g16 = cooperation.vip.vipcomponent.util.c.g(4, -1, this.W.getQQNewVipIconMap());
            if (g16 != null && !TextUtils.isEmpty(g16.mIconUrl)) {
                x(g16, R.drawable.g7m);
            }
            y();
        } else if (this.W.isQQUnionVip()) {
            QQUnionIconInfo g17 = cooperation.vip.vipcomponent.util.c.g(4, this.W.getQQUnionVipLevel(), this.W.getQQUnionVipIconMap());
            if (g17 != null && !TextUtils.isEmpty(g17.mIconUrl)) {
                x(g17, R.drawable.g7r);
            }
            y();
        } else {
            y();
        }
        setBoundsForDrawable();
        postInvalidate();
        WeakReference<Activity> weakReference = this.f46741d;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        this.f46741d.get().runOnUiThread(new Runnable() { // from class: com.qzone.cover.ui.QzoneVipDecorator.1
            @Override // java.lang.Runnable
            public void run() {
                QzoneVipDecorator qzoneVipDecorator = QzoneVipDecorator.this;
                qzoneVipDecorator.setContentDescription(qzoneVipDecorator.t());
                QzoneVipDecorator qzoneVipDecorator2 = QzoneVipDecorator.this;
                qzoneVipDecorator2.setOnClickListener(qzoneVipDecorator2.f46788p0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qzone.cover.ui.QzoneComponentDecorator, android.view.View
    public void onDraw(Canvas canvas) {
        s(canvas);
        super.onDraw(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i3, int i16) {
        setMeasuredDimension(this.U, this.V);
    }

    public void r(Lifecycle lifecycle) {
        this.f46785m0 = lifecycle;
    }

    protected void s(Canvas canvas) {
        Drawable drawable = this.f46783k0;
        if (drawable == null || ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).isZipDrawableShow(drawable)) {
            canvas.translate(this.f46744h, 0.0f);
            Drawable drawable2 = this.P;
            if (drawable2 != null) {
                canvas.translate((QzoneComponentDecorator.E - this.f46777e0) / 2, this.f46780h0);
                drawable2.draw(canvas);
                canvas.translate((-(QzoneComponentDecorator.E - this.f46777e0)) / 2, -this.f46780h0);
            }
            Drawable drawable3 = this.M;
            if (drawable3 != null) {
                canvas.translate((QzoneComponentDecorator.E - QzoneComponentDecorator.G) / 2, 0.0f);
                drawable3.draw(canvas);
                canvas.translate((-(QzoneComponentDecorator.E - QzoneComponentDecorator.G)) / 2, 0.0f);
            }
            Drawable drawable4 = this.N;
            if (drawable4 != null) {
                canvas.translate((QzoneComponentDecorator.E - this.f46775c0) / 2, this.f46781i0);
                drawable4.draw(canvas);
                canvas.translate((-(QzoneComponentDecorator.E - this.f46775c0)) / 2, -this.f46781i0);
            }
            if (drawable != null) {
                canvas.translate((QzoneComponentDecorator.E - this.f46773a0) / 2, this.f46781i0);
                drawable.draw(canvas);
                canvas.translate((-(QzoneComponentDecorator.E - this.f46773a0)) / 2, -this.f46781i0);
            }
            canvas.translate(-this.f46744h, 0.0f);
        }
    }

    protected void setBoundsForDrawable() {
        if (QzoneComponentDecorator.K != null) {
            QzoneComponentDecorator.K.setBounds(0, 0, QzoneComponentDecorator.J, this.f46779g0);
        }
        if (this.M != null) {
            this.M.setBounds(0, 0, QzoneComponentDecorator.G, QzoneComponentDecorator.H);
        }
        if (this.N != null) {
            this.f46775c0 = this.N.getIntrinsicWidth();
            this.f46776d0 = this.N.getIntrinsicHeight();
            Drawable drawable = this.N;
            int i3 = cooperation.vip.vipcomponent.util.a.f391397b;
            drawable.setBounds(0, i3 - this.f46776d0, this.f46775c0, i3);
        }
        if (this.P != null) {
            this.P.setBounds(0, 0, this.f46777e0, this.f46778f0);
        }
        Drawable drawable2 = this.f46783k0;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, this.f46773a0, this.f46774b0);
        }
    }

    public void setQzoneQbossDecorator(QzoneComponentDecorator qzoneComponentDecorator) {
        this.Q = qzoneComponentDecorator;
    }

    public View.OnClickListener u() {
        return this.f46788p0;
    }

    public void w(Activity activity, String str, boolean z16) {
        this.T = z16;
        super.c(activity, str);
    }

    public boolean z() {
        return (this.W.isQQUnionVip() || this.W.isShowNewVip()) ? false : true;
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements VipResourcesListener {
        a() {
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onLoaded(Drawable drawable) {
            QzoneVipDecorator qzoneVipDecorator = QzoneVipDecorator.this;
            if (qzoneVipDecorator.W != null && qzoneVipDecorator.z()) {
                QzoneVipDecorator.this.N = drawable;
                if (QzoneVipDecorator.this.N != null) {
                    QzoneVipDecorator qzoneVipDecorator2 = QzoneVipDecorator.this;
                    qzoneVipDecorator2.f46775c0 = qzoneVipDecorator2.N.getIntrinsicWidth();
                    QzoneVipDecorator qzoneVipDecorator3 = QzoneVipDecorator.this;
                    qzoneVipDecorator3.f46776d0 = qzoneVipDecorator3.N.getIntrinsicHeight();
                    Drawable drawable2 = QzoneVipDecorator.this.N;
                    int i3 = cooperation.vip.vipcomponent.util.a.f391397b;
                    QzoneVipDecorator qzoneVipDecorator4 = QzoneVipDecorator.this;
                    drawable2.setBounds(0, i3 - qzoneVipDecorator4.f46776d0, qzoneVipDecorator4.f46775c0, i3);
                }
            }
            QzoneVipDecorator.this.postInvalidate();
        }

        @Override // cooperation.vip.vipcomponent.util.VipResourcesListener
        public void onFailed() {
        }
    }

    public QzoneVipDecorator(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.R = null;
        this.S = true;
        this.U = ar.d(120.0f);
        this.V = ar.e(35.0f);
        this.f46773a0 = ar.d(26.0f);
        this.f46774b0 = ar.d(27.0f);
        this.f46775c0 = ar.d(24.0f);
        this.f46776d0 = ar.d(24.0f);
        this.f46777e0 = ar.d(49.0f);
        this.f46778f0 = ar.d(17.0f);
        this.f46779g0 = ar.d(38.0f);
        this.f46780h0 = ar.d(9.0f);
        this.f46781i0 = ar.d(2.0f);
        this.f46782j0 = ar.d(10.0f);
        this.f46784l0 = new Handler(Looper.getMainLooper());
        this.f46786n0 = new a();
        this.f46787o0 = new b();
        this.f46788p0 = new View.OnClickListener() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4
            private boolean a() {
                return QzoneVipDecorator.this.S;
            }

            private void b() {
                QzoneVipDecorator.this.S = false;
                if (QzoneVipDecorator.this.f46784l0 != null) {
                    QzoneVipDecorator.this.f46784l0.postDelayed(new Runnable() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QzoneVipDecorator.this.S = true;
                        }
                    }, 1500L);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeakReference<Activity> weakReference;
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneVipDecorator qzoneVipDecorator = QzoneVipDecorator.this;
                if (qzoneVipDecorator.W != null && (weakReference = qzoneVipDecorator.f46741d) != null && weakReference.get() != null) {
                    Activity activity = QzoneVipDecorator.this.f46741d.get();
                    if (QzoneVipDecorator.this.Q != null && QzoneVipDecorator.this.Q.b()) {
                        QzoneVipDecorator.this.Q.e();
                    } else if (a()) {
                        String str = "1";
                        if (QzoneVipDecorator.this.W.isQQUnionVip()) {
                            if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                d.d(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HOME_URL, QzoneConfig.DEFAULT_UNION_VIP_HOME_URL), "{aid}", "jhan_dhytxgj"), activity, null);
                                ClickReport.m("124", "2", "3");
                            } else {
                                d.p(activity, f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_PAY_URL, QzoneConfig.DEFAULT_UNION_VIP_PAY_URL), "{openUin}", LoginData.getInstance().getUin()), "{openMonth}", 3L), "{aid}", "jhan_dhytxgj"), -1, null, null, null);
                                if (QzoneVipDecorator.this.T) {
                                    str = "2";
                                }
                                ClickReport.m("124", "2", str);
                            }
                        } else {
                            b();
                            int comDiamondType = QzoneVipDecorator.this.W.getComDiamondType();
                            if (comDiamondType != 3 && comDiamondType != 6) {
                                String string = QzoneVipDecorator.this.getContext().getResources().getString(QzoneVipDecorator.this.A() ? R.string.h_9 : R.string.gpz);
                                if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                    if (!QzoneVipDecorator.this.A()) {
                                        Intent p16 = ak.p(activity, "jhan_touxiangzengsong", comDiamondType, string, true, Long.parseLong(QzoneVipDecorator.this.f46742e), QzoneVipDecorator.this.A());
                                        if (comDiamondType == 0) {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.f224276ih));
                                        } else {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.h__));
                                        }
                                        ak.Q(activity, p16, 101);
                                        ClickReport.s("", "", "", AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 5);
                                    } else {
                                        vo.c.R(activity, QzoneVipDecorator.this.f46742e);
                                    }
                                } else {
                                    String stringDataSet = com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-07-12", "qzone_kuikly_pay_url").getStringDataSet("avatar_vip_url", "");
                                    if (!stringDataSet.isEmpty()) {
                                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(activity, stringDataSet);
                                    } else {
                                        ak.Q(activity, ak.p(activity, "jhan_touxiang", comDiamondType, string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 101);
                                    }
                                }
                                QzoneVipDecorator.this.D();
                            } else {
                                ClickReport.m(PersonalityConfig.ACTION_TYPE_STAR_VIP, "1", "2");
                                QZoneVIPUtils.a(QzoneVipDecorator.this.getContext(), "jhan_xztouxiang");
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }

    public QzoneVipDecorator(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.R = null;
        this.S = true;
        this.U = ar.d(120.0f);
        this.V = ar.e(35.0f);
        this.f46773a0 = ar.d(26.0f);
        this.f46774b0 = ar.d(27.0f);
        this.f46775c0 = ar.d(24.0f);
        this.f46776d0 = ar.d(24.0f);
        this.f46777e0 = ar.d(49.0f);
        this.f46778f0 = ar.d(17.0f);
        this.f46779g0 = ar.d(38.0f);
        this.f46780h0 = ar.d(9.0f);
        this.f46781i0 = ar.d(2.0f);
        this.f46782j0 = ar.d(10.0f);
        this.f46784l0 = new Handler(Looper.getMainLooper());
        this.f46786n0 = new a();
        this.f46787o0 = new b();
        this.f46788p0 = new View.OnClickListener() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4
            private boolean a() {
                return QzoneVipDecorator.this.S;
            }

            private void b() {
                QzoneVipDecorator.this.S = false;
                if (QzoneVipDecorator.this.f46784l0 != null) {
                    QzoneVipDecorator.this.f46784l0.postDelayed(new Runnable() { // from class: com.qzone.cover.ui.QzoneVipDecorator.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            QzoneVipDecorator.this.S = true;
                        }
                    }, 1500L);
                }
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WeakReference<Activity> weakReference;
                EventCollector.getInstance().onViewClickedBefore(view);
                QzoneVipDecorator qzoneVipDecorator = QzoneVipDecorator.this;
                if (qzoneVipDecorator.W != null && (weakReference = qzoneVipDecorator.f46741d) != null && weakReference.get() != null) {
                    Activity activity = QzoneVipDecorator.this.f46741d.get();
                    if (QzoneVipDecorator.this.Q != null && QzoneVipDecorator.this.Q.b()) {
                        QzoneVipDecorator.this.Q.e();
                    } else if (a()) {
                        String str = "1";
                        if (QzoneVipDecorator.this.W.isQQUnionVip()) {
                            if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                d.d(f.j(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_HOME_URL, QzoneConfig.DEFAULT_UNION_VIP_HOME_URL), "{aid}", "jhan_dhytxgj"), activity, null);
                                ClickReport.m("124", "2", "3");
                            } else {
                                d.p(activity, f.j(f.i(f.i(QzoneConfig.getInstance().getConfig("H5Url", QzoneConfig.SECONDARY_UNION_VIP_PAY_URL, QzoneConfig.DEFAULT_UNION_VIP_PAY_URL), "{openUin}", LoginData.getInstance().getUin()), "{openMonth}", 3L), "{aid}", "jhan_dhytxgj"), -1, null, null, null);
                                if (QzoneVipDecorator.this.T) {
                                    str = "2";
                                }
                                ClickReport.m("124", "2", str);
                            }
                        } else {
                            b();
                            int comDiamondType = QzoneVipDecorator.this.W.getComDiamondType();
                            if (comDiamondType != 3 && comDiamondType != 6) {
                                String string = QzoneVipDecorator.this.getContext().getResources().getString(QzoneVipDecorator.this.A() ? R.string.h_9 : R.string.gpz);
                                if (QzoneVipDecorator.this.T && !QzoneVipDecorator.this.f46743f) {
                                    if (!QzoneVipDecorator.this.A()) {
                                        Intent p16 = ak.p(activity, "jhan_touxiangzengsong", comDiamondType, string, true, Long.parseLong(QzoneVipDecorator.this.f46742e), QzoneVipDecorator.this.A());
                                        if (comDiamondType == 0) {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.f224276ih));
                                        } else {
                                            p16.putExtra("dialog_msg", QzoneVipDecorator.this.v(R.string.h__));
                                        }
                                        ak.Q(activity, p16, 101);
                                        ClickReport.s("", "", "", AdReporterForEffect.ACTION_MOBILEAPP_QUICKAPP_OPEN_FAILURE, 5);
                                    } else {
                                        vo.c.R(activity, QzoneVipDecorator.this.f46742e);
                                    }
                                } else {
                                    String stringDataSet = com.tencent.mobileqq.vas.ar.b("kenaiyu", "2024-07-12", "qzone_kuikly_pay_url").getStringDataSet("avatar_vip_url", "");
                                    if (!stringDataSet.isEmpty()) {
                                        ((IVasHybridRoute) QRoute.api(IVasHybridRoute.class)).openSchema(activity, stringDataSet);
                                    } else {
                                        ak.Q(activity, ak.p(activity, "jhan_touxiang", comDiamondType, string, false, LoginData.getInstance().getUin(), LoginData.getInstance().isQzoneVip()), 101);
                                    }
                                }
                                QzoneVipDecorator.this.D();
                            } else {
                                ClickReport.m(PersonalityConfig.ACTION_TYPE_STAR_VIP, "1", "2");
                                QZoneVIPUtils.a(QzoneVipDecorator.this.getContext(), "jhan_xztouxiang");
                            }
                        }
                    }
                }
                EventCollector.getInstance().onViewClicked(view);
            }
        };
    }
}
