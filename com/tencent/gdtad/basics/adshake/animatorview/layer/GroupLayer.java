package com.tencent.gdtad.basics.adshake.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.gdtad.basics.adshake.animatorview.animator.Animator;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes6.dex */
public class GroupLayer extends AnimatorLayer {
    private final List<AnimatorLayer> mLayers = new ArrayList();
    private SubLayerAnimationListener mSubLayerAnimationListener = new SubLayerAnimationListener();

    /* compiled from: P */
    /* loaded from: classes6.dex */
    private class SubLayerAnimationListener implements Animator.AnimatorListener {
        private int mFinishedLayerCount;

        SubLayerAnimationListener() {
        }

        @Override // com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorListener
        public void onAnimationFinish() {
            int i3 = this.mFinishedLayerCount + 1;
            this.mFinishedLayerCount = i3;
            if (i3 == GroupLayer.this.mLayers.size()) {
                this.mFinishedLayerCount = 0;
                Animator.AnimatorListener animatorListener = GroupLayer.this.mAnimatorListener;
                if (animatorListener != null) {
                    animatorListener.onAnimationFinish();
                }
            }
        }
    }

    public GroupLayer(AnimatorLayer... animatorLayerArr) {
        addLayers(animatorLayerArr);
    }

    public void addLayer(AnimatorLayer animatorLayer) {
        if (animatorLayer instanceof GroupLayer) {
            GroupLayer groupLayer = (GroupLayer) animatorLayer;
            for (AnimatorLayer animatorLayer2 : groupLayer.getLayers()) {
                animatorLayer2.setX(groupLayer.getX() + animatorLayer2.getX());
                animatorLayer2.setY(groupLayer.getY() + animatorLayer2.getY());
                addLayers(animatorLayer2);
            }
            return;
        }
        addLayers(animatorLayer);
    }

    public void addLayers(AnimatorLayer... animatorLayerArr) {
        if (animatorLayerArr == null) {
            return;
        }
        for (AnimatorLayer animatorLayer : animatorLayerArr) {
            if (animatorLayer != null) {
                this.mLayers.add(animatorLayer);
                animatorLayer.assignParent(this);
            }
        }
    }

    public List<AnimatorLayer> getLayers() {
        return this.mLayers;
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        Animator.AnimatorListener animatorListener;
        if (getAnimator() != null && (animatorListener = this.mAnimatorListener) != null) {
            animatorListener.onAnimationFinish();
        }
    }

    public void removeAllLayers() {
        this.mLayers.clear();
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        super.setAnimatorListener(animatorListener);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setAnimatorListener(this.mSubLayerAnimationListener);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void setCanvasView(View view) {
        super.setCanvasView(view);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setCanvasView(view);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void setMatrix(Matrix matrix) {
        super.setMatrix(matrix);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setMatrix(matrix);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void setPx(float f16) {
        super.setPx(f16);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setPx(f16);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void setPy(float f16) {
        super.setPy(f16);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setPy(f16);
        }
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
    }

    @Override // com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorLayer, com.tencent.gdtad.basics.adshake.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17, float f18, float f19, float f26) {
    }
}
