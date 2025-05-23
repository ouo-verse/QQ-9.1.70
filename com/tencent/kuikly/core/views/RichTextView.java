package com.tencent.kuikly.core.views;

import com.tencent.ams.mosaic.jsengine.component.video.VideoComponent;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.RenderView;
import com.tencent.kuikly.core.layout.FlexDirection;
import com.tencent.kuikly.core.layout.FlexNode;
import com.tencent.kuikly.core.layout.FlexPositionType;
import com.tencent.kuikly.core.log.KLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringNumberConversionsJVMKt;
import kotlin.text.StringsKt__StringsKt;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\b\u0016\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0007\u00a2\u0006\u0004\b>\u0010?J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\u0005H\u0002J\u0010\u0010\u000f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0010\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\rH\u0002J \u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J \u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\b\u0010\u0019\u001a\u00020\nH\u0002J\b\u0010\u001a\u001a\u00020\nH\u0016J!\u0010\u001e\u001a\u00020\n2\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u001b\u00a2\u0006\u0002\b\u001cH\u0016J\u0018\u0010!\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\u0018\u0010\"\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u001fH\u0016J\b\u0010#\u001a\u00020\u0003H\u0016J\b\u0010$\u001a\u00020\nH\u0016J\b\u0010%\u001a\u00020\nH\u0016J\b\u0010&\u001a\u00020\nH\u0016J\b\u0010'\u001a\u00020\u0002H\u0016J\b\u0010(\u001a\u00020\u0005H\u0016J(\u0010-\u001a\u00020\n2\u0006\u0010*\u001a\u00020)2\u0006\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010,\u001a\u00020+H\u0016R\u0018\u0010/\u001a\u0004\u0018\u00010.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u0016\u00101\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R5\u00103\u001a\u0015\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n\u0018\u00010\u001b\u00a2\u0006\u0002\b\u001c8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b3\u00104\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\"\u00109\u001a\u00020\u00078\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b9\u00102\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=\u00a8\u0006@"}, d2 = {"Lcom/tencent/kuikly/core/views/RichTextView;", "Lcom/tencent/kuikly/core/base/DeclarativeBaseView;", "Lcom/tencent/kuikly/core/views/RichTextAttr;", "Lcom/tencent/kuikly/core/views/RichTextEvent;", "Lcom/tencent/kuikly/core/layout/f;", "", "propKey", "", "canSyncToRenderView", "isShadowProp", "", "tryFireLineBreakMarginEvent", "buildValuesPropValue", "", "height", "measureHeightToFloat", "width", "measureWidthToFloat", "Lcom/tencent/kuikly/core/base/w;", "measureOutputSize", VideoComponent.ScaleType.FIT_WIDTH, VideoComponent.ScaleType.FIT_HEIGHT, "flexLayoutSize", "widthLayoutSize", "heightLayoutSize", "dispatchPlaceholderSpanLayoutEventIfNeed", "willInit", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "init", "attr", "", "propValue", "didSetProp", "syncProp", "createEvent", "createFlexNode", "createRenderView", "didRemoveFromParentView", "createAttr", "viewName", "Lcom/tencent/kuikly/core/layout/FlexNode;", "node", "Lcom/tencent/kuikly/core/layout/g;", "measureOutput", "measure", "Lm01/a;", "shadow", "Lm01/a;", "didLayout", "Z", "attrInitBlock", "Lkotlin/jvm/functions/Function1;", "getAttrInitBlock$core_release", "()Lkotlin/jvm/functions/Function1;", "setAttrInitBlock$core_release", "(Lkotlin/jvm/functions/Function1;)V", "isWillInit", "isWillInit$core_release", "()Z", "setWillInit$core_release", "(Z)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class RichTextView extends DeclarativeBaseView<RichTextAttr, RichTextEvent> implements com.tencent.kuikly.core.layout.f {
    private Function1<? super RichTextAttr, Unit> attrInitBlock;
    private boolean didLayout;
    private boolean isWillInit;
    private m01.a shadow;

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RichTextAttr access$getAttr(RichTextView richTextView) {
        return (RichTextAttr) richTextView.getAttr();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ RichTextEvent access$getEvent(RichTextView richTextView) {
        return (RichTextEvent) richTextView.getEvent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final String buildValuesPropValue() {
        ArrayList arrayList = new ArrayList();
        for (ae aeVar : ((RichTextAttr) getAttr()).getSpans$core_release()) {
            HashMap hashMap = new HashMap();
            hashMap.putAll(aeVar.g());
            if (!hashMap.isEmpty()) {
                arrayList.add(hashMap);
            }
        }
        return b01.c.a(arrayList).toString();
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

    /* JADX WARN: Multi-variable type inference failed */
    private final void dispatchPlaceholderSpanLayoutEventIfNeed() {
        for (final ae aeVar : ((RichTextAttr) getAttr()).getSpans$core_release()) {
            if ((aeVar instanceof bg) && ((bg) aeVar).h() != null) {
                getPager().addTaskWhenPagerUpdateLayoutFinish(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.RichTextView$dispatchPlaceholderSpanLayoutEventIfNeed$1$1
                    /* JADX INFO: Access modifiers changed from: package-private */
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Removed duplicated region for block: B:14:0x003b  */
                    /* JADX WARN: Removed duplicated region for block: B:36:? A[RETURN, SYNTHETIC] */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final void invoke2() {
                        m01.a aVar;
                        boolean z16;
                        List split$default;
                        Float floatOrNull;
                        Float floatOrNull2;
                        Float floatOrNull3;
                        Float floatOrNull4;
                        int indexOf = RichTextView.access$getAttr(RichTextView.this).getSpans$core_release().indexOf(aeVar);
                        if (indexOf < 0) {
                            return;
                        }
                        aVar = RichTextView.this.shadow;
                        String callMethod = aVar != null ? aVar.callMethod("spanRect", String.valueOf(indexOf)) : null;
                        if (callMethod != null) {
                            if (callMethod.length() > 0) {
                                z16 = true;
                                if (z16) {
                                    return;
                                }
                                split$default = StringsKt__StringsKt.split$default((CharSequence) callMethod, new String[]{" "}, false, 0, 6, (Object) null);
                                ae aeVar2 = aeVar;
                                if (split$default.size() >= 4) {
                                    bg bgVar = (bg) aeVar2;
                                    floatOrNull = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull((String) split$default.get(0));
                                    float floatValue = floatOrNull != null ? floatOrNull.floatValue() : 0.0f;
                                    floatOrNull2 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull((String) split$default.get(1));
                                    float floatValue2 = floatOrNull2 != null ? floatOrNull2.floatValue() : 0.0f;
                                    floatOrNull3 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull((String) split$default.get(2));
                                    float floatValue3 = floatOrNull3 != null ? floatOrNull3.floatValue() : 0.0f;
                                    floatOrNull4 = StringsKt__StringNumberConversionsJVMKt.toFloatOrNull((String) split$default.get(3));
                                    bgVar.j(new com.tencent.kuikly.core.layout.d(floatValue, floatValue2, floatValue3, floatOrNull4 != null ? floatOrNull4.floatValue() : 0.0f));
                                    return;
                                }
                                KLog.INSTANCE.e("KuiklyCore", "spanRect result is error:" + callMethod);
                                return;
                            }
                        }
                        z16 = false;
                        if (z16) {
                        }
                    }
                });
            }
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
        if (((RichTextAttr) getAttr()).getProp("lineBreakMargin") != null) {
            getPager().addTaskWhenPagerDidCalculateLayout(new Function0<Unit>() { // from class: com.tencent.kuikly.core.views.RichTextView$tryFireLineBreakMarginEvent$1
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
                    m01.a aVar;
                    Function1<Object, Unit> handler$core_release;
                    aVar = RichTextView.this.shadow;
                    if (!Intrinsics.areEqual(aVar != null ? aVar.callMethod("isLineBreakMargin", "") : null, "1") || (handler$core_release = RichTextView.access$getEvent(RichTextView.this).getHandler$core_release()) == null) {
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

    @Override // com.tencent.kuikly.core.base.DeclarativeBaseView, com.tencent.kuikly.core.base.q
    public void attr(Function1<? super RichTextAttr, Unit> init) {
        Intrinsics.checkNotNullParameter(init, "init");
        if (this.isWillInit) {
            this.attrInitBlock = init;
        } else {
            super.attr(init);
        }
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
        m01.a aVar = this.shadow;
        if (aVar != null) {
            aVar.removeFromParentComponent();
        }
        this.shadow = null;
        this.attrInitBlock = null;
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void didSetProp(String propKey, Object propValue) {
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        Intrinsics.checkNotNullParameter(propValue, "propValue");
        if (canSyncToRenderView(propKey)) {
            super.didSetProp(propKey, propValue);
        }
        if (isShadowProp(propKey)) {
            m01.a aVar = this.shadow;
            if (aVar != null) {
                aVar.setProp(propKey, propValue);
            }
            getFlexNode().a0();
        }
    }

    public final Function1<RichTextAttr, Unit> getAttrInitBlock$core_release() {
        return this.attrInitBlock;
    }

    /* renamed from: isWillInit$core_release, reason: from getter */
    public final boolean getIsWillInit() {
        return this.isWillInit;
    }

    public void measure(FlexNode node, float width, float height, com.tencent.kuikly.core.layout.g measureOutput) {
        com.tencent.kuikly.core.base.w wVar;
        RenderView renderView;
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(measureOutput, "measureOutput");
        float measureHeightToFloat = measureHeightToFloat(height);
        float measureWidthToFloat = measureWidthToFloat(width);
        m01.a aVar = this.shadow;
        if (aVar != null) {
            aVar.d(buildValuesPropValue());
        }
        m01.a aVar2 = this.shadow;
        if (aVar2 == null || (wVar = aVar2.calculateRenderViewSize(measureWidthToFloat, measureHeightToFloat)) == null) {
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
        m01.a aVar3 = this.shadow;
        if (aVar3 != null && aVar3.getCalculateFromCache()) {
            z16 = true;
        }
        if (!z16 && (renderView = getRenderView()) != null) {
            renderView.l();
        }
        Intrinsics.checkNotNull(wVar);
        measureOutput.d(wVar.getWidth());
        measureOutput.c(wVar.getHeight());
        dispatchPlaceholderSpanLayoutEventIfNeed();
        tryFireLineBreakMarginEvent();
    }

    public final void setAttrInitBlock$core_release(Function1<? super RichTextAttr, Unit> function1) {
        this.attrInitBlock = function1;
    }

    public final void setWillInit$core_release(boolean z16) {
        this.isWillInit = z16;
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
        if (((RichTextAttr) getAttr()).getDidSetTextGradient()) {
            return "KRGradientRichTextView";
        }
        return "KRRichTextView";
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public void willInit() {
        super.willInit();
        this.shadow = new m01.a(getPagerId(), getNativeRef(), viewName());
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public RichTextAttr createAttr() {
        return new RichTextAttr();
    }

    @Override // com.tencent.kuikly.core.base.AbstractBaseView
    public RichTextEvent createEvent() {
        return new RichTextEvent();
    }
}
