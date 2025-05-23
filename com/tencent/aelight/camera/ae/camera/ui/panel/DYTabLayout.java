package com.tencent.aelight.camera.ae.camera.ui.panel;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes32.dex */
public class DYTabLayout extends FrameLayout {
    private ViewTreeObserver.OnGlobalLayoutListener C;

    /* renamed from: d, reason: collision with root package name */
    private LinearLayout f63016d;

    /* renamed from: e, reason: collision with root package name */
    private View f63017e;

    /* renamed from: f, reason: collision with root package name */
    private d f63018f;

    /* renamed from: h, reason: collision with root package name */
    private c f63019h;

    /* renamed from: i, reason: collision with root package name */
    private HashMap<String, c> f63020i;

    /* renamed from: m, reason: collision with root package name */
    private boolean f63021m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class a implements ViewTreeObserver.OnGlobalLayoutListener {
        a() {
        }

        @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
        public void onGlobalLayout() {
            DYTabLayout.this.c();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    class b implements View.OnClickListener {
        b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            EventCollector.getInstance().onViewClickedBefore(view);
            DYTabLayout.this.g(((c) view).f63025e);
            EventCollector.getInstance().onViewClicked(view);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes32.dex */
    public class c extends FrameLayout {

        /* renamed from: d, reason: collision with root package name */
        TextView f63024d;

        /* renamed from: e, reason: collision with root package name */
        int f63025e;

        public c(Context context, String str, int i3) {
            super(context);
            this.f63025e = i3;
            int applyDimension = (int) TypedValue.applyDimension(1, 7.0f, context.getResources().getDisplayMetrics());
            setPadding(applyDimension, 0, applyDimension, 0);
            TextView textView = new TextView(context);
            this.f63024d = textView;
            textView.setTextSize(1, 12.0f);
            this.f63024d.setText(str);
            a();
            FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
            generateDefaultLayoutParams.width = -2;
            generateDefaultLayoutParams.height = -2;
            generateDefaultLayoutParams.gravity = 17;
            addView(this.f63024d, generateDefaultLayoutParams);
        }

        private void a() {
            String str;
            TextView textView = this.f63024d;
            if (isSelected()) {
                str = "#FFFFFF";
            } else {
                str = "#99FFFFFF";
            }
            textView.setTextColor(Color.parseColor(str));
        }

        @Override // android.view.View
        public void setSelected(boolean z16) {
            super.setSelected(z16);
            a();
        }
    }

    /* compiled from: P */
    /* loaded from: classes32.dex */
    public interface d {
        void a(View view, int i3);
    }

    public DYTabLayout(Context context) {
        this(context, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        c cVar;
        if (this.f63017e.getVisibility() == 0 && (cVar = this.f63019h) != null) {
            this.f63017e.offsetLeftAndRight(((cVar.getLeft() + (this.f63019h.getWidth() / 2)) - this.f63017e.getLeft()) - (this.f63017e.getWidth() / 2));
        }
    }

    private Drawable d(int i3) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius(i3);
        gradientDrawable.setColor(Color.parseColor("#FFFFFF"));
        return gradientDrawable;
    }

    private void f(Context context, AttributeSet attributeSet) {
        LinearLayout linearLayout = new LinearLayout(context);
        this.f63016d = linearLayout;
        linearLayout.setOrientation(0);
        FrameLayout.LayoutParams generateDefaultLayoutParams = generateDefaultLayoutParams();
        generateDefaultLayoutParams.width = -2;
        generateDefaultLayoutParams.height = -1;
        addView(this.f63016d, generateDefaultLayoutParams);
        this.f63016d.setVisibility(4);
        int applyDimension = (int) TypedValue.applyDimension(1, 3.0f, context.getResources().getDisplayMetrics());
        int applyDimension2 = (int) TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics());
        View view = new View(context);
        this.f63017e = view;
        view.setBackgroundDrawable(d(applyDimension));
        FrameLayout.LayoutParams generateDefaultLayoutParams2 = generateDefaultLayoutParams();
        generateDefaultLayoutParams2.gravity = 80;
        generateDefaultLayoutParams2.height = applyDimension;
        generateDefaultLayoutParams2.width = applyDimension2;
        addView(this.f63017e, generateDefaultLayoutParams2);
        this.f63017e.setVisibility(4);
        this.C = new a();
        getViewTreeObserver().addOnGlobalLayoutListener(this.C);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(int i3) {
        c cVar = this.f63019h;
        if (cVar == null || cVar.f63025e != i3) {
            c cVar2 = null;
            for (int i16 = 0; i16 < this.f63016d.getChildCount(); i16++) {
                c cVar3 = (c) this.f63016d.getChildAt(i16);
                cVar3.setSelected(cVar3.f63025e == i3);
                if (cVar3.f63025e == i3) {
                    cVar2 = cVar3;
                }
            }
            if (cVar2 == null) {
                return;
            }
            this.f63019h = cVar2;
            d dVar = this.f63018f;
            if (dVar != null) {
                dVar.a(cVar2, i3);
            }
            requestLayout();
        }
    }

    public int e() {
        c cVar = this.f63019h;
        if (cVar == null) {
            return -1;
        }
        return cVar.f63025e;
    }

    public void h(int i3) {
        g(i3);
    }

    public void setupTabs(String[] strArr, d dVar) {
        this.f63018f = dVar;
        int applyDimension = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
        this.f63016d.removeAllViews();
        this.f63020i.clear();
        int i3 = 0;
        while (i3 < strArr.length) {
            c cVar = new c(getContext(), strArr[i3], i3);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            layoutParams.rightMargin = i3 < strArr.length - 1 ? applyDimension : 0;
            this.f63020i.put(strArr[i3], cVar);
            this.f63016d.addView(cVar, layoutParams);
            cVar.setOnClickListener(new b());
            if (i3 == 0) {
                post(new Runnable() { // from class: com.tencent.aelight.camera.ae.camera.ui.panel.DYTabLayout.3
                    @Override // java.lang.Runnable
                    public void run() {
                        DYTabLayout.this.g(0);
                    }
                });
            }
            i3++;
        }
        if (strArr.length > 0) {
            this.f63016d.setVisibility(0);
            if (this.f63021m) {
                this.f63017e.setVisibility(0);
            }
        } else {
            this.f63016d.setVisibility(4);
            this.f63017e.setVisibility(4);
        }
        requestLayout();
    }

    public DYTabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        f(context, attributeSet);
    }

    public DYTabLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f63020i = new HashMap<>();
        f(context, attributeSet);
    }
}
