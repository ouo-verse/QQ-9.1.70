package com.tencent.mobileqq.activity.aio;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.ImageView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes10.dex */
public class BaseChatItemLayout extends ChatItemAnimLayout {
    public static final int J;
    public static final int K;
    public static int L;
    public static int M;
    public static int N;
    public static final int P;
    public static final int Q;
    private static final int R;
    private static final int S;
    private static final int T;
    private static final int U;
    public static final int V;
    public static final int W;

    /* renamed from: a0, reason: collision with root package name */
    public static final int f178043a0;

    /* renamed from: b0, reason: collision with root package name */
    private static final int f178044b0;

    /* renamed from: c0, reason: collision with root package name */
    private static final int f178045c0;

    /* renamed from: d0, reason: collision with root package name */
    private static final int f178046d0;

    /* renamed from: e0, reason: collision with root package name */
    private static final int f178047e0;

    /* renamed from: f0, reason: collision with root package name */
    public static final int f178048f0;

    /* renamed from: g0, reason: collision with root package name */
    public static final int f178049g0;

    /* renamed from: h0, reason: collision with root package name */
    public static final int f178050h0;

    /* renamed from: i0, reason: collision with root package name */
    public static final int f178051i0;

    /* renamed from: j0, reason: collision with root package name */
    public static final int f178052j0;

    /* renamed from: k0, reason: collision with root package name */
    @Deprecated
    public static final float f178053k0;

    /* renamed from: l0, reason: collision with root package name */
    public static final int f178054l0;

    /* renamed from: m0, reason: collision with root package name */
    public static int f178055m0;

    /* renamed from: n0, reason: collision with root package name */
    public static final int f178056n0;

    /* renamed from: o0, reason: collision with root package name */
    public static final int f178057o0;

    /* renamed from: p0, reason: collision with root package name */
    public static int f178058p0;

    /* renamed from: q0, reason: collision with root package name */
    public static boolean f178059q0;
    public boolean H;
    public ImageView I;

    static {
        BaseApplication context = BaseApplication.getContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float f16 = displayMetrics.density;
        f178053k0 = f16;
        P = context.getResources().getDimensionPixelSize(R.dimen.f158201a6);
        Q = context.getResources().getDimensionPixelSize(R.dimen.f158200a5);
        R = context.getResources().getDimensionPixelSize(R.dimen.f158199a4);
        S = context.getResources().getDimensionPixelSize(R.dimen.bz7);
        T = context.getResources().getDimensionPixelSize(R.dimen.f158197a3);
        U = context.getResources().getDimensionPixelSize(R.dimen.bz4);
        V = context.getResources().getDimensionPixelSize(R.dimen.f158196a2);
        W = context.getResources().getDimensionPixelSize(R.dimen.f158271bw);
        f178043a0 = context.getResources().getDimensionPixelSize(R.dimen.f158270bv);
        f178044b0 = context.getResources().getDimensionPixelSize(R.dimen.f158269bu);
        f178045c0 = context.getResources().getDimensionPixelSize(R.dimen.c0y);
        f178046d0 = context.getResources().getDimensionPixelSize(R.dimen.f158268bt);
        f178047e0 = context.getResources().getDimensionPixelSize(R.dimen.c0x);
        f178048f0 = context.getResources().getDimensionPixelSize(R.dimen.f158206ab);
        int i3 = displayMetrics.widthPixels;
        J = i3;
        int i16 = displayMetrics.heightPixels;
        K = i16;
        int min = Math.min(i3, i16);
        L = min;
        int i17 = (int) (min - (f16 * 108.0f));
        M = i17;
        N = (i17 - f()) - e();
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.f158247b9);
        f178049g0 = dimensionPixelSize;
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.b_);
        f178050h0 = dimensionPixelSize2;
        f178051i0 = context.getResources().getDimensionPixelSize(R.dimen.f158248ba);
        f178052j0 = context.getResources().getDimensionPixelSize(R.dimen.f158245b7);
        f178054l0 = context.getResources().getDimensionPixelSize(R.dimen.f158230az);
        f178055m0 = context.getResources().getDimensionPixelSize(R.dimen.f158228ax);
        int dimensionPixelSize3 = context.getResources().getDimensionPixelSize(R.dimen.f159574ay1);
        f178058p0 = dimensionPixelSize3;
        f178058p0 = Math.min(dimensionPixelSize3, N);
        int dimensionPixelSize4 = ((L - dimensionPixelSize) - dimensionPixelSize2) - (context.getResources().getDimensionPixelSize(R.dimen.axw) * 2);
        int d16 = d() + c() + f178058p0;
        f178056n0 = Math.min(dimensionPixelSize4, d16);
        if (L < 1441) {
            f178057o0 = dimensionPixelSize4;
        } else {
            f178057o0 = Math.min(dimensionPixelSize4, d16);
        }
        f178059q0 = false;
    }

    public BaseChatItemLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.H = false;
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
    }

    public static int c() {
        if (QQTheme.isNowSimpleUI()) {
            return U;
        }
        return T;
    }

    public static int d() {
        if (QQTheme.isNowSimpleUI()) {
            return S;
        }
        return R;
    }

    public static int e() {
        return c() + g();
    }

    public static int f() {
        return d() + h();
    }

    public static int g() {
        if (QQTheme.isNowSimpleUI()) {
            return f178047e0;
        }
        return f178046d0;
    }

    public static int h() {
        if (QQTheme.isNowSimpleUI()) {
            return f178045c0;
        }
        return f178044b0;
    }

    public void b(int i3, int i16) {
        w.a("BaseChatItemLayout#doDismiss");
    }

    public boolean i() {
        w.a("BaseChatItemLayout#haveStickers");
        return false;
    }

    public void j() {
        w.a("BaseChatItemLayout#startAutoDismiss");
    }

    public BaseChatItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BaseChatItemLayout(Context context) {
        this(context, null);
    }
}
