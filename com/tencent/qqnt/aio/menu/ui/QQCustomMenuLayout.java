package com.tencent.qqnt.aio.menu.ui;

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
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes23.dex */
public class QQCustomMenuLayout extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private int C;
    private float D;
    private TextPaint E;
    private int F;
    private boolean G;
    private boolean H;

    /* renamed from: d, reason: collision with root package name */
    private ImageView f351537d;

    /* renamed from: e, reason: collision with root package name */
    private ImageView f351538e;

    /* renamed from: f, reason: collision with root package name */
    private ImageView f351539f;

    /* renamed from: h, reason: collision with root package name */
    private ImageView f351540h;

    /* renamed from: i, reason: collision with root package name */
    private int f351541i;

    /* renamed from: m, reason: collision with root package name */
    private int f351542m;

    public QQCustomMenuLayout(Context context) {
        super(context);
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
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
        this.f351537d = imageView;
        imageView.setVisibility(8);
        this.f351537d.setImageResource(R.drawable.cbf);
        this.f351537d.setContentDescription(HardCodeUtil.qqStr(R.string.qo7));
        this.f351537d.setBackgroundDrawable(null);
        this.f351537d.setOnClickListener(this);
        ImageView imageView2 = this.f351537d;
        float f17 = i3;
        float f18 = this.D;
        imageView2.setPadding((int) (f17 * f18), (int) (f18 * 10.0f), (int) (f17 * f18), (int) (f18 * 10.0f));
        this.f351537d.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f351537d, 0);
        ImageView imageView3 = new ImageView(context);
        this.f351539f = imageView3;
        imageView3.setBackgroundResource(R.drawable.f160388cb0);
        this.f351539f.setContentDescription("leftIcon");
        this.f351539f.setVisibility(8);
        this.f351539f.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f351539f, 1);
        ImageView imageView4 = new ImageView(context);
        this.f351540h = imageView4;
        imageView4.setBackgroundResource(R.drawable.f160388cb0);
        this.f351540h.setContentDescription("rightIcon");
        this.f351540h.setVisibility(8);
        this.f351540h.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f351540h, 2);
        ImageView imageView5 = new ImageView(context);
        this.f351538e = imageView5;
        imageView5.setVisibility(8);
        this.f351538e.setImageResource(R.drawable.cbk);
        this.f351538e.setContentDescription(HardCodeUtil.qqStr(R.string.qnt));
        this.f351538e.setBackgroundDrawable(null);
        this.f351538e.setOnClickListener(this);
        ImageView imageView6 = this.f351538e;
        float f19 = this.D;
        imageView6.setPadding((int) (f17 * f19), (int) (f19 * 10.0f), (int) (f17 * f19), (int) (f19 * 10.0f));
        this.f351538e.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
        addView(this.f351538e, 3);
    }

    private void b() {
        if (this.f351541i > 3) {
            ImageView imageView = this.f351537d;
            if (imageView != null && imageView.getVisibility() != 0) {
                this.f351537d.setVisibility(0);
            }
        } else {
            ImageView imageView2 = this.f351537d;
            if (imageView2 != null && imageView2.getVisibility() != 8) {
                this.f351537d.setVisibility(8);
            }
        }
        if (this.f351542m < getChildCount() - 4) {
            ImageView imageView3 = this.f351538e;
            if (imageView3 != null && imageView3.getVisibility() != 0) {
                this.f351538e.setVisibility(0);
            }
        } else {
            ImageView imageView4 = this.f351538e;
            if (imageView4 != null && imageView4.getVisibility() != 8) {
                this.f351538e.setVisibility(8);
            }
        }
        ImageView imageView5 = this.f351539f;
        if (imageView5 != null && this.f351537d != null && imageView5.getVisibility() != this.f351537d.getVisibility()) {
            this.f351539f.setVisibility(this.f351537d.getVisibility());
        }
        ImageView imageView6 = this.f351540h;
        if (imageView6 != null && this.f351538e != null && imageView6.getVisibility() != this.f351538e.getVisibility()) {
            this.f351540h.setVisibility(this.f351538e.getVisibility());
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            super.addView(view, getChildCount() - 2);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) view);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        int i3 = -1;
        while (true) {
            int d16 = d();
            if (QLog.isDevelopLevel()) {
                QLog.d("QQCustomMenuLayout", 4, "totalWidth = " + d16 + " startPosition = " + this.f351541i + " endPosition = " + this.f351542m);
            }
            int i16 = this.C;
            if (d16 > i16 && i3 != d16) {
                setMinimumWidth(i16);
                if (this.G) {
                    this.f351542m -= 2;
                } else if (this.H) {
                    this.f351541i += 2;
                } else {
                    this.f351542m -= 2;
                }
                if (this.f351542m < 0) {
                    this.f351542m = 0;
                }
                int i17 = this.f351541i;
                int i18 = this.f351542m;
                if (i17 > i18) {
                    this.f351541i = i18;
                }
                a(this.f351541i, i18);
                b();
                i3 = d16;
            }
        }
        b();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) view);
        } else if (view == this.f351537d) {
            int i3 = this.f351541i;
            if (i3 > 3) {
                this.G = false;
                this.H = true;
                int i16 = i3 - 2;
                this.f351542m = i16;
                this.f351541i = 2;
                if (2 > i16) {
                    this.f351541i = i16;
                }
                a(this.f351541i, i16);
                this.f351538e.setVisibility(0);
                this.f351540h.setVisibility(0);
                this.f351537d.setVisibility(8);
                this.f351539f.setVisibility(8);
                c();
                this.H = false;
            }
        } else if (this.f351541i < getChildCount() - 4) {
            this.H = false;
            this.G = true;
            this.f351541i = this.f351542m + 2;
            int childCount = getChildCount() - 3;
            this.f351542m = childCount;
            if (this.f351541i > childCount) {
                this.f351541i = childCount;
            }
            a(this.f351541i, childCount);
            this.f351537d.setVisibility(0);
            this.f351539f.setVisibility(0);
            this.f351538e.setVisibility(8);
            this.f351540h.setVisibility(8);
            c();
            this.G = false;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void addView(View view, ViewGroup.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view, (Object) layoutParams);
        } else {
            view.setLayoutParams(layoutParams);
            addView(view);
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, view, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        LinearLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        if (generateDefaultLayoutParams == null) {
            return;
        }
        generateDefaultLayoutParams.width = i3;
        generateDefaultLayoutParams.height = i16;
        addView(view, generateDefaultLayoutParams);
    }
}
