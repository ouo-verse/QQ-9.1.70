package com.tencent.kuikly.core.views;

import com.tencent.ams.mosaic.jsengine.component.video.VideoComponent;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b-\u0010.J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0010\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0010\u0010\u0010\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0002J \u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J \u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J \u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0002J\b\u0010\u0018\u001a\u00020\u0005H\u0016J\u0018\u0010\u001b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\u0018\u0010\u001c\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010\u001e\u001a\u00020\u0005H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020\u0002H\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016J(\u0010'\u001a\u00020\u00052\u0006\u0010$\u001a\u00020#2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010&\u001a\u00020%H\u0016R\u0018\u0010)\u001a\u0004\u0018\u00010(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010+\u001a\u00020\t8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,\u00a8\u0006/"}, d2 = {"Lcom/tencent/kuikly/core/views/TextView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/ce;", "Lcom/tencent/kuikly/core/views/TextEvent;", "Lcom/tencent/kuikly/core/layout/f;", "", "tryFireLineBreakMarginEvent", "", "propKey", "", "canSyncToRenderView", "isShadowProp", "", "height", "measureHeightToFloat", "width", "measureWidthToFloat", "Lcom/tencent/kuikly/core/base/w;", "measureOutputSize", VideoComponent.ScaleType.FIT_WIDTH, VideoComponent.ScaleType.FIT_HEIGHT, "widthLayoutSize", "heightLayoutSize", "flexLayoutSize", "willInit", "", "propValue", "didSetProp", "syncProp", "createFlexNode", "createRenderView", "didRemoveFromParentView", "createAttr", "createEvent", "viewName", "Lcom/tencent/kuikly/core/layout/FlexNode;", "node", "Lcom/tencent/kuikly/core/layout/g;", "measureOutput", "measure", "Lm01/b;", "shadow", "Lm01/b;", "didLayout", "Z", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class TextView extends DeclarativeBaseView<ce, TextEvent> implements com.tencent.kuikly.core.layout.f {
    private boolean didLayout;
    private m01.b shadow;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ TextEvent access$getEvent(TextView textView) {
        return (TextEvent) textView.getEvent();
    }

    private final boolean canSyncToRenderView(String propKey) {
        switch (propKey.hashCode()) {
            case -823812830:
                return !propKey.equals("values");
            case 3556653:
                return !propKey.equals("text");
            case 94842723:
                return !propKey.equals("color");
            case 365601008:
                return !propKey.equals("fontSize");
            default:
                return true;
        }
    }

    private final com.tencent.kuikly.core.base.w flexLayoutSize(com.tencent.kuikly.core.base.w measureOutputSize, float fitWidth, float fitHeight) {
        FlexNode flexNode = getFlexNode().getCom.tencent.mtt.hippy.views.common.HippyNestedScrollComponent.PRIORITY_PARENT java.lang.String();
        FlexDirection j3 = flexNode != null ? flexNode.j() : null;
        if (j3 != FlexDirection.ROW && j3 != FlexDirection.ROW_REVERSE) {
            if (Float.isNaN(fitHeight)) {
                return measureOutputSize;
            }
            float height = measureOutputSize.getHeight();
            if (height >= fitHeight) {
                fitHeight = height;
            }
            return new com.tencent.kuikly.core.base.w(measureOutputSize.getWidth(), fitHeight);
        }
        if (Float.isNaN(fitWidth)) {
            return measureOutputSize;
        }
        float width = measureOutputSize.getWidth();
        if (width >= fitWidth) {
            fitWidth = width;
        }
        return new com.tencent.kuikly.core.base.w(fitWidth, measureOutputSize.getHeight());
    }

    private final com.tencent.kuikly.core.base.w heightLayoutSize(com.tencent.kuikly.core.base.w measureOutputSize, float fitWidth, float fitHeight) {
        if (Float.isNaN(fitHeight)) {
            return measureOutputSize;
        }
        float height = measureOutputSize.getHeight();
        if (height >= fitHeight) {
            fitHeight = height;
        }
        return new com.tencent.kuikly.core.base.w(measureOutputSize.getWidth(), fitHeight);
    }

    private final boolean isShadowProp(String propKey) {
        switch (propKey.hashCode()) {
            case -1267206133:
                return !propKey.equals("opacity");
            case 1052666732:
                return !propKey.equals("transform");
            case 1287124693:
                return !propKey.equals("backgroundColor");
            case 1941332754:
                return !propKey.equals("visibility");
            default:
                return true;
        }
    }

    private final float measureHeightToFloat(float height) {
        if (Float.isNaN(height)) {
            return -1.0f;
        }
        return height;
    }

    private final float measureWidthToFloat(float width) {
        if (Float.isNaN(width)) {
            return 100000.0f;
        }
        return width;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void tryFireLineBreakMarginEvent() {
        if (((ce) getAttr()).getProp("lineBreakMargin") != null) {
            getPager().addTaskWhenPagerDidCalculateLayout(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.TextView$tryFireLineBreakMarginEvent$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    m01.b bVar;
                    Function1<Object, Unit> handler$core_release;
                    bVar = TextView.this.shadow;
                    if (!Intrinsics.areEqual(bVar != null ? bVar.callMethod("isLineBreakMargin", "") : null, "1") || (handler$core_release = TextView.access$getEvent(TextView.this).getHandler$core_release()) == null) {
                        return;
                    }
                    handler$core_release.invoke(null);
                }
            });
        }
    }

    private final com.tencent.kuikly.core.base.w widthLayoutSize(com.tencent.kuikly.core.base.w measureOutputSize, float fitWidth, float fitHeight) {
        if (Float.isNaN(fitWidth)) {
            return measureOutputSize;
        }
        float width = measureOutputSize.getWidth();
        if (width >= fitWidth) {
            fitWidth = width;
        }
        return new com.tencent.kuikly.core.base.w(fitWidth, measureOutputSize.getHeight());
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void createFlexNode() {
        super.createFlexNode();
        getFlexNode().B0(this);
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void createRenderView() {
        RenderView renderView;
        super.createRenderView();
        if (!this.didLayout || (renderView = getRenderView()) == null) {
            return;
        }
        renderView.l();
    }

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView
    public void didRemoveFromParentView() {
        super.didRemoveFromParentView();
        getFlexNode().B0(null);
        m01.b bVar = this.shadow;
        if (bVar != null) {
            bVar.removeFromParentComponent();
        }
        this.shadow = null;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didSetProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (canSyncToRenderView(propKey)) {
            super.didSetProp(propKey, propValue);
        }
        if (isShadowProp(propKey)) {
            m01.b bVar = this.shadow;
            if (bVar != null) {
                bVar.setProp(propKey, propValue);
            }
            getFlexNode().a0();
        }
    }

    public void measure(FlexNode node, float width, float height, com.tencent.kuikly.core.layout.g measureOutput) {
        com.tencent.kuikly.core.base.w wVar;
        RenderView renderView;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(measureOutput, "measureOutput");
        float measureHeightToFloat = measureHeightToFloat(height);
        float measureWidthToFloat = measureWidthToFloat(width);
        m01.b bVar = this.shadow;
        if (bVar == null || (wVar = bVar.calculateRenderViewSize(measureWidthToFloat, measureHeightToFloat)) == null) {
            wVar = new com.tencent.kuikly.core.base.w(0.0f, 0.0f);
        }
        boolean z16 = false;
        if (!(getFlexNode().i() == 0.0f) && getFlexNode().G() == FlexPositionType.RELATIVE) {
            wVar = flexLayoutSize(wVar, width, height);
        }
        if (!Float.isNaN(getFlexNode().U())) {
            wVar = new com.tencent.kuikly.core.base.w(getFlexNode().U(), wVar.getHeight());
        }
        if (!Float.isNaN(getFlexNode().P())) {
            wVar = widthLayoutSize(wVar, getFlexNode().P(), height);
        }
        if (!Float.isNaN(getFlexNode().K())) {
            wVar = new com.tencent.kuikly.core.base.w(wVar.getWidth(), getFlexNode().K());
        }
        if (!Float.isNaN(getFlexNode().O())) {
            wVar = heightLayoutSize(wVar, width, getFlexNode().O());
        }
        this.didLayout = true;
        m01.b bVar2 = this.shadow;
        if (bVar2 != null && bVar2.getCalculateFromCache()) {
            z16 = true;
        }
        if (!z16 && (renderView = getRenderView()) != null) {
            renderView.l();
        }
        measureOutput.d(wVar != null ? wVar.getWidth() : 0.0f);
        measureOutput.c(wVar != null ? wVar.getHeight() : 0.0f);
        tryFireLineBreakMarginEvent();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void syncProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (canSyncToRenderView(propKey)) {
            super.syncProp(propKey, propValue);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public String viewName() {
        if (((ce) getAttr()).getDidSetTextGradient()) {
            return "KRGradientRichTextView";
        }
        return "KRRichTextView";
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        this.shadow = new m01.b(getPagerId(), getNativeRef(), viewName());
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public ce createAttr() {
        return new ce();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public TextEvent createEvent() {
        return new TextEvent();
    }
}
