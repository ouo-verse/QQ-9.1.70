package com.tencent.ams.fusion.widget.animatorview.layer;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.render.IAnimatorRender;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class GroupLayer extends AnimatorLayer {
    static IPatchRedirector $redirector_;
    private final List<AnimatorLayer> mLayers;
    private final SubLayerAnimationListener mSubLayerAnimationListener;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    private class SubLayerAnimationListener implements Animator.AnimatorListener {
        static IPatchRedirector $redirector_;
        private int mFinishedLayerCount;

        SubLayerAnimationListener() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) GroupLayer.this);
        }

        @Override // com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
        public void onAnimationFinish() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
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

        /* synthetic */ SubLayerAnimationListener(GroupLayer groupLayer, AnonymousClass1 anonymousClass1) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) groupLayer, (Object) anonymousClass1);
        }
    }

    public GroupLayer(AnimatorLayer... animatorLayerArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) animatorLayerArr);
            return;
        }
        this.mLayers = new ArrayList();
        this.mSubLayerAnimationListener = new SubLayerAnimationListener(this, null);
        addLayers(animatorLayerArr);
    }

    public void addLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) animatorLayer);
            return;
        }
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
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) animatorLayerArr);
            return;
        }
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

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) canvas);
        }
    }

    public List<AnimatorLayer> getLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.mLayers;
    }

    public void merge(GroupLayer groupLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) groupLayer);
        } else if (groupLayer != null && groupLayer.getLayers() != null) {
            Iterator<AnimatorLayer> it = groupLayer.getLayers().iterator();
            while (it.hasNext()) {
                addLayers(it.next());
            }
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.animator.Animator.AnimatorListener
    public void onAnimationFinish() {
        Animator.AnimatorListener animatorListener;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this);
        } else if (getAnimator() != null && (animatorListener = this.mAnimatorListener) != null) {
            animatorListener.onAnimationFinish();
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postAlpha(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, i3);
            return;
        }
        super.postAlpha(i3);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().postAlpha(i3);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postProgress(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, Float.valueOf(f16));
            return;
        }
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().postProgress(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer, com.tencent.ams.fusion.widget.animatorview.layer.AnimatorAction
    public void postScale(float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, Float.valueOf(f16), Float.valueOf(f17));
        }
    }

    public void removeAllLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.mLayers.clear();
        }
    }

    public void removeLayer(AnimatorLayer animatorLayer) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) animatorLayer);
        } else if (animatorLayer != null) {
            this.mLayers.remove(animatorLayer);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setAnimatorListener(Animator.AnimatorListener animatorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) animatorListener);
            return;
        }
        super.setAnimatorListener(animatorListener);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setAnimatorListener(this.mSubLayerAnimationListener);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setAnimatorRender(IAnimatorRender iAnimatorRender) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) iAnimatorRender);
            return;
        }
        super.setAnimatorRender(iAnimatorRender);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setAnimatorRender(iAnimatorRender);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setCanvasView(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) view);
            return;
        }
        super.setCanvasView(view);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setCanvasView(view);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setMatrix(Matrix matrix) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) matrix);
            return;
        }
        super.setMatrix(matrix);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setMatrix(matrix);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setPx(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, this, Float.valueOf(f16));
            return;
        }
        super.setPx(f16);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setPx(f16);
        }
    }

    @Override // com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer
    public void setPy(float f16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16));
            return;
        }
        super.setPy(f16);
        Iterator<AnimatorLayer> it = this.mLayers.iterator();
        while (it.hasNext()) {
            it.next().setPy(f16);
        }
    }
}
