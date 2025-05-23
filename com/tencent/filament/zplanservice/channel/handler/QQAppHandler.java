package com.tencent.filament.zplanservice.channel.handler;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.filament.zplanservice.channel.handler.annotation.EventName;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientPlatformResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetClientVersionResponse;
import com.tencent.filament.zplanservice.pbjava.QQAppChannel$GetCurrentUinResponse;
import com.tencent.filament.zplanservice.util.log.FLog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\n\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007J\"\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0007\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/filament/zplanservice/channel/handler/QQAppHandler;", "", "", AdMetricTag.EVENT_NAME, "", "eventData", "Lcom/tencent/filament/zplanservice/channel/a;", "callbackN2C", "", "getCurrentUin", "getClientVersion", "getClientPlatform", "<init>", "()V", "a", "zplan-service_release"}, k = 1, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class QQAppHandler {
    @EventName(name = "qqapp.getClientPlatform")
    public final void getClientPlatform(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getClientPlatform ");
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
        fLog.i("QQAppHandler", sb5.toString());
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        el0.c cVar = (el0.c) fl0.a.f399763a.a(el0.c.class);
        if (cVar != null) {
            cVar.b(new Function1<QQAppChannel$GetClientPlatformResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.QQAppHandler$getClientPlatform$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQAppChannel$GetClientPlatformResponse qQAppChannel$GetClientPlatformResponse) {
                    invoke2(qQAppChannel$GetClientPlatformResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQAppChannel$GetClientPlatformResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }

    @EventName(name = "qqapp.getClientVersion")
    public final void getClientVersion(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getClientVersion ");
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
        fLog.i("QQAppHandler", sb5.toString());
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        el0.c cVar = (el0.c) fl0.a.f399763a.a(el0.c.class);
        if (cVar != null) {
            cVar.c(new Function1<QQAppChannel$GetClientVersionResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.QQAppHandler$getClientVersion$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQAppChannel$GetClientVersionResponse qQAppChannel$GetClientVersionResponse) {
                    invoke2(qQAppChannel$GetClientVersionResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQAppChannel$GetClientVersionResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }

    @EventName(name = "qqapp.getCurrentUin")
    public final void getCurrentUin(@NotNull String eventName, @Nullable byte[] eventData, @NotNull final com.tencent.filament.zplanservice.channel.a callbackN2C) {
        Integer num;
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(callbackN2C, "callbackN2C");
        FLog fLog = FLog.INSTANCE;
        StringBuilder sb5 = new StringBuilder();
        sb5.append("getCurrentUin ");
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
        fLog.i("QQAppHandler", sb5.toString());
        if (eventData == null) {
            a.d(callbackN2C, 0, null, 3, null);
            return;
        }
        el0.c cVar = (el0.c) fl0.a.f399763a.a(el0.c.class);
        if (cVar != null) {
            cVar.a(new Function1<QQAppChannel$GetCurrentUinResponse, Unit>() { // from class: com.tencent.filament.zplanservice.channel.handler.QQAppHandler$getCurrentUin$1
                /* JADX INFO: Access modifiers changed from: package-private */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(QQAppChannel$GetCurrentUinResponse qQAppChannel$GetCurrentUinResponse) {
                    invoke2(qQAppChannel$GetCurrentUinResponse);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(@NotNull QQAppChannel$GetCurrentUinResponse it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    a.e(com.tencent.filament.zplanservice.channel.a.this, it);
                }
            });
        }
    }
}
