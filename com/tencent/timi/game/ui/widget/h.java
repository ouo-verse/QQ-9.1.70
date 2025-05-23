package com.tencent.timi.game.ui.widget;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import androidx.customview.widget.ViewDragHelper;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qqlive.common.screen.ScreenUtils;
import com.tencent.timi.game.base.ui.TimiGamePageLoadingView;
import com.tencent.timi.game.ui.widget.DragViewGroup;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt___RangesKt;
import mqq.app.Constants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 '2\u00020\u00012\u00020\u0002:\u0001(B\u000f\u0012\u0006\u0010$\u001a\u00020#\u00a2\u0006\u0004\b%\u0010&J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H&J\b\u0010\b\u001a\u00020\u0007H&J\n\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u000bH\u0016J\b\u0010\u000e\u001a\u00020\u0003H\u0016J\u0012\u0010\u0011\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0014J\b\u0010\u0012\u001a\u00020\u0003H\u0016R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0018\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u00078\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u0017R\u0016\u0010\u001e\u001a\u00020\u001b8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u0016\u0010 \u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001f\u0010\u0017R\u0016\u0010\"\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b!\u0010\u0017\u00a8\u0006)"}, d2 = {"Lcom/tencent/timi/game/ui/widget/h;", "Lcom/tencent/timi/game/ui/widget/s;", "Lcom/tencent/timi/game/ui/widget/k;", "", "o0", "Lcom/tencent/timi/game/ui/widget/DragViewGroup;", "p0", "", "m0", "Lcom/tencent/timi/game/base/ui/TimiGamePageLoadingView;", "n0", "", "text", "K", "hideLoadingView", "Landroid/os/Bundle;", Constants.FILE_INSTANCE_STATE, "onCreate", "show", "Landroidx/customview/widget/ViewDragHelper;", "J", "Landroidx/customview/widget/ViewDragHelper;", "mDragHelper", "I", "mScreenHeight", "L", "mStatusBarHeight", "", "M", "Z", "mNeedAppendStatusBar", "N", "mContentShowTop", "P", "mContentSlideOutTop", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", AppConstants.RichMediaErrorCode.HTTP_OK_FAIL_PRE, "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public abstract class h extends s implements k {

    /* renamed from: J, reason: from kotlin metadata */
    @Nullable
    private ViewDragHelper mDragHelper;

    /* renamed from: K, reason: from kotlin metadata */
    private final int mScreenHeight;

    /* renamed from: L, reason: from kotlin metadata */
    private final int mStatusBarHeight;

    /* renamed from: M, reason: from kotlin metadata */
    private boolean mNeedAppendStatusBar;

    /* renamed from: N, reason: from kotlin metadata */
    private int mContentShowTop;

    /* renamed from: P, reason: from kotlin metadata */
    private int mContentSlideOutTop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J \u0010\r\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J \u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u0004H\u0016J0\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0004H\u0016\u00a8\u0006\u0018"}, d2 = {"com/tencent/timi/game/ui/widget/h$b", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroid/view/View;", "child", "", "pointerId", "", "tryCaptureView", "releasedChild", "", "xvel", "yvel", "", "onViewReleased", "getViewVerticalDragRange", "top", "dy", "clampViewPositionVertical", "state", "onViewDragStateChanged", "changedView", "left", "dx", "onViewPositionChanged", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b extends ViewDragHelper.Callback {
        b() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NotNull View child, int top, int dy5) {
            int coerceAtLeast;
            Intrinsics.checkNotNullParameter(child, "child");
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "clampViewPositionVertical top:" + top + ", dy:" + dy5);
            coerceAtLeast = RangesKt___RangesKt.coerceAtLeast(top, h.this.mContentShowTop);
            return coerceAtLeast;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NotNull View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "getViewVerticalDragRange child:" + child);
            return h.this.m0();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int state) {
            ViewDragHelper viewDragHelper;
            View capturedView;
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "onViewDragStateChanged state:" + state);
            if (state == 0 && (viewDragHelper = h.this.mDragHelper) != null && (capturedView = viewDragHelper.getCapturedView()) != null && capturedView.getTop() == h.this.mContentSlideOutTop) {
                com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "onViewReleased auto dismiss");
                h.this.dismiss();
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(@NotNull View changedView, int left, int top, int dx5, int dy5) {
            Intrinsics.checkNotNullParameter(changedView, "changedView");
            float m06 = (top - h.this.mContentShowTop) / h.this.m0();
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "onViewPositionChanged ratio=" + m06);
            h.this.getShadowView().setAlpha(((float) 1) - m06);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NotNull View releasedChild, float xvel, float yvel) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            int top = releasedChild.getTop();
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "onViewReleased top:" + top);
            if (top >= h.this.mContentShowTop + (h.this.m0() * 0.3d)) {
                ViewDragHelper viewDragHelper = h.this.mDragHelper;
                if (viewDragHelper != null) {
                    viewDragHelper.settleCapturedViewAt(0, h.this.mContentSlideOutTop);
                }
            } else {
                ViewDragHelper viewDragHelper2 = h.this.mDragHelper;
                if (viewDragHelper2 != null) {
                    viewDragHelper2.settleCapturedViewAt(0, h.this.mContentShowTop);
                }
            }
            h.this.p0().invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NotNull View child, int pointerId) {
            Intrinsics.checkNotNullParameter(child, "child");
            com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "tryCaptureView child:" + child);
            return Intrinsics.areEqual(child, h.this.Y());
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/ui/widget/h$c", "Lcom/tencent/timi/game/ui/widget/DragViewGroup$a;", "Landroid/view/MotionEvent;", "event", "Lcom/tencent/timi/game/ui/widget/DragViewGroup;", "viewGroup", "", "b", "ev", "a", "", "c", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements DragViewGroup.a {
        c() {
        }

        @Override // com.tencent.timi.game.ui.widget.DragViewGroup.a
        public boolean a(@NotNull MotionEvent ev5, @NotNull DragViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(ev5, "ev");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            ViewDragHelper viewDragHelper = h.this.mDragHelper;
            Intrinsics.checkNotNull(viewDragHelper);
            if (viewDragHelper.isViewUnder(h.this.Y(), (int) ev5.getX(), (int) ev5.getY())) {
                ViewDragHelper viewDragHelper2 = h.this.mDragHelper;
                Intrinsics.checkNotNull(viewDragHelper2);
                return viewDragHelper2.shouldInterceptTouchEvent(ev5);
            }
            ViewDragHelper viewDragHelper3 = h.this.mDragHelper;
            Intrinsics.checkNotNull(viewDragHelper3);
            viewDragHelper3.cancel();
            return viewGroup.a(ev5);
        }

        @Override // com.tencent.timi.game.ui.widget.DragViewGroup.a
        public boolean b(@NotNull MotionEvent event, @NotNull DragViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(event, "event");
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            ViewDragHelper viewDragHelper = h.this.mDragHelper;
            if (viewDragHelper != null) {
                viewDragHelper.processTouchEvent(event);
                return true;
            }
            return true;
        }

        @Override // com.tencent.timi.game.ui.widget.DragViewGroup.a
        public void c(@NotNull DragViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
            if (h.this.mDragHelper != null) {
                ViewDragHelper viewDragHelper = h.this.mDragHelper;
                Intrinsics.checkNotNull(viewDragHelper);
                if (viewDragHelper.continueSettling(true)) {
                    viewGroup.invalidate();
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.mScreenHeight = ScreenUtils.getAppScreenHeight();
        this.mStatusBarHeight = ImmersiveUtils.getStatusBarHeight(context);
        this.mNeedAppendStatusBar = true;
    }

    private final void o0() {
        com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "initDragHelper rootView().parent:" + p0().getParent());
        if (this.mNeedAppendStatusBar) {
            this.mContentShowTop = (this.mScreenHeight + this.mStatusBarHeight) - m0();
            this.mContentSlideOutTop = this.mScreenHeight + this.mStatusBarHeight;
        } else {
            this.mContentShowTop = this.mScreenHeight - m0();
            this.mContentSlideOutTop = this.mScreenHeight;
        }
        this.mDragHelper = ViewDragHelper.create(p0(), new b());
        p0().setTouchHookListener(new c());
        com.tencent.timi.game.utils.l.i("DragSlideUpDialog_", "initDragHelper done!");
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void K(@NotNull String text) {
        boolean z16;
        Intrinsics.checkNotNullParameter(text, "text");
        if (text.length() == 0) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (z16) {
            text = this.G.getString(R.string.f23156727);
            Intrinsics.checkNotNullExpressionValue(text, "context.getString(R.stri\u2026ame_loading_hint_default)");
        }
        TimiGamePageLoadingView n06 = n0();
        if (n06 != null) {
            n06.setHintText(text);
        }
        TimiGamePageLoadingView n07 = n0();
        if (n07 != null) {
            n07.d();
        }
    }

    @Override // com.tencent.timi.game.ui.widget.k
    public void hideLoadingView() {
        TimiGamePageLoadingView n06 = n0();
        if (n06 != null) {
            n06.c();
        }
    }

    public abstract int m0();

    @Nullable
    public abstract TimiGamePageLoadingView n0();

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.timi.game.ui.widget.s, com.tencent.timi.game.ui.widget.j, android.app.Dialog
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        o0();
    }

    @NotNull
    public abstract DragViewGroup p0();

    @Override // com.tencent.timi.game.ui.widget.b, com.tencent.mobileqq.qui.dialog.QUICompatDialog, android.app.Dialog
    public void show() {
        super.show();
        f0();
    }
}
