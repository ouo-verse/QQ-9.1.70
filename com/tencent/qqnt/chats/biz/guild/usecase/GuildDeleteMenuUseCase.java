package com.tencent.qqnt.chats.biz.guild.usecase;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/biz/guild/usecase/GuildDeleteMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "", "getProcessType", "()I", "processType", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildDeleteMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildDeleteMenuUseCase(@NotNull IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(String guildId, int i3, String str) {
        Intrinsics.checkNotNullParameter(guildId, "$guildId");
        QLog.d("GuildDeleteMenuUseCase", 1, "deleteRecentContact guildId: " + guildId + " result: " + i3 + ", err: " + str);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public int getProcessType() {
        return R.id.epz;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
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

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    @Nullable
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull a.C9600a params) {
        g gVar;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof g) {
            gVar = (g) b16;
        } else {
            gVar = null;
        }
        if (gVar == null) {
            return null;
        }
        final String f16 = ex3.a.f(gVar.s());
        getRecentContactRepo().n(gVar.s(), new IOperateCallback() { // from class: com.tencent.qqnt.chats.biz.guild.usecase.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                GuildDeleteMenuUseCase.b(f16, i3, str);
            }
        });
        return FlowKt.flow(new GuildDeleteMenuUseCase$invoke$2(null));
    }
}
