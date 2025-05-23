package com.tencent.kuikly.core.render.android.expand.component.list;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0018\u001a\u00020\u0016\u00a2\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\u000e\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u0004H\u0002J\u000e\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0004J\u0016\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bR\u0016\u0010\u0012\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0013\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0011R\u0016\u0010\u0014\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011R\u0016\u0010\u0015\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00168\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0017\u00a8\u0006\u001b"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/k;", "", "Landroid/view/MotionEvent;", "e", "", "actionIndex", "", "b", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "recyclerView", "", "c", "event", "activeIndex", "d", "slopConstant", "a", "I", "scrollPointerId", "initialTouchX", "initialTouchY", "touchSlop", "Landroid/content/Context;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class k {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private int scrollPointerId;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int initialTouchX;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int initialTouchY;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private final Context context;

    public k(@NotNull Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.context = context;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
    }

    private final void b(MotionEvent e16, int actionIndex) {
        this.scrollPointerId = e16.getPointerId(actionIndex);
        this.initialTouchX = (int) (e16.getX() + 0.5f);
        this.initialTouchY = (int) (e16.getY() + 0.5f);
    }

    private final boolean c(KRRecyclerView recyclerView, MotionEvent e16) {
        RecyclerView.LayoutManager layoutManager;
        int findPointerIndex = e16.findPointerIndex(this.scrollPointerId);
        boolean z16 = false;
        if (findPointerIndex >= 0 && (layoutManager = recyclerView.getLayoutManager()) != null) {
            Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager ?: return false");
            boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
            boolean canScrollVertically = layoutManager.canScrollVertically();
            int x16 = (int) (e16.getX(findPointerIndex) + 0.5f);
            int y16 = (int) (e16.getY(findPointerIndex) + 0.5f);
            if (recyclerView.getScrollState() != 1) {
                int i3 = x16 - this.initialTouchX;
                int i16 = y16 - this.initialTouchY;
                if (canScrollHorizontally && Math.abs(i3) > this.touchSlop && Math.abs(i3) > Math.abs(i16)) {
                    z16 = true;
                }
                if (canScrollVertically && Math.abs(i16) > this.touchSlop && Math.abs(i16) > Math.abs(i3)) {
                    z16 = true;
                }
                return !z16;
            }
        }
        return false;
    }

    private final void d(MotionEvent event, int activeIndex) {
        int i3;
        if (event.getPointerId(activeIndex) == this.scrollPointerId) {
            if (activeIndex == 0) {
                i3 = 1;
            } else {
                i3 = 0;
            }
            this.scrollPointerId = event.getPointerId(i3);
            this.initialTouchX = (int) (event.getX() + 0.5f);
            this.initialTouchY = (int) (event.getY() + 0.5f);
        }
    }

    public final boolean a(@NotNull MotionEvent e16, @NotNull KRRecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(e16, "e");
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        int actionIndex = e16.getActionIndex();
        int actionMasked = e16.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 2) {
                if (actionMasked != 5) {
                    if (actionMasked != 6) {
                        return false;
                    }
                    d(e16, actionIndex);
                    return false;
                }
                b(e16, actionIndex);
                return false;
            }
            return c(recyclerView, e16);
        }
        b(e16, actionIndex);
        return false;
    }

    public final void e(int slopConstant) {
        int scaledTouchSlop;
        ViewConfiguration vc5 = ViewConfiguration.get(this.context);
        if (slopConstant != 0) {
            if (slopConstant != 1) {
                Intrinsics.checkNotNullExpressionValue(vc5, "vc");
                scaledTouchSlop = vc5.getScaledTouchSlop();
            } else {
                Intrinsics.checkNotNullExpressionValue(vc5, "vc");
                scaledTouchSlop = vc5.getScaledPagingTouchSlop();
            }
        } else {
            Intrinsics.checkNotNullExpressionValue(vc5, "vc");
            scaledTouchSlop = vc5.getScaledTouchSlop();
        }
        this.touchSlop = scaledTouchSlop;
    }
}
