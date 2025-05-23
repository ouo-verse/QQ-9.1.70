package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"Lcom/tencent/mobileqq/wink/event/WinkExtractCoverEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "result", "Ljava/util/ArrayList;", "", "(Ljava/util/ArrayList;)V", "getResult", "()Ljava/util/ArrayList;", "qq-wink-impl_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class WinkExtractCoverEvent extends SimpleBaseEvent {

    @NotNull
    private final ArrayList<byte[]> result;

    public WinkExtractCoverEvent(@NotNull ArrayList<byte[]> result) {
        Intrinsics.checkNotNullParameter(result, "result");
        this.result = result;
    }

    @NotNull
    public final ArrayList<byte[]> getResult() {
        return this.result;
    }
}
