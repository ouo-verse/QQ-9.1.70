package androidx.recyclerview.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.qq.e.comm.managers.plugin.PM;
import com.tencent.aio.api.list.p;
import com.tencent.aio.exception.AIOException;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.kuikly.core.views.ScrollerAttr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000x\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 B2\u00020\u00012\u00020\u00022\u00020\u0003:\u0001BB9\b\u0007\u0012\u0006\u0010<\u001a\u00020;\u0012\n\b\u0002\u0010>\u001a\u0004\u0018\u00010=\u0012\b\b\u0002\u0010?\u001a\u00020\u0012\u0012\u0010\b\u0002\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u000104\u00a2\u0006\u0004\b@\u0010AJ\u0014\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0017J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u0012H\u0016J\b\u0010\u0016\u001a\u00020\u0015H\u0016J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0012H\u0016J\u0010\u0010\u001c\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u001aH\u0014J\u000f\u0010\u001f\u001a\u00020\u0006H\u0000\u00a2\u0006\u0004\b\u001d\u0010\u001eR\"\u0010 \u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010&\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b&\u0010!\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010*\u001a\b\u0012\u0004\u0012\u00020\u000b0)8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b*\u0010+R\u001a\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000f0,8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00188\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b/\u0010!\u001a\u0004\b0\u0010#\"\u0004\b1\u0010%R\u0014\u00102\u001a\u00020\b8\u0002X\u0083\u0004\u00a2\u0006\u0006\n\u0004\b2\u00103R*\u00105\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001048\u0006@\u0006X\u0086\u000e\u00a2\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:\u00a8\u0006C"}, d2 = {"Landroidx/recyclerview/widget/AIORecycleView;", "Landroidx/recyclerview/widget/InnerAIORecycleView;", "Landroidx/core/view/NestedScrollingChild3;", "", "", "msg", "", "checkLegal", "Landroid/view/View$OnTouchListener;", "l", "setOnTouchListener", "Landroidx/recyclerview/widget/OnAIOTouchListener;", "listener", "addOnTouchListener", "removeOnTouchListener", "Lcom/tencent/aio/api/list/p;", "addOnDispatchDrawListener", "removeOnDispatchDrawListener", "", "size", "setItemViewCacheSize", "Landroidx/recyclerview/widget/AIOLayoutManager;", "getLayoutManager", "direction", "", "canScrollVertically", "Landroid/graphics/Canvas;", PM.CANVAS, "dispatchDraw", "prepareForFastScroll$sdk_debug", "()V", "prepareForFastScroll", ScrollerAttr.SCROLL_ENABLED, "Z", "getScrollEnabled$sdk_debug", "()Z", "setScrollEnabled$sdk_debug", "(Z)V", "coreOperationFlag", "getCoreOperationFlag$sdk_debug", "setCoreOperationFlag$sdk_debug", "", "observerTouchListener", "Ljava/util/List;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "dispatchDrawListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "firstValidDraw", "getFirstValidDraw$sdk_debug", "setFirstValidDraw$sdk_debug", "touchListener", "Landroid/view/View$OnTouchListener;", "Lkotlin/Function0;", "firstEffectiveDrawInvoke", "Lkotlin/jvm/functions/Function0;", "getFirstEffectiveDrawInvoke", "()Lkotlin/jvm/functions/Function0;", "setFirstEffectiveDrawInvoke", "(Lkotlin/jvm/functions/Function0;)V", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", Node.ATTRS_ATTR, "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;ILkotlin/jvm/functions/Function0;)V", "Companion", "sdk_debug"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes.dex */
public final class AIORecycleView extends InnerAIORecycleView {
    public static final int DEFAULT_CACHE_SIZE = 4;
    private static final String TAG = "AIORecycleView";
    private boolean coreOperationFlag;
    private final CopyOnWriteArrayList<p> dispatchDrawListeners;

    @Nullable
    private Function0<Unit> firstEffectiveDrawInvoke;
    private boolean firstValidDraw;
    private final List<OnAIOTouchListener> observerTouchListener;
    private boolean scrollEnabled;

    @SuppressLint({"ClickableViewAccessibility"})
    private final View.OnTouchListener touchListener;

    @JvmOverloads
    public AIORecycleView(@NotNull Context context) {
        this(context, null, 0, null, 14, null);
    }

    private final void checkLegal(String msg2) {
        if (!this.coreOperationFlag) {
            if (msg2 == null) {
                msg2 = "cant not invoke, this only can be invoked by core";
            }
            throw new AIOException(msg2);
        }
    }

    static /* synthetic */ void checkLegal$default(AIORecycleView aIORecycleView, String str, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = null;
        }
        aIORecycleView.checkLegal(str);
    }

    public void addOnDispatchDrawListener(@NotNull p listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dispatchDrawListeners.add(listener);
    }

    public void addOnTouchListener(@NotNull OnAIOTouchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.observerTouchListener.add(listener);
    }

    @Override // android.view.View
    public boolean canScrollVertically(int direction) {
        if (this.scrollEnabled && super.canScrollVertically(direction)) {
            return true;
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        super.dispatchDraw(canvas);
        for (p pVar : this.dispatchDrawListeners) {
            canvas.save();
            pVar.dispatchDraw(canvas);
            canvas.restore();
        }
        if (getChildCount() > 0) {
            com.tencent.aio.pref.a.f69788j.f();
        }
    }

    /* renamed from: getCoreOperationFlag$sdk_debug, reason: from getter */
    public final boolean getCoreOperationFlag() {
        return this.coreOperationFlag;
    }

    @Nullable
    public final Function0<Unit> getFirstEffectiveDrawInvoke() {
        return this.firstEffectiveDrawInvoke;
    }

    /* renamed from: getFirstValidDraw$sdk_debug, reason: from getter */
    public final boolean getFirstValidDraw() {
        return this.firstValidDraw;
    }

    /* renamed from: getScrollEnabled$sdk_debug, reason: from getter */
    public final boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    public final void prepareForFastScroll$sdk_debug() {
        stopScroll();
        removeAndRecycleViews();
        this.mAdapterHelper.reset();
        RecyclerView.Recycler recycler = this.mRecycler;
        RecyclerView.Adapter adapter = this.mAdapter;
        recycler.onAdapterChanged(adapter, adapter, false);
        this.mState.mStructureChanged = true;
        this.mChildHelper.removeAllViewsUnfiltered();
        this.mRecycler.updateViewCacheSize();
    }

    public void removeOnDispatchDrawListener(@NotNull p listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.dispatchDrawListeners.remove(listener);
    }

    public void removeOnTouchListener(@NotNull OnAIOTouchListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.observerTouchListener.remove(listener);
    }

    public final void setCoreOperationFlag$sdk_debug(boolean z16) {
        this.coreOperationFlag = z16;
    }

    public final void setFirstEffectiveDrawInvoke(@Nullable Function0<Unit> function0) {
        this.firstEffectiveDrawInvoke = function0;
    }

    public final void setFirstValidDraw$sdk_debug(boolean z16) {
        this.firstValidDraw = z16;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setItemViewCacheSize(int size) {
        checkLegal$default(this, null, 1, null);
        super.setItemViewCacheSize(size);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public void setOnTouchListener(@Nullable View.OnTouchListener l3) {
        super.setOnTouchListener(l3);
    }

    public final void setScrollEnabled$sdk_debug(boolean z16) {
        this.scrollEnabled = z16;
    }

    @JvmOverloads
    public AIORecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, null, 12, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    @NotNull
    public AIOLayoutManager getLayoutManager() {
        RecyclerView.LayoutManager layoutManager = super.getLayoutManager();
        if (layoutManager != null) {
            return (AIOLayoutManager) layoutManager;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.AIOLayoutManager");
    }

    @JvmOverloads
    public AIORecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3) {
        this(context, attributeSet, i3, null, 8, null);
    }

    public /* synthetic */ AIORecycleView(Context context, AttributeSet attributeSet, int i3, Function0 function0, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3, (i16 & 8) != 0 ? null : function0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AIORecycleView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i3, @Nullable Function0<Unit> function0) {
        super(context, attributeSet, i3);
        Intrinsics.checkNotNullParameter(context, "context");
        this.firstEffectiveDrawInvoke = function0;
        this.scrollEnabled = true;
        this.observerTouchListener = new ArrayList();
        this.dispatchDrawListeners = new CopyOnWriteArrayList<>();
        this.touchListener = new View.OnTouchListener() { // from class: androidx.recyclerview.widget.AIORecycleView$touchListener$1
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                List list;
                list = AIORecycleView.this.observerTouchListener;
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    if (((OnAIOTouchListener) it.next()).onTouch(view, motionEvent)) {
                        return true;
                    }
                }
                return false;
            }
        };
        com.tencent.aio.base.b.b(this, new Function1<AIORecycleView, Unit>() { // from class: androidx.recyclerview.widget.AIORecycleView.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(AIORecycleView aIORecycleView) {
                invoke2(aIORecycleView);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull AIORecycleView receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                receiver.setOnTouchListener(receiver.touchListener);
            }
        });
    }
}
