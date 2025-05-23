package com.tencent.qqnt.chats.main.vm.usecase.business;

import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.ui.third.p013const.ThirdViewEnum;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.main.vm.usecase.result.a;
import com.tencent.qqnt.chats.main.vm.usecase.thirdview.b;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/business/SpecialCareClickUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b$a;", "params", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class SpecialCareClickUseCase implements b {
    static IPatchRedirector $redirector_;

    public SpecialCareClickUseCase() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.thirdview.b
    public boolean a(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        if (params.b() != ThirdViewEnum.SP_CARE && params.b() != ThirdViewEnum.KEYWORD) {
            return false;
        }
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.thirdview.b
    @Nullable
    public a b(@NotNull b.a params) {
        Object obj;
        g gVar;
        List listOf;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        Map<String, Object> a16 = params.a();
        if (a16 != null) {
            obj = a16.get(PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME);
        } else {
            obj = null;
        }
        if (obj instanceof g) {
            gVar = (g) obj;
        } else {
            gVar = null;
        }
        if (gVar != null) {
            listOf = CollectionsKt__CollectionsJVMKt.listOf(new a.k(gVar.s()));
            return new com.tencent.qqnt.chats.main.vm.usecase.result.a(listOf);
        }
        return null;
    }
}
