package com.qzone.module.feedcomponent.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000e"}, d2 = {"Lcom/qzone/module/feedcomponent/ui/FrdHotVideoRecyclerView;", "Landroidx/recyclerview/widget/RecyclerView;", "context", "Landroid/content/Context;", Node.ATTRS_ATTR, "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "lastX", "", "lastY", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes39.dex */
public final class FrdHotVideoRecyclerView extends RecyclerView {
    private float lastX;
    private float lastY;

    public /* synthetic */ FrdHotVideoRecyclerView(Context context, AttributeSet attributeSet, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev5) {
        Intrinsics.checkNotNullParameter(ev5, "ev");
        if (ev5.getAction() == 0) {
            this.lastX = ev5.getX();
            this.lastY = ev5.getY();
            getParent().requestDisallowInterceptTouchEvent(true);
        } else if (ev5.getAction() == 2) {
            float x16 = ev5.getX();
            float y16 = ev5.getY();
            float abs = Math.abs(x16 - this.lastX);
            float abs2 = Math.abs(y16 - this.lastY);
            int scaledTouchSlop = ViewConfiguration.get(getContext()).getScaledTouchSlop();
            if (canScrollHorizontally(-1)) {
                float f16 = scaledTouchSlop;
                if (abs >= f16) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                } else if (abs2 >= f16) {
                    getParent().requestDisallowInterceptTouchEvent(false);
                }
            } else {
                getParent().requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.dispatchTouchEvent(ev5);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FrdHotVideoRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
