package com.tencent.ntcompose.material;

import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.views.TextEvent;
import com.tencent.kuikly.core.views.TextView;
import com.tencent.kuikly.core.views.ce;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.material.an;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/TextViewPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class TextViewPropUpdater implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final TextViewPropUpdater f339357a = new TextViewPropUpdater();

    TextViewPropUpdater() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0026. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v20, types: [com.tencent.kuikly.core.base.event.Event] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.TextView");
        ce ceVar = (ce) ((TextView) b16).getViewAttr();
        switch (propKey.hashCode()) {
            case -2015901959:
                if (propKey.equals("onTextWithLineBreak")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.TextWithLineBreakParams, kotlin.Unit>");
                    ((TextEvent) ((TextView) view.b()).getViewEvent()).onTextWithLineBreak((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1447136695:
                if (propKey.equals("includePadding")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    ceVar.includePadding(((Boolean) propArg0).booleanValue());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1408498779:
                if (propKey.equals("textPostProcessor")) {
                    ce ceVar2 = (ce) ((TextView) view.b()).getViewAttr();
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    ceVar2.textPostProcessor((String) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1105983751:
                if (propKey.equals("lineBreakMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    ceVar.lineBreakMargin(((Float) propArg0).floatValue());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case -1048634236:
                if (propKey.equals("textStyle")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.TextStyle");
                    TextKt.b(ceVar, (bp3.k) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 3556653:
                if (propKey.equals("text")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    ceVar.text((String) propArg0);
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 261414991:
                if (propKey.equals("textOverflow")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.TextOverflow");
                    int value = ((an) propArg0).getValue();
                    an.Companion companion = an.INSTANCE;
                    if (value == companion.a()) {
                        ceVar.textOverFlowClip();
                        return;
                    } else if (value == companion.c()) {
                        ceVar.textOverFlowMiddle();
                        return;
                    } else {
                        ceVar.textOverFlowTail();
                        return;
                    }
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 390232059:
                if (propKey.equals("maxLines")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                    ceVar.lines(((Integer) propArg0).intValue());
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 679753206:
                if (propKey.equals("onTextLayout")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] com.tencent.ntcompose.material.TextLayoutResult, kotlin.Unit>");
                    final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                    FrameEventKt.a(((TextView) view.b()).getViewEvent(), new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.TextViewPropUpdater$setPropToView$1
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(com.tencent.kuikly.core.layout.d dVar) {
                            invoke2(dVar);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(com.tencent.kuikly.core.layout.d it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            function1.invoke(new am(it));
                        }
                    });
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            case 1761302298:
                if (propKey.equals("onLineBreakMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    ((TextEvent) ((TextView) view.b()).getViewEvent()).onLineBreakMargin((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
            default:
                com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
                return;
        }
    }
}
