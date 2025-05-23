package com.tencent.ams.mosaic.jsengine.animation.layer.container;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import androidx.annotation.NonNull;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.MaskLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.RectangleShapeLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.animation.layer.ShapeLayer;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class ContainerLayerBase extends LayerBase<a> implements ContainerLayer {
    static IPatchRedirector $redirector_;
    protected final List<LayerBase> S;
    protected boolean T;

    public ContainerLayerBase(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.S = new ArrayList();
        }
    }

    private a e() {
        return (a) this.K;
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void addLayer(LayerBase layerBase) {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerBase);
            return;
        }
        if (layerBase != null && !this.S.contains(layerBase)) {
            this.S.add(layerBase);
            layerBase.setParent(this);
            ((a) this.K).addLayers(layerBase.getAnimatorLayer());
            g();
            if (layerBase.getAnimation() != null) {
                animator = (Animator) layerBase.getAnimation().getAnimator(layerBase);
            } else {
                animator = null;
            }
            AnimatorLayer animatorLayer = layerBase.getAnimatorLayer();
            if (animator == null) {
                animatorLayer.setAnimator(new KeepAnimator(animatorLayer));
            } else {
                animatorLayer.setAnimator(animator);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    @NonNull
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public a a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (a) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return new a();
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    public void draw(Canvas canvas) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) canvas);
            return;
        }
        f();
        super.draw(canvas);
        g();
        List<LayerBase> list = this.S;
        if (list != null) {
            Iterator<LayerBase> it = list.iterator();
            while (it.hasNext()) {
                it.next().draw(canvas);
            }
        }
    }

    protected void f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        a e16 = e();
        if (e16 != null) {
            for (AnimatorLayer animatorLayer : e16.getLayers()) {
                animatorLayer.setX(MosaicUtils.j(this.H));
                animatorLayer.setY(MosaicUtils.j(this.I));
                animatorLayer.setWidth((int) MosaicUtils.j(this.f70736h));
                animatorLayer.setHeight((int) MosaicUtils.j(this.f70737i));
            }
        }
    }

    protected abstract void g();

    /* JADX INFO: Access modifiers changed from: protected */
    public float[] h(float f16, float f17, float f18, float f19, float f26, float f27) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return (float[]) iPatchRedirector.redirect((short) 11, this, Float.valueOf(f16), Float.valueOf(f17), Float.valueOf(f18), Float.valueOf(f19), Float.valueOf(f26), Float.valueOf(f27));
        }
        float x16 = getX();
        float y16 = getY();
        float f28 = f16 + x16;
        float f29 = f17 + y16;
        if (this.T) {
            if (f28 < x16) {
                f28 = x16;
            }
            float f36 = x16 + f26;
            if (f28 + f18 > f36) {
                f18 = (int) (f36 - f28);
                if (f18 < 0.0f) {
                    f18 = 0.0f;
                }
            }
            if (f29 < y16) {
                f29 = y16;
            }
            float f37 = y16 + f27;
            if (f29 + f19 > f37) {
                f19 = (int) (f37 - f29);
                if (f19 < 0.0f) {
                    f19 = 0.0f;
                }
            }
        }
        return new float[]{f28, f29, f18, f19};
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void masksToBounds(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.T = z16;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase
    public void notifyAnimationStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
            return;
        }
        super.notifyAnimationStart();
        Iterator<LayerBase> it = this.S.iterator();
        while (it.hasNext()) {
            it.next().notifyAnimationStart();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeAllLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.S.clear();
            ((a) this.K).clear();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeLayer(LayerBase layerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) layerBase);
        } else {
            this.S.remove(layerBase);
            ((a) this.K).removeLayer(layerBase.getAnimatorLayer());
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setBackgroundColor(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
            return;
        }
        a e16 = e();
        if (e16 != null) {
            RectangleShapeLayer rectangleShapeLayer = new RectangleShapeLayer((int) MosaicUtils.j(this.f70736h), (int) MosaicUtils.j(this.f70737i), MosaicUtils.O(str));
            rectangleShapeLayer.setAnimator(new KeepAnimator(rectangleShapeLayer));
            e16.addLayer(rectangleShapeLayer);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase, com.tencent.ams.mosaic.jsengine.animation.layer.Layer
    public void setMaskLayer(ShapeLayer shapeLayer, int i3) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) shapeLayer, i3);
            return;
        }
        a e16 = e();
        if (e16 != null) {
            Path path = shapeLayer.getPath();
            if (i3 == 1) {
                i16 = 0;
            } else {
                i16 = 1;
            }
            MaskLayer maskLayer = new MaskLayer(path, i16);
            maskLayer.setAnimator(new KeepAnimator(maskLayer));
            e16.addLayers(maskLayer);
        }
    }
}
