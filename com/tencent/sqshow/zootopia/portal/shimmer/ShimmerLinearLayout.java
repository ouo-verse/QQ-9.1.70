package com.tencent.sqshow.zootopia.portal.shimmer;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import tl.h;
import ua4.a;
import ua4.c;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B)\b\u0007\u0012\b\u0010,\u001a\u0004\u0018\u00010+\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010-\u0012\b\b\u0002\u0010/\u001a\u00020\n\u00a2\u0006\u0004\b0\u00101J\u0010\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0006\u001a\u00020\u0005J\u0006\u0010\u0007\u001a\u00020\u0005J0\u0010\u000f\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\nH\u0014J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\nH\u0014J\b\u0010\u0014\u001a\u00020\u0005H\u0014J\b\u0010\u0015\u001a\u00020\u0005H\u0014J\u0010\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0016H\u0014J\u0010\u0010\u001b\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0014R\u0014\u0010\u001e\u001a\u00020\u001c8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001dR\u0014\u0010\"\u001a\u00020\u001f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010%\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010$R\u0016\u0010'\u001a\u00020\b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b&\u0010$R\u0014\u0010*\u001a\u00020\b8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b(\u0010)\u00a8\u00062"}, d2 = {"Lcom/tencent/sqshow/zootopia/portal/shimmer/ShimmerLinearLayout;", "Landroid/widget/LinearLayout;", "Lua4/a;", "shimmer", "b", "", "c", "d", "", "changed", "", "left", "top", "right", "bottom", "onLayout", "Landroid/view/View;", "changedView", "visibility", "onVisibilityChanged", NodeProps.ON_ATTACHED_TO_WINDOW, NodeProps.ON_DETACHED_FROM_WINDOW, "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "Landroid/graphics/drawable/Drawable;", "who", "verifyDrawable", "Landroid/graphics/Paint;", "Landroid/graphics/Paint;", "mContentPaint", "Lua4/c;", "e", "Lua4/c;", "mShimmerDrawable", "f", "Z", "mShowShimmer", h.F, "mStoppedShimmerBecauseVisibility", "a", "()Z", "isShimmerStarted", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class ShimmerLinearLayout extends LinearLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private final Paint mContentPaint;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final c mShimmerDrawable;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private boolean mShowShimmer;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean mStoppedShimmerBecauseVisibility;

    public ShimmerLinearLayout(Context context) {
        this(context, null, 0, 6, null);
    }

    private final boolean a() {
        return this.mShimmerDrawable.b();
    }

    private final ShimmerLinearLayout b(a shimmer) {
        this.mShimmerDrawable.f(shimmer);
        setLayerType(2, this.mContentPaint);
        return this;
    }

    public final void d() {
        if (this.mShowShimmer) {
            this.mStoppedShimmerBecauseVisibility = false;
            this.mShowShimmer = false;
            this.mShimmerDrawable.h();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        if (this.mShowShimmer) {
            this.mShimmerDrawable.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.mShimmerDrawable.d();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        this.mShimmerDrawable.setBounds(0, 0, getWidth(), getHeight());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View changedView, int visibility) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, visibility);
        c cVar = this.mShimmerDrawable;
        if (cVar == null) {
            return;
        }
        if (visibility != 0) {
            if (a()) {
                d();
                this.mStoppedShimmerBecauseVisibility = true;
                return;
            }
            return;
        }
        if (this.mStoppedShimmerBecauseVisibility) {
            cVar.d();
            this.mStoppedShimmerBecauseVisibility = false;
        }
    }

    @Override // android.view.View
    protected boolean verifyDrawable(Drawable who) {
        Intrinsics.checkNotNullParameter(who, "who");
        return super.verifyDrawable(who) || who == this.mShimmerDrawable;
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public final void c() {
        this.mShowShimmer = true;
        this.mShimmerDrawable.g();
    }

    public /* synthetic */ ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    public ShimmerLinearLayout(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.mContentPaint = new Paint();
        c cVar = new c();
        this.mShimmerDrawable = cVar;
        this.mShowShimmer = true;
        setWillNotDraw(false);
        cVar.setCallback(this);
        b(new a());
    }
}
