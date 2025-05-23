package com.tencent.filament.zplanservice.channel.handler;

import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageChannelError;
import com.tencent.filament.zplanservice.pbjava.MessageChannelErrorCode$MessageResponse;
import com.tencent.mobileqq.pb.MessageMicro;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a!\u0010\u000b\u001a\u00020\n*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\t\u001a\u0004\u0018\u00010\u0004H\u0086\u0002\u001a \u0010\f\u001a\u00020\n*\u00020\u00062\b\b\u0002\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u001a\u0014\u0010\r\u001a\u00020\n*\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\u000f\u001a\u00020\n*\u00020\u00062\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\u000e\u00a8\u0006\u0010"}, d2 = {"", "errorCode", "", "message", "Lcom/tencent/filament/zplanservice/pbjava/MessageChannelErrorCode$MessageChannelError;", "a", "Lcom/tencent/filament/zplanservice/channel/a;", "", "data", "error", "", "b", "c", "f", "Lcom/tencent/mobileqq/pb/MessageMicro;", "e", "zplan-service_release"}, k = 2, mv = {1, 4, 2})
/* loaded from: classes6.dex */
public final class a {
    @NotNull
    public static final MessageChannelErrorCode$MessageChannelError a(int i3, @Nullable String str) {
        MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError = new MessageChannelErrorCode$MessageChannelError();
        messageChannelErrorCode$MessageChannelError.code.set(i3);
        if (str != null) {
            messageChannelErrorCode$MessageChannelError.message.set(str);
        }
        return messageChannelErrorCode$MessageChannelError;
    }

    public static final void b(@NotNull com.tencent.filament.zplanservice.channel.a invoke, @Nullable byte[] bArr, @Nullable MessageChannelErrorCode$MessageChannelError messageChannelErrorCode$MessageChannelError) {
        Intrinsics.checkNotNullParameter(invoke, "$this$invoke");
        MessageChannelErrorCode$MessageResponse messageChannelErrorCode$MessageResponse = new MessageChannelErrorCode$MessageResponse();
        if (bArr != null) {
            messageChannelErrorCode$MessageResponse.data.set(com.tencent.filament.zplanservice.util.d.b(bArr));
        }
        if (messageChannelErrorCode$MessageChannelError != null) {
            messageChannelErrorCode$MessageResponse.error.set(messageChannelErrorCode$MessageChannelError);
        }
        Unit unit = Unit.INSTANCE;
        invoke.a(messageChannelErrorCode$MessageResponse);
    }

    public static final void c(@NotNull com.tencent.filament.zplanservice.channel.a invokeFail, int i3, @Nullable String str) {
        Intrinsics.checkNotNullParameter(invokeFail, "$this$invokeFail");
        b(invokeFail, null, a(i3, str));
    }

    public static /* synthetic */ void d(com.tencent.filament.zplanservice.channel.a aVar, int i3, String str, int i16, Object obj) {
        if ((i16 & 1) != 0) {
            i3 = 2;
        }
        if ((i16 & 2) != 0) {
            str = null;
        }
        c(aVar, i3, str);
    }

    public static final void e(@NotNull com.tencent.filament.zplanservice.channel.a invokeSuccess, @NotNull MessageMicro<?> data) {
        Intrinsics.checkNotNullParameter(invokeSuccess, "$this$invokeSuccess");
        Intrinsics.checkNotNullParameter(data, "data");
        f(invokeSuccess, data.toByteArray());
    }

    public static final void f(@NotNull com.tencent.filament.zplanservice.channel.a invokeSuccess, @Nullable byte[] bArr) {
        Intrinsics.checkNotNullParameter(invokeSuccess, "$this$invokeSuccess");
        b(invokeSuccess, bArr, null);
    }
}
