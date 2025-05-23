package com.tencent.timi.game.initer.impl;

import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.timi.game.utils.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.h;
import rh2.g;

/* compiled from: P */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0015B\t\b\u0002\u00a2\u0006\u0004\b\u001a\u0010\u001bJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tJ\u001e\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0019\u001a\u00020\u00168BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001c"}, d2 = {"Lcom/tencent/timi/game/initer/impl/b;", "", "", "businessId", "", "e", "panelType", "gameType", "anchorId", "", "needPanelRes", "", "g", "giftId", "Lcom/tencent/timi/game/initer/impl/b$a;", "callback", "i", "f", "b", "Lnh2/c;", "c", "a", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "d", "()Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "qqGiftManager", "<init>", "()V", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f377190a = new b();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lcom/tencent/timi/game/initer/impl/b$a;", "", "", "giftCount", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(long giftCount);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/initer/impl/b$c", "Lrh2/g;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/e;", "tabItems", "onReceive", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class c implements g {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ a f377193d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ int f377194e;

        c(a aVar, int i3) {
            this.f377193d = aVar;
            this.f377194e = i3;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            l.e("GiftSdkInitManager", "preloadPackageGiftRes#onFailed: " + errCode + "; " + errMsg);
            this.f377193d.a(0L);
        }

        @Override // rh2.g
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.e> tabItems) {
            Integer num;
            if (tabItems != null) {
                num = Integer.valueOf(tabItems.size());
            } else {
                num = null;
            }
            l.i("GiftSdkInitManager", "preloadPackageGiftRes#onReceive: " + num + ", giftId:" + this.f377194e);
            if (tabItems != null) {
                int i3 = this.f377194e;
                a aVar = this.f377193d;
                Iterator<T> it = tabItems.iterator();
                while (it.hasNext()) {
                    List<com.tencent.mobileqq.qqgift.data.service.d> list = ((com.tencent.mobileqq.qqgift.data.service.e) it.next()).f264898e;
                    Intrinsics.checkNotNullExpressionValue(list, "giftTabItem.gifts");
                    for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
                        if (dVar.f264875d0 && dVar.f264874d == i3) {
                            l.i("GiftSdkInitManager", "preloadGiftRes#getGiftList#giftNum: " + dVar.f264877e0);
                            aVar.a(dVar.f264877e0);
                            return;
                        }
                    }
                }
            }
            this.f377193d.a(0L);
        }
    }

    b() {
    }

    private final IQQGiftManager d() {
        QRouteApi api = QRoute.api(IQQGiftManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGiftManager::class.java)");
        return (IQQGiftManager) api;
    }

    public static /* synthetic */ void h(b bVar, int i3, int i16, String str, String str2, boolean z16, int i17, Object obj) {
        int i18;
        boolean z17;
        if ((i17 & 2) != 0) {
            i18 = 1;
        } else {
            i18 = i16;
        }
        if ((i17 & 4) != 0) {
            str = "";
        }
        String str3 = str;
        if ((i17 & 8) != 0) {
            str2 = "0";
        }
        String str4 = str2;
        if ((i17 & 16) != 0) {
            z17 = true;
        } else {
            z17 = z16;
        }
        bVar.g(i3, i18, str3, str4, z17);
    }

    public final void a(int businessId) {
        oh2.b a16;
        nh2.c c16 = c(businessId);
        if (c16 != null && (a16 = c16.a()) != null) {
            a16.z();
        }
    }

    public final void b(int businessId) {
        l.e("GiftSdkInitManager", "try destroy businessId: " + businessId);
        nh2.c sDKImpl = d().getSDKImpl(businessId);
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            l.e("GiftSdkInitManager", "destroy businessId: " + businessId);
            sDKImpl.destroy();
            sDKImpl.g().exitRoom();
        }
    }

    @Nullable
    public final nh2.c c(int businessId) {
        return d().getSDKImpl(businessId);
    }

    @NotNull
    public final String e(int businessId) {
        if (businessId != 10001) {
            if (businessId == 10013) {
                return "571ab62646abd99881be652d3e250a39";
            }
            if (businessId != 10004) {
                if (businessId != 10005) {
                    if (businessId != 10007) {
                        if (businessId == 10008) {
                            return "571ab62646abd99881be652d3e250a39";
                        }
                        return "3972178cd6bfbe11e7f3f54e7c3c623d";
                    }
                    return "m9iyc4gnzlkt9g7yq71v3v0oyi2xr3p3";
                }
                return "8d9a9cd4e6fa29def6af5c4f448d8153";
            }
            return "d16a682ef7c2321aef85f422fdc1fefc";
        }
        return "2ba343368f5483089089ae290adf298f";
    }

    public final void f(int businessId) {
        boolean contains;
        nh2.c sDKImpl = d().getSDKImpl(businessId);
        if (!sDKImpl.isInited()) {
            l.e("GiftSdkInitManager", "initGiftSdk businessId: " + businessId);
            sDKImpl.c(MobileQQ.sMobileQQ.waitAppRuntime(null), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(businessId).a(e(businessId)).b());
            sDKImpl.g().enterRoom();
            contains = ArraysKt___ArraysKt.contains(new Integer[]{10005, 10004, 10003, 10003}, Integer.valueOf(businessId));
            if (contains) {
                h(this, businessId, 0, null, null, false, 14, null);
            }
        }
    }

    public final void g(int businessId, int panelType, @NotNull String gameType, @NotNull String anchorId, boolean needPanelRes) {
        Intrinsics.checkNotNullParameter(gameType, "gameType");
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        nh2.c sDKImpl = d().getSDKImpl(businessId);
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            sDKImpl.a().P(new com.tencent.mobileqq.qqgift.data.service.a(panelType, String.valueOf(businessId), gameType, anchorId), new C9927b(sDKImpl, needPanelRes));
        } else {
            l.e("GiftSdkInitManager", "preloadGiftRes giftSdk error!");
        }
    }

    public final void i(int businessId, int giftId, @NotNull a callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        nh2.c sDKImpl = d().getSDKImpl(businessId);
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            sDKImpl.a().V(new c(callback, giftId));
        } else {
            l.e("GiftSdkInitManager", "preloadPackageGiftRes giftSdk error!");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/initer/impl/b$b", "Lrh2/e;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "onReceive", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* renamed from: com.tencent.timi.game.initer.impl.b$b, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static final class C9927b implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nh2.c f377191d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f377192e;

        C9927b(nh2.c cVar, boolean z16) {
            this.f377191d = cVar;
            this.f377192e = z16;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            l.e("GiftSdkInitManager", "preloadGiftRes#getGiftList#onFailed: " + errCode + "; " + errMsg);
        }

        @Override // rh2.e
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
            int collectionSizeOrDefault;
            if (giftList == null) {
                l.e("GiftSdkInitManager", "preloadGiftRes#getGiftList#onReceive: giftList == null");
            }
            if (giftList != null) {
                List<com.tencent.mobileqq.qqgift.data.service.d> list = giftList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
                    arrayList.add(new com.tencent.mobileqq.qqgift.data.service.g(dVar.C, dVar.f264874d, dVar.f264883i));
                }
                this.f377191d.b().S(arrayList, new a());
                if (this.f377192e) {
                    this.f377191d.b().i(arrayList, null);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/timi/game/initer/impl/b$b$a", "Lqh2/h;", "", "totalCount", "successCount", "", "a", "", "success", "id", "", "msg", "b", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.timi.game.initer.impl.b$b$a */
        /* loaded from: classes26.dex */
        public static final class a implements h {
            a() {
            }

            @Override // qh2.h
            public void a(int totalCount, int successCount) {
                l.e("GiftSdkInitManager", "downloadAnimationResources# totalCount: " + totalCount + " successCount: " + successCount);
            }

            @Override // qh2.h
            public void b(boolean success, int id5, @Nullable String msg2) {
            }
        }
    }
}
