package com.tencent.icgame.game.initer.impl;

import com.tencent.icgame.game.utils.g;
import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__IterablesKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.MobileQQ;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import qh2.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J6\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u00042\b\b\u0002\u0010\n\u001a\u00020\tJ\u000e\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u000f8BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/icgame/game/initer/impl/b;", "", "", "businessId", "", "c", "panelType", "gameType", "anchorId", "", "needPanelRes", "", "e", "d", "a", "Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "b", "()Lcom/tencent/mobileqq/qqgift/api/IQQGiftManager;", "qqGiftManager", "<init>", "()V", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes7.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final b f115068a = new b();

    b() {
    }

    private final IQQGiftManager b() {
        QRouteApi api = QRoute.api(IQQGiftManager.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IQQGiftManager::class.java)");
        return (IQQGiftManager) api;
    }

    public static /* synthetic */ void f(b bVar, int i3, int i16, String str, String str2, boolean z16, int i17, Object obj) {
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
        bVar.e(i3, i18, str3, str4, z17);
    }

    public final void a(int businessId) {
        g.d("ICGameGiftSdkInitManager", "try destroy businessId: " + businessId);
        nh2.c sDKImpl = b().getSDKImpl(businessId);
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            g.d("ICGameGiftSdkInitManager", "destroy businessId: " + businessId);
            sDKImpl.destroy();
            sDKImpl.g().exitRoom();
        }
    }

    @NotNull
    public final String c(int businessId) {
        if (businessId != 10004) {
            if (businessId != 10005) {
                if (businessId != 10007) {
                    if (businessId == 10008 || businessId == 10013 || businessId == 10015) {
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

    public final void d(int businessId) {
        boolean contains;
        nh2.c sDKImpl = b().getSDKImpl(businessId);
        if (!sDKImpl.isInited()) {
            g.d("ICGameGiftSdkInitManager", "initGiftSdk businessId: " + businessId);
            sDKImpl.c(MobileQQ.sMobileQQ.peekAppRuntime(), com.tencent.mobileqq.qqgift.sdk.config.a.a().d(businessId).a(c(businessId)).b());
            sDKImpl.g().enterRoom();
            contains = ArraysKt___ArraysKt.contains(new Integer[]{10005, 10004, 10003, 10003}, Integer.valueOf(businessId));
            if (contains) {
                f(this, businessId, 0, null, null, false, 14, null);
            }
        }
    }

    public final void e(int businessId, int panelType, @NotNull String gameType, @NotNull String anchorId, boolean needPanelRes) {
        Intrinsics.checkNotNullParameter(gameType, "gameType");
        Intrinsics.checkNotNullParameter(anchorId, "anchorId");
        nh2.c sDKImpl = b().getSDKImpl(businessId);
        if (sDKImpl.isInited() && !sDKImpl.isDestroyed()) {
            sDKImpl.a().P(new com.tencent.mobileqq.qqgift.data.service.a(panelType, String.valueOf(businessId), gameType, anchorId), new a(sDKImpl, needPanelRes));
        } else {
            g.d("ICGameGiftSdkInitManager", "preloadGiftRes giftSdk error!");
        }
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/icgame/game/initer/impl/b$a", "Lrh2/e;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "onReceive", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes7.dex */
    public static final class a implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ nh2.c f115069d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ boolean f115070e;

        a(nh2.c cVar, boolean z16) {
            this.f115069d = cVar;
            this.f115070e = z16;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            g.d("ICGameGiftSdkInitManager", "preloadGiftRes#getGiftList#onFailed: " + errCode + "; " + errMsg);
        }

        @Override // rh2.e
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
            int collectionSizeOrDefault;
            if (giftList == null) {
                g.d("ICGameGiftSdkInitManager", "preloadGiftRes#getGiftList#onReceive: giftList == null");
            }
            if (giftList != null) {
                List<com.tencent.mobileqq.qqgift.data.service.d> list = giftList;
                collectionSizeOrDefault = CollectionsKt__IterablesKt.collectionSizeOrDefault(list, 10);
                ArrayList arrayList = new ArrayList(collectionSizeOrDefault);
                for (com.tencent.mobileqq.qqgift.data.service.d dVar : list) {
                    arrayList.add(new com.tencent.mobileqq.qqgift.data.service.g(dVar.C, dVar.f264874d, dVar.f264883i));
                }
                this.f115069d.b().S(arrayList, new C5828a());
                if (this.f115070e) {
                    this.f115069d.b().i(arrayList, null);
                }
            }
        }

        /* compiled from: P */
        @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J\"\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0016\u00a8\u0006\r"}, d2 = {"com/tencent/icgame/game/initer/impl/b$a$a", "Lqh2/h;", "", "totalCount", "successCount", "", "a", "", "success", "id", "", "msg", "b", "ic-game-timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
        /* renamed from: com.tencent.icgame.game.initer.impl.b$a$a, reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public static final class C5828a implements h {
            C5828a() {
            }

            @Override // qh2.h
            public void a(int totalCount, int successCount) {
                g.d("ICGameGiftSdkInitManager", "downloadAnimationResources# totalCount: " + totalCount + " successCount: " + successCount);
            }

            @Override // qh2.h
            public void b(boolean success, int id5, @Nullable String msg2) {
            }
        }
    }
}
