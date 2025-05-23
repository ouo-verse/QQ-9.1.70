package com.tencent.mobileqq.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.hotchat.anim.HeartLayout;
import com.tencent.mobileqq.profile.like.PraiseManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.IndividuationUrlHelper;
import com.tencent.mobileqq.vas.VasToggle;
import com.tencent.mobileqq.vas.apng.api.IVasApngFactory;
import com.tencent.mobileqq.vas.likeArea.api.IVasLikeAreaUtil;
import com.tencent.mobileqq.vas.updatesystem.business.LikeAreaBusiness;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.mobileqq.widget.VoteViewV2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.SingleLineTextView;
import java.util.HashMap;
import org.slf4j.Marker;

/* compiled from: P */
/* loaded from: classes20.dex */
public class VoteView extends RelativeLayout implements PraiseManager.a {
    public static boolean R = true;
    public ImageView C;
    private double D;
    private boolean E;
    private boolean F;
    public int G;
    public int H;
    public boolean I;
    HeartLayout J;
    com.tencent.mobileqq.hotchat.ui.b K;
    public QQAppInterface L;
    private boolean M;
    VoteViewV2.ReportTimeOutSetup N;
    public boolean P;
    com.tencent.mobileqq.profile.like.b Q;

    /* renamed from: d, reason: collision with root package name */
    public RelativeLayout f316521d;

    /* renamed from: e, reason: collision with root package name */
    public ImageView f316522e;

    /* renamed from: f, reason: collision with root package name */
    public SingleLineTextView f316523f;

    /* renamed from: h, reason: collision with root package name */
    public FrameLayout f316524h;

    /* renamed from: i, reason: collision with root package name */
    public TextView f316525i;

    /* renamed from: m, reason: collision with root package name */
    public ImageView f316526m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes20.dex */
    public class a implements View.OnLongClickListener {
        a() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            VoteView.this.C.setVisibility(8);
            ((IVasLikeAreaUtil) QRoute.api(IVasLikeAreaUtil.class)).showLikeAreaSheet();
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    public VoteView(Context context) {
        super(context);
        this.M = false;
        this.P = false;
        this.Q = new com.tencent.mobileqq.profile.like.b();
        d();
    }

    private int b(boolean z16) {
        int f16 = PraiseManager.f(this.L);
        if (f16 == 0) {
            w13.a aVar = w13.a.f444413a;
            if (aVar.e() && z16) {
                return aVar.c();
            }
        }
        return f16;
    }

    private void c() {
        int i3;
        String str;
        if (VasToggle.VAS_LIKE_AREA_ENTRY.isEnable(true)) {
            ImageView imageView = new ImageView(getContext());
            this.C = imageView;
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            double d16 = this.D;
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) (122.0d * d16), (int) (d16 * 40.0d));
            int i16 = layoutParams.width;
            layoutParams.leftMargin = -((i16 / 12) * 7);
            int i17 = (int) (-(layoutParams.height + (this.D * 5.0d)));
            if (R) {
                i3 = 5;
            } else {
                i3 = 0;
            }
            layoutParams.topMargin = i17 + i3;
            layoutParams.rightMargin = -((i16 / 12) * 5);
            addView(this.C, 0, layoutParams);
            if (R) {
                IVasApngFactory iVasApngFactory = (IVasApngFactory) QRoute.api(IVasApngFactory.class);
                if (QQTheme.isNowThemeIsNight()) {
                    str = LikeAreaBusiness.VAS_LIKE_AREA_TIP_NIGHT;
                } else {
                    str = LikeAreaBusiness.VAS_LIKE_AREA_TIP;
                }
                this.C.setImageDrawable(iVasApngFactory.getDynamicDrawable(str));
                this.C.setVisibility(0);
                R = false;
                HashMap hashMap = new HashMap();
                hashMap.put("dt_eid", "em_userprofile_likeplace_bubble");
                hashMap.put("dt_pgid", "pg_user_profile_new");
                VideoReport.reportEvent("imp", hashMap);
            } else {
                w13.a aVar = w13.a.f444413a;
                if (aVar.g()) {
                    this.C.setImageDrawable(((IVasApngFactory) QRoute.api(IVasApngFactory.class)).getDynamicDrawable(LikeAreaBusiness.NEW_YEAR_LUCKY_BAG));
                    aVar.h();
                }
                this.C.setVisibility(8);
            }
            this.f316526m = new ImageView(getContext());
            double d17 = this.D;
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) (126.0d * d17), (int) (d17 * 107.0d));
            int i18 = layoutParams2.width;
            layoutParams2.leftMargin = -(i18 / 2);
            int i19 = layoutParams2.height;
            layoutParams2.topMargin = -(i19 / 2);
            layoutParams2.bottomMargin = -(i19 / 2);
            layoutParams2.rightMargin = -(i18 / 2);
            this.f316526m.setTranslationX((float) (this.D * 12.0d));
            this.f316526m.setTranslationY((float) (this.D * 12.0d));
            addView(this.f316526m, 0, layoutParams2);
            this.f316526m.setVisibility(8);
            setClipChildren(false);
            setClipToPadding(false);
            setOnLongClickListener(new a());
        }
    }

    private void d() {
        int intrinsicWidth;
        int intrinsicHeight;
        setClipChildren(false);
        this.E = false;
        this.F = false;
        this.G = 0;
        this.H = 0;
        Resources resources = getResources();
        this.D = resources.getDisplayMetrics().density;
        RelativeLayout relativeLayout = new RelativeLayout(getContext());
        this.f316521d = relativeLayout;
        relativeLayout.setId(R.id.dyw);
        this.f316521d.setBackgroundResource(R.drawable.ahd);
        RelativeLayout relativeLayout2 = this.f316521d;
        double d16 = this.D;
        relativeLayout2.setPadding((int) (d16 * 8.0d), (int) (d16 * 3.0d), (int) (8.0d * d16), (int) (d16 * 3.0d));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, (int) (this.D * 24.0d));
        layoutParams.addRule(9);
        layoutParams.addRule(10);
        layoutParams.topMargin = (int) (this.D * 6.0d);
        RelativeLayout relativeLayout3 = new RelativeLayout(getContext());
        View view = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.f168848b11, (ViewGroup) null);
        view.setId(R.id.e2d);
        addView(view, new RelativeLayout.LayoutParams(-2, -2));
        addView(relativeLayout3, new RelativeLayout.LayoutParams(-2, -2));
        relativeLayout3.addView(this.f316521d, layoutParams);
        bt.b();
        ImageView imageView = new ImageView(getContext());
        this.f316522e = imageView;
        imageView.setId(R.id.fxu);
        Drawable drawable = resources.getDrawable(R.drawable.skin_card_icon_zan);
        this.f316522e.setImageDrawable(drawable);
        if (drawable == null) {
            intrinsicWidth = (int) (this.D * 18.0d);
        } else {
            intrinsicWidth = drawable.getIntrinsicWidth();
        }
        if (drawable == null) {
            intrinsicHeight = (int) (this.D * 18.0d);
        } else {
            intrinsicHeight = drawable.getIntrinsicHeight();
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(intrinsicWidth, intrinsicHeight);
        layoutParams2.addRule(9);
        layoutParams2.addRule(15);
        layoutParams2.rightMargin = (int) (this.D * 3.0d);
        this.f316521d.addView(this.f316522e, layoutParams2);
        SingleLineTextView singleLineTextView = new SingleLineTextView(getContext());
        this.f316523f = singleLineTextView;
        singleLineTextView.setId(R.id.e9c);
        this.f316523f.setTextColor(-1);
        this.f316523f.setTextSize(13.0f);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-2, (int) (this.D * 24.0d));
        layoutParams3.addRule(1, R.id.fxu);
        this.f316521d.addView(this.f316523f, layoutParams3);
        FrameLayout frameLayout = new FrameLayout(getContext());
        this.f316524h = frameLayout;
        frameLayout.setId(R.id.dxr);
        this.f316524h.setBackgroundResource(R.drawable.f162476h20);
        this.f316524h.setMinimumHeight((int) (this.D * 6.0d));
        this.f316524h.setMinimumWidth((int) (this.D * 6.0d));
        this.f316524h.setContentDescription(resources.getString(R.string.aal));
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams4.addRule(10);
        layoutParams4.addRule(7, R.id.dyw);
        relativeLayout3.addView(this.f316524h, layoutParams4);
        TextView textView = new TextView(getContext());
        this.f316525i = textView;
        textView.setId(R.id.f8o);
        this.f316525i.setTextSize(1, 11.0f);
        this.f316525i.setTextColor(-1);
        this.f316524h.addView(this.f316525i, -2, -2);
        c();
    }

    @Override // com.tencent.mobileqq.profile.like.PraiseManager.a
    public void M0(int i3, com.tencent.mobileqq.profile.like.d dVar, int i16, String str) {
        if (i3 != 0 && i3 == b(true) && dVar != null && !this.F) {
            i(dVar);
            Pair<Point, Integer> pair = this.Q.D.get(i3);
            if (pair != null) {
                com.tencent.mobileqq.profile.like.b bVar = this.Q;
                QQAppInterface qQAppInterface = this.L;
                HeartLayout heartLayout = this.J;
                Bitmap e16 = this.K.e();
                Object obj = pair.first;
                bVar.a(qQAppInterface, heartLayout, e16, this, i3, false, 0, ((Point) obj).x, ((Point) obj).y);
                this.Q.D.remove(i3);
            }
        }
    }

    public void e(boolean z16, int i3) {
        String valueOf;
        int i16;
        String str;
        int i17 = 4;
        if (QLog.isDebugVersion()) {
            QLog.d("VoteView", 4, "refreshView,showReddot=" + z16 + ",VoteNum=" + this.G + ",VoteInc=" + this.H);
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f316521d.getLayoutParams();
        if (this.F && this.H > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f316524h.getLayoutParams();
            if (z16) {
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                }
                valueOf = String.valueOf(this.G);
                if (layoutParams2 != null) {
                    double d16 = this.D;
                    layoutParams2.width = (int) ((d16 * 6.0d) + 0.5d);
                    layoutParams2.height = (int) ((6.0d * d16) + 0.5d);
                    layoutParams2.rightMargin = (int) ((3.0d % d16) + 0.5d);
                }
                i16 = R.drawable.skin_tips_dot_small;
            } else {
                if (layoutParams != null) {
                    layoutParams.topMargin = (int) ((this.D * 15.0d) + 0.5d);
                }
                valueOf = String.valueOf(this.G - this.H);
                if (layoutParams2 != null) {
                    layoutParams2.width = -2;
                    layoutParams2.height = -2;
                    layoutParams2.rightMargin = 0;
                }
                i16 = R.drawable.skin_tips_newmessage;
            }
            this.f316524h.setBackgroundResource(i16);
            if (layoutParams2 != null) {
                this.f316524h.setLayoutParams(layoutParams2);
            }
            this.f316524h.setVisibility(i3);
            TextView textView = this.f316525i;
            if (z16) {
                str = "";
            } else {
                str = Marker.ANY_NON_NULL_MARKER + this.H;
            }
            textView.setText(str);
            TextView textView2 = this.f316525i;
            if (!z16) {
                i17 = 0;
            }
            textView2.setVisibility(i17);
        } else {
            if (layoutParams != null) {
                layoutParams.topMargin = 0;
            }
            valueOf = String.valueOf(this.G);
            if (!this.F || !this.I) {
                this.f316524h.setVisibility(4);
            }
        }
        this.f316523f.setText(valueOf);
        this.f316521d.setLayoutParams(layoutParams);
    }

    public void f() {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i("PraiseManager", 1, "showPatternVote, SimpleUIMode is open now");
            return;
        }
        this.Q.f260221m = false;
        if (!this.M) {
            bt.b();
            VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_pageview", null, 1, 0, 0, null, "1", null);
        }
        this.M = true;
        postDelayed(new Runnable() { // from class: com.tencent.mobileqq.widget.VoteView.2

            /* compiled from: P */
            /* renamed from: com.tencent.mobileqq.widget.VoteView$2$a */
            /* loaded from: classes20.dex */
            class a implements View.OnClickListener {
                a() {
                }

                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    EventCollector.getInstance().onViewClickedBefore(view);
                    Intent intent = new Intent(VoteView.this.getContext(), (Class<?>) QQBrowserActivity.class);
                    VasWebviewUtil.openQQBrowserWithoutAD(VoteView.this.getContext(), IndividuationUrlHelper.getMarketUrl(VoteView.this.getContext(), "praise", ""), 536870912L, intent, false, -1);
                    VasWebviewUtil.reportCommercialDrainage(null, "thumbup", "others_click", null, 1, 0, 0, null, "1", null);
                    EventCollector.getInstance().onViewClicked(view);
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                if (VoteView.this.M) {
                    bt.c(VoteView.this);
                    VoteView.this.findViewById(R.id.e2d).setOnClickListener(new a());
                }
            }
        }, 3000L);
    }

    public void g(boolean z16) {
        this.I = z16;
        FrameLayout frameLayout = this.f316524h;
        if (frameLayout != null && frameLayout.getVisibility() != 0) {
            int i3 = 0;
            if (z16) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f316521d.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f316524h.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.topMargin = 0;
                }
                if (layoutParams2 == null) {
                    layoutParams2 = new RelativeLayout.LayoutParams(this.f316524h.getContext(), (AttributeSet) null);
                }
                double d16 = this.D;
                layoutParams2.width = (int) ((d16 * 6.0d) + 0.5d);
                layoutParams2.height = (int) ((6.0d * d16) + 0.5d);
                layoutParams2.rightMargin = (int) ((3.0d % d16) + 0.5d);
                this.f316524h.setBackgroundResource(R.drawable.skin_tips_dot_small);
                this.f316524h.setLayoutParams(layoutParams2);
            }
            FrameLayout frameLayout2 = this.f316524h;
            if (!z16) {
                i3 = 4;
            }
            frameLayout2.setVisibility(i3);
        }
    }

    public void h(boolean z16) {
        HeartLayout heartLayout = this.J;
        if (heartLayout != null) {
            heartLayout.setCanDoAnim(z16);
        }
    }

    public void i(com.tencent.mobileqq.profile.like.d dVar) {
        if (SimpleUIUtil.getSimpleUISwitch()) {
            QLog.i("PraiseManager", 1, "startPraiseAnim, SimpleUIMode is open now");
            return;
        }
        if (!this.F && dVar != null) {
            com.tencent.mobileqq.profile.like.b bVar = this.Q;
            if (!bVar.f260221m) {
                bVar.f260218f = this.f316522e;
                bVar.f260220i = new BitmapDrawable(getResources(), dVar.f260238f);
                this.Q.c(this.E, false, this.f316522e.getDrawable(), getResources());
                this.f316522e.startAnimation(com.tencent.mobileqq.profile.like.b.b(this.Q, 1.0f, 0.3f));
                this.Q.f260221m = true;
            }
        }
    }

    public void j(boolean z16, boolean z17, int i3, int i16, com.tencent.mobileqq.dating.j jVar, boolean z18, int i17, boolean z19, String str) {
        int i18;
        Drawable drawable;
        int b16;
        ImageView imageView;
        if (!this.F && z19 && !R && (imageView = this.C) != null && !this.P) {
            imageView.setVisibility(0);
            this.P = true;
        }
        this.F = z16;
        this.E = z17;
        if (i3 > 0) {
            i18 = i3;
        } else {
            i18 = 0;
        }
        this.G = i18;
        if (i16 > i18) {
            this.H = i18 % 20;
        } else if (i16 < 0) {
            this.H = 0;
        } else {
            this.H = i16;
        }
        if (!z16 && z17) {
            drawable = super.getResources().getDrawable(R.drawable.skin_card_icon_zan_sel);
        } else {
            drawable = super.getResources().getDrawable(R.drawable.skin_card_icon_zan);
        }
        com.tencent.mobileqq.profile.like.b bVar = this.Q;
        if (bVar.f260221m) {
            bVar.c(this.E, false, drawable, getResources());
        } else {
            this.f316522e.setImageDrawable(drawable);
        }
        if (!z16 && !this.Q.f260221m && !z18 && !this.M && (b16 = b(z19)) > 0) {
            PraiseManager praiseManager = (PraiseManager) this.L.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER);
            praiseManager.h(this);
            i(praiseManager.g(b16, true, "from_profile_card"));
        }
        setContentDescription(String.format(getContext().getString(R.string.f170791ab1), String.valueOf(this.G)));
        if (!this.F) {
            e(false, 4);
            if (z18 && this.J != null) {
                this.f316521d.getLocationInWindow(new int[2]);
                if (this.K == null) {
                    this.K = new com.tencent.mobileqq.hotchat.ui.b(getContext(), R.drawable.f5m);
                }
                float width = (float) (r0[0] + ((this.f316522e.getWidth() + this.f316521d.getPaddingLeft()) * 0.5d));
                float f16 = this.J.f236898e;
                int b17 = b(z19);
                if (b17 > 0) {
                    this.Q.a(this.L, this.J, this.K.e(), this, b17, true, 0, width, f16);
                    VoteViewV2.ReportTimeOutSetup reportTimeOutSetup = this.N;
                    if (reportTimeOutSetup == null) {
                        this.N = new VoteViewV2.ReportTimeOutSetup(str);
                    } else {
                        ThreadManagerV2.removeJob(reportTimeOutSetup, 16);
                    }
                    ThreadManagerV2.executeDelay(this.N, 16, null, false, 500L);
                    return;
                }
                this.J.d(this.K.e(), width, f16);
                return;
            }
            return;
        }
        if (jVar != null) {
            jVar.g(this.G, this.H, this.f316524h, this.f316525i, this.f316523f, this.f316521d, this.J);
            g(this.I);
        } else {
            e(true, 0);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        QQAppInterface qQAppInterface = this.L;
        if (qQAppInterface != null) {
            ((PraiseManager) qQAppInterface.getManager(QQManagerFactory.PERSONAL_PRAISE_MANAGER)).j(this);
        }
        this.M = false;
        super.onDetachedFromWindow();
    }

    public void setHeartLayout(QQAppInterface qQAppInterface, HeartLayout heartLayout) {
        this.L = qQAppInterface;
        this.J = heartLayout;
        com.tencent.mobileqq.hotchat.ui.b.d(heartLayout);
    }

    public VoteView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.M = false;
        this.P = false;
        this.Q = new com.tencent.mobileqq.profile.like.b();
        d();
    }

    public VoteView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.M = false;
        this.P = false;
        this.Q = new com.tencent.mobileqq.profile.like.b();
        d();
    }
}
