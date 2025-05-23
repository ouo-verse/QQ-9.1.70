package com.tencent.ntcompose.material;

import bp3.a;
import com.tencent.kuikly.core.base.DeclarativeBaseView;
import com.tencent.kuikly.core.base.event.ClickParams;
import com.tencent.kuikly.core.base.event.FrameEventKt;
import com.tencent.kuikly.core.views.RichTextAttr;
import com.tencent.kuikly.core.views.RichTextEvent;
import com.tencent.kuikly.core.views.RichTextView;
import com.tencent.kuikly.core.views.bg;
import com.tencent.kuikly.core.views.cf;
import com.tencent.ntcompose.core.ComposeRenderView;
import com.tencent.ntcompose.material.an;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c2\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000f\u0010\u0010JJ\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u00062\b\u0010\n\u001a\u0004\u0018\u00010\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/ntcompose/material/RichTextViewPropUpdater;", "Lcom/tencent/ntcompose/core/f;", "Lcom/tencent/ntcompose/core/ComposeRenderView;", "view", "", "propKey", "", "propArg0", "propArg1", "propArg2", "propArg3", "propArg4", "", "setPropToView", "resetPropToView", "<init>", "()V", "ntcompose_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class RichTextViewPropUpdater implements com.tencent.ntcompose.core.f {

    /* renamed from: a, reason: collision with root package name */
    public static final RichTextViewPropUpdater f339353a = new RichTextViewPropUpdater();

    RichTextViewPropUpdater() {
    }

    @Override // com.tencent.ntcompose.core.f
    public void resetPropToView(ComposeRenderView view, String propKey) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.tencent.kuikly.core.base.event.Event] */
    @Override // com.tencent.ntcompose.core.f
    public void setPropToView(ComposeRenderView view, String propKey, Object propArg0, Object propArg1, Object propArg2, Object propArg3, Object propArg4) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(propKey, "propKey");
        DeclarativeBaseView<?, ?> b16 = view.b();
        Intrinsics.checkNotNull(b16, "null cannot be cast to non-null type com.tencent.kuikly.core.views.RichTextView");
        RichTextView richTextView = (RichTextView) b16;
        RichTextAttr richTextAttr = (RichTextAttr) richTextView.getViewAttr();
        switch (propKey.hashCode()) {
            case -2015901959:
                if (propKey.equals("onTextWithLineBreak")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<com.tencent.kuikly.core.views.TextWithLineBreakParams, kotlin.Unit>");
                    ((RichTextEvent) richTextView.getViewEvent()).onTextWithLineBreak((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                break;
            case -1447136695:
                if (propKey.equals("includePadding")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Boolean");
                    richTextAttr.includePadding(((Boolean) propArg0).booleanValue());
                    return;
                }
                break;
            case -1408498779:
                if (propKey.equals("textPostProcessor")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.String");
                    richTextAttr.textPostProcessor((String) propArg0);
                    return;
                }
                break;
            case -1105983751:
                if (propKey.equals("lineBreakMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Float");
                    richTextAttr.lineBreakMargin(((Float) propArg0).floatValue());
                    return;
                }
                break;
            case -1048634236:
                if (propKey.equals("textStyle")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.TextStyle");
                    TextKt.b(richTextAttr, (bp3.k) propArg0);
                    return;
                }
                break;
            case 3556653:
                if (propKey.equals("text")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.ui.text.AnnotatedString");
                    bp3.a aVar = (bp3.a) propArg0;
                    ArrayList<com.tencent.kuikly.core.views.ae> arrayList = new ArrayList<>();
                    richTextAttr.getExtProps().put("annotatedString", propArg0);
                    Iterator<T> it = aVar.c().iterator();
                    while (it.hasNext()) {
                        a.Range range = (a.Range) it.next();
                        if (range.b() instanceof bp3.i) {
                            bg placeholderSpan = ((bp3.i) range.b()).getPlaceholderSpan();
                            if (placeholderSpan != null) {
                                arrayList.add(placeholderSpan);
                            }
                        } else {
                            cf cfVar = new cf();
                            cfVar.setPagerId(richTextAttr.getPagerId());
                            cfVar.text(aVar.subSequence(range.getStart(), range.getEnd()).toString());
                            TextKt.b(cfVar, (bp3.k) range.b());
                            Function1<ClickParams, Unit> o16 = ((bp3.j) range.b()).o();
                            if (o16 != null) {
                                cfVar.click(o16);
                            }
                            arrayList.add(cfVar);
                        }
                    }
                    richTextAttr.spans(arrayList);
                    return;
                }
                break;
            case 261414991:
                if (propKey.equals("textOverflow")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type com.tencent.ntcompose.material.TextOverflow");
                    int value = ((an) propArg0).getValue();
                    an.Companion companion = an.INSTANCE;
                    if (value == companion.a()) {
                        richTextAttr.textOverFlowClip();
                        return;
                    } else if (value == companion.c()) {
                        richTextAttr.textOverFlowMiddle();
                        return;
                    } else {
                        richTextAttr.textOverFlowTail();
                        return;
                    }
                }
                break;
            case 390232059:
                if (propKey.equals("maxLines")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Int");
                    richTextAttr.lines(((Integer) propArg0).intValue());
                    return;
                }
                break;
            case 679753206:
                if (propKey.equals("onTextLayout")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'result')] com.tencent.ntcompose.material.TextLayoutResult, kotlin.Unit>");
                    final Function1 function1 = (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1);
                    FrameEventKt.a(richTextView.getViewEvent(), new Function1<com.tencent.kuikly.core.layout.d, Unit>() { // from class: com.tencent.ntcompose.material.RichTextViewPropUpdater$setPropToView$2
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
                        public final void invoke2(com.tencent.kuikly.core.layout.d it5) {
                            Intrinsics.checkNotNullParameter(it5, "it");
                            function1.invoke(new am(it5));
                        }
                    });
                    return;
                }
                break;
            case 722544206:
                if (propKey.equals("onClickCallback")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function2<@[ParameterName(name = 'spanIndex')] kotlin.Int, @[ParameterName(name = 'e')] com.tencent.kuikly.core.base.event.ClickParams, kotlin.Unit>{ com.tencent.ntcompose.material.RichTextKt.RichTextClickCallback }");
                    final Function2 function2 = (Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 2);
                    ((RichTextEvent) richTextView.getViewEvent()).click(new Function1<ClickParams, Unit>() { // from class: com.tencent.ntcompose.material.RichTextViewPropUpdater$setPropToView$3
                        /* JADX INFO: Access modifiers changed from: package-private */
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                            invoke2(clickParams);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ClickParams clickParams) {
                            Intrinsics.checkNotNullParameter(clickParams, "clickParams");
                            Object params = clickParams.getParams();
                            com.tencent.kuikly.core.nvi.serialization.json.e eVar = params instanceof com.tencent.kuikly.core.nvi.serialization.json.e ? (com.tencent.kuikly.core.nvi.serialization.json.e) params : null;
                            function2.invoke(Integer.valueOf(eVar != null ? eVar.j("index") : 0), clickParams);
                        }
                    });
                    return;
                }
                break;
            case 1761302298:
                if (propKey.equals("onLineBreakMargin")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = 'parma')] kotlin.Any?, kotlin.Unit>{ com.tencent.kuikly.core.base.event.IEventKt.EventHandlerFn }");
                    ((RichTextEvent) richTextView.getViewEvent()).onLineBreakMargin((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(propArg0, 1));
                    return;
                }
                break;
            case 1910225824:
                if (propKey.equals("inlineContent")) {
                    Intrinsics.checkNotNull(propArg0, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, com.tencent.ntcompose.ui.text.InlineTextContent>");
                    Map map = (Map) propArg0;
                    Object obj = richTextAttr.getExtProps().get("inlineContent");
                    Map map2 = obj instanceof Map ? (Map) obj : null;
                    richTextAttr.getExtProps().put("inlineContent", map);
                    RichTextKt.c(map, map2);
                    return;
                }
                break;
        }
        com.tencent.ntcompose.material.base.e.f339411a.setPropToView(view, propKey, propArg0, propArg1, propArg2, propArg3, propArg4);
    }
}
