package com.tencent.biz.pubaccount.recentcontact;

import android.content.Context;
import com.tencent.mobileqq.R;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002R\u0014\u0010\f\u001a\u00020\t8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/biz/pubaccount/recentcontact/DefaultPAUnsubscribeMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "", "getProcessType", "()I", "processType", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "qqpubaccount_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class DefaultPAUnsubscribeMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultPAUnsubscribeMenuUseCase(IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public int getProcessType() {
        return R.id.z4b;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        return params.b() instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(a.C9600a params) {
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        Context a16 = params.a();
        if (a16 == null || !(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return null;
        }
        new m(getRecentContactRepo(), a16).w((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16);
        return FlowKt.flow(new DefaultPAUnsubscribeMenuUseCase$invoke$1(null));
    }
}
