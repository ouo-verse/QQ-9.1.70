package com.qzone.widget.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.qzone.album.base.AlbumPersonalizeManager;
import com.qzone.util.l;
import com.tencent.mobileqq.R;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import common.config.service.QzoneConfig;

/* compiled from: P */
/* loaded from: classes37.dex */
public class LoadingLayout extends FrameLayout implements ep.a {
    private final View C;
    private Drawable D;
    private Drawable E;
    private Drawable F;
    private boolean G;
    private String H;
    private String I;
    private String J;
    private String K;
    private String L;
    private CharSequence M;
    private RotateAnimation N;
    private RotateAnimation P;
    private final Animation Q;
    private View R;
    private View S;
    private ImageView T;
    private View U;
    private ViewGroup V;
    private boolean W;

    /* renamed from: d, reason: collision with root package name */
    protected final String f60872d;

    /* renamed from: e, reason: collision with root package name */
    private final RelativeLayout f60873e;

    /* renamed from: f, reason: collision with root package name */
    private final ImageView f60874f;

    /* renamed from: h, reason: collision with root package name */
    private final Matrix f60875h;

    /* renamed from: i, reason: collision with root package name */
    private final TextView f60876i;

    /* renamed from: m, reason: collision with root package name */
    private final TextView f60877m;

    /* compiled from: P */
    /* loaded from: classes37.dex */
    class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            Log.i(LoadingLayout.this.f60872d, "onGlobalLayout: height " + LoadingLayout.this.V.getHeight());
            Log.i(LoadingLayout.this.f60872d, "onGlobalLayout: padding " + LoadingLayout.this.V.getPaddingTop() + " " + LoadingLayout.this.V.getPaddingBottom());
            ViewGroup.LayoutParams layoutParams = LoadingLayout.this.V.getLayoutParams();
            if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                Log.i(LoadingLayout.this.f60872d, "onGlobalLayout: margin " + marginLayoutParams.topMargin + " " + marginLayoutParams.bottomMargin);
            }
        }
    }

    public LoadingLayout(Context context, TypedArray typedArray) {
        super(context);
        Drawable drawable;
        this.f60872d = LoadingLayout.class.getSimpleName();
        this.G = true;
        this.K = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DETAIL_GAME_DRAG_LABEL, l.a(R.string.ns7));
        this.L = l.a(R.string.ns8);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.bqg, this);
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.g5r);
        this.f60873e = relativeLayout;
        this.V = relativeLayout;
        this.f60876i = (TextView) viewGroup.findViewById(R.id.g5x);
        this.f60877m = (TextView) viewGroup.findViewById(R.id.g5w);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.g5s);
        this.f60874f = imageView;
        this.C = findViewById(R.id.g5q);
        this.R = findViewById(R.id.g5y);
        this.S = findViewById(R.id.g5t);
        this.T = (ImageView) findViewById(R.id.g5u);
        this.U = findViewById(R.id.g5p);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.f60875h = matrix;
        imageView.setImageMatrix(matrix);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.Q = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(600L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.N = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.N.setFillAfter(true);
        RotateAnimation rotateAnimation3 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.P = rotateAnimation3;
        rotateAnimation3.setDuration(100L);
        this.P.setFillAfter(true);
        this.H = context.getString(R.string.hqh);
        this.I = context.getString(R.string.hqg);
        this.J = context.getString(R.string.hqj);
        if (typedArray.hasValue(9)) {
            ColorStateList colorStateList = typedArray.getColorStateList(9);
            setTextColor(colorStateList == null ? ColorStateList.valueOf(-16777216) : colorStateList);
        }
        if (typedArray.hasValue(8)) {
            ColorStateList colorStateList2 = typedArray.getColorStateList(8);
            setSubTextColor(colorStateList2 == null ? ColorStateList.valueOf(-16777216) : colorStateList2);
        }
        if (typedArray.hasValue(7) && (drawable = typedArray.getDrawable(7)) != null) {
            setBackgroundDrawable(drawable);
        }
        Drawable drawable2 = typedArray.hasValue(6) ? typedArray.getDrawable(6) : null;
        drawable2 = drawable2 == null ? context.getResources().getDrawable(R.drawable.buv) : drawable2;
        setLoadingDrawable(drawable2);
        setPullDrawable(drawable2);
        setReleaseDrawable(drawable2);
        setDividerVisible(false);
        reset();
    }

    private void h() {
        this.f60875h.reset();
        this.f60874f.setImageMatrix(this.f60875h);
    }

    private void i() {
        if (TextUtils.isEmpty(this.M)) {
            this.f60877m.setVisibility(8);
        } else {
            this.f60877m.setText(this.M);
            this.f60877m.setVisibility(0);
        }
    }

    @Override // ep.a
    public void a() {
        this.f60876i.setText(this.H);
        this.f60874f.clearAnimation();
        this.f60874f.setImageDrawable(this.E);
        this.f60874f.startAnimation(this.P);
        f();
        i();
    }

    @Override // ep.a
    public void b() {
        this.f60876i.setText(this.I);
        this.f60874f.clearAnimation();
        this.f60874f.setImageDrawable(this.D);
        this.f60874f.startAnimation(this.Q);
        i();
    }

    @Override // ep.a
    public void c(int i3, String str) {
        this.f60876i.setText(str);
        this.f60874f.clearAnimation();
        if (i3 == 0) {
            this.f60874f.setImageResource(R.drawable.refresh_success);
        } else {
            if (i3 != 1) {
                return;
            }
            this.f60874f.setImageResource(R.drawable.refresh_fail);
        }
    }

    @Override // ep.a
    public void d() {
        this.f60876i.setText(this.J);
        this.f60874f.clearAnimation();
        this.f60874f.setImageDrawable(this.E);
        this.f60874f.startAnimation(this.N);
        i();
    }

    public void f() {
        if (!AlbumPersonalizeManager.L().Q()) {
            QLog.d(this.f60872d, 1, "user skin is not default1");
            return;
        }
        if (this.W) {
            TextView textView = this.f60876i;
            if (textView == null || this.U == null) {
                return;
            }
            textView.setTextColor(-16777216);
            this.U.setBackgroundColor(-1);
            return;
        }
        s5.a.m(this.f60876i);
        s5.a.e(this.f60874f);
        s5.a.h(this.U);
        QLog.d(this.f60872d, 1, "adapt night model success");
    }

    public void g() {
        this.R.setVisibility(4);
        this.S.setVisibility(4);
        this.T.setImageResource(R.drawable.fzb);
        this.T.setVisibility(0);
    }

    @Override // ep.a
    public void reset() {
        this.f60876i.setText(this.H);
        this.f60876i.setVisibility(0);
        i();
        this.f60874f.setImageDrawable(this.E);
        this.f60874f.setVisibility(0);
        this.f60874f.clearAnimation();
        h();
    }

    public void setBackgroundAlpha(int i3) {
        this.U.setAlpha(i3 / 255.0f);
        this.f60876i.setTextColor(BaseApplication.getContext().getResources().getColor(R.color.f156918f7));
    }

    public void setDividerVisible(boolean z16) {
        this.C.setVisibility(z16 ? 0 : 8);
    }

    @Override // ep.a
    public void setHeaderLayoutBackgroundColor(int i3) {
        RelativeLayout relativeLayout = this.f60873e;
        if (relativeLayout != null) {
            relativeLayout.setBackgroundColor(i3);
        }
    }

    @Override // ep.a
    public void setLoadingBackgroundColor(int i3) {
        if (!AlbumPersonalizeManager.L().Q()) {
            QLog.d(this.f60872d, 1, "user skin is not default2");
        } else {
            if (this.U == null) {
                return;
            }
            QLog.d(this.f60872d, 1, "set black background success");
            this.U.setBackgroundColor(i3);
        }
    }

    public void setLoadingDrawable(Drawable drawable) {
        this.D = drawable;
        this.f60874f.setImageDrawable(drawable);
    }

    @Override // ep.a
    public void setNotAdaptNightMode(boolean z16) {
        this.W = z16;
    }

    public void setPullAnimationEnabled(boolean z16) {
        this.G = z16;
    }

    public void setPullDrawable(Drawable drawable) {
        this.E = drawable;
    }

    public void setPullLabel(String str) {
        this.H = str;
    }

    public void setRefreshingLabel(String str) {
        this.I = str;
    }

    public void setReleaseDrawable(Drawable drawable) {
        this.F = drawable;
    }

    public void setReleaseLabel(String str) {
        this.J = str;
    }

    @Override // ep.a
    public void setSubHeaderText(CharSequence charSequence) {
        this.M = charSequence;
        if (TextUtils.isEmpty(charSequence)) {
            this.f60877m.setVisibility(8);
        } else {
            this.f60877m.setText(charSequence);
            this.f60877m.setVisibility(0);
        }
    }

    public void setSubTextColor(ColorStateList colorStateList) {
        this.f60877m.setTextColor(colorStateList);
    }

    public void setSubTextSize(float f16) {
        this.f60877m.setTextSize(f16);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f60876i.setTextColor(colorStateList);
    }

    public void setTextSize(float f16) {
        this.f60876i.setTextSize(f16);
    }

    public void setViewHeight(int i3) {
        Log.i(this.f60872d, "setViewHeight: " + i3);
        ViewGroup.LayoutParams layoutParams = this.V.getLayoutParams();
        layoutParams.height = i3;
        this.V.setLayoutParams(layoutParams);
        this.V.invalidate();
        this.V.getViewTreeObserver().addOnGlobalLayoutListener(new a());
    }

    public void setSubTextColor(int i3) {
        setSubTextColor(ColorStateList.valueOf(i3));
    }

    @Override // ep.a
    public void setTextColor(int i3) {
        setTextColor(ColorStateList.valueOf(i3));
    }

    @Override // ep.a
    public View getView() {
        return this;
    }

    public LoadingLayout(Context context) {
        super(context);
        this.f60872d = LoadingLayout.class.getSimpleName();
        this.G = true;
        this.K = QzoneConfig.getInstance().getConfig("QZoneSetting", QzoneConfig.SECONDARY_DETAIL_GAME_DRAG_LABEL, l.a(R.string.ns7));
        this.L = l.a(R.string.ns8);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.bqg, this);
        RelativeLayout relativeLayout = (RelativeLayout) viewGroup.findViewById(R.id.g5r);
        this.f60873e = relativeLayout;
        this.V = relativeLayout;
        this.f60876i = (TextView) viewGroup.findViewById(R.id.g5x);
        this.f60877m = (TextView) viewGroup.findViewById(R.id.g5w);
        ImageView imageView = (ImageView) viewGroup.findViewById(R.id.g5s);
        this.f60874f = imageView;
        this.C = findViewById(R.id.g5q);
        this.R = findViewById(R.id.g5y);
        this.S = findViewById(R.id.g5t);
        this.T = (ImageView) findViewById(R.id.g5u);
        this.U = findViewById(R.id.g5p);
        imageView.setScaleType(ImageView.ScaleType.MATRIX);
        Matrix matrix = new Matrix();
        this.f60875h = matrix;
        imageView.setImageMatrix(matrix);
        LinearInterpolator linearInterpolator = new LinearInterpolator();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        this.Q = rotateAnimation;
        rotateAnimation.setInterpolator(linearInterpolator);
        rotateAnimation.setDuration(600L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setRepeatMode(1);
        RotateAnimation rotateAnimation2 = new RotateAnimation(0.0f, -180.0f, 1, 0.5f, 1, 0.5f);
        this.N = rotateAnimation2;
        rotateAnimation2.setDuration(100L);
        this.N.setFillAfter(true);
        RotateAnimation rotateAnimation3 = new RotateAnimation(-180.0f, 0.0f, 1, 0.5f, 1, 0.5f);
        this.P = rotateAnimation3;
        rotateAnimation3.setDuration(100L);
        this.P.setFillAfter(true);
        this.H = context.getString(R.string.hqh);
        this.I = context.getString(R.string.hqg);
        this.J = context.getString(R.string.hqj);
        Drawable drawable = context.getResources().getDrawable(R.drawable.refresh_arrow_2);
        setLoadingDrawable(context.getResources().getDrawable(R.drawable.b08));
        setPullDrawable(drawable);
        setReleaseDrawable(drawable);
        setDividerVisible(false);
        reset();
    }
}
