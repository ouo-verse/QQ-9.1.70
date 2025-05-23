package com.tencent.mobileqq.guild.ipc.methods;

import android.os.Bundle;
import com.tencent.mobileqq.guild.channel.joinchannel.JoinGuildLogic;
import com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod;
import com.tencent.mobileqq.guild.jump.model.JumpGuildParam;
import com.tencent.mobileqq.guild.util.IQQGuildUtilApi;
import com.tencent.mobileqq.guild.util.Logger;
import com.tencent.mobileqq.guild.util.ch;
import com.tencent.mobileqq.qqguildsdk.data.IGProSecurityResult;
import com.tencent.mobileqq.qqguildsdk.data.genc.IGProJoinGuildResult;
import com.tencent.mobileqq.qroute.QRoute;
import eipc.EIPCResult;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vh2.bv;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0007\u00a2\u0006\u0004\b\f\u0010\rJ=\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0016\u0010\b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00070\u0006\"\u0004\u0018\u00010\u0007H\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/guild/ipc/methods/b;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod;", "Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;", "context", "", "method", "", "", "arguments", "Leipc/EIPCResult;", "a", "(Lcom/tencent/mobileqq/guild/ipc/methods/AbsIpcMethod$a;Ljava/lang/String;[Ljava/lang/Object;)Leipc/EIPCResult;", "<init>", "()V", "qqguild-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes13.dex */
public final class b extends AbsIpcMethod {
    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(String guildId, AbsIpcMethod.a aVar, int i3, String str, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        Logger.f235387a.d().i("Guild.join.AddGuildWithJoinSigMethod", 1, "addGuild result=" + i3 + " errMsg=" + str + " security=" + iGProSecurityResult);
        if (!com.tencent.mobileqq.guild.channel.joinchannel.h.d(i3, iGProSecurityResult)) {
            ((IQQGuildUtilApi) QRoute.api(IQQGuildUtilApi.class)).handleJoinGuildError(ch.i(), i3, str, iGProSecurityResult);
        }
        Bundle K = aq1.h.K(i3, str, iGProSecurityResult);
        K.putString("guildId", guildId);
        if (aVar != null) {
            aVar.b(K);
        }
    }

    @Override // com.tencent.mobileqq.guild.ipc.methods.AbsIpcMethod
    @Nullable
    public EIPCResult a(@Nullable final AbsIpcMethod.a context, @Nullable String method, @NotNull Object... arguments) {
        Intrinsics.checkNotNullParameter(arguments, "arguments");
        Object obj = arguments[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        final String str = (String) obj;
        Object obj2 = arguments[1];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.String");
        String str2 = (String) obj2;
        Object obj3 = arguments[2];
        Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.String");
        String str3 = (String) obj3;
        Object obj4 = arguments[3];
        Intrinsics.checkNotNull(obj4, "null cannot be cast to non-null type kotlin.String");
        Object obj5 = arguments[4];
        Intrinsics.checkNotNull(obj5, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj5).intValue();
        JumpGuildParam jumpGuildParam = new JumpGuildParam(str, "", str2, str3, (String) obj4);
        jumpGuildParam.getJoinInfoParam().setPageEntranceId(intValue);
        com.tencent.mobileqq.guild.channel.joinchannel.h.a(ch.i(), jumpGuildParam, new JoinGuildLogic.JumpParam(), "QQGuildSvrIPCModule", new bv() { // from class: com.tencent.mobileqq.guild.ipc.methods.a
            @Override // vh2.bv
            public final void a(int i3, String str4, IGProSecurityResult iGProSecurityResult, IGProJoinGuildResult iGProJoinGuildResult) {
                b.e(str, context, i3, str4, iGProSecurityResult, iGProJoinGuildResult);
            }
        });
        return null;
    }
}
