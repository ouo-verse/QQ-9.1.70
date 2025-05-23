package com.tencent.qqnt.chats.biz.guild.usecase;

import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.api.IGuildMsgApi;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\f"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/usecase/GuildRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase$a;", "params", "", "interestedIn", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildRedDotDragUseCase extends IRedDotDragUseCase {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRedDotDragUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    public boolean interestedIn(@NotNull IRedDotDragUseCase.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b a16 = params.a();
        if (a16 instanceof g) {
            gVar = (g) a16;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        int n3 = gVar.n();
        if (n3 != 16 && n3 != 60 && n3 != 62) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    public boolean invoke(@NotNull IRedDotDragUseCase.a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b a16 = params.a();
        if (a16 instanceof g) {
            gVar = (g) a16;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return false;
        }
        final String f16 = ex3.a.f(gVar.s());
        ((IGuildMsgApi) com.tencent.qqnt.aio.adapter.a.INSTANCE.a(IGuildMsgApi.class)).setGProGuildMsgRead(f16, gVar.n(), new Function2<Integer, String, Unit>() { // from class: com.tencent.qqnt.chats.biz.guild.usecase.GuildRedDotDragUseCase$invoke$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, @NotNull String errMsg) {
                Intrinsics.checkNotNullParameter(errMsg, "errMsg");
                QLog.i("GuildRedDotDragUseCase", 1, "setGuildMsgRead: guildId: " + f16 + " result = " + i3 + ", errMsg = " + errMsg);
            }
        });
        return true;
    }
}
