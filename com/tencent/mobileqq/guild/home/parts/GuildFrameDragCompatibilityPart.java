package com.tencent.mobileqq.guild.home.parts;

import android.app.Activity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Space;
import com.tencent.ams.mosaic.MosaicConstants$JsProperty;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.quibadge.QUIBadgeDragLayout;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.mtt.hippy.views.common.HippyNestedScrollComponent;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u000e\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u000b\u001a\u00020\u00072\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0016R\u0016\u0010\u000f\u001a\u00020\f8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\r\u0010\u000eR\u0016\u0010\u0012\u001a\u00020\u00038\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0016\u001a\u00020\u00138\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b\u0014\u0010\u0015R!\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001a\u00a8\u0006 "}, d2 = {"Lcom/tencent/mobileqq/guild/home/parts/GuildFrameDragCompatibilityPart;", "Lcom/tencent/mobileqq/guild/home/parts/a;", "Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout$OnDragModeChangedListener;", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "L9", "Landroid/view/View;", MosaicConstants$JsProperty.PROP_ROOT_VIEW, "", "onInitView", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "onPartDestroy", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout;", "e", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout;", "betterCoordinatorLayout", "f", "Lcom/tencent/mobileqq/activity/recent/cur/DragFrameLayout;", "dragFrame", "Landroid/widget/Space;", tl.h.F, "Landroid/widget/Space;", "windowAnchor", "i", "Lkotlin/Lazy;", "K9", "()Lcom/tencent/mobileqq/quibadge/QUIBadgeDragLayout$OnDragModeChangedListener;", "dragModeChangeListener", "<init>", "()V", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildFrameDragCompatibilityPart extends a {

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private BetterCoordinatorLayout betterCoordinatorLayout;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    private DragFrameLayout dragFrame;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    private Space windowAnchor;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy dragModeChangeListener;

    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\n"}, d2 = {"com/tencent/mobileqq/guild/home/parts/GuildFrameDragCompatibilityPart$b", "Lcom/tencent/mobileqq/guild/home/views/BetterCoordinatorLayout$b;", "Landroid/view/MotionEvent;", "ev", "Landroid/view/ViewGroup;", HippyNestedScrollComponent.PRIORITY_PARENT, "", "handled", "", "a", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes13.dex */
    public static final class b implements BetterCoordinatorLayout.b {
        b() {
        }

        @Override // com.tencent.mobileqq.guild.home.views.BetterCoordinatorLayout.b
        public void a(@NotNull MotionEvent ev5, @NotNull ViewGroup parent, boolean handled) {
            Intrinsics.checkNotNullParameter(ev5, "ev");
            Intrinsics.checkNotNullParameter(parent, "parent");
            Logger logger = Logger.f235387a;
            if (QLog.isColorLevel()) {
                logger.d().d("GuildFrameDragCompatibilityPart", 1, "onDispatchTouchEvent dragFrame ev:" + ev5);
            }
            Space space = GuildFrameDragCompatibilityPart.this.windowAnchor;
            Space space2 = null;
            if (space == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
                space = null;
            }
            ev5.offsetLocation(0.0f, -space.getTop());
            DragFrameLayout dragFrameLayout = GuildFrameDragCompatibilityPart.this.dragFrame;
            if (dragFrameLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
                dragFrameLayout = null;
            }
            dragFrameLayout.dispatchTouchEvent(ev5);
            Space space3 = GuildFrameDragCompatibilityPart.this.windowAnchor;
            if (space3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("windowAnchor");
            } else {
                space2 = space3;
            }
            ev5.offsetLocation(0.0f, space2.getTop());
        }
    }

    public GuildFrameDragCompatibilityPart() {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<QUIBadgeDragLayout.OnDragModeChangedListener<DragFrameLayout>>() { // from class: com.tencent.mobileqq.guild.home.parts.GuildFrameDragCompatibilityPart$dragModeChangeListener$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final QUIBadgeDragLayout.OnDragModeChangedListener<DragFrameLayout> invoke() {
                QUIBadgeDragLayout.OnDragModeChangedListener<DragFrameLayout> L9;
                L9 = GuildFrameDragCompatibilityPart.this.L9();
                return L9;
            }
        });
        this.dragModeChangeListener = lazy;
    }

    private final QUIBadgeDragLayout.OnDragModeChangedListener<DragFrameLayout> K9() {
        return (QUIBadgeDragLayout.OnDragModeChangedListener) this.dragModeChangeListener.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final QUIBadgeDragLayout.OnDragModeChangedListener<DragFrameLayout> L9() {
        return new QUIBadgeDragLayout.OnDragModeChangedListener() { // from class: com.tencent.mobileqq.guild.home.parts.b
            @Override // com.tencent.mobileqq.quibadge.QUIBadgeDragLayout.OnDragModeChangedListener
            public final void onChange(boolean z16, int i3, QUIBadgeDragLayout qUIBadgeDragLayout) {
                GuildFrameDragCompatibilityPart.M9(GuildFrameDragCompatibilityPart.this, z16, i3, (DragFrameLayout) qUIBadgeDragLayout);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void M9(GuildFrameDragCompatibilityPart this$0, boolean z16, int i3, DragFrameLayout from) {
        boolean z17;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(from, "from");
        DragFrameLayout dragFrameLayout = this$0.dragFrame;
        BetterCoordinatorLayout betterCoordinatorLayout = null;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            dragFrameLayout = null;
        }
        if (dragFrameLayout.getMode() != -1) {
            z17 = true;
        } else {
            z17 = false;
        }
        Logger.a d16 = Logger.f235387a.d();
        DragFrameLayout dragFrameLayout2 = this$0.dragFrame;
        if (dragFrameLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            dragFrameLayout2 = null;
        }
        d16.i("GuildFrameDragCompatibilityPart", 1, "onChange(" + dragFrameLayout2.getMode() + ") " + z16 + " " + i3 + " dragFrameProcessing=" + z17);
        this$0.A9().l(z17 ^ true);
        BetterCoordinatorLayout betterCoordinatorLayout2 = this$0.betterCoordinatorLayout;
        if (betterCoordinatorLayout2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("betterCoordinatorLayout");
        } else {
            betterCoordinatorLayout = betterCoordinatorLayout2;
        }
        betterCoordinatorLayout.j(z17);
    }

    @Override // com.tencent.biz.richframework.part.Part
    public void onInitView(@NotNull View rootView) {
        Object m476constructorimpl;
        Intrinsics.checkNotNullParameter(rootView, "rootView");
        super.onInitView(rootView);
        try {
            Result.Companion companion = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl((BetterCoordinatorLayout) rootView);
        } catch (Throwable th5) {
            Result.Companion companion2 = Result.INSTANCE;
            m476constructorimpl = Result.m476constructorimpl(ResultKt.createFailure(th5));
        }
        if (Result.m479exceptionOrNullimpl(m476constructorimpl) == null) {
            BetterCoordinatorLayout betterCoordinatorLayout = (BetterCoordinatorLayout) m476constructorimpl;
            this.betterCoordinatorLayout = betterCoordinatorLayout;
            DragFrameLayout dragFrameLayout = null;
            if (betterCoordinatorLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("betterCoordinatorLayout");
                betterCoordinatorLayout = null;
            }
            betterCoordinatorLayout.setTouchEventDragAware(new b());
            View findViewById = rootView.findViewById(R.id.ulf);
            Intrinsics.checkNotNullExpressionValue(findViewById, "rootView.findViewById(R.id.drag_frame_layout)");
            this.dragFrame = (DragFrameLayout) findViewById;
            View findViewById2 = rootView.findViewById(R.id.f915155d);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "rootView.findViewById(R.id.system_window_anchor)");
            this.windowAnchor = (Space) findViewById2;
            DragFrameLayout dragFrameLayout2 = this.dragFrame;
            if (dragFrameLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            } else {
                dragFrameLayout = dragFrameLayout2;
            }
            dragFrameLayout.addOnDragModeChangeListener(K9(), true);
            return;
        }
        throw new IllegalStateException("\u6839\u5e03\u5c40\u7c7b\u578b\u9519\u8bef! \u8bf7\u68c0\u67e5!");
    }

    @Override // com.tencent.biz.richframework.part.Part, com.tencent.biz.richframework.part.PartLifecycleCallbacks
    public void onPartDestroy(@Nullable Activity activity) {
        super.onPartDestroy(activity);
        DragFrameLayout dragFrameLayout = this.dragFrame;
        if (dragFrameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("dragFrame");
            dragFrameLayout = null;
        }
        dragFrameLayout.removeOnDragModeChangeListener(K9());
    }
}
