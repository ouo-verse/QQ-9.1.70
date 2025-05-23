package com.tencent.mobileqq.qqecommerce.biz.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 \u00132\u00020\u0001:\u0001\u0014B2\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u0017\u0010\u0003\u001a\u00020\u00028\u0006\u00a2\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R2\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\b\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u00078\u0006\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/event/QFSHRGameTabCallbackEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "", "eventType", "I", "getEventType", "()I", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "arg", "", "callback", "Lkotlin/jvm/functions/Function1;", "getCallback", "()Lkotlin/jvm/functions/Function1;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "Companion", "a", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public final class QFSHRGameTabCallbackEvent extends SimpleBaseEvent {
    public static final int EVENT_GET_TAB_INDEX = 1;

    @NotNull
    private final Function1<Object, Unit> callback;
    private final int eventType;

    public QFSHRGameTabCallbackEvent(int i3, @NotNull Function1<Object, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.eventType = i3;
        this.callback = callback;
    }

    @NotNull
    public final Function1<Object, Unit> getCallback() {
        return this.callback;
    }

    public final int getEventType() {
        return this.eventType;
    }
}
