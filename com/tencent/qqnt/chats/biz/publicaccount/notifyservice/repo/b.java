package com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.d;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentContactService;
import com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.qqnt.msg.f;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001c2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0019\u001a\u00020\u0018\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0002H\u0016J\u0012\u0010\b\u001a\u00020\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016R \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\t8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00108\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0017\u001a\u00020\u00148\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/b;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", OperateCustomButton.OPERATE_CREATE, "destroy", ReportConstant.COSTREPORT_PREFIX, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "a", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactService;", "b", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentContactService;", "mKernelRecentContactService", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentGetContactCallback;", "c", "Lcom/tencent/qqnt/kernel/nativeinterface/IKernelRecentGetContactCallback;", "mRecentGetContactCallback", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "d", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class b implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private IKernelRecentContactService mKernelRecentContactService;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private IKernelRecentGetContactCallback mRecentGetContactCallback;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/biz/publicaccount/notifyservice/repo/b$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.b$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
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
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(40940);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 23)) {
            redirector.redirect((short) 23);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public b(@NotNull LifecycleCoroutineScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
        } else {
            this.dataNotify = new com.tencent.qqnt.chats.data.c<>();
            this.mRecentGetContactCallback = new IKernelRecentGetContactCallback() { // from class: com.tencent.qqnt.chats.biz.publicaccount.notifyservice.repo.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IKernelRecentGetContactCallback
                public final void onResult(int i3, String str, ArrayList arrayList) {
                    b.r(b.this, i3, str, arrayList);
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void r(b this$0, int i3, String str, ArrayList relation) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullExpressionValue(relation, "relation");
        if (relation.isEmpty()) {
            relation = new ArrayList();
        }
        if (i3 == 0) {
            com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(0, 1, null);
            ArrayList arrayList = new ArrayList();
            Iterator it = relation.iterator();
            while (it.hasNext()) {
                g b16 = com.tencent.qqnt.chats.data.converter.b.b(bVar, (RecentContactInfo) it.next(), null, 2, null);
                if (b16 != null) {
                    arrayList.add(b16);
                }
            }
            this$0.o().d(new com.tencent.qqnt.chats.data.b(arrayList, 0, false, false, 0, false, null, 126, null));
            return;
        }
        if (str != null) {
            this$0.o().c(i3, str);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            IRecentContactRepo.a.f(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            return ((Boolean) iPatchRedirector.redirect((short) 13, (Object) this)).booleanValue();
        }
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            s();
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (List) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return IRecentContactRepo.a.e(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable g gVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, this, gVar, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            IRecentContactRepo.a.j(this, gVar, i3, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) contact, (Object) iOperateCallback);
        } else {
            IRecentContactRepo.a.a(this, contact, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) contact, (Object) iOperateCallback);
        } else {
            IRecentContactRepo.a.k(this, contact, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        IKernelRecentContactService recentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
            return;
        }
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null && (recentContactService = k3.getRecentContactService()) != null) {
            recentContactService.getServiceAssistantRecentContactInfos(this.mRecentGetContactCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else {
            IRecentContactRepo.a.g(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) contact, (Object) iOperateCallback);
        } else {
            IRecentContactRepo.a.l(this, contact, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo recentContactInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) recentContactInfo, i3);
        } else {
            IRecentContactRepo.a.i(this, recentContactInfo, i3);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String str, long j3, boolean z16, int i3, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, this, str, Long.valueOf(j3), Boolean.valueOf(z16), Integer.valueOf(i3), iOperateCallback);
        } else {
            IRecentContactRepo.a.q(this, str, j3, z16, i3, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super g, Boolean> function1, @NotNull Function1<? super g, Object[]> function12) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) function1, (Object) function12);
        } else {
            IRecentContactRepo.a.m(this, function1, function12);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
        } else {
            IRecentContactRepo.a.o(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void n(@NotNull RecentContactInfo recentContactInfo, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) recentContactInfo, (Object) iOperateCallback);
        } else {
            IRecentContactRepo.a.c(this, recentContactInfo, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @NotNull
    public com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.qqnt.chats.data.c) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.dataNotify;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this);
        } else {
            IRecentContactRepo.a.n(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void q(@Nullable d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dVar);
        } else {
            IRecentContactRepo.a.p(this, dVar);
        }
    }

    public void s() {
        IKernelRecentContactService iKernelRecentContactService;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        IQQNTWrapperSession k3 = f.k();
        if (k3 != null) {
            iKernelRecentContactService = k3.getRecentContactService();
        } else {
            iKernelRecentContactService = null;
        }
        this.mKernelRecentContactService = iKernelRecentContactService;
        if (iKernelRecentContactService != null) {
            iKernelRecentContactService.getServiceAssistantRecentContactInfos(this.mRecentGetContactCallback);
        }
    }
}
