package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ3\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00070\u0006\"\u00020\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/c;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class c extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@NotNull AbsIpcMethod.a context, @NotNull String method, @NotNull Object... arguments) {
        boolean z16;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        com.tencent.mobileqq.guild.base.extension.r rVar = com.tencent.mobileqq.guild.base.extension.r.f214743a;
        IRuntimeService S0 = ch.S0(IGPSService.class, "");
        Intrinsics.checkNotNullExpressionValue(S0, "runtimeService(T::class.java, process)");
        IGProChannelInfo channelInfo = ((IGPSService) S0).getChannelInfo((String) obj);
        Bundle bundle = new Bundle();
        if (channelInfo != null) {
            z16 = true;
        } else {
            z16 = false;
        }
        bundle.putBoolean("extra_exist", z16);
        EIPCResult createResult = EIPCResult.createResult(0, bundle);
        Intrinsics.checkNotNullExpressionValue(createResult, "createResult(EIPCResult.CODE_NO_ERR, bundle)");
        return createResult;
    }
}
