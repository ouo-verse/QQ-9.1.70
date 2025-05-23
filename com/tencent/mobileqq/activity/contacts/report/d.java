package com.tencent.mobileqq.activity.contacts.report;

import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendExtensionService;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqnt.contacts.cache.FriendListInfoCache;
import com.tencent.qqnt.ntrelation.api.IFriendsTABService;
import com.tencent.qqnt.ntrelation.constant.RelationListReqType;
import com.tencent.qqnt.trace.NTTraceManager;
import com.tencent.qqnt.trace.r;
import com.tencent.richframework.tracer.RFWTraceStreamResult;
import cooperation.qzone.QzoneIPCModule;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u001c\u0010\u001dJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0014\u0010\b\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\n\u001a\u00020\u0004H\u0002J \u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\fH\u0002J\u0012\u0010\u0010\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006J\u0016\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0013J\u0016\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0013R\u0016\u0010\u001b\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e\u00a2\u0006\u0006\n\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001e"}, d2 = {"Lcom/tencent/mobileqq/activity/contacts/report/d;", "", "", "nodeName", "", DomainData.DOMAIN_NAME, "Lmqq/app/AppRuntime;", "app", "k", "f", "d", "cacheType", "Ljava/util/concurrent/CopyOnWriteArrayList;", "uidCacheList", "", "e", "l", "Lcom/tencent/qqnt/ntrelation/constant/RelationListReqType;", "pageType", "", QzoneIPCModule.RESULT_CODE, "i", "success", "g", "", "b", "Z", "isEnd", "<init>", "()V", "AQQLiteModule_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes10.dex */
public final class d {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final d f181714a;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static volatile boolean isEnd;

    /* compiled from: P */
    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* loaded from: classes10.dex */
    public /* synthetic */ class a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f181716a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50422);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 1)) {
                redirector.redirect((short) 1);
                return;
            }
            int[] iArr = new int[RelationListReqType.values().length];
            try {
                iArr[RelationListReqType.NORMAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RelationListReqType.LETTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f181716a = iArr;
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(50423);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 5)) {
            redirector.redirect((short) 5);
        } else {
            f181714a = new d();
        }
    }

    d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private final void d() {
        Iterator<Map.Entry<String, FriendListInfoCache.c>> it = FriendListInfoCache.INSTANCE.a().s().entrySet().iterator();
        while (it.hasNext()) {
            FriendListInfoCache.c value = it.next().getValue();
            RFWTraceStreamResult rFWTraceStreamResult = new RFWTraceStreamResult();
            HashMap hashMap = new HashMap();
            hashMap.put("response_item_count", Integer.valueOf(value.d()));
            hashMap.put("total_item_count", Integer.valueOf(value.e()));
            String c16 = value.c();
            hashMap.put("source", c16);
            hashMap.put("item_capacity", Integer.valueOf(value.b()));
            int a16 = value.a();
            hashMap.put("item_count", Integer.valueOf(a16));
            hashMap.put("lru_cache_size", Long.valueOf(f181714a.e(c16, FriendListInfoCache.INSTANCE.a().r(value.c())) * a16));
            rFWTraceStreamResult.setExtraParam(hashMap);
            rFWTraceStreamResult.setStreamName(c16);
            NTTraceManager.f362318a.j(rFWTraceStreamResult, false);
        }
        FriendListInfoCache.INSTANCE.a().s().clear();
    }

    private final long e(String cacheType, CopyOnWriteArrayList<String> uidCacheList) {
        Iterator<String> it;
        if (uidCacheList != null) {
            it = uidCacheList.iterator();
        } else {
            it = null;
        }
        long j3 = 0;
        while (true) {
            boolean z16 = false;
            if (it != null && it.hasNext()) {
                z16 = true;
            }
            if (z16) {
                String uid = it.next();
                FriendListInfoCache a16 = FriendListInfoCache.INSTANCE.a();
                Intrinsics.checkNotNullExpressionValue(uid, "uid");
                if (a16.k(cacheType, uid, "ContactTracer_friendListCacheReport") != null) {
                    j3 += com.tencent.cache.api.util.c.e(com.tencent.cache.api.util.c.f98640a, r6, true, false, false, 12, null);
                }
            } else {
                return j3;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00f3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void f(AppRuntime app) {
        IFriendDataService iFriendDataService;
        int i3;
        IFriendExtensionService iFriendExtensionService;
        List<Friends> list;
        int i16;
        int i17;
        int i18;
        int i19;
        List<ExtensionInfo> allExtensionInfo;
        HashMap hashMap = new HashMap();
        RFWTraceStreamResult rFWTraceStreamResult = new RFWTraceStreamResult();
        hashMap.put("source", com.tencent.qqnt.contacts.cache.a.f355804a.e());
        List<ExtensionInfo> list2 = null;
        if (app != null) {
            iFriendDataService = (IFriendDataService) app.getRuntimeService(IFriendDataService.class, "");
        } else {
            iFriendDataService = null;
        }
        int i26 = 0;
        if (iFriendDataService != null) {
            i3 = iFriendDataService.getFriendCount();
        } else {
            i3 = 0;
        }
        if (app != null) {
            iFriendExtensionService = (IFriendExtensionService) app.getRuntimeService(IFriendExtensionService.class, "");
        } else {
            iFriendExtensionService = null;
        }
        if (iFriendDataService != null) {
            list = iFriendDataService.getAllFriends();
        } else {
            list = null;
        }
        if (list != null) {
            i16 = list.size();
        } else {
            i16 = 0;
        }
        if (list != null) {
            if (i16 >= 3) {
                Friends firstFriend = list.get(0);
                Friends lastFriend = list.get(i16 - 1);
                Friends middleFriend = list.get(i16 / 2);
                com.tencent.cache.api.util.c cVar = com.tencent.cache.api.util.c.f98640a;
                Intrinsics.checkNotNullExpressionValue(firstFriend, "firstFriend");
                int e16 = com.tencent.cache.api.util.c.e(cVar, firstFriend, true, false, false, 12, null);
                Intrinsics.checkNotNullExpressionValue(lastFriend, "lastFriend");
                int e17 = e16 + com.tencent.cache.api.util.c.e(cVar, lastFriend, true, false, false, 12, null);
                Intrinsics.checkNotNullExpressionValue(middleFriend, "middleFriend");
                i17 = (e17 + com.tencent.cache.api.util.c.e(cVar, middleFriend, true, false, false, 12, null)) / 3;
            } else {
                int i27 = 0;
                for (int i28 = 0; i28 < i16; i28++) {
                    com.tencent.cache.api.util.c cVar2 = com.tencent.cache.api.util.c.f98640a;
                    Friends friends = list.get(i28);
                    Intrinsics.checkNotNullExpressionValue(friends, "friends[i]");
                    i27 += com.tencent.cache.api.util.c.e(cVar2, friends, true, false, false, 12, null);
                }
                if (i16 != 0) {
                    i17 = i27 / i16;
                }
            }
            if (iFriendExtensionService == null && (allExtensionInfo = iFriendExtensionService.getAllExtensionInfo()) != null) {
                i18 = allExtensionInfo.size();
            } else {
                i18 = 0;
            }
            hashMap.put("response_item_count", Integer.valueOf(i3));
            hashMap.put("qq_extension_count", Integer.valueOf(i18));
            if (iFriendExtensionService != null) {
                list2 = iFriendExtensionService.getAllExtensionInfo();
            }
            if (list2 == null) {
                i19 = list2.size();
            } else {
                i19 = 0;
            }
            if (list2 != null) {
                if (i19 >= 3) {
                    ExtensionInfo firstExtensionInfo = list2.get(0);
                    ExtensionInfo lastExtensionInfo = list2.get(i19 - 1);
                    ExtensionInfo middleExtensionInfo = list2.get(i19 / 2);
                    com.tencent.cache.api.util.c cVar3 = com.tencent.cache.api.util.c.f98640a;
                    Intrinsics.checkNotNullExpressionValue(firstExtensionInfo, "firstExtensionInfo");
                    int e18 = com.tencent.cache.api.util.c.e(cVar3, firstExtensionInfo, true, false, false, 12, null);
                    Intrinsics.checkNotNullExpressionValue(lastExtensionInfo, "lastExtensionInfo");
                    int e19 = e18 + com.tencent.cache.api.util.c.e(cVar3, lastExtensionInfo, true, false, false, 12, null);
                    Intrinsics.checkNotNullExpressionValue(middleExtensionInfo, "middleExtensionInfo");
                    i26 = (e19 + com.tencent.cache.api.util.c.e(cVar3, middleExtensionInfo, true, false, false, 12, null)) / 3;
                } else {
                    int i29 = 0;
                    for (int i36 = 0; i36 < i19; i36++) {
                        com.tencent.cache.api.util.c cVar4 = com.tencent.cache.api.util.c.f98640a;
                        ExtensionInfo extensionInfo = list2.get(i36);
                        Intrinsics.checkNotNullExpressionValue(extensionInfo, "extensionInfoList[i]");
                        i29 += com.tencent.cache.api.util.c.e(cVar4, extensionInfo, true, false, false, 12, null);
                    }
                    if (i19 != 0) {
                        i26 = i29 / i19;
                    }
                }
            }
            hashMap.put("qq_friend_cache_size", Integer.valueOf((i17 * i3) + (i26 * i19)));
            rFWTraceStreamResult.setExtraParam(hashMap);
            rFWTraceStreamResult.setStreamName(com.tencent.qqnt.contacts.cache.a.f355804a.e());
            NTTraceManager.f362318a.onStreamFinish(rFWTraceStreamResult);
        }
        i17 = 0;
        if (iFriendExtensionService == null) {
        }
        i18 = 0;
        hashMap.put("response_item_count", Integer.valueOf(i3));
        hashMap.put("qq_extension_count", Integer.valueOf(i18));
        if (iFriendExtensionService != null) {
        }
        if (list2 == null) {
        }
        if (list2 != null) {
        }
        hashMap.put("qq_friend_cache_size", Integer.valueOf((i17 * i3) + (i26 * i19)));
        rFWTraceStreamResult.setExtraParam(hashMap);
        rFWTraceStreamResult.setStreamName(com.tencent.qqnt.contacts.cache.a.f355804a.e());
        NTTraceManager.f362318a.onStreamFinish(rFWTraceStreamResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void h(RelationListReqType pageType, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(pageType, "$pageType");
        int i16 = a.f181716a[pageType.ordinal()];
        boolean z16 = true;
        if (i16 != 1) {
            if (i16 == 2) {
                str = "ALPHABET_LIST_ANDROID";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            str = "FRIEND_LIST_ANDROID";
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        RFWTraceStreamResult rFWTraceStreamResult = new RFWTraceStreamResult();
        HashMap hashMap = new HashMap();
        hashMap.put("response_data_time_result", Integer.valueOf(i3));
        rFWTraceStreamResult.setStreamName(str);
        rFWTraceStreamResult.setExtraParam(hashMap);
        NTTraceManager.f362318a.j(rFWTraceStreamResult, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void j(RelationListReqType pageType, int i3) {
        String str;
        Intrinsics.checkNotNullParameter(pageType, "$pageType");
        int i16 = a.f181716a[pageType.ordinal()];
        boolean z16 = true;
        if (i16 != 1) {
            if (i16 == 2) {
                str = "ALPHABET_LIST_ANDROID";
            } else {
                throw new NoWhenBranchMatchedException();
            }
        } else {
            str = "FRIEND_LIST_ANDROID";
        }
        if (str.length() != 0) {
            z16 = false;
        }
        if (z16) {
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("result_code", Integer.valueOf(i3));
        RFWTraceStreamResult rFWTraceStreamResult = new RFWTraceStreamResult();
        rFWTraceStreamResult.setStreamName(str);
        rFWTraceStreamResult.setExtraParam(hashMap);
        NTTraceManager.f362318a.j(rFWTraceStreamResult, false);
    }

    private final synchronized void k(AppRuntime app) {
        d();
        f(app);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void m(AppRuntime appRuntime) {
        f181714a.k(appRuntime);
    }

    @JvmStatic
    public static final void n(@NotNull String nodeName) {
        Intrinsics.checkNotNullParameter(nodeName, "nodeName");
        synchronized (f181714a) {
            if (Intrinsics.areEqual("ITEM_CLICK", nodeName)) {
                isEnd = false;
            } else {
                if (isEnd) {
                    return;
                }
                if (Intrinsics.areEqual("refresh_ui_time", nodeName)) {
                    isEnd = true;
                }
            }
            QLog.i("ContactTracer", 1, nodeName);
            r.f362387a.findStream("CONTACT_PAGE").tagNode(nodeName);
            Unit unit = Unit.INSTANCE;
        }
    }

    public final void g(@NotNull final RelationListReqType pageType, final int success) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) pageType, success);
        } else {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.report.a
                @Override // java.lang.Runnable
                public final void run() {
                    d.h(RelationListReqType.this, success);
                }
            }, 16, null, true);
        }
    }

    public final void i(@NotNull final RelationListReqType pageType, final int resultCode) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) pageType, resultCode);
        } else {
            Intrinsics.checkNotNullParameter(pageType, "pageType");
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.report.c
                @Override // java.lang.Runnable
                public final void run() {
                    d.j(RelationListReqType.this, resultCode);
                }
            }, 16, null, true);
        }
    }

    public final void l(@Nullable final AppRuntime app) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) app);
        } else {
            if (!((IFriendsTABService) QRoute.api(IFriendsTABService.class)).isNtDataService()) {
                return;
            }
            ThreadManagerV2.excute(new Runnable() { // from class: com.tencent.mobileqq.activity.contacts.report.b
                @Override // java.lang.Runnable
                public final void run() {
                    d.m(AppRuntime.this);
                }
            }, 16, null, true);
        }
    }
}
