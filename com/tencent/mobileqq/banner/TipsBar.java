package com.tencent.mobileqq.banner;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.content.res.ResourcesCompat;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.GlobalDisplayMetricsManager;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableView;
import com.tencent.util.TokenResUtils;

/* compiled from: P */
@Deprecated
/* loaded from: classes11.dex */
public class TipsBar extends RelativeLayout implements SkinnableView {
    static IPatchRedirector $redirector_;
    private final int C;
    private final int D;
    private final int E;
    private final int F;
    private final int G;
    private String H;
    private Drawable I;
    private Drawable J;
    private Drawable K;
    private String L;
    private String M;
    private final boolean N;
    protected ImageView P;
    protected ImageView Q;
    protected ImageView R;
    protected TextView S;
    protected TextView T;
    protected ImageView U;
    protected ImageView V;
    protected Button W;

    /* renamed from: a0, reason: collision with root package name */
    private final float f200231a0;

    /* renamed from: b0, reason: collision with root package name */
    private View.OnClickListener f200232b0;

    /* renamed from: c0, reason: collision with root package name */
    private View f200233c0;

    /* renamed from: d, reason: collision with root package name */
    private int f200234d;

    /* renamed from: e, reason: collision with root package name */
    private final int f200235e;

    /* renamed from: f, reason: collision with root package name */
    private final int f200236f;

    /* renamed from: h, reason: collision with root package name */
    private final int f200237h;

    /* renamed from: i, reason: collision with root package name */
    private final int f200238i;

    /* renamed from: m, reason: collision with root package name */
    private final int f200239m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public class a implements View.OnClickListener {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) TipsBar.this);
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) view);
            } else {
                TipsBar.this.removeAllViews();
            }
            EventCollector.getInstance().onViewClicked(view);
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

    private boolean C() {
        if (TokenResUtils.useNewSearch() && !QQTheme.isVasTheme()) {
            return true;
        }
        return false;
    }

    private void a() {
        this.U.setId(R.id.jnl);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.E, this.F);
        layoutParams.rightMargin = this.f200239m;
        layoutParams.leftMargin = this.f200238i;
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        addView(this.U, layoutParams);
    }

    private void d() {
        ImageView imageView = new ImageView(getContext());
        this.Q = imageView;
        imageView.setId(R.id.f97965lt);
        this.Q.setScaleType(ImageView.ScaleType.FIT_XY);
        this.Q.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f200236f, this.f200237h);
        layoutParams.leftMargin = p() - this.G;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.Q, layoutParams);
        this.Q.setVisibility(8);
    }

    private void e() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        layoutParams.removeRule(0);
        layoutParams.addRule(0, R.id.f97995lw);
        this.S.setLayoutParams(layoutParams);
        removeView(this.T);
        this.T.setText(this.M);
        this.T.setSingleLine(true);
        this.T.setGravity(8388627);
        this.T.setTextSize(2, 14.0f);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -1);
        layoutParams2.addRule(15);
        layoutParams2.addRule(0, R.id.jnl);
        addView(this.T, layoutParams2);
    }

    private void f() {
        ImageView imageView = new ImageView(getContext());
        this.P = imageView;
        imageView.setId(R.id.jnj);
        this.P.setScaleType(ImageView.ScaleType.FIT_XY);
        this.P.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f200236f, this.f200237h);
        layoutParams.leftMargin = p();
        layoutParams.addRule(3, R.id.f97965lt);
        layoutParams.addRule(9);
        layoutParams.addRule(8, R.id.f97965lt);
        layoutParams.addRule(6, R.id.f97965lt);
        layoutParams.addRule(15);
        addView(this.P, layoutParams);
        this.P.setVisibility(8);
    }

    private void g() {
        ImageView imageView = new ImageView(getContext());
        this.R = imageView;
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        this.R.setImportantForAccessibility(2);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(this.f200236f, this.f200237h);
        layoutParams.leftMargin = p() + this.G;
        layoutParams.addRule(3, R.id.jnj);
        layoutParams.addRule(9);
        layoutParams.addRule(8, R.id.jnj);
        layoutParams.addRule(6, R.id.jnj);
        layoutParams.addRule(15);
        addView(this.R, layoutParams);
        this.R.setVisibility(8);
    }

    private Drawable n() {
        return ResourcesCompat.getDrawable(getResources(), R.drawable.qui_close_icon_secondary_01_selector, null);
    }

    private int p() {
        if (!GlobalDisplayMetricsManager.needAdjustDensity(getContext()) && QQTheme.isNowSimpleUI()) {
            return ViewUtils.dpToPx(27.4f);
        }
        return ViewUtils.dpToPx(30.0f);
    }

    private int q() {
        if (!GlobalDisplayMetricsManager.needAdjustDensity(getContext()) && QQTheme.isNowSimpleUI()) {
            return ViewUtils.dpToPx(21.4f);
        }
        return ViewUtils.dpToPx(24.0f);
    }

    private void s() {
        int p16;
        setFocusable(true);
        setClickable(true);
        d();
        f();
        g();
        TextView textView = new TextView(getContext());
        this.S = textView;
        textView.setId(R.id.jnk);
        this.S.setSingleLine(true);
        this.S.setGravity(8388627);
        this.S.setEllipsize(TextUtils.TruncateAt.END);
        this.S.setTextSize(2, 14.0f);
        B();
        this.S.setDuplicateParentStateEnabled(true);
        if (!TextUtils.isEmpty(this.H)) {
            this.S.setText(this.H);
            setContentDescription(this.H);
        }
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -1);
        if (this.I != null) {
            p16 = q();
        } else {
            p16 = p();
        }
        layoutParams.leftMargin = p16;
        layoutParams.addRule(15);
        layoutParams.addRule(1, R.id.jnj);
        layoutParams.addRule(0, R.id.jnl);
        addView(this.S, layoutParams);
        setAvatar(this.J, this.I, this.K);
        this.W = v();
        this.V = w();
        this.U = u();
        if (!TextUtils.isEmpty(this.L)) {
            b();
        } else if (this.N) {
            c();
        } else {
            a();
        }
        TextView textView2 = new TextView(getContext());
        this.T = textView2;
        textView2.setClickable(true);
        this.T.setId(R.id.f97995lw);
        this.T.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.qui_common_text_link_selector));
        if (!TextUtils.isEmpty(this.M)) {
            e();
        }
        this.f200233c0 = new View(getContext());
        x();
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, 1);
        layoutParams2.addRule(12);
        addView(this.f200233c0, layoutParams2);
        setBackgroundDrawable(j(this.f200234d));
        A();
    }

    private boolean t(int i3) {
        if (i3 == 1 || i3 == 2 || i3 == 3 || i3 == 4 || i3 == 5) {
            return true;
        }
        return false;
    }

    private ImageView u() {
        ImageView imageView = new ImageView(getContext());
        imageView.setImageDrawable(h());
        imageView.setImportantForAccessibility(2);
        return imageView;
    }

    private Button v() {
        Resources resources = getResources();
        Button button = new Button(getContext());
        button.setText(this.L);
        button.setContentDescription(this.L);
        button.setTextSize(2, 14.0f);
        button.setTextColor(l(resources, this.f200234d));
        button.setMinWidth((int) ((this.f200231a0 * 48.0f) + 0.5d));
        button.setMinHeight((int) ((this.f200231a0 * 24.0f) + 0.5d));
        button.setSingleLine(true);
        button.setEllipsize(TextUtils.TruncateAt.END);
        button.setGravity(17);
        button.setBackgroundDrawable(k(resources));
        int i3 = (int) ((this.f200231a0 * 10.0f) + 0.5d);
        int i16 = i3 / 2;
        button.setPadding(i3, i16, i3, i16);
        button.setOnClickListener(this.f200232b0);
        return button;
    }

    private void x() {
        View view = this.f200233c0;
        if (view == null) {
            QLog.d("TipsBar", 1, "resetDividerBg, divider is null");
        } else {
            view.setBackgroundDrawable(AppCompatResources.getDrawable(getContext(), R.drawable.qui_common_border_standard_bg));
        }
    }

    private void y(int i3) {
        if (i3 != 1) {
            if (i3 != 2) {
                this.f200234d = 1;
                return;
            } else {
                this.f200234d = 2;
                this.I = ResourcesCompat.getDrawable(getResources(), R.drawable.qui_caution_filled_feedback_error, null);
                return;
            }
        }
        this.f200234d = 1;
        this.I = ResourcesCompat.getDrawable(getResources(), R.drawable.qui_info_filled_feedback_normal, null);
    }

    public void A() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        }
    }

    public void B() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        TextView textView = this.S;
        if (textView == null) {
            return;
        }
        if (this.f200234d == 2) {
            textView.setTextColor(AppCompatResources.getColorStateList(getContext(), R.color.f157970ah4));
        } else {
            textView.setTextColor(getResources().getColor(R.color.qui_common_text_secondary));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.W != null) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams.rightMargin = this.D;
            layoutParams.leftMargin = this.f200238i;
            this.W.setId(R.id.jnl);
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.W, layoutParams);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        ImageView imageView = this.V;
        if (imageView != null) {
            imageView.setId(R.id.jnl);
            int i3 = this.E;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(i3, i3);
            layoutParams.rightMargin = this.C;
            layoutParams.leftMargin = this.f200238i;
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            addView(this.V, layoutParams);
        }
    }

    protected Drawable h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return (Drawable) iPatchRedirector.redirect((short) 13, (Object) this);
        }
        return ResourcesCompat.getDrawable(getResources(), R.drawable.qui_chevron_right_icon_secondary_01, null);
    }

    public int i() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Integer) iPatchRedirector.redirect((short) 23, (Object) this)).intValue();
        }
        return this.f200234d;
    }

    protected Drawable j(int i3) {
        Drawable drawable;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (Drawable) iPatchRedirector.redirect((short) 12, (Object) this, i3);
        }
        int i16 = R.drawable.qui_common_fill_light_primary_bg_selector;
        if (i3 != 1) {
            if (i3 != 2) {
                int i17 = R.drawable.lur;
                if (i3 != 3) {
                    if (i3 != 4) {
                        if (i3 != 5) {
                            drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.f160540jm, null);
                        } else if (C()) {
                            drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.qui_common_fill_light_primary_bg_selector, null);
                        } else if (QQTheme.isNowThemeIsNight()) {
                            drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.jiu, null);
                        } else {
                            drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.f160540jm, null);
                        }
                    } else {
                        Resources resources = getResources();
                        if (!C()) {
                            i17 = R.drawable.lm9;
                        }
                        drawable = ResourcesCompat.getDrawable(resources, i17, null);
                    }
                } else {
                    Resources resources2 = getResources();
                    if (!C()) {
                        i17 = R.drawable.f160541jn;
                    }
                    drawable = ResourcesCompat.getDrawable(resources2, i17, null);
                }
            } else {
                drawable = ResourcesCompat.getDrawable(getResources(), R.drawable.f160565kf, null);
            }
        } else {
            if (!C()) {
                i16 = R.drawable.f160540jm;
            }
            drawable = ResourcesCompat.getDrawable(getResources(), i16, null);
        }
        return o(drawable);
    }

    public Drawable k(Resources resources) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (Drawable) iPatchRedirector.redirect((short) 10, (Object) this, (Object) resources);
        }
        return ResourcesCompat.getDrawable(resources, R.drawable.f160506il, null);
    }

    protected ColorStateList l(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 11, (Object) this, (Object) resources, i3);
        }
        return AppCompatResources.getColorStateList(getContext(), R.color.skin_color_button_common_white);
    }

    public Button m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 26)) {
            return (Button) iPatchRedirector.redirect((short) 26, (Object) this);
        }
        return this.W;
    }

    Drawable o(Drawable drawable) {
        Bitmap bitmap;
        boolean z16 = drawable instanceof SkinnableBitmapDrawable;
        if (!z16 && !(drawable instanceof BitmapDrawable)) {
            return drawable;
        }
        if (z16) {
            bitmap = ((SkinnableBitmapDrawable) drawable).getBitmap();
        } else {
            bitmap = ((BitmapDrawable) drawable).getBitmap();
        }
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
        } else {
            super.onMeasure(i3, View.MeasureSpec.makeMeasureSpec(this.f200235e, 1073741824));
            setMeasuredDimension(getMeasuredWidth(), this.f200235e);
        }
    }

    @Override // com.tencent.theme.SkinnableView
    public void onThemeChanged() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 31)) {
            iPatchRedirector.redirect((short) 31, (Object) this);
        } else {
            setBackgroundDrawable(j(this.f200234d));
        }
    }

    public ImageView r() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 25)) {
            return (ImageView) iPatchRedirector.redirect((short) 25, (Object) this);
        }
        return this.P;
    }

    public void setAvatar(Drawable drawable, Drawable drawable2, Drawable drawable3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, this, drawable, drawable2, drawable3);
            return;
        }
        if (drawable != null && drawable2 != null && drawable3 != null) {
            this.J = drawable;
            this.K = drawable3;
            this.Q.setVisibility(0);
            this.R.setVisibility(0);
            this.Q.setImageDrawable(this.J);
            this.R.setImageDrawable(this.K);
            setTipsIcon(drawable2);
            return;
        }
        if (drawable2 != null) {
            this.Q.setVisibility(8);
            this.R.setVisibility(8);
            setTipsIcon(drawable2);
        }
    }

    public void setBarType(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, i3);
            return;
        }
        if (t(i3)) {
            if (i3 == this.f200234d) {
                return;
            }
            this.f200234d = i3;
            B();
            Resources resources = getResources();
            setBackgroundDrawable(j(this.f200234d));
            if (this.U != null) {
                this.U.setImageDrawable(h());
            }
            if (this.V != null) {
                this.V.setImageDrawable(n());
            }
            Button button = this.W;
            if (button != null) {
                button.setTextColor(l(resources, this.f200234d));
                this.W.setBackgroundDrawable(k(resources));
            }
            x();
            return;
        }
        throw new RuntimeException("Parameter bgType is illegal!");
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
            this.W = v();
        }
        removeView(this.W);
        removeView(this.U);
        removeView(this.V);
        String charSequence2 = charSequence.toString();
        this.L = charSequence2;
        this.W.setText(charSequence2);
        b();
    }

    public void setCloseListener(View.OnClickListener onClickListener) {
        ImageView imageView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 30)) {
            iPatchRedirector.redirect((short) 30, (Object) this, (Object) onClickListener);
        } else if (onClickListener != null && (imageView = this.V) != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setLinkText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) charSequence);
            return;
        }
        String charSequence2 = charSequence.toString();
        this.M = charSequence2;
        if (TextUtils.isEmpty(charSequence2)) {
            return;
        }
        e();
    }

    public void setLinkTextVisible(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this, i3);
            return;
        }
        TextView textView = this.T;
        if (textView != null) {
            textView.setVisibility(i3);
        }
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        Button button;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) onClickListener);
            return;
        }
        this.f200232b0 = onClickListener;
        if (!TextUtils.isEmpty(this.L) && (button = this.W) != null) {
            button.setOnClickListener(this.f200232b0);
        } else {
            super.setOnClickListener(this.f200232b0);
        }
    }

    public void setOnLinkTextClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) onClickListener);
        } else {
            this.T.setOnClickListener(onClickListener);
        }
    }

    public void setOriginalOnClickListener(View.OnClickListener onClickListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) onClickListener);
        } else {
            super.setOnClickListener(onClickListener);
        }
    }

    public void setTipsIcon(Drawable drawable) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) drawable);
            return;
        }
        if (drawable == null) {
            return;
        }
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.S.getLayoutParams();
        layoutParams.leftMargin = q();
        this.S.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.P.getLayoutParams();
        layoutParams2.leftMargin = p();
        this.P.setLayoutParams(layoutParams2);
        this.P.setVisibility(0);
        x();
        this.P.setImageDrawable(drawable);
    }

    public void setTipsText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) charSequence);
            return;
        }
        String charSequence2 = charSequence.toString();
        this.H = charSequence2;
        this.S.setText(charSequence2);
        setContentDescription(this.H);
    }

    protected ImageView w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ImageView) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        ImageView imageView = new ImageView(getContext());
        imageView.setBackground(n());
        imageView.setOnClickListener(new a());
        imageView.setContentDescription(HardCodeUtil.qqStr(R.string.u6j));
        return imageView;
    }

    public void z(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 28)) {
            iPatchRedirector.redirect((short) 28, (Object) this, z16);
            return;
        }
        if (this.V == null) {
            this.V = w();
        }
        removeView(this.V);
        removeView(this.W);
        removeView(this.U);
        if (z16) {
            c();
        }
    }

    public TipsBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.f200235e = ScreenUtil.dip2px(48.0f);
        this.f200236f = ScreenUtil.dip2px(24.0f);
        this.f200237h = ScreenUtil.dip2px(24.0f);
        this.f200238i = ScreenUtil.dip2px(12.0f);
        this.f200239m = ScreenUtil.dip2px(11.5f);
        this.C = ScreenUtil.dip2px(13.0f);
        this.D = ScreenUtil.dip2px(16.0f);
        this.E = ScreenUtil.dip2px(16.0f);
        this.F = ScreenUtil.dip2px(16.0f);
        this.G = ScreenUtil.dip2px(16.0f);
        this.f200231a0 = getResources().getDisplayMetrics().density;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, jj2.b.P8);
        this.H = obtainStyledAttributes.getString(jj2.b.Y8);
        y(obtainStyledAttributes.getInt(jj2.b.Q8, 0));
        Drawable drawable = obtainStyledAttributes.getDrawable(jj2.b.V8);
        if (drawable != null) {
            this.I = drawable;
        }
        this.J = obtainStyledAttributes.getDrawable(jj2.b.W8);
        this.K = obtainStyledAttributes.getDrawable(jj2.b.X8);
        this.M = obtainStyledAttributes.getString(jj2.b.T8);
        this.L = obtainStyledAttributes.getString(jj2.b.S8);
        this.f200234d = obtainStyledAttributes.getInt(jj2.b.R8, this.f200234d);
        this.N = obtainStyledAttributes.getBoolean(jj2.b.U8, false);
        obtainStyledAttributes.recycle();
        s();
    }
}
