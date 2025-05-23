package com.tencent.mobileqq.wink.event;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t\u00a8\u0006\f"}, d2 = {"Lcom/tencent/mobileqq/wink/event/QFSAggregationUpdateEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "id", "", "unifiedType", "isCollection", "", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "()Z", "getUnifiedType", "qq-wink-api_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes21.dex */
public final class QFSAggregationUpdateEvent extends SimpleBaseEvent {

    @NotNull
    private final String id;
    private final boolean isCollection;

    @NotNull
    private final String unifiedType;

    public QFSAggregationUpdateEvent(@NotNull String id5, @NotNull String unifiedType, boolean z16) {
        Intrinsics.checkNotNullParameter(id5, "id");
        Intrinsics.checkNotNullParameter(unifiedType, "unifiedType");
        this.id = id5;
        this.unifiedType = unifiedType;
        this.isCollection = z16;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getUnifiedType() {
        return this.unifiedType;
    }

    /* renamed from: isCollection, reason: from getter */
    public final boolean getIsCollection() {
        return this.isCollection;
    }
}
