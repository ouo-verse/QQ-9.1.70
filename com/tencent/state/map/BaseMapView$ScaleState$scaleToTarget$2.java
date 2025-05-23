package com.tencent.state.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.tencent.state.map.BaseMapView;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/map/BaseMapView$ScaleState$scaleToTarget$2", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class BaseMapView$ScaleState$scaleToTarget$2 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewPropertyAnimator $animator;
    final /* synthetic */ Function1 $endCallback;
    final /* synthetic */ BaseMapView.ScaleState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMapView$ScaleState$scaleToTarget$2(BaseMapView.ScaleState scaleState, ViewPropertyAnimator viewPropertyAnimator, Function1 function1) {
        this.this$0 = scaleState;
        this.$animator = viewPropertyAnimator;
        this.$endCallback = function1;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$animator.setUpdateListener(null).setListener(null);
        this.this$0.isMapZooming = false;
        BaseMapView.this.getContainer().post(new Runnable() { // from class: com.tencent.state.map.BaseMapView$ScaleState$scaleToTarget$2$onAnimationEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                MapItemController controller;
                HashMap hashMap;
                if (BaseMapView.this.getContainer().getTranslationX() != 0.0f || BaseMapView.this.getContainer().getTranslationY() != 0.0f) {
                    BaseMapView.this.getScrollState().doScrollBy(-((int) BaseMapView.this.getContainer().getTranslationX()), -((int) BaseMapView.this.getContainer().getTranslationY()), ViewportChangeReason.SCALE_TO_TARGET);
                    BaseMapView.this.getContainer().setTranslationX(0.0f);
                    BaseMapView.this.getContainer().setTranslationY(0.0f);
                    MapAdapter adapter = BaseMapView.this.getAdapter();
                    if (adapter != null && (controller = adapter.getController()) != null) {
                        controller.setBlockScale(false);
                    }
                }
                BaseMapView.ScaleState scaleState = BaseMapView$ScaleState$scaleToTarget$2.this.this$0;
                hashMap = scaleState.levelRatioMap;
                Float f16 = (Float) hashMap.get(2);
                if (f16 == null) {
                    f16 = Float.valueOf(0.7f);
                }
                Intrinsics.checkNotNullExpressionValue(f16, "levelRatioMap[ZoomLevel.\u2026_IN_2] ?: ZOOM_IN_2_RATIO");
                scaleState.onMapZoomEnd(2, f16.floatValue());
                Function1 function1 = BaseMapView$ScaleState$scaleToTarget$2.this.$endCallback;
                if (function1 != null) {
                }
                BaseMapView.this.resumeFilament(ViewportChangeReason.SCALE_TO_TARGET);
            }
        });
    }
}
