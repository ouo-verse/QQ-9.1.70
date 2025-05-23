package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.biz.pubaccount.accountdetail.api.IPublicAccountDetail;
import com.tencent.biz.pubaccount.api.IPublicAccountDataManager;
import com.tencent.biz.pubaccount.util.api.IPublicAccountUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.api.w;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.IOperateCallback;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import com.tencent.qqnt.kernelpublic.nativeinterface.Contact;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001:B\t\b\u0002\u00a2\u0006\u0004\b8\u00109J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0002J\n\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J$\u0010\f\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0006H\u0002J$\u0010\u000e\u001a\u00020\u000b2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\r2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\u0016\u0010\u000f\u001a\u00020\u000b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002JV\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0010j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007`\u00112\"\u0010\u0012\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u0010j\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007`\u00112\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u0002J\b\u0010\u0014\u001a\u00020\u000bH\u0002J\u0010\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rH\u0002J\u0010\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0002J\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0018\u0010$\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0018\u0010%\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020 2\b\u0010#\u001a\u0004\u0018\u00010\"J\u0010\u0010(\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&J\u0010\u0010)\u001a\u00020\u000b2\b\u0010'\u001a\u0004\u0018\u00010&J\u0006\u0010*\u001a\u00020\u000bJ\u000e\u0010+\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rJ\u000e\u0010,\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010-\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u001aR6\u00100\u001a\"\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0010j\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u00118\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b.\u0010/R&\u00103\u001a\u0012\u0012\u0004\u0012\u00020&0\u0006j\b\u0012\u0004\u0012\u00020&`18\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b(\u00102R \u00107\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\u000b048\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u001e\u00106\u00a8\u0006;"}, d2 = {"Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager;", "", "Lcom/tencent/qqnt/kernel/api/aa;", "i", "Lcom/tencent/qqnt/kernel/api/w;", "g", "Ljava/util/ArrayList;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "changedList", "", "sortList", "", "p", "", "w", QCircleScheme.AttrQQPublish.INPUT_TAB_QZONE_TEXT_TAB, "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "newChangList", "v", "o", "f", "", "uin", "", "l", "Lcom/tencent/biz/pubaccount/accountdetail/api/IPublicAccountDetail;", "detail", "", h.F, "d", "t", "Lcom/tencent/qqnt/kernelpublic/nativeinterface/Contact;", "peer", "Lcom/tencent/qqnt/kernel/nativeinterface/IOperateCallback;", "callback", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, DomainData.DOMAIN_NAME, "Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager$a;", "uiUpdateListener", "c", "r", ReportConstant.COSTREPORT_PREFIX, "e", "k", "j", "b", "Ljava/util/LinkedHashMap;", "chatsListCacheMap", "Lkotlin/collections/ArrayList;", "Ljava/util/ArrayList;", "uiUpdateListeners", "Lkotlin/Function1;", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "Lkotlin/jvm/functions/Function1;", "mPlatformListenerWrapper", "<init>", "()V", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes4.dex */
public final class ServiceAccountFolderNTManager {

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @Nullable
    private static LinkedHashMap<Long, RecentContactInfo> chatsListCacheMap;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ServiceAccountFolderNTManager f79965a = new ServiceAccountFolderNTManager();

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static ArrayList<a> uiUpdateListeners = new ArrayList<>();

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Function1<RecentContactListChangedInfo, Unit> mPlatformListenerWrapper = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderNTManager$mPlatformListenerWrapper$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
            invoke2(recentContactListChangedInfo);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull RecentContactListChangedInfo info) {
            Intrinsics.checkNotNullParameter(info, "info");
            ServiceAccountFolderNTManager serviceAccountFolderNTManager = ServiceAccountFolderNTManager.f79965a;
            ArrayList<RecentContactInfo> arrayList = info.changedList;
            Intrinsics.checkNotNullExpressionValue(arrayList, "info.changedList");
            ArrayList<Long> arrayList2 = info.sortedContactList;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "info.sortedContactList");
            serviceAccountFolderNTManager.p(arrayList, arrayList2);
        }
    };

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/biz/pubaccount/serviceAccountFolder/ServiceAccountFolderNTManager$a;", "", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "data", "", "a", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes4.dex */
    public interface a {
        void a(@Nullable List<RecentContactInfo> data);
    }

    ServiceAccountFolderNTManager() {
    }

    private final List<RecentContactInfo> f() {
        ArrayList arrayList = new ArrayList();
        List<RecentContactInfo> e16 = e();
        if (e16 != null) {
            for (RecentContactInfo recentContactInfo : e16) {
                ServiceAccountFolderNTManager serviceAccountFolderNTManager = f79965a;
                if (serviceAccountFolderNTManager.l(String.valueOf(recentContactInfo.peerUin))) {
                    serviceAccountFolderNTManager.m(new Contact(103, recentContactInfo.peerUid, ""), null);
                } else {
                    arrayList.add(recentContactInfo);
                }
            }
        }
        return arrayList;
    }

    private final w g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        w msgService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getMsgService();
        if (msgService == null) {
            QLog.i("ServiceAccountFolderNTManager", 1, "getService == null");
        }
        return msgService;
    }

    private final int h(IPublicAccountDetail detail) {
        int i3;
        if (detail == null) {
            return -1;
        }
        long accountFlag2 = detail.getAccountFlag2();
        int i16 = (int) ((30720 & accountFlag2) >> 11);
        int i17 = 3;
        if (i16 != 1) {
            if (i16 != 2) {
                if (i16 != 3) {
                    if (i16 != 4) {
                        i3 = -1;
                    } else {
                        i3 = 3;
                    }
                } else {
                    i3 = 0;
                }
            } else {
                i3 = 1;
            }
        } else {
            i3 = 2;
        }
        int accountFlag = detail.getAccountFlag();
        int accountType = ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType(accountFlag);
        if (((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).isSubscript(accountFlag, accountFlag2)) {
            i17 = 2;
        } else if (accountType != -5) {
            i17 = 1;
        }
        if ((i3 == 0 && i17 == 2) || (i3 == 2 && i17 == 1)) {
            i3 = 1;
        } else if (i3 == -1) {
            i3 = i17;
        }
        StringBuilder sb5 = new StringBuilder(256);
        sb5.append("updateServiceAccountBelongInfo()->getPublicAccountFolderType->puin:");
        sb5.append(detail.getUin());
        sb5.append(", folder type:");
        sb5.append(i3);
        sb5.append(", detail accountFlag:");
        sb5.append(detail.getAccountData());
        sb5.append(", detail accountFlag2:");
        sb5.append(detail.getAccountFlag2());
        QLog.d("ServiceAccountFolderNTManager", 1, sb5.toString());
        return i3;
    }

    private final aa i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            return null;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService == null) {
            QLog.i("ServiceAccountFolderNTManager", 1, "getService == null");
        }
        return recentContactService;
    }

    private final boolean l(String uin) {
        AppRuntime peekAppRuntime;
        Object findPublicAccountInfo;
        if (((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("remove_certified_account_check_in_account_folder", true) || (peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime()) == null || !(peekAppRuntime instanceof QQAppInterface)) {
            return false;
        }
        IPublicAccountDataManager iPublicAccountDataManager = (IPublicAccountDataManager) peekAppRuntime.getRuntimeService(IPublicAccountDataManager.class, "all");
        if (iPublicAccountDataManager != null && (findPublicAccountInfo = iPublicAccountDataManager.findPublicAccountInfo(uin)) != null && ((IPublicAccountUtil) QRoute.api(IPublicAccountUtil.class)).getAccountType2(((PublicAccountInfo) findPublicAccountInfo).accountFlag2) == -10) {
            return true;
        }
        return false;
    }

    private final void o() {
        ArrayList<a> arrayList = uiUpdateListeners;
        if (arrayList != null) {
            Iterator<T> it = arrayList.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(f79965a.f());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void p(ArrayList<RecentContactInfo> changedList, ArrayList<Long> sortList) {
        try {
            w(changedList, sortList);
        } catch (Throwable th5) {
            QLog.e("ServiceAccountFolderNTManager", 1, "[PA-NT-Msg] error=" + th5.getMessage(), th5);
        }
    }

    private final synchronized void q(List<Long> sortList) {
        Iterator<Map.Entry<Long, RecentContactInfo>> it;
        LinkedHashMap<Long, RecentContactInfo> linkedHashMap = chatsListCacheMap;
        Intrinsics.checkNotNull(linkedHashMap);
        Set<Map.Entry<Long, RecentContactInfo>> entrySet = linkedHashMap.entrySet();
        if (entrySet != null) {
            it = entrySet.iterator();
        } else {
            it = null;
        }
        if (it != null) {
            while (it.hasNext()) {
                Map.Entry<Long, RecentContactInfo> next = it.next();
                Intrinsics.checkNotNullExpressionValue(next, "it.next()");
                if (!sortList.contains(next.getKey())) {
                    it.remove();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void u(int i3, String str) {
        QLog.i("ServiceAccountFolderNTManager", 2, "serviceAccountMarkRead result: " + i3 + " errMsg:" + str);
    }

    private final LinkedHashMap<Long, RecentContactInfo> v(LinkedHashMap<Long, RecentContactInfo> newChangList, List<Long> sortList) {
        LinkedHashMap<Long, RecentContactInfo> linkedHashMap = new LinkedHashMap<>();
        Iterator<T> it = sortList.iterator();
        while (it.hasNext()) {
            long longValue = ((Number) it.next()).longValue();
            if (newChangList.containsKey(Long.valueOf(longValue))) {
                Long valueOf = Long.valueOf(longValue);
                RecentContactInfo recentContactInfo = newChangList.get(Long.valueOf(longValue));
                Intrinsics.checkNotNull(recentContactInfo);
                linkedHashMap.put(valueOf, recentContactInfo);
            }
        }
        for (Map.Entry<Long, RecentContactInfo> entry : newChangList.entrySet()) {
            if (linkedHashMap.get(entry.getKey()) == null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return linkedHashMap;
    }

    private final synchronized void w(List<RecentContactInfo> changedList, List<Long> sortList) {
        if (chatsListCacheMap == null) {
            chatsListCacheMap = new LinkedHashMap<>();
        }
        if (sortList.isEmpty()) {
            LinkedHashMap<Long, RecentContactInfo> linkedHashMap = chatsListCacheMap;
            Intrinsics.checkNotNull(linkedHashMap);
            linkedHashMap.clear();
            o();
            return;
        }
        LinkedHashMap<Long, RecentContactInfo> linkedHashMap2 = new LinkedHashMap<>();
        for (RecentContactInfo recentContactInfo : changedList) {
            if (sortList.contains(Long.valueOf(recentContactInfo.contactId))) {
                linkedHashMap2.put(Long.valueOf(recentContactInfo.contactId), recentContactInfo);
            }
        }
        q(sortList);
        LinkedHashMap<Long, RecentContactInfo> linkedHashMap3 = chatsListCacheMap;
        Intrinsics.checkNotNull(linkedHashMap3);
        for (Map.Entry<Long, RecentContactInfo> entry : linkedHashMap3.entrySet()) {
            if (linkedHashMap2.get(entry.getKey()) == null) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        chatsListCacheMap = v(linkedHashMap2, sortList);
        o();
    }

    public final void c(@Nullable a uiUpdateListener) {
        if (uiUpdateListener == null) {
            return;
        }
        if (!uiUpdateListeners.contains(uiUpdateListener)) {
            uiUpdateListeners.add(uiUpdateListener);
        }
        aa i3 = i();
        if (i3 != null) {
            i3.g0(3, mPlatformListenerWrapper);
        }
    }

    public final void d() {
        aa i3 = i();
        if (i3 != null) {
            aa.b.a(i3, new AnchorPointContactInfo(), true, 3, 0, null, 24, null);
        }
    }

    @Nullable
    public final synchronized List<RecentContactInfo> e() {
        List<RecentContactInfo> list;
        Collection<RecentContactInfo> values;
        LinkedHashMap<Long, RecentContactInfo> linkedHashMap = chatsListCacheMap;
        if (linkedHashMap != null && (values = linkedHashMap.values()) != null) {
            list = CollectionsKt___CollectionsKt.toList(values);
        } else {
            list = null;
        }
        return list;
    }

    public final boolean j(@NotNull IPublicAccountDetail detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (h(detail) == 0) {
            return true;
        }
        return false;
    }

    public final boolean k(@NotNull IPublicAccountDetail detail) {
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (h(detail) == 1) {
            return true;
        }
        return false;
    }

    public final void m(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        w g16 = g();
        if (g16 != null) {
            g16.setMsgRead(peer, callback);
        }
    }

    public final void n(@NotNull Contact peer, @Nullable IOperateCallback callback) {
        Intrinsics.checkNotNullParameter(peer, "peer");
        w g16 = g();
        if (g16 != null) {
            g16.setMarkUnreadFlag(peer, true);
        }
    }

    public final void r(@Nullable a uiUpdateListener) {
        if (uiUpdateListener == null) {
            return;
        }
        if (uiUpdateListeners.contains(uiUpdateListener)) {
            uiUpdateListeners.remove(uiUpdateListener);
        }
        aa i3 = i();
        if (i3 != null) {
            i3.m(3, mPlatformListenerWrapper);
        }
    }

    public final void s() {
        uiUpdateListeners.clear();
        chatsListCacheMap = null;
    }

    public final void t() {
        Contact contact = new Contact(30, "", "");
        w g16 = g();
        if (g16 != null) {
            g16.setMsgRead(contact, new IOperateCallback() { // from class: com.tencent.biz.pubaccount.serviceAccountFolder.a
                @Override // com.tencent.qqnt.kernel.nativeinterface.IOperateCallback
                public final void onResult(int i3, String str) {
                    ServiceAccountFolderNTManager.u(i3, str);
                }
            });
        }
    }
}
