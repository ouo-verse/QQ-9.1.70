package com.tencent.mobileqq.chat;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.annotation.KeepClassConstructor;
import com.tencent.mobileqq.subaccount.SubAccountAssistantUtil;
import com.tencent.mobileqq.subaccount.api.ISubAccountControllUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.usecase.meun.a;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@KeepClassConstructor
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\u0004\b\u0011\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0096\u0002R\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/mobileqq/chat/SubAccountAssistantDeleteMenuUseCase;", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a;", "", "d", "Lcom/tencent/qqnt/chats/main/vm/usecase/meun/a$a;", "params", "", "interestedIn", "Lkotlinx/coroutines/flow/Flow;", "Lcom/tencent/qqnt/chats/main/vm/usecase/result/a;", "invoke", "", "getProcessType", "()I", "processType", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "recentContactRepo", "<init>", "(Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;)V", "a", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes11.dex */
public final class SubAccountAssistantDeleteMenuUseCase extends com.tencent.qqnt.chats.main.vm.usecase.meun.a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/mobileqq/chat/SubAccountAssistantDeleteMenuUseCase$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "qqsubaccount-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.mobileqq.chat.SubAccountAssistantDeleteMenuUseCase$a, reason: from kotlin metadata */
    /* loaded from: classes11.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                return;
            }
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) defaultConstructorMarker);
        }

        Companion() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
                return;
            }
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(20017);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SubAccountAssistantDeleteMenuUseCase(@NotNull IRecentContactRepo recentContactRepo) {
        super(recentContactRepo);
        Intrinsics.checkNotNullParameter(recentContactRepo, "recentContactRepo");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) recentContactRepo);
        }
    }

    private final void d() {
        final AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        SubAccountAssistantUtil.f291050a.i(-1L);
        QLog.i("SubAccountAssistantDeleteMenuUseCase", 2, "deleteCache delete subAccount unRead");
        ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.chat.k
            @Override // java.lang.Runnable
            public final void run() {
                SubAccountAssistantDeleteMenuUseCase.e(AppRuntime.this);
            }
        }, 128, null, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(AppRuntime appRuntime) {
        if (appRuntime != null) {
            AppInterface appInterface = (AppInterface) appRuntime;
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanAllThirdQQUnreadMsgNum(appInterface);
            ((ISubAccountControllUtil) QRoute.api(ISubAccountControllUtil.class)).cleanAllSubAccountMessageUnread(appInterface, true, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void f(int i3, String str) {
        QLog.d("SubAccountAssistantDeleteMenuUseCase", 1, "deleteRecentContact: result: " + i3 + ", err: " + str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void g(int i3, String str) {
        QLog.d("SubAccountAssistantDeleteMenuUseCase", 1, "mark read: result: " + i3 + ", err: " + str);
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public int getProcessType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 0;
    }

    @Override // com.tencent.qqnt.chats.main.vm.usecase.meun.a
    public boolean interestedIn(@NotNull a.C9600a params) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) params)).booleanValue();
        }
        Intrinsics.checkNotNullParameter(params, "params");
        com.tencent.qqnt.chats.core.adapter.itemdata.b b16 = params.b();
        if (!(b16 instanceof com.tencent.qqnt.chats.core.adapter.itemdata.g) || ((com.tencent.qqnt.chats.core.adapter.itemdata.g) b16).n() != 131) {
            return false;
        }
        return true;
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
        d();
        com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) b16;
        getRecentContactRepo().n(gVar.s(), new IOperateCallback() { // from class: com.tencent.mobileqq.chat.i
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                SubAccountAssistantDeleteMenuUseCase.f(i3, str);
            }
        });
        getRecentContactRepo().g(new Contact(gVar.n(), gVar.k(), ""), new IOperateCallback() { // from class: com.tencent.mobileqq.chat.j
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                SubAccountAssistantDeleteMenuUseCase.g(i3, str);
            }
        });
        return FlowKt.flow(new SubAccountAssistantDeleteMenuUseCase$invoke$3(null));
    }
}
