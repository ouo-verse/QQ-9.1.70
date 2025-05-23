package com.tencent.biz.qqcircle.richframework.widget.tab;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.richframework.ui.res.R$styleable;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqmini.sdk.launcher.core.proxy.va.TipsElementData;
import java.util.ArrayList;
import java.util.Collections;

/* compiled from: P */
/* loaded from: classes5.dex */
public class SlidingTabLayout extends HorizontalScrollView implements ViewPager.OnPageChangeListener {
    private int C;
    private Rect D;
    private Rect E;
    private GradientDrawable F;
    private Paint G;
    private Paint H;
    private Paint I;
    private Path J;
    private int K;
    private float L;
    private boolean M;
    private float N;
    private boolean P;
    private int Q;
    private float R;
    private float S;
    private float T;
    private float U;
    private float V;
    private float W;

    /* renamed from: a0, reason: collision with root package name */
    private float f92223a0;

    /* renamed from: b0, reason: collision with root package name */
    private int f92224b0;

    /* renamed from: c0, reason: collision with root package name */
    private boolean f92225c0;

    /* renamed from: d, reason: collision with root package name */
    private Context f92226d;

    /* renamed from: d0, reason: collision with root package name */
    private int f92227d0;

    /* renamed from: e, reason: collision with root package name */
    private ViewPager f92228e;

    /* renamed from: e0, reason: collision with root package name */
    private float f92229e0;

    /* renamed from: f, reason: collision with root package name */
    private ArrayList<String> f92230f;

    /* renamed from: f0, reason: collision with root package name */
    private int f92231f0;

    /* renamed from: g0, reason: collision with root package name */
    private int f92232g0;

    /* renamed from: h, reason: collision with root package name */
    private LinearLayout f92233h;

    /* renamed from: h0, reason: collision with root package name */
    private float f92234h0;

    /* renamed from: i, reason: collision with root package name */
    private int f92235i;

    /* renamed from: i0, reason: collision with root package name */
    private float f92236i0;

    /* renamed from: j0, reason: collision with root package name */
    private float f92237j0;

    /* renamed from: k0, reason: collision with root package name */
    private float f92238k0;

    /* renamed from: l0, reason: collision with root package name */
    private int f92239l0;

    /* renamed from: m, reason: collision with root package name */
    private float f92240m;

    /* renamed from: m0, reason: collision with root package name */
    private int f92241m0;

    /* renamed from: n0, reason: collision with root package name */
    private int f92242n0;

    /* renamed from: o0, reason: collision with root package name */
    private boolean f92243o0;

    /* renamed from: p0, reason: collision with root package name */
    private int f92244p0;

    /* renamed from: q0, reason: collision with root package name */
    private int f92245q0;

    /* renamed from: r0, reason: collision with root package name */
    private boolean f92246r0;

    /* renamed from: s0, reason: collision with root package name */
    private Paint f92247s0;

    /* renamed from: t0, reason: collision with root package name */
    private float f92248t0;

    /* renamed from: u0, reason: collision with root package name */
    private sb0.a f92249u0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            int indexOfChild = SlidingTabLayout.this.f92233h.indexOfChild(view);
            if (indexOfChild != -1) {
                if (SlidingTabLayout.this.f92249u0 != null) {
                    SlidingTabLayout.this.f92249u0.d(view, indexOfChild);
                }
                if (SlidingTabLayout.this.f92228e.getCurrentItem() != indexOfChild) {
                    if (SlidingTabLayout.this.f92246r0 && Math.abs(SlidingTabLayout.this.f92228e.getCurrentItem() - indexOfChild) > SlidingTabLayout.this.f92228e.getOffscreenPageLimit()) {
                        SlidingTabLayout.this.f92228e.setCurrentItem(indexOfChild, false);
                    } else {
                        SlidingTabLayout.this.f92228e.setCurrentItem(indexOfChild);
                    }
                } else if (SlidingTabLayout.this.f92249u0 != null) {
                    SlidingTabLayout.this.f92249u0.c(indexOfChild);
                }
            }
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    public SlidingTabLayout(Context context) {
        this(context, null, 0);
    }

    private void e(int i3, String str, View view) {
        LinearLayout.LayoutParams layoutParams;
        TextView textView = (TextView) view.findViewById(R.id.f111766m4);
        if (textView != null && str != null) {
            textView.setText(str);
        }
        sb0.a aVar = this.f92249u0;
        if (aVar != null) {
            aVar.b(view, i3);
        }
        view.setOnClickListener(new a());
        if (this.M) {
            layoutParams = new LinearLayout.LayoutParams(0, -1, 1.0f);
        } else {
            layoutParams = new LinearLayout.LayoutParams(-2, -1);
        }
        if (this.N > 0.0f) {
            layoutParams = new LinearLayout.LayoutParams((int) this.N, -1);
        }
        this.f92233h.addView(view, i3, layoutParams);
    }

    private void f() {
        View childAt = this.f92233h.getChildAt(this.f92235i);
        if (childAt == null) {
            return;
        }
        float left = childAt.getLeft();
        float right = childAt.getRight();
        if (this.K == 0 && this.f92225c0) {
            TextView textView = (TextView) childAt.findViewById(R.id.f111766m4);
            this.f92247s0.setTextSize(this.f92237j0);
            this.f92248t0 = ((right - left) - this.f92247s0.measureText(textView.getText().toString())) / 2.0f;
        }
        int i3 = this.f92235i;
        if (i3 < this.C - 1) {
            View childAt2 = this.f92233h.getChildAt(i3 + 1);
            float left2 = childAt2.getLeft();
            float right2 = childAt2.getRight();
            float f16 = this.f92240m;
            left += (left2 - left) * f16;
            right += f16 * (right2 - right);
            if (this.K == 0 && this.f92225c0) {
                TextView textView2 = (TextView) childAt2.findViewById(R.id.f111766m4);
                this.f92247s0.setTextSize(this.f92237j0);
                float measureText = ((right2 - left2) - this.f92247s0.measureText(textView2.getText().toString())) / 2.0f;
                float f17 = this.f92248t0;
                this.f92248t0 = f17 + (this.f92240m * (measureText - f17));
            }
        }
        Rect rect = this.D;
        int i16 = (int) left;
        rect.left = i16;
        int i17 = (int) right;
        rect.right = i17;
        if (this.K == 0 && this.f92225c0) {
            float f18 = this.f92248t0;
            rect.left = (int) ((left + f18) - 1.0f);
            rect.right = (int) ((right - f18) - 1.0f);
        }
        Rect rect2 = this.E;
        rect2.left = i16;
        rect2.right = i17;
        if (this.S >= 0.0f) {
            float left3 = childAt.getLeft() + ((childAt.getWidth() - this.S) / 2.0f);
            if (this.f92235i < this.C - 1) {
                left3 += this.f92240m * ((childAt.getWidth() / 2) + (this.f92233h.getChildAt(r2 + 1).getWidth() / 2));
            }
            Rect rect3 = this.D;
            int i18 = (int) left3;
            rect3.left = i18;
            rect3.right = (int) (i18 + this.S);
        }
    }

    private void h(Canvas canvas, int i3, int i16) {
        float f16 = this.f92234h0;
        if (f16 > 0.0f) {
            this.H.setStrokeWidth(f16);
            this.H.setColor(this.f92232g0);
            for (int i17 = 0; i17 < this.C - 1; i17++) {
                View childAt = this.f92233h.getChildAt(i17);
                canvas.drawLine(childAt.getRight() + i16, this.f92236i0, childAt.getRight() + i16, i3 - this.f92236i0, this.H);
            }
        }
    }

    private void i(Canvas canvas, int i3, int i16) {
        f();
        int i17 = this.K;
        if (i17 == 1) {
            if (this.R > 0.0f) {
                this.I.setColor(this.Q);
                this.J.reset();
                float f16 = i3;
                this.J.moveTo(this.D.left + i16, f16);
                Path path = this.J;
                Rect rect = this.D;
                path.lineTo((rect.left / 2) + i16 + (rect.right / 2), f16 - this.R);
                this.J.lineTo(i16 + this.D.right, f16);
                this.J.close();
                canvas.drawPath(this.J, this.I);
                return;
            }
            return;
        }
        if (i17 == 2) {
            if (this.R < 0.0f) {
                this.R = (i3 - this.V) - this.f92223a0;
            }
            float f17 = this.R;
            if (f17 > 0.0f) {
                float f18 = this.T;
                if (f18 < 0.0f || f18 > f17 / 2.0f) {
                    this.T = f17 / 2.0f;
                }
                this.F.setColor(this.Q);
                GradientDrawable gradientDrawable = this.F;
                int i18 = ((int) this.U) + i16 + this.D.left;
                float f19 = this.V;
                gradientDrawable.setBounds(i18, (int) f19, (int) ((i16 + r1.right) - this.W), (int) (f19 + this.R));
                this.F.setCornerRadius(this.T);
                this.F.draw(canvas);
                return;
            }
            return;
        }
        if (this.R > 0.0f) {
            this.F.setColor(this.Q);
            if (this.f92224b0 == 80) {
                GradientDrawable gradientDrawable2 = this.F;
                int i19 = ((int) this.U) + i16;
                Rect rect2 = this.D;
                int i26 = i19 + rect2.left;
                int i27 = i3 - ((int) this.R);
                float f26 = this.f92223a0;
                gradientDrawable2.setBounds(i26, i27 - ((int) f26), (i16 + rect2.right) - ((int) this.W), i3 - ((int) f26));
            } else {
                GradientDrawable gradientDrawable3 = this.F;
                int i28 = ((int) this.U) + i16;
                Rect rect3 = this.D;
                int i29 = i28 + rect3.left;
                float f27 = this.V;
                gradientDrawable3.setBounds(i29, (int) f27, (i16 + rect3.right) - ((int) this.W), ((int) this.R) + ((int) f27));
            }
            this.F.setCornerRadius(this.T);
            this.F.draw(canvas);
        }
    }

    private void j(Canvas canvas, int i3, int i16) {
        if (this.f92229e0 > 0.0f) {
            this.G.setColor(this.f92227d0);
            if (this.f92231f0 == 80) {
                float f16 = i3;
                canvas.drawRect(i16, f16 - this.f92229e0, this.f92233h.getWidth() + i16, f16, this.G);
            } else {
                canvas.drawRect(i16, 0.0f, this.f92233h.getWidth() + i16, this.f92229e0, this.G);
            }
        }
    }

    private void o(Context context, AttributeSet attributeSet) {
        String str;
        int i3;
        float f16;
        float f17;
        float f18;
        float f19;
        int g16;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SlidingTabLayout);
        int i16 = obtainStyledAttributes.getInt(R$styleable.SlidingTabLayout_tl_indicator_style, 0);
        this.K = i16;
        int i17 = R$styleable.SlidingTabLayout_tl_indicator_color;
        if (i16 == 2) {
            str = "#4B6A87";
        } else {
            str = TipsElementData.DEFAULT_COLOR;
        }
        this.Q = obtainStyledAttributes.getColor(i17, Color.parseColor(str));
        int i18 = R$styleable.SlidingTabLayout_tl_indicator_height;
        int i19 = this.K;
        if (i19 == 1) {
            f16 = 4.0f;
        } else {
            if (i19 == 2) {
                i3 = -1;
            } else {
                i3 = 2;
            }
            f16 = i3;
        }
        this.R = obtainStyledAttributes.getDimension(i18, g(f16));
        int i26 = R$styleable.SlidingTabLayout_tl_indicator_width;
        if (this.K == 1) {
            f17 = 10.0f;
        } else {
            f17 = -1.0f;
        }
        this.S = obtainStyledAttributes.getDimension(i26, g(f17));
        int i27 = R$styleable.SlidingTabLayout_tl_indicator_corner_radius;
        if (this.K == 2) {
            f18 = -1.0f;
        } else {
            f18 = 0.0f;
        }
        this.T = obtainStyledAttributes.getDimension(i27, g(f18));
        this.U = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_indicator_margin_left, g(0.0f));
        int i28 = R$styleable.SlidingTabLayout_tl_indicator_margin_top;
        float f26 = 7.0f;
        if (this.K == 2) {
            f19 = 7.0f;
        } else {
            f19 = 0.0f;
        }
        this.V = obtainStyledAttributes.getDimension(i28, g(f19));
        this.W = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_indicator_margin_right, g(0.0f));
        int i29 = R$styleable.SlidingTabLayout_tl_indicator_margin_bottom;
        if (this.K != 2) {
            f26 = 0.0f;
        }
        this.f92223a0 = obtainStyledAttributes.getDimension(i29, g(f26));
        this.f92224b0 = obtainStyledAttributes.getInt(R$styleable.SlidingTabLayout_tl_indicator_gravity, 80);
        this.f92225c0 = obtainStyledAttributes.getBoolean(R$styleable.SlidingTabLayout_tl_indicator_width_equal_title, false);
        this.f92227d0 = obtainStyledAttributes.getColor(R$styleable.SlidingTabLayout_tl_underline_color, Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f92229e0 = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_underline_height, g(0.0f));
        this.f92231f0 = obtainStyledAttributes.getInt(R$styleable.SlidingTabLayout_tl_underline_gravity, 80);
        this.f92232g0 = obtainStyledAttributes.getColor(R$styleable.SlidingTabLayout_tl_divider_color, Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f92234h0 = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_divider_width, g(0.0f));
        this.f92236i0 = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_divider_padding, g(12.0f));
        this.f92237j0 = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_textsize, q(14.0f));
        this.f92238k0 = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_textSelectSize, q(14.0f));
        this.f92239l0 = obtainStyledAttributes.getColor(R$styleable.SlidingTabLayout_tl_textSelectColor, Color.parseColor(TipsElementData.DEFAULT_COLOR));
        this.f92241m0 = obtainStyledAttributes.getResourceId(R$styleable.SlidingTabLayout_tl_textUnselectColor, Color.parseColor("#AAffffff"));
        this.f92242n0 = obtainStyledAttributes.getInt(R$styleable.SlidingTabLayout_tl_textBold, 0);
        this.f92243o0 = obtainStyledAttributes.getBoolean(R$styleable.SlidingTabLayout_tl_textAllCaps, false);
        this.M = obtainStyledAttributes.getBoolean(R$styleable.SlidingTabLayout_tl_tab_space_equal, false);
        float dimension = obtainStyledAttributes.getDimension(R$styleable.SlidingTabLayout_tl_tab_width, g(-1.0f));
        this.N = dimension;
        int i36 = R$styleable.SlidingTabLayout_tl_tab_padding;
        if (!this.M && dimension <= 0.0f) {
            g16 = g(20.0f);
        } else {
            g16 = g(0.0f);
        }
        this.L = obtainStyledAttributes.getDimension(i36, g16);
        this.P = obtainStyledAttributes.getBoolean(R$styleable.SlidingTabLayout_tl_tab_enable_img_dec, false);
        obtainStyledAttributes.recycle();
    }

    private void p() {
        if (this.C <= 0) {
            return;
        }
        int width = (int) (this.f92240m * this.f92233h.getChildAt(this.f92235i).getWidth());
        int left = this.f92233h.getChildAt(this.f92235i).getLeft() + width;
        if (this.f92235i > 0 || width > 0) {
            int width2 = left - ((getWidth() / 2) - getPaddingLeft());
            f();
            Rect rect = this.E;
            left = width2 + ((rect.right - rect.left) / 2);
        }
        if (left != this.f92244p0) {
            this.f92244p0 = left;
            scrollTo(left, 0);
        }
    }

    private void r(int i3) {
        boolean z16;
        int i16;
        float f16;
        for (int i17 = 0; i17 < this.C; i17++) {
            View childAt = this.f92233h.getChildAt(i17);
            if (i17 == i3) {
                z16 = true;
            } else {
                z16 = false;
            }
            TextView textView = (TextView) childAt.findViewById(R.id.f111766m4);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.f111756m3);
            if (textView != null) {
                if (z16) {
                    textView.setTextColor(this.f92239l0);
                } else {
                    textView.setTextColor(AppCompatResources.getColorStateList(getContext(), this.f92241m0));
                }
                childAt.setSelected(z16);
                if (z16) {
                    f16 = this.f92238k0;
                } else {
                    f16 = this.f92237j0;
                }
                textView.setTextSize(0, f16);
                if (this.f92242n0 == 1) {
                    textView.getPaint().setFakeBoldText(z16);
                }
            }
            if (imageView != null && this.P) {
                if (z16) {
                    i16 = 0;
                } else {
                    i16 = 8;
                }
                imageView.setVisibility(i16);
            }
        }
    }

    private void s() {
        int i3;
        for (int i16 = 0; i16 < this.C; i16++) {
            View childAt = this.f92233h.getChildAt(i16);
            TextView textView = (TextView) childAt.findViewById(R.id.f111766m4);
            ImageView imageView = (ImageView) childAt.findViewById(R.id.f111756m3);
            if (textView != null) {
                if (i16 == this.f92235i) {
                    textView.setTextColor(this.f92239l0);
                } else {
                    textView.setTextColor(AppCompatResources.getColorStateList(getContext(), this.f92241m0));
                }
                textView.setTextSize(0, this.f92237j0);
                float f16 = this.L;
                textView.setPadding((int) f16, 0, (int) f16, 0);
                if (this.f92243o0) {
                    textView.setText(textView.getText().toString().toUpperCase());
                }
                int i17 = this.f92242n0;
                if (i17 == 2) {
                    textView.getPaint().setFakeBoldText(true);
                } else if (i17 == 0) {
                    textView.getPaint().setFakeBoldText(false);
                }
            }
            if (imageView != null && this.P) {
                if (i16 == this.f92235i) {
                    i3 = 0;
                } else {
                    i3 = 8;
                }
                imageView.setVisibility(i3);
            }
        }
    }

    protected int g(float f16) {
        return (int) ((f16 * this.f92226d.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public int k() {
        return this.f92235i;
    }

    public float l() {
        return this.L;
    }

    public View m(int i3) {
        LinearLayout linearLayout = this.f92233h;
        if (linearLayout == null) {
            return null;
        }
        return linearLayout.getChildAt(i3);
    }

    public void n() {
        int size;
        String str;
        this.f92233h.removeAllViews();
        ArrayList<String> arrayList = this.f92230f;
        if (arrayList == null) {
            size = this.f92228e.getAdapter().getF373114d();
        } else {
            size = arrayList.size();
        }
        this.C = size;
        for (int i3 = 0; i3 < this.C; i3++) {
            View inflate = View.inflate(this.f92226d, R.layout.ffn, null);
            ArrayList<String> arrayList2 = this.f92230f;
            if (arrayList2 == null) {
                str = this.f92228e.getAdapter().getPageTitle(i3);
            } else {
                str = arrayList2.get(i3);
            }
            e(i3, str.toString(), inflate);
        }
        s();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (!isInEditMode() && this.C > 0) {
            int height = getHeight();
            int paddingLeft = getPaddingLeft();
            h(canvas, height, paddingLeft);
            j(canvas, height, paddingLeft);
            i(canvas, height, paddingLeft);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i3, float f16, int i16) {
        this.f92235i = i3;
        this.f92240m = f16;
        p();
        invalidate();
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i3) {
        r(i3);
        sb0.a aVar = this.f92249u0;
        if (aVar != null) {
            aVar.a(i3);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            this.f92235i = bundle.getInt("mCurrentTab");
            parcelable = bundle.getParcelable("instanceState");
            if (this.f92235i != 0 && this.f92233h.getChildCount() > 0) {
                r(this.f92235i);
                p();
            }
        }
        super.onRestoreInstanceState(parcelable);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("instanceState", super.onSaveInstanceState());
        bundle.putInt("mCurrentTab", this.f92235i);
        return bundle;
    }

    protected int q(float f16) {
        return (int) ((f16 * this.f92226d.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public void setCurrentTab(int i3) {
        this.f92235i = i3;
        this.f92228e.setCurrentItem(i3);
    }

    public void setDividerColor(int i3) {
        this.f92232g0 = i3;
        invalidate();
    }

    public void setDividerPadding(float f16) {
        this.f92236i0 = g(f16);
        invalidate();
    }

    public void setDividerWidth(float f16) {
        this.f92234h0 = g(f16);
        invalidate();
    }

    public void setIndicatorColor(int i3) {
        this.Q = i3;
        invalidate();
    }

    public void setIndicatorCornerRadius(float f16) {
        this.T = g(f16);
        invalidate();
    }

    public void setIndicatorGravity(int i3) {
        this.f92224b0 = i3;
        invalidate();
    }

    public void setIndicatorHeight(float f16) {
        this.R = g(f16);
        invalidate();
    }

    public void setIndicatorMargin(float f16, float f17, float f18, float f19) {
        this.U = g(f16);
        this.V = g(f17);
        this.W = g(f18);
        this.f92223a0 = g(f19);
        invalidate();
    }

    public void setIndicatorStyle(int i3) {
        this.K = i3;
        invalidate();
    }

    public void setIndicatorWidth(float f16) {
        this.S = g(f16);
        invalidate();
    }

    public void setIndicatorWidthEqualTitle(boolean z16) {
        this.f92225c0 = z16;
        invalidate();
    }

    public void setOnTabSelectListener(sb0.a aVar) {
        this.f92249u0 = aVar;
    }

    public void setSnapOnTabClick(boolean z16) {
        this.f92246r0 = z16;
    }

    public void setTabPadding(float f16) {
        this.L = g(f16);
        s();
    }

    public void setTabSpaceEqual(boolean z16) {
        this.M = z16;
        s();
    }

    public void setTabWidth(float f16) {
        this.N = g(f16);
        s();
    }

    public void setTextAllCaps(boolean z16) {
        this.f92243o0 = z16;
        s();
    }

    public void setTextBold(int i3) {
        this.f92242n0 = i3;
        s();
    }

    public void setTextSelectColor(int i3) {
        this.f92239l0 = i3;
        s();
    }

    public void setTextSize(float f16) {
        this.f92237j0 = q(f16);
        s();
    }

    public void setTextUnselectColor(int i3) {
        this.f92241m0 = i3;
        s();
    }

    public void setUnderlineColor(int i3) {
        this.f92227d0 = i3;
        invalidate();
    }

    public void setUnderlineGravity(int i3) {
        this.f92231f0 = i3;
        invalidate();
    }

    public void setUnderlineHeight(float f16) {
        this.f92229e0 = g(f16);
        invalidate();
    }

    public void setViewPager(ViewPager viewPager) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            this.f92228e = viewPager;
            viewPager.removeOnPageChangeListener(this);
            this.f92228e.addOnPageChangeListener(this);
            n();
            return;
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.D = new Rect();
        this.E = new Rect();
        this.F = new GradientDrawable();
        this.G = new Paint(1);
        this.H = new Paint(1);
        this.I = new Paint(1);
        this.J = new Path();
        this.K = 0;
        this.f92247s0 = new Paint(1);
        setFillViewport(true);
        setWillNotDraw(false);
        setClipChildren(false);
        setClipToPadding(false);
        this.f92226d = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f92233h = linearLayout;
        addView(linearLayout);
        o(context, attributeSet);
        String attributeValue = attributeSet.getAttributeValue("http://schemas.android.com/apk/res/android", "layout_height");
        if (attributeValue.equals("-1") || attributeValue.equals("-2")) {
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, new int[]{android.R.attr.layout_height});
        this.f92245q0 = obtainStyledAttributes.getDimensionPixelSize(0, -2);
        obtainStyledAttributes.recycle();
    }

    public void setCurrentTab(int i3, boolean z16) {
        this.f92235i = i3;
        this.f92228e.setCurrentItem(i3, z16);
    }

    public void setViewPager(ViewPager viewPager, String[] strArr) {
        if (viewPager != null && viewPager.getAdapter() != null) {
            if (strArr != null && strArr.length != 0) {
                if (strArr.length == viewPager.getAdapter().getF373114d()) {
                    this.f92228e = viewPager;
                    ArrayList<String> arrayList = new ArrayList<>();
                    this.f92230f = arrayList;
                    Collections.addAll(arrayList, strArr);
                    this.f92228e.removeOnPageChangeListener(this);
                    this.f92228e.addOnPageChangeListener(this);
                    n();
                    return;
                }
                throw new IllegalStateException("Titles length must be the same as the page count !");
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager or ViewPager adapter can not be NULL !");
    }

    public void setViewPager(ViewPager viewPager, String[] strArr, FragmentActivity fragmentActivity, ArrayList<Fragment> arrayList) {
        if (viewPager != null) {
            if (strArr != null && strArr.length != 0) {
                this.f92228e = viewPager;
                viewPager.setAdapter(new b(fragmentActivity.getSupportFragmentManager(), arrayList, strArr));
                this.f92228e.removeOnPageChangeListener(this);
                this.f92228e.addOnPageChangeListener(this);
                n();
                return;
            }
            throw new IllegalStateException("Titles can not be EMPTY !");
        }
        throw new IllegalStateException("ViewPager can not be NULL !");
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i3) {
    }

    /* compiled from: P */
    /* loaded from: classes5.dex */
    class b extends FragmentPagerAdapter {

        /* renamed from: d, reason: collision with root package name */
        private ArrayList<Fragment> f92251d;

        /* renamed from: e, reason: collision with root package name */
        private String[] f92252e;

        public b(FragmentManager fragmentManager, ArrayList<Fragment> arrayList, String[] strArr) {
            super(fragmentManager);
            new ArrayList();
            this.f92251d = arrayList;
            this.f92252e = strArr;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        /* renamed from: getCount */
        public int getF373114d() {
            return this.f92251d.size();
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter
        public Fragment getItem(int i3) {
            return this.f92251d.get(i3);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getItemPosition(Object obj) {
            return -2;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public CharSequence getPageTitle(int i3) {
            return this.f92252e[i3];
        }

        @Override // androidx.fragment.app.FragmentPagerAdapter, androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i3, Object obj) {
        }
    }
}
