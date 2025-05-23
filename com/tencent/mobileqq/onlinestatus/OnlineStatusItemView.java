package com.tencent.mobileqq.onlinestatus;

import android.animation.Animator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.FontSettingManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.onlinestatus.utils.LottieHelper;
import com.tencent.mobileqq.onlinestatus.utils.NewStatusCache;
import com.tencent.mobileqq.onlinestatus.utils.OnlineStatusToggleUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.widget.lottie.LottieLoader;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BatteryDrawable;
import com.tencent.widget.OnlineBatteryProducer;

/* compiled from: P */
/* loaded from: classes16.dex */
public class OnlineStatusItemView extends RelativeLayout implements Animator.AnimatorListener {
    private ImageView C;
    private CheckBox D;
    private LottieAnimationView E;
    private LottieDrawable F;
    private ba G;
    private TextView H;
    private int I;
    private OnlineBatteryProducer J;
    private int K;

    /* renamed from: d, reason: collision with root package name */
    private int f255336d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f255337e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f255338f;

    /* renamed from: h, reason: collision with root package name */
    public au f255339h;

    /* renamed from: i, reason: collision with root package name */
    private View f255340i;

    /* renamed from: m, reason: collision with root package name */
    private TextView f255341m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes16.dex */
    public class a implements LottieHelper.d {
        a() {
        }

        @Override // com.tencent.mobileqq.onlinestatus.utils.LottieHelper.d
        public void onLoad(LottieDrawable lottieDrawable) {
            if (lottieDrawable != null) {
                OnlineStatusItemView.this.F = lottieDrawable;
                OnlineStatusItemView.this.F.addAnimatorListener(OnlineStatusItemView.this);
                OnlineStatusItemView.this.E.setImageDrawable(OnlineStatusItemView.this.F);
                OnlineStatusItemView.this.r();
            }
        }
    }

    public OnlineStatusItemView(Context context) {
        super(context);
        this.f255337e = false;
        this.f255338f = false;
        this.J = null;
        this.K = 0;
    }

    private boolean f(au auVar, boolean z16) {
        if (!z16 || !this.G.f255575n || !af.j0(auVar.f255494g, auVar.f255489b)) {
            return false;
        }
        this.G.f255575n = false;
        return com.tencent.mobileqq.onlinestatus.utils.ak.k(auVar.f255498k, auVar.f255499l, OnlineStatusResDownLoader.d(auVar.f255489b));
    }

    private void g() {
        CheckBox checkBox = new CheckBox(getContext());
        this.D = checkBox;
        checkBox.setClickable(false);
        int dpToPx = ViewUtils.dpToPx(16.0f);
        int dpToPx2 = ViewUtils.dpToPx(7.0f);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(dpToPx, dpToPx);
        layoutParams.addRule(10);
        layoutParams.topMargin = dpToPx2;
        layoutParams.rightMargin = dpToPx2;
        this.D.setButtonDrawable((Drawable) null);
        layoutParams.addRule(11);
        this.D.setBackgroundDrawable(getResources().getDrawable(R.drawable.f160053j34));
        addView(this.D, layoutParams);
    }

    private void h() {
        LottieAnimationView lottieAnimationView = new LottieAnimationView(getContext());
        this.E = lottieAnimationView;
        lottieAnimationView.setVisibility(8);
        addView(this.E, new RelativeLayout.LayoutParams(-1, -1));
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setId(R.id.f166461zy1);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        addView(linearLayout, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.C = imageView;
        imageView.setId(R.id.bvs);
        int i3 = this.f255336d;
        linearLayout.addView(this.C, new RelativeLayout.LayoutParams(i3, i3));
        TextView textView = new TextView(getContext());
        this.f255341m = textView;
        textView.setId(R.id.bvz);
        this.f255341m.setTextSize(1, 14.0f);
        this.f255341m.setSingleLine(true);
        this.f255341m.setEllipsize(TextUtils.TruncateAt.END);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = ViewUtils.dpToPx(4.0f);
        linearLayout.addView(this.f255341m, layoutParams2);
        if (AppSetting.t(getContext()) && FontSettingManager.getFontLevel() > 16.0f) {
            FontSettingManager.resetViewSize2Normal(getContext(), linearLayout);
        }
        TextView textView2 = new TextView(getContext());
        this.H = textView2;
        p(textView2);
        View view = new View(getContext());
        this.f255340i = view;
        view.setId(R.id.zy6);
        this.f255340i.setVisibility(8);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, -2);
        layoutParams3.addRule(12);
        layoutParams3.addRule(3, R.id.f166461zy1);
        layoutParams3.topMargin = -ViewUtils.dpToPx(16.0f);
        addView(this.f255340i, layoutParams3);
    }

    private String i() {
        return "";
    }

    private int j(boolean z16, boolean z17, boolean z18) {
        if (this.G.f255562a == 2) {
            return R.drawable.j1n;
        }
        if (!z16) {
            return R.drawable.j1k;
        }
        if (z17) {
            return R.drawable.j1m;
        }
        if (z18) {
            return R.drawable.j1k;
        }
        return R.drawable.j1l;
    }

    private int k(boolean z16, boolean z17) {
        if (z16) {
            if (z17) {
                return R.drawable.jj7;
            }
            return R.drawable.jj6;
        }
        return R.drawable.jj5;
    }

    private int l(boolean z16, boolean z17, boolean z18) {
        int i3;
        if (z16) {
            if (z17) {
                i3 = -3355444;
            } else {
                i3 = -16777216;
            }
        } else {
            i3 = -1;
        }
        if (z18) {
            if (z16 && z17) {
                return -3355444;
            }
            return -1;
        }
        return i3;
    }

    private BatteryDrawable m(int i3) {
        if (this.J == null) {
            this.J = new OnlineBatteryProducer();
        }
        return this.J.getSelfBatteryDrawable(getContext(), i3);
    }

    private ColorStateList n(boolean z16) {
        int i3;
        if (z16) {
            i3 = R.color.qui_common_text_allwhite_primary;
        } else {
            i3 = R.color.qui_common_text_primary;
        }
        return ResourcesCompat.getColorStateList(getResources(), i3, getContext().getTheme());
    }

    private boolean q(boolean z16) {
        au auVar;
        if (z16 || (auVar = this.f255339h) == null || auVar.f255513z <= 0) {
            return false;
        }
        long serverTime = NetConnInfoCenter.getServerTime();
        au auVar2 = this.f255339h;
        if (serverTime >= auVar2.f255513z || !NewStatusCache.f256304a.g(auVar2.f255494g, auVar2.f255489b)) {
            return false;
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        LottieDrawable lottieDrawable = this.F;
        if (lottieDrawable != null && !lottieDrawable.isAnimating()) {
            this.F.playAnimation();
        }
    }

    private boolean s(au auVar) {
        ba baVar;
        boolean z16;
        if (auVar == null || (baVar = this.G) == null) {
            return false;
        }
        boolean z17 = baVar.f255578q;
        if (auVar.B <= -100) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (!z17 || !z16) {
            return false;
        }
        return true;
    }

    private void t() {
        w();
        au auVar = this.f255339h;
        if (auVar != null && f(auVar, this.f255338f)) {
            this.E.setVisibility(0);
            au auVar2 = this.f255339h;
            String c16 = OnlineStatusResDownLoader.c(auVar2.f255498k, auVar2.f255499l, auVar2.f255489b);
            BaseApplication context = BaseApplication.getContext();
            String str = c16 + LottieLoader.FILE_DATA_JSON;
            String str2 = c16 + LottieLoader.FILE_IMAGES;
            int i3 = this.I;
            LottieHelper.c(context, str, str2, i3, i3, new a());
            return;
        }
        v();
    }

    private void u(boolean z16, boolean z17) {
        int i3;
        int i16;
        Drawable drawable;
        int i17;
        if (this.f255341m == null) {
            return;
        }
        if (z17) {
            drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.k5f, null);
            i3 = ViewUtils.dpToPx(9.0f);
            i16 = ViewUtils.dpToPx(3.0f);
        } else if (z16) {
            Resources resources = getResources();
            if (this.f255338f) {
                i17 = R.drawable.lnr;
            } else {
                i17 = R.drawable.lnq;
            }
            drawable = ResourcesCompat.getDrawable(resources, i17, null);
            i3 = ViewUtils.dpToPx(14.0f);
            i16 = ViewUtils.dpToPx(1.5f);
        } else {
            i3 = 0;
            i16 = 0;
            drawable = null;
        }
        if (drawable != null) {
            drawable.setBounds(0, 0, i3, i3);
        }
        this.f255341m.setCompoundDrawables(null, null, drawable, null);
        this.f255341m.setCompoundDrawablePadding(i16);
    }

    private void v() {
        this.E.setVisibility(8);
        LottieDrawable lottieDrawable = this.F;
        if (lottieDrawable != null) {
            lottieDrawable.removeAnimatorListener(this);
        }
    }

    private void w() {
        LottieDrawable lottieDrawable = this.F;
        if (lottieDrawable == null) {
            return;
        }
        if (lottieDrawable.isAnimating()) {
            this.F.stop();
        }
        this.F.removeAnimatorListener(this);
        this.F.setFrame(0);
        this.F = null;
    }

    public void e(au auVar) {
        int i3;
        Drawable drawable;
        int i16;
        int i17;
        int parseColor;
        if (auVar == null) {
            return;
        }
        this.f255339h = auVar;
        this.f255341m.setText(auVar.f255490c);
        boolean s16 = s(auVar);
        View view = this.f255340i;
        if (s16) {
            i3 = 0;
        } else {
            i3 = 8;
        }
        view.setVisibility(i3);
        if (OnlineStatusToggleUtils.d() && ((i17 = this.G.f255562a) == 1 || i17 == 3)) {
            try {
                if (TextUtils.isEmpty(auVar.f255510w)) {
                    parseColor = this.K;
                } else {
                    parseColor = Color.parseColor(auVar.f255510w);
                }
                this.K = parseColor;
            } catch (Exception e16) {
                QLog.e("OnlineStatusItemView", 1, "bindOnlineStatusItem " + e16);
            }
        }
        ba baVar = this.G;
        boolean z16 = baVar.f255576o;
        boolean z17 = baVar.f255577p;
        if (auVar.f255493f == 2) {
            drawable = ar.c(auVar.f255494g);
        } else if (this.f255337e && !TextUtils.isEmpty(i())) {
            Object obj = new QQText(i(), 3).mSpans[0];
            if (obj instanceof EmoticonSpan) {
                drawable = ((EmoticonSpan) obj).getDrawable();
            } else {
                drawable = null;
            }
        } else if (af.C().e0(auVar)) {
            drawable = m(1);
        } else if (auVar.f255489b == 1080 && af.C().f0()) {
            drawable = af.C().G(auVar, this.f255336d, 3);
        } else if (auVar.f255489b == 2000) {
            drawable = ResourcesCompat.getDrawable(this.C.getResources(), j(z16, z17, this.f255338f), null);
        } else {
            drawable = URLDrawable.getDrawable(this.f255339h.f255491d, URLDrawable.URLDrawableOptions.obtain());
        }
        if (drawable != null) {
            int i18 = this.f255336d;
            drawable.setBounds(0, 0, i18, i18);
            this.C.setImageDrawable(drawable);
        }
        if (!OnlineStatusToggleUtils.d()) {
            setBackgroundResource(k(z16, z17));
        }
        if (this.G.f255562a == 2) {
            setBackgroundResource(R.drawable.jj8);
            this.f255341m.setTextColor(n(this.f255338f));
        } else {
            this.f255341m.setTextColor(l(z16, z17, this.f255338f));
        }
        this.H.setVisibility(8);
        boolean q16 = q(this.f255338f);
        if (OnlineStatusToggleUtils.d() && (((i16 = this.G.f255562a) == 1 || i16 == 3) && !this.f255338f)) {
            if (q16) {
                setBackgroundResource(R.drawable.jj9);
            } else {
                setBackground(null);
            }
        }
        u(s16, q16);
    }

    public void o(ba baVar) {
        this.G = baVar;
        this.f255336d = ViewUtils.dpToPx(30.0f);
        if (AppSetting.t(getContext()) && FontSettingManager.getFontLevel() > 16.0f) {
            this.f255336d = ViewUtils.dpToPx(20.0f);
        }
        h();
        if (baVar.f255563b) {
            g();
        }
        setOnTouchListener(new LottieHelper.e());
        this.K = ResourcesCompat.getColor(getResources(), R.color.qui_common_brand_standard, getContext().getTheme());
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationCancel(Animator animator) {
        v();
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animator) {
        v();
    }

    public void p(TextView textView) {
        textView.setText(R.string.f201464uv);
        textView.setTextSize(1, 12.0f);
        textView.setSingleLine(true);
        textView.setGravity(17);
        textView.setEllipsize(TextUtils.TruncateAt.END);
        textView.setRotation(45.0f);
        textView.setTextColor(Color.parseColor("#FFFFFF"));
        textView.setBackgroundColor(Color.parseColor("#FF596A"));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(ViewUtils.dip2px(50.0f), ViewUtils.dip2px(16.0f));
        layoutParams.setMargins(0, ViewUtils.dip2px(4.0f), -ViewUtils.dip2px(13.0f), 0);
        layoutParams.addRule(11);
        addView(textView, layoutParams);
    }

    public void setItemWidth(int i3) {
        this.I = i3;
    }

    public void setStatusTextOnClickListener(View.OnClickListener onClickListener) {
        View view = this.f255340i;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag(obj);
        View view = this.f255340i;
        if (view != null) {
            view.setTag(obj);
        }
    }

    public void x(boolean z16) {
        int i3;
        TextView textView = this.H;
        if (textView != null) {
            if (z16) {
                i3 = 0;
            } else {
                i3 = 8;
            }
            textView.setVisibility(i3);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v15, types: [android.graphics.drawable.Drawable] */
    /* JADX WARN: Type inference failed for: r8v0, types: [android.view.View, com.tencent.mobileqq.onlinestatus.OnlineStatusItemView] */
    public void y() {
        Drawable drawable;
        int i3;
        GradientDrawable gradientDrawable;
        ba baVar = this.G;
        boolean z16 = baVar.f255577p;
        boolean z17 = baVar.f255576o;
        this.f255341m.setTextColor(l(z17, z16, this.f255338f));
        if (OnlineStatusToggleUtils.d() && ((i3 = this.G.f255562a) == 1 || i3 == 3)) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(8.0f));
            gradientDrawable2.setColor(this.K);
            if (q(this.f255338f)) {
                gradientDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.jj9, null);
            } else {
                gradientDrawable = null;
            }
            if (!this.f255338f) {
                gradientDrawable2 = gradientDrawable;
            }
            setBackground(gradientDrawable2);
        } else if (this.G.f255562a == 2) {
            this.f255341m.setTextColor(n(this.f255338f));
            setBackgroundResource(R.drawable.jj8);
        } else {
            setBackgroundResource(k(z17, z16));
        }
        au auVar = this.f255339h;
        if (auVar != null && auVar.f255489b == 2000 && (drawable = ResourcesCompat.getDrawable(this.C.getResources(), j(z17, z16, this.f255338f), null)) != null) {
            int i16 = this.f255336d;
            drawable.setBounds(0, 0, i16, i16);
            this.C.setImageDrawable(drawable);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v0, types: [android.view.View, com.tencent.mobileqq.onlinestatus.OnlineStatusItemView] */
    /* JADX WARN: Type inference failed for: r7v9, types: [android.graphics.drawable.Drawable] */
    public void z(boolean z16) {
        Drawable drawable;
        int i3;
        GradientDrawable gradientDrawable;
        this.f255338f = z16;
        ba baVar = this.G;
        boolean z17 = baVar.f255576o;
        boolean z18 = baVar.f255577p;
        if (baVar.f255562a == 2) {
            setBackgroundResource(R.drawable.jj8);
        }
        if (this.G.f255563b) {
            this.D.setChecked(z16);
            if (this.G.f255562a == 2) {
                this.f255341m.setTextColor(n(z16));
            } else {
                this.f255341m.setTextColor(l(z17, z18, z16));
            }
            setSelected(false);
        } else {
            setSelected(z16);
            boolean q16 = q(z16);
            if (OnlineStatusToggleUtils.d() && ((i3 = this.G.f255562a) == 1 || i3 == 3)) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(ViewUtils.dpToPx(8.0f));
                gradientDrawable2.setColor(this.K);
                if (q16) {
                    gradientDrawable = ResourcesCompat.getDrawable(getResources(), R.drawable.jj9, null);
                } else {
                    gradientDrawable = null;
                }
                if (!z16) {
                    gradientDrawable2 = gradientDrawable;
                }
                setBackground(gradientDrawable2);
            }
            if (this.G.f255562a == 2) {
                this.f255341m.setTextColor(n(z16));
            } else {
                this.f255341m.setTextColor(l(z17, z18, z16));
            }
            au auVar = this.f255339h;
            if (auVar != null && auVar.f255489b == 2000 && (drawable = ResourcesCompat.getDrawable(this.C.getResources(), j(z17, z18, z16), null)) != null) {
                int i16 = this.f255336d;
                drawable.setBounds(0, 0, i16, i16);
                this.C.setImageDrawable(drawable);
            }
            u(s(this.f255339h), q16);
        }
        t();
        invalidate();
    }

    public OnlineStatusItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f255337e = false;
        this.f255338f = false;
        this.J = null;
        this.K = 0;
    }

    public OnlineStatusItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f255337e = false;
        this.f255338f = false;
        this.J = null;
        this.K = 0;
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationRepeat(Animator animator) {
    }

    @Override // android.animation.Animator.AnimatorListener
    public void onAnimationStart(Animator animator) {
    }
}
