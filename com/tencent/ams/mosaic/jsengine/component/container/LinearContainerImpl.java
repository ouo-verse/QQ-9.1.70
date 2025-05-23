package com.tencent.ams.mosaic.jsengine.component.container;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class LinearContainerImpl extends ContainerComponent implements Linear {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private final LinearLayout f71026e;

    /* compiled from: P */
    /* loaded from: classes3.dex */
    class a extends LinearLayout {
        static IPatchRedirector $redirector_;

        a(Context context) {
            super(context);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) LinearContainerImpl.this, (Object) context);
            }
        }

        @Override // android.view.ViewGroup, android.view.View
        protected void dispatchDraw(Canvas canvas) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) canvas);
            } else {
                LinearContainerImpl.this.o(canvas);
                super.dispatchDraw(canvas);
            }
        }
    }

    public LinearContainerImpl(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.f71026e = new a(context);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (super.addChild(componentBase)) {
            return true;
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(componentBase), p(componentBase));
        layoutParams.leftMargin = componentBase.getLeftMargin();
        layoutParams.rightMargin = componentBase.getRightMargin();
        layoutParams.topMargin = componentBase.getTopMargin();
        layoutParams.bottomMargin = componentBase.getBottomMargin();
        if (!TextUtils.isEmpty(componentBase.getAlignParent())) {
            layoutParams.gravity = covertAlignSplice(componentBase.getAlignParent());
        }
        s(componentBase, getView(), layoutParams);
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Linear
    public void setAlignItems(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        } else {
            this.f71026e.setGravity(covertAlignSplice(str));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.Linear
    public void setDirection(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        } else {
            this.f71026e.setOrientation("column".equals(str) ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase
    public String tag() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "LinearContainerImpl";
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.f71026e : (ViewGroup) iPatchRedirector.redirect((short) 4, (Object) this);
    }
}
