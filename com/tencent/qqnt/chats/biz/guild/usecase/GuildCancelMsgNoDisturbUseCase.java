package com.tencent.qqnt.chats.biz.guild.usecase;

import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildMsgApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/usecase/GuildCancelMsgNoDisturbUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildCancelMsgNoDisturbUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildCancelMsgNoDisturbUseCase(@NotNull IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g) || ((g) b16).n() != 16) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    @Nullable
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        final com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof g)) {
            return null;
        }
        ((IGuildMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildMsgApi.class)).setGuildUnNotifyFlag(ex3.a.f(((g) b16).s()), 0, new Function3<Integer, String, Integer, Unit>() { // from class: com.tencent.qqnt.chats.biz.guild.usecase.GuildCancelMsgNoDisturbUseCase$invoke$1
            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str, Integer num2) {
                invoke(num.intValue(), str, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg, int i16) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("GuildCancelMsgNoDisturbUseCase", 1, "setGuildUnNotifyFlag: guildId: " + ex3.a.f(((g) com.tencent.qqnt.chats.core.adapter.itemdata.b.this).s()) + " result = " + i3 + ", errMsg = " + errMsg + ", needNotice: " + i16);
            }
        });
        return FlowKt.flow(new GuildCancelMsgNoDisturbUseCase$invoke$2(null));
    }
}
