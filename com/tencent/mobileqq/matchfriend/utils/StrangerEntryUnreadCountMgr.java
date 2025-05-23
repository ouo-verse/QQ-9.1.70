package com.tencent.mobileqq.matchfriend.utils;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.matchfriend.api.IMatchFriendChatApi;
import com.tencent.mobileqq.matchfriend.reborn.api.IQQStrangerRuntimeService;
import com.tencent.mobileqq.matchfriend.reborn.content.msg.utils.QQStrangerRecentContactHelper;
import com.tencent.mobileqq.mqq.api.IAccountRuntime;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0002J\b\u0010\u0006\u001a\u00020\u0004H\u0002J\u0010\u0010\b\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0002J\u0006\u0010\f\u001a\u00020\u0004J\u0006\u0010\r\u001a\u00020\u0002R\u001b\u0010\u0012\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000f\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/matchfriend/utils/StrangerEntryUnreadCountMgr;", "", "", "g", "", "d", "c", "count", h.F, "", "key", "a", "e", "f", "Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "b", "Lkotlin/Lazy;", "()Lcom/tencent/mobileqq/qmmkv/MMKVOptionEntity;", "cache", "<init>", "()V", "matchfriend_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes33.dex */
public final class StrangerEntryUnreadCountMgr {

    /* renamed from: a, reason: collision with root package name */
    public static final StrangerEntryUnreadCountMgr f245590a = new StrangerEntryUnreadCountMgr();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    private static final Lazy cache;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<MMKVOptionEntity>() { // from class: com.tencent.mobileqq.matchfriend.utils.StrangerEntryUnreadCountMgr$cache$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final MMKVOptionEntity invoke() {
                return QMMKV.from(MobileQQ.sMobileQQ, "common_mmkv_configurations");
            }
        });
        cache = lazy;
    }

    StrangerEntryUnreadCountMgr() {
    }

    private final String a(String key) {
        return ((IAccountRuntime) QRoute.api(IAccountRuntime.class)).getAccount() + "_" + key;
    }

    private final MMKVOptionEntity b() {
        return (MMKVOptionEntity) cache.getValue();
    }

    private final int c() {
        return b().decodeInt(a("match_friend_entry_last_read_count"), 0);
    }

    private final int d() {
        return ((IMatchFriendChatApi) QRoute.api(IMatchFriendChatApi.class)).getUnreadNum();
    }

    private final void g() {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        appInterface.getBusinessHandler(com.tencent.relation.common.servlet.a.f364759y4).notifyUI(14, true, null);
    }

    private final void h(int count) {
        b().encodeInt(a("match_friend_entry_last_read_count"), count);
    }

    public final synchronized int e() {
        IQQStrangerRuntimeService iQQStrangerRuntimeService;
        if (!QQStrangerRecentContactHelper.f244865a.j().get()) {
            return 0;
        }
        int d16 = d();
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean hasLogin = (peekAppRuntime == null || (iQQStrangerRuntimeService = (IQQStrangerRuntimeService) peekAppRuntime.getRuntimeService(IQQStrangerRuntimeService.class, "")) == null) ? false : iQQStrangerRuntimeService.hasLogin();
        if (hasLogin) {
            QLog.i("StrangerEntryUnreadCountMgr", 1, "getVisibleCount() ignore realCount=" + d16 + ", hasLogin=" + hasLogin);
            h(d16);
            return 0;
        }
        int c16 = c();
        QLog.i("StrangerEntryUnreadCountMgr", 1, "getVisibleCount() realCount=" + d16 + ", lastReadCount=" + c16);
        if (d16 == c16) {
            return 0;
        }
        h(0);
        return d16;
    }

    public final synchronized void f() {
        int d16 = d();
        QLog.i("StrangerEntryUnreadCountMgr", 1, "markEntryRead() realCount=" + d16);
        h(d16);
        g();
    }
}
