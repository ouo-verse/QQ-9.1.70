package com.tencent.mobileqq.settings.message;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.widget.FormItemConstants;

/* compiled from: P */
/* loaded from: classes18.dex */
public class SimpleFormSimpleItem extends RelativeLayout implements FormItemConstants {
    static IPatchRedirector $redirector_;
    protected static boolean I;
    private boolean C;
    protected TextView D;
    protected TextView E;
    private int F;
    private final Rect G;
    private final Paint H;

    /* renamed from: d, reason: collision with root package name */
    private CharSequence f286995d;

    /* renamed from: e, reason: collision with root package name */
    private int f286996e;

    /* renamed from: f, reason: collision with root package name */
    protected CharSequence f286997f;

    /* renamed from: h, reason: collision with root package name */
    protected int f286998h;

    /* renamed from: i, reason: collision with root package name */
    protected Drawable f286999i;

    /* renamed from: m, reason: collision with root package name */
    private int f287000m;

    public SimpleFormSimpleItem(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private boolean d() {
        if (!"1000".equals(ThemeUtil.curThemeId) && !"999".equals(ThemeUtil.curThemeId)) {
            return false;
        }
        return true;
    }

    protected ColorStateList a(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ColorStateList) iPatchRedirector.redirect((short) 4, (Object) this, (Object) resources, i3);
        }
        return com.tencent.mobileqq.widget.o.a(resources, i3);
    }

    protected Drawable b(Resources resources, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (Drawable) iPatchRedirector.redirect((short) 5, (Object) this, (Object) resources, i3);
        }
        return com.tencent.mobileqq.widget.o.h(resources, i3, I, this.C);
    }

    protected void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        setFocusable(true);
        setClickable(true);
        this.D = new TextView(getContext());
        if (!TextUtils.isEmpty(this.f286995d)) {
            this.D.setText(this.f286995d);
            this.D.setContentDescription(this.f286995d);
        }
        this.D.setId(R.id.cjm);
        this.D.setTextColor(a(getResources(), this.f286996e));
        this.D.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158563j1));
        this.D.setGravity(19);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.leftMargin = this.F;
        layoutParams.addRule(9);
        layoutParams.addRule(15);
        addView(this.D, layoutParams);
        this.E = new TextView(getContext());
        if (!TextUtils.isEmpty(this.f286997f)) {
            this.E.setText(this.f286997f);
            this.E.setContentDescription(this.f286997f);
        }
        this.E.setId(R.id.cjn);
        this.E.setTextColor(a(getResources(), this.f286998h));
        this.E.setTextSize(0, getContext().getResources().getDimensionPixelSize(R.dimen.f158570j9));
        this.E.setGravity(19);
        this.E.setEllipsize(TextUtils.TruncateAt.END);
        this.E.setDuplicateParentStateEnabled(true);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = this.F;
        layoutParams2.addRule(11);
        layoutParams2.addRule(15);
        addView(this.E, layoutParams2);
        e();
        setBackgroundDrawable(b(getResources(), this.f287000m));
    }

    protected void e() {
        int intrinsicWidth;
        int intrinsicHeight;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (this.E == null) {
            return;
        }
        if (d()) {
            intrinsicWidth = FormItemConstants.WIDTH_DEFAULT_ARROW;
            intrinsicHeight = FormItemConstants.HEIGHT_DEFAULT_ARROW;
        } else {
            intrinsicWidth = this.f286999i.getIntrinsicWidth();
            intrinsicHeight = this.f286999i.getIntrinsicHeight();
        }
        if (!TextUtils.isEmpty(this.f286997f)) {
            this.E.setVisibility(0);
            this.E.setText(this.f286997f);
            this.E.setTextColor(a(getResources(), this.f286998h));
            this.E.setContentDescription(this.f286997f);
            if (d()) {
                this.f286999i.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
                this.E.setCompoundDrawables(null, null, this.f286999i, null);
            } else {
                this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f286999i, (Drawable) null);
            }
            this.E.setCompoundDrawablePadding(8);
            return;
        }
        this.E.setText("");
        this.E.setVisibility(0);
        if (d()) {
            this.f286999i.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.E.setCompoundDrawables(null, null, this.f286999i, null);
        } else {
            this.E.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, this.f286999i, (Drawable) null);
        }
        this.E.setCompoundDrawablePadding(0);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
            return;
        }
        if (com.tencent.mobileqq.widget.o.l() && this.C) {
            return;
        }
        int i3 = this.f287000m;
        if (i3 == 1 || i3 == 2) {
            if (d()) {
                this.H.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
            } else {
                this.H.setColor(0);
            }
            int measuredWidth = getMeasuredWidth();
            int measuredHeight = getMeasuredHeight();
            this.G.set(FormItemConstants.PADDING_DEFAULT_BG_DIVIDER, measuredHeight - FormItemConstants.HEIGHT_DEFAULT_BG_DIVIDER, measuredWidth, measuredHeight);
            canvas.drawRect(this.G, this.H);
        }
    }

    public void setLeftText(CharSequence charSequence) {
        TextView textView;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) charSequence);
            return;
        }
        if (!TextUtils.isEmpty(charSequence) && (textView = this.D) != null) {
            this.f286995d = charSequence;
            textView.setText(charSequence);
            this.D.setTextColor(a(getResources(), this.f286996e));
            this.D.setContentDescription(this.f286995d);
        }
    }

    public void setRightText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) charSequence);
        } else {
            this.f286997f = charSequence;
            e();
        }
    }

    public void setUseCardUIStyle(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.C = z16;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x008d, code lost:
    
        if (r1 != null) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public SimpleFormSimpleItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
            return;
        }
        this.G = new Rect();
        this.H = new Paint();
        getResources().getDimensionPixelSize(R.dimen.f158564j2);
        this.f286999i = getResources().getDrawable(R.drawable.common_arrow_right_selector);
        TypedArray typedArray = null;
        try {
            typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.FormItem);
            this.F = typedArray.getDimensionPixelSize(R.styleable.FormItem_customPadding, getResources().getDimensionPixelSize(R.dimen.aes));
            this.f286995d = typedArray.getString(R.styleable.FormItem_leftText);
            this.f286996e = typedArray.getInt(R.styleable.FormItem_leftTextColor, 0);
            this.f286997f = typedArray.getString(R.styleable.FormItem_rightText);
            this.f286998h = typedArray.getInt(R.styleable.FormItem_rightTextColor, 3);
            this.f287000m = typedArray.getInt(R.styleable.FormItem_bgType, 0);
            I = typedArray.getBoolean(R.styleable.FormItem_needFocusBg, true);
            this.C = typedArray.getBoolean(u51.a.Z, true);
        } catch (Throwable unused) {
        }
        typedArray.recycle();
        this.H.setAntiAlias(true);
        this.H.setColor(FormItemConstants.COLOR_DEFAULT_BG_DIVIDER);
        c();
    }
}
