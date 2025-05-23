package com.tencent.kuikly.core.views;

import com.tencent.kuikly.core.base.event.ClickParams;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000e\b\u0016\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J#\u0010\t\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002H\u0000\u00a2\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\f\u001a\u00020\u0004H\u0000\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\r\u001a\u00020\u00062\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0002H\u0016R$\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/kuikly/core/views/RichTextEvent;", "Lcom/tencent/kuikly/core/views/TextEvent;", "Lkotlin/Function1;", "Lcom/tencent/kuikly/core/base/event/c;", "", "handler", "", "interceptClick$core_release", "(Lkotlin/jvm/functions/Function1;)V", "interceptClick", "hasInterceptClick$core_release", "()Z", "hasInterceptClick", "click", "interceptClickClickHandler", "Lkotlin/jvm/functions/Function1;", "didListenClick", "Z", "<init>", "()V", "core_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public class RichTextEvent extends TextEvent {
    private boolean didListenClick;
    private Function1<? super ClickParams, Boolean> interceptClickClickHandler;

    @Override // com.tencent.kuikly.core.base.event.Event
    public void click(final Function1<? super ClickParams, Unit> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.didListenClick = true;
        super.click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.RichTextEvent$click$1
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
            public final void invoke2(ClickParams it) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(it, "it");
                function1 = RichTextEvent.this.interceptClickClickHandler;
                boolean z16 = false;
                if (function1 != null && ((Boolean) function1.invoke(it)).booleanValue()) {
                    z16 = true;
                }
                if (z16) {
                    return;
                }
                handler.invoke(it);
            }
        });
    }

    public final boolean hasInterceptClick$core_release() {
        return this.interceptClickClickHandler != null;
    }

    public final void interceptClick$core_release(Function1<? super ClickParams, Boolean> handler) {
        Intrinsics.checkNotNullParameter(handler, "handler");
        this.interceptClickClickHandler = handler;
        if (this.didListenClick) {
            return;
        }
        click(new Function1<ClickParams, Unit>() { // from class: com.tencent.kuikly.core.views.RichTextEvent$interceptClick$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClickParams it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClickParams clickParams) {
                invoke2(clickParams);
                return Unit.INSTANCE;
            }
        });
    }
}
