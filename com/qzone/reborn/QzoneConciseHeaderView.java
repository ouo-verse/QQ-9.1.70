package com.qzone.reborn;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.cover.ui.QzoneAvatarDecorator;
import com.qzone.feed.ui.activity.f;
import com.qzone.reborn.configx.g;
import com.qzone.reborn.util.k;
import com.qzone.reborn.vas.VasLetterNamePlateController;
import com.qzone.widget.QZonePullToRefreshListView;
import com.tencent.biz.richframework.widget.BaseWidgetView;
import com.tencent.biz.subscribe.part.block.base.RefreshHeaderView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.gamecenter.api.IGameCenterRedPointConfigApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.resconfig.MainResourceConfig;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.zplan.api.IZPlanApi;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qzonehub.api.zipanimate.IZipAnimationDrawable;
import com.tencent.widget.AbsListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.util.QZLog;
import gf.o;
import ho.i;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes39.dex */
public class QzoneConciseHeaderView extends BaseWidgetView implements f {
    private o C;
    private View D;
    private LinearLayout E;
    private RefreshHeaderView F;
    private boolean G;
    private Drawable H;
    private VasLetterNamePlateController I;

    /* renamed from: d, reason: collision with root package name */
    private TextView f52159d;

    /* renamed from: e, reason: collision with root package name */
    private TextView f52160e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f52161f;

    /* renamed from: h, reason: collision with root package name */
    private RelativeLayout f52162h;

    /* renamed from: i, reason: collision with root package name */
    private QzoneAvatarDecorator f52163i;

    /* renamed from: m, reason: collision with root package name */
    private View.OnClickListener f52164m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class a implements RefreshHeaderView.b {
        a() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.b
        public boolean a() {
            return QzoneConciseHeaderView.this.C.isFeedViewListOnTop();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class b implements RefreshHeaderView.c {
        b() {
        }

        @Override // com.tencent.biz.subscribe.part.block.base.RefreshHeaderView.c
        public void onRefresh() {
            if (QzoneConciseHeaderView.this.C != null) {
                QzoneConciseHeaderView.this.C.onRefresh();
                QzoneConciseHeaderView.this.C.stopAllAudio();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            i.z().m(QzoneConciseHeaderView.this.getContext(), LoginData.getInstance().getUin());
            int id5 = view == null ? -1 : view.getId();
            if (id5 == R.id.f68253fj) {
                LpReportInfo_pf00064.allReport(143, 2, 2);
            } else if (id5 == R.id.f110416ig) {
                LpReportInfo_pf00064.allReport(143, 3, 2);
            }
            com.qzone.misc.network.report.a.c();
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class d implements QZonePullToRefreshListView.a {
        d() {
        }

        @Override // com.qzone.widget.QZonePullToRefreshListView.a
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            if (QzoneConciseHeaderView.this.F == null) {
                return false;
            }
            QzoneConciseHeaderView.this.F.handleRefreshGesture(motionEvent);
            QzoneConciseHeaderView qzoneConciseHeaderView = QzoneConciseHeaderView.this;
            qzoneConciseHeaderView.p0(qzoneConciseHeaderView.C);
            return false;
        }
    }

    public QzoneConciseHeaderView(Context context) {
        super(context);
        this.G = true;
        x0(context, this);
    }

    private void A0() {
        getMainHandler().post(new Runnable() { // from class: com.qzone.reborn.QzoneConciseHeaderView.3
            @Override // java.lang.Runnable
            public void run() {
                String nickName = LoginData.getInstance().getNickName(LoginData.getInstance().getUinString());
                if (QzoneConciseHeaderView.this.f52159d == null || TextUtils.isEmpty(nickName)) {
                    return;
                }
                int length = nickName.length() - 10;
                if (length > 0 && !g.f53821a.b().z1()) {
                    QzoneConciseHeaderView.this.f52159d.setText(nickName.substring(0, nickName.length() - length) + MiniBoxNoticeInfo.APPNAME_SUFFIX);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append("\u8d85\u51fa");
                    sb5.append(nickName.length() - 10);
                    sb5.append("\u4e2a\u5b57,\u622a\u65ad");
                    QLog.i("QzoneConciseHeaderView", 2, sb5.toString());
                } else {
                    QzoneConciseHeaderView.this.f52159d.setText(nickName);
                }
                LpReportInfo_pf00064.allReport(143, 3, 1);
            }
        });
    }

    private void B0() {
        this.I.v(this.f52161f, this.H);
    }

    private View o0(com.tencent.mobileqq.leba.feed.c cVar) {
        View a16 = cVar.a();
        a16.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
        if (a16.getParent() instanceof ViewGroup) {
            ((ViewGroup) a16.getParent()).removeView(a16);
        }
        return a16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p0(o oVar) {
        boolean g16 = this.F.g();
        if (g16 != this.G) {
            this.G = g16;
            oVar.setSupportPullDown(!g16);
        }
    }

    private AppRuntime q0() {
        return MobileQQ.sMobileQQ.waitAppRuntime(null);
    }

    private View.OnClickListener s0() {
        if (this.f52164m == null) {
            this.f52164m = new c();
        }
        return this.f52164m;
    }

    public void C0() {
        QzoneAvatarDecorator qzoneAvatarDecorator = this.f52163i;
        if (qzoneAvatarDecorator != null) {
            qzoneAvatarDecorator.d();
            QLog.i("QzoneConciseHeaderView", 2, "updateAvatar start");
        }
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    public int getLayoutId() {
        return R.layout.hkq;
    }

    @Override // com.qzone.feed.ui.activity.f
    public boolean isRefreshing() {
        RefreshHeaderView refreshHeaderView = this.F;
        if (refreshHeaderView != null) {
            return refreshHeaderView.getIsRefreshing();
        }
        return false;
    }

    public void onDestroy() {
        if (this.H != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.H);
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).release(this.H);
            this.H = null;
        }
    }

    public void onPause() {
        if (this.H != null) {
            ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).stop(this.H);
        }
    }

    public View r0() {
        return this.E;
    }

    public void refresh() {
        A0();
        C0();
    }

    public void setRefreshParent() {
        o oVar;
        if (this.F == null || (oVar = this.C) == null) {
            return;
        }
        oVar.setSupportPullDown(false);
        this.C.setDispatchTouchEventListener(new d());
        this.C.setQZoneRefreshIndicatorInterface(this);
    }

    @Override // com.qzone.feed.ui.activity.f
    public void t() {
        RefreshHeaderView refreshHeaderView = this.F;
        if (refreshHeaderView != null) {
            refreshHeaderView.setRefreshing(true);
            this.F.setState(2);
        }
    }

    public void u0() {
        QzoneAvatarDecorator qzoneAvatarDecorator = this.f52163i;
        if (qzoneAvatarDecorator != null) {
            qzoneAvatarDecorator.setOnClickListener(s0());
            QLog.i("QzoneConciseHeaderView", 2, "\u8df3\u8f6c\u5230\u4e3b\u9875");
        }
        TextView textView = this.f52159d;
        if (textView != null) {
            textView.setOnClickListener(s0());
            QLog.i("QzoneConciseHeaderView", 2, "\u8df3\u8f6c\u5230\u4e3b\u9875");
        }
        RelativeLayout relativeLayout = this.f52162h;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(s0());
            QLog.i("QzoneConciseHeaderView", 2, "\u8df3\u8f6c\u5230\u4e3b\u9875");
        }
        TextView textView2 = this.f52160e;
        if (textView2 != null) {
            textView2.setOnClickListener(s0());
            QLog.i("QzoneConciseHeaderView", 2, "\u8df3\u8f6c\u5230\u4e3b\u9875");
        }
    }

    public void v0(o oVar) {
        QLog.i("QzoneConciseHeaderView", 2, "initData Start");
        this.C = oVar;
        if (oVar != null) {
            this.f52163i.c(oVar.getActivity(), LoginData.getInstance().getUinString());
            this.f52163i.d();
            LpReportInfo_pf00064.allReport(143, 2, 1);
            QLog.i("QzoneConciseHeaderView", 2, "initData AvatarUpdate");
        }
        A0();
        B0();
        o oVar2 = this.C;
        if (oVar2 != null && oVar2.getNavigatorController() != null) {
            ((IGameCenterRedPointConfigApi) QRoute.api(IGameCenterRedPointConfigApi.class)).setBannerContainer(1, this.E);
            this.E.addView(o0(this.C.getNavigatorController()), 1, new LinearLayout.LayoutParams(-1, -2));
            this.C.getNavigatorController().onCreate();
            u0();
        }
        this.I.u(this.C);
    }

    @Override // com.qzone.feed.ui.activity.f
    public void y() {
        RefreshHeaderView refreshHeaderView = this.F;
        if (refreshHeaderView != null) {
            refreshHeaderView.setRefreshing(false);
        }
    }

    public void y0() {
        C0();
        Drawable drawable = this.H;
        if (drawable == null || !drawable.isVisible()) {
            return;
        }
        ((IZipAnimationDrawable) QRoute.api(IZipAnimationDrawable.class)).start(this.H);
    }

    public void z0() {
        RefreshHeaderView refreshHeaderView = this.F;
        if (refreshHeaderView != null) {
            refreshHeaderView.setRefreshing(false);
        }
        B0();
    }

    private void w0() {
        RefreshHeaderView refreshHeaderView = (RefreshHeaderView) findViewById(R.id.f74193vl);
        this.F = refreshHeaderView;
        refreshHeaderView.findViewById(R.id.f110596iy).setVisibility(8);
        ((ImageView) this.F.findViewById(R.id.y4_)).setImageDrawable(null);
        this.F.setMeasuredHeight(ImmersiveUtils.dpToPx(60.0f));
        this.F.setAlwaysShowProgressBar(true);
        this.F.setCanRefreshDelegate(new a());
        this.F.setOnRefreshListener(new b());
        LinearLayout linearLayout = this.E;
        if (linearLayout != null && (linearLayout.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            ((ViewGroup.MarginLayoutParams) this.E.getLayoutParams()).topMargin = MainResourceConfig.i().q(getContext());
        }
    }

    protected void x0(Context context, View view) {
        this.f52159d = (TextView) findViewById(R.id.f110416ig);
        this.f52160e = (TextView) findViewById(R.id.f110406if);
        ImageView imageView = (ImageView) findViewById(R.id.y7m);
        this.f52161f = imageView;
        AccessibilityUtil.s(imageView, "\u4f1a\u5458\u94ed\u724c");
        this.f52162h = (RelativeLayout) findViewById(R.id.f75423yx);
        AccessibilityUtil.c(this.f52160e, "\u8fdb\u5165\u6211\u7684\u8d44\u6599", Button.class.getName());
        AccessibilityUtil.c(this.f52162h, "\u8fdb\u5165\u6211\u7684\u8d44\u6599", Button.class.getName());
        this.E = (LinearLayout) findViewById(R.id.ynt);
        QzoneAvatarDecorator qzoneAvatarDecorator = (QzoneAvatarDecorator) findViewById(R.id.f68253fj);
        this.f52163i = qzoneAvatarDecorator;
        AccessibilityUtil.s(qzoneAvatarDecorator, getResources().getString(R.string.gqm));
        boolean z16 = false;
        this.f52163i.setIsShowAvatarTieDecorator(false);
        this.f52163i.setOnlyAvatarView(ImmersiveUtils.dpToPx(60.0f));
        this.f52163i.d();
        this.D = findViewById(R.id.y27);
        this.I = new VasLetterNamePlateController();
        if (((IZPlanApi) QRoute.api(IZPlanApi.class)).isQzoneEntranceEnabled(q0().getLongAccountUin()) && !k.f59549a.g()) {
            z16 = true;
        }
        QZLog.i("QZoneConciseZPlan QzoneConciseHeaderView", 1, "[onInitView] ZPlanSwitchIsOpen=" + z16);
        if (!z16) {
            w0();
        }
        this.f52159d.setTextColor(getResources().getColor(R.color.qui_common_text_primary));
        this.f52159d.setMaxLines(2);
        this.D.setBackgroundColor(getResources().getColor(R.color.qui_common_border_light));
        this.f52160e.setBackground(getResources().getDrawable(R.drawable.qui_chevron_right_icon_secondary_02));
    }

    @Override // com.tencent.biz.richframework.widget.BaseWidgetView
    protected void bindData(Object obj, int i3) {
    }
}
