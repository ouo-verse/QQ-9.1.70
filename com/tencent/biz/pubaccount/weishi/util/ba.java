package com.tencent.biz.pubaccount.weishi.util;

import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stWaterAdStyle;
import UserGrowth.stWaterFallCardStyle;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.text.TextUtils;
import android.util.Pair;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.graphics.drawable.DrawableCompat;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.pad.SplitViewState;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes32.dex */
public class ba {
    private static int A;

    /* renamed from: x, reason: collision with root package name */
    private static int f81749x;

    /* renamed from: y, reason: collision with root package name */
    private static int f81750y;

    /* renamed from: z, reason: collision with root package name */
    private static int f81751z;

    /* renamed from: a, reason: collision with root package name */
    private static final Pattern f81726a = Pattern.compile("^#([0-9a-fA-F]{8}|[0-9a-fA-F]{6})$");

    /* renamed from: b, reason: collision with root package name */
    public static final int f81727b = ah.b(0.5f);

    /* renamed from: c, reason: collision with root package name */
    public static final int f81728c = ah.b(1.0f);

    /* renamed from: d, reason: collision with root package name */
    public static final int f81729d = ah.b(2.0f);

    /* renamed from: e, reason: collision with root package name */
    public static final int f81730e = ah.b(4.0f);

    /* renamed from: f, reason: collision with root package name */
    public static final int f81731f = ah.b(5.0f);

    /* renamed from: g, reason: collision with root package name */
    public static final int f81732g = ah.b(6.0f);

    /* renamed from: h, reason: collision with root package name */
    public static final int f81733h = ah.b(7.0f);

    /* renamed from: i, reason: collision with root package name */
    public static final int f81734i = ah.b(10.0f);

    /* renamed from: j, reason: collision with root package name */
    public static final int f81735j = ah.b(12.0f);

    /* renamed from: k, reason: collision with root package name */
    public static final int f81736k = ah.b(14.0f);

    /* renamed from: l, reason: collision with root package name */
    public static final int f81737l = ah.b(15.0f);

    /* renamed from: m, reason: collision with root package name */
    public static final int f81738m = ah.b(18.0f);

    /* renamed from: n, reason: collision with root package name */
    public static final int f81739n = ah.b(20.0f);

    /* renamed from: o, reason: collision with root package name */
    public static final int f81740o = ah.b(24.0f);

    /* renamed from: p, reason: collision with root package name */
    public static final int f81741p = ah.b(28.0f);

    /* renamed from: q, reason: collision with root package name */
    public static final int f81742q = ah.b(55.0f);

    /* renamed from: r, reason: collision with root package name */
    public static final int f81743r = ah.b(50.0f);

    /* renamed from: s, reason: collision with root package name */
    public static final int f81744s = ah.b(58.0f);

    /* renamed from: t, reason: collision with root package name */
    public static final int f81745t = ah.b(60.0f);

    /* renamed from: u, reason: collision with root package name */
    public static final int f81746u = ah.b(80.0f);

    /* renamed from: v, reason: collision with root package name */
    public static final int f81747v = ah.b(84.0f);

    /* renamed from: w, reason: collision with root package name */
    public static final int f81748w = ah.b(5.0f);
    private static int B = 0;
    private static int C = 0;

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class a implements View.OnTouchListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Drawable f81752d;

        a(Drawable drawable) {
            this.f81752d = drawable;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f81752d.mutate().setAlpha(127);
                return false;
            }
            if (action != 1 && action != 3) {
                return false;
            }
            this.f81752d.mutate().setAlpha(255);
            return false;
        }
    }

    public static void B(Configuration configuration, String str) {
        B = ah.b(configuration.screenWidthDp);
        C = ah.e(BaseApplicationImpl.getApplication());
        x.j("WeishiUIUtil", "[updateConfiguration] screenOrientation:" + configuration.orientation + ", sScreenWidth:" + B + ", sScreenHeight:" + C + ", scene:" + str);
    }

    public static GradientDrawable a(int i3, float f16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f16, f16, f16, f16, f16, f16});
        return gradientDrawable;
    }

    public static GradientDrawable b(float f16) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-16777216);
        gradientDrawable.setCornerRadii(new float[]{f16, f16, f16, f16, 0.0f, 0.0f, 0.0f, 0.0f});
        return gradientDrawable;
    }

    public static Pair<Integer, Integer> f(GdtAd gdtAd, stWaterAdStyle stwateradstyle) {
        int p16 = (p() - (com.tencent.biz.pubaccount.weishi.n.f80927d * 3)) / 2;
        return new Pair<>(Integer.valueOf(p16), Integer.valueOf((int) (p16 * e(gdtAd, stwateradstyle))));
    }

    public static Drawable g(String str) {
        if (!TextUtils.isEmpty(str)) {
            ColorDrawable colorDrawable = new ColorDrawable();
            if (!w(str)) {
                str = "#D9D9D9";
            }
            colorDrawable.setColor(Color.parseColor(str));
            return colorDrawable;
        }
        return r.i(R.color.f77352);
    }

    public static Pair<Integer, Integer> i(stSimpleMetaFeed stsimplemetafeed) {
        int i3;
        int i16;
        stWaterFallCardStyle stwaterfallcardstyle = stsimplemetafeed.waterFallCardStyle;
        boolean z16 = stwaterfallcardstyle != null && stwaterfallcardstyle.isFullSpan;
        float f16 = (stwaterfallcardstyle == null || (i16 = stwaterfallcardstyle.ratioW) == 0) ? 1.3333334f : (stwaterfallcardstyle.ratioH * 1.0f) / i16;
        float f17 = f16 <= 2.0f ? f16 : 1.3333334f;
        if (z16) {
            f17 = 0.5625f;
        }
        int p16 = p();
        if (z16) {
            i3 = p16 - (com.tencent.biz.pubaccount.weishi.n.f80927d * 2);
        } else {
            i3 = (p16 - (com.tencent.biz.pubaccount.weishi.n.f80927d * 3)) / 2;
        }
        return new Pair<>(Integer.valueOf(i3), Integer.valueOf((int) (i3 * f17)));
    }

    public static int j(Activity activity) {
        int n3 = n();
        if (activity == null) {
            return n3;
        }
        return ah.a(activity) ? n3 - ah.c(activity) : n3;
    }

    public static Drawable l(int i3) {
        Drawable drawable = BaseApplicationImpl.getApplication().getResources().getDrawable(i3);
        DrawableCompat.setTint(drawable, ag.a(R.color.weishi_color_skin_comment_text));
        return drawable;
    }

    public static int n() {
        if (C == 0) {
            C = ah.e(BaseApplicationImpl.getApplication());
            int g16 = ah.g(BaseApplication.getContext());
            int f16 = ah.f(BaseApplicationImpl.getApplication());
            if ((g16 == 2 && C > f16) || (g16 == 1 && C < f16)) {
                x.f("WeishiUIUtil", "[getScreenWidth] sScreenHeight:" + C + ", w:" + f16);
                C = f16;
            }
        }
        return C;
    }

    public static int o() {
        if (B == 0) {
            B = ah.f(BaseApplicationImpl.getApplication());
            int g16 = ah.g(BaseApplication.getContext());
            int e16 = ah.e(BaseApplicationImpl.getApplication());
            if ((g16 == 2 && B < e16) || (g16 == 1 && B > e16)) {
                x.f("WeishiUIUtil", "[getScreenWidth] sScreenWidth:" + B + ", h:" + e16);
                B = e16;
            }
        }
        return B;
    }

    public static int p() {
        int g16 = ah.g(BaseApplication.getContext());
        int o16 = o();
        boolean b16 = i.b();
        SplitViewState a16 = i.a();
        x.j("WeishiUIUtil", "[getSplitScreenWidth] , splitViewState:" + a16 + ", isSplitViewMode:" + b16 + ", screenOrientation:" + g16 + ", screenWidth:" + o16);
        return (b16 && a16 == SplitViewState.STATE_FLAT) ? (int) (o16 * i.c()) : o16;
    }

    public static int q(Activity activity) {
        if (f81749x == 0 && activity != null) {
            f81749x = ah.d(activity);
        }
        return f81749x;
    }

    public static int r() {
        if (A == 0) {
            A = ah.b(41.0f);
        }
        return A;
    }

    public static int s() {
        if (f81751z == 0) {
            f81751z = ah.b(16.0f);
        }
        return f81751z;
    }

    public static int t(Activity activity) {
        if (f81750y == 0) {
            f81750y = q(activity) + ah.b(4.5f);
        }
        return f81750y;
    }

    public static float u(stWaterAdStyle stwateradstyle) {
        return stwateradstyle.hRatioH / stwateradstyle.HRatioW;
    }

    public static float v(stWaterAdStyle stwateradstyle) {
        return stwateradstyle.vRatioH / stwateradstyle.vRatioW;
    }

    public static boolean w(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return f81726a.matcher(str).matches();
    }

    public static void z() {
        x.f("WeishiUIUtil", "[reset]");
        B = 0;
        C = 0;
    }

    private static int c(int[] iArr) {
        int i3 = iArr[0];
        for (int i16 : iArr) {
            if (i16 > i3) {
                i3 = i16;
            }
        }
        return i3;
    }

    private static int d(int[] iArr) {
        int i3 = iArr[0];
        for (int i16 : iArr) {
            if (i16 < i3) {
                i3 = i16;
            }
        }
        return i3;
    }

    public static Drawable m(stSimpleMetaFeed stsimplemetafeed) {
        return g(bb.r(stsimplemetafeed, true));
    }

    public static int h(RecyclerView recyclerView) {
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findFirstVisibleItemPositions(iArr);
                return d(iArr);
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findFirstVisibleItemPosition();
            }
        }
        return -1;
    }

    public static int k(RecyclerView recyclerView) {
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof StaggeredGridLayoutManager) {
                StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
                int[] iArr = new int[staggeredGridLayoutManager.getSpanCount()];
                staggeredGridLayoutManager.findLastVisibleItemPositions(iArr);
                return c(iArr);
            }
            if (layoutManager instanceof LinearLayoutManager) {
                return ((LinearLayoutManager) layoutManager).findLastVisibleItemPosition();
            }
        }
        return -1;
    }

    public static float e(GdtAd gdtAd, stWaterAdStyle stwateradstyle) {
        if (gdtAd == null || !gdtAd.isValid()) {
            return 0.5625f;
        }
        int innerShowType = gdtAd.getInnerShowType();
        if (innerShowType != 2 && innerShowType != 4) {
            if (x(stwateradstyle)) {
                return u(stwateradstyle);
            }
            return 0.5625f;
        }
        return y(stwateradstyle) ? v(stwateradstyle) : 1.7777778f;
    }

    public static boolean x(stWaterAdStyle stwateradstyle) {
        return (stwateradstyle == null || stwateradstyle.HRatioW == 0 || stwateradstyle.hRatioH == 0) ? false : true;
    }

    public static boolean y(stWaterAdStyle stwateradstyle) {
        return (stwateradstyle == null || stwateradstyle.vRatioW == 0 || stwateradstyle.vRatioH == 0) ? false : true;
    }

    public static void A(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setOnTouchListener(new a(drawable));
    }
}
