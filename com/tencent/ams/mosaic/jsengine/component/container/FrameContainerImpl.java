package com.tencent.ams.mosaic.jsengine.component.container;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.List;

/* compiled from: P */
/* loaded from: classes3.dex */
public class FrameContainerImpl extends ContainerComponent {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    protected FrameLayout f71024e;

    /* compiled from: P */
    @SuppressLint({"ViewConstructor"})
    /* loaded from: classes3.dex */
    protected static class FrameLayoutWrapper extends FrameLayout {
        static IPatchRedirector $redirector_;

        /* renamed from: d, reason: collision with root package name */
        private ContainerComponent f71025d;

        public FrameLayoutWrapper(@NonNull Context context, ContainerComponent containerComponent) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) containerComponent);
            } else {
                this.f71025d = containerComponent;
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
                return;
            }
            ContainerComponent containerComponent = this.f71025d;
            if (containerComponent != null) {
                containerComponent.o(canvas);
            }
            super.dispatchDraw(canvas);
        }

        @Override // android.view.View
        public void onDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) canvas);
                return;
            }
            super.onDraw(canvas);
            ContainerComponent containerComponent = this.f71025d;
            if (containerComponent != null) {
                containerComponent.onDraw(canvas);
            }
        }
    }

    public FrameContainerImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71024e = new FrameLayoutWrapper(context, this);
        }
    }

    private int u(List<ComponentBase> list, ComponentBase componentBase) {
        if (list != null && list.size() > 0) {
            for (int i3 = 0; i3 <= list.size() - 1; i3++) {
                if (componentBase.getZIndex() < list.get(i3).getZIndex()) {
                    return i3;
                }
            }
            return -1;
        }
        return -1;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (super.addChild(componentBase)) {
            return true;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(r(componentBase), p(componentBase));
        if (componentBase.getPositionType() == 3) {
            v(componentBase, layoutParams);
        } else {
            layoutParams.leftMargin = componentBase.getLeftMargin();
            layoutParams.rightMargin = componentBase.getRightMargin();
            layoutParams.topMargin = componentBase.getTopMargin();
            layoutParams.bottomMargin = componentBase.getBottomMargin();
            if (!TextUtils.isEmpty(componentBase.getAlignParent())) {
                layoutParams.gravity = covertAlignSplice(componentBase.getAlignParent());
            }
        }
        s(componentBase, getView(), layoutParams);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent
    public int q(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) componentBase)).intValue();
        }
        if (componentBase.getZIndex() <= -1) {
            return -1;
        }
        return u(this.f71009d, componentBase);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "FrameContainerImpl";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void v(ComponentBase componentBase, FrameLayout.LayoutParams layoutParams) {
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 5;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) componentBase, (Object) layoutParams);
            return;
        }
        if (componentBase == null || layoutParams == null) {
            return;
        }
        if (componentBase.getLeft() != -99198.0f) {
            layoutParams.leftMargin = (int) (componentBase.getLeft() + componentBase.getLeftMargin());
            i3 = 3;
        } else if (componentBase.getRight() != -99198.0f) {
            layoutParams.rightMargin = (int) (componentBase.getRight() + componentBase.getRightMargin());
        } else {
            i3 = 0;
        }
        if (componentBase.getTop() != -99198.0f) {
            layoutParams.topMargin = (int) (componentBase.getTop() + componentBase.getTopMargin());
            i3 |= 48;
        } else if (componentBase.getBottom() != -99198.0f) {
            layoutParams.bottomMargin = (int) (componentBase.getBottom() + componentBase.getBottomMargin());
            i3 |= 80;
        }
        if (i3 != 0) {
            layoutParams.gravity = i3;
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.f71024e : (ViewGroup) iPatchRedirector.redirect((short) 3, (Object) this);
    }
}
