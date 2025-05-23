package com.dataline.nt;

import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\n\u001a\u00020\t\u00a2\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/dataline/nt/DataLineMenuSetTopUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes2.dex */
public final class DataLineMenuSetTopUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataLineMenuSetTopUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if ((b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) && ((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16).n() == 8) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    @Nullable
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull a.C9600a params) {
        boolean z16;
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) {
            com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
            if (gVar.n() == 8) {
                DataLineRecentContactUtil dataLineRecentContactUtil = DataLineRecentContactUtil.f32313a;
                String str = gVar.s().peerUid;
                Intrinsics.checkNotNullExpressionValue(str, "chatItem.originData.peerUid");
                if (dataLineRecentContactUtil.h(str).length() > 0) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    QLog.i("DataLineMenuSetTopUseCase", 1, "old contact, uid=" + gVar.s().peerUid + ", uin=" + gVar.s().peerUin);
                    dataLineRecentContactUtil.z(gVar.s().peerUid);
                    String str2 = gVar.s().peerUid;
                    Intrinsics.checkNotNullExpressionValue(str2, "chatItem.originData.peerUid");
                    dataLineRecentContactUtil.r(str2, true);
                } else {
                    String str3 = gVar.s().peerUid;
                    Intrinsics.checkNotNullExpressionValue(str3, "chatItem.originData.peerUid");
                    dataLineRecentContactUtil.r(dataLineRecentContactUtil.g(str3), true);
                }
            }
        }
        return FlowKt.flow(new DataLineMenuSetTopUseCase$invoke$1(null));
    }
}
