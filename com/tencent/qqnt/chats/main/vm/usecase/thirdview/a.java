package com.tencent.qqnt.chats.main.vm.usecase.thirdview;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.main.vm.usecase.thirdview.b;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/a;", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b;", "Lcom/tencent/qqnt/chats/main/vm/usecase/thirdview/b$a;", "params", "", "a", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "b", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a implements b {
    static IPatchRedirector $redirector_;

    public a() {
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
        return true;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.thirdview.b
    @Nullable
    public com.tencent.qqnt.chats.main.vm.usecase.result.a b(@NotNull b.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.main.vm.usecase.result.a) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params);
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return null;
    }
}
