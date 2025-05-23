package com.tencent.qqnt.contact.friends;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.ntrelation.friendsinfo.bean.e;
import com.tencent.qqnt.ntrelation.otherinfo.api.IOtherInfoService;
import com.tencent.relation.common.api.IRelationNTUinAndUidApi;
import hx3.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u0007B\t\b\u0002\u00a2\u0006\u0004\b\f\u0010\rJ\u0012\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002R\u001b\u0010\u000b\u001a\u00020\u00068BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/contact/friends/NTFriendMigrationManager;", "", "Lcom/tencent/mobileqq/app/QQAppInterface;", "app", "", "d", "Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "a", "Lkotlin/Lazy;", "f", "()Lcom/tencent/mobileqq/qmmkv/v2/MMKVOptionEntityV2;", "newEntity", "<init>", "()V", "b", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes24.dex */
public final class NTFriendMigrationManager {
    static IPatchRedirector $redirector_;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE;

    /* renamed from: c, reason: collision with root package name */
    @NotNull
    private static final Lazy<NTFriendMigrationManager> f355771c;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private final Lazy newEntity;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000e\u0010\bR!\u0010\t\u001a\u00020\u00028FX\u0087\u0084\u0002\u00a2\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\n8\u0006X\u0086T\u00a2\u0006\u0006\n\u0004\b\r\u0010\f\u00a8\u0006\u000f"}, d2 = {"Lcom/tencent/qqnt/contact/friends/NTFriendMigrationManager$a;", "", "Lcom/tencent/qqnt/contact/friends/NTFriendMigrationManager;", "instance$delegate", "Lkotlin/Lazy;", "a", "()Lcom/tencent/qqnt/contact/friends/NTFriendMigrationManager;", "getInstance$annotations", "()V", WadlProxyConsts.LOAD_CONFIG_FROM_INSTANCE, "", "KEY_IS_INIT", "Ljava/lang/String;", "TAG", "<init>", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.qqnt.contact.friends.NTFriendMigrationManager$a, reason: from kotlin metadata */
    /* loaded from: classes24.dex */
    public static final class Companion {
        static IPatchRedirector $redirector_;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
                return;
            }
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
        }

        @NotNull
        public final NTFriendMigrationManager a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (NTFriendMigrationManager) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            return (NTFriendMigrationManager) NTFriendMigrationManager.f355771c.getValue();
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
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0003H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/qqnt/contact/friends/NTFriendMigrationManager$b", "Lhx3/c;", "Lcom/tencent/qqnt/ntrelation/otherinfo/bean/c;", "Lcom/tencent/qqnt/ntrelation/friendsinfo/bean/e;", WebViewPlugin.KEY_RESPONSE, "", "onUpdateResult", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes24.dex */
    public static final class b implements c<com.tencent.qqnt.ntrelation.otherinfo.bean.c> {
        static IPatchRedirector $redirector_;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f355774b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f355775c;

        b(long j3, int i3) {
            this.f355774b = j3;
            this.f355775c = i3;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, NTFriendMigrationManager.this, Long.valueOf(j3), Integer.valueOf(i3));
            }
        }

        @Override // hx3.c
        public void onUpdateResult(@Nullable e<com.tencent.qqnt.ntrelation.otherinfo.bean.c> responseData) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) responseData);
                return;
            }
            boolean z16 = false;
            if (responseData != null && responseData.a() == 0) {
                z16 = true;
            }
            if (z16) {
                NTFriendMigrationManager.this.f().putBoolean("NT_Friend_Migration_Manager_Is_Init", true);
                QLog.i("NTFriendMigrationManager", 1, "cost time:" + (System.currentTimeMillis() - this.f355774b) + " size: " + this.f355775c);
            }
        }
    }

    static {
        Lazy<NTFriendMigrationManager> lazy;
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(63933);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
            return;
        }
        INSTANCE = new Companion(null);
        lazy = LazyKt__LazyJVMKt.lazy(NTFriendMigrationManager$Companion$instance$2.INSTANCE);
        f355771c = lazy;
    }

    public /* synthetic */ NTFriendMigrationManager(DefaultConstructorMarker defaultConstructorMarker) {
        this();
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            return;
        }
        iPatchRedirector.redirect((short) 3, (Object) this, (Object) defaultConstructorMarker);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(QQAppInterface qQAppInterface, NTFriendMigrationManager this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            IRuntimeService runtimeService = qQAppInterface.getRuntimeService(IFriendExtensionService.class, "");
            Intrinsics.checkNotNullExpressionValue(runtimeService, "app.getRuntimeService(IF\u2026va, ProcessConstant.MAIN)");
            List<ExtensionInfo> friendRingIdListFromDB = ((IFriendExtensionService) runtimeService).getFriendRingIdListFromDB();
            if (friendRingIdListFromDB == null) {
                this$0.f().putBoolean("NT_Friend_Migration_Manager_Is_Init", true);
                QLog.d("NTFriendMigrationManager", 1, "extensionList == null");
                return;
            }
            ArrayList<com.tencent.qqnt.ntrelation.otherinfo.bean.c> arrayList = new ArrayList<>();
            int size = friendRingIdListFromDB.size();
            Iterator<ExtensionInfo> it = friendRingIdListFromDB.iterator();
            while (it.hasNext()) {
                String str = it.next().uin;
                String uidFromUin = ((IRelationNTUinAndUidApi) QRoute.api(IRelationNTUinAndUidApi.class)).getUidFromUin(str);
                if (str != null && uidFromUin != null) {
                    com.tencent.qqnt.ntrelation.otherinfo.bean.c cVar = new com.tencent.qqnt.ntrelation.otherinfo.bean.c(uidFromUin, str);
                    cVar.m();
                    cVar.p(r6.friendRingId);
                    arrayList.add(cVar);
                }
                QLog.d("NTFriendMigrationManager", 1, "uin == null &|| uid == null uid = " + uidFromUin + " uin = " + str);
            }
            ((IOtherInfoService) QRoute.api(IOtherInfoService.class)).accurateUpdateNTOtherSimpleInfo(arrayList, "NTFriendMigrationManager", new b(currentTimeMillis, size));
        } catch (Exception e16) {
            QLog.i("NTFriendMigrationManager", 1, "error " + e16);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final MMKVOptionEntityV2 f() {
        return (MMKVOptionEntityV2) this.newEntity.getValue();
    }

    public final void d(@Nullable final QQAppInterface app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
            return;
        }
        boolean z16 = f().getBoolean("NT_Friend_Migration_Manager_Is_Init", false);
        if (!z16 && app != null) {
            ThreadManagerV2.executeOnSubThread(new Runnable() { // from class: com.tencent.qqnt.contact.friends.a
                @Override // java.lang.Runnable
                public final void run() {
                    NTFriendMigrationManager.e(QQAppInterface.this, this);
                }
            });
            return;
        }
        if (z16) {
            QLog.i("NTFriendMigrationManager", 1, "checkFriendMigrationPrompt has init.");
        }
        if (app == null) {
            QLog.i("NTFriendMigrationManager", 1, "app == null");
        }
    }

    NTFriendMigrationManager() {
        Lazy lazy;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            lazy = LazyKt__LazyJVMKt.lazy(NTFriendMigrationManager$newEntity$2.INSTANCE);
            this.newEntity = lazy;
        }
    }
}
