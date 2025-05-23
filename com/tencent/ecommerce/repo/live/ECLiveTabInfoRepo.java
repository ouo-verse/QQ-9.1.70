package com.tencent.ecommerce.repo.live;

import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.ecommerce.base.network.service.IECNetworkCallback;
import com.tencent.ecommerce.biz.live.LiveScene;
import com.tencent.ecommerce.biz.live.LiveTabId;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;
import com.tencent.mobileqq.transfile.dns.DomainData;
import di0.v;
import di0.w;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: P */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b)\u0010*J \u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J>\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0002J0\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00102\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J6\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0002J(\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0002H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002J(\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001a2\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\b0\u001cJZ\u0010!\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00022\u0018\u0010\u001d\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u0010\u0012\u0004\u0012\u00020\b0\u001c2\u0018\u0010 \u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\b0\u001fJ\u001e\u0010\"\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010#\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0006\u0010$\u001a\u00020\bR&\u0010(\u001a\u0014\u0012\u0004\u0012\u00020\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100%8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b&\u0010'\u00a8\u0006+"}, d2 = {"Lcom/tencent/ecommerce/repo/live/ECLiveTabInfoRepo;", "", "", "isMaster", "", WadlProxyConsts.CHANNEL, "", "roomId", "", "d", "isCouponScene", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/v;", "Ldi0/w;", "callback", DomainData.DOMAIN_NAME, "", "Lcom/tencent/ecommerce/repo/live/TabInfo;", QCircleScheme.AttrQQPublish.INPUT_TAB_MAGIC_STUDIO, "tabInfos", "b", "", "e", "g", "f", tl.h.F, "Lcom/tencent/ecommerce/biz/live/LiveTabId;", "tabId", "Lkotlin/Function1;", "success", "k", "Lkotlin/Function2;", "fail", "l", "j", "i", "c", "", "a", "Ljava/util/Map;", "cache", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes31.dex */
public final class ECLiveTabInfoRepo {

    /* renamed from: b, reason: collision with root package name */
    public static final ECLiveTabInfoRepo f105070b = new ECLiveTabInfoRepo();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Map<String, List<TabInfo>> cache = new LinkedHashMap();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0003H\u0016J\u0018\u0010\n\u001a\u00020\u00062\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000b"}, d2 = {"com/tencent/ecommerce/repo/live/ECLiveTabInfoRepo$a", "Lcom/tencent/ecommerce/base/network/service/IECNetworkCallback;", "Ldi0/v;", "Ldi0/w;", "reqModel", "respModel", "", "b", "Lcom/tencent/ecommerce/base/network/api/e;", "errorResponse", "a", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
    /* loaded from: classes31.dex */
    public static final class a implements IECNetworkCallback<v, w> {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f105071a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f105072b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ long f105073c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ boolean f105074d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ Function1 f105075e;

        /* renamed from: f, reason: collision with root package name */
        final /* synthetic */ Function2 f105076f;

        a(boolean z16, int i3, long j3, boolean z17, Function1 function1, Function2 function2) {
            this.f105071a = z16;
            this.f105072b = i3;
            this.f105073c = j3;
            this.f105074d = z17;
            this.f105075e = function1;
            this.f105076f = function2;
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(v reqModel, ECRemoteResponse errorResponse) {
            cg0.a.b("ECLiveTabInfoRepo", "request from net fail, code=" + errorResponse.getCode() + ", msg=" + errorResponse.getMsg());
            this.f105076f.invoke(Integer.valueOf(errorResponse.getCode()), errorResponse.getMsg());
        }

        @Override // com.tencent.ecommerce.base.network.service.IECNetworkCallback
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(v reqModel, w respModel) {
            if (!respModel.a().isEmpty()) {
                cg0.a.b("ECLiveTabInfoRepo", "request from net onSuccess, tabList=" + respModel.a());
                ECLiveTabInfoRepo.f105070b.b(this.f105071a, this.f105072b, this.f105073c, this.f105074d, respModel.a());
                this.f105075e.invoke(respModel.a());
                return;
            }
            cg0.a.b("ECLiveTabInfoRepo", "request from net fail, backend error");
            this.f105076f.invoke(-1, "\u540e\u53f0\u6ca1\u6709\u8fd4\u56de\u6570\u636e");
        }
    }

    ECLiveTabInfoRepo() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void b(boolean isMaster, int channel, long roomId, boolean isCouponScene, List<TabInfo> tabInfos) {
        Object first;
        Map<String, List<TabInfo>> map = cache;
        if (map.size() > 20) {
            first = CollectionsKt___CollectionsKt.first(map.keySet());
            map.remove(first);
        }
        String e16 = e(isMaster, channel, roomId, isCouponScene);
        map.put(e16, tabInfos);
        cg0.a.b("ECLiveTabInfoRepo", "addCache, key=" + e16 + ", tabInfo=" + tabInfos);
    }

    private final String e(boolean isMaster, int channel, long roomId, boolean isCouponScene) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getAccountManager().getCurrentAccount());
        sb5.append('-');
        sb5.append(isMaster);
        sb5.append('-');
        sb5.append(channel);
        sb5.append('-');
        sb5.append(roomId);
        sb5.append('-');
        sb5.append(isCouponScene);
        return sb5.toString();
    }

    private final TabInfo f() {
        return new TabInfo(LiveTabId.LIVE_TAB_GOK, "\u738b\u8005\u5546\u54c1", 0, false, false, true, 0, 64, null);
    }

    private final TabInfo g() {
        return new TabInfo(LiveTabId.LIVE_TAB_PRODUCT, "\u76f4\u64ad\u5546\u54c1", 0, true, false, false, 0, 64, null);
    }

    private final TabInfo h() {
        return new TabInfo(LiveTabId.LIVE_TAB_QSHOP, "QQ\u5c0f\u5e97", 0, true, false, false, 0, 64, null);
    }

    private final List<TabInfo> m(boolean isMaster, int channel, long roomId, boolean isCouponScene) {
        String e16 = e(isMaster, channel, roomId, isCouponScene);
        List<TabInfo> list = cache.get(e16);
        if (list == null) {
            return null;
        }
        cg0.a.b("ECLiveTabInfoRepo", "requestFromCache, key=" + e16 + ", tabInfo=" + list);
        return list;
    }

    private final void n(boolean isMaster, int channel, long roomId, boolean isCouponScene, IECNetworkCallback<v, w> callback) {
        LiveScene liveScene;
        cg0.a.b("ECLiveTabInfoRepo", "requestFromNet start, isMaster:" + isMaster + ", liveRoomId:{" + roomId + "}, channel:{" + channel + "}, isCouponScene:" + isCouponScene);
        v.Companion companion = v.INSTANCE;
        String b16 = companion.b(isMaster);
        String a16 = companion.a(isMaster);
        if (isCouponScene) {
            liveScene = LiveScene.SCENE_COUPON;
        } else {
            liveScene = LiveScene.SCENE_DEFAULT;
        }
        com.tencent.ecommerce.base.network.service.a.b(b16, a16, new v(channel, roomId, liveScene), new w(), callback);
    }

    public final void c() {
        cache.clear();
    }

    public final void j(boolean isMaster, int channel, long roomId) {
        d(isMaster, channel, roomId);
        i(isMaster, channel, roomId);
    }

    public final void k(LiveTabId tabId, Function1<? super List<TabInfo>, Unit> success) {
        TabInfo g16;
        List mutableListOf;
        int i3 = f.f105132a[tabId.ordinal()];
        if (i3 == 1) {
            g16 = g();
        } else if (i3 == 2) {
            g16 = h();
        } else if (i3 != 3) {
            g16 = g();
        } else {
            g16 = f();
        }
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(g16);
        success.invoke(mutableListOf);
    }

    public final void l(boolean isMaster, int channel, long roomId, boolean isCouponScene, Function1<? super List<TabInfo>, Unit> success, Function2<? super Integer, ? super String, Unit> fail) {
        List<TabInfo> m3 = m(isMaster, channel, roomId, isCouponScene);
        if (m3 != null) {
            cg0.a.b("ECLiveTabInfoRepo", "request from cache success, tabList=" + m3);
            success.invoke(m3);
            return;
        }
        n(isMaster, channel, roomId, isCouponScene, new a(isMaster, channel, roomId, isCouponScene, success, fail));
    }

    public final void i(final boolean isMaster, final int channel, final long roomId) {
        l(isMaster, channel, roomId, false, new Function1<List<TabInfo>, Unit>() { // from class: com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo$preload$1
            /* JADX INFO: Access modifiers changed from: package-private */
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<TabInfo> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<TabInfo> list) {
                cg0.a.b("ECLiveTabInfoRepo", "preload success, cache=" + list);
                ECLiveTabInfoRepo.f105070b.b(isMaster, channel, roomId, false, list);
            }
        }, new Function2<Integer, String, Unit>() { // from class: com.tencent.ecommerce.repo.live.ECLiveTabInfoRepo$preload$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Integer num, String str) {
                invoke(num.intValue(), str);
                return Unit.INSTANCE;
            }

            public final void invoke(int i3, String str) {
                cg0.a.b("ECLiveTabInfoRepo", "preload fail, code=" + i3 + ", msg=" + str);
            }
        });
    }

    private final void d(boolean isMaster, int channel, long roomId) {
        String e16 = e(isMaster, channel, roomId, false);
        cg0.a.b("ECLiveTabInfoRepo", "clear cache key=" + e16);
        cache.remove(e16);
    }
}
