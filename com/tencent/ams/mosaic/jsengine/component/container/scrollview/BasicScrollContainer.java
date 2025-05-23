package com.tencent.ams.mosaic.jsengine.component.container.scrollview;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.facebook.yoga.YogaValue;
import com.tencent.ams.hippo.quickjs.android.JSFunction;
import com.tencent.ams.hippo.quickjs.android.JSObject;
import com.tencent.ams.mosaic.jsengine.component.ComponentBase;
import com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent;
import com.tencent.ams.mosaic.jsengine.component.container.FlexContainerImpl;
import com.tencent.ams.mosaic.jsengine.component.container.scrollview.b;
import com.tencent.ams.mosaic.utils.MosaicUtils;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class BasicScrollContainer<T extends b> extends ContainerComponent implements Scroll, c {
    static IPatchRedirector $redirector_;

    @NonNull
    protected Context C;
    private int D;
    private int E;

    /* renamed from: e, reason: collision with root package name */
    @NonNull
    protected final T f71095e;

    /* renamed from: f, reason: collision with root package name */
    protected ViewGroup f71096f;

    /* renamed from: h, reason: collision with root package name */
    protected FlexContainerImpl f71097h;

    /* renamed from: i, reason: collision with root package name */
    private JSFunction f71098i;

    /* renamed from: m, reason: collision with root package name */
    private JSFunction f71099m;

    public BasicScrollContainer(Context context, String str, float f16, float f17) {
        super(context, str, f16, f17);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, context, str, Float.valueOf(f16), Float.valueOf(f17));
        } else {
            this.C = context;
            this.f71095e = w(context);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void y(boolean z16) {
        getView().setScrollbarFadingEnabled(z16);
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.container.Container
    public boolean addChild(ComponentBase componentBase) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this, (Object) componentBase)).booleanValue();
        }
        if (super.addChild(componentBase)) {
            return true;
        }
        v();
        FlexContainerImpl flexContainerImpl = this.f71097h;
        if (flexContainerImpl == null) {
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(r(componentBase), p(componentBase));
            layoutParams.leftMargin = componentBase.getLeftMargin();
            layoutParams.rightMargin = componentBase.getRightMargin();
            layoutParams.topMargin = componentBase.getTopMargin();
            layoutParams.bottomMargin = componentBase.getBottomMargin();
            if (!TextUtils.isEmpty(componentBase.getAlignParent())) {
                layoutParams.gravity = covertAlignSplice(componentBase.getAlignParent());
            }
            s(componentBase, this.f71096f, layoutParams);
        } else {
            flexContainerImpl.addChild(componentBase);
        }
        return true;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.c
    public void onScrollChange(View view, int i3, int i16, int i17, int i18) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, view, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), Integer.valueOf(i18));
            return;
        }
        this.D = i3;
        this.E = i16;
        if (this.f71098i != null) {
            getJSEngine().u(this.f71098i, new Object[]{Float.valueOf(MosaicUtils.E(i3)), Float.valueOf(MosaicUtils.E(i16)), Float.valueOf(MosaicUtils.E(i17)), Float.valueOf(MosaicUtils.E(i18))}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.c
    public void onScrollStop(View view) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) view);
            return;
        }
        f.e(tag(), "onScrollStop mScrollEndX\uff1a" + this.D + " mScrollEndY\uff1a" + this.E);
        if (this.f71099m != null) {
            getJSEngine().u(this.f71099m, new Object[]{Float.valueOf(MosaicUtils.E(this.D)), Float.valueOf(MosaicUtils.E(this.E))}, null);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.ComponentBase, com.tencent.ams.mosaic.jsengine.component.Component
    public void setFlexLayout(JSObject jSObject) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSObject);
            return;
        }
        if (!MosaicUtils.D()) {
            f.h(tag(), "setFlexLayout failed: not support yoga");
            return;
        }
        if (this.f71097h == null) {
            FlexContainerImpl flexContainerImpl = new FlexContainerImpl(this.C, "", 0.0f, 0.0f);
            this.f71097h = flexContainerImpl;
            flexContainerImpl.setJSEngine(getJSEngine());
        }
        this.f71097h.setFlexLayout(jSObject);
        YogaNode yogaNode = (YogaNode) this.f71097h.getYogaNode();
        if (yogaNode != null) {
            YogaNode yogaNode2 = (YogaNode) this.mYogaNode;
            if (yogaNode2 == null) {
                yogaNode2 = YogaNodeFactory.create();
            }
            YogaValue width = yogaNode.getWidth();
            YogaValue height = yogaNode.getHeight();
            if (width != null) {
                yogaNode2.setWidth(width.value);
            }
            if (height != null) {
                yogaNode2.setHeight(height.value);
            }
            yogaNode.setWidthAuto();
            yogaNode.setHeightAuto();
            YogaEdge yogaEdge = YogaEdge.LEFT;
            YogaValue margin = yogaNode.getMargin(yogaEdge);
            YogaEdge yogaEdge2 = YogaEdge.TOP;
            YogaValue margin2 = yogaNode.getMargin(yogaEdge2);
            YogaEdge yogaEdge3 = YogaEdge.RIGHT;
            YogaValue margin3 = yogaNode.getMargin(yogaEdge3);
            YogaEdge yogaEdge4 = YogaEdge.BOTTOM;
            YogaValue margin4 = yogaNode.getMargin(yogaEdge4);
            if (margin != null) {
                yogaNode2.setMargin(yogaEdge, margin.value);
            }
            if (margin2 != null) {
                yogaNode2.setMargin(yogaEdge2, margin2.value);
            }
            if (margin3 != null) {
                yogaNode2.setMargin(yogaEdge3, margin3.value);
            }
            if (margin4 != null) {
                yogaNode2.setMargin(yogaEdge4, margin4.value);
            }
            this.mYogaNode = yogaNode2;
            setSize(this.f71097h.getWidth(), this.f71097h.getHeight());
            return;
        }
        this.f71097h = null;
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public void setScrollIndicatorFadingEnabled(final boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, z16);
        } else {
            MosaicUtils.I(new Runnable() { // from class: com.tencent.ams.mosaic.jsengine.component.container.scrollview.a
                @Override // java.lang.Runnable
                public final void run() {
                    BasicScrollContainer.this.y(z16);
                }
            });
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.component.container.scrollview.Scroll
    public void setScrollListener(JSFunction jSFunction, JSFunction jSFunction2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) jSFunction, (Object) jSFunction2);
        } else {
            this.f71098i = jSFunction;
            this.f71099m = jSFunction2;
        }
    }

    protected void v() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.f71096f == null) {
            FlexContainerImpl flexContainerImpl = this.f71097h;
            if (flexContainerImpl == null) {
                this.f71096f = new LinearLayout(this.C);
            } else {
                this.f71096f = flexContainerImpl.getView();
            }
            x();
        }
    }

    @NonNull
    protected abstract T w(Context context);

    protected abstract void x();

    @Override // com.tencent.ams.mosaic.jsengine.component.container.ContainerComponent, com.tencent.ams.mosaic.jsengine.component.Component
    @NonNull
    public ViewGroup getView() {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.f71095e.getView() : (ViewGroup) iPatchRedirector.redirect((short) 2, (Object) this);
    }
}
