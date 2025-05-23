package com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.HorizontalScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J(\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0002H\u0014J\u0010\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u000f"}, d2 = {"com/tencent/mobileqq/qqvideoedit/editor/clipping/timeline/widget/dragdrop/DragDropScrollView$createHorizontalScrollView$1", "Landroid/widget/HorizontalScrollView;", "", "l", "t", "oldl", "oldt", "", "onScrollChanged", "velocityX", "fling", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "d", "Landroidx/dynamicanimation/animation/DynamicAnimation$OnAnimationUpdateListener;", "listener", "qqvideoedit_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes17.dex */
public final class DragDropScrollView$createHorizontalScrollView$1 extends HorizontalScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final DynamicAnimation.OnAnimationUpdateListener listener;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ DragDropScrollView f275401e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DragDropScrollView$createHorizontalScrollView$1(DragDropScrollView dragDropScrollView, Context context) {
        super(context);
        this.f275401e = dragDropScrollView;
        this.listener = new DynamicAnimation.OnAnimationUpdateListener() { // from class: com.tencent.mobileqq.qqvideoedit.editor.clipping.timeline.widget.dragdrop.e
            @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationUpdateListener
            public final void onAnimationUpdate(DynamicAnimation dynamicAnimation, float f16, float f17) {
                DragDropScrollView$createHorizontalScrollView$1.b(DragDropScrollView$createHorizontalScrollView$1.this, dynamicAnimation, f16, f17);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(DragDropScrollView$createHorizontalScrollView$1 this$0, DynamicAnimation dynamicAnimation, float f16, float f17) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.scrollTo((int) f16, this$0.getScrollY());
    }

    @Override // android.widget.HorizontalScrollView
    public void fling(int velocityX) {
        f fVar;
        tj2.a h16;
        fVar = this.f275401e.dragDropScrollViewController;
        if (fVar != null && (h16 = fVar.h()) != null) {
            float scrollX = getScrollX();
            Intrinsics.checkNotNull(this.f275401e.getContentView());
            h16.b(velocityX, scrollX, r2.getMeasuredWidth(), this.listener);
        }
    }

    @Override // android.view.View
    protected void onScrollChanged(int l3, int t16, int oldl, int oldt) {
        f fVar;
        DragEventHandler dragEventHandler;
        super.onScrollChanged(l3, t16, oldl, oldt);
        BottomLineRelativeLayout contentView = this.f275401e.getContentView();
        if (contentView != null) {
            int childCount = contentView.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                KeyEvent.Callback childAt = contentView.getChildAt(i3);
                if (childAt != null) {
                    Intrinsics.checkNotNullExpressionValue(childAt, "getChildAt(i)");
                    if (childAt instanceof m) {
                        ((m) childAt).c(this, l3, t16, oldl, oldt);
                    }
                }
            }
        }
        fVar = this.f275401e.dragDropScrollViewController;
        if (fVar != null) {
            fVar.s(l3);
        }
        dragEventHandler = this.f275401e.dragEventHandler;
        dragEventHandler.F(l3, t16, oldl, oldt);
    }
}
