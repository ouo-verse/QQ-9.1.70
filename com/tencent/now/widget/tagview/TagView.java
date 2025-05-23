package com.tencent.now.widget.tagview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes22.dex */
public class TagView extends RelativeLayout {
    private int C;
    private int D;
    private int E;
    private int F;
    private int G;

    /* renamed from: d, reason: collision with root package name */
    private List<ro3.a> f339098d;

    /* renamed from: e, reason: collision with root package name */
    private LayoutInflater f339099e;

    /* renamed from: f, reason: collision with root package name */
    private ViewTreeObserver f339100f;

    /* renamed from: h, reason: collision with root package name */
    private int f339101h;

    /* renamed from: i, reason: collision with root package name */
    private boolean f339102i;

    /* renamed from: m, reason: collision with root package name */
    private int f339103m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            if (!TagView.this.f339102i) {
                TagView.this.f339102i = true;
                TagView.this.g();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class b implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ro3.a f339105d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f339106e;

        b(ro3.a aVar, int i3) {
            this.f339105d = aVar;
            this.f339106e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TagView.a(TagView.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class c implements View.OnLongClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ro3.a f339108d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f339109e;

        c(ro3.a aVar, int i3) {
            this.f339108d = aVar;
            this.f339109e = i3;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            EventCollector.getInstance().onViewLongClickedBefore(view);
            TagView.d(TagView.this);
            EventCollector.getInstance().onViewLongClicked(view);
            return true;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes22.dex */
    public class d implements View.OnClickListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ ro3.a f339111d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f339112e;

        d(ro3.a aVar, int i3) {
            this.f339111d = aVar;
            this.f339112e = i3;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            TagView.b(TagView.this);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface e {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface f {
    }

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface g {
    }

    public TagView(Context context) {
        super(context, null);
        this.f339098d = new ArrayList();
        this.f339102i = false;
        i(context, null, 0);
    }

    static /* bridge */ /* synthetic */ e a(TagView tagView) {
        tagView.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ f b(TagView tagView) {
        tagView.getClass();
        return null;
    }

    static /* bridge */ /* synthetic */ g d(TagView tagView) {
        tagView.getClass();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (!this.f339102i) {
            return;
        }
        removeAllViews();
        float paddingLeft = getPaddingLeft() + getPaddingRight();
        ViewGroup viewGroup = null;
        ro3.a aVar = null;
        int i3 = 1;
        int i16 = 1;
        int i17 = 1;
        for (ro3.a aVar2 : this.f339098d) {
            int i18 = i3 - 1;
            View inflate = this.f339099e.inflate(R.layout.hrs, viewGroup);
            inflate.setId(i3);
            inflate.setBackground(h(aVar2));
            TextView textView = (TextView) inflate.findViewById(R.id.f111776m5);
            textView.setText(aVar2.f431815a);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) textView.getLayoutParams();
            layoutParams.setMargins(this.D, this.F, this.E, this.G);
            textView.setLayoutParams(layoutParams);
            textView.setTextColor(aVar2.f431816b);
            textView.setTextSize(2, aVar2.f431817c);
            inflate.setOnClickListener(new b(aVar2, i18));
            inflate.setOnLongClickListener(new c(aVar2, i18));
            float measureText = textView.getPaint().measureText(aVar2.f431815a) + this.D + this.E;
            TextView textView2 = (TextView) inflate.findViewById(R.id.f111786m6);
            if (aVar2.f431820f) {
                textView2.setVisibility(0);
                textView2.setText(aVar2.f431824j);
                int a16 = ro3.b.a(getContext(), 2.0f);
                textView2.setPadding(a16, this.F, this.E + a16, this.G);
                textView2.setTextColor(aVar2.f431821g);
                textView2.setTextSize(2, aVar2.f431822h);
                textView2.setOnClickListener(new d(aVar2, i18));
                measureText += textView2.getPaint().measureText(aVar2.f431824j) + this.D + this.E;
            } else {
                textView2.setVisibility(8);
            }
            RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
            layoutParams2.bottomMargin = this.f339103m;
            if (this.f339101h <= paddingLeft + measureText + ro3.b.a(getContext(), 2.0f)) {
                if (aVar != null) {
                    layoutParams2.addRule(3, i17);
                }
                paddingLeft = getPaddingLeft() + getPaddingRight();
                i16 = i3;
                i17 = i16;
            } else {
                layoutParams2.addRule(6, i16);
                if (i3 != i16) {
                    layoutParams2.addRule(1, i18);
                    int i19 = this.C;
                    layoutParams2.leftMargin = i19;
                    paddingLeft += i19;
                    if (aVar != null && aVar.f431817c < aVar2.f431817c) {
                        i17 = i3;
                    }
                }
            }
            paddingLeft += measureText;
            addView(inflate, layoutParams2);
            i3++;
            aVar = aVar2;
            viewGroup = null;
        }
    }

    private Drawable h(ro3.a aVar) {
        Drawable drawable = aVar.f431827m;
        if (drawable != null) {
            return drawable;
        }
        StateListDrawable stateListDrawable = new StateListDrawable();
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(aVar.f431818d);
        gradientDrawable.setCornerRadius(aVar.f431823i);
        if (aVar.f431825k > 0.0f) {
            gradientDrawable.setStroke(ro3.b.a(getContext(), aVar.f431825k), aVar.f431826l);
        }
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(aVar.f431819e);
        gradientDrawable2.setCornerRadius(aVar.f431823i);
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, gradientDrawable2);
        stateListDrawable.addState(new int[0], gradientDrawable);
        return stateListDrawable;
    }

    private void i(Context context, AttributeSet attributeSet, int i3) {
        this.f339099e = (LayoutInflater) context.getSystemService("layout_inflater");
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        this.f339100f = viewTreeObserver;
        viewTreeObserver.addOnGlobalLayoutListener(new a());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, li2.a.f414814x6, i3, i3);
        this.f339103m = (int) obtainStyledAttributes.getDimension(li2.a.f414823y6, ro3.b.a(getContext(), 5.0f));
        this.C = (int) obtainStyledAttributes.getDimension(li2.a.f414832z6, ro3.b.a(getContext(), 5.0f));
        this.D = (int) obtainStyledAttributes.getDimension(li2.a.B6, ro3.b.a(getContext(), 8.0f));
        this.E = (int) obtainStyledAttributes.getDimension(li2.a.C6, ro3.b.a(getContext(), 8.0f));
        this.F = (int) obtainStyledAttributes.getDimension(li2.a.D6, ro3.b.a(getContext(), 5.0f));
        this.G = (int) obtainStyledAttributes.getDimension(li2.a.A6, ro3.b.a(getContext(), 5.0f));
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        g();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i3, int i16) {
        super.onMeasure(i3, i16);
        if (getMeasuredWidth() <= 0) {
            return;
        }
        this.f339101h = getMeasuredWidth();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i3, int i16, int i17, int i18) {
        super.onSizeChanged(i3, i16, i17, i18);
        this.f339101h = i3;
    }

    public void setLineMargin(float f16) {
        this.f339103m = ro3.b.a(getContext(), f16);
    }

    public void setTagMargin(float f16) {
        this.C = ro3.b.a(getContext(), f16);
    }

    public void setTextPaddingLeft(float f16) {
        this.D = ro3.b.a(getContext(), f16);
    }

    public void setTextPaddingRight(float f16) {
        this.E = ro3.b.a(getContext(), f16);
    }

    public void setTextPaddingTop(float f16) {
        this.F = ro3.b.a(getContext(), f16);
    }

    public void settextPaddingBottom(float f16) {
        this.G = ro3.b.a(getContext(), f16);
    }

    public TagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f339098d = new ArrayList();
        this.f339102i = false;
        i(context, attributeSet, 0);
    }

    public TagView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f339098d = new ArrayList();
        this.f339102i = false;
        i(context, attributeSet, i3);
    }

    public void setOnTagClickListener(e eVar) {
    }

    public void setOnTagDeleteListener(f fVar) {
    }

    public void setOnTagLongClickListener(g gVar) {
    }
}
