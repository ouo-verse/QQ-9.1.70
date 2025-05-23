package com.tencent.qqnt.chats.main.vm.usecase.reddot;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.core.adapter.itemdata.b;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.core.adapter.itemdata.payload.m;
import com.tencent.qqnt.chats.core.uievent.a;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\b\u001a\u00020\u0007\u00a2\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0011\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0096\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/DefaultRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/reddot/IRedDotDragUseCase$a;", "params", "", "interestedIn", "invoke", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "repo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class DefaultRedDotDragUseCase extends IRedDotDragUseCase {
    static IPatchRedirector $redirector_;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DefaultRedDotDragUseCase(@NotNull IRecentContactRepo repo) {
        super(repo);
        Intrinsics.checkNotNullParameter(repo, "repo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) repo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(b item, int i3, String str) {
        Intrinsics.checkNotNullParameter(item, "$item");
        QLog.d("ItemRedDotDragUseCase", 1, "redDotDrag: result: " + i3 + ", err: " + str);
        if (i3 != 0) {
            ((IChatsUtil) QRoute.api(IChatsUtil.class)).sendEventToChat(new a.x(((g) item).k(), m.f354604a));
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    public boolean interestedIn(@NotNull IRedDotDragUseCase.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        return params.a() instanceof g;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.reddot.IRedDotDragUseCase
    public boolean invoke(@NotNull IRedDotDragUseCase.a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        final b a16 = params.a();
        if (a16 instanceof g) {
            g gVar = (g) a16;
            getRepo().f(new Contact(gVar.n(), gVar.k(), ex3.a.f(gVar.s())), new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.usecase.reddot.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    DefaultRedDotDragUseCase.b(b.this, i3, str);
                }
            });
            return true;
        }
        return false;
    }
}
