package com.tencent.sqshow.zootopia.nativeui.data.repo;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import uv4.bk;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u00072\u00020\u0001:\u0002\f\u0007B\u0007\u00a2\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004R<\u0010\u000e\u001a*\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t0\bj\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\t`\u000b8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\f\u0010\r\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f;", "", "", "itemId", "Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f$b;", "callback", "", "b", "Ljava/util/HashMap;", "", "Luv4/bk;", "Lkotlin/collections/HashMap;", "a", "Ljava/util/HashMap;", "mCacheData", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class f {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final HashMap<Integer, List<bk>> mCacheData = new HashMap<>();

    /* compiled from: P */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H&J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\nH&\u00a8\u0006\r"}, d2 = {"Lcom/tencent/sqshow/zootopia/nativeui/data/repo/f$b;", "", "", "itemId", "", "Luv4/bk;", "result", "", "onSuccess", "errCode", "", "errMsg", "onError", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public interface b {
        void onError(int errCode, String errMsg);

        void onSuccess(int itemId, List<bk> result);
    }

    /* compiled from: P */
    @Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J#\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016\u00a2\u0006\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"com/tencent/sqshow/zootopia/nativeui/data/repo/f$c", "Ltd3/a;", "", "data", "", "onReceive", "", "errCode", "", "errMsg", "a", "(Ljava/lang/Integer;Ljava/lang/String;)V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
    /* loaded from: classes34.dex */
    public static final class c implements td3.a {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ b f371112a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f371113b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ f f371114c;

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ long f371115d;

        c(b bVar, int i3, f fVar, long j3) {
            this.f371112a = bVar;
            this.f371113b = i3;
            this.f371114c = fVar;
            this.f371115d = j3;
        }

        @Override // td3.a
        public void a(Integer errCode, String errMsg) {
            b bVar = this.f371112a;
            if (bVar != null) {
                bVar.onError(errCode != null ? errCode.intValue() : -11, errMsg);
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
        
            if ((r6.length == 0) != false) goto L26;
         */
        @Override // td3.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void onReceive(byte[] data) {
            String str;
            uv4.r rVar;
            boolean z16;
            List<bk> list;
            if (data == null) {
                b bVar = this.f371112a;
                if (bVar != null) {
                    bVar.onError(-10, "rsp is null");
                    return;
                }
                return;
            }
            try {
                rVar = uv4.r.c(data);
                str = "";
            } catch (Exception e16) {
                String message = e16.getMessage();
                if (message == null) {
                    message = "RSP_PARSE_FAILED";
                }
                str = message;
                rVar = null;
            }
            if (rVar == null) {
                b bVar2 = this.f371112a;
                if (bVar2 != null) {
                    bVar2.onError(-13, str);
                    return;
                }
                return;
            }
            bk[] bkVarArr = rVar.f440439a;
            if (bkVarArr != null) {
                z16 = false;
            }
            z16 = true;
            if (z16) {
                b bVar3 = this.f371112a;
                if (bVar3 != null) {
                    bVar3.onError(-101, "\u63a8\u8350\u5217\u8868\u4e3a\u7a7a");
                    return;
                }
                return;
            }
            Intrinsics.checkNotNullExpressionValue(bkVarArr, "rsp.list");
            list = ArraysKt___ArraysKt.toList(bkVarArr);
            b bVar4 = this.f371112a;
            if (bVar4 != null) {
                bVar4.onSuccess(this.f371113b, list);
            }
            this.f371114c.mCacheData.put(Integer.valueOf(this.f371113b), list);
            QLog.i("AvatarRecommendDataRepo", 1, "requestRecommendData cost=" + (System.currentTimeMillis() - this.f371115d));
        }
    }

    public final void b(int itemId, b callback) {
        Map emptyMap;
        QLog.i("AvatarRecommendDataRepo", 1, "requestRecommendData itemId:" + itemId);
        List<bk> list = this.mCacheData.get(Integer.valueOf(itemId));
        if (list != null && (list.isEmpty() ^ true)) {
            QLog.i("AvatarRecommendDataRepo", 1, "requestRecommendData hit cache");
            if (callback != null) {
                callback.onSuccess(itemId, list);
                return;
            }
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        uv4.q qVar = new uv4.q();
        qVar.f440438a = new int[]{itemId};
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16 && callback != null) {
            callback.onError(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        QRouteApi api = QRoute.api(IZootopiaProxyServlet.class);
        Intrinsics.checkNotNullExpressionValue(api, "api(IZootopiaProxyServlet::class.java)");
        byte[] byteArray = MessageNano.toByteArray(qVar);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        IZootopiaProxyServlet.b.b((IZootopiaProxyServlet) api, appInterface, "trpc.metaverse.store_conf_svr.StoreConfSvr", "GetRecommendStoreItemList", byteArray, emptyMap, new c(callback, itemId, this, currentTimeMillis), 0, 0, 192, null);
    }
}
