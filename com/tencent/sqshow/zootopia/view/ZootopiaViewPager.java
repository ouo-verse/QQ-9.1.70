package com.tencent.sqshow.zootopia.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.viewpager.widget.ViewPager;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.biz.pubaccount.weishi.event.WSComboHomePageChangeEvent;
import com.tencent.mobileqq.activity.fling.TopGestureLayout;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00192\u00020\u0001:\u0001\u0007B\u0019\u0012\u0006\u0010\u0014\u001a\u00020\u0013\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015\u00a2\u0006\u0004\b\u0017\u0010\u0018J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\n\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\n\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0014R\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u001a"}, d2 = {"Lcom/tencent/sqshow/zootopia/view/ZootopiaViewPager;", "Landroidx/viewpager/widget/ViewPager;", "", "enableGesture", "", "c", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "b", "Landroid/view/MotionEvent;", "ev", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "onTouchEvent", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "d", "Lcom/tencent/mobileqq/activity/fling/TopGestureLayout;", "topGestureLayout", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "e", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ZootopiaViewPager extends ViewPager {

    /* renamed from: f, reason: collision with root package name */
    private static final String f373339f = "ZootopiaViewPager";

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private TopGestureLayout topGestureLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZootopiaViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        addOnPageChangeListener(new a());
    }

    private final TopGestureLayout b() {
        TopGestureLayout topGestureLayout = this.topGestureLayout;
        if (topGestureLayout != null) {
            return topGestureLayout;
        }
        Context context = getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        if (activity == null) {
            return null;
        }
        View decorView = activity.getWindow().getDecorView();
        ViewGroup viewGroup = decorView instanceof ViewGroup ? (ViewGroup) decorView : null;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        KeyEvent.Callback callback = null;
        for (int i3 = 0; i3 < childCount; i3++) {
            callback = viewGroup.getChildAt(i3);
            boolean z16 = callback instanceof DragFrameLayout;
            if (z16) {
                DragFrameLayout dragFrameLayout = z16 ? (DragFrameLayout) callback : null;
                callback = dragFrameLayout != null ? dragFrameLayout.getChildAt(0) : null;
            }
            if (callback instanceof TopGestureLayout) {
                break;
            }
        }
        TopGestureLayout topGestureLayout2 = callback instanceof TopGestureLayout ? (TopGestureLayout) callback : null;
        this.topGestureLayout = topGestureLayout2;
        return topGestureLayout2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c(boolean enableGesture) {
        TopGestureLayout b16 = b();
        if (b16 != null) {
            b16.setInterceptTouchFlag(enableGesture);
        }
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev5) {
        try {
            return super.onInterceptTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            QLog.e(f373339f, 1, "onInterceptTouchEvent error");
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int childCount = getChildCount();
        int i3 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt = getChildAt(i16);
            childAt.measure(widthMeasureSpec, ViewGroup.getChildMeasureSpec(heightMeasureSpec, getPaddingTop() + getPaddingBottom(), childAt.getLayoutParams().height));
            i3 = Math.max(i3, childAt.getMeasuredHeight());
        }
        super.onMeasure(widthMeasureSpec, View.MeasureSpec.makeMeasureSpec(i3, 1073741824));
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    public boolean onTouchEvent(MotionEvent ev5) {
        try {
            return super.onTouchEvent(ev5);
        } catch (IllegalArgumentException unused) {
            QLog.e(f373339f, 1, "onTouchEvent error");
            return false;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0002H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/view/ZootopiaViewPager$a", "Landroidx/viewpager/widget/ViewPager$OnPageChangeListener;", "", "position", "", "positionOffset", "positionOffsetPixels", "", WSComboHomePageChangeEvent.EVENT_ON_PAGE_SCROLLED, "onPageSelected", "state", "onPageScrollStateChanged", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class a implements ViewPager.OnPageChangeListener {
        a() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int position) {
            ZootopiaViewPager.this.c(position == 0);
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int state) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }
    }
}
