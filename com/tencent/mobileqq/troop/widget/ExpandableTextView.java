package com.tencent.mobileqq.troop.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qq.minibox.api.data.MiniBoxNoticeInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes19.dex */
public class ExpandableTextView extends LinearLayout implements View.OnClickListener {
    static IPatchRedirector $redirector_;
    private static float N;
    private int C;
    private int D;
    private int E;
    private String F;
    private String G;
    private int H;
    private float I;
    private boolean J;
    private b K;
    private SparseBooleanArray L;
    private int M;

    /* renamed from: d, reason: collision with root package name */
    protected TextView f302297d;

    /* renamed from: e, reason: collision with root package name */
    protected TextView f302298e;

    /* renamed from: f, reason: collision with root package name */
    private CharSequence f302299f;

    /* renamed from: h, reason: collision with root package name */
    private boolean f302300h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f302301i;

    /* renamed from: m, reason: collision with root package name */
    private int f302302m;

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public interface a {
    }

    /* compiled from: P */
    /* loaded from: classes19.dex */
    public static class b implements ViewTreeObserver.OnGlobalLayoutListener {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private TextView f302303d;

        /* renamed from: e, reason: collision with root package name */
        private int f302304e;

        public b(TextView textView, int i3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) textView, i3);
                return;
            }
            this.f302303d = textView;
            this.f302304e = i3;
            textView.setMaxLines(i3 + 1);
            this.f302303d.setSingleLine(false);
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            CharSequence text;
            String str;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (this.f302303d.getLineCount() > this.f302304e) {
                try {
                    text = this.f302303d.getText().subSequence(0, this.f302303d.getLayout().getLineEnd(this.f302304e - 1) - 3);
                    str = MiniBoxNoticeInfo.APPNAME_SUFFIX;
                } catch (Exception unused) {
                    text = this.f302303d.getText();
                    str = "";
                }
                this.f302303d.setText(text);
                this.f302303d.append(str);
            }
            this.f302303d.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(65196);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 14)) {
            redirector.redirect((short) 14);
        } else {
            N = 0.7f;
        }
    }

    public ExpandableTextView(Context context) {
        this(context, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
    }

    private void b() {
        String str;
        TextView textView = (TextView) findViewById(R.id.bzm);
        this.f302297d = textView;
        textView.setEllipsize(TextUtils.TruncateAt.END);
        TextView textView2 = (TextView) findViewById(R.id.bzk);
        this.f302298e = textView2;
        if (this.f302301i) {
            str = this.F;
        } else {
            str = this.G;
        }
        textView2.setText(str);
        this.f302298e.setOnClickListener(this);
    }

    private int c(TextView textView) {
        return textView.getLayout().getLineTop(textView.getLineCount()) + textView.getCompoundPaddingTop() + textView.getCompoundPaddingBottom();
    }

    private void d(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mobileqq.troop.api.d.Q0);
        this.D = obtainStyledAttributes.getInt(com.tencent.mobileqq.troop.api.d.V0, 7);
        this.H = obtainStyledAttributes.getInt(com.tencent.mobileqq.troop.api.d.S0, 400);
        this.I = obtainStyledAttributes.getFloat(com.tencent.mobileqq.troop.api.d.R0, N);
        this.F = obtainStyledAttributes.getString(com.tencent.mobileqq.troop.api.d.U0);
        this.G = obtainStyledAttributes.getString(com.tencent.mobileqq.troop.api.d.T0);
        if (TextUtils.isEmpty(this.F)) {
            this.F = HardCodeUtil.qqStr(R.string.mat);
        }
        if (TextUtils.isEmpty(this.G)) {
            this.G = "";
        }
        obtainStyledAttributes.recycle();
        setOrientation(1);
        setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) view);
        } else if (this.f302298e.getVisibility() == 0) {
            boolean z16 = !this.f302301i;
            this.f302301i = z16;
            if (z16) {
                this.f302298e.setText(this.F);
            } else {
                this.f302298e.setText(this.G);
                if (!this.f302297d.getText().equals(this.f302299f)) {
                    this.f302297d.setText(this.f302299f);
                }
            }
            SparseBooleanArray sparseBooleanArray = this.L;
            if (sparseBooleanArray != null) {
                sparseBooleanArray.put(this.M, this.f302301i);
            }
            this.f302300h = true;
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    @Override // android.view.View
    @SuppressLint({"MissingSuperCall"})
    protected void onFinishInflate() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            b();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this, (Object) motionEvent)).booleanValue();
        }
        return this.J;
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        if (this.f302300h && getVisibility() != 8) {
            this.f302300h = false;
            this.f302298e.setVisibility(8);
            this.f302297d.setMaxLines(Integer.MAX_VALUE);
            super.onMeasure(i3, i16);
            if (this.f302297d.getLineCount() <= this.D) {
                return;
            }
            this.C = c(this.f302297d);
            if (this.f302301i) {
                this.f302297d.setMaxLines(this.D);
                if (this.K == null) {
                    this.K = new b(this.f302297d, this.D);
                }
                this.f302297d.getViewTreeObserver().addOnGlobalLayoutListener(this.K);
            }
            this.f302298e.setVisibility(0);
            super.onMeasure(i3, i16);
            if (this.f302301i) {
                this.f302297d.post(new Runnable() { // from class: com.tencent.mobileqq.troop.widget.ExpandableTextView.1
                    static IPatchRedirector $redirector_;

                    {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                            iPatchRedirector2.redirect((short) 1, (Object) this, (Object) ExpandableTextView.this);
                        }
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        IPatchRedirector iPatchRedirector2 = $redirector_;
                        if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                            iPatchRedirector2.redirect((short) 2, (Object) this);
                        } else {
                            ExpandableTextView expandableTextView = ExpandableTextView.this;
                            expandableTextView.E = expandableTextView.getHeight() - ExpandableTextView.this.f302297d.getHeight();
                        }
                    }
                });
                this.f302302m = getMeasuredHeight();
                return;
            }
            return;
        }
        super.onMeasure(i3, i16);
    }

    public void setOnExpandStateChangeListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) aVar);
        }
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            if (i3 != 0) {
                super.setOrientation(i3);
                return;
            }
            throw new IllegalArgumentException("ExpandableTextView only supports Vertical Orientation.");
        }
    }

    public void setText(CharSequence charSequence) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) charSequence);
            return;
        }
        this.f302300h = true;
        this.f302299f = charSequence;
        this.f302297d.setText(charSequence);
        setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    public ExpandableTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context, (Object) attributeSet);
        } else {
            this.f302301i = true;
            d(attributeSet);
        }
    }

    @TargetApi(11)
    public ExpandableTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, context, attributeSet, Integer.valueOf(i3));
        } else {
            this.f302301i = true;
            d(attributeSet);
        }
    }

    public void setText(CharSequence charSequence, SparseBooleanArray sparseBooleanArray, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, this, charSequence, sparseBooleanArray, Integer.valueOf(i3));
            return;
        }
        this.L = sparseBooleanArray;
        this.M = i3;
        boolean z16 = sparseBooleanArray.get(i3, true);
        clearAnimation();
        this.f302301i = z16;
        this.f302298e.setText(z16 ? this.F : this.G);
        setText(charSequence);
        getLayoutParams().height = -2;
        requestLayout();
    }
}
