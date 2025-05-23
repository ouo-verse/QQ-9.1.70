package com.tencent.state.map;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.ViewPropertyAnimator;
import com.tencent.state.map.BaseMapView;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/state/map/BaseMapView$ScaleState$zoomMap$5", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes34.dex */
public final class BaseMapView$ScaleState$zoomMap$5 extends AnimatorListenerAdapter {
    final /* synthetic */ ViewPropertyAnimator $animator;
    final /* synthetic */ int $next;
    final /* synthetic */ float $scaleNext;
    final /* synthetic */ BaseMapView.ScaleState this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseMapView$ScaleState$zoomMap$5(BaseMapView.ScaleState scaleState, ViewPropertyAnimator viewPropertyAnimator, int i3, float f16) {
        this.this$0 = scaleState;
        this.$animator = viewPropertyAnimator;
        this.$next = i3;
        this.$scaleNext = f16;
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public void onAnimationEnd(Animator animation) {
        this.$animator.setUpdateListener(null).setListener(null);
        this.this$0.isMapZooming = false;
        BaseMapView.this.getContainer().post(new Runnable() { // from class: com.tencent.state.map.BaseMapView$ScaleState$zoomMap$5$onAnimationEnd$1
            @Override // java.lang.Runnable
            public final void run() {
                if (BaseMapView.this.getContainer().getTranslationX() != 0.0f || BaseMapView.this.getContainer().getTranslationY() != 0.0f) {
                    BaseMapView.this.getScrollState().doScrollBy(-((int) BaseMapView.this.getContainer().getTranslationX()), -((int) BaseMapView.this.getContainer().getTranslationY()), ViewportChangeReason.ZOOM);
                    BaseMapView.this.getContainer().setTranslationX(0.0f);
                    BaseMapView.this.getContainer().setTranslationY(0.0f);
                }
                BaseMapView$ScaleState$zoomMap$5 baseMapView$ScaleState$zoomMap$5 = BaseMapView$ScaleState$zoomMap$5.this;
                baseMapView$ScaleState$zoomMap$5.this$0.onMapZoomEnd(baseMapView$ScaleState$zoomMap$5.$next, baseMapView$ScaleState$zoomMap$5.$scaleNext);
                BaseMapView.this.resumeFilament(ViewportChangeReason.ZOOM, ViewportChangeReason.SCROLL);
            }
        });
    }
}
