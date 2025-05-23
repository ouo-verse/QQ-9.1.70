package com.tencent.kuikly.core.render.android.expand.component.list;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010$\u001a\u00020\u0010\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0002H\u0002J\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\"\u0010\u0013\u001a\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u00100\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0005\u0010\u0012R\u0016\u0010\u0015\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\n\u0010\u0014R\u0016\u0010\u0016\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0014R\u0016\u0010\u0017\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0014R\u0016\u0010\u0018\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0014R\u0014\u0010\u001c\u001a\u00020\u00198\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0016\u0010#\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\"\u00a8\u0006'"}, d2 = {"Lcom/tencent/kuikly/core/render/android/expand/component/list/h;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/c;", "Landroid/view/MotionEvent;", "event", "", "a", "e", "", "actionIndex", "", "b", "c", "activeIndex", "d", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "Ljava/lang/ref/WeakReference;", "Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;", "kotlin.jvm.PlatformType", "Ljava/lang/ref/WeakReference;", "recyclerViewWeakRef", "I", "scrollPointerId", "initialTouchX", "initialTouchY", "touchSlop", "", "f", "[I", "locationArray", "Landroid/graphics/Rect;", "g", "Landroid/graphics/Rect;", "hitRect", tl.h.F, "Z", "isPointInside", "recyclerView", "<init>", "(Lcom/tencent/kuikly/core/render/android/expand/component/list/KRRecyclerView;)V", "core-render-android_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes7.dex */
public final class h implements c {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final WeakReference<KRRecyclerView> recyclerViewWeakRef;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private int scrollPointerId;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private int initialTouchX;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private int initialTouchY;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private int touchSlop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private final int[] locationArray;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private final Rect hitRect;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private boolean isPointInside;

    public h(@NotNull KRRecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.recyclerViewWeakRef = new WeakReference<>(recyclerView);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(recyclerView.getContext());
        Intrinsics.checkNotNullExpressionValue(viewConfiguration, "ViewConfiguration.get(recyclerView.context)");
        this.touchSlop = viewConfiguration.getScaledTouchSlop();
        this.locationArray = new int[2];
        this.hitRect = new Rect();
    }

    private final boolean a(MotionEvent event) {
        KRRecyclerView kRRecyclerView = this.recyclerViewWeakRef.get();
        if (kRRecyclerView == null) {
            return false;
        }
        Intrinsics.checkNotNullExpressionValue(kRRecyclerView, "recyclerViewWeakRef.get() ?: return false");
        kRRecyclerView.getLocationOnScreen(this.locationArray);
        kRRecyclerView.getHitRect(this.hitRect);
        Rect rect = this.hitRect;
        int i3 = rect.bottom - rect.top;
        int i16 = rect.right - rect.left;
        int[] iArr = this.locationArray;
        int i17 = iArr[0];
        int i18 = iArr[1];
        return new Rect(i17, i18, i16 + i17, i3 + i18).contains((int) event.getRawX(), (int) event.getRawY());
    }

    private final void b(MotionEvent e16, int actionIndex) {
        this.scrollPointerId = e16.getPointerId(actionIndex);
        this.initialTouchX = (int) (e16.getX() + 0.5f);
        this.initialTouchY = (int) (e16.getY() + 0.5f);
    }

    private final boolean c(MotionEvent e16) {
        RecyclerView.LayoutManager layoutManager;
        boolean z16;
        KRRecyclerView kRRecyclerView = this.recyclerViewWeakRef.get();
        if (kRRecyclerView != null) {
            Intrinsics.checkNotNullExpressionValue(kRRecyclerView, "recyclerViewWeakRef.get() ?: return false");
            if (Intrinsics.areEqual(kRRecyclerView.getCom.tencent.kuikly.core.views.ScrollerAttr.SCROLL_WITH_PARENT java.lang.String(), Boolean.FALSE)) {
                return true;
            }
            int findPointerIndex = e16.findPointerIndex(this.scrollPointerId);
            if (findPointerIndex >= 0 && (layoutManager = kRRecyclerView.getLayoutManager()) != null) {
                Intrinsics.checkNotNullExpressionValue(layoutManager, "recyclerView.layoutManager ?: return false");
                boolean canScrollHorizontally = layoutManager.canScrollHorizontally();
                boolean canScrollVertically = layoutManager.canScrollVertically();
                int x16 = (int) (e16.getX(findPointerIndex) + 0.5f);
                int y16 = (int) (e16.getY(findPointerIndex) + 0.5f);
                int i3 = x16 - this.initialTouchX;
                int i16 = y16 - this.initialTouchY;
                if (canScrollHorizontally && Math.abs(i3) > this.touchSlop && Math.abs(i3) > Math.abs(i16)) {
                    return true;
                }
                if (canScrollVertically && Math.abs(i16) > this.touchSlop && Math.abs(i16) > Math.abs(i3)) {
                    if (i16 > 0 && kRRecyclerView.getContentOffsetY() <= 0.0f) {
                        return false;
                    }
                    if (i16 < 0) {
                        if (kRRecyclerView.computeVerticalScrollExtent() + kRRecyclerView.computeVerticalScrollOffset() >= kRRecyclerView.computeVerticalScrollRange()) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        if (z16) {
                            return false;
                        }
                    }
                    return true;
                }
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

    @Override // com.tencent.kuikly.core.render.android.expand.component.list.c
    public boolean onInterceptTouchEvent(@NotNull MotionEvent event) {
        boolean z16;
        Intrinsics.checkNotNullParameter(event, "event");
        KRRecyclerView kRRecyclerView = this.recyclerViewWeakRef.get();
        if (kRRecyclerView != null && !kRRecyclerView.getCom.tencent.kuikly.core.views.ScrollerAttr.SCROLL_ENABLED java.lang.String()) {
            return false;
        }
        if (event.getAction() == 0) {
            this.isPointInside = a(event);
        }
        if (!this.isPointInside) {
            return false;
        }
        int actionIndex = event.getActionIndex();
        int actionMasked = event.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked != 2) {
                if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        d(event, actionIndex);
                    }
                } else {
                    b(event, actionIndex);
                }
            } else {
                z16 = c(event);
                if (event.getAction() != 1 || event.getAction() == 3) {
                    this.isPointInside = false;
                }
                return z16;
            }
        } else {
            b(event, actionIndex);
        }
        z16 = false;
        if (event.getAction() != 1) {
        }
        this.isPointInside = false;
        return z16;
    }
}
