package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QFSMessageLoadEmptyBlockEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "load", "", "key", "", "(ZLjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "getLoad", "()Z", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QFSMessageLoadEmptyBlockEvent extends SimpleBaseEvent {

    @NotNull
    private final String key;
    private final boolean load;

    public QFSMessageLoadEmptyBlockEvent(boolean z16, @NotNull String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        this.load = z16;
        this.key = key;
    }

    @NotNull
    public final String getKey() {
        return this.key;
    }

    public final boolean getLoad() {
        return this.load;
    }
}
