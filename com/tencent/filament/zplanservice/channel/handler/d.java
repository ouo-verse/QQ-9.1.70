package com.tencent.filament.zplanservice.channel.handler;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.pbjava.ResourceEtagInfo$etag_info;
import com.tencent.filament.zplanservice.util.log.FLog;
import el0.f;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/handler/d;", "", "", AdMetricTag.EVENT_NAME, "", "eventData", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "handleETagInfo", "<init>", "()V", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class d {
    @EventName(name = "EtagInfoRpc.onEtagInfo")
    public final void handleETagInfo(@NotNull String eventName, @Nullable byte[] eventData, @NotNull com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        if (eventData == null) {
            FLog.INSTANCE.e("ResourceETagInfoHandler", "handleETagInfo, eventData null.");
            return;
        }
        ResourceEtagInfo$etag_info req = (ResourceEtagInfo$etag_info) com.tencent.filament.zplanservice.util.d.a(eventData, new ResourceEtagInfo$etag_info());
        f fVar = (f) fl0.a.f399763a.a(f.class);
        if (fVar != null) {
            Intrinsics.checkNotNullExpressionValue(req, "req");
            fVar.a(req);
        }
    }
}
