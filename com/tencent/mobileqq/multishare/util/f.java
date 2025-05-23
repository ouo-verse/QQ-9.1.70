package com.tencent.mobileqq.multishare.util;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.proxy.IRecentForwardUserProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.filemanager.fileassistant.util.h;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.relation.common.api.IRelationNTRecentListApi;
import com.tencent.relation.common.nt.listener.RecentContactListener;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__MutableCollectionsJVMKt;
import kotlin.comparisons.ComparisonsKt__ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0010\u0010\u0011J\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0002J\u0016\u0010\b\u001a\u00020\u00072\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u0016\u0010\n\u001a\u00020\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u0002J\u0018\u0010\u000f\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000e\u001a\u00020\r\u00a8\u0006\u0012"}, d2 = {"Lcom/tencent/mobileqq/multishare/util/f;", "", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "f", "", "e", "outRecentUserList", "d", "Lj92/e;", "sorter", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "recentContactListener", "g", "<init>", "()V", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class f {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final f f251809a;

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016\u00a8\u0006\u0007"}, d2 = {"com/tencent/mobileqq/multishare/util/f$a", "Lcom/tencent/relation/common/nt/listener/RecentContactListener;", "", "Lcom/tencent/mobileqq/data/RecentUser;", "recentUserList", "", "onResult", "qqmultishare-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes15.dex */
    public static final class a implements RecentContactListener {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ j92.e f251810a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ RecentContactListener f251811b;

        /* compiled from: P */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u000e\u0010\u0003\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u00022\u000e\u0010\u0005\u001a\n \u0004*\u0004\u0018\u0001H\u0002H\u0002H\n\u00a2\u0006\u0004\b\u0006\u0010\u0007\u00a8\u0006\b"}, d2 = {"<anonymous>", "", "T", "a", "kotlin.jvm.PlatformType", "b", "compare", "(Ljava/lang/Object;Ljava/lang/Object;)I", "kotlin/comparisons/ComparisonsKt__ComparisonsKt$compareByDescending$1"}, k = 3, mv = {1, 7, 1}, xi = 48)
        /* renamed from: com.tencent.mobileqq.multishare.util.f$a$a, reason: collision with other inner class name */
        /* loaded from: classes15.dex */
        public static final class C8119a<T> implements Comparator {
            static IPatchRedirector $redirector_;

            public C8119a() {
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                    iPatchRedirector.redirect((short) 1, (Object) this);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t16, T t17) {
                int compareValues;
                IPatchRedirector iPatchRedirector = $redirector_;
                if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
                    compareValues = ComparisonsKt__ComparisonsKt.compareValues(Long.valueOf(((RecentUser) t17).lastmsgtime), Long.valueOf(((RecentUser) t16).lastmsgtime));
                    return compareValues;
                }
                return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) t16, (Object) t17)).intValue();
            }
        }

        a(j92.e eVar, RecentContactListener recentContactListener) {
            this.f251810a = eVar;
            this.f251811b = recentContactListener;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) eVar, (Object) recentContactListener);
            }
        }

        @Override // com.tencent.relation.common.nt.listener.RecentContactListener
        public void onResult(@NotNull List<RecentUser> recentUserList) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) recentUserList);
                return;
            }
            Intrinsics.checkNotNullParameter(recentUserList, "recentUserList");
            f fVar = f.f251809a;
            List<RecentUser> f16 = fVar.f(recentUserList);
            fVar.d(f16);
            fVar.e(f16);
            if (f16.size() > 1) {
                CollectionsKt__MutableCollectionsJVMKt.sortWith(f16, new C8119a());
            }
            j92.e eVar = this.f251810a;
            if (eVar != null) {
                eVar.a(f16);
            }
            this.f251811b.onResult(f16);
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(43362);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f251809a = new f();
        }
    }

    f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(List<RecentUser> outRecentUserList) {
        List emptyList;
        IRecentUserProxyService iRecentUserProxyService;
        IRecentForwardUserProxy recentForwardCache;
        List<RecentUser> recentList;
        boolean z16;
        if (MobileQQ.sProcessId != 1) {
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null || (iRecentUserProxyService = (IRecentUserProxyService) peekAppRuntime.getRuntimeService(IRecentUserProxyService.class, "")) == null || (recentForwardCache = iRecentUserProxyService.getRecentForwardCache()) == null || (recentList = recentForwardCache.getRecentList(false, true, false)) == null) {
            emptyList = CollectionsKt__CollectionsKt.emptyList();
        } else {
            emptyList = new ArrayList();
            for (Object obj : recentList) {
                RecentUser recentUser = (RecentUser) obj;
                if (recentUser != null && recentUser.type == 10027) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                if (z16) {
                    emptyList.add(obj);
                }
            }
        }
        if (QLog.isDevelopLevel()) {
            QLog.d("MultiShareRecentFriendsLoader", 4, "[addRecentForGuildNode]: resultSize=" + emptyList.size());
        }
        outRecentUserList.addAll(emptyList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void e(List<RecentUser> recentUserList) {
        IRecentForwardUserProxy recentForwardCache = ((IRecentUserProxyService) MobileQQ.sMobileQQ.peekAppRuntime().getRuntimeService(IRecentUserProxyService.class, "")).getRecentForwardCache();
        Intrinsics.checkNotNullExpressionValue(recentForwardCache, "appRuntime.getRuntimeSer\u2026     ).recentForwardCache");
        List<RecentUser> recentList = recentForwardCache.getRecentList(true, true, false);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (RecentUser recentUser : recentList) {
            if (recentUser.type != 10027) {
                int size = recentUserList.size();
                int i3 = 0;
                while (true) {
                    if (i3 < size) {
                        RecentUser recentUser2 = recentUserList.get(i3);
                        if (Intrinsics.areEqual(recentUser.uin, recentUser2.uin)) {
                            arrayList2.add(recentUser2);
                            arrayList3.add(Integer.valueOf(i3));
                            break;
                        }
                        i3++;
                    }
                }
            }
        }
        int size2 = recentUserList.size();
        for (int i16 = 0; i16 < size2; i16++) {
            if (!arrayList3.contains(Integer.valueOf(i16))) {
                arrayList.add(recentUserList.get(i16));
            }
        }
        recentUserList.clear();
        recentUserList.addAll(arrayList2);
        recentUserList.addAll(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<RecentUser> f(List<RecentUser> recentUserList) {
        ArrayList<RecentUser> arrayList = new ArrayList();
        arrayList.addAll(recentUserList);
        ArrayList arrayList2 = new ArrayList();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return new ArrayList();
        }
        IRuntimeService runtimeService = peekAppRuntime.getRuntimeService(IFriendDataService.class, "");
        Intrinsics.checkNotNullExpressionValue(runtimeService, "appRuntime.getRuntimeSer\u2026va, ProcessConstant.MAIN)");
        IFriendDataService iFriendDataService = (IFriendDataService) runtimeService;
        for (RecentUser recentUser : arrayList) {
            if (!Intrinsics.areEqual(recentUser.uin, AppConstants.DATALINE_NEW_VERSION_UIN) || h.o()) {
                if (!Intrinsics.areEqual(recentUser.uin, AppConstants.DATALINE_IPAD_UIN) && !Intrinsics.areEqual(recentUser.uin, AppConstants.DATALINE_PHONE_UIN) && (recentUser.type != 0 || iFriendDataService.isFriend(recentUser.uin))) {
                    if (recentUser.type == 1000) {
                        recentUser.displayName = recentUser.uin;
                    }
                    String str = recentUser.displayName;
                    Friends friendFromMemoryCache = iFriendDataService.getFriendFromMemoryCache(recentUser.uin);
                    if (friendFromMemoryCache != null) {
                        if (TextUtils.isEmpty(friendFromMemoryCache.remark)) {
                            str = friendFromMemoryCache.name;
                        } else {
                            str = friendFromMemoryCache.remark;
                        }
                        if (TextUtils.isEmpty(str)) {
                            str = recentUser.uin;
                        }
                    }
                    recentUser.displayName = str;
                    arrayList2.add(recentUser);
                }
            }
        }
        return arrayList2;
    }

    public final void g(@Nullable j92.e sorter, @NotNull RecentContactListener recentContactListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) sorter, (Object) recentContactListener);
            return;
        }
        Intrinsics.checkNotNullParameter(recentContactListener, "recentContactListener");
        ((IRelationNTRecentListApi) QRoute.api(IRelationNTRecentListApi.class)).getRecentList(MobileQQ.sMobileQQ.peekAppRuntime(), new a(sorter, recentContactListener), false);
    }
}
