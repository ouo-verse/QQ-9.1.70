package com.tencent.mobileqq.matchfriend.reborn.content.main.framework.widget.carousel;

import android.animation.ValueAnimator;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorEvent;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002:\u0001.B\u000f\u0012\u0006\u0010+\u001a\u00020*\u00a2\u0006\u0004\b,\u0010-J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0005\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0003H\u0002J\u0010\u0010\t\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u0007J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0014J0\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0013\u001a\u00020\nH\u0014J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0017\u001a\u00020\u0003J\b\u0010\u0018\u001a\u00020\u0003H\u0016J\b\u0010\u0019\u001a\u00020\u0003H\u0014R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR&\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u001fR\u0016\u0010\"\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0016\u0010!R\u0016\u0010$\u001a\u00020\n8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0004\u0010#R\u0016\u0010%\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010!R\u0018\u0010)\u001a\u0004\u0018\u00010&8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b'\u0010(\u00a8\u0006/"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout;", "Landroid/widget/FrameLayout;", "Ljava/lang/Runnable;", "", h.F, "e", "g", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout$a;", "adapter", "setAdapter", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "", "changed", "left", "top", "right", "bottom", "onLayout", "j", "f", "i", TencentLocation.RUN_MODE, NodeProps.ON_DETACHED_FROM_WINDOW, "d", "Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout$a;", "Ljava/util/ArrayList;", "Landroid/view/View;", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "childrenViews", "Z", "isFirstLayout", "I", "overLap", "isAnimal", "Landroid/animation/ValueAnimator;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "Landroid/animation/ValueAnimator;", "valueAnimator", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "a", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class CarouselLayout extends FrameLayout implements Runnable {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private a adapter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private ArrayList<View> childrenViews;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean isFirstLayout;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int overLap;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private boolean isAnimal;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    private ValueAnimator valueAnimator;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0007\u001a\u00020\u0006H&J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004H&\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/main/framework/widget/carousel/CarouselLayout$a;", "", "Landroid/content/Context;", "context", "Landroid/view/View;", HippyEngineMonitorEvent.MODULE_LOAD_EVENT_CREATE_VIEW, "", "a", "view", "", "bindView", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes33.dex */
    public interface a {
        int a();

        void bindView(View view);

        View createView(Context context);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CarouselLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.childrenViews = new ArrayList<>();
        this.isFirstLayout = true;
    }

    private final void g() {
        ValueAnimator valueAnimator = this.valueAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.valueAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        removeCallbacks(this);
        this.isAnimal = false;
    }

    private final void h() {
        View view = this.childrenViews.get(0);
        view.setTranslationX(0.0f);
        view.setScaleX(1.0f);
        view.setScaleY(1.0f);
        view.setAlpha(1.0f);
        view.bringToFront();
        View view2 = this.childrenViews.get(1);
        view2.setTranslationX(view2.getMeasuredWidth() - this.overLap);
        view2.bringToFront();
        view2.setScaleX(1.0f);
        view2.setScaleY(1.0f);
        view2.setAlpha(1.0f);
        view2.bringToFront();
        View view3 = this.childrenViews.get(2);
        view3.setTranslationX(getMeasuredWidth() - view3.getMeasuredWidth());
        view3.setScaleY(1.0f);
        view3.setScaleX(1.0f);
        view3.setAlpha(1.0f);
        view3.bringToFront();
        View view4 = this.childrenViews.get(3);
        view4.setTranslationX(getMeasuredWidth() - view4.getMeasuredWidth());
        view4.setScaleX(1.0f);
        view4.setScaleY(1.0f);
        view4.setAlpha(1.0f);
        view4.setAlpha(0.0f);
        view4.bringToFront();
    }

    public final void f() {
        if (this.isAnimal) {
            g();
        }
    }

    public final void i() {
        if (this.isAnimal) {
            return;
        }
        j();
    }

    public final void j() {
        if (this.isAnimal) {
            return;
        }
        e();
        this.isAnimal = true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        g();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        if (this.isFirstLayout && (!this.childrenViews.isEmpty())) {
            this.isFirstLayout = false;
            h();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        ArrayList<View> arrayList = this.childrenViews;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        setMeasuredDimension((this.childrenViews.get(0).getMeasuredWidth() * 3) - (this.overLap * 2), View.MeasureSpec.getSize(heightMeasureSpec));
    }

    @Override // java.lang.Runnable
    public void run() {
        e();
    }

    public final void setAdapter(a adapter) {
        g();
        this.adapter = adapter;
        removeAllViews();
        this.childrenViews.clear();
        if (adapter != null) {
            for (int i3 = 0; i3 < 4; i3++) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                View createView = adapter.createView(context);
                addView(createView);
                adapter.bindView(createView);
                this.childrenViews.add(createView);
            }
            this.overLap = adapter.a();
            requestLayout();
        }
    }

    private final void e() {
    }
}
