package com.tencent.qqnt.chats.main.vm.datasource.biz;

import androidx.lifecycle.LifecycleCoroutineScope;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.api.IChatsUtil;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.chats.main.vm.datasource.LocalChatsCacheDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.PlatformRecentContactsDataSource;
import com.tencent.qqnt.chats.main.vm.datasource.e;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.xweb.FileReaderHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u008d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005*\u00013\u0018\u0000 @2\u00020\u0001:\u0001\"B\u000f\u0012\u0006\u0010=\u001a\u00020<\u00a2\u0006\u0004\b>\u0010?J\u0012\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J2\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u00102\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00172\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u001a\u0010\u001a\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J8\u0010!\u001a\u00020\u00042\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u00020\u001b2\u001a\u0010 \u001a\u0016\u0012\u0004\u0012\u00020\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u001e0\u001bH\u0016J\b\u0010\"\u001a\u00020\u0004H\u0016R\u0016\u0010%\u001a\u00020#8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\"\u0010$R\u0014\u0010)\u001a\u00020&8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b'\u0010(R\u0016\u0010-\u001a\u00020*8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b+\u0010,R\u0016\u00100\u001a\u00020\r8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R\u0016\u0010\u000f\u001a\u00020\u00028\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b1\u00102R\u0016\u00105\u001a\u0002038\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u001a\u00104R \u0010;\u001a\b\u0012\u0004\u0012\u000207068\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0016\u00108\u001a\u0004\b9\u0010:\u00a8\u0006A"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", FileReaderHelper.OPEN_FILE_FROM_FORCE, "", "t", OperateCustomButton.OPERATE_CREATE, "destroy", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "", "chatUin", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "i", "g", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "contact", DomainData.DOMAIN_NAME, "f", "Lkotlin/Function1;", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "opChanged", "", "", "opGetPayload", "l", "a", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "platformDataSource", "Lcom/tencent/qqnt/chats/data/converter/b;", "b", "Lcom/tencent/qqnt/chats/data/converter/b;", "mChatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "c", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "localDataSource", "d", "J", "lastGetTopTime", "e", "Z", "com/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo$b;", "platformListenerWrapper", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "Landroidx/lifecycle/LifecycleCoroutineScope;", "scope", "<init>", "(Landroidx/lifecycle/LifecycleCoroutineScope;)V", tl.h.F, "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class GuildHelperChatsRepo implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

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
    private long lastGetTopTime;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private boolean isTop;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private b platformListenerWrapper;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\b\u0010\tR\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00058\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0006\u0010\u0007\u00a8\u0006\n"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo$a;", "", "", "CAN_GET_TOP_TIME", "J", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.biz.GuildHelperChatsRepo$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000-\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"com/tencent/qqnt/chats/main/vm/datasource/biz/GuildHelperChatsRepo$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "", "isGuildUpdate", "", "f", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "b", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements com.tencent.qqnt.chats.main.vm.datasource.e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildHelperChatsRepo.this);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void a(int i3, @Nullable String str, @Nullable RecentContactInfo recentContactInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(i3), str, recentContactInfo);
            } else {
                e.a.d(this, i3, str, recentContactInfo);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void b(@NotNull List<Long> sortedContactList, @NotNull List<RecentContactInfo> changedList, boolean isGuildUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, this, sortedContactList, changedList, Boolean.valueOf(isGuildUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(sortedContactList, "sortedContactList");
            Intrinsics.checkNotNullParameter(changedList, "changedList");
            e.a.g(GuildHelperChatsRepo.this.localDataSource, sortedContactList, changedList, false, 4, null);
            GuildHelperChatsRepo.u(GuildHelperChatsRepo.this, false, 1, null);
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void c(@NotNull List<Long> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) list);
            } else {
                e.a.b(this, list);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void d(@NotNull List<String> list) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) list);
            } else {
                e.a.a(this, list);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void e(int i3, @NotNull String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, i3, (Object) str);
            } else {
                e.a.c(this, i3, str);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, info, Boolean.valueOf(isGuildUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            e.a.f(GuildHelperChatsRepo.this.localDataSource, info, false, 2, null);
            GuildHelperChatsRepo.this.t(true);
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void onLitterEarChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this);
            } else {
                e.a.e(this);
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46125);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 22)) {
            redirector.redirect((short) 22);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public GuildHelperChatsRepo(@NotNull LifecycleCoroutineScope scope) {
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(scope, "scope");
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) scope);
            return;
        }
        this.platformDataSource = new PlatformRecentContactsDataSource(60);
        com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(60);
        this.mChatsItemConverter = bVar;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        this.localDataSource = new LocalChatsCacheDataSource(bVar, emptyList, emptyList2, false, 8, null);
        this.lastGetTopTime = System.currentTimeMillis();
        this.platformListenerWrapper = new b();
        this.dataNotify = this.localDataSource.r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void t(boolean force) {
        if (!force && System.currentTimeMillis() - this.lastGetTopTime < 1000) {
            return;
        }
        this.lastGetTopTime = System.currentTimeMillis();
        ((IChatsUtil) QRoute.api(IChatsUtil.class)).isTop("", 60, new Function1<Boolean, Unit>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.biz.GuildHelperChatsRepo$getTop$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(1);
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this, (Object) GuildHelperChatsRepo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z16) {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    GuildHelperChatsRepo.this.isTop = z16;
                } else {
                    iPatchRedirector.redirect((short) 2, (Object) this, z16);
                }
            }
        });
    }

    static /* synthetic */ void u(GuildHelperChatsRepo guildHelperChatsRepo, boolean z16, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            z16 = false;
        }
        guildHelperChatsRepo.t(z16);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this);
        } else if (!this.platformDataSource.n()) {
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
            this.platformDataSource.d(this.platformListenerWrapper);
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
            this.platformDataSource.y(this.platformListenerWrapper);
            this.localDataSource.x();
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.g(peer, callback);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) peer, (Object) callback);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
        } else {
            Intrinsics.checkNotNullParameter(chatUid, "chatUid");
            this.platformDataSource.A(chatUid, chatUin, isTop, contactType, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) opChanged, (Object) opGetPayload);
            return;
        }
        Intrinsics.checkNotNullParameter(opChanged, "opChanged");
        Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        this.localDataSource.v(opChanged, opGetPayload, 6);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) contact, (Object) callback);
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
