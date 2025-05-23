package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.TimingFuncType;
import com.tencent.kuikly.core.base.event.Event;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0007\u00a2\u0006\u0004\b\u001d\u0010\u001eJ(\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\u0003\u001a\u00020\u00022\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007J\u001e\u0010\n\u001a\u00020\u00062\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007J\u001e\u0010\u000b\u001a\u00020\u00062\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007J\u001e\u0010\f\u001a\u00020\u00062\u0016\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0007J-\u0010\u0012\u001a\u00020\u00062%\u0010\b\u001a!\u0012\u0013\u0012\u00110\r\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u0011J$\u0010\u0015\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00060\u0004J$\u0010\u0018\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\u00022\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00060\u0004J/\u0010\u001c\u001a\u00020\u00062'\u0010\b\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0019\u00a2\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u00060\u0004j\u0002`\u001b\u00a8\u0006 "}, d2 = {"Lcom/tencent/kuikly/core/views/TextAreaEvent;", "Lcom/tencent/kuikly/core/base/event/Event;", "", "isSyncEdit", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/views/aj;", "", "Lcom/tencent/kuikly/core/views/InputEventHandlerFn;", "handler", DomainData.DOMAIN_NAME, QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "i", tl.h.F, "", "Lkotlin/ParameterName;", "name", "imeAction", "Lcom/tencent/kuikly/core/views/IMEActionEventHandlerFn;", "l", "sync", "Lcom/tencent/kuikly/core/views/an;", "j", "Lcom/tencent/kuikly/core/base/w;", "onTextContentSizeChangedCallback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "", "parma", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "p", "<init>", "()V", "a", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class TextAreaEvent extends Event {
    public final void h(final Function1<? super InputParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("inputBlur", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$inputBlur$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                handler.invoke(new InputParams(((com.tencent.kuikly.core.nvi.serialization.json.e) obj).p("text"), null, 2, null));
            }
        });
    }

    public final void i(final Function1<? super InputParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("inputFocus", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$inputFocus$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                handler.invoke(new InputParams(((com.tencent.kuikly.core.nvi.serialization.json.e) obj).p("text"), null, 2, null));
            }
        });
    }

    public final void j(boolean sync, final Function1<? super KeyboardParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("keyboardHeightChange", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$keyboardHeightChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                float h16 = (float) eVar.h("height");
                float h17 = (float) eVar.h("duration");
                int k3 = eVar.k("curve", 0);
                handler.invoke(new KeyboardParams(h16, h17, (int) (1000 * h17), k3 == 0 ? TimingFuncType.EASEIN : TimingFuncType.INSTANCE.a(k3)));
            }
        }, sync);
    }

    public final void l(final Function1<? super String, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("imeAction", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$onIMEAction$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                handler.invoke(((com.tencent.kuikly.core.nvi.serialization.json.e) obj).p("ime_action"));
            }
        });
    }

    public final void m(boolean sync, final Function1<? super com.tencent.kuikly.core.base.w, Unit> onTextContentSizeChangedCallback) {
        Intrinsics.checkNotNullParameter(onTextContentSizeChangedCallback, "onTextContentSizeChangedCallback");
        register("textContentSizeChanged", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$onTextContentSizeChanged$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                onTextContentSizeChangedCallback.invoke(new com.tencent.kuikly.core.base.w((float) eVar.h("contentWidth"), (float) eVar.h("contentHeight")));
            }
        }, sync);
    }

    public final void n(boolean isSyncEdit, final Function1<? super InputParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("textDidChange", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$textDidChange$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                handler.invoke(new InputParams(eVar.p("text"), Integer.valueOf(eVar.j("length"))));
            }
        }, isSyncEdit);
    }

    public final void p(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("textLengthBeyondLimit", handler);
    }

    public final void q(final Function1<? super InputParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("textWillChange", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextAreaEvent$textWillChangeForIOS$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
                invoke2(obj);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Object obj) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) obj;
                handler.invoke(new InputParams(eVar.p("text"), Integer.valueOf(eVar.j("length"))));
            }
        });
    }

    public static /* synthetic */ void k(TextAreaEvent textAreaEvent, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        textAreaEvent.j(z16, function1);
    }

    public static /* synthetic */ void o(TextAreaEvent textAreaEvent, boolean z16, Function1 function1, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        textAreaEvent.n(z16, function1);
    }
}
