package com.tencent.biz.qqcircle.events;

import com.tencent.biz.richframework.eventbus.SimpleBaseEvent;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/qqcircle/events/QCircleAdClickEvent;", "Lcom/tencent/biz/richframework/eventbus/SimpleBaseEvent;", "traceId", "", "(Ljava/lang/String;)V", "mTraceId", "getTraceId", "qcircle-plugin-module_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes4.dex */
public final class QCircleAdClickEvent extends SimpleBaseEvent {

    @Nullable
    private String mTraceId;

    public QCircleAdClickEvent(@Nullable String str) {
        this.mTraceId = str;
    }

    @Nullable
    /* renamed from: getTraceId, reason: from getter */
    public final String getMTraceId() {
        return this.mTraceId;
    }
}
