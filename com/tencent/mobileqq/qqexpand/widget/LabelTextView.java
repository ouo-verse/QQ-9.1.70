package com.tencent.mobileqq.qqexpand.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;
import com.tencent.widget.ThemeImageWrapper;

/* compiled from: P */
/* loaded from: classes16.dex */
public class LabelTextView extends TextView implements ThemeImageWrapper.DrawInterface {

    /* renamed from: d, reason: collision with root package name */
    protected ThemeImageWrapper f264157d;

    /* renamed from: e, reason: collision with root package name */
    private int f264158e;

    /* renamed from: f, reason: collision with root package name */
    private boolean f264159f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f264160h;

    public LabelTextView(Context context) {
        super(context);
        this.f264158e = Integer.MAX_VALUE;
        this.f264159f = false;
        this.f264160h = false;
        a();
    }

    private void a() {
        setMaxLines(1);
        setGravity(17);
        setSingleLine();
        setEllipsize(TextUtils.TruncateAt.END);
        b();
    }

    private void b() {
        ThemeImageWrapper themeImageWrapper = new ThemeImageWrapper();
        this.f264157d = themeImageWrapper;
        themeImageWrapper.setSupportMaskView(true);
        this.f264157d.setMaskShape(ThemeImageWrapper.MODE_OTHER);
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        ThemeImageWrapper themeImageWrapper;
        if (this.f264160h && (themeImageWrapper = this.f264157d) != null) {
            themeImageWrapper.onDraw(canvas, this);
        } else {
            super.draw(canvas);
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (this.f264159f) {
            if (getMeasuredWidth() < this.f264158e) {
                if (getVisibility() == 0) {
                    setVisibility(8);
                }
            } else if (getVisibility() != 0) {
                setVisibility(0);
            }
        }
    }

    public void setMinWidthCheck(int i3) {
        boolean z16;
        this.f264158e = i3;
        if (i3 > 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        this.f264159f = z16;
    }

    public void setParam(int i3, int i16, float f16) {
        setTextColor(i16);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i3);
        gradientDrawable.setCornerRadius(f16);
        setBackgroundDrawable(gradientDrawable);
    }

    @Override // com.tencent.widget.ThemeImageWrapper.DrawInterface
    public void superOnDraw(Canvas canvas) {
        super.draw(canvas);
    }

    public LabelTextView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f264158e = Integer.MAX_VALUE;
        this.f264159f = false;
        this.f264160h = false;
        a();
    }

    public LabelTextView(Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f264158e = Integer.MAX_VALUE;
        this.f264159f = false;
        this.f264160h = false;
        a();
    }
}
