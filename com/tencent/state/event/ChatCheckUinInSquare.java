package com.tencent.state.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u00a2\u0006\u0002\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\r"}, d2 = {"Lcom/tencent/state/event/ChatCheckUinInSquare;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "uin", "", "onDone", "Lkotlin/Function1;", "", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "getOnDone", "()Lkotlin/jvm/functions/Function1;", "getUin", "()Ljava/lang/String;", "state_square_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes33.dex */
public final class ChatCheckUinInSquare extends SimpleBaseEvent {
    private final Function1<Boolean, Unit> onDone;
    private final String uin;

    /* JADX WARN: Multi-variable type inference failed */
    public ChatCheckUinInSquare(String uin, Function1<? super Boolean, Unit> function1) {
        Intrinsics.checkNotNullParameter(uin, "uin");
        this.uin = uin;
        this.onDone = function1;
    }

    public final Function1<Boolean, Unit> getOnDone() {
        return this.onDone;
    }

    public final String getUin() {
        return this.uin;
    }

    public /* synthetic */ ChatCheckUinInSquare(String str, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i3 & 2) != 0 ? null : function1);
    }
}
