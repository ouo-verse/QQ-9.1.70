package com.tencent.qqnt.chats.main.vm.datasource.biz;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u00104\u001a\u000203\u00a2\u0006\u0004\b5\u00106J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\b\u001a\u00020\u0002H\u0016J2\u0010\u0011\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00122\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J8\u0010 \u001a\u00020\u00022\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\r0\u001a2\u001a\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001d0\u001aH\u0016R\u0016\u0010#\u001a\u00020!8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\b\u0010\"R\u0014\u0010'\u001a\u00020$8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b%\u0010&R\u0016\u0010+\u001a\u00020(8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b)\u0010*R \u00102\u001a\b\u0012\u0004\u0012\u00020-0,8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\u00a8\u00067"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/c;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "a", "", "chatUid", "", "chatUin", "", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "i", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", DomainData.DOMAIN_NAME, "f", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "opChanged", "", "", "opGetPayload", "l", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "platformDataSource", "Lcom/tencent/qqnt/chats/data/converter/b;", "b", "Lcom/tencent/qqnt/chats/data/converter/b;", "mChatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "c", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "localDataSource", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "d", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class c implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PlatformRecentContactsDataSource platformDataSource;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.converter.b mChatsItemConverter;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalChatsCacheDataSource localDataSource;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    public c(@NotNull LifecycleCoroutineScope scope) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
            return;
        }
        this.platformDataSource = new PlatformRecentContactsDataSource(7);
        com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(7);
        this.mChatsItemConverter = bVar;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        LocalChatsCacheDataSource localChatsCacheDataSource = new LocalChatsCacheDataSource(bVar, emptyList, emptyList2, false, 8, null);
        this.localDataSource = localChatsCacheDataSource;
        this.dataNotify = localChatsCacheDataSource.r();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            this.platformDataSource.o(null);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return ((Boolean) iPatchRedirector.redirect((short) 16, (Object) this)).booleanValue();
        }
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            this.platformDataSource.d(this.localDataSource);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            return (List) iPatchRedirector.redirect((short) 14, (Object) this);
        }
        return IRecentContactRepo.a.e(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.platformDataSource.y(this.localDataSource);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, this, gVar, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            IRecentContactRepo.a.j(this, gVar, i3, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.g(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.w(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) callback);
        } else {
            this.platformDataSource.o(callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this);
        } else {
            IRecentContactRepo.a.g(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.x(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo recentContactInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) recentContactInfo, i3);
        } else {
            IRecentContactRepo.a.i(this, recentContactInfo, i3);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
        } else {
            Intrinsics.checkNotNullParameter(chatUid, "chatUid");
            this.platformDataSource.A(chatUid, chatUin, isTop, contactType, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) opChanged, (Object) opGetPayload);
            return;
        }
        Intrinsics.checkNotNullParameter(opChanged, "opChanged");
        Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        this.localDataSource.v(opChanged, opGetPayload, 2);
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
    public void n(@NotNull RecentContactInfo contact, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) contact, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(contact, "contact");
            this.platformDataSource.h(contact, callback);
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
    public void q(@Nullable com.tencent.qqnt.chats.main.vm.datasource.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) dVar);
        } else {
            IRecentContactRepo.a.p(this, dVar);
        }
    }
}
