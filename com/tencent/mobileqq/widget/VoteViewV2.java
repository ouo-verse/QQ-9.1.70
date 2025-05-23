package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.qzone.album.data.model.PhotoCacheData;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.ApngDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.kuikly.api.IVasKuiklyLogicApi;
import com.tencent.mobileqq.vas.likeArea.api.IVasLikeAreaUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.ui.APNGDrawable;
import com.tencent.mobileqq.vas.ui.IDynamicDrawable;
import com.tencent.mobileqq.vas.updatesystem.business.LikeAreaBusiness;
import com.tencent.mobileqq.vas.util.QQVasUpdateBusinessUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.slf4j.Marker;
import s13.KuikLyConfig;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoteViewV2 extends FrameLayout implements PraiseManager.a {

    /* renamed from: c0, reason: collision with root package name */
    private static final boolean f316529c0 = com.tencent.mobileqq.vas.ar.b("shouyouye", "2024-09-09", "vas_bugfix_130259359").isEnable(true);
    protected int C;
    QQAppInterface D;
    protected com.tencent.mobileqq.profile.like.b E;
    private Context F;
    private LayoutInflater G;
    protected double H;
    protected ViewGroup I;
    protected TextView J;
    private HeartLayout K;
    private com.tencent.mobileqq.hotchat.ui.b L;
    private boolean M;
    protected boolean N;
    protected boolean P;
    private boolean Q;
    protected ImageView R;
    protected ImageView S;
    private ImageView T;
    private int U;
    private int V;
    private int W;

    /* renamed from: a0, reason: collision with root package name */
    private int f316530a0;

    /* renamed from: b0, reason: collision with root package name */
    private Runnable f316531b0;

    /* renamed from: d, reason: collision with root package name */
    public boolean f316532d;

    /* renamed from: e, reason: collision with root package name */
    public int f316533e;

    /* renamed from: f, reason: collision with root package name */
    public int f316534f;

    /* renamed from: h, reason: collision with root package name */
    protected TextView f316535h;

    /* renamed from: i, reason: collision with root package name */
    protected ImageView f316536i;

    /* renamed from: m, reason: collision with root package name */
    protected TextView f316537m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.widget.VoteViewV2$3, reason: invalid class name */
    /* loaded from: classes20.dex */
    public class AnonymousClass3 implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f316539d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ImageView f316540e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: P */
        /* renamed from: com.tencent.mobileqq.widget.VoteViewV2$3$1, reason: invalid class name */
        /* loaded from: classes20.dex */
        public class AnonymousClass1 implements Runnable {

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ APNGDrawable f316541d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ LikeAreaBusiness f316542e;

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.widget.VoteViewV2$3$1$a */
            /* loaded from: classes20.dex */
            class a implements Function1<IDynamicDrawable, Unit> {

                /* renamed from: d, reason: collision with root package name */
                final /* synthetic */ ApngDrawable.OnPlayRepeatListener f316547d;

                a(ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
                    this.f316547d = onPlayRepeatListener;
                }

                @Override // kotlin.jvm.functions.Function1
                /* renamed from: a, reason: merged with bridge method [inline-methods] */
                public Unit invoke(IDynamicDrawable iDynamicDrawable) {
                    VoteViewV2.this.f316536i.setAlpha(0);
                    VoteViewV2.this.f316535h.setAlpha(0.0f);
                    VoteViewV2.this.T.setAlpha(0);
                    AnonymousClass1.this.f316541d.setOnPlayRepeatListener(this.f316547d);
                    return null;
                }
            }

            AnonymousClass1(APNGDrawable aPNGDrawable, LikeAreaBusiness likeAreaBusiness) {
                this.f316541d = aPNGDrawable;
                this.f316542e = likeAreaBusiness;
            }

            @Override // java.lang.Runnable
            public void run() {
                AnonymousClass3.this.f316540e.setImageDrawable(this.f316541d);
                this.f316541d.setLoadedListener(new a(new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.widget.VoteViewV2.3.1.1
                    @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                    public void onPlayRepeat(int i3) {
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        final Drawable likeAreaBgAnimation = anonymousClass1.f316542e.getLikeAreaBgAnimation(AnonymousClass3.this.f316539d);
                        AnonymousClass3.this.f316540e.post(new Runnable() { // from class: com.tencent.mobileqq.widget.VoteViewV2.3.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass3.this.f316540e.setImageDrawable(likeAreaBgAnimation);
                                VoteViewV2.this.f316536i.setAlpha(255);
                                VoteViewV2.this.T.setAlpha(255);
                                VoteViewV2.this.f316535h.setAlpha(1.0f);
                            }
                        });
                    }
                }));
            }
        }

        AnonymousClass3(int i3, ImageView imageView) {
            this.f316539d = i3;
            this.f316540e = imageView;
        }

        @Override // java.lang.Runnable
        public void run() {
            LikeAreaBusiness likeAreaBusiness = (LikeAreaBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(LikeAreaBusiness.class);
            APNGDrawable likeAreaOpenAnimation = likeAreaBusiness.getLikeAreaOpenAnimation(this.f316539d);
            if (likeAreaOpenAnimation == null) {
                QLog.e("VoteViewV2", 1, "isFileExists = false likeAreaId : " + this.f316539d);
                return;
            }
            ThreadManagerV2.getUIHandlerV2().post(new AnonymousClass1(likeAreaOpenAnimation, likeAreaBusiness));
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    static class ReportTimeOutSetup implements Runnable {

        /* renamed from: d, reason: collision with root package name */
        private String f316555d;

        public ReportTimeOutSetup(String str) {
            this.f316555d = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (w13.a.f444413a.e()) {
                HashMap hashMap = new HashMap();
                hashMap.put("ark_id", "");
                hashMap.put("scene", "5");
                hashMap.put(PhotoCacheData.OWNER_UIN, this.f316555d);
                hashMap.put("group_id", "");
                ((IVasKuiklyLogicApi) QRoute.api(IVasKuiklyLogicApi.class)).openLucky(new KuikLyConfig("LuckyLogicPage", "vas_lucky_bag", "openLuckyBag", hashMap));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            VoteViewV2.this.T.setVisibility(8);
            ((IVasLikeAreaUtil) QRoute.api(IVasLikeAreaUtil.class)).showLikeAreaSheet();
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* compiled from: P */
    /* loaded from: classes20.dex */
    class b implements Function1<IDynamicDrawable, Unit> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ APNGDrawable f316557d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ ApngDrawable.OnPlayRepeatListener f316558e;

        b(APNGDrawable aPNGDrawable, ApngDrawable.OnPlayRepeatListener onPlayRepeatListener) {
            this.f316557d = aPNGDrawable;
            this.f316558e = onPlayRepeatListener;
        }

        @Override // kotlin.jvm.functions.Function1
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unit invoke(IDynamicDrawable iDynamicDrawable) {
            VoteViewV2.this.f316536i.setAlpha(0);
            VoteViewV2.this.f316535h.setAlpha(0.0f);
            VoteViewV2.this.T.setAlpha(0);
            this.f316557d.setOnPlayRepeatListener(this.f316558e);
            return null;
        }
    }

    public VoteViewV2(Context context) {
        this(context, null);
    }

    private int e(int i3, boolean z16) {
        if (z16 && i3 == 0) {
            w13.a aVar = w13.a.f444413a;
            if (aVar.e()) {
                return aVar.b();
            }
            return i3;
        }
        return i3;
    }

    private int g(boolean z16) {
        int f16 = PraiseManager.f(this.D);
        if (f16 == 0) {
            w13.a aVar = w13.a.f444413a;
            if (aVar.e() && z16) {
                return aVar.c();
            }
        }
        return f16;
    }

    private void h() {
        ViewGroup viewGroup;
        int i3;
        String str;
        if (!VasToggle.VAS_LIKE_AREA_ENTRY.isEnable(true) || (viewGroup = (ViewGroup) findViewById(R.id.f12027794)) == null) {
            return;
        }
        this.T = new ImageView(getContext());
        double d16 = this.H;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (117.0d * d16), (int) (d16 * 40.0d));
        int i16 = layoutParams.width;
        layoutParams.leftMargin = -((i16 / 10) * 7);
        int i17 = (int) (-(layoutParams.height - (this.H * 5.0d)));
        if (VoteView.R) {
            i3 = 5;
        } else {
            i3 = 0;
        }
        layoutParams.topMargin = i17 + i3;
        layoutParams.rightMargin = -((i16 / 10) * 3);
        viewGroup.addView(this.T, 0, layoutParams);
        this.T.setZ(1000.0f);
        if (VoteView.R) {
            IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
            if (QQTheme.isNowThemeIsNight()) {
                str = LikeAreaBusiness.BASE_LIKE_AREA_TIP_NIGHT;
            } else {
                str = LikeAreaBusiness.BASE_LIKE_AREA_TIP;
            }
            this.T.setImageDrawable(iVasApngFactory.getDynamicDrawable(str));
            this.T.setVisibility(0);
            VoteView.R = false;
            HashMap hashMap = new HashMap();
            hashMap.put("dt_eid", "em_userprofile_likeplace_bubble");
            hashMap.put("dt_pgid", "pg_user_profile_new");
            VideoReport.reportEvent("imp", hashMap);
        } else {
            w13.a aVar = w13.a.f444413a;
            if (aVar.g()) {
                this.T.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(LikeAreaBusiness.NEW_YEAR_LUCKY_BAG));
                aVar.h();
            }
            this.T.setVisibility(8);
        }
        this.R = new ImageView(getContext());
        this.S = new ImageView(getContext());
        double d17 = this.H;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (126.0d * d17), (int) (d17 * 107.0d));
        int i18 = layoutParams2.width;
        layoutParams2.leftMargin = -(i18 / 2);
        int i19 = layoutParams2.height;
        layoutParams2.topMargin = -(i19 / 2);
        layoutParams2.bottomMargin = -(i19 / 2);
        layoutParams2.rightMargin = -(i18 / 2);
        this.R.setTranslationY((float) (this.H * 12.0d));
        this.S.setTranslationY((float) (this.H * 12.0d));
        ((ViewGroup) findViewById(R.id.e2d)).addView(this.S, 0, layoutParams2);
        viewGroup.addView(this.R, 0, layoutParams2);
        setClipChildren(false);
        setClipToPadding(false);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
            ((ViewGroup) getParent()).setClipToPadding(false);
        }
        ViewParent parent = this.R.getParent();
        for (int i26 = 0; (parent instanceof ViewGroup) && i26 < 6; i26++) {
            ViewGroup viewGroup2 = (ViewGroup) parent;
            viewGroup2.setClipChildren(false);
            viewGroup2.setClipToPadding(false);
            parent = parent.getParent();
        }
        setOnLongClickListener(new a());
    }

    private void j() {
        this.U = R.drawable.ahb;
        this.V = R.drawable.aha;
        this.W = R.drawable.ahc;
        this.f316530a0 = R.drawable.aha;
    }

    private void l(int i3, int i16) {
        Drawable a16;
        if (!this.N && this.M) {
            a16 = com.tencent.qqnt.aio.utils.af.a(getResources().getDrawable(i3));
        } else {
            a16 = com.tencent.qqnt.aio.utils.af.a(getResources().getDrawable(i16));
        }
        this.f316536i.setImageDrawable(a16);
    }

    @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
    public void M0(int i3, com.tencent.mobileqq.profile.like.d dVar, int i16, String str) {
        if (i3 != 0 && i3 == g(true) && dVar != null && !this.N) {
            p(dVar);
            Pair<Point, Integer> pair = this.E.D.get(i3);
            if (pair != null) {
                com.tencent.mobileqq.profile.like.b bVar = this.E;
                QQAppInterface qQAppInterface = this.D;
                HeartLayout heartLayout = this.K;
                Bitmap e16 = this.L.e();
                Object obj = pair.first;
                bVar.a(qQAppInterface, heartLayout, e16, this, i3, false, 0, ((Point) obj).x, ((Point) obj).y);
                this.E.D.remove(i3);
            }
        }
    }

    public void d(int i3) {
        this.C = i3;
        s();
        if (this.C == 1) {
            this.f316535h.setTextColor(this.F.getResources().getColor(R.color.skin_gray2));
            this.f316537m.setTextColor(this.F.getResources().getColor(R.color.skin_gray2));
            com.tencent.mobileqq.profile.like.b bVar = this.E;
            Drawable drawable = bVar.f260220i;
            if (drawable != null) {
                bVar.f260220i = BaseImageUtil.maskDrawableByColor(drawable, -7894119);
                return;
            }
            return;
        }
        this.f316535h.setTextColor(this.F.getResources().getColor(R.color.skin_white));
        this.f316537m.setTextColor(this.F.getResources().getColor(R.color.skin_white));
        com.tencent.mobileqq.profile.like.b bVar2 = this.E;
        Drawable drawable2 = bVar2.f260220i;
        if (drawable2 != null) {
            bVar2.f260220i = BaseImageUtil.maskDrawableByColor(drawable2, -1);
        }
        if (ThemeUtil.isInNightMode(BaseApplicationImpl.getApplication().getRuntime())) {
            this.f316536i.setColorFilter(1996488704);
            this.f316535h.setTextColor(getResources().getColor(R.color.skin_black));
        }
    }

    protected int f() {
        return R.layout.f168849b12;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void i() {
        setClipChildren(false);
        this.G.inflate(f(), this);
        this.f316535h = (TextView) findViewById(R.id.l0g);
        this.I = (ViewGroup) findViewById(R.id.i4x);
        this.J = (TextView) findViewById(R.id.i4y);
        this.f316537m = (TextView) findViewById(R.id.f166490fj4);
        bs.a();
        this.f316536i = (ImageView) findViewById(R.id.l0l);
        j();
        d(1);
        h();
    }

    public void k(boolean z16, int i3) {
        int i16;
        int i17;
        int i18;
        String str;
        int i19 = 4;
        if (QLog.isDebugVersion()) {
            QLog.d("VoteViewV2", 4, "refreshView,showReddot=" + z16 + ",VoteNum=" + this.f316533e + ",VoteInc=" + this.f316534f);
        }
        boolean z17 = this.N;
        if (z17 && (i17 = this.f316534f) > 0) {
            if (z16) {
                i16 = this.f316533e;
                i18 = R.drawable.skin_tips_dot_small;
            } else {
                i16 = this.f316533e - i17;
                i18 = R.drawable.f162476h20;
            }
            this.I.setBackgroundResource(i18);
            this.I.setVisibility(i3);
            TextView textView = this.J;
            if (z16) {
                str = "";
            } else {
                str = Marker.ANY_NON_NULL_MARKER + this.f316534f;
            }
            textView.setText(str);
            TextView textView2 = this.J;
            if (!z16) {
                i19 = 0;
            }
            textView2.setVisibility(i19);
        } else {
            int i26 = this.f316533e;
            if (!z17 || !this.P) {
                this.I.setVisibility(4);
            }
            i16 = i26;
        }
        this.f316535h.setText(String.valueOf(i16));
    }

    public void m() {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
            return;
        }
        this.E.f260221m = false;
        if (!this.Q) {
            bt.b();
            VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
        }
        this.Q = true;
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.VoteViewV2.2

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.widget.VoteViewV2$2$a */
            /* loaded from: classes20.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Intent intent = new Intent(VoteViewV2.this.F, (Class<?>) QQBrowserActivity.class);
                    VasWebviewUtil.openQQBrowserWithoutAD(VoteViewV2.this.F, IndividuationUrlHelper.getMarketUrl(VoteViewV2.this.F, "praise", ""), 536870912L, intent, false, -1);
                    VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_click", null, 1, 0, 0, null, "0", null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VoteViewV2.this.Q) {
                    VoteViewV2.this.findViewById(R.id.e2d).setVisibility(0);
                    bs.b(VoteViewV2.this);
                    VoteViewV2.this.findViewById(R.id.e2d).setOnClickListener(new a());
                }
            }
        }, 3000L);
    }

    public void n(boolean z16) {
        int i3;
        this.P = z16;
        if (this.I.getVisibility() == 0) {
            return;
        }
        this.I.setBackgroundResource(R.drawable.skin_tips_dot_small);
        ViewGroup viewGroup = this.I;
        if (z16) {
            i3 = 0;
        } else {
            i3 = 4;
        }
        viewGroup.setVisibility(i3);
    }

    public void o(boolean z16) {
        HeartLayout heartLayout = this.K;
        if (heartLayout != null) {
            heartLayout.setCanDoAnim(z16);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QQAppInterface qQAppInterface = this.D;
        if (qQAppInterface != null) {
            ((PraiseManager) qQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).j(this);
        }
        this.Q = false;
        super.onDetachedFromWindow();
    }

    public void p(com.tencent.mobileqq.profile.like.d dVar) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
            return;
        }
        if (!this.N && dVar != null) {
            com.tencent.mobileqq.profile.like.b bVar = this.E;
            if (!bVar.f260221m && !this.Q) {
                bVar.f260218f = this.f316536i;
                bVar.f260220i = new BitmapDrawable(getResources(), dVar.f260238f);
                if (this.C == 1) {
                    com.tencent.mobileqq.profile.like.b bVar2 = this.E;
                    bVar2.f260220i = BaseImageUtil.maskDrawableByColor(bVar2.f260220i, -7894119);
                }
                this.E.c(false, false, this.f316536i.getDrawable(), getResources());
                this.f316536i.startAnimation(com.tencent.mobileqq.profile.like.b.b(this.E, 1.0f, 0.3f));
                this.E.f260221m = true;
            }
        }
    }

    public void q(int i3, final ImageView imageView, Boolean bool) {
        if (imageView == null) {
            return;
        }
        final int e16 = e(i3, bool.booleanValue());
        boolean isNowSimpleUI = QQTheme.isNowSimpleUI();
        if (VasToggle.VAS_LIKE_AREA_ENTRY.isEnable(true) && e16 != 0 && !(imageView.getDrawable() instanceof APNGDrawable) && !isNowSimpleUI) {
            ViewParent parent = imageView.getParent();
            for (int i16 = 0; (parent instanceof ViewGroup) && i16 < 6; i16++) {
                ViewGroup viewGroup = (ViewGroup) parent;
                viewGroup.setClipChildren(false);
                viewGroup.setClipToPadding(false);
                parent = parent.getParent();
            }
            if (f316529c0) {
                ThreadManagerV2.excute(new AnonymousClass3(e16, imageView), 16, null, false);
                return;
            }
            final LikeAreaBusiness likeAreaBusiness = (LikeAreaBusiness) QQVasUpdateBusinessUtil.getBusinessInstance(LikeAreaBusiness.class);
            APNGDrawable likeAreaOpenAnimation = likeAreaBusiness.getLikeAreaOpenAnimation(e16);
            if (likeAreaOpenAnimation == null) {
                QLog.e("VoteViewV2", 1, "isFileExists = false likeAreaId : " + e16);
                return;
            }
            imageView.setImageDrawable(likeAreaOpenAnimation);
            likeAreaOpenAnimation.setLoadedListener(new b(likeAreaOpenAnimation, new ApngDrawable.OnPlayRepeatListener() { // from class: com.tencent.mobileqq.widget.VoteViewV2.4
                @Override // com.tencent.image.ApngDrawable.OnPlayRepeatListener
                public void onPlayRepeat(int i17) {
                    final Drawable likeAreaBgAnimation = likeAreaBusiness.getLikeAreaBgAnimation(e16);
                    imageView.post(new Runnable() { // from class: com.tencent.mobileqq.widget.VoteViewV2.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            imageView.setImageDrawable(likeAreaBgAnimation);
                            VoteViewV2.this.f316536i.setAlpha(255);
                            VoteViewV2.this.T.setAlpha(255);
                            VoteViewV2.this.f316535h.setAlpha(1.0f);
                        }
                    });
                }
            }));
        }
    }

    public void r(boolean z16, boolean z17, int i3, int i16, com.tencent.mobileqq.dating.j jVar, boolean z18, int i17, Boolean bool, String str) {
        int i18;
        Drawable drawable;
        int g16;
        ImageView imageView;
        this.N = z16;
        this.M = z17;
        if (i3 > 0) {
            i18 = i3;
        } else {
            i18 = 0;
        }
        this.f316533e = i18;
        if (!z16 && bool.booleanValue() && !VoteView.R && (imageView = this.T) != null && !this.f316532d) {
            imageView.setVisibility(0);
            this.f316532d = true;
        }
        int i19 = this.f316533e;
        if (i16 > i19) {
            this.f316534f = i19 % 20;
        } else if (i16 < 0) {
            this.f316534f = 0;
        } else {
            this.f316534f = i16;
        }
        if (!this.N && this.M) {
            drawable = getResources().getDrawable(this.f316530a0);
        } else if (this.C == 1) {
            drawable = getResources().getDrawable(this.U);
        } else {
            drawable = getResources().getDrawable(this.W);
        }
        setContentDescription(String.format(getContext().getString(R.string.f170791ab1), String.valueOf(this.f316533e)));
        com.tencent.mobileqq.profile.like.b bVar = this.E;
        if (bVar.f260221m) {
            bVar.c(false, false, drawable, getResources());
        } else {
            s();
        }
        if (!z16 && !this.E.f260221m && !z18 && !this.Q && (g16 = g(bool.booleanValue())) > 0) {
            PraiseManager praiseManager = (PraiseManager) this.D.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
            praiseManager.h(this);
            p(praiseManager.g(g16, true, "from_profile_card"));
        }
        if (!this.N) {
            k(false, 4);
            if (z18 && this.K != null) {
                int[] iArr = new int[2];
                this.f316535h.getLocationInWindow(iArr);
                if (this.L == null) {
                    this.L = new com.tencent.mobileqq.hotchat.ui.b(getContext(), R.drawable.f5m);
                }
                float compoundPaddingLeft = (float) (iArr[0] + (this.f316535h.getCompoundPaddingLeft() * 0.5d));
                float f16 = iArr[1];
                int g17 = g(bool.booleanValue());
                if (g17 > 0) {
                    this.E.a(this.D, this.K, this.L.e(), this, g17, true, 0, compoundPaddingLeft, f16);
                } else {
                    this.K.d(this.L.e(), compoundPaddingLeft, f16);
                }
                ReportTimeOutSetup reportTimeOutSetup = new ReportTimeOutSetup(str);
                Runnable runnable = this.f316531b0;
                if (runnable != null) {
                    ThreadManagerV2.removeJob(runnable, 16);
                }
                this.f316531b0 = ThreadManagerV2.executeDelay(reportTimeOutSetup, 16, null, false, 1000L);
            }
        } else if (jVar != null) {
            jVar.g(this.f316533e, this.f316534f, this.I, this.J, this.f316535h, null, this.K);
            n(this.P);
            k(false, 0);
        } else {
            k(true, 0);
        }
        setRedDotPos(ViewUtils.dip2px(20.0f), ViewUtils.dip2px(26.0f));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void s() {
        if (this.C == 1) {
            l(this.V, this.U);
        } else {
            l(this.f316530a0, this.W);
        }
    }

    public void setHeartLayout(QQAppInterface qQAppInterface, HeartLayout heartLayout) {
        this.D = qQAppInterface;
        this.K = heartLayout;
        com.tencent.mobileqq.hotchat.ui.b.d(heartLayout);
    }

    public void setRedDotPos(int i3, int i16) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.I.getLayoutParams();
        layoutParams.topMargin = 0;
        layoutParams.bottomMargin = i16;
        layoutParams.leftMargin = i3;
        this.I.setLayoutParams(layoutParams);
        View findViewById = findViewById(R.id.f12027794);
        if (findViewById == null) {
            return;
        }
        ((FrameLayout.LayoutParams) findViewById.getLayoutParams()).topMargin = ViewUtils.dip2px(5.0f);
    }

    public void setVoteColor(int i3) {
        ImageView imageView = this.f316536i;
        if (imageView == null) {
            return;
        }
        if (!this.N && this.M) {
            imageView.setColorFilter(i3);
        } else {
            imageView.clearColorFilter();
        }
    }

    public void setVoteImageId(int i3, int i16) {
        this.U = i3;
        this.V = i16;
        this.W = i3;
        this.f316530a0 = i16;
    }

    public void setVoteNumColor(int i3) {
        this.f316535h.setTextColor(i3);
    }

    public VoteViewV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VoteViewV2(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f316532d = false;
        this.C = 0;
        this.E = new com.tencent.mobileqq.profile.like.b();
        this.Q = false;
        this.F = context;
        this.G = LayoutInflater.from(context);
        this.H = getResources().getDisplayMetrics().density;
        i();
    }
}
