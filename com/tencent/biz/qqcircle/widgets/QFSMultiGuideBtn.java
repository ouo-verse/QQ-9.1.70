package com.tencent.biz.qqcircle.widgets;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.tencent.biz.qqcircle.utils.cx;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class QFSMultiGuideBtn extends TextView implements View.OnClickListener {
    private static float M;
    private static int N;
    private static int P;
    private static int Q;
    private static float R;
    private int C;
    private int D;
    private float E;
    private GradientDrawable F;
    private int G;
    private String H;
    private a I;
    private b J;
    private String K;
    private ColorStateList L;

    /* renamed from: d, reason: collision with root package name */
    private String f93307d;

    /* renamed from: e, reason: collision with root package name */
    private float f93308e;

    /* renamed from: f, reason: collision with root package name */
    private int f93309f;

    /* renamed from: h, reason: collision with root package name */
    private int f93310h;

    /* renamed from: i, reason: collision with root package name */
    private String f93311i;

    /* renamed from: m, reason: collision with root package name */
    private float f93312m;

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface a {
        void a(QFSMultiGuideBtn qFSMultiGuideBtn);

        void b(QFSMultiGuideBtn qFSMultiGuideBtn);
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    public interface b {
        void a(int i3);
    }

    public QFSMultiGuideBtn(Context context) {
        this(context, null);
    }

    private void d() {
        setOnClickListener(this);
        setSingleLine();
    }

    private void g() {
        if (!TextUtils.isEmpty(this.f93311i)) {
            setText(this.f93311i);
        } else {
            int i3 = this.G;
            if (i3 != 1) {
                if (i3 == 3) {
                    setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1905342c));
                }
            } else {
                setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1914044p));
            }
        }
        if (this.C == 0) {
            this.C = N;
        }
        setTextColor(this.C);
        setGravity(17);
    }

    private void h() {
        if (this.F == null) {
            this.F = new GradientDrawable();
        }
        if (this.D == 0) {
            this.D = P;
        }
        this.F.setColor(this.D);
        setBackground(this.F);
    }

    private void i() {
        if (this.F == null) {
            this.F = new GradientDrawable();
        }
        this.F.setShape(0);
        if (this.E == 0.0f) {
            this.E = R;
        }
        this.F.setCornerRadius(this.E);
        if (this.f93310h == 0) {
            int i3 = this.G;
            if (i3 != 1 && i3 != 3) {
                this.f93310h = P;
            } else {
                this.f93310h = Q;
            }
        }
        this.F.setColor(this.f93310h);
        setBackground(this.F);
    }

    public String a() {
        return this.K;
    }

    public String b() {
        return this.H;
    }

    public int c() {
        return this.G;
    }

    public void e() {
        g();
        h();
    }

    public void f(String str, int i3, int i16, int i17) {
        this.f93310h = i17;
        i();
        if (!TextUtils.isEmpty(str)) {
            setText(str);
        } else {
            int i18 = this.G;
            if (i18 != 1) {
                if (i18 != 2) {
                    if (i18 != 3) {
                        if (i18 != 4) {
                            setText("");
                            setVisibility(8);
                        } else {
                            setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1911143x));
                        }
                    } else {
                        setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f19049429));
                    }
                } else {
                    setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1898540i));
                }
            } else {
                setText(com.tencent.biz.qqcircle.utils.h.a(R.string.f1913644l));
            }
        }
        if (i3 != 0) {
            setTextColor(i3);
        } else {
            setTextColor(N);
        }
        if (i16 != 0) {
            setTextSize(1, i16);
        } else {
            setTextSize(1, M);
        }
        setGravity(17);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onAttachedToWindow() {
        a aVar;
        super.onAttachedToWindow();
        Rect rect = new Rect();
        getLocalVisibleRect(rect);
        if (rect.left == 0 && rect.right == 0 && rect.top == 0 && rect.bottom == 0 && (aVar = this.I) != null) {
            aVar.b(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        if (!fb0.a.a("QFSMultiGuideBtn")) {
            a aVar = this.I;
            if (aVar != null) {
                aVar.a(this);
            }
            b bVar = this.J;
            if (bVar != null) {
                bVar.a(this.G);
            }
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setAfterSelectedBgColor(int i3) {
        this.D = i3;
    }

    public void setAfterSelectedText(String str) {
        this.f93311i = str;
    }

    public void setAfterSelectedTextColor(int i3) {
        this.C = i3;
    }

    public void setAfterSelectedTextSize(int i3) {
        this.f93312m = i3;
    }

    public void setBgColor(int i3) {
        this.f93310h = i3;
    }

    public void setCornerRadius(float f16) {
        this.E = f16;
    }

    public void setDatongJsonData(String str) {
        this.K = str;
    }

    public void setGuideBtnListener(a aVar) {
        this.I = aVar;
    }

    public void setOnSelectedListener(b bVar) {
        this.J = bVar;
    }

    public void setSchema(String str) {
        this.H = str;
    }

    public void setType(int i3) {
        this.G = i3;
    }

    public QFSMultiGuideBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x012b, code lost:
    
        if (r11 == null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public QFSMultiGuideBtn(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.L = new ColorStateList(new int[][]{new int[]{android.R.attr.state_selected}, new int[0]}, new int[]{getContext().getResources().getColor(R.color.cji), getContext().getResources().getColor(R.color.cli)});
        TypedArray typedArray = null;
        try {
            try {
                typedArray = context.obtainStyledAttributes(attributeSet, y91.a.f449637e6);
                int i16 = y91.a.f449736m6;
                this.f93308e = typedArray.getDimensionPixelSize(i16, 14);
                int i17 = y91.a.f449712k6;
                this.f93309f = typedArray.getColor(i17, getContext().getResources().getColor(R.color.cla));
                this.f93307d = typedArray.getString(y91.a.f449748n6);
                int i18 = y91.a.f449700j6;
                this.f93310h = typedArray.getColor(i18, getContext().getResources().getColor(R.color.cjn));
                this.f93312m = typedArray.getDimensionPixelSize(y91.a.f449663g6, 14);
                this.C = typedArray.getResourceId(y91.a.f449650f6, getContext().getResources().getColor(R.color.cla));
                this.f93311i = typedArray.getString(y91.a.f449676h6);
                this.D = typedArray.getColor(y91.a.f449724l6, getContext().getResources().getColor(R.color.cjn));
                int i19 = y91.a.f449688i6;
                this.E = typedArray.getDimensionPixelSize(i19, cx.a(4.0f));
                M = typedArray.getDimensionPixelSize(i16, 14);
                N = typedArray.getColor(i17, getContext().getResources().getColor(R.color.cla));
                P = typedArray.getColor(i18, getContext().getResources().getColor(R.color.cjn));
                Q = typedArray.getColor(i18, getContext().getResources().getColor(R.color.cbu));
                R = typedArray.getDimensionPixelSize(i19, (int) TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()));
            } catch (Exception e16) {
                e16.printStackTrace();
            }
            typedArray.recycle();
            d();
        } catch (Throwable th5) {
            if (typedArray != null) {
                typedArray.recycle();
            }
            throw th5;
        }
    }
}
