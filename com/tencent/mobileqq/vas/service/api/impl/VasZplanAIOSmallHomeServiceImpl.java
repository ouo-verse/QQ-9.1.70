package com.tencent.mobileqq.vas.service.api.impl;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControl;
import com.tencent.mobileqq.vas.aio.VasZplanAIOConfigControlV2;
import com.tencent.mobileqq.vas.aio.VasZplanAIOData;
import com.tencent.mobileqq.vas.aio.VasZplanAdvIcon;
import com.tencent.mobileqq.vas.aio.VasZplanAvatarIcon;
import com.tencent.mobileqq.vas.aio.VasZplanAvatarInfo;
import com.tencent.mobileqq.vas.aio.VasZplanBubble;
import com.tencent.mobileqq.vas.aio.VasZplanCycleIcon;
import com.tencent.mobileqq.vas.aio.VasZplanInfo;
import com.tencent.mobileqq.vas.data.h;
import com.tencent.mobileqq.vas.data.i;
import com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService;
import com.tencent.mobileqq.vas.sso.api.IZplanVasProxyServlet;
import com.tencent.mobileqq.z1.sso.api.IZ1ProxyServlet;
import com.tencent.qphone.base.util.QLog;
import e33.RspErrorData;
import e33.b;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import lu4.a;
import lu4.d;
import lu4.e;
import lu4.f;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import sb3.Z1RspErrorData;
import sb3.b;
import zu4.p;
import zu4.q;

/* compiled from: P */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00142\u00020\u0001:\u0001\u0015B\u0007\u00a2\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J$\u0010\u000f\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bH\u0016J&\u0010\u0011\u001a\u00020\r2\u0006\u0010\n\u001a\u00020\u00022\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0012\u0004\u0012\u00020\r0\u000bH\u0016\u00a8\u0006\u0016"}, d2 = {"Lcom/tencent/mobileqq/vas/service/api/impl/VasZplanAIOSmallHomeServiceImpl;", "Lcom/tencent/mobileqq/vas/service/api/IVasZplanAIOSmallHomeService;", "", "friendUin", "Llu4/c;", "getSmallHomeReq", "Llu4/d;", "rsp", "Lcom/tencent/mobileqq/vas/aio/c;", "convertSmallHomeInfo", "uin", "Lkotlin/Function1;", "", "", "callback", "requestEntranceInfo", "Lcom/tencent/mobileqq/vas/data/h;", "requestEntranceInfoV2", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class VasZplanAIOSmallHomeServiceImpl implements IVasZplanAIOSmallHomeService {
    private static final String AIO_SMALL_HOME_SERVICE = "trpc.qmeta.aio_wo_status_svr.AioWoStatusSvr";
    private static final String GET_USER_AIO_HOME_INFO = "GetUserAioHomeInfo";
    private static final String METHOD = "GetWoStatus";
    private static final String SMALL_HOME_INFO_SERVICE = "trpc.metaverse.mod_info_svr.ModInfoSvr";
    private static final String TAG = "VasZplanAIOSmallHomeServiceImpl";

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/service/api/impl/VasZplanAIOSmallHomeServiceImpl$b", "Le33/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class b implements e33.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<Boolean, Unit> f310643a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f310644b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ VasZplanAIOSmallHomeServiceImpl f310645c;

        /* JADX WARN: Multi-variable type inference failed */
        b(Function1<? super Boolean, Unit> function1, long j3, VasZplanAIOSmallHomeServiceImpl vasZplanAIOSmallHomeServiceImpl) {
            this.f310643a = function1;
            this.f310644b = j3;
            this.f310645c = vasZplanAIOSmallHomeServiceImpl;
        }

        @Override // e33.b
        public void a(Integer errCode, String errMsg) {
            QLog.i(VasZplanAIOSmallHomeServiceImpl.TAG, 1, "aio request errCode:  " + errCode + ", errMas: " + errMsg);
            this.f310643a.invoke(Boolean.FALSE);
        }

        @Override // e33.a
        public void b(RspErrorData rspErrorData) {
            b.a.a(this, rspErrorData);
        }

        @Override // e33.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f310643a.invoke(Boolean.TRUE);
                QLog.i(VasZplanAIOSmallHomeServiceImpl.TAG, 1, "aio smallhome entrance receive null");
                return;
            }
            d rsp = d.c(data);
            VasZplanAIOConfigControl a16 = VasZplanAIOConfigControl.INSTANCE.a();
            Long valueOf = Long.valueOf(this.f310644b);
            VasZplanAIOSmallHomeServiceImpl vasZplanAIOSmallHomeServiceImpl = this.f310645c;
            Intrinsics.checkNotNullExpressionValue(rsp, "rsp");
            a16.o(valueOf, vasZplanAIOSmallHomeServiceImpl.convertSmallHomeInfo(rsp));
            QLog.i(VasZplanAIOSmallHomeServiceImpl.TAG, 1, "aio smallhome entrance receive");
            this.f310643a.invoke(Boolean.TRUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VasZplanAIOData convertSmallHomeInfo(d rsp) {
        int i3 = rsp.f415586a;
        lu4.b bVar = rsp.f415587b;
        long j3 = bVar.f415579a;
        String str = bVar.f415580b;
        Intrinsics.checkNotNullExpressionValue(str, "rsp.bubble.text");
        VasZplanBubble vasZplanBubble = new VasZplanBubble(j3, str, rsp.f415587b.f415581c);
        e eVar = rsp.f415588c;
        long j16 = eVar.f415597a;
        String str2 = eVar.f415598b;
        Intrinsics.checkNotNullExpressionValue(str2, "rsp.iconOnce.url");
        VasZplanAdvIcon vasZplanAdvIcon = new VasZplanAdvIcon(j16, str2, rsp.f415588c.f415599c);
        f fVar = rsp.f415589d;
        long j17 = fVar.f415600a;
        String str3 = fVar.f415601b;
        Intrinsics.checkNotNullExpressionValue(str3, "rsp.iconTimes.url");
        f fVar2 = rsp.f415589d;
        VasZplanCycleIcon vasZplanCycleIcon = new VasZplanCycleIcon(j17, str3, fVar2.f415602c, fVar2.f415603d, fVar2.f415604e);
        a[] aVarArr = rsp.f415596k;
        Intrinsics.checkNotNullExpressionValue(aVarArr, "rsp.avatarInfos");
        ArrayList arrayList = new ArrayList(aVarArr.length);
        for (a aVar : aVarArr) {
            String str4 = aVar.f415576a;
            Intrinsics.checkNotNullExpressionValue(str4, "it.avatar");
            arrayList.add(new VasZplanAvatarIcon(str4, aVar.f415578c, aVar.f415577b));
        }
        VasZplanAvatarInfo vasZplanAvatarInfo = new VasZplanAvatarInfo(arrayList, rsp.f415595j);
        String str5 = rsp.f415592g;
        Intrinsics.checkNotNullExpressionValue(str5, "rsp.defaultIcon");
        return new VasZplanAIOData(i3, vasZplanBubble, vasZplanAdvIcon, vasZplanCycleIcon, vasZplanAvatarInfo, new VasZplanInfo(str5, rsp.f415593h, rsp.f415594i));
    }

    private final lu4.c getSmallHomeReq(long friendUin) {
        VasZplanAIOData m3 = VasZplanAIOConfigControl.INSTANCE.a().m();
        lu4.c cVar = new lu4.c();
        cVar.f415582a = friendUin;
        VasZplanBubble bubble = m3.getBubble();
        cVar.f415583b = bubble != null ? bubble.getSeq() : 0L;
        VasZplanAdvIcon advIcon = m3.getAdvIcon();
        cVar.f415584c = advIcon != null ? advIcon.getSeq() : 0L;
        VasZplanCycleIcon cycleIcon = m3.getCycleIcon();
        cVar.f415585d = cycleIcon != null ? cycleIcon.getSeq() : 0L;
        return cVar;
    }

    @Override // com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService
    public void requestEntranceInfo(long uin, Function1<? super Boolean, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        lu4.c smallHomeReq = getSmallHomeReq(uin);
        QLog.i(TAG, 1, "aio request : " + smallHomeReq);
        QRouteApi api = QRoute.api(IZplanVasProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZplanVasProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(smallHomeReq);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZplanVasProxyServlet.a.a((IZplanVasProxyServlet) api, appInterface, AIO_SMALL_HOME_SERVICE, METHOD, byteArray, emptyMap, new b(callback, uin, this), 0, 64, null);
    }

    @Override // com.tencent.mobileqq.vas.service.api.IVasZplanAIOSmallHomeService
    public void requestEntranceInfoV2(long uin, Function1<? super h, Unit> callback) {
        Map emptyMap;
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        p pVar = new p();
        pVar.f453464a = uin;
        QLog.i(TAG, 1, "aio requestv2 : " + pVar);
        QRouteApi api = QRoute.api(IZ1ProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZ1ProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(pVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZ1ProxyServlet.a.a((IZ1ProxyServlet) api, appInterface, SMALL_HOME_INFO_SERVICE, GET_USER_AIO_HOME_INFO, byteArray, emptyMap, new c(callback, uin), 0, 64, null);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/mobileqq/vas/service/api/impl/VasZplanAIOSmallHomeServiceImpl$c", "Lsb3/b;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes35.dex */
    public static final class c implements sb3.b {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function1<h, Unit> f310646a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ long f310647b;

        /* JADX WARN: Multi-variable type inference failed */
        c(Function1<? super h, Unit> function1, long j3) {
            this.f310646a = function1;
            this.f310647b = j3;
        }

        @Override // sb3.b
        public void a(Integer errCode, String errMsg) {
            QLog.i(VasZplanAIOSmallHomeServiceImpl.TAG, 1, "aio request errCode:  " + errCode + ", errMas: " + errMsg);
            this.f310646a.invoke(null);
        }

        @Override // sb3.a
        public void b(Z1RspErrorData z1RspErrorData) {
            b.a.a(this, z1RspErrorData);
        }

        @Override // sb3.a
        public void onReceive(byte[] data) {
            if (data == null) {
                this.f310646a.invoke(null);
                return;
            }
            q c16 = q.c(data);
            boolean z16 = c16.f453466b == 1;
            boolean z17 = c16.f453471g == 1;
            String str = c16.f453467c;
            Intrinsics.checkNotNullExpressionValue(str, "rsp.newText");
            h hVar = new h(z16, z17, new i(str, c16.f453468d), c16.f453470f, c16.f453469e);
            VasZplanAIOConfigControlV2.INSTANCE.a().d(this.f310647b, hVar);
            QLog.i(VasZplanAIOSmallHomeServiceImpl.TAG, 1, "aio smallhome entrance receive v2");
            this.f310646a.invoke(hVar);
        }
    }
}
