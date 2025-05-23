package com.tencent.ams.mosaic.jsengine.component.surface;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.ams.fusion.widget.animatorview.AnimatorView;
import com.tencent.ams.fusion.widget.animatorview.animator.Animator;
import com.tencent.ams.fusion.widget.animatorview.animator.KeepAnimator;
import com.tencent.ams.fusion.widget.animatorview.layer.AnimatorLayer;
import com.tencent.ams.fusion.widget.animatorview.layer.GroupLayer;
import com.tencent.ams.mosaic.jsengine.animation.layer.Layer;
import com.tencent.ams.mosaic.jsengine.animation.layer.LayerBase;
import com.tencent.ams.mosaic.jsengine.component.container.FrameContainerImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SurfaceComponentImpl extends FrameContainerImpl {
    static IPatchRedirector $redirector_;

    /* renamed from: f, reason: collision with root package name */
    private final a f71301f;

    /* renamed from: h, reason: collision with root package name */
    private final List<Layer> f71302h;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    static class a extends AnimatorView {
        static IPatchRedirector $redirector_;

        public a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            }
        }

        @Override // android.view.SurfaceView, android.view.View
        protected void onAttachedToWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            super.onAttachedToWindow();
            if (isUserStarted()) {
                startAnimation();
            }
        }

        @Override // android.view.SurfaceView, android.view.View
        protected void onDetachedFromWindow() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            } else {
                stopAnimation(true, false);
                super.onDetachedFromWindow();
            }
        }
    }

    public SurfaceComponentImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        this.f71302h = new ArrayList();
        a aVar = new a(context);
        this.f71301f = aVar;
        this.f71024e.addView(aVar, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void addLayer(LayerBase layerBase) {
        Animator animator;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) layerBase);
            return;
        }
        if (layerBase != null && !this.f71302h.contains(layerBase)) {
            layerBase.setParent(this);
            AnimatorLayer animatorLayer = layerBase.getAnimatorLayer();
            this.f71301f.addLayer(animatorLayer);
            if (layerBase.getAnimation() != null) {
                animator = (Animator) layerBase.getAnimation().getAnimator(layerBase);
            } else {
                animator = null;
            }
            if (!(animatorLayer instanceof GroupLayer) && animator == null) {
                animatorLayer.setAnimator(new KeepAnimator(animatorLayer));
            } else {
                animatorLayer.setAnimator(animator);
            }
            if (!this.f71301f.isUserStarted()) {
                this.f71301f.startAnimation();
                layerBase.notifyAnimationStart();
            }
            this.f71302h.add(layerBase);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeAllLayers() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.f71301f.clearLayers();
            this.f71301f.stopAnimation();
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.animation.layer.container.ContainerLayer
    public void removeLayer(LayerBase layerBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) layerBase);
            return;
        }
        if (layerBase != null) {
            this.f71301f.removeLayer(layerBase.getAnimatorLayer());
            this.f71302h.remove(layerBase);
            if (this.f71302h.isEmpty()) {
                this.f71301f.stopAnimation();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.container.FrameContainerImpl, com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this);
        }
        return "SurfaceComponentImpl";
    }
}
