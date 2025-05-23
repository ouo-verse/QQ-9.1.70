package com.tencent.filament.zplanservice.channel.handler;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.pbjava.MSFChannel$MSFRequest;
import com.tencent.filament.zplanservice.pbjava.MSFChannel$MSFResponse;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0000\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\r"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/handler/MsfHandler;", "", "", AdMetricTag.EVENT_NAME, "", "eventData", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "sendRequest", "<init>", "()V", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class MsfHandler {
    @EventName(name = "msf.sendRequest")
    public final void sendRequest(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("sendRequest ");
        sb5.append(eventName);
        sb5.append(", ");
        if (eventData != null) {
            num = Integer.valueOf(eventData.length);
        } else {
            num = null;
        }
        sb5.append(num);
        sb5.append(", ");
        sb5.append(callbackN2C);
        fLog.i("MsfHandler", sb5.toString());
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        MSFChannel$MSFRequest req = (MSFChannel$MSFRequest) com.tencent.filament.zplanservice.util.d.a(eventData, new MSFChannel$MSFRequest());
        fLog.i("MsfHandler", "sendRequest command: " + req.command.get());
        el0.b bVar = (el0.b) fl0.a.f399763a.a(el0.b.class);
        if (bVar != null) {
            Intrinsics.checkNotNullExpressionValue(req, "req");
            bVar.a(req, new Function1<MSFChannel$MSFResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.MsfHandler$sendRequest$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(MSFChannel$MSFResponse mSFChannel$MSFResponse) {
                    invoke2(mSFChannel$MSFResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull MSFChannel$MSFResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    FLog.INSTANCE.i("MsfHandler", "onResponse code : " + it.error.code.get());
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }
}
