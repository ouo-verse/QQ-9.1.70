package com.tencent.mobileqq.qqui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.ams.fusion.widget.downloadcard.DownloadCardView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qqui.utils.CombineAvatarUtils;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.QUITokenResCompat;
import com.tencent.util.TokenResUtils;
import java.util.HashMap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
/* loaded from: classes17.dex */
public class TipsBar extends RelativeLayout {
    static IPatchRedirector $redirector_;

    /* renamed from: i0, reason: collision with root package name */
    public static final int f274771i0;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private final int H;
    private final int I;
    private final int J;
    private String K;
    private String L;
    private Drawable M;
    private String N;
    private final boolean P;
    protected ImageView Q;
    protected ImageView R;
    protected TextView S;
    protected TextView T;
    protected ImageView U;
    protected ImageView V;
    protected Button W;

    /* renamed from: a0, reason: collision with root package name */
    private final float f274772a0;

    /* renamed from: b0, reason: collision with root package name */
    private b f274773b0;

    /* renamed from: c0, reason: collision with root package name */
    private b f274774c0;

    /* renamed from: d, reason: collision with root package name */
    private int f274775d;

    /* renamed from: d0, reason: collision with root package name */
    private b f274776d0;

    /* renamed from: e, reason: collision with root package name */
    private final int f274777e;

    /* renamed from: e0, reason: collision with root package name */
    private View f274778e0;

    /* renamed from: f, reason: collision with root package name */
    private final int f274779f;

    /* renamed from: f0, reason: collision with root package name */
    private int f274780f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f274781g0;

    /* renamed from: h, reason: collision with root package name */
    private final int f274782h;

    /* renamed from: h0, reason: collision with root package name */
    private Map<String, String> f274783h0;

    /* renamed from: i, reason: collision with root package name */
    private final int f274784i;

    /* renamed from: m, reason: collision with root package name */
    private final int f274785m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class a implements View.OnTouchListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TipsBar.this);
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) view, (Object) motionEvent)).booleanValue();
            }
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1 || action == 3) {
                    view.setAlpha(1.0f);
                    return false;
                }
                return false;
            }
            view.setAlpha(0.5f);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes17.dex */
    public class b implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private View.OnClickListener f274787d;

        /* renamed from: e, reason: collision with root package name */
        private int f274788e;

        b(int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TipsBar.this, i3);
            } else {
                this.f274788e = i3;
            }
        }

        private void a() {
            HashMap hashMap = new HashMap();
            hashMap.put("horizontal_service_id", Integer.valueOf(TipsBar.this.f274781g0));
            hashMap.put("horizontal_click_area", Integer.valueOf(this.f274788e));
            if (TipsBar.this.f274783h0 != null) {
                hashMap.putAll(TipsBar.this.f274783h0);
            }
            com.tencent.mobileqq.aio.utils.b.l("em_bas_aio_small_horizontal", hashMap);
        }

        public void b(View.OnClickListener onClickListener) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) onClickListener);
            } else {
                this.f274787d = onClickListener;
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
            } else {
                View.OnClickListener onClickListener = this.f274787d;
                if (onClickListener != null) {
                    onClickListener.onClick(view);
                }
                a();
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(48093);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 35)) {
            redirector.redirect((short) 35);
        } else {
            f274771i0 = ViewUtils.dip2px(44.0f);
        }
    }

    public TipsBar(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void A(View.OnClickListener onClickListener) {
        if (this.f274773b0 == null) {
            b bVar = new b(3);
            this.f274773b0 = bVar;
            super.setOnClickListener(bVar);
        }
        this.f274773b0.b(onClickListener);
    }

    private void B(Drawable drawable) {
        if (drawable == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.Q.getLayoutParams();
        layoutParams.leftMargin = o();
        this.Q.setLayoutParams(layoutParams);
        this.Q.setVisibility(0);
        y();
        this.Q.setImageDrawable(drawable);
        ImageView imageView = this.R;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        G();
    }

    private void G() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        if (this.Q.getVisibility() == 0) {
            layoutParams.leftMargin = q();
            this.S.setLayoutParams(layoutParams);
            return;
        }
        ImageView imageView = this.R;
        if (imageView != null && imageView.getVisibility() == 0) {
            layoutParams.leftMargin = this.J;
            this.S.setLayoutParams(layoutParams);
        } else {
            layoutParams.leftMargin = o();
            this.S.setLayoutParams(layoutParams);
        }
    }

    private void d() {
        this.U.setId(R.id.jnl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.G, this.H);
        layoutParams.rightMargin = this.D;
        layoutParams.leftMargin = this.C;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.U, layoutParams);
    }

    private void g() {
        if (this.R != null) {
            return;
        }
        ImageView imageView = new ImageView(getContext());
        this.R = imageView;
        imageView.setId(R.id.f97955ls);
        this.R.setScaleType(ImageView.ScaleType.FIT_XY);
        this.R.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f274782h, this.f274784i);
        layoutParams.leftMargin = this.f274785m;
        layoutParams.addRule(1, R.id.jnj);
        layoutParams.addRule(15);
        addView(this.R, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        layoutParams2.addRule(1, R.id.f97955ls);
        this.S.setLayoutParams(layoutParams2);
    }

    private void h() {
        if (this.T != null) {
            return;
        }
        TextView textView = new TextView(getContext());
        this.T = textView;
        textView.setId(R.id.f97995lw);
        this.T.setTextSize(2, 14.0f);
        this.T.setTextColor(getContext().getResources().getColorStateList(R.color.qui_common_text_link));
        this.T.setGravity(16);
        if (!TextUtils.isEmpty(this.L)) {
            this.T.setText(this.L);
            this.T.setContentDescription(this.L);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams.leftMargin = this.I;
        layoutParams.addRule(15);
        layoutParams.addRule(0, R.id.jnl);
        addView(this.T, layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        layoutParams2.addRule(0, R.id.f97995lw);
        this.S.setLayoutParams(layoutParams2);
    }

    private Drawable m(Resources resources, int i3) {
        return resources.getDrawable(R.drawable.qui_close_icon_secondary_01_selector);
    }

    private int o() {
        if (!GlobalDisplayMetricsManager.needAdjustDensity(getContext())) {
            return ViewUtils.dpToPx(25.4f);
        }
        return ViewUtils.dpToPx(28.0f);
    }

    private int p() {
        if (TokenResUtils.useTokenIcon()) {
            return getResources().getColor(R.color.qui_common_text_secondary);
        }
        if (!QQTheme.isNowSimpleUI() && !QQTheme.isNowThemeSimpleNight()) {
            if (QQTheme.isNowThemeIsNight()) {
                return -1712591883;
            }
            return -6775116;
        }
        return DownloadCardView.COLOR_APP_VERSION;
    }

    private int q() {
        if (!GlobalDisplayMetricsManager.needAdjustDensity(getContext())) {
            return ViewUtils.dpToPx(19.4f);
        }
        return ViewUtils.dpToPx(22.0f);
    }

    private void s() {
        int o16;
        setFocusable(true);
        setClickable(true);
        Resources resources = getResources();
        ImageView imageView = new ImageView(getContext());
        this.Q = imageView;
        imageView.setId(R.id.jnj);
        this.Q.setScaleType(ImageView.ScaleType.FIT_XY);
        this.Q.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f274777e, this.f274779f);
        layoutParams.leftMargin = o();
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.Q, layoutParams);
        TextView textView = new TextView(getContext());
        this.S = textView;
        textView.setId(R.id.jnk);
        this.S.setSingleLine(true);
        this.S.setGravity(8388627);
        this.S.setEllipsize(TextUtils.TruncateAt.END);
        this.S.setTextSize(2, 14.0f);
        F();
        this.S.setDuplicateParentStateEnabled(true);
        if (!TextUtils.isEmpty(this.K)) {
            this.S.setText(this.K);
            this.S.setContentDescription(this.K);
        }
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        if (this.M != null) {
            o16 = q();
        } else {
            o16 = o();
        }
        layoutParams2.leftMargin = o16;
        layoutParams2.addRule(15);
        layoutParams2.addRule(1, R.id.jnj);
        layoutParams2.addRule(0, R.id.jnl);
        addView(this.S, layoutParams2);
        this.Q.setVisibility(8);
        setTipsIcon(this.M);
        this.W = w();
        this.V = x();
        this.U = v();
        if (!TextUtils.isEmpty(this.N)) {
            e();
        } else if (this.P) {
            f();
        } else {
            d();
        }
        this.f274778e0 = new View(getContext());
        y();
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams3.addRule(12);
        addView(this.f274778e0, layoutParams3);
        setBackgroundDrawable(j(resources, this.f274775d));
        E();
        this.Q.setOnTouchListener(new a());
    }

    private boolean t(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5 || i3 == 6 || i3 == 7 || i3 == 8) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void u(Bitmap bitmap) {
        this.R.setVisibility(0);
        if (bitmap != null) {
            this.R.setImageBitmap(bitmap);
        } else {
            this.R.setImageResource(R.drawable.f160830com);
        }
    }

    private ImageView v() {
        Resources resources = getResources();
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(i(resources, this.f274775d));
        imageView.setImportantForAccessibility(2);
        return imageView;
    }

    private Button w() {
        Resources resources = getResources();
        Button button = new Button(getContext());
        button.setText(this.N);
        button.setContentDescription(this.N);
        button.setTextSize(2, 14.0f);
        button.setTextColor(l(resources, this.f274775d));
        button.setMinWidth((int) ((this.f274772a0 * 48.0f) + 0.5d));
        button.setMinHeight((int) ((this.f274772a0 * 24.0f) + 0.5d));
        button.setSingleLine(true);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setGravity(17);
        button.setBackgroundDrawable(k(resources));
        int i3 = (int) ((this.f274772a0 * 10.0f) + 0.5d);
        int i16 = i3 / 2;
        button.setPadding(i3, i16, i3, i16);
        return button;
    }

    private void y() {
        if (this.f274778e0 == null) {
            QLog.d("TipsBar", 1, "resetDividerBg, divider is null");
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(getResources().getColorStateList(R.color.skin_divider_color));
        this.f274778e0.setBackgroundDrawable(gradientDrawable);
    }

    private void z(View.OnClickListener onClickListener) {
        if (this.f274773b0 == null) {
            b bVar = new b(1);
            this.f274773b0 = bVar;
            this.W.setOnClickListener(bVar);
        }
        this.f274773b0.b(onClickListener);
    }

    public void C(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, z16);
            return;
        }
        if (this.U == null) {
            this.U = v();
        }
        removeView(this.U);
        removeView(this.W);
        removeView(this.V);
        if (z16) {
            d();
        }
    }

    public void D(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this, z16);
            return;
        }
        if (this.V == null) {
            this.V = x();
        }
        removeView(this.V);
        removeView(this.W);
        removeView(this.U);
        if (z16) {
            f();
        }
    }

    public void E() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    public void F() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        TextView textView = this.S;
        if (textView == null) {
            return;
        }
        if (this.f274775d == 4) {
            textView.setTextColor(ResourcesCompat.getColor(getResources(), R.color.qui_common_feedback_error, getContext().getTheme()));
        } else {
            textView.setTextColor(p());
        }
    }

    protected void e() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        if (this.W != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.F;
            layoutParams.leftMargin = this.C;
            this.W.setId(R.id.jnl);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.W, layoutParams);
        }
    }

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.setId(R.id.jnl);
            int i3 = this.G;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.rightMargin = this.E;
            layoutParams.leftMargin = this.C;
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.V, layoutParams);
        }
    }

    protected Drawable i(Resources resources, int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            return (Drawable) iPatchRedirector.redirect((short) 15, (Object) this, (Object) resources, i3);
        }
        if (TokenResUtils.useTokenIcon()) {
            return resources.getDrawable(R.drawable.qui_chevron_right_icon_secondary_01);
        }
        if (i3 == 5) {
            drawable = resources.getDrawable(R.drawable.cii);
        } else if (QQTheme.isThemeSimpleUI(QQTheme.getCurrentThemeId())) {
            drawable = resources.getDrawable(R.drawable.mr9);
        } else {
            drawable = resources.getDrawable(R.drawable.mr8);
        }
        return n(drawable);
    }

    protected Drawable j(Resources resources, int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (Drawable) iPatchRedirector.redirect((short) 14, (Object) this, (Object) resources, i3);
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
                drawable = ResourcesCompat.getDrawable(resources, R.drawable.qui_common_bg_top_light_bg, getContext().getTheme());
                break;
            case 5:
                drawable = resources.getDrawable(R.drawable.f160564ke);
                break;
            case 6:
                drawable = resources.getDrawable(R.drawable.qui_common_fill_light_primary_overlay_light_bg);
                break;
            case 7:
                drawable = resources.getDrawable(R.drawable.qui_common_fill_light_primary_overlay_light_bg);
                break;
            case 8:
                drawable = resources.getDrawable(R.drawable.qui_common_bg_list_selector);
                break;
            default:
                drawable = resources.getDrawable(R.drawable.f160540jm);
                break;
        }
        return n(drawable);
    }

    public Drawable k(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Drawable) iPatchRedirector.redirect((short) 12, (Object) this, (Object) resources);
        }
        return resources.getDrawable(R.drawable.f160506il);
    }

    protected ColorStateList l(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 13, (Object) this, (Object) resources, i3);
        }
        switch (i3) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 6:
            case 7:
            case 8:
                return resources.getColorStateList(R.color.skin_color_button_common_white);
            case 5:
            default:
                return resources.getColorStateList(R.color.skin_color_button_common_white);
        }
    }

    Drawable n(Drawable drawable) {
        if (!(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        Bitmap createBitmap = Bitmap.createBitmap(bitmap);
        Resources resources = getResources();
        if (resources == null) {
            return drawable;
        }
        if (bitmap != null && createBitmap == null) {
            createBitmap = bitmap;
        } else if (bitmap == null && createBitmap == null) {
            return drawable;
        }
        BitmapDrawable bitmapDrawable = new BitmapDrawable(resources, bitmap);
        BitmapDrawable bitmapDrawable2 = new BitmapDrawable(resources, createBitmap);
        bitmapDrawable2.setAlpha(127);
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, bitmapDrawable2);
        stateListDrawable.addState(new int[]{android.R.attr.state_focused}, bitmapDrawable);
        stateListDrawable.addState(new int[0], bitmapDrawable);
        return stateListDrawable;
    }

    @Override // android.widget.RelativeLayout, android.view.View
    public void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        int i17 = f274771i0;
        super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(i17, 1073741824));
        setMeasuredDimension(getMeasuredWidth(), i17);
    }

    public String r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 27)) {
            return (String) iPatchRedirector.redirect((short) 27, (Object) this);
        }
        return this.K;
    }

    public void setAvatarUins(@NonNull String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) strArr);
            return;
        }
        this.Q.setVisibility(8);
        g();
        CombineAvatarUtils.f274736a.d(getContext(), strArr, new com.tencent.qqnt.avatar.combine.b() { // from class: com.tencent.mobileqq.qqui.widget.c
            @Override // com.tencent.qqnt.avatar.combine.b
            public final void a(Bitmap bitmap) {
                TipsBar.this.u(bitmap);
            }
        });
        G();
    }

    public void setBarType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 24)) {
            iPatchRedirector.redirect((short) 24, (Object) this, i3);
            return;
        }
        if (t(i3)) {
            if (i3 == this.f274775d) {
                return;
            }
            this.f274775d = i3;
            F();
            Resources resources = getResources();
            setBackgroundDrawable(j(resources, this.f274775d));
            if (this.U != null) {
                this.U.setImageDrawable(i(resources, this.f274775d));
            }
            if (this.V != null) {
                this.V.setImageDrawable(m(resources, this.f274775d));
            }
            Button button = this.W;
            if (button != null) {
                button.setTextColor(l(resources, this.f274775d));
                this.W.setBackgroundDrawable(k(resources));
            }
            y();
            return;
        }
        throw new RuntimeException("Parameter bgType is illegal!");
    }

    public void setBusinessType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            iPatchRedirector.redirect((short) 26, (Object) this, i3);
        } else {
            this.f274781g0 = i3;
        }
    }

    public void setButtonText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) charSequence);
            return;
        }
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        if (this.W == null) {
            this.W = w();
        }
        removeView(this.W);
        removeView(this.U);
        removeView(this.V);
        String charSequence2 = charSequence.toString();
        this.N = charSequence2;
        this.W.setText(charSequence2);
        e();
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 33)) {
            iPatchRedirector.redirect((short) 33, (Object) this, (Object) onClickListener);
            return;
        }
        if (onClickListener != null && this.V != null) {
            if (this.f274776d0 == null) {
                b bVar = new b(2);
                this.f274776d0 = bVar;
                this.V.setOnClickListener(bVar);
            }
            this.f274776d0.b(onClickListener);
        }
    }

    public void setID(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, i3);
        } else {
            this.f274780f0 = i3;
        }
    }

    public void setLinkText(CharSequence charSequence) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) charSequence);
            return;
        }
        if (TextUtils.equals(this.L, charSequence)) {
            return;
        }
        h();
        String charSequence2 = charSequence.toString();
        this.L = charSequence2;
        this.T.setText(charSequence2);
        this.T.setContentDescription(this.L);
        TextView textView = this.T;
        if (TextUtils.isEmpty(this.L)) {
            i3 = 8;
        } else {
            i3 = 0;
        }
        textView.setVisibility(i3);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onClickListener);
        } else if (!TextUtils.isEmpty(this.N) && this.W != null) {
            z(onClickListener);
        } else {
            A(onClickListener);
        }
    }

    public void setOnLinkClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) onClickListener);
            return;
        }
        if (this.f274774c0 == null) {
            this.f274774c0 = new b(1);
            h();
            this.T.setOnClickListener(this.f274774c0);
        }
        this.f274774c0.b(onClickListener);
    }

    public void setOriginalOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) onClickListener);
        } else {
            super.setOnClickListener(onClickListener);
        }
    }

    public void setReportParam(@NotNull Map<String, String> map) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 34)) {
            iPatchRedirector.redirect((short) 34, (Object) this, (Object) map);
        } else {
            this.f274783h0 = map;
        }
    }

    @Deprecated
    public void setTipsIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) drawable);
        } else {
            if (drawable == null) {
                return;
            }
            B(getResources().getDrawable(R.drawable.common_banner_tips_warning));
        }
    }

    public void setTipsIconLimitQuiToken(@DrawableRes int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, i3);
            return;
        }
        try {
            String resourceEntryName = getResources().getResourceEntryName(i3);
            if (!TextUtils.isEmpty(resourceEntryName) && resourceEntryName.startsWith("qui_")) {
                B(getResources().getDrawable(QUITokenResCompat.getDrawableResId(i3)));
                return;
            }
            QLog.i("TipsBar", 1, "setTipsIconQuiTokenLimit Illegal params quiTokenResId R.id." + resourceEntryName + ", please ensure it is qui token");
        } catch (Resources.NotFoundException e16) {
            QLog.i("TipsBar", 1, "setTipsIconQuiTokenLimit Illegal params quiTokenResId, please check it is exists");
            QLog.i("TipsBar", 1, "setTipsIconQuiTokenLimit: " + QLog.getStackTraceString(e16));
        }
    }

    public void setTipsText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, (Object) charSequence);
            return;
        }
        String charSequence2 = charSequence.toString();
        this.K = charSequence2;
        this.S.setText(charSequence2);
        this.S.setContentDescription(this.K);
    }

    protected ImageView x() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ImageView) iPatchRedirector.redirect((short) 9, (Object) this);
        }
        Resources resources = getResources();
        ImageView imageView = new ImageView(getContext());
        imageView.setBackground(m(resources, this.f274775d));
        return imageView;
    }

    public TipsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f274777e = ViewUtils.dip2px(24.0f);
        this.f274779f = ViewUtils.dip2px(24.0f);
        this.f274782h = ViewUtils.dip2px(28.0f);
        this.f274784i = ViewUtils.dip2px(28.0f);
        this.f274785m = ViewUtils.dip2px(16.0f);
        this.C = ViewUtils.dip2px(12.0f);
        this.D = ViewUtils.dip2px(11.5f);
        this.E = ViewUtils.dip2px(13.0f);
        this.F = ViewUtils.dip2px(16.0f);
        this.G = ViewUtils.dip2px(16.0f);
        this.H = ViewUtils.dip2px(16.0f);
        this.I = ViewUtils.dip2px(14.5f);
        this.J = ViewUtils.dip2px(10.0f);
        this.f274780f0 = -1;
        this.f274772a0 = getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.P8);
        this.K = obtainStyledAttributes.getString(jj2.b.Y8);
        this.M = obtainStyledAttributes.getDrawable(jj2.b.V8);
        this.N = obtainStyledAttributes.getString(jj2.b.S8);
        this.f274775d = obtainStyledAttributes.getInt(jj2.b.R8, 2);
        this.P = obtainStyledAttributes.getBoolean(jj2.b.U8, false);
        obtainStyledAttributes.recycle();
        s();
    }
}
