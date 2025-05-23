package com.tencent.state.square.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.graphics.Rect;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.state.SquareDebug;
import com.tencent.state.VasExtensionsKt;
import com.tencent.state.ViewExtensionsKt;
import com.tencent.state.map.BaseMapView;
import com.tencent.state.map.IMapItemViewManager;
import com.tencent.state.map.IMapLocator;
import com.tencent.state.map.MapItem;
import com.tencent.state.map.MapPlayableViewHolder;
import com.tencent.state.map.MapViewHolder;
import com.tencent.state.map.MapViewKt;
import com.tencent.state.square.SquareBaseKt;
import com.tencent.state.square.SquareLogger;
import com.tencent.state.square.data.SquareAvatarItem;
import com.tencent.state.square.holder.AvatarViewHolder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000  2\u00020\u0001:\u0002 !B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0002\b\u00030\u0007j\u0002`\b\u00a2\u0006\u0002\u0010\tJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J0\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J0\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0002J0\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0002J\u0016\u0010\u001e\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0016J\u0018\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u0015H\u0002R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0002\b\u00030\u0007j\u0002`\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/tencent/state/square/layout/SquareDynamicLayoutAnimator;", "Lcom/tencent/state/square/layout/OnMoveCallback;", "vm", "Lcom/tencent/state/map/IMapItemViewManager;", "locator", "Lcom/tencent/state/map/IMapLocator;", "square", "Lcom/tencent/state/map/BaseMapView;", "Lcom/tencent/state/map/MapView;", "(Lcom/tencent/state/map/IMapItemViewManager;Lcom/tencent/state/map/IMapLocator;Lcom/tencent/state/map/BaseMapView;)V", "animatingViews", "", "Landroid/view/View;", "doAlphaAnimation", "", "view", "isAlphaIn", "", "skipAnim", "doAnimation", "srcIndex", "", "dstIndex", "isDestOutScreen", "doMoveAnimation", "doOnMove", "commands", "", "Lcom/tencent/state/square/layout/MoveCommand;", "doTranslateAnimation", "onMove", "updateViewLocation", "Companion", "MoveAnimateListener", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class SquareDynamicLayoutAnimator implements OnMoveCallback {
    private static final long ANIM_DUR = 1000;
    private static final String TAG = "SquareDynamicLayoutAnimator";
    private final List<View> animatingViews;
    private final IMapLocator locator;
    private final BaseMapView<?> square;
    private final IMapItemViewManager vm;

    /* compiled from: P */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u00a6\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\u000e\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/state/square/layout/SquareDynamicLayoutAnimator$MoveAnimateListener;", "Landroid/animation/AnimatorListenerAdapter;", "view", "Landroid/view/View;", "(Lcom/tencent/state/square/layout/SquareDynamicLayoutAnimator;Landroid/view/View;)V", "isCanceled", "", "vh", "Lcom/tencent/state/map/MapPlayableViewHolder;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationStart", "state_square_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes38.dex */
    public abstract class MoveAnimateListener extends AnimatorListenerAdapter {
        private boolean isCanceled;
        final /* synthetic */ SquareDynamicLayoutAnimator this$0;
        private final MapPlayableViewHolder<?> vh;
        private final View view;

        public MoveAnimateListener(SquareDynamicLayoutAnimator squareDynamicLayoutAnimator, View view) {
            Intrinsics.checkNotNullParameter(view, "view");
            this.this$0 = squareDynamicLayoutAnimator;
            this.view = view;
            MapViewHolder<?> mapViewHolder = MapViewKt.getMapViewHolder(view);
            this.vh = (MapPlayableViewHolder) (mapViewHolder instanceof MapPlayableViewHolder ? mapViewHolder : null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            if (!this.isCanceled) {
                this.this$0.animatingViews.remove(this.view);
            }
            MapPlayableViewHolder<?> mapPlayableViewHolder = this.vh;
            if (mapPlayableViewHolder != null) {
                mapPlayableViewHolder.setInAnim(false);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animation) {
            super.onAnimationStart(animation);
            MapPlayableViewHolder<?> mapPlayableViewHolder = this.vh;
            if (mapPlayableViewHolder != null) {
                mapPlayableViewHolder.setInAnim(true);
                MapPlayableViewHolder.stop$default(mapPlayableViewHolder, false, 1, null);
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animation) {
            this.isCanceled = true;
            MapPlayableViewHolder<?> mapPlayableViewHolder = this.vh;
            if (mapPlayableViewHolder != null) {
                mapPlayableViewHolder.setInAnim(false);
            }
        }
    }

    public SquareDynamicLayoutAnimator(IMapItemViewManager vm5, IMapLocator locator, BaseMapView<?> square) {
        Intrinsics.checkNotNullParameter(vm5, "vm");
        Intrinsics.checkNotNullParameter(locator, "locator");
        Intrinsics.checkNotNullParameter(square, "square");
        this.vm = vm5;
        this.locator = locator;
        this.square = square;
        this.animatingViews = new ArrayList();
    }

    private final void doAnimation(final View view, final int srcIndex, final int dstIndex, final boolean isDestOutScreen, final boolean skipAnim) {
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$doAnimation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                int i3 = srcIndex;
                if (i3 < 0) {
                    SquareDynamicLayoutAnimator.this.doAlphaAnimation(view, true, skipAnim);
                    return;
                }
                int i16 = dstIndex;
                if (i16 < 0) {
                    SquareDynamicLayoutAnimator.this.doAlphaAnimation(view, false, skipAnim);
                } else {
                    SquareDynamicLayoutAnimator.this.doTranslateAnimation(view, i3, i16, isDestOutScreen, skipAnim);
                }
            }
        });
    }

    private final void doMoveAnimation(View view, int srcIndex, int dstIndex, boolean isDestOutScreen, boolean skipAnim) {
        this.animatingViews.add(view);
        updateViewLocation(view, dstIndex);
        doAnimation(view, srcIndex, dstIndex, isDestOutScreen, skipAnim);
    }

    private final void doOnMove(List<MoveCommand> commands) {
        SquareBaseKt.getSquareLog().i(TAG, "doMove");
        SquareDebug.INSTANCE.printMoveViewInfo("[addRoles] doOnMove, start", this.vm.getIndexViewList());
        SparseArray sparseArray = new SparseArray();
        for (MoveCommand moveCommand : commands) {
            if (moveCommand.getFrom() < 0 && this.vm.getInScreenIndexSet().contains(Integer.valueOf(moveCommand.getTo()))) {
                MapItem fromData = moveCommand.getFromData();
                if (fromData != null) {
                    View addView = this.vm.addView(moveCommand.getTo(), fromData);
                    if (this.square.isInDetailMode()) {
                        SquareBaseKt.getSquareLog().i(TAG, "addView and isInScaleMode");
                        addView.setAlpha(0.0f);
                        updateViewLocation(addView, moveCommand.getTo());
                    } else {
                        doMoveAnimation(addView, moveCommand.getFrom(), moveCommand.getTo(), false, moveCommand.getSkipAnim());
                    }
                    sparseArray.put(moveCommand.getTo(), addView);
                    SquareBaseKt.getSquareLog().d(TAG, "doOnMove, 1,  putChange: " + moveCommand.getFrom() + ", " + moveCommand.getTo());
                }
            } else if (this.vm.getInScreenIndexSet().contains(Integer.valueOf(moveCommand.getFrom()))) {
                View view = this.vm.getIndexViewList().get(moveCommand.getFrom());
                if (view != null) {
                    doMoveAnimation(view, moveCommand.getFrom(), moveCommand.getTo(), !this.vm.getInScreenIndexSet().contains(Integer.valueOf(moveCommand.getTo())), moveCommand.getSkipAnim());
                    sparseArray.put(moveCommand.getTo(), view);
                    SquareBaseKt.getSquareLog().d(TAG, "doOnMove, 2, putChange: " + moveCommand.getFrom() + ", " + moveCommand.getTo());
                    SquareLogger.DefaultImpls.e$default(SquareBaseKt.getSquareLog(), TAG, "indexViewList get " + moveCommand.getFrom() + " == null", null, 4, null);
                }
            } else if (this.vm.getInScreenIndexSet().contains(Integer.valueOf(moveCommand.getTo()))) {
                View addView2 = this.vm.addView(moveCommand.getFrom());
                doMoveAnimation(addView2, moveCommand.getFrom(), moveCommand.getTo(), false, moveCommand.getSkipAnim());
                sparseArray.put(moveCommand.getTo(), addView2);
                SquareBaseKt.getSquareLog().d(TAG, "doOnMove, 3, putChange: " + moveCommand.getFrom() + ", " + moveCommand.getTo());
            } else {
                SquareBaseKt.getSquareLog().i(TAG, "src and dst all is not in screen.");
            }
        }
        SquareDebug squareDebug = SquareDebug.INSTANCE;
        squareDebug.printMoveViewInfo("[addRoles] doOnMove, after cmd", this.vm.getIndexViewList());
        VasExtensionsKt.forEach(sparseArray, new Function2<Integer, View, Unit>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$doOnMove$2
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, View view2) {
                invoke(num.intValue(), view2);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, View view2) {
                IMapItemViewManager iMapItemViewManager;
                IMapLocator iMapLocator;
                Intrinsics.checkNotNullParameter(view2, "view");
                iMapItemViewManager = SquareDynamicLayoutAnimator.this.vm;
                iMapItemViewManager.getIndexViewList().put(i3, view2);
                iMapLocator = SquareDynamicLayoutAnimator.this.locator;
                view2.setElevation(iMapLocator.getItemLocation(i3).getCenterY());
            }
        });
        squareDebug.printMoveViewInfo("[addRoles] doOnMove, end", this.vm.getIndexViewList());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doTranslateAnimation(final View view, int srcIndex, final int dstIndex, final boolean isDestOutScreen, boolean skipAnim) {
        Rect itemPosition = this.locator.getItemPosition(srcIndex);
        Rect itemPosition2 = this.locator.getItemPosition(dstIndex);
        view.setTranslationX(itemPosition.left - itemPosition2.left);
        view.setTranslationY(itemPosition.top - itemPosition2.top);
        view.animate().translationX(0.0f).translationY(0.0f).setDuration(1000L).setListener(new MoveAnimateListener(view) { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$doTranslateAnimation$1
            @Override // com.tencent.state.square.layout.SquareDynamicLayoutAnimator.MoveAnimateListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                view.setTranslationX(0.0f);
                view.setTranslationY(0.0f);
            }

            @Override // com.tencent.state.square.layout.SquareDynamicLayoutAnimator.MoveAnimateListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                IMapItemViewManager iMapItemViewManager;
                if (isDestOutScreen) {
                    iMapItemViewManager = SquareDynamicLayoutAnimator.this.vm;
                    iMapItemViewManager.recycleView(dstIndex);
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }

    @Override // com.tencent.state.square.layout.OnMoveCallback
    public void onMove(List<MoveCommand> commands) {
        Intrinsics.checkNotNullParameter(commands, "commands");
        if (!this.animatingViews.isEmpty()) {
            Iterator<T> it = this.animatingViews.iterator();
            while (it.hasNext()) {
                ((View) it.next()).animate().cancel();
            }
            this.animatingViews.clear();
        }
        doOnMove(commands);
    }

    private final void updateViewLocation(final View view, final int dstIndex) {
        if (dstIndex < 0) {
            return;
        }
        final Rect itemPosition = this.locator.getItemPosition(dstIndex);
        ViewExtensionsKt.updateLayoutParams(view, new Function1<BaseMapView.LayoutParams, Unit>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$updateViewLocation$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(BaseMapView.LayoutParams layoutParams) {
                invoke2(layoutParams);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(BaseMapView.LayoutParams receiver) {
                Intrinsics.checkNotNullParameter(receiver, "$receiver");
                Rect rect = itemPosition;
                ((FrameLayout.LayoutParams) receiver).leftMargin = rect.left;
                ((FrameLayout.LayoutParams) receiver).topMargin = rect.top;
            }
        });
        MapViewHolder<?> mapViewHolder = MapViewKt.getMapViewHolder(view);
        if (mapViewHolder != null) {
            mapViewHolder.setIndex(dstIndex);
        }
        SquareBaseKt.getSquareThread().postOnUi(new Function0<Unit>() { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$updateViewLocation$2
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                MapViewHolder<?> mapViewHolder2 = MapViewKt.getMapViewHolder(view);
                if (!(mapViewHolder2 instanceof AvatarViewHolder)) {
                    mapViewHolder2 = null;
                }
                AvatarViewHolder avatarViewHolder = (AvatarViewHolder) mapViewHolder2;
                if (avatarViewHolder != null) {
                    avatarViewHolder.bindDebugTips(dstIndex, (SquareAvatarItem) avatarViewHolder.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doAlphaAnimation(final View view, final boolean isAlphaIn, boolean skipAnim) {
        float f16 = isAlphaIn ? 0.0f : 1.0f;
        final float f17 = isAlphaIn ? 1.0f : 0.0f;
        long j3 = skipAnim ? 0L : 1000L;
        view.setAlpha(f16);
        view.animate().alpha(f17).setDuration(j3).setListener(new MoveAnimateListener(view) { // from class: com.tencent.state.square.layout.SquareDynamicLayoutAnimator$doAlphaAnimation$1
            @Override // com.tencent.state.square.layout.SquareDynamicLayoutAnimator.MoveAnimateListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                super.onAnimationCancel(animation);
                view.setAlpha(f17);
            }

            @Override // com.tencent.state.square.layout.SquareDynamicLayoutAnimator.MoveAnimateListener, android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                BaseMapView baseMapView;
                if (!isAlphaIn) {
                    baseMapView = SquareDynamicLayoutAnimator.this.square;
                    baseMapView.getContainer().removeView(view);
                }
                super.onAnimationEnd(animation);
            }
        }).start();
    }
}
