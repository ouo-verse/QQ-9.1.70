package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.Event;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J1\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bH\u0016J+\u0010\r\u001a\u00020\u00072!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00110\u000b\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\u0002H\u0016RG\u0010\t\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0002j\u0004\u0018\u0001`\b8\u0000@\u0000X\u0080\u000e\u00a2\u0006\u0012\n\u0004\b\t\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/kuikly/core/views/TextEvent;", "Lcom/tencent/kuikly/core/base/event/Event;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "handler", "onLineBreakMargin", "Lcom/tencent/kuikly/core/views/ch;", "params", "onTextWithLineBreak", "Lkotlin/jvm/functions/Function1;", "getHandler$core_release", "()Lkotlin/jvm/functions/Function1;", "setHandler$core_release", "(Lkotlin/jvm/functions/Function1;)V", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class TextEvent extends Event {
    private Function1<Object, Unit> handler;

    public final Function1<Object, Unit> getHandler$core_release() {
        return this.handler;
    }

    public void onLineBreakMargin(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.handler = handler;
    }

    public void onTextWithLineBreak(final Function1<? super ch, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("textWithLineBreak", new Function1<Object, Unit>() { // from class: com.tencent.kuikly.core.views.TextEvent$onTextWithLineBreak$1
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
                String p16 = eVar.p("text");
                handler.invoke(new ch(eVar.j("lineBreakMagicCode"), p16));
            }
        });
    }

    public final void setHandler$core_release(Function1<Object, Unit> function1) {
        this.handler = function1;
    }
}
