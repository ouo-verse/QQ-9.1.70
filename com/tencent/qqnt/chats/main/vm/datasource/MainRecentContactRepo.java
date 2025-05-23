package com.tencent.qqnt.chats.main.vm.datasource;

import androidx.core.app.NotificationCompat;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.hippy.qq.view.tkd.listview.HippyTKDListViewAdapter;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.minigame.action.OperateCustomButton;
import com.tencent.qqnt.chats.main.api.IMainChatEarManager;
import com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernel.utils.n;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import com.tencent.state.data.SquareJSConst;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0093\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\b\u0006*\u0001H\b\u0016\u0018\u0000 /2\u00020\u0001:\u0001\u000eB\u0007\u00a2\u0006\u0004\bK\u0010LJ$\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0002H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\b\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u0002H\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0006\u0010\u000f\u001a\u00020\u0007J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J2\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001a2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010 \u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\"\u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010#\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001d2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016J8\u0010)\u001a\u00020\u00072\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00180$2\u001a\u0010(\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\f\u0012\n\u0012\u0004\u0012\u00020'\u0018\u00010&0$H\u0016J\"\u0010-\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\f2\u0006\u0010+\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020\u0018H\u0016J\u001a\u0010/\u001a\u00020\u00072\b\u0010*\u001a\u0004\u0018\u00010\u00032\u0006\u0010.\u001a\u00020\u001aH\u0016J\u0012\u00101\u001a\u00020\u00072\b\u0010\u0013\u001a\u0004\u0018\u000100H\u0016R\u0016\u00103\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u000e\u00102R\u0016\u00105\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b4\u00102R\u0016\u00107\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b6\u00102R\u0014\u0010:\u001a\u0002088\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\r\u00109R\u0016\u0010=\u001a\u00020;8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b-\u0010<R\u0016\u0010@\u001a\u00020>8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b#\u0010?R\u0016\u0010A\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b \u00102R \u0010G\u001a\b\u0012\u0004\u0012\u00020C0B8\u0016X\u0096\u0004\u00a2\u0006\f\n\u0004\b\u0011\u0010D\u001a\u0004\bE\u0010FR\u0014\u0010J\u001a\u00020H8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001f\u0010I\u00a8\u0006M"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo;", "Lcom/tencent/qqnt/chats/main/vm/datasource/IRecentContactRepo;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "sortedContactList", "", HippyTKDListViewAdapter.X, OperateCustomButton.OPERATE_CREATE, "p", "destroy", "Lcom/tencent/qqnt/chats/core/adapter/itemdata/g;", "d", "a", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, h.F, "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", "getRecentContactList", "", "chatUid", "chatUin", "", "isTop", "", "contactType", "k", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "i", "g", "contact", DomainData.DOMAIN_NAME, "f", "Lkotlin/Function1;", "opChanged", "", "", "opGetPayload", "l", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, com.tencent.luggage.wxa.c8.c.G, "loadNext", "e", "jumpType", "j", "Lcom/tencent/qqnt/chats/main/vm/datasource/d;", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Z", "isCreated", "b", "isDestroyed", "c", "isInTop", "Lcom/tencent/qqnt/chats/data/converter/b;", "Lcom/tencent/qqnt/chats/data/converter/b;", "chatsItemConverter", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/PlatformRecentContactsDataSource;", "platformDataSource", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "Lcom/tencent/qqnt/chats/main/vm/datasource/LocalChatsCacheDataSource;", "localCacheDataSource", "isShieldPartUpdate", "Lcom/tencent/qqnt/chats/data/c;", "Lcom/tencent/qqnt/chats/data/b;", "Lcom/tencent/qqnt/chats/data/c;", "o", "()Lcom/tencent/qqnt/chats/data/c;", "dataNotify", "com/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo$b;", "platformListenerWrapper", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public class MainRecentContactRepo implements IRecentContactRepo {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private boolean isCreated;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private boolean isDestroyed;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private boolean isInTop;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.converter.b chatsItemConverter;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private PlatformRecentContactsDataSource platformDataSource;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private LocalChatsCacheDataSource localCacheDataSource;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    private volatile boolean isShieldPartUpdate;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final com.tencent.qqnt.chats.data.c<com.tencent.qqnt.chats.data.b> dataNotify;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final b platformListenerWrapper;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u0004\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo$a;", "", "", "TAG", "Ljava/lang/String;", "<init>", "()V", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo$a, reason: from kotlin metadata */
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
    @Metadata(d1 = {"\u0000=\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\b*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J,\u0010\r\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\b2\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\bH\u0016J\u0016\u0010\u0012\u001a\u00020\u00062\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0016J\b\u0010\u0013\u001a\u00020\u0006H\u0016J$\u0010\u0018\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00142\b\u0010\u0016\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0017\u001a\u0004\u0018\u00010\u000bH\u0016J\u0018\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u000eH\u0016\u00a8\u0006\u001c"}, d2 = {"com/tencent/qqnt/chats/main/vm/datasource/MainRecentContactRepo$b", "Lcom/tencent/qqnt/chats/main/vm/datasource/e;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "info", "", "isGuildUpdate", "", "f", "", "", "sortedContactList", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "b", "", "uidList", "d", SquareJSConst.Params.PARAMS_UIN_LIST, "c", "onLitterEarChange", "", "result", "errMsg", "curSpecifyInfo", "a", NotificationCompat.CATEGORY_ERROR, "msg", "e", "chats_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements e {
        static IPatchRedirector $redirector_;

        b() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) MainRecentContactRepo.this);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void a(int result, @Nullable String errMsg, @Nullable RecentContactInfo curSpecifyInfo) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, this, Integer.valueOf(result), errMsg, curSpecifyInfo);
            } else {
                MainRecentContactRepo.this.localCacheDataSource.a(result, errMsg, curSpecifyInfo);
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
            MainRecentContactRepo.this.localCacheDataSource.b(sortedContactList, changedList, isGuildUpdate);
            MainRecentContactRepo.this.x(changedList, sortedContactList);
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void c(@NotNull List<Long> uinList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) uinList);
            } else {
                Intrinsics.checkNotNullParameter(uinList, "uinList");
                MainRecentContactRepo.this.localCacheDataSource.c(uinList);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void d(@NotNull List<String> uidList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) uidList);
            } else {
                Intrinsics.checkNotNullParameter(uidList, "uidList");
                MainRecentContactRepo.this.localCacheDataSource.d(uidList);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void e(int err, @NotNull String msg2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
                iPatchRedirector.redirect((short) 8, (Object) this, err, (Object) msg2);
            } else {
                Intrinsics.checkNotNullParameter(msg2, "msg");
                MainRecentContactRepo.this.localCacheDataSource.e(err, msg2);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void f(@NotNull RecentContactListChangedInfo info, boolean isGuildUpdate) {
            IPatchRedirector iPatchRedirector = $redirector_;
            boolean z16 = true;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, this, info, Boolean.valueOf(isGuildUpdate));
                return;
            }
            Intrinsics.checkNotNullParameter(info, "info");
            if (!MainRecentContactRepo.this.isShieldPartUpdate || info.notificationType != 2) {
                MainRecentContactRepo.this.isShieldPartUpdate = false;
                MainRecentContactRepo.this.localCacheDataSource.f(info, isGuildUpdate);
                MainRecentContactRepo mainRecentContactRepo = MainRecentContactRepo.this;
                if (info.cacheLocation != 1) {
                    z16 = false;
                }
                mainRecentContactRepo.isInTop = z16;
                MainRecentContactRepo mainRecentContactRepo2 = MainRecentContactRepo.this;
                ArrayList<RecentContactInfo> arrayList = info.changedList;
                Intrinsics.checkNotNullExpressionValue(arrayList, "info.changedList");
                ArrayList<Long> arrayList2 = info.sortedContactList;
                Intrinsics.checkNotNullExpressionValue(arrayList2, "info.sortedContactList");
                mainRecentContactRepo2.x(arrayList, arrayList2);
            }
        }

        @Override // com.tencent.qqnt.chats.main.vm.datasource.e
        public void onLitterEarChange() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this);
            } else {
                MainRecentContactRepo.this.localCacheDataSource.onLitterEarChange();
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(46079);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 24)) {
            redirector.redirect((short) 24);
        } else {
            INSTANCE = new Companion(null);
        }
    }

    public MainRecentContactRepo() {
        List emptyList;
        List emptyList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.data.converter.b bVar = new com.tencent.qqnt.chats.data.converter.b(1);
        this.chatsItemConverter = bVar;
        this.platformDataSource = new PlatformRecentContactsDataSource(1);
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        emptyList2 = CollectionsKt__CollectionsKt.emptyList();
        LocalChatsCacheDataSource localChatsCacheDataSource = new LocalChatsCacheDataSource(bVar, emptyList, emptyList2, true);
        this.localCacheDataSource = localChatsCacheDataSource;
        this.dataNotify = localChatsCacheDataSource.r();
        this.platformListenerWrapper = new b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void x(List<RecentContactInfo> changedList, List<Long> sortedContactList) {
        if (!this.isInTop) {
            return;
        }
        Iterator<RecentContactInfo> it = changedList.iterator();
        while (it.hasNext()) {
            if (sortedContactList.indexOf(Long.valueOf(it.next().contactId)) < 15) {
                com.tencent.qqnt.chats.data.persistent.c.f(com.tencent.qqnt.chats.data.persistent.c.f355136a, false, 1, null);
                return;
            }
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainRecentContactRepo", 2, "getRecentContactFromCache");
        }
        n.f359273a.f(new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo$getRecentContactFromCache$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainRecentContactRepo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                PlatformRecentContactsDataSource platformRecentContactsDataSource;
                PlatformRecentContactsDataSource platformRecentContactsDataSource2;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                platformRecentContactsDataSource = MainRecentContactRepo.this.platformDataSource;
                if (!platformRecentContactsDataSource.n()) {
                    platformRecentContactsDataSource2 = MainRecentContactRepo.this.platformDataSource;
                    platformRecentContactsDataSource2.o(null);
                } else {
                    ((IMainChatEarManager) QRoute.api(IMainChatEarManager.class)).onLitterEarChange();
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public boolean c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 23)) {
            return ((Boolean) iPatchRedirector.redirect((short) 23, (Object) this)).booleanValue();
        }
        return IRecentContactRepo.a.h(this);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void create() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (this.isCreated) {
            QLog.d("MainRecentContactRepo", 1, "create is call when created");
        } else if (this.platformDataSource.d(this.platformListenerWrapper)) {
            QLog.d("MainRecentContactRepo", 1, "on Create");
            this.isCreated = true;
            this.isDestroyed = false;
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    @Nullable
    public List<com.tencent.qqnt.chats.core.adapter.itemdata.g> d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (List) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.localCacheDataSource.q();
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void destroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        if (this.isDestroyed) {
            QLog.d("MainRecentContactRepo", 1, "destroy is call when destroyed");
            return;
        }
        QLog.d("MainRecentContactRepo", 1, "on Destroy");
        this.platformDataSource.y(this.platformListenerWrapper);
        this.platformDataSource.z();
        this.localCacheDataSource.x();
        this.isDestroyed = true;
        this.isCreated = false;
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void e(@Nullable com.tencent.qqnt.chats.core.adapter.itemdata.g item, int pos, boolean loadNext) {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 19)) {
            iPatchRedirector.redirect((short) 19, this, item, Integer.valueOf(pos), Boolean.valueOf(loadNext));
            return;
        }
        PlatformRecentContactsDataSource platformRecentContactsDataSource = this.platformDataSource;
        if (item != null) {
            j3 = item.m();
        } else {
            j3 = 0;
        }
        platformRecentContactsDataSource.t(new AnchorPointContactInfo(j3, 0L, pos), loadNext);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void f(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.g(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void g(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 15)) {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.w(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void getRecentContactList(@Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) callback);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainRecentContactRepo", 2, "getRecentContactList");
        }
        this.platformDataSource.o(callback);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void h() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this);
            return;
        }
        com.tencent.qqnt.chats.data.persistent.c cVar = com.tencent.qqnt.chats.data.persistent.c.f355136a;
        List<RecentContactInfo> j3 = cVar.j();
        if (j3.isEmpty()) {
            j3 = cVar.l();
        }
        final List<RecentContactInfo> list = j3;
        List<Long> k3 = cVar.k();
        if (k3.isEmpty()) {
            k3 = cVar.m();
        }
        final List<Long> list2 = k3;
        if (!list2.isEmpty() && !list.isEmpty()) {
            z16 = true;
        } else {
            z16 = false;
        }
        QLog.i("MainRecentContactRepo", 1, "getRecentContactFromCacheOnly, isPreLoad=" + z16);
        if (!z16) {
            return;
        }
        n.f359273a.d(new Function0<Unit>(list2, list) { // from class: com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo$getRecentContactFromLocalCache$1
            static IPatchRedirector $redirector_;
            final /* synthetic */ List<RecentContactInfo> $data;
            final /* synthetic */ List<Long> $sortList;

            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.$sortList = list2;
                this.$data = list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, MainRecentContactRepo.this, list2, list);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                LocalChatsCacheDataSource localChatsCacheDataSource = MainRecentContactRepo.this.localCacheDataSource;
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.$sortList);
                Unit unit = Unit.INSTANCE;
                ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.$data);
                localChatsCacheDataSource.w(new RecentContactListChangedInfo(1, arrayList, arrayList2, 1, 0L, 0L, 1L, 0L, false, false));
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void i(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) peer, (Object) callback);
        } else {
            Intrinsics.checkNotNullParameter(peer, "peer");
            this.platformDataSource.x(peer, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void j(@Nullable RecentContactInfo item, int jumpType) {
        String str;
        int i3;
        String f16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 21)) {
            iPatchRedirector.redirect((short) 21, (Object) this, (Object) item, jumpType);
            return;
        }
        PlatformRecentContactsDataSource platformRecentContactsDataSource = this.platformDataSource;
        if (item != null) {
            str = item.peerUid;
        } else {
            str = null;
        }
        String str2 = "";
        if (str == null) {
            str = "";
        }
        if (item != null && (f16 = ex3.a.f(item)) != null) {
            str2 = f16;
        }
        if (item != null) {
            i3 = item.chatType;
        } else {
            i3 = 0;
        }
        platformRecentContactsDataSource.r(str, str2, i3, jumpType);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void k(@NotNull String chatUid, long chatUin, boolean isTop, int contactType, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, this, chatUid, Long.valueOf(chatUin), Boolean.valueOf(isTop), Integer.valueOf(contactType), callback);
        } else {
            Intrinsics.checkNotNullParameter(chatUid, "chatUid");
            this.platformDataSource.A(chatUid, chatUin, isTop, contactType, callback);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void l(@NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Boolean> opChanged, @NotNull Function1<? super com.tencent.qqnt.chats.core.adapter.itemdata.g, Object[]> opGetPayload) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 18)) {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) opChanged, (Object) opGetPayload);
            return;
        }
        Intrinsics.checkNotNullParameter(opChanged, "opChanged");
        Intrinsics.checkNotNullParameter(opGetPayload, "opGetPayload");
        this.localCacheDataSource.v(opChanged, opGetPayload, 0);
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void m() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("MainRecentContactRepo", 2, "setAndGetRecentContactFromCache");
        }
        n.f359273a.d(new Function0<Unit>() { // from class: com.tencent.qqnt.chats.main.vm.datasource.MainRecentContactRepo$setAndGetRecentContactFromCache$1
            static IPatchRedirector $redirector_;

            /* JADX INFO: Access modifiers changed from: package-private */
            {
                super(0);
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, (Object) this, (Object) MainRecentContactRepo.this);
                }
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 == null || !iPatchRedirector2.hasPatch((short) 2)) {
                    MainRecentContactRepo.this.localCacheDataSource.z();
                } else {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                }
            }
        });
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void n(@NotNull RecentContactInfo contact, @Nullable IOperateCallback callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 16)) {
            iPatchRedirector.redirect((short) 16, (Object) this, (Object) contact, (Object) callback);
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
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else {
            IRecentContactRepo.a.n(this);
            this.platformDataSource.d(this.platformListenerWrapper);
        }
    }

    @Override // com.tencent.qqnt.chats.main.vm.datasource.IRecentContactRepo
    public void q(@Nullable d callback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 22)) {
            iPatchRedirector.redirect((short) 22, (Object) this, (Object) callback);
        } else {
            this.localCacheDataSource.A(callback);
        }
    }

    public final void w() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
        } else {
            this.platformDataSource.v(new AnchorPointContactInfo(), true, 6);
        }
    }
}
