package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\fB'\b\u0007\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0012\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\u0004\b\u0016\u0010\u0017J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\b\u0010\n\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u000e\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000e\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/timi/game/ui/widget/DragViewGroup;", "Landroid/widget/RelativeLayout;", "Lcom/tencent/timi/game/ui/widget/DragViewGroup$a;", "l", "", "setTouchHookListener", "Landroid/view/MotionEvent;", "event", "", "onTouchEvent", "computeScroll", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "a", "d", "Lcom/tencent/timi/game/ui/widget/DragViewGroup$a;", "mTouchHookListener", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class DragViewGroup extends RelativeLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a mTouchHookListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H&\u00a8\u0006\f"}, d2 = {"Lcom/tencent/timi/game/ui/widget/DragViewGroup$a;", "", "Landroid/view/MotionEvent;", "event", "Lcom/tencent/timi/game/ui/widget/DragViewGroup;", "viewGroup", "", "b", "ev", "a", "", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        boolean a(@NotNull MotionEvent ev5, @NotNull DragViewGroup viewGroup);

        boolean b(@NotNull MotionEvent event, @NotNull DragViewGroup viewGroup);

        void c(@NotNull DragViewGroup viewGroup);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragViewGroup(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public final boolean a(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.View
    public void computeScroll() {
        a aVar = this.mTouchHookListener;
        if (aVar != null) {
            aVar.c(this);
        } else {
            super.computeScroll();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = this.mTouchHookListener;
        if (aVar != null) {
            return aVar.a(event, this);
        }
        return super.onInterceptTouchEvent(event);
    }

    @Override // android.view.View
    public boolean onTouchEvent(@NotNull MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        a aVar = this.mTouchHookListener;
        if (aVar != null) {
            return aVar.b(event, this);
        }
        return super.onTouchEvent(event);
    }

    public final void setTouchHookListener(@NotNull a l3) {
        Intrinsics.checkNotNullParameter(l3, "l");
        this.mTouchHookListener = l3;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragViewGroup(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ DragViewGroup(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DragViewGroup(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
