package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.guild.data.GuildSpeakParamsInfo;
import com.tencent.mobileqq.guild.guide.GuildSpeakManageGuide;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\f\u0010\rJ;\u0010\n\u001a\u00020\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/GuildDeleteFeedIPCMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class GuildDeleteFeedIPCMethod extends AbsIpcMethod {
    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @NotNull
    public EIPCResult a(@Nullable AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        String str = (String) obj;
        Object obj2 = arguments[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        Object obj3 = arguments[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        Bundle bundle = new Bundle();
        GuildSpeakManageGuide.d(new GuildSpeakParamsInfo(str, (String) obj2, null, 6), str, (String) obj3, R.string.f143120l8, GuildDeleteFeedIPCMethod$doInvoke$1.INSTANCE);
        EIPCResult createSuccessResult = EIPCResult.createSuccessResult(bundle);
        Intrinsics.checkNotNullExpressionValue(createSuccessResult, "createSuccessResult(bundle)");
        return createSuccessResult;
    }
}
