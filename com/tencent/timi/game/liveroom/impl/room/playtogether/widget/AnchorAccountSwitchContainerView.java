package com.tencent.timi.game.liveroom.impl.room.playtogether.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import androidx.customview.widget.ViewDragHelper;
import com.tencent.mtt.hippy.dom.node.NodeProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import trpc.yes.common.GameRoleOuterClass$SmobaGameRoleInfo;
import trpc.yes.common.YesGameInfoOuterClass$SetUserGameDefaultRoleRsp;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u001a\u00a2\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\f\u001a\u00020\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u0010\u000e\u001a\u00020\u000b2\b\u0010\r\u001a\u0004\u0018\u00010\tH\u0016R\u0014\u0010\u0012\u001a\u00020\u000f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00138\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0017\u0010\u0018R\u0016\u0010\u001c\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u001bR\u0016\u0010\u001e\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001d\u0010\u001b\u00a8\u0006'"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView;", "Landroid/widget/FrameLayout;", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "listener", "", "setAnchorAccountSwitchListener", "Landroid/view/View;", tl.h.F, "computeScroll", "Landroid/view/MotionEvent;", "ev", "", NodeProps.ON_INTERCEPT_TOUCH_EVENT, "event", "onTouchEvent", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView;", "d", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchView;", "anchorAccountSwitchView", "Landroidx/customview/widget/ViewDragHelper;", "e", "Landroidx/customview/widget/ViewDragHelper;", "viewDragHelper", "f", "Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "anchorAccountSwitchListener", "", "I", "anchorAccountSwitchViewHeight", "i", "anchorAccountSwitchViewTop", "Landroid/content/Context;", "ctx", "Landroid/util/AttributeSet;", "attr", "def", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class AnchorAccountSwitchContainerView extends FrameLayout {

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final AnchorAccountSwitchView anchorAccountSwitchView;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private ViewDragHelper viewDragHelper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private b anchorAccountSwitchListener;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private int anchorAccountSwitchViewHeight;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    private int anchorAccountSwitchViewTop;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0002H\u0016J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0004H\u0016J \u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0004H\u0016\u00a8\u0006\u0015"}, d2 = {"com/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$a", "Landroidx/customview/widget/ViewDragHelper$Callback;", "Landroid/view/View;", "p0", "", "p1", "", "tryCaptureView", "child", "getViewVerticalDragRange", "releasedChild", "", "xvel", "yvel", "", "onViewReleased", "state", "onViewDragStateChanged", "top", "dy", "clampViewPositionVertical", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class a extends ViewDragHelper.Callback {
        a() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(@NotNull View child, int top, int dy5) {
            Intrinsics.checkNotNullParameter(child, "child");
            return Math.max(top, AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewTop);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(@NotNull View child) {
            Intrinsics.checkNotNullParameter(child, "child");
            return 1;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int state) {
            int i3;
            b bVar;
            View capturedView;
            super.onViewDragStateChanged(state);
            if (state == 0) {
                ViewDragHelper viewDragHelper = AnchorAccountSwitchContainerView.this.viewDragHelper;
                if (viewDragHelper == null || (capturedView = viewDragHelper.getCapturedView()) == null) {
                    i3 = AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewTop;
                } else {
                    i3 = capturedView.getTop();
                }
                if (i3 > AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewTop && (bVar = AnchorAccountSwitchContainerView.this.anchorAccountSwitchListener) != null) {
                    bVar.a();
                }
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(@NotNull View releasedChild, float xvel, float yvel) {
            Intrinsics.checkNotNullParameter(releasedChild, "releasedChild");
            if (releasedChild.getTop() > ((int) (AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewTop + (AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewHeight * 0.3f)))) {
                ViewDragHelper viewDragHelper = AnchorAccountSwitchContainerView.this.viewDragHelper;
                if (viewDragHelper != null) {
                    viewDragHelper.settleCapturedViewAt(0, AnchorAccountSwitchContainerView.this.getHeight());
                }
            } else {
                ViewDragHelper viewDragHelper2 = AnchorAccountSwitchContainerView.this.viewDragHelper;
                if (viewDragHelper2 != null) {
                    viewDragHelper2.settleCapturedViewAt(0, AnchorAccountSwitchContainerView.this.anchorAccountSwitchViewTop);
                }
            }
            AnchorAccountSwitchContainerView.this.invalidate();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(@NotNull View p06, int p16) {
            Intrinsics.checkNotNullParameter(p06, "p0");
            return Intrinsics.areEqual(p06, AnchorAccountSwitchContainerView.this.anchorAccountSwitchView);
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/liveroom/impl/room/playtogether/widget/AnchorAccountSwitchContainerView$b;", "", "", "a", "Ltrpc/yes/common/GameRoleOuterClass$SmobaGameRoleInfo;", "roleRsp", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface b {
        void a();

        void b(@Nullable GameRoleOuterClass$SmobaGameRoleInfo roleRsp);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchContainerView(@NotNull Context ctx) {
        this(ctx, null, 0, 6, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(AnchorAccountSwitchContainerView this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.anchorAccountSwitchViewHeight = this$0.anchorAccountSwitchView.getHeight();
        this$0.anchorAccountSwitchViewTop = this$0.anchorAccountSwitchView.getTop();
    }

    @Override // android.view.View
    public void computeScroll() {
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        boolean z16 = false;
        if (viewDragHelper != null && viewDragHelper.continueSettling(true)) {
            z16 = true;
        }
        if (z16) {
            invalidate();
        }
    }

    @NotNull
    public final View h() {
        return this.anchorAccountSwitchView.i();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(@Nullable MotionEvent ev5) {
        Boolean bool;
        if (ev5 == null) {
            return super.onInterceptTouchEvent(ev5);
        }
        float x16 = ev5.getX();
        float y16 = ev5.getY() - this.anchorAccountSwitchView.getTop();
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            bool = Boolean.valueOf(viewDragHelper.isViewUnder(this.anchorAccountSwitchView.j(), (int) x16, (int) y16));
        } else {
            bool = null;
        }
        if (Intrinsics.areEqual(bool, Boolean.TRUE)) {
            ViewDragHelper viewDragHelper2 = this.viewDragHelper;
            if (viewDragHelper2 == null || !viewDragHelper2.shouldInterceptTouchEvent(ev5)) {
                return false;
            }
            return true;
        }
        ViewDragHelper viewDragHelper3 = this.viewDragHelper;
        if (viewDragHelper3 == null) {
            return false;
        }
        viewDragHelper3.cancel();
        return false;
    }

    @Override // android.view.View
    public boolean onTouchEvent(@Nullable MotionEvent event) {
        if (event == null) {
            return super.onTouchEvent(event);
        }
        ViewDragHelper viewDragHelper = this.viewDragHelper;
        if (viewDragHelper != null) {
            viewDragHelper.processTouchEvent(event);
            return true;
        }
        return true;
    }

    public final void setAnchorAccountSwitchListener(@NotNull b listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        this.anchorAccountSwitchListener = listener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchContainerView(@NotNull Context ctx, @Nullable AttributeSet attributeSet) {
        this(ctx, attributeSet, 0, 4, null);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
    }

    public /* synthetic */ AnchorAccountSwitchContainerView(Context context, AttributeSet attributeSet, int i3, int i16, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i16 & 2) != 0 ? null : attributeSet, (i16 & 4) != 0 ? 0 : i3);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AnchorAccountSwitchContainerView(@NotNull Context ctx, @Nullable AttributeSet attributeSet, int i3) {
        super(ctx, attributeSet, i3);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        AnchorAccountSwitchView anchorAccountSwitchView = new AnchorAccountSwitchView(ctx, null, 0, 6, null);
        this.anchorAccountSwitchView = anchorAccountSwitchView;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, fh4.b.b(360));
        layoutParams.gravity = 80;
        Unit unit = Unit.INSTANCE;
        addView(anchorAccountSwitchView, layoutParams);
        post(new Runnable() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.a
            @Override // java.lang.Runnable
            public final void run() {
                AnchorAccountSwitchContainerView.b(AnchorAccountSwitchContainerView.this);
            }
        });
        anchorAccountSwitchView.setDefaultRoleChooseCb(new Function1<YesGameInfoOuterClass$SetUserGameDefaultRoleRsp, Unit>() { // from class: com.tencent.timi.game.liveroom.impl.room.playtogether.widget.AnchorAccountSwitchContainerView.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(YesGameInfoOuterClass$SetUserGameDefaultRoleRsp yesGameInfoOuterClass$SetUserGameDefaultRoleRsp) {
                invoke2(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@Nullable YesGameInfoOuterClass$SetUserGameDefaultRoleRsp yesGameInfoOuterClass$SetUserGameDefaultRoleRsp) {
                b bVar = AnchorAccountSwitchContainerView.this.anchorAccountSwitchListener;
                if (bVar != null) {
                    bVar.b(com.tencent.timi.game.liveroom.impl.room.playtogether.util.h.j(yesGameInfoOuterClass$SetUserGameDefaultRoleRsp != null ? yesGameInfoOuterClass$SetUserGameDefaultRoleRsp.role_info : null));
                }
            }
        });
        this.viewDragHelper = ViewDragHelper.create(this, 1.0f, new a());
    }
}
