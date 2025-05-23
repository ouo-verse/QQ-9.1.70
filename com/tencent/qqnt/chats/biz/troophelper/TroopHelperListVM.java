package com.tencent.qqnt.chats.biz.troophelper;

import android.content.Context;
import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qqnt.chats.biz.troophelper.f;
import com.tencent.qqnt.chats.biz.troophelper.g;
import com.tencent.qqnt.chats.main.vm.ChatsListVM;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.biz.TroopHelperChatsRepo;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u0006\u0010\u0011\u001a\u00020\u0010\u0012\u0006\u0010\u0013\u001a\u00020\u0012\u0012\b\u0010\r\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\u0014\u0010\u0015J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0016\u0010\r\u001a\u0004\u0018\u00010\n8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\f\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/qqnt/chats/biz/troophelper/TroopHelperListVM;", "Lcom/tencent/qqnt/chats/main/vm/ChatsListVM;", "", "isAccountChange", "", BdhLogUtil.LogTag.Tag_Req, "T", "Lcom/tencent/qqnt/chats/core/userintent/b;", "userIntent", "M", "Lcom/tencent/qqnt/chats/biz/troophelper/a;", "w", "Lcom/tencent/qqnt/chats/biz/troophelper/a;", "troopHelperUseCase", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Landroid/content/Context;", "context", "Lcom/tencent/qqnt/chats/main/vm/datasource/biz/TroopHelperChatsRepo;", "recentContactRepo", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Landroid/content/Context;Lcom/tencent/qqnt/chats/main/vm/datasource/biz/TroopHelperChatsRepo;Lcom/tencent/qqnt/chats/biz/troophelper/a;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class TroopHelperListVM extends ChatsListVM {
    static IPatchRedirector $redirector_;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private final a troopHelperUseCase;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TroopHelperListVM(@NotNull LifecycleCoroutineScope scope, @NotNull Context context, @NotNull TroopHelperChatsRepo recentContactRepo, @Nullable a aVar) {
        super(scope, new com.tencent.qqnt.chats.core.a(context, 2), recentContactRepo);
        Intrinsics.checkNotNullParameter(scope, "scope");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, scope, context, recentContactRepo, aVar);
        } else {
            this.troopHelperUseCase = aVar;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM, com.tencent.qqnt.chats.core.mvi.a
    /* renamed from: M */
    public void l(@NotNull com.tencent.qqnt.chats.core.userintent.b userIntent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) userIntent);
            return;
        }
        Intrinsics.checkNotNullParameter(userIntent, "userIntent");
        if (userIntent instanceof g.b) {
            IRecentContactRepo H = H();
            Intrinsics.checkNotNull(H, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.datasource.biz.TroopHelperChatsRepo");
            ((TroopHelperChatsRepo) H).y();
        } else {
            if (userIntent instanceof g.c) {
                n(f.b.f354426a);
                return;
            }
            if (userIntent instanceof g.a) {
                a aVar = this.troopHelperUseCase;
                if (aVar != null) {
                    aVar.a();
                    return;
                }
                return;
            }
            super.l(userIntent);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void R(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, isAccountChange);
            return;
        }
        super.R(isAccountChange);
        IRecentContactRepo H = H();
        Intrinsics.checkNotNull(H, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.datasource.biz.TroopHelperChatsRepo");
        ((TroopHelperChatsRepo) H).x(new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chats.biz.troophelper.TroopHelperListVM$onCreate$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) TroopHelperListVM.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    TroopHelperListVM.this.n(new f.a(z16));
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this, z16);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.ChatsListVM
    public void T(boolean isAccountChange) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, isAccountChange);
            return;
        }
        IRecentContactRepo H = H();
        Intrinsics.checkNotNull(H, "null cannot be cast to non-null type com.tencent.qqnt.chats.main.vm.datasource.biz.TroopHelperChatsRepo");
        ((TroopHelperChatsRepo) H).x(null);
        super.T(isAccountChange);
    }
}
