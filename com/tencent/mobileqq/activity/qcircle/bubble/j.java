package com.tencent.mobileqq.activity.qcircle.bubble;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0014\u0010\u0006\u001a\u00020\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002J \u0010\t\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u0005H\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\u0011\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/activity/qcircle/bubble/j;", "Lcom/tencent/mobileqq/activity/qcircle/bubble/e;", "Landroid/widget/FrameLayout$LayoutParams;", "Landroid/view/View;", "qCircleTabIconView", "", "v", "parentView", "bubbleView", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "l", "j", "Landroid/view/View;", "k", "Landroid/view/View$OnLayoutChangeListener;", "Landroid/view/View$OnLayoutChangeListener;", "qCircleTabIconLayoutChangeListener", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class j extends e {

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View bubbleView;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private View qCircleTabIconView;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final View.OnLayoutChangeListener qCircleTabIconLayoutChangeListener = new View.OnLayoutChangeListener() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.h
        @Override // android.view.View.OnLayoutChangeListener
        public final void onLayoutChange(View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
            j.x(j.this, view, i3, i16, i17, i18, i19, i26, i27, i28);
        }
    };

    private final void v(FrameLayout.LayoutParams layoutParams, View view) {
        int[] iArr = new int[2];
        view.getLocationInWindow(iArr);
        int width = view.getWidth();
        int i3 = iArr[0];
        int i16 = iArr[1];
        layoutParams.leftMargin = (i3 + (width / 2)) - (layoutParams.width / 2);
        layoutParams.topMargin = i16 - layoutParams.height;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void w(View it) {
        ViewGroup viewGroup;
        Intrinsics.checkNotNullParameter(it, "$it");
        ViewParent parent = it.getParent();
        if (parent instanceof ViewGroup) {
            viewGroup = (ViewGroup) parent;
        } else {
            viewGroup = null;
        }
        if (viewGroup != null) {
            viewGroup.removeView(it);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(j this$0, View view, int i3, int i16, int i17, int i18, int i19, int i26, int i27, int i28) {
        View view2;
        FrameLayout.LayoutParams layoutParams;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        View view3 = this$0.qCircleTabIconView;
        if (view3 == null || (view2 = this$0.bubbleView) == null) {
            return;
        }
        ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
        if (layoutParams2 instanceof FrameLayout.LayoutParams) {
            layoutParams = (FrameLayout.LayoutParams) layoutParams2;
        } else {
            layoutParams = null;
        }
        if (layoutParams != null) {
            this$0.v(layoutParams, view3);
        }
        view2.setLayoutParams(layoutParams);
    }

    @Override // com.tencent.mobileqq.activity.qcircle.bubble.e
    public boolean l() {
        if (this.bubbleView != null) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.activity.qcircle.bubble.e
    public void m() {
        final View view = this.bubbleView;
        if (view != null) {
            ThreadManagerV2.getUIHandlerV2().post(new Runnable() { // from class: com.tencent.mobileqq.activity.qcircle.bubble.i
                @Override // java.lang.Runnable
                public final void run() {
                    j.w(view);
                }
            });
            this.bubbleView = null;
            View view2 = this.qCircleTabIconView;
            if (view2 != null) {
                view2.removeOnLayoutChangeListener(this.qCircleTabIconLayoutChangeListener);
            }
            this.qCircleTabIconView = null;
        }
    }

    @Override // com.tencent.mobileqq.activity.qcircle.bubble.e
    public void n(@NotNull View parentView, @NotNull View qCircleTabIconView, @NotNull View bubbleView) {
        Intrinsics.checkNotNullParameter(parentView, "parentView");
        Intrinsics.checkNotNullParameter(qCircleTabIconView, "qCircleTabIconView");
        Intrinsics.checkNotNullParameter(bubbleView, "bubbleView");
        int measuredWidth = bubbleView.getMeasuredWidth();
        int measuredHeight = bubbleView.getMeasuredHeight();
        if (parentView instanceof FrameLayout) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(measuredWidth, measuredHeight);
            v(layoutParams, qCircleTabIconView);
            Unit unit = Unit.INSTANCE;
            ((FrameLayout) parentView).addView(bubbleView, layoutParams);
            this.bubbleView = bubbleView;
            qCircleTabIconView.addOnLayoutChangeListener(this.qCircleTabIconLayoutChangeListener);
            this.qCircleTabIconView = qCircleTabIconView;
            return;
        }
        QLog.e("QCircleTabRedPoint.BubbleEmbedViewStrategy", 1, "showBubble failed, contentFrame = " + parentView);
    }
}
