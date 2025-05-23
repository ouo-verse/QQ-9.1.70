package com.tencent.mobileqq.matchfriend.reborn.content.msg.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerDataApi;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.liteaction.q;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.aa;
import com.tencent.qqnt.kernel.nativeinterface.AnchorPointContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactInfo;
import com.tencent.qqnt.kernel.nativeinterface.RecentContactListChangedInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b%\u0010&J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0004H\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u000bJ\u000e\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000eJ\u0006\u0010\u0011\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0012\u001a\u00020\u000bJ\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00130\u0015R \u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00130\u00178\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0016\u0010\u001b\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\r\u0010\u001aR$\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0010\u0010\u001dR$\u0010$\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f8\u0006@BX\u0086\u000e\u00a2\u0006\f\n\u0004\b\n\u0010!\u001a\u0004\b\"\u0010#\u00a8\u0006'"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/reborn/content/msg/utils/QQStrangerRecentContactHelper;", "", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactListChangedInfo;", "changeInfo", "", "l", "", "b", "k", "i", "e", "", "peerUid", "c", "", "notifyUI", "d", h.F, "tinyId", "Lcom/tencent/qqnt/kernel/nativeinterface/RecentContactInfo;", "g", "", "f", "", "Ljava/util/Map;", "recentContactMap", "J", "currentTotalMsgUnreadNum", "Lkotlin/Function1;", "Lkotlin/jvm/functions/Function1;", "recentContactListener", "Ljava/util/concurrent/atomic/AtomicBoolean;", "<set-?>", "Ljava/util/concurrent/atomic/AtomicBoolean;", "j", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "isRecentContactLoaded", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class QQStrangerRecentContactHelper {

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    private static long currentTotalMsgUnreadNum;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    private static Function1<? super RecentContactListChangedInfo, Unit> recentContactListener;

    /* renamed from: a, reason: collision with root package name */
    public static final QQStrangerRecentContactHelper f244865a = new QQStrangerRecentContactHelper();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, RecentContactInfo> recentContactMap = new LinkedHashMap();

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    private static AtomicBoolean isRecentContactLoaded = new AtomicBoolean(false);

    QQStrangerRecentContactHelper() {
    }

    private final long b() {
        Iterator<Map.Entry<String, RecentContactInfo>> it = recentContactMap.entrySet().iterator();
        long j3 = 0;
        while (it.hasNext()) {
            j3 += it.next().getValue().unreadCnt;
        }
        return j3;
    }

    private final void k() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4).notifyUI(14, true, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l(RecentContactListChangedInfo changeInfo) {
        ArrayList<RecentContactInfo> arrayList = changeInfo.changedList;
        Intrinsics.checkNotNullExpressionValue(arrayList, "changeInfo.changedList");
        ArrayList<RecentContactInfo> arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (changeInfo.sortedContactList.contains(Long.valueOf(((RecentContactInfo) obj).contactId))) {
                arrayList2.add(obj);
            }
        }
        for (RecentContactInfo it : arrayList2) {
            Map<String, RecentContactInfo> map = recentContactMap;
            String str = it.peerUid;
            Intrinsics.checkNotNullExpressionValue(str, "it.peerUid");
            Intrinsics.checkNotNullExpressionValue(it, "it");
            map.put(str, it);
        }
        long j3 = currentTotalMsgUnreadNum;
        ((IQQStrangerDataApi) QRoute.api(IQQStrangerDataApi.class)).updateLiteActionLatestUnread();
        currentTotalMsgUnreadNum = b();
        isRecentContactLoaded.set(true);
        if (j3 != currentTotalMsgUnreadNum) {
            k();
        }
    }

    public final void c(String peerUid) {
        Intrinsics.checkNotNullParameter(peerUid, "peerUid");
        Map<String, RecentContactInfo> map = recentContactMap;
        if (map.containsKey(peerUid)) {
            map.remove(peerUid);
        }
    }

    public final void d(boolean notifyUI) {
        recentContactMap.clear();
        currentTotalMsgUnreadNum = 0L;
        isRecentContactLoaded.set(false);
        if (notifyUI) {
            k();
        }
    }

    public final void e() {
        IKernelService iKernelService;
        aa recentContactService;
        Function1<? super RecentContactListChangedInfo, Unit> function1 = recentContactListener;
        if (function1 != null) {
            AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
            if (peekAppRuntime != null && (iKernelService = (IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "all")) != null && (recentContactService = iKernelService.getRecentContactService()) != null) {
                recentContactService.m(8, function1);
            }
            recentContactListener = null;
        }
        d(false);
    }

    public final List<RecentContactInfo> f() {
        Map<String, RecentContactInfo> map = recentContactMap;
        ArrayList arrayList = new ArrayList(map.size());
        Iterator<Map.Entry<String, RecentContactInfo>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().getValue());
        }
        return arrayList;
    }

    public final RecentContactInfo g(String tinyId) {
        Intrinsics.checkNotNullParameter(tinyId, "tinyId");
        return recentContactMap.get(tinyId);
    }

    public final long h() {
        return currentTotalMsgUnreadNum + q.f244623a.d();
    }

    public final void i() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.e("QQStrangerUnreadHelper", 1, "initRecentContactListener is error! app is null!");
            return;
        }
        aa recentContactService = ((IKernelService) peekAppRuntime.getRuntimeService(IKernelService.class, "")).getRecentContactService();
        if (recentContactService != null && recentContactListener == null) {
            QQStrangerRecentContactHelper$initRecentContactListener$1 qQStrangerRecentContactHelper$initRecentContactListener$1 = new Function1<RecentContactListChangedInfo, Unit>() { // from class: com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper$initRecentContactListener$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(RecentContactListChangedInfo recentContactListChangedInfo) {
                    invoke2(recentContactListChangedInfo);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(RecentContactListChangedInfo it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    QQStrangerRecentContactHelper.f244865a.l(it);
                }
            };
            recentContactListener = qQStrangerRecentContactHelper$initRecentContactListener$1;
            Intrinsics.checkNotNull(qQStrangerRecentContactHelper$initRecentContactListener$1);
            recentContactService.g0(8, qQStrangerRecentContactHelper$initRecentContactListener$1);
            aa.b.a(recentContactService, new AnchorPointContactInfo(), true, 8, 0, null, 24, null);
        }
    }

    public final AtomicBoolean j() {
        return isRecentContactLoaded;
    }
}
