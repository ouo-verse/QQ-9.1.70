package com.qzone.component.banner;

import TianShuJce.AdItem;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.common.event.ui.model.PublishEventTag;
import com.qzone.component.banner.util.QZoneAvatarLoopAnimationManager;
import com.qzone.reborn.feedx.widget.QZoneUserAvatarView;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.reborn.util.l;
import com.qzone.util.ak;
import com.qzone.util.ar;
import com.tencent.biz.qqcircle.richframework.widget.RoundCornerImageView;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.biz.richframework.part.utils.FastClickUtils;
import com.tencent.libra.LoadState;
import com.tencent.libra.listener.IPicLoadStateListener;
import com.tencent.libra.request.Option;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.tianshu.api.ITianshuManager;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.immersive.ImmersiveUtils;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import cooperation.qzone.report.lp.LpReportManager;
import cooperation.qzone.util.QZonePermission;
import cooperation.qzone.video.QzoneVideoBeaconReport;
import ho.i;
import java.util.ArrayList;
import java.util.Map;
import rn.g;

/* loaded from: classes39.dex */
public class QZoneGuidePublishMoodBanner extends Banner {
    private LinearLayout C;
    private ImageView D;
    private ImageView E;
    private RoundCornerImageView F;
    private TextView G;
    private TextView H;
    private QZoneUserAvatarView I;
    private long J;
    private String K;
    private String L;
    private boolean M;
    private AdItem N;
    private String P;
    private String Q;
    private int R;
    private QZoneAvatarLoopAnimationManager S;

    /* renamed from: h, reason: collision with root package name */
    private Activity f46477h;

    /* renamed from: i, reason: collision with root package name */
    private FrameLayout f46478i;

    /* renamed from: m, reason: collision with root package name */
    private FrameLayout f46479m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class a implements IPicLoadStateListener {
        a() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (!loadState.isFinishSuccess() || option.getAnimatable() == null) {
                return;
            }
            option.getAnimatable().start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes39.dex */
    public class b implements IPicLoadStateListener {
        b() {
        }

        @Override // com.tencent.libra.listener.IPicLoadStateListener
        public void onStateChange(LoadState loadState, Option option) {
            if (loadState.isFinishSuccess() && option.getAnimatable() != null) {
                option.getAnimatable().start();
            } else {
                RFWLog.e("QZoneGuidePublishMoodBanner", RFWLog.USR, "load guide publish mood banner fail");
            }
        }
    }

    public QZoneGuidePublishMoodBanner(Activity activity) {
        super(activity);
        this.f46477h = activity;
    }

    private void A() {
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(8);
    }

    private void B() {
        ImageView imageView = this.D;
        if (imageView == null) {
            return;
        }
        s5.a.b(imageView, fd.a.f398306e, false);
        this.D.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.component.banner.c
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneGuidePublishMoodBanner.this.O(view);
            }
        });
    }

    private void C() {
        if (L()) {
            E();
            I();
            F();
            A();
            H();
        }
    }

    private void D() {
        if (this.f46479m == null) {
            return;
        }
        if (QQTheme.isNowThemeIsNightForQzone()) {
            this.f46479m.setBackgroundResource(R.drawable.ldj);
        } else {
            this.f46479m.setBackgroundResource(R.drawable.qui_common_fill_standard_primary_bg_corner_4);
        }
        W();
        this.f46479m.setOnClickListener(new View.OnClickListener() { // from class: com.qzone.component.banner.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                QZoneGuidePublishMoodBanner.this.P(view);
            }
        });
        this.f46478i.setVisibility(0);
    }

    private void E() {
        FrameLayout frameLayout = this.f46479m;
        if (frameLayout != null && (frameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f46479m.getLayoutParams();
            layoutParams.height = ImmersiveUtils.dpToPx(56.0f);
            this.f46479m.setLayoutParams(layoutParams);
        }
    }

    private void F() {
        TextView textView;
        if (this.C == null || (textView = this.G) == null || !(textView.getLayoutParams() instanceof LinearLayout.LayoutParams)) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.G.getLayoutParams();
        layoutParams.setMargins(ImmersiveUtils.dpToPx(12.0f), 0, 0, 0);
        layoutParams.gravity = 16;
        this.G.setLayoutParams(layoutParams);
        if (this.C.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.C.getLayoutParams();
            layoutParams2.setMargins(ImmersiveUtils.dpToPx(16.0f), ImmersiveUtils.dpToPx(12.0f), 0, 0);
            this.C.setLayoutParams(layoutParams2);
            this.C.setGravity(16);
        }
    }

    private void G() {
        FrameLayout frameLayout = this.f46478i;
        if (frameLayout == null || this.f46477h == null) {
            return;
        }
        this.f46297e = true;
        this.f46479m = (FrameLayout) frameLayout.findViewById(R.id.f68633gk);
        this.D = (ImageView) this.f46478i.findViewById(R.id.f68603gh);
        this.E = (ImageView) this.f46478i.findViewById(R.id.f68623gj);
        this.C = (LinearLayout) this.f46478i.findViewById(R.id.f68653gm);
        this.I = (QZoneUserAvatarView) this.f46478i.findViewById(R.id.f68613gi);
        this.G = (TextView) this.f46478i.findViewById(R.id.f68643gl);
        this.H = (TextView) this.f46478i.findViewById(R.id.f68663gn);
        this.F = (RoundCornerImageView) this.f46478i.findViewById(R.id.f164564t33);
    }

    private void H() {
        ImageView imageView = this.E;
        if (imageView != null && (imageView.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.E.getLayoutParams();
            layoutParams.width = ImmersiveUtils.dpToPx(56.0f);
            layoutParams.height = ImmersiveUtils.dpToPx(56.0f);
            this.E.setLayoutParams(layoutParams);
        }
    }

    private void I() {
        QZoneUserAvatarView qZoneUserAvatarView = this.I;
        if (qZoneUserAvatarView == null) {
            return;
        }
        qZoneUserAvatarView.setUser(LoginData.getInstance().getUin());
        this.I.setIsShieldJumpToMainPage(true);
        this.I.setVisibility(0);
    }

    private boolean J() {
        return this.R == 0;
    }

    private boolean K() {
        return this.R == 1;
    }

    private boolean L() {
        return this.R == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void O(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        N();
        EventCollector.getInstance().onViewClicked(view);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void P(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (FastClickUtils.isFastDoubleClick("QZoneGuidePublishMoodBanner")) {
            RFWLog.d("QZoneGuidePublishMoodBanner", RFWLog.USR, "fast click");
        } else {
            M();
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    private void Q(boolean z16) {
        LpReportInfo_pf00064 lpReportInfo_pf00064 = new LpReportInfo_pf00064();
        lpReportInfo_pf00064.actionType = 1300;
        lpReportInfo_pf00064.subactionType = z16 ? 1 : 2;
        lpReportInfo_pf00064.reserves3 = String.valueOf(this.J);
        lpReportInfo_pf00064.reserves4 = this.L;
        LpReportManager.getInstance().reportToPF00064(lpReportInfo_pf00064, false, false);
        ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.a(z16 ? 101 : 102, this.J, this.L));
    }

    private void S() {
        if (this.N == null) {
            return;
        }
        y(true);
        Q(true);
        C();
        Map<String, String> map = this.N.argList;
        if (map == null) {
            return;
        }
        String str = map.get("pic");
        this.K = map.get("background");
        String str2 = map.get("text");
        ArrayList<String> arrayList = this.N.lstPic;
        String str3 = map.get("tag");
        String str4 = map.get("taguin");
        String str5 = map.get("event_tag_hot_text");
        D();
        B();
        V(this.K);
        Z(str);
        X(str2);
        a0(str3, str4);
        Y(str5);
    }

    private void T(com.qzone.feed.business.model.a aVar) {
        AdItem adItem = this.N;
        if (adItem != null && adItem.iAdId != 0 && !TextUtils.isEmpty(adItem.traceinfo)) {
            AdItem adItem2 = this.N;
            this.J = adItem2.iAdId;
            this.L = adItem2.traceinfo;
        } else {
            BusinessADBannerData businessADBannerData = aVar.f47123g;
            this.J = businessADBannerData.iAdID;
            this.L = String.valueOf(businessADBannerData.iTraceID);
        }
    }

    private void V(String str) {
        if (this.F == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            this.F.setVisibility(8);
            return;
        }
        this.F.setVisibility(0);
        this.F.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.F.setCorner(ar.d(4.0f));
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(this.F).setRequestWidth(ar.l()).setRequestHeight(ImmersiveUtils.dpToPx(56.0f)).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setLoadingDrawableColor(getContext().getResources().getColor(R.color.f156918f7)).setFailedDrawableId(R.drawable.fux), new a());
    }

    private void W() {
        FrameLayout frameLayout = this.f46479m;
        if (frameLayout == null || !(frameLayout.getLayoutParams() instanceof FrameLayout.LayoutParams)) {
            return;
        }
        this.f46479m.setLayoutParams(pl.a.f426446a.c(this.f46477h, (FrameLayout.LayoutParams) this.f46479m.getLayoutParams()));
    }

    private void X(String str) {
        int parseColor;
        TextView textView = this.G;
        if (textView == null || this.f46477h == null) {
            return;
        }
        if (TextUtils.isEmpty(this.K)) {
            parseColor = this.f46477h.getResources().getColor(R.color.qui_common_text_secondary);
        } else {
            parseColor = Color.parseColor("#999999");
        }
        textView.setTextColor(parseColor);
        this.G.setText(str);
    }

    private void Y(String str) {
        if (this.H == null || TextUtils.isEmpty(str)) {
            return;
        }
        if (!K()) {
            this.H.setVisibility(8);
        } else {
            this.H.setText(str);
        }
    }

    private void Z(String str) {
        if (this.E == null) {
            return;
        }
        if (TextUtils.isEmpty(str)) {
            RFWLog.e("QZoneGuidePublishMoodBanner", RFWLog.USR, "guide publish mood banner url is empty");
            this.E.setVisibility(8);
        } else {
            this.E.setVisibility(0);
        }
        this.E.setScaleType(ImageView.ScaleType.CENTER_CROP);
        com.tencent.mobileqq.qzone.picload.c.a().i(Option.obtain().setUrl(str).setTargetView(this.E).setFromPreLoad(false).setPredecode(true).setSupportRecycler(true).setRequestWidth(ImmersiveUtils.dpToPx(56.0f)).setRequestHeight(ImmersiveUtils.dpToPx(56.0f)).setLoadingDrawableColor(getContext().getResources().getColor(R.color.f156918f7)).setFailedDrawableId(R.drawable.fux), new b());
    }

    private void a0(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.P = str;
        this.Q = str2;
    }

    private void w() {
        Map<String, String> map;
        AdItem adItem = this.N;
        if (adItem == null || (map = adItem.argList) == null) {
            return;
        }
        this.M = TextUtils.isEmpty(map.get("tag")) && TextUtils.isEmpty(map.get("taguin"));
    }

    private void y(boolean z16) {
        AdItem adItem = this.N;
        if (adItem != null && !TextUtils.isEmpty(String.valueOf(adItem.iAdId)) && !TextUtils.isEmpty(String.valueOf(this.N.traceinfo))) {
            ak.f(this.N, z16 ? 101 : 102);
        } else {
            ((ITianshuManager) QRoute.api(ITianshuManager.class)).report(ak.a(z16 ? 101 : 102, this.J, this.L));
        }
    }

    private PublishEventTag z() {
        PublishEventTag publishEventTag = new PublishEventTag();
        publishEventTag.title = this.P;
        if (this.N != null) {
            publishEventTag.advId = String.valueOf(this.J);
        }
        publishEventTag.f45887protocol = this.Q + "_102_" + this.P;
        return publishEventTag;
    }

    public void U(String str) {
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(1);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0(str);
        qZonePublishMoodInitBean.v0(bool);
        qZonePublishMoodInitBean.O0(11);
        qZonePublishMoodInitBean.J0(l.f59550a.e(z()));
        qZonePublishMoodInitBean.L0(z().title);
        qZonePublishMoodInitBean.j0(z().advId);
        qZonePublishMoodInitBean.K0(z().f45887protocol);
        i.w().c(this.f46477h, qZonePublishMoodInitBean);
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 700;
    }

    @Override // com.qzone.component.banner.Banner
    public void destroy() {
        super.destroy();
        QZoneAvatarLoopAnimationManager qZoneAvatarLoopAnimationManager = this.S;
        if (qZoneAvatarLoopAnimationManager != null) {
            qZoneAvatarLoopAnimationManager.i();
        }
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 29;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        QLog.d("QZoneGuidePublishMoodBanner", 1, "internal_show fail, needShow: " + z16 + ", mContainer: " + this.f46478i + ", isBannerInitialized: " + this.f46297e);
        if (this.f46478i == null || !this.f46297e) {
            return;
        }
        if (this.M && !g.d()) {
            this.f46478i.setVisibility(8);
        } else if (z16 && !J()) {
            this.f46298f = false;
            S();
        } else {
            this.f46478i.setVisibility(8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        FrameLayout frameLayout;
        return this.f46297e && (frameLayout = this.f46478i) != null && frameLayout.getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void n(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        W();
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        if (aVar != null && aVar.f47123g != null) {
            QLog.d("QZoneGuidePublishMoodBanner", 1, "show guide publish mood banner");
            x();
            this.N = com.qzone.component.banner.util.b.a(aVar);
            w();
            T(aVar);
            this.f46298f = true;
            c();
            return;
        }
        QLog.e("QZoneGuidePublishMoodBanner", 1, "updateBannerData fail: " + aVar);
    }

    private void M() {
        Map<String, String> map;
        y(false);
        Q(false);
        AdItem adItem = this.N;
        if (adItem != null && (map = adItem.argList) != null && !TextUtils.isEmpty(map.get("url"))) {
            String str = this.N.argList.get("url");
            QLog.d("QZoneGuidePublishMoodBanner", 1, "[jumpToPublishMood] jump by schema:" + str);
            yo.d.d(str, this.f46477h, null);
            return;
        }
        QLog.d("QZoneGuidePublishMoodBanner", 1, "[jumpToPublishMood] jump by native");
        QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
        qZonePublishMoodInitBean.t0(0);
        Boolean bool = Boolean.FALSE;
        qZonePublishMoodInitBean.R0(bool);
        qZonePublishMoodInitBean.C0("shuoshuoPlus");
        qZonePublishMoodInitBean.O0(21);
        qZonePublishMoodInitBean.G0(Boolean.TRUE);
        qZonePublishMoodInitBean.J0(l.f59550a.e(z()));
        qZonePublishMoodInitBean.v0(bool);
        i.w().c(this.f46477h, qZonePublishMoodInitBean);
    }

    private void N() {
        y(false);
        Q(false);
        AdItem adItem = this.N;
        if (adItem != null && !TextUtils.isEmpty(adItem.jumpurl)) {
            yo.d.d(this.N.jumpurl, this.f46477h, null);
            return;
        }
        QzoneVideoBeaconReport.reportAlbumEvent(LoginData.getInstance().getUinString(), QzoneVideoBeaconReport.EVENT_ALBUM_ADD_ALBUM);
        Activity activity = this.f46477h;
        if (activity != null && QZonePermission.requestStoragePermission(activity, QQPermissionConstants.Business.SCENE.QQ_QZONE_SHUOSHUO_ALBUM_OPEN_MEDIA)) {
            U("toolBar");
        }
    }

    private void x() {
        this.R = 2;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            return;
        }
        View inflate = viewStub.inflate();
        if (inflate instanceof FrameLayout) {
            FrameLayout frameLayout = (FrameLayout) inflate;
            this.f46478i = frameLayout;
            frameLayout.setBackgroundResource(R.drawable.qui_common_fill_light_primary_bg);
            G();
        }
    }
}
