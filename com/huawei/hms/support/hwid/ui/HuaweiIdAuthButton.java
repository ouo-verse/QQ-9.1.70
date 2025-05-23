package com.huawei.hms.support.hwid.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.tencent.mobileqq.R;

/* compiled from: P */
/* loaded from: classes2.dex */
public class HuaweiIdAuthButton extends RelativeLayout {
    public static final int COLOR_POLICY_BLACK = 3;
    public static final int COLOR_POLICY_GRAY = 4;
    public static final int COLOR_POLICY_RED = 0;
    public static final int COLOR_POLICY_WHITE = 1;
    public static final int COLOR_POLICY_WHITE_WITH_BORDER = 2;
    public static final int CORNER_RADIUS_LARGE = -1;
    public static final int CORNER_RADIUS_MEDIUM = -2;
    public static final int CORNER_RADIUS_SMALL = -3;
    public static final int THEME_FULL_TITLE = 1;
    public static final int THEME_NO_TITLE = 0;

    /* renamed from: a, reason: collision with root package name */
    private static final PorterDuffColorFilter f37620a = new PorterDuffColorFilter(218103808, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: b, reason: collision with root package name */
    private static final PorterDuffColorFilter f37621b = new PorterDuffColorFilter(436207616, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: c, reason: collision with root package name */
    private static final PorterDuffColorFilter f37622c = new PorterDuffColorFilter(872415231, PorterDuff.Mode.SRC_ATOP);

    /* renamed from: d, reason: collision with root package name */
    private int f37623d;

    /* renamed from: e, reason: collision with root package name */
    private int f37624e;

    /* renamed from: f, reason: collision with root package name */
    private int f37625f;

    /* renamed from: g, reason: collision with root package name */
    private GradientDrawable f37626g;

    /* renamed from: h, reason: collision with root package name */
    private Button f37627h;

    /* renamed from: i, reason: collision with root package name */
    private ImageView f37628i;

    /* renamed from: j, reason: collision with root package name */
    private LinearLayout f37629j;

    public HuaweiIdAuthButton(Context context) {
        super(context);
        a((AttributeSet) null);
    }

    private void a(AttributeSet attributeSet) {
        GradientDrawable gradientDrawable = (GradientDrawable) getResources().getDrawable(R.drawable.jsv);
        this.f37626g = gradientDrawable;
        setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(getContext());
        this.f37629j = linearLayout;
        int i3 = 0;
        linearLayout.setOrientation(0);
        this.f37629j.setGravity(17);
        b();
        a();
        addView(this.f37629j);
        int a16 = a(8.0f);
        int i16 = 1;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.huawei.android.hms.hwid.R.styleable.HuaweiIdAuthButton);
            i16 = obtainStyledAttributes.getInt(com.huawei.android.hms.hwid.R.styleable.HuaweiIdAuthButton_hwid_button_theme, 1);
            i3 = obtainStyledAttributes.getInt(com.huawei.android.hms.hwid.R.styleable.HuaweiIdAuthButton_hwid_color_policy, 0);
            a16 = obtainStyledAttributes.getLayoutDimension(com.huawei.android.hms.hwid.R.styleable.HuaweiIdAuthButton_hwid_corner_radius, a(8.0f));
            obtainStyledAttributes.recycle();
        }
        setLayoutParams(generateDefaultLayoutParams());
        setUIMode(i16, i3, a16);
    }

    private void b() {
        if (this.f37627h == null) {
            this.f37627h = new Button(getContext());
        }
        this.f37627h.setStateListAnimator(null);
        this.f37627h.setBackground(null);
        int intrinsicWidth = a(R.drawable.oiv).getIntrinsicWidth();
        int a16 = a(8.0f);
        this.f37627h.setCompoundDrawablePadding(a16);
        a(intrinsicWidth, a16);
        this.f37627h.setLayoutParams(new ViewGroup.LayoutParams(-2, a(36.0f)));
        this.f37629j.addView(this.f37627h);
    }

    private void setBackgroundCornerRadius(int i3) {
        this.f37626g.mutate();
        this.f37626g.setCornerRadius(i3);
    }

    private void setBackgroundDrawableColor(int i3) {
        this.f37626g.mutate();
        this.f37626g.setColor(getResources().getColor(i3));
    }

    public int getColorPolicy() {
        return this.f37624e;
    }

    public int getCornerRadius() {
        return this.f37625f;
    }

    public int getTheme() {
        return this.f37623d;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x001e, code lost:
    
        if (r0 != 4) goto L26;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean onTouchEvent(MotionEvent motionEvent) {
        GradientDrawable gradientDrawable;
        if (motionEvent.getAction() == 0) {
            if (this.f37626g != null && isEnabled()) {
                int i3 = this.f37624e;
                if (i3 != 0) {
                    if (i3 != 1 && i3 != 2) {
                        if (i3 == 3) {
                            this.f37626g.setColorFilter(f37622c);
                        }
                    }
                    this.f37626g.setColorFilter(f37620a);
                } else {
                    this.f37626g.setColorFilter(f37621b);
                }
            }
        } else if (1 == motionEvent.getAction() && (gradientDrawable = this.f37626g) != null) {
            gradientDrawable.clearColorFilter();
        }
        if (!hasOnClickListeners()) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setColorPolicy(int i3) {
        if (i3 != 0) {
            if (i3 != 1) {
                if (i3 != 2) {
                    if (i3 != 3) {
                        if (i3 == 4) {
                            a(i3, R.color.bv_, R.color.bvb, R.drawable.oir);
                            return;
                        }
                        return;
                    } else {
                        a(i3, R.color.bv8, R.color.bvc, R.drawable.oiv);
                        this.f37628i.setImageDrawable(getResources().getDrawable(R.drawable.oiu));
                        return;
                    }
                }
                a(i3, R.color.bvd, R.color.bvb, R.drawable.oir);
                if (this.f37623d == 1) {
                    b(a(1.0f), getResources().getColor(R.color.bv9));
                    return;
                }
                return;
            }
            a(i3, R.color.bvd, R.color.bvb, R.drawable.oir);
            this.f37628i.setImageDrawable(getResources().getDrawable(R.drawable.oit));
            return;
        }
        a(i3, R.color.bva, R.color.bvc, R.drawable.oiv);
        this.f37628i.setImageDrawable(getResources().getDrawable(R.drawable.oiu));
    }

    public void setCornerRadius(int i3) {
        if (i3 != -3) {
            if (i3 != -2) {
                if (i3 == -1) {
                    i3 = a(24.0f);
                }
            } else {
                i3 = a(8.0f);
            }
        } else {
            i3 = a(3.0f);
        }
        if (i3 < 0) {
            return;
        }
        this.f37625f = i3;
        setBackgroundCornerRadius(i3);
    }

    @Override // android.view.View
    public void setEnabled(boolean z16) {
        super.setEnabled(z16);
        if (!z16) {
            setAlpha(0.38f);
        } else {
            setAlpha(1.0f);
        }
    }

    public void setTheme(int i3) {
        if (i3 != 0) {
            if (i3 == 1) {
                this.f37623d = i3;
                this.f37628i.setVisibility(8);
                this.f37627h.setVisibility(0);
                setMinimumWidth(a(200.0f));
                setMinimumHeight(a(36.0f));
                this.f37629j.setMinimumWidth(a(200.0f));
                this.f37629j.setMinimumHeight(a(36.0f));
                return;
            }
            return;
        }
        this.f37623d = i3;
        this.f37628i.setVisibility(0);
        this.f37627h.setVisibility(8);
        setMinimumWidth(a(48.0f));
        setMinimumHeight(a(48.0f));
        this.f37629j.setMinimumWidth(a(48.0f));
        this.f37629j.setMinimumHeight(a(48.0f));
    }

    public void setUIMode(int i3, int i16, int i17) {
        setTheme(i3);
        setColorPolicy(i16);
        setCornerRadius(i17);
    }

    public HuaweiIdAuthButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public HuaweiIdAuthButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        a(attributeSet);
    }

    private void b(int i3, int i16) {
        this.f37626g.mutate();
        this.f37626g.setStroke(i3, i16);
    }

    private void a() {
        if (this.f37628i == null) {
            this.f37628i = new ImageView(getContext());
        }
        this.f37628i.setImageDrawable(getResources().getDrawable(R.drawable.oit));
        setBackgroundDrawableColor(R.color.bvd);
        this.f37629j.addView(this.f37628i);
    }

    private void a(int i3, int i16) {
        this.f37627h.setTextSize(16.0f);
        this.f37627h.setText(getResources().getText(R.string.f159321s0));
        this.f37627h.setSingleLine();
        int i17 = getResources().getDisplayMetrics().widthPixels;
        int a16 = a(16.0f);
        int i18 = a16 + a16;
        int i19 = i17 - i18;
        this.f37627h.setMaxWidth(i19);
        float measureText = this.f37627h.getPaint().measureText(this.f37627h.getText().toString());
        while (((int) measureText) + i3 + i16 + i18 > i19 && this.f37627h.getTextSize() > a(9.0f)) {
            Button button = this.f37627h;
            button.setTextSize(0, button.getTextSize() - 1.0f);
            measureText = this.f37627h.getPaint().measureText(this.f37627h.getText().toString());
        }
        this.f37627h.setEllipsize(TextUtils.TruncateAt.END);
        this.f37627h.setPadding(a16, 0, a16, 0);
    }

    private Drawable a(int i3) {
        Drawable drawable = getResources().getDrawable(i3);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        this.f37627h.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        return drawable;
    }

    private void a(int i3, int i16, int i17, int i18) {
        this.f37624e = i3;
        if (this.f37623d != 1 && i3 != 0 && i3 != 3 && i3 != 1) {
            setBackgroundDrawableColor(R.color.bvd);
            this.f37628i.setImageDrawable(getResources().getDrawable(R.drawable.oit));
        } else {
            setBackgroundDrawableColor(i16);
        }
        b(0, 0);
        this.f37627h.setTextColor(getResources().getColor(i17));
        a(i18);
    }

    private int a(float f16) {
        return (int) ((f16 * getResources().getDisplayMetrics().density) + 0.5f);
    }
}
