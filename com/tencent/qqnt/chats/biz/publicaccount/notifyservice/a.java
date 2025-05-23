package com.tencent.qqnt.chats.biz.publicaccount.notifyservice;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.b;
import com.tencent.qqnt.chats.core.userintent.b;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\t\u001a\u00020\u0006\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\b\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/a;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "Lcom/tencent/qqnt/chats/core/userintent/b;", "userIntent", "", "M", "Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/b;", "w", "Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/b;", "notifyServiceRepo", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/biz/notifyservice/a;", "notifyServiceUseCase", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/b;Lcom/tencent/qqnt/chats/biz/notifyservice/a;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class a extends ChatsListVM {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b notifyServiceRepo;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull b notifyServiceRepo, @Nullable com.tencent.qqnt.chats.biz.notifyservice.a aVar) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 0), notifyServiceRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(notifyServiceRepo, "notifyServiceRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, context, notifyServiceRepo, aVar);
        } else {
            this.notifyServiceRepo = notifyServiceRepo;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M */
    public void l(@NotNull com.tencent.qqnt.chats.core.userintent.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        super.l(userIntent);
        if (Intrinsics.areEqual(b.i.f355089a, userIntent)) {
            this.notifyServiceRepo.s();
        }
    }
}
