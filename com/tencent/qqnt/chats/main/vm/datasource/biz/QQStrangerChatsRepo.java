package com.tencent.qqnt.chats.main.vm.datasource.biz;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.api.IStrangerChatsApi;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.e;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsJVMKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u009a\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00132\u00020\u0001:\u0001\u0018B\u001b\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u00a2\u0006\u0004\bC\u0010DJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0004\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J2\u0010\u0010\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00112\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\u001a\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00152\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0002H\u0016J8\u0010\u001f\u001a\u00020\u00022\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\f0\u00192\u001a\u0010\u001e\u001a\u0016\u0012\u0004\u0012\u00020\u001a\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c0\u0019H\u0016J\"\u0010#\u001a\u00020\u00022\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\b0 2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\b0 R\u0014\u0010%\u001a\u00020\u000e8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\u0018\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0014\u0010-\u001a\u00020*8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00101\u001a\u00020.8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b/\u00100R\u001b\u00107\u001a\u0002028BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b3\u00104\u001a\u0004\b5\u00106R \u0010>\u001a\b\u0012\u0004\u0012\u000209088\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=\u00a8\u0006E"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/QQStrangerChatsRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "", "chatUin", "", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "g", "i", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", DomainData.DOMAIN_NAME, "a", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "opChanged", "", "", "opGetPayload", "l", "", "removeTopSets", "addTopSets", "u", "I", "listType", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "b", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "platformDataSource", "Lcom/tencent/qqnt/chats/data/converter/b;", "c", "Lcom/tencent/qqnt/chats/data/converter/b;", "mChatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "d", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "localDataSource", "Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/e;", "e", "Lkotlin/Lazy;", "t", "()Lcom/tencent/qqnt/chats/main/vm/datasource/preprocess/e;", "platformListenerWrapper", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "f", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;", "localDateFilter", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;Lcom/tencent/qqnt/chats/main/vm/datasource/filter/a;)V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class QQStrangerChatsRepo implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final int listType;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final PlatformRecentContactsDataSource platformDataSource;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.converter.b mChatsItemConverter;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalChatsCacheDataSource localDataSource;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy platformListenerWrapper;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/QQStrangerChatsRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.biz.QQStrangerChatsRepo$a, reason: from kotlin metadata */
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

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016\u00a8\u0006\u0006"}, d2 = {"com/tencent/qqnt/chats/main/vm/datasource/biz/QQStrangerChatsRepo$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/filter/b;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "info", "", "a", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b extends com.tencent.qqnt.chats.main.vm.datasource.filter.b {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.filter.b
        public boolean a(@NotNull RecentContactInfo info) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) info)).booleanValue();
            }
            Intrinsics.checkNotNullParameter(info, "info");
            int i3 = info.chatType;
            if (i3 != 104 && i3 != 109) {
                return true;
            }
            return false;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46154);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public QQStrangerChatsRepo(@NotNull LifecycleCoroutineScope scope, @Nullable com.tencent.qqnt.chats.main.vm.datasource.filter.a aVar) {
        Lazy lazy;
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope, (Object) aVar);
            return;
        }
        this.listType = 8;
        this.platformDataSource = new PlatformRecentContactsDataSource(8);
        com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(8);
        this.mChatsItemConverter = bVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(new b());
        Unit unit = Unit.INSTANCE;
        this.localDataSource = new LocalChatsCacheDataSource(bVar, arrayList, aVar == null ? CollectionsKt__CollectionsKt.emptyList() : CollectionsKt__CollectionsJVMKt.listOf(aVar), false, 8, null);
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<com.tencent.qqnt.chats.main.vm.datasource.preprocess.e>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.biz.QQStrangerChatsRepo$platformListenerWrapper$2
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) QQStrangerChatsRepo.this);
                }
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            @NotNull
            public final com.tencent.qqnt.chats.main.vm.datasource.preprocess.e invoke() {
                LocalChatsCacheDataSource localChatsCacheDataSource;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    return (com.tencent.qqnt.chats.main.vm.datasource.preprocess.e) iPatchRedirector2.redirect((short) 2, (Object) this);
                }
                QRouteApi api = QRoute.api(IStrangerChatsApi.class);
                Intrinsics.checkNotNullExpressionValue(api, "api(IStrangerChatsApi::class.java)");
                IStrangerChatsApi iStrangerChatsApi = (IStrangerChatsApi) api;
                localChatsCacheDataSource = QQStrangerChatsRepo.this.localDataSource;
                return new com.tencent.qqnt.chats.main.vm.datasource.preprocess.e(localChatsCacheDataSource, iStrangerChatsApi.createContactInfoPreProcessor(), iStrangerChatsApi.createContactListResortProcessor());
            }
        });
        this.platformListenerWrapper = lazy;
        this.dataNotify = this.localDataSource.r();
    }

    private final com.tencent.qqnt.chats.main.vm.datasource.preprocess.e t() {
        return (com.tencent.qqnt.chats.main.vm.datasource.preprocess.e) this.platformListenerWrapper.getValue();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
        } else {
            this.platformDataSource.o(null);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            return ((Boolean) iPatchRedirector.redirect((short) 18, (Object) this)).booleanValue();
        }
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
        } else {
            this.platformDataSource.d(t());
            this.platformDataSource.e(new Contact(109, "", ""), new IOperateCallback() { // from class: com.tencent.qqnt.chats.main.vm.datasource.biz.g
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    QQStrangerChatsRepo.s(i3, str);
                }
            });
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            return (List) iPatchRedirector.redirect((short) 16, (Object) this);
        }
        return IRecentContactRepo.a.e(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            this.platformDataSource.y(t());
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g gVar, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, this, gVar, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            IRecentContactRepo.a.j(this, gVar, i3, z16);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact contact, @Nullable IOperateCallback iOperateCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) contact, (Object) iOperateCallback);
        } else {
            IRecentContactRepo.a.a(this, contact, iOperateCallback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.w(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) callback);
        } else {
            this.platformDataSource.o(callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this);
        } else {
            IRecentContactRepo.a.g(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.x(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo recentContactInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, (Object) this, (Object) recentContactInfo, i3);
        } else {
            IRecentContactRepo.a.i(this, recentContactInfo, i3);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback) {
        Object obj;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
            return;
        }
        Intrinsics.checkNotNullParameter(chatUid, "chatUid");
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> q16 = this.localDataSource.q();
        if (q16 != null) {
            Iterator<T> it = q16.iterator();
            while (true) {
                if (it.hasNext()) {
                    obj = it.next();
                    if (Intrinsics.areEqual(((com.tencent.qqnt.chats.core.adapter.itemdata.g) obj).k(), chatUid)) {
                        break;
                    }
                } else {
                    obj = null;
                    break;
                }
            }
            if (((com.tencent.qqnt.chats.core.adapter.itemdata.g) obj) != null) {
                this.platformDataSource.A(chatUid, chatUin, isTop, contactType, callback);
            }
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
        QLog.i("QQStrangerChatsRepo", 1, "notifyMultiDiffChange invoke");
        this.localDataSource.v(opChanged, opGetPayload, 5);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (com.tencent.qqnt.chats.data.c) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.dataNotify;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this);
        } else {
            IRecentContactRepo.a.n(this);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void q(@Nullable com.tencent.qqnt.chats.main.vm.datasource.d dVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            iPatchRedirector.redirect((short) 23, (Object) this, (Object) dVar);
        } else {
            IRecentContactRepo.a.p(this, dVar);
        }
    }

    public final void u(@NotNull Set<String> removeTopSets, @NotNull Set<String> addTopSets) {
        int collectionSizeOrDefault;
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this, (Object) removeTopSets, (Object) addTopSets);
            return;
        }
        Intrinsics.checkNotNullParameter(removeTopSets, "removeTopSets");
        Intrinsics.checkNotNullParameter(addTopSets, "addTopSets");
        List<com.tencent.qqnt.chats.core.adapter.itemdata.g> q16 = this.localDataSource.q();
        if (q16 != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : q16) {
                com.tencent.qqnt.chats.core.adapter.itemdata.g gVar = (com.tencent.qqnt.chats.core.adapter.itemdata.g) obj;
                if (!removeTopSets.contains(gVar.k()) && !addTopSets.contains(gVar.k())) {
                    z16 = false;
                } else {
                    z16 = true;
                }
                if (z16) {
                    arrayList.add(obj);
                }
            }
            com.tencent.qqnt.chats.main.vm.datasource.preprocess.e t16 = t();
            List<Long> g16 = t().g();
            collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10);
            ArrayList arrayList2 = new ArrayList(collectionSizeOrDefault);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                arrayList2.add(((com.tencent.qqnt.chats.core.adapter.itemdata.g) it.next()).s());
            }
            e.a.g(t16, g16, arrayList2, false, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void s(int i3, String str) {
    }
}
