package ny;

import com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.api.IContactCommAPI;
import com.tencent.qqnt.chats.core.adapter.itemdata.g;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.ContactTopData;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001\u001eB\u0007\u00a2\u0006\u0004\b'\u0010(J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u001b\u001a\u00020\u0004H\u0016R \u0010\"\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!R\u0016\u0010&\u001a\u00020#8\u0002@\u0002X\u0082.\u00a2\u0006\u0006\n\u0004\b$\u0010%\u00a8\u0006*"}, d2 = {"Lny/e;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "Lcom/tencent/qqnt/kernel/api/aa;", "v", "", OperateCustomButton.OPERATE_CREATE, "w", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "", "chatUin", "", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", DomainData.DOMAIN_NAME, "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "g", "f", "i", "destroy", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "a", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager$a;", "b", "Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager$a;", "mListener", "<init>", "()V", "c", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class e implements IRecentContactRepo {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify = new com.tencent.qqnt.chats.data.c<>();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private ServiceAccountFolderNTManager.a mListener;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"ny/e$b", "Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager$a;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public static final class b implements ServiceAccountFolderNTManager.a {
        b() {
        }

        @Override // com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager.a
        public void a(@Nullable List<RecentContactInfo> data) {
            boolean z16;
            List<RecentContactInfo> list = data;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (z16) {
                e.this.o().d(new com.tencent.qqnt.chats.data.b(new ArrayList(), 0, false, false, 0, false, null, 126, null));
            } else {
                e.this.o().d(((IContactCommAPI) QRoute.api(IContactCommAPI.class)).convertRecentInfoToNotifyItem(data, 3));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    private final aa v() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        aa aaVar = null;
        if (peekAppRuntime == null) {
            return null;
        }
        IKernelService iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "");
        if (iKernelService != null) {
            aaVar = iKernelService.getRecentContactService();
        }
        if (aaVar == null) {
            QLog.i("ServiceAccountFolderRepo", 1, "getMsgService == null");
        }
        return aaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void x(IOperateCallback iOperateCallback, int i3, String str) {
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void y(IOperateCallback iOperateCallback, e this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
        this$0.w();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void z(IOperateCallback iOperateCallback, e this$0, int i3, String str) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (iOperateCallback != null) {
            iOperateCallback.onResult(i3, str);
        }
        this$0.w();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IRecentContactRepo.a.f(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IRecentContactRepo.a.b(this);
        b bVar = new b();
        this.mListener = bVar;
        ServiceAccountFolderNTManager.f79965a.c(bVar);
        w();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<g> d() {
        return IRecentContactRepo.a.e(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IRecentContactRepo.a.d(this);
        ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
        ServiceAccountFolderNTManager.a aVar = this.mListener;
        if (aVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mListener");
            aVar = null;
        }
        serviceAccountFolderNTManager.r(aVar);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable g gVar, int i3, boolean z16) {
        IRecentContactRepo.a.j(this, gVar, i3, z16);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        IRecentContactRepo.a.a(this, peer, callback);
        g(peer, callback);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact peer, @Nullable final IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        IRecentContactRepo.a.k(this, peer, callback);
        ServiceAccountFolderNTManager.f79965a.m(peer, new IOperateCallback() { // from class: ny.a
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                e.x(IOperateCallback.this, i3, str);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        ServiceAccountFolderNTManager.f79965a.d();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        IRecentContactRepo.a.g(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact peer, @Nullable final IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        IRecentContactRepo.a.l(this, peer, callback);
        ServiceAccountFolderNTManager.f79965a.n(peer, new IOperateCallback() { // from class: ny.b
            @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
            public final void onResult(int i3, String str) {
                e.y(IOperateCallback.this, this, i3, str);
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo recentContactInfo, int i3) {
        IRecentContactRepo.a.i(this, recentContactInfo, i3);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable final IOperateCallback callback) {
        ArrayList<ContactTopData> arrayListOf;
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        ContactTopData contactTopData = new ContactTopData();
        contactTopData.chatType = contactType;
        contactTopData.uin = chatUin;
        contactTopData.uid = chatUid;
        aa v3 = v();
        if (v3 != null) {
            arrayListOf = CollectionsKt__CollectionsKt.arrayListOf(contactTopData);
            v3.setContactListTop(isTop, arrayListOf, new IOperateCallback() { // from class: ny.d
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    e.z(IOperateCallback.this, this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super g, Boolean> function1, @NotNull Function1<? super g, Object[]> function12) {
        IRecentContactRepo.a.m(this, function1, function12);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void m() {
        IRecentContactRepo.a.o(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void n(@NotNull RecentContactInfo contact, @Nullable final IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(contact, "contact");
        ArrayList<Contact> arrayList = new ArrayList<>();
        arrayList.add(new Contact(contact.chatType, contact.peerUid, ex3.a.f(contact)));
        aa v3 = v();
        if (v3 != null) {
            v3.a0(arrayList, new IOperateCallback() { // from class: ny.c
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    e.u(IOperateCallback.this, i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @NotNull
    public com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> o() {
        return this.dataNotify;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void p() {
        IRecentContactRepo.a.n(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void q(@Nullable com.tencent.qqnt.chats.main.vm.datasource.d dVar) {
        IRecentContactRepo.a.p(this, dVar);
    }

    public void w() {
        ServiceAccountFolderNTManager.f79965a.d();
    }
}
