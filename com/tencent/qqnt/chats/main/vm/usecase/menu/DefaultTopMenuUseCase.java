package com.tencent.qqnt.chats.main.vm.usecase.menu;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.aio.adapter.a;
import com.tencent.qqnt.aio.adapter.api.ITroopApi;
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
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0019\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\bH\u0096\u0002R\u0014\u0010\u0010\u001a\u00020\u00048VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/menu/DefaultTopMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "", "chatUid", "", "contactType", "", "c", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "getProcessType", "()I", "processType", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DefaultTopMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultTopMenuUseCase(@NotNull IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentContactRepo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(int i3, String str) {
        QLog.d("MenuOperateUseCase", 1, "setItemTop result: " + i3 + ", errMsg: " + str);
    }

    private final boolean c(String chatUid, int contactType) {
        if (contactType != 2) {
            return false;
        }
        a.Companion companion = com.tencent.qqnt.aio.adapter.a.INSTANCE;
        boolean z16 = !((ITroopApi) companion.a(ITroopApi.class)).isTroopMember(chatUid);
        if (z16) {
            ((ITroopApi) companion.a(ITroopApi.class)).showExitTroopPinToTopMsg(chatUid);
        }
        return z16;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public int getProcessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return R.id.eqe;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return params.b() instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    @Nullable
    public Flow<com.tencent.qqnt.chats.main.vm.usecase.result.a> invoke(@NotNull a.C9600a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Flow) iPatchRedirector.redirect((short) 4, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g)) {
            return null;
        }
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        if (c(gVar.k(), gVar.n())) {
            return null;
        }
        getRecentContactRepo().k(gVar.k(), gVar.l(), true, gVar.n(), new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.usecase.menu.h
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                DefaultTopMenuUseCase.b(i3, str);
            }
        });
        return FlowKt.flow(new DefaultTopMenuUseCase$invoke$2(null));
    }
}
