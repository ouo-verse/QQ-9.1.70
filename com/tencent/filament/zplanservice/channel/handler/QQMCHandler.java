package com.tencent.filament.zplanservice.channel.handler;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCRawDataResponse;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchRequest;
import com.tencent.filament.zplanservice.pbjava.QQMCChannel$QQMCSwitchResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\u000b\u0010\fJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/handler/QQMCHandler;", "", "", AdMetricTag.EVENT_NAME, "", "eventData", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "isSwitchOnWithKey", "loadJsonConfigWithKey", "<init>", "()V", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class QQMCHandler {
    @EventName(name = "qqmc.switch")
    public final void isSwitchOnWithKey(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        QQMCChannel$QQMCSwitchRequest req = (QQMCChannel$QQMCSwitchRequest) com.tencent.filament.zplanservice.util.d.a(eventData, new QQMCChannel$QQMCSwitchRequest());
        el0.d dVar = (el0.d) fl0.a.f399763a.a(el0.d.class);
        if (dVar != null) {
            Intrinsics.checkNotNullExpressionValue(req, "req");
            dVar.a(req, new Function1<QQMCChannel$QQMCSwitchResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.QQMCHandler$isSwitchOnWithKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQMCChannel$QQMCSwitchResponse qQMCChannel$QQMCSwitchResponse) {
                    invoke2(qQMCChannel$QQMCSwitchResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQMCChannel$QQMCSwitchResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }

    @EventName(name = "qqmc.rawData")
    public final void loadJsonConfigWithKey(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        QQMCChannel$QQMCRawDataRequest req = (QQMCChannel$QQMCRawDataRequest) com.tencent.filament.zplanservice.util.d.a(eventData, new QQMCChannel$QQMCRawDataRequest());
        el0.d dVar = (el0.d) fl0.a.f399763a.a(el0.d.class);
        if (dVar != null) {
            Intrinsics.checkNotNullExpressionValue(req, "req");
            dVar.b(req, new Function1<QQMCChannel$QQMCRawDataResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.QQMCHandler$loadJsonConfigWithKey$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQMCChannel$QQMCRawDataResponse qQMCChannel$QQMCRawDataResponse) {
                    invoke2(qQMCChannel$QQMCRawDataResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQMCChannel$QQMCRawDataResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }
}
