package com.tencent.timi.game.gift.impl.timi;

import com.tencent.mobileqq.qqgift.api.IQQGiftManager;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0013B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u000e\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u0002R&\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u000f\u00a8\u0006\u0014"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/c;", "", "", "businessId", "Lnh2/c;", "c", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "", "d", "b", "", "", "Lcom/tencent/timi/game/gift/impl/timi/c$a;", "Ljava/util/Map;", "callbackMap", "<init>", "()V", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes26.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    @NotNull
    public static final c f377140a = new c();

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    @NotNull
    private static final Map<Integer, List<a>> callbackMap = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00052\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H&\u00a8\u0006\u0007"}, d2 = {"Lcom/tencent/timi/game/gift/impl/timi/c$a;", "", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftServiceData", "", "a", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public interface a {
        void a(@NotNull List<? extends com.tencent.mobileqq.qqgift.data.service.d> giftServiceData);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016\u00a8\u0006\f"}, d2 = {"com/tencent/timi/game/gift/impl/timi/c$b", "Lrh2/e;", "", "errCode", "", "errMsg", "", "onFailed", "", "Lcom/tencent/mobileqq/qqgift/data/service/d;", "giftList", "onReceive", "timi-game-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes26.dex */
    public static final class b implements rh2.e {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f377142d;

        b(int i3) {
            this.f377142d = i3;
        }

        @Override // qh2.d
        public void onFailed(int errCode, @Nullable String errMsg) {
            com.tencent.timi.game.utils.l.e("GiftResourceManager", "getGiftList#onFailed businessId: " + this.f377142d + "; errCode: " + errCode + "; errMsg: " + errMsg);
        }

        @Override // rh2.e
        public void onReceive(@Nullable List<com.tencent.mobileqq.qqgift.data.service.d> giftList) {
            boolean z16;
            List<com.tencent.mobileqq.qqgift.data.service.d> list = giftList;
            if (list != null && !list.isEmpty()) {
                z16 = false;
            } else {
                z16 = true;
            }
            if (!z16) {
                c.f377140a.d(this.f377142d, giftList);
            } else {
                com.tencent.timi.game.utils.l.e("GiftResourceManager", "getGiftList#onReceive empty");
            }
        }
    }

    c() {
    }

    private final nh2.c c(int businessId) {
        nh2.c sDKImpl = ((IQQGiftManager) QRoute.api(IQQGiftManager.class)).getSDKImpl(businessId);
        if (!sDKImpl.isInited() || sDKImpl.isDestroyed()) {
            com.tencent.timi.game.utils.l.e("GiftResourceManager", "giftSDK not inited or has destroyed");
            return null;
        }
        return sDKImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(int businessId, List<? extends com.tencent.mobileqq.qqgift.data.service.d> giftServiceData) {
        List<a> list = callbackMap.get(Integer.valueOf(businessId));
        if (list != null) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                ((a) it.next()).a(giftServiceData);
            }
        }
    }

    public final void b(int businessId) {
        oh2.b a16;
        com.tencent.mobileqq.qqgift.data.service.a aVar = new com.tencent.mobileqq.qqgift.data.service.a(1, String.valueOf(businessId), "", "");
        nh2.c c16 = c(businessId);
        if (c16 != null && (a16 = c16.a()) != null) {
            a16.P(aVar, new b(businessId));
        }
    }
}
