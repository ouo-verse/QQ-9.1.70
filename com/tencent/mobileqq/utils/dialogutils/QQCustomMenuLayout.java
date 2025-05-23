package com.tencent.mobileqq.utils.dialogutils;

import android.content.Context;
import android.content.res.Resources;
import android.text.Layout;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class QQCustomMenuLayout extends LinearLayout implements View.OnClickListener {
    private int C;
    private float D;
    private TextPaint E;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f307649d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f307650e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f307651f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f307652h;

    /* renamed from: i, reason: collision with root package name */
    private int f307653i;

    /* renamed from: m, reason: collision with root package name */
    private int f307654m;

    public QQCustomMenuLayout(Context context) {
        super(context);
        int i3;
        this.F = 0;
        Resources resources = context.getResources();
        this.C = resources.getDisplayMetrics().widthPixels;
        float f16 = resources.getDisplayMetrics().density;
        this.D = f16;
        this.C -= (int) (f16 * 10.0f);
        if (f16 >= 2.0f) {
            i3 = 20;
        } else {
            i3 = 12;
        }
        TextPaint textPaint = new TextPaint(1);
        this.E = textPaint;
        textPaint.density = resources.getDisplayMetrics().density;
        this.E.setTextSize(TypedValue.applyDimension(2, 15.0f, resources.getDisplayMetrics()));
        ImageView imageView = new ImageView(context);
        this.f307649d = imageView;
        imageView.setVisibility(8);
        this.f307649d.setImageResource(R.drawable.cbf);
        this.f307649d.setContentDescription(HardCodeUtil.qqStr(R.string.qo7));
        this.f307649d.setBackgroundDrawable(null);
        this.f307649d.setOnClickListener(this);
        ImageView imageView2 = this.f307649d;
        float f17 = i3;
        float f18 = this.D;
        imageView2.setPadding((int) (f17 * f18), (int) (f18 * 10.0f), (int) (f17 * f18), (int) (f18 * 10.0f));
        this.f307649d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f307649d, 0);
        ImageView imageView3 = new ImageView(context);
        this.f307651f = imageView3;
        imageView3.setBackgroundResource(R.drawable.f160388cb0);
        this.f307651f.setContentDescription("leftIcon");
        this.f307651f.setVisibility(8);
        this.f307651f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f307651f, 1);
        ImageView imageView4 = new ImageView(context);
        this.f307652h = imageView4;
        imageView4.setBackgroundResource(R.drawable.f160388cb0);
        this.f307652h.setContentDescription("rightIcon");
        this.f307652h.setVisibility(8);
        this.f307652h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f307652h, 2);
        ImageView imageView5 = new ImageView(context);
        this.f307650e = imageView5;
        imageView5.setVisibility(8);
        this.f307650e.setImageResource(R.drawable.cbk);
        this.f307650e.setContentDescription(HardCodeUtil.qqStr(R.string.qnt));
        this.f307650e.setBackgroundDrawable(null);
        this.f307650e.setOnClickListener(this);
        ImageView imageView6 = this.f307650e;
        float f19 = this.D;
        imageView6.setPadding((int) (f17 * f19), (int) (f19 * 10.0f), (int) (f17 * f19), (int) (f19 * 10.0f));
        this.f307650e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f307650e, 3);
    }

    private void b() {
        if (this.f307653i > 3) {
            ImageView imageView = this.f307649d;
            if (imageView != null && imageView.getVisibility() != 0) {
                this.f307649d.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.f307649d;
            if (imageView2 != null && imageView2.getVisibility() != 8) {
                this.f307649d.setVisibility(8);
            }
        }
        if (this.f307654m < getChildCount() - 4) {
            ImageView imageView3 = this.f307650e;
            if (imageView3 != null && imageView3.getVisibility() != 0) {
                this.f307650e.setVisibility(0);
            }
        } else {
            ImageView imageView4 = this.f307650e;
            if (imageView4 != null && imageView4.getVisibility() != 8) {
                this.f307650e.setVisibility(8);
            }
        }
        ImageView imageView5 = this.f307651f;
        if (imageView5 != null && this.f307649d != null && imageView5.getVisibility() != this.f307649d.getVisibility()) {
            this.f307651f.setVisibility(this.f307649d.getVisibility());
        }
        ImageView imageView6 = this.f307652h;
        if (imageView6 != null && this.f307650e != null && imageView6.getVisibility() != this.f307650e.getVisibility()) {
            this.f307652h.setVisibility(this.f307650e.getVisibility());
        }
    }

    private int d() {
        int i3;
        int childCount = getChildCount();
        onMeasure(0, 0);
        int i16 = 0;
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt = getChildAt(i17);
            if (childAt != null && childAt.getVisibility() != 8) {
                if (childAt instanceof TextView) {
                    TextView textView = (TextView) childAt;
                    int desiredWidth = (int) Layout.getDesiredWidth(textView.getText(), this.E);
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QQCustomMenuLayout", 4, "child  TextView text " + ((Object) textView.getText()) + " measureWidth = " + desiredWidth + " padding = " + childAt.getPaddingLeft());
                    }
                    i3 = i16 + desiredWidth + this.F;
                } else {
                    int measuredWidth = childAt.getMeasuredWidth();
                    i3 = i16 + measuredWidth;
                    if (QLog.isDevelopLevel()) {
                        QLog.d("QQCustomMenuLayout", 4, "child  nonTextView measureWidth = " + measuredWidth);
                    }
                }
                i16 = i3 + childAt.getPaddingLeft() + childAt.getPaddingRight();
            }
        }
        return i16;
    }

    public void a(int i3, int i16) {
        for (int i17 = 2; i17 < getChildCount() - 2; i17++) {
            if (i17 >= i3 && i17 <= i16) {
                getChildAt(i17).setVisibility(0);
            } else {
                getChildAt(i17).setVisibility(8);
            }
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        super.addView(view, getChildCount() - 2);
    }

    public void c() {
        int i3 = -1;
        while (true) {
            int d16 = d();
            if (QLog.isDevelopLevel()) {
                QLog.d("QQCustomMenuLayout", 4, "totalWidth = " + d16 + " startPosition = " + this.f307653i + " endPosition = " + this.f307654m);
            }
            int i16 = this.C;
            if (d16 > i16 && i3 != d16) {
                setMinimumWidth(i16);
                if (this.G) {
                    this.f307654m -= 2;
                } else if (this.H) {
                    this.f307653i += 2;
                } else {
                    this.f307654m -= 2;
                }
                if (this.f307654m < 0) {
                    this.f307654m = 0;
                }
                int i17 = this.f307653i;
                int i18 = this.f307654m;
                if (i17 > i18) {
                    this.f307653i = i18;
                }
                a(this.f307653i, i18);
                b();
                i3 = d16;
            }
        }
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (view == this.f307649d) {
            int i3 = this.f307653i;
            if (i3 > 3) {
                this.G = false;
                this.H = true;
                int i16 = i3 - 2;
                this.f307654m = i16;
                this.f307653i = 2;
                if (2 > i16) {
                    this.f307653i = i16;
                }
                a(this.f307653i, i16);
                this.f307650e.setVisibility(0);
                this.f307652h.setVisibility(0);
                this.f307649d.setVisibility(8);
                this.f307651f.setVisibility(8);
                c();
                this.H = false;
            }
        } else if (this.f307653i < getChildCount() - 4) {
            this.H = false;
            this.G = true;
            this.f307653i = this.f307654m + 2;
            int childCount = getChildCount() - 3;
            this.f307654m = childCount;
            if (this.f307653i > childCount) {
                this.f307653i = childCount;
            }
            a(this.f307653i, childCount);
            this.f307649d.setVisibility(0);
            this.f307651f.setVisibility(0);
            this.f307650e.setVisibility(8);
            this.f307652h.setVisibility(8);
            c();
            this.G = false;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        view.setLayoutParams(layoutParams);
        addView(view);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        if (generateDefaultLayoutParams == null) {
            return;
        }
        generateDefaultLayoutParams.width = i3;
        generateDefaultLayoutParams.height = i16;
        addView(view, generateDefaultLayoutParams);
    }
}
