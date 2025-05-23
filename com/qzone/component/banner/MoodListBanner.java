package com.qzone.component.banner;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.OvershootInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;
import com.qzone.common.account.LoginData;
import com.qzone.proxy.feedcomponent.util.j;
import com.qzone.reborn.route.QZonePublishMoodInitBean;
import com.qzone.util.am;
import com.qzone.widget.AsyncImageView;
import com.qzone.widget.AvatarImageView;
import com.tencent.aelight.camera.api.IAEMaterialManager;
import com.tencent.aelight.camera.util.api.IAECameraPrefsUtil;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import common.config.service.QzoneConfig;
import cooperation.peak.PeakConstants;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.RDMEtraMsgCollector;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;
import ho.i;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes39.dex */
public class MoodListBanner extends Banner {
    private AvatarImageView C;
    private AsyncImageView D;
    private AsyncImageView E;
    private AsyncImageView F;
    private View G;
    private TextView H;
    private TextView I;
    private View J;
    private int K;
    private boolean L;
    private final String M;
    private String N;
    private List<ps.a> P;
    private ArrayList<ps.a> Q;
    private View.OnClickListener R;
    private long S;
    public View.OnClickListener T;
    private long U;
    public View.OnClickListener V;

    /* renamed from: h, reason: collision with root package name */
    public String f46359h;

    /* renamed from: i, reason: collision with root package name */
    private Context f46360i;

    /* renamed from: m, reason: collision with root package name */
    private ViewGroup f46361m;

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            if (MoodListBanner.this.f46360i != null) {
                yo.d.b(MoodListBanner.this.f46360i, new yo.g(MoodListBanner.this.N));
                if (j.g()) {
                    j.e("MoodListBanner", 2, "open camera success: mScheme=" + MoodListBanner.this.N);
                }
                if ("mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzonePublishFrame&uin=&appid=406&widgetid=&shareto=2".equals(MoodListBanner.this.N)) {
                    LpReportInfo_pf00064.allReport(302, 500, 4);
                } else {
                    LpReportInfo_pf00064.allReport(302, 500, 2);
                }
            } else {
                j.c("MoodListBanner", "open camera failed: mContext == null");
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - MoodListBanner.this.S >= 1000) {
                MoodListBanner.this.S = currentTimeMillis;
                RDMEtraMsgCollector.getInstance().addNoramlClickAction(MoodListBanner.this.f46359h, view);
                QZonePublishMoodInitBean qZonePublishMoodInitBean = new QZonePublishMoodInitBean(System.currentTimeMillis());
                qZonePublishMoodInitBean.t0(0);
                Boolean bool = Boolean.FALSE;
                qZonePublishMoodInitBean.R0(bool);
                qZonePublishMoodInitBean.v0(bool);
                qZonePublishMoodInitBean.C0("shuoshuoList");
                qZonePublishMoodInitBean.O0(22);
                qZonePublishMoodInitBean.G0(Boolean.TRUE);
                i.w().c(MoodListBanner.this.f46360i, qZonePublishMoodInitBean);
                LpReportInfo_pf00064.allReport(302, 500, 6);
                com.qzone.misc.network.report.b.d();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes39.dex */
    class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - MoodListBanner.this.U >= 1000) {
                MoodListBanner.this.U = currentTimeMillis;
                QZoneHelper.UserInfo userInfo = QZoneHelper.UserInfo.getInstance();
                userInfo.qzone_uin = LoginData.getInstance().getUin() + "";
                userInfo.nickname = LoginData.getInstance().getNickName("");
                QZoneHelper.forwardToShuoshuoDailyCalendar((Activity) MoodListBanner.this.f46360i, userInfo, -1);
                LpReportInfo_pf00064.allReport(302, 500, 8);
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public MoodListBanner(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet J() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setStartOffset(0L);
        scaleAnimation.setAnimationListener(new e());
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet K() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(200L);
        scaleAnimation.setStartOffset(0L);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setAnimationListener(new f());
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    private AnimationSet L() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 90.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(500L);
        rotateAnimation.setStartOffset(500L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(500L);
        scaleAnimation.setStartOffset(500L);
        scaleAnimation.setAnimationListener(new d());
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setStartOffset(1000L);
        animationSet.addAnimation(scaleAnimation2);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet M() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        RotateAnimation rotateAnimation = new RotateAnimation(90.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(300L);
        rotateAnimation.setStartOffset(0L);
        animationSet.addAnimation(rotateAnimation);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setDuration(300L);
        scaleAnimation.setStartOffset(0L);
        animationSet.addAnimation(scaleAnimation);
        return animationSet;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AnimationSet N() {
        AnimationSet animationSet = new AnimationSet(false);
        animationSet.setFillAfter(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setInterpolator(new OvershootInterpolator());
        scaleAnimation.setDuration(300L);
        scaleAnimation.setStartOffset(40L);
        scaleAnimation.setAnimationListener(new g());
        animationSet.addAnimation(scaleAnimation);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 0.0f, 1.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation2.setDuration(200L);
        scaleAnimation2.setStartOffset(2000L);
        scaleAnimation2.setAnimationListener(new h());
        animationSet.addAnimation(scaleAnimation2);
        return animationSet;
    }

    private void P() {
        this.Q = ((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).stringToLastMaterialList(LocalMultiProcConfig.getString("secondary_mood_list_banner_widget_datas", ""));
        ArrayList<ps.a> stringToLastMaterialList = ((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).stringToLastMaterialList(((IAECameraPrefsUtil) QRoute.api(IAECameraPrefsUtil.class)).getString(PeakConstants.KEY_LATEST_MATERIAL, "", 4));
        ArrayList<ps.a> arrayList = this.Q;
        if (arrayList != null && arrayList.size() != 0) {
            if (this.P == null) {
                this.P = new ArrayList();
            }
            if (stringToLastMaterialList != null) {
                for (ps.a aVar : stringToLastMaterialList) {
                    if (!this.Q.contains(aVar)) {
                        this.P.add(aVar);
                    }
                }
                return;
            }
            return;
        }
        this.P = stringToLastMaterialList;
    }

    private void S(final ps.a aVar) {
        T();
        if (aVar == null) {
            this.N = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzonePublishFrame&uin=&appid=406&widgetid=&shareto=2";
            LpReportInfo_pf00064.allReport(302, 500, 3);
        } else {
            if (am.h(aVar.b())) {
                return;
            }
            ImageLoader.getInstance().loadImage(aVar.b(), new ImageLoader.ImageLoadListener() { // from class: com.qzone.component.banner.MoodListBanner.4
                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageLoaded(String str, final Drawable drawable, ImageLoader.Options options) {
                    if (MoodListBanner.this.D != null) {
                        MoodListBanner.this.D.post(new Runnable() { // from class: com.qzone.component.banner.MoodListBanner.4.1
                            @Override // java.lang.Runnable
                            public void run() {
                                MoodListBanner.this.D.setImageDrawable(drawable);
                                MoodListBanner.this.Q();
                                if (MoodListBanner.this.Q == null) {
                                    MoodListBanner.this.Q = new ArrayList();
                                }
                                if (MoodListBanner.this.Q.contains(aVar)) {
                                    return;
                                }
                                MoodListBanner.this.Q.add(aVar);
                                LocalMultiProcConfig.putString("secondary_mood_list_banner_widget_datas", ((IAEMaterialManager) QRoute.api(IAEMaterialManager.class)).materialListToString(MoodListBanner.this.Q));
                            }
                        });
                    }
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageCanceled(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageFailed(String str, ImageLoader.Options options) {
                }

                @Override // com.tencent.component.media.image.ImageLoader.ImageLoadListener
                public void onImageProgress(String str, float f16, ImageLoader.Options options) {
                }
            });
        }
    }

    private void T() {
        if (this.J != null) {
            this.K = LocalMultiProcConfig.getInt4Uin("qzone_applist_daily_shuoshuo_count", 0, LoginData.getInstance().getUin());
            this.K = LocalMultiProcConfig.getInt4Uin("qzone_daily_shuoshuo_count", -1, LoginData.getInstance().getUin());
            boolean config = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_QZONE_SHUOSHUO_CALENDAR_FRIEND_FEED, true);
            this.L = config;
            if (this.K > 0 && config) {
                this.J.setVisibility(0);
                this.I.setText(String.valueOf(this.K));
                LpReportInfo_pf00064.allReport(302, 500, 7);
                return;
            }
            this.J.setVisibility(8);
        }
    }

    public void O() {
        View findViewById = this.f46361m.findViewById(R.id.l3_);
        this.G = findViewById;
        findViewById.setVisibility(0);
        this.G.setOnClickListener(this.R);
        AsyncImageView asyncImageView = (AsyncImageView) this.f46361m.findViewById(R.id.aok);
        this.E = asyncImageView;
        asyncImageView.setImageResource(R.drawable.bhw);
        this.E.setVisibility(0);
        AsyncImageView asyncImageView2 = (AsyncImageView) this.f46361m.findViewById(R.id.dvz);
        this.F = asyncImageView2;
        asyncImageView2.setImageResource(R.drawable.bhx);
        this.F.setVisibility(0);
        ThemeUtil.setColorFilterIfNeed(this.F, com.qzone.adapter.feedcomponent.i.H().p1());
        ThemeUtil.setColorFilterIfNeed(this.E, com.qzone.adapter.feedcomponent.i.H().p1());
        AsyncImageView asyncImageView3 = (AsyncImageView) this.f46361m.findViewById(R.id.f167127l34);
        this.D = asyncImageView3;
        asyncImageView3.setVisibility(4);
    }

    public void Q() {
        AsyncImageView asyncImageView = this.E;
        if (asyncImageView != null) {
            asyncImageView.clearAnimation();
        }
        AsyncImageView asyncImageView2 = this.D;
        if (asyncImageView2 != null) {
            asyncImageView2.clearAnimation();
        }
        AsyncImageView asyncImageView3 = this.F;
        if (asyncImageView3 != null) {
            asyncImageView3.clearAnimation();
            this.F.startAnimation(L());
        }
    }

    @Override // com.qzone.component.banner.Banner
    public int d() {
        return 1023;
    }

    @Override // com.qzone.component.banner.Banner
    public int e() {
        return 27;
    }

    @Override // com.qzone.component.banner.Banner
    public void h(ViewStub viewStub) {
        if (viewStub == null) {
            j.c("MoodListBanner", "initView: viewStub == null");
            return;
        }
        ViewGroup viewGroup = (ViewGroup) viewStub.inflate();
        this.f46361m = viewGroup;
        if (viewGroup == null) {
            j.c("MoodListBanner", "initView: viewStub.inflate() failed");
            return;
        }
        viewGroup.findViewById(R.id.hki).setBackgroundColor(getResources().getColor(R.color.qzone_skin_common_white2black_color));
        AvatarImageView avatarImageView = (AvatarImageView) this.f46361m.findViewById(R.id.eyj);
        this.C = avatarImageView;
        avatarImageView.setVisibility(8);
        O();
        P();
        TextView textView = (TextView) this.f46361m.findViewById(R.id.k8g);
        this.H = textView;
        textView.setOnClickListener(this.T);
        LpReportInfo_pf00064.allReport(302, 500, 5);
        this.I = (TextView) this.f46361m.findViewById(R.id.f166309lw1);
        View findViewById = this.f46361m.findViewById(R.id.f166310lw2);
        this.J = findViewById;
        findViewById.setOnClickListener(this.V);
        T();
        this.f46297e = true;
    }

    @Override // com.qzone.component.banner.Banner
    public void i(boolean z16) {
        if (!this.f46297e) {
            j.c("MoodListBanner", "internal_show: banner\u8fd8\u672a\u521d\u59cb\u5316\u6216\u521d\u59cb\u5316\u5931\u8d25");
        } else {
            this.f46361m.setVisibility(z16 ? 0 : 8);
        }
    }

    @Override // com.qzone.component.banner.Banner
    public boolean j() {
        return false;
    }

    @Override // com.qzone.component.banner.Banner
    public boolean k() {
        return true;
    }

    @Override // com.qzone.component.banner.Banner
    public boolean l() {
        return this.f46297e && this.f46361m.getVisibility() == 0;
    }

    @Override // com.qzone.component.banner.Banner
    public void t(com.qzone.feed.business.model.a aVar) {
        List<ps.a> list = this.P;
        if (list != null && list.size() != 0) {
            S(this.P.get(0));
            this.P.remove(0);
        } else {
            S(null);
        }
    }

    public MoodListBanner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f46359h = getClass().getSimpleName();
        this.K = 0;
        this.L = true;
        this.M = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzonePublishFrame&uin=&appid=406&widgetid=&shareto=2";
        this.N = "mqqapi://videostory/takevideo?src_type=internal&version=1&from=qzonePublishFrame&uin=&appid=406&widgetid=&shareto=2";
        this.R = new a();
        this.S = 0L;
        this.T = new b();
        this.U = 0L;
        this.V = new c();
        this.f46360i = context;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class d implements Animation.AnimationListener {
        d() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MoodListBanner.this.E != null) {
                MoodListBanner.this.E.clearAnimation();
                MoodListBanner.this.E.startAnimation(MoodListBanner.this.J());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class e implements Animation.AnimationListener {
        e() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MoodListBanner.this.D != null) {
                MoodListBanner.this.D.clearAnimation();
                MoodListBanner.this.D.startAnimation(MoodListBanner.this.N());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class f implements Animation.AnimationListener {
        f() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MoodListBanner.this.F != null) {
                MoodListBanner.this.F.clearAnimation();
                MoodListBanner.this.F.startAnimation(MoodListBanner.this.M());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class g implements Animation.AnimationListener {
        g() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MoodListBanner.this.D != null) {
                MoodListBanner.this.D.setVisibility(8);
            }
            LpReportInfo_pf00064.allReport(302, 500, 1);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            if (MoodListBanner.this.D != null) {
                MoodListBanner.this.D.setVisibility(0);
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes39.dex */
    public class h implements Animation.AnimationListener {
        h() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            if (MoodListBanner.this.E != null) {
                MoodListBanner.this.E.clearAnimation();
                MoodListBanner.this.E.startAnimation(MoodListBanner.this.K());
            }
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
