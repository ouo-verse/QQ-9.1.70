package mi0;

import com.tencent.ecommerce.base.config.api.IECLocalConfig;
import com.tencent.ecommerce.base.config.service.ECLocalConfig;
import com.tencent.ecommerce.base.ui.api.ECToastIcon;
import com.tencent.ecommerce.base.ui.i;
import com.tencent.ecommerce.biz.pay.api.IECPayApi;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\b\u001a\f\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u0002\u001a\u0016\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003*\u00020\u0000\"\u0014\u0010\b\u001a\u00020\u00048BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007\"\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00038F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\f"}, d2 = {"Lcom/tencent/ecommerce/biz/pay/api/IECPayApi$b;", "", "e", "", "", "d", "b", "()Ljava/lang/String;", "payEnv", "c", "()Ljava/util/Map;", "payNeedLoginSpanExtInfo", "ecommerce_sdk_debug"}, k = 2, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {
    private static final String b() {
        if (IECLocalConfig.a.c(ECLocalConfig.f100650f, "is_release_env", true, null, 4, null)) {
            return "release";
        }
        return "test";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void e(IECPayApi.PayResult payResult) {
        if (payResult.getCode() == 0) {
            return;
        }
        if (Intrinsics.areEqual(payResult.getMsg(), "fast click")) {
            i.f101155b.d("\u64cd\u4f5c\u8fc7\u5feb\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", ECToastIcon.ICON_ERROR, 0);
        } else {
            i.f101155b.d("\u652f\u4ed8\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5", ECToastIcon.ICON_ERROR, 0);
        }
    }

    public static final Map<String, String> c() {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("errMsg", "payNeedLogin"), TuplesKt.to("payEnv", b()));
        return mapOf;
    }

    public static final Map<String, String> d(IECPayApi.PayResult payResult) {
        Map<String, String> mapOf;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("payResult", String.valueOf(payResult)), TuplesKt.to("payEnv", b()));
        return mapOf;
    }
}
