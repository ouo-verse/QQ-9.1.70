package com.tencent.filament.zplanservice.channel;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0010\t\n\u0002\b\u0002\u001a<\u0010\n\u001a\u00020\u0007*\u00020\u00002\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00032\u0018\u0010\t\u001a\u0014\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005j\u0002`\b*&\u0010\u000b\"\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u00052\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\u00070\u0005*2\u0010\u000f\"\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\f2\u0016\u0012\u0006\u0012\u0004\u0018\u00010\r\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00070\f\u00a8\u0006\u0010"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/MessageChannel;", "", AdMetricTag.EVENT_NAME, "Lcom/tencent/mobileqq/pb/MessageMicro;", "data", "Lkotlin/Function1;", "Lcom/tencent/filament/zplanservice/pbjava/MessageChannelErrorCode$MessageResponse;", "", "Lcom/tencent/filament/zplanservice/channel/CallbackC2N;", "callbackC2N", "a", "CallbackC2N", "Lkotlin/Function2;", "", "", "JniCallbackC2N", "zplan-service_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class c {
    public static final void a(@NotNull MessageChannel callN2C, @NotNull Enum<?> eventName, @NotNull MessageMicro<?> data, @NotNull Function1<? super MessageChannelErrorCode$MessageResponse, Unit> callbackC2N) {
        Intrinsics.checkNotNullParameter(callN2C, "$this$callN2C");
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(callbackC2N, "callbackC2N");
        callN2C.callN2C(eventName.name(), data.toByteArray(), callbackC2N);
    }
}
