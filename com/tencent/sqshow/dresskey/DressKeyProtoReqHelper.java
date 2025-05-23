package com.tencent.sqshow.dresskey;

import com.google.protobuf.nano.MessageNano;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.zootopia.api.e;
import com.tencent.mobileqq.zootopia.sso.api.IZootopiaProxyServlet;
import com.tencent.sqshow.utils.featureswitch.ZPlanQQMC;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0013\u0010\u0014J&\u0010\n\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\b\b\u0002\u0010\b\u001a\u00020\u0007R\u0014\u0010\r\u001a\u00020\u000b8\u0002X\u0082D\u00a2\u0006\u0006\n\u0004\b\n\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00078BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/sqshow/dresskey/DressKeyProtoReqHelper;", "", "Ldw4/a;", "req", "Lcom/tencent/mobileqq/zootopia/api/e;", "Ldw4/b;", "callback", "", "source", "", "b", "", "Ljava/lang/String;", "TAG", "c", "Lkotlin/Lazy;", "d", "()I", "TIMEOUT", "<init>", "()V", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class DressKeyProtoReqHelper {

    /* renamed from: a */
    public static final DressKeyProtoReqHelper f369812a = new DressKeyProtoReqHelper();

    /* renamed from: b, reason: from kotlin metadata */
    private static final String TAG = "DressKeyProtoReqHelper";

    /* renamed from: c, reason: from kotlin metadata */
    private static final Lazy TIMEOUT;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.tencent.sqshow.dresskey.DressKeyProtoReqHelper$TIMEOUT$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(ZPlanQQMC.INSTANCE.getDressInfoRequestTimeout());
            }
        });
        TIMEOUT = lazy;
    }

    DressKeyProtoReqHelper() {
    }

    private final int d() {
        return ((Number) TIMEOUT.getValue()).intValue();
    }

    public final void b(dw4.a req, e<dw4.b> callback, int source) {
        Map<String, String> emptyMap;
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        boolean z16 = peekAppRuntime instanceof AppInterface;
        if (!z16) {
            callback.onResultFailure(-12, "\u83b7\u53d6app\u5f02\u5e38");
        }
        AppInterface appInterface = z16 ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null) {
            return;
        }
        IZootopiaProxyServlet iZootopiaProxyServlet = (IZootopiaProxyServlet) QRoute.api(IZootopiaProxyServlet.class);
        byte[] byteArray = MessageNano.toByteArray(req);
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(req)");
        emptyMap = MapsKt__MapsKt.emptyMap();
        iZootopiaProxyServlet.sendZootopiaProxyRequest(appInterface, "trpc.metaverse.user_material.UserMaterialServer", "GetDressKey", byteArray, emptyMap, new DressKeyProtoReqHelper$doGetDressKeyReq$1(source, callback), source, d());
    }

    public static /* synthetic */ void c(DressKeyProtoReqHelper dressKeyProtoReqHelper, dw4.a aVar, e eVar, int i3, int i16, Object obj) {
        if ((i16 & 4) != 0) {
            i3 = 0;
        }
        dressKeyProtoReqHelper.b(aVar, eVar, i3);
    }
}
