package com.tencent.mobileqq.matchfriend.widget;

import android.animation.ValueAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.OverScroller;
import com.tencent.mobileqq.matchfriend.utils.d;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes33.dex */
public class MatchFriendLoopScrollView extends HorizontalScrollView {
    private boolean C;
    private boolean D;
    private int E;
    private d F;

    /* renamed from: d, reason: collision with root package name */
    private final Context f245643d;

    /* renamed from: e, reason: collision with root package name */
    private b f245644e;

    /* renamed from: f, reason: collision with root package name */
    private ValueAnimator f245645f;

    /* renamed from: h, reason: collision with root package name */
    private final LinearLayout f245646h;

    /* renamed from: i, reason: collision with root package name */
    private View f245647i;

    /* renamed from: m, reason: collision with root package name */
    private final List<View> f245648m;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: d, reason: collision with root package name */
        private int f245649d;

        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            int intValue = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            int max = Math.max(0, intValue - this.f245649d);
            if (!MatchFriendLoopScrollView.this.C) {
                MatchFriendLoopScrollView.this.scrollBy(max, 0);
            }
            this.f245649d = intValue;
        }
    }

    public MatchFriendLoopScrollView(Context context) {
        this(context, null);
    }

    private void b() {
        j();
        ValueAnimator ofInt = ValueAnimator.ofInt(1000);
        this.f245645f = ofInt;
        ofInt.setDuration(10000);
        this.f245645f.setRepeatCount(-1);
        this.f245645f.setInterpolator(new LinearInterpolator());
        this.f245645f.addUpdateListener(new a());
        this.f245645f.start();
    }

    private void h() {
        d dVar = new d(this.f245643d);
        this.F = dVar;
        dVar.c("pg_kl_new_voice_match_call", null);
    }

    private int i(int i3, boolean z16) {
        if (!c(i3, z16)) {
            boolean z17 = i3 <= 0;
            int width = (getWidth() - getPaddingLeft()) - getPaddingRight();
            ArrayList arrayList = new ArrayList();
            int i16 = 0;
            for (int childCount = this.f245646h.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = this.f245646h.getChildAt(childCount);
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                if (!z17 ? childAt.getRight() + marginLayoutParams.rightMargin > i3 : childAt.getLeft() - marginLayoutParams.leftMargin < width) {
                    i16 += childAt.getWidth() + marginLayoutParams.rightMargin + marginLayoutParams.leftMargin;
                    arrayList.add(0, childAt);
                }
            }
            if (z17) {
                d(arrayList, i16);
                i3 += i16;
            } else {
                e(arrayList, i16);
                i3 -= i16;
            }
        }
        return Math.max(0, i3);
    }

    private void j() {
        ValueAnimator valueAnimator = this.f245645f;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.f245645f.removeAllListeners();
            this.f245645f = null;
        }
    }

    private void k() {
        d dVar = this.F;
        if (dVar != null) {
            dVar.k("ev_kl_new_voice_call_bullet_screen", null);
        }
    }

    public void g(List<com.tencent.mobileqq.matchfriend.bean.a> list) {
        this.f245648m.clear();
        for (int i3 = 0; i3 < 2; i3++) {
            MatchFriendIceBreakTopicContainer matchFriendIceBreakTopicContainer = new MatchFriendIceBreakTopicContainer(this.f245643d);
            matchFriendIceBreakTopicContainer.b(list);
            this.f245648m.add(matchFriendIceBreakTopicContainer);
        }
        this.f245647i = new View(this.f245643d);
        this.f245647i.setLayoutParams(new FrameLayout.LayoutParams(ViewUtils.getScreenWidth(), -1));
        this.f245646h.removeAllViews();
        this.f245646h.addView(this.f245647i);
        Iterator<View> it = this.f245648m.iterator();
        while (it.hasNext()) {
            this.f245646h.addView(it.next());
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        j();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z16, int i3, int i16, int i17, int i18) {
        super.onLayout(z16, i3, i16, i17, i18);
        if (z16 || this.f245645f == null) {
            b();
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    protected void onOverScrolled(int i3, int i16, boolean z16, boolean z17) {
        if (!this.C) {
            int currX = this.f245644e.getCurrX();
            int i17 = currX - this.E;
            this.E = currX;
            if (i17 == 0) {
                return;
            } else {
                i3 = getScrollX() + i17;
            }
        }
        super.onOverScrolled(i(i3, z16), i16, false, z17);
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            this.C = false;
            this.E = getScrollX();
            k();
        } else {
            this.C = true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public MatchFriendLoopScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void f() {
        setHorizontalScrollBarEnabled(false);
        setOverScrollMode(0);
        l();
    }

    private void l() {
        try {
            Field declaredField = HorizontalScrollView.class.getDeclaredField("mScroller");
            declaredField.setAccessible(true);
            b bVar = new b(getContext());
            this.f245644e = bVar;
            declaredField.set(this, bVar);
        } catch (Exception e16) {
            QLog.e("MatchFriendLoopScrollView", 1, "setLoopScroller fail", e16);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public void scrollTo(int i3, int i16) {
        super.scrollTo(i(i3, false), i16);
    }

    public MatchFriendLoopScrollView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f245648m = new ArrayList();
        this.C = false;
        this.D = false;
        this.E = 0;
        this.f245643d = context;
        LinearLayout linearLayout = new LinearLayout(context);
        this.f245646h = linearLayout;
        addView(linearLayout);
        f();
        h();
    }

    private void d(List<View> list, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < this.f245646h.getChildCount(); i17++) {
            View childAt = this.f245646h.getChildAt(i17);
            if (!list.contains(childAt)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i16 += childAt.getWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                childAt.layout(childAt.getLeft() + i3, childAt.getTop(), childAt.getRight() + i3, childAt.getBottom());
            }
        }
        for (View view : list) {
            view.layout(view.getLeft() - i16, view.getTop(), view.getRight() - i16, view.getBottom());
        }
    }

    private void e(List<View> list, int i3) {
        int i16 = 0;
        for (int i17 = 0; i17 < this.f245646h.getChildCount(); i17++) {
            View childAt = this.f245646h.getChildAt(i17);
            if (!list.contains(childAt)) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i16 += childAt.getWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                childAt.layout(childAt.getLeft() - i3, childAt.getTop(), childAt.getRight() - i3, childAt.getBottom());
            }
        }
        for (View view : list) {
            view.layout(view.getLeft() + i16, view.getTop(), view.getRight() + i16, view.getBottom());
        }
    }

    private boolean c(int i3, boolean z16) {
        if (i3 < 0 || (i3 == 0 && z16)) {
            return !this.D;
        }
        boolean z17 = getWidth() + i3 < (this.f245646h.getWidth() + getPaddingLeft()) + getPaddingRight();
        if (!z17) {
            if (!this.D) {
                this.f245646h.removeView(this.f245647i);
            }
            this.D = true;
        }
        return z17;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public static class b extends OverScroller {
        public b(Context context) {
            super(context);
        }

        @Override // android.widget.OverScroller
        public void fling(int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28, int i29, int i36) {
            super.fling(i3, i16, i17, i18, Integer.MIN_VALUE, Integer.MAX_VALUE, i27, i28, 0, i36);
        }
    }
}
