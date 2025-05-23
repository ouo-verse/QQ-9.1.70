package com.tencent.kuikly.core.views;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012J/\u0010\n\u001a\u00020\u00072'\u0010\t\u001a#\u0012\u0015\u0012\u0013\u0018\u00010\u0003\u00a2\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00070\u0002j\u0002`\bJ\u001c\u0010\f\u001a\u00020\u00072\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0002H\u0016R<\u0010\u000f\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u00020\rj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070\u0002`\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0013"}, d2 = {"Lcom/tencent/kuikly/core/views/PageListEvent;", "Lcom/tencent/kuikly/core/views/ap;", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "parma", "", "Lcom/tencent/kuikly/core/base/event/EventHandlerFn;", "handler", "pageIndexDidChanged", "Lcom/tencent/kuikly/core/views/co;", "willDragEndBySync", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "willDragEndHandlers", "Ljava/util/ArrayList;", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class PageListEvent extends ap {
    private final ArrayList<Function1<co, Unit>> willDragEndHandlers = new ArrayList<>();

    public final void pageIndexDidChanged(Function1<Object, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        register("pageIndexDidChanged", handler);
    }

    @Override // com.tencent.kuikly.core.views.ScrollerEvent
    public void willDragEndBySync(Function1<? super co, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        if (this.willDragEndHandlers.isEmpty()) {
            super.willDragEndBySync(new Function1<co, Unit>() { // from class: com.tencent.kuikly.core.views.PageListEvent$willDragEndBySync$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(co coVar) {
                    invoke2(coVar);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(co it) {
                    ArrayList arrayList;
                    Intrinsics.checkNotNullParameter(it, "it");
                    arrayList = PageListEvent.this.willDragEndHandlers;
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        ((Function1) it5.next()).invoke(it);
                    }
                }
            });
        }
        this.willDragEndHandlers.add(handler);
    }
}
