package com.tencent.mobileqq.guild.media.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001/B'\b\u0007\u0012\u0006\u0010)\u001a\u00020(\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010*\u0012\b\b\u0002\u0010,\u001a\u00020\u0006\u00a2\u0006\u0004\b-\u0010.J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0006H\u0014J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0006H\u0016J0\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0006H\u0016J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0013J\u0012\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H\u0016R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR$\u0010$\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0016\u0010'\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b%\u0010&\u00a8\u00060"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView;", "Landroidx/core/widget/NestedScrollView;", "Landroid/view/View;", "view", "", "t", "", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "velocityY", "fling", "target", "dx", "dy", "", "consumed", "type", "onNestedPreScroll", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView$a;", "listener", "setDispatchTouchListener", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "d", "Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView$a;", "dispatchTouchEventListener", "Landroidx/recyclerview/widget/RecyclerView;", "e", "Landroidx/recyclerview/widget/RecyclerView;", "u", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "recyclerView", "f", "I", "topContentHeight", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes14.dex */
public final class GuildNestedScrollView extends NestedScrollView {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private a dispatchTouchEventListener;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private RecyclerView recyclerView;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private int topContentHeight;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/mobileqq/guild/media/widget/GuildNestedScrollView$a;", "", "Landroid/view/MotionEvent;", "ev", "", "dispatchTouchEvent", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes14.dex */
    public interface a {
        boolean dispatchTouchEvent(@Nullable MotionEvent ev5);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNestedScrollView(@NotNull Context context) {
        this(context, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    private final void t(View view) {
        View view2;
        if (view != null && !Intrinsics.areEqual(view, this) && !(view instanceof GuildNestedScrollView)) {
            this.topContentHeight += view.getTop();
            Object parent = view.getParent();
            if (parent instanceof View) {
                view2 = (View) parent;
            } else {
                view2 = null;
            }
            t(view2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(@Nullable MotionEvent ev5) {
        a aVar = this.dispatchTouchEventListener;
        boolean z16 = false;
        if (aVar != null && aVar.dispatchTouchEvent(ev5)) {
            z16 = true;
        }
        if (z16) {
            return true;
        }
        return super.dispatchTouchEvent(ev5);
    }

    @Override // androidx.core.widget.NestedScrollView
    public void fling(int velocityY) {
        if (this.recyclerView == null) {
            super.fling(velocityY);
            return;
        }
        if (getScrollY() < this.topContentHeight) {
            int scrollY = getScrollY() + velocityY;
            int i3 = this.topContentHeight;
            if (scrollY <= i3) {
                super.fling(velocityY);
                return;
            }
            int scrollY2 = i3 - getScrollY();
            if (velocityY > 0) {
                super.fling(scrollY2);
            } else {
                super.fling(-scrollY2);
            }
            int i16 = velocityY - scrollY2;
            if (velocityY > 0) {
                RecyclerView recyclerView = this.recyclerView;
                Intrinsics.checkNotNull(recyclerView);
                recyclerView.fling(0, i16);
                return;
            } else {
                RecyclerView recyclerView2 = this.recyclerView;
                Intrinsics.checkNotNull(recyclerView2);
                recyclerView2.fling(0, -i16);
                return;
            }
        }
        super.fling(velocityY);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.core.widget.NestedScrollView, android.widget.FrameLayout, android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.topContentHeight = 0;
        t(this.recyclerView);
    }

    @Override // androidx.core.widget.NestedScrollView, androidx.core.view.NestedScrollingParent2
    public void onNestedPreScroll(@NotNull View target, int dx5, int dy5, @NotNull int[] consumed, int type) {
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(consumed, "consumed");
        if (this.recyclerView == null) {
            super.onNestedPreScroll(target, dx5, dy5, consumed, type);
            return;
        }
        if (getScrollY() == 0 && dy5 < 0) {
            super.onNestedPreScroll(target, dx5, dy5, consumed, type);
            return;
        }
        if (getScrollY() < this.topContentHeight) {
            int scrollY = getScrollY() + dy5;
            int i3 = this.topContentHeight;
            if (scrollY < i3) {
                scrollBy(0, dy5);
                consumed[1] = dy5;
                return;
            } else {
                int scrollY2 = i3 - getScrollY();
                scrollBy(0, scrollY2);
                consumed[1] = scrollY2;
                return;
            }
        }
        super.onNestedPreScroll(target, dx5, dy5, consumed, type);
    }

    public final void setDispatchTouchListener(@NotNull a listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dispatchTouchEventListener = listener;
    }

    public final void setRecyclerView(@Nullable RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
    }

    @Nullable
    /* renamed from: u, reason: from getter */
    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNestedScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ GuildNestedScrollView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public GuildNestedScrollView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
