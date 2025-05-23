package com.tencent.hippykotlin.demo.pages.base.view;

import com.tencent.kuikly.core.base.Attr;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.kuikly.core.base.w;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.layout.f;
import com.tencent.kuikly.core.layout.g;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class QQComposeMarkdownView extends DeclarativeBaseView<QQComposeMarkdownViewAttr, QQComposeMarkdownViewEvent> implements f {
    public boolean didLayout;
    public QQComposeMarkdownViewShadow shadow;

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Attr createAttr() {
        return new QQComposeMarkdownViewAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final Event createEvent() {
        return new QQComposeMarkdownViewEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void createFlexNode() {
        super.createFlexNode();
        getFlexNode().B0(this);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void createRenderView() {
        RenderView renderView;
        super.createRenderView();
        if (!this.didLayout || (renderView = getRenderView()) == null) {
            return;
        }
        renderView.l();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public final void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getFlexNode().B0(null);
        QQComposeMarkdownViewShadow qQComposeMarkdownViewShadow = this.shadow;
        if (qQComposeMarkdownViewShadow != null) {
            qQComposeMarkdownViewShadow.removeFromParentComponent();
        }
        this.shadow = null;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void didSetProp(String str, Object obj) {
        super.didSetProp(str, obj);
        int hashCode = str.hashCode();
        if (hashCode == -1267206133 ? !str.equals("opacity") : hashCode == 1052666732 ? !str.equals("transform") : !(hashCode == 1287124693 ? str.equals("backgroundColor") : hashCode == 1941332754 && str.equals("visibility"))) {
            QQComposeMarkdownViewShadow qQComposeMarkdownViewShadow = this.shadow;
            if (qQComposeMarkdownViewShadow != null) {
                qQComposeMarkdownViewShadow.setProp(str, obj);
            }
            getFlexNode().a0();
        }
    }

    @Override // com.tencent.kuikly.core.layout.f
    public final void measure(FlexNode flexNode, float f16, float f17, g gVar) {
        w wVar;
        RenderView renderView;
        float f18 = Float.isNaN(f17) ? -1.0f : f17;
        float f19 = Float.isNaN(f16) ? 100000.0f : f16;
        QQComposeMarkdownViewShadow qQComposeMarkdownViewShadow = this.shadow;
        if (qQComposeMarkdownViewShadow == null || (wVar = qQComposeMarkdownViewShadow.calculateRenderViewSize(f19, f18)) == null) {
            wVar = new w(0.0f, 0.0f);
        }
        boolean z16 = false;
        if (!(getFlexNode().i() == 0.0f) && getFlexNode().G() == FlexPositionType.RELATIVE) {
            FlexNode flexNode2 = getFlexNode().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String();
            FlexDirection j3 = flexNode2 != null ? flexNode2.j() : null;
            if (j3 != FlexDirection.ROW && j3 != FlexDirection.ROW_REVERSE) {
                if (!Float.isNaN(f17)) {
                    float height = wVar.getHeight();
                    if (height >= f17) {
                        f17 = height;
                    }
                    wVar = new w(wVar.getWidth(), f17);
                }
            } else if (!Float.isNaN(f16)) {
                float width = wVar.getWidth();
                if (width >= f16) {
                    f16 = width;
                }
                wVar = new w(f16, wVar.getHeight());
            }
        }
        if (!Float.isNaN(getFlexNode().U())) {
            wVar = new w(getFlexNode().U(), wVar.getHeight());
        }
        if (!Float.isNaN(getFlexNode().P())) {
            float P = getFlexNode().P();
            if (!Float.isNaN(P)) {
                float width2 = wVar.getWidth();
                if (width2 >= P) {
                    P = width2;
                }
                wVar = new w(P, wVar.getHeight());
            }
        }
        if (!Float.isNaN(getFlexNode().K())) {
            wVar = new w(wVar.getWidth(), getFlexNode().K());
        }
        if (!Float.isNaN(getFlexNode().O())) {
            float O = getFlexNode().O();
            if (!Float.isNaN(O)) {
                float height2 = wVar.getHeight();
                if (height2 >= O) {
                    O = height2;
                }
                wVar = new w(wVar.getWidth(), O);
            }
        }
        this.didLayout = true;
        QQComposeMarkdownViewShadow qQComposeMarkdownViewShadow2 = this.shadow;
        if (qQComposeMarkdownViewShadow2 != null && qQComposeMarkdownViewShadow2.calculateFromCache) {
            z16 = true;
        }
        if (!z16 && (renderView = getRenderView()) != null) {
            renderView.l();
        }
        gVar.d(wVar.getWidth());
        gVar.c(wVar.getHeight());
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final String viewName() {
        return "QQComposeMarkdownView";
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public final void willInit() {
        super.willInit();
        this.shadow = new QQComposeMarkdownViewShadow(getPagerId(), getNativeRef());
    }
}
