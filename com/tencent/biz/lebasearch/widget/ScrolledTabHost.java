package com.tencent.biz.lebasearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.R;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes2.dex */
public class ScrolledTabHost extends FrameLayout implements View.OnClickListener {
    int C;

    /* renamed from: d, reason: collision with root package name */
    Context f78643d;

    /* renamed from: e, reason: collision with root package name */
    ViewGroup f78644e;

    /* renamed from: f, reason: collision with root package name */
    HorizontalScrollView f78645f;

    /* renamed from: h, reason: collision with root package name */
    View f78646h;

    /* renamed from: i, reason: collision with root package name */
    List<View> f78647i;

    /* renamed from: m, reason: collision with root package name */
    b f78648m;

    /* compiled from: P */
    /* loaded from: classes2.dex */
    public interface b {
        void f(int i3);

        void g(int i3);
    }

    public ScrolledTabHost(Context context) {
        super(context);
        this.f78647i = new ArrayList();
        this.C = 0;
        this.f78643d = context;
        d();
    }

    private void d() {
        LayoutInflater.from(this.f78643d).inflate(R.layout.f168780aq2, this);
        this.f78644e = (ViewGroup) findViewById(R.id.j_i);
        this.f78645f = (HorizontalScrollView) findViewById(R.id.j_u);
        this.f78646h = findViewById(R.id.cdb);
    }

    public void a(String str) {
        View remove;
        if (this.f78647i.size() == 0) {
            remove = LayoutInflater.from(getContext()).inflate(R.layout.aq7, (ViewGroup) null);
        } else {
            remove = this.f78647i.remove(0);
        }
        ((TextView) remove.findViewById(R.id.kbs)).setText(str);
        remove.setTag(-3, str);
        if (remove.getParent() != null) {
            return;
        }
        remove.findViewById(R.id.j_9).setVisibility(4);
        this.f78644e.addView(remove);
        remove.setOnClickListener(this);
    }

    public void b() {
        for (int i3 = 0; i3 < this.f78644e.getChildCount(); i3++) {
            View childAt = this.f78644e.getChildAt(i3);
            childAt.findViewById(R.id.j_9).setVisibility(4);
            this.f78647i.add(childAt);
        }
        f(0);
        this.f78644e.removeAllViews();
        this.C = 0;
    }

    public View c(int i3) {
        return this.f78644e.getChildAt(i3);
    }

    public void e() {
        if (this.f78644e != null) {
            this.C = 0;
            for (int i3 = 0; i3 < this.f78644e.getChildCount(); i3++) {
                View findViewById = this.f78644e.getChildAt(i3).findViewById(R.id.j_9);
                if (i3 == 0) {
                    findViewById.setVisibility(0);
                } else {
                    findViewById.setVisibility(4);
                }
            }
            b bVar = this.f78648m;
            if (bVar != null) {
                bVar.f(0);
            }
        }
    }

    public void f(int i3) {
        View c16 = c(i3);
        if (c16 == null) {
            return;
        }
        int width = c16.getWidth();
        int[] iArr = new int[2];
        c16.getLocationInWindow(iArr);
        int i16 = iArr[0];
        int i17 = this.f78643d.getResources().getDisplayMetrics().widthPixels;
        if (i16 < 0) {
            this.f78645f.smoothScrollBy(i16, 0);
        } else {
            int i18 = i16 + width;
            if (i18 > i17) {
                this.f78645f.smoothScrollBy(i18 - i17, 0);
            }
        }
        for (int i19 = 0; i19 < this.f78644e.getChildCount(); i19++) {
            TextView textView = (TextView) this.f78644e.getChildAt(i19).findViewById(R.id.kbs);
            if (i19 == i3) {
                textView.setTextColor(getResources().getColor(R.color.skin_black_item));
            } else {
                textView.setTextColor(getResources().getColor(R.color.skin_gray2_item));
            }
        }
    }

    public void g(int i3, int i16) {
        View c16 = c(i3);
        View c17 = c(i16);
        View findViewById = c16.findViewById(R.id.j_9);
        View findViewById2 = c17.findViewById(R.id.j_9);
        if (i3 == i16) {
            findViewById2.setVisibility(0);
            return;
        }
        int[] iArr = new int[2];
        findViewById.getLocationInWindow(iArr);
        findViewById2.getLocationInWindow(new int[2]);
        int[] iArr2 = new int[2];
        this.f78644e.getLocationInWindow(iArr2);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f78646h.getLayoutParams();
        layoutParams.leftMargin = iArr[0] - iArr2[0];
        layoutParams.width = findViewById2.getMeasuredWidth();
        this.f78646h.setLayoutParams(layoutParams);
        AnimationSet animationSet = new AnimationSet(false);
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, r4[0] - iArr[0], 0.0f, 0.0f);
        translateAnimation.setDuration(300L);
        translateAnimation.setFillAfter(false);
        animationSet.addAnimation(translateAnimation);
        animationSet.setAnimationListener(new a(findViewById, findViewById2, i16));
        this.f78646h.setVisibility(0);
        findViewById.setVisibility(4);
        this.f78646h.startAnimation(animationSet);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        EventCollector.getInstance().onViewClickedBefore(view);
        b bVar = this.f78648m;
        if (bVar != null) {
            bVar.f(this.f78644e.indexOfChild(view));
            this.f78648m.g(this.f78644e.indexOfChild(view));
        }
        EventCollector.getInstance().onViewClicked(view);
    }

    public void setCurrentTab(int i3) {
        if (i3 >= 0 && i3 < this.f78644e.getChildCount()) {
            int i16 = this.C;
            this.C = i3;
            b bVar = this.f78648m;
            if (bVar != null) {
                bVar.f(i3);
            }
            for (int i17 = 0; i17 < this.f78644e.getChildCount(); i17++) {
                TextView textView = (TextView) this.f78644e.getChildAt(i17).findViewById(R.id.kbs);
                if (i17 == i3) {
                    textView.setTextColor(getResources().getColor(R.color.skin_black_item));
                } else {
                    textView.setTextColor(getResources().getColor(R.color.skin_gray2_item));
                }
            }
            g(i16, this.C);
        }
    }

    public void setOnTabSelectedListener(b bVar) {
        this.f78648m = bVar;
    }

    public ScrolledTabHost(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f78647i = new ArrayList();
        this.C = 0;
        this.f78643d = context;
        d();
    }

    public ScrolledTabHost(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f78647i = new ArrayList();
        this.C = 0;
        this.f78643d = context;
        d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes2.dex */
    public class a implements Animation.AnimationListener {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ View f78649d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ View f78650e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ int f78651f;

        a(View view, View view2, int i3) {
            this.f78649d = view;
            this.f78650e = view2;
            this.f78651f = i3;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f78649d.setVisibility(4);
            this.f78650e.setVisibility(0);
            ScrolledTabHost.this.f78646h.setVisibility(8);
            ScrolledTabHost.this.f(this.f78651f);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }
}
