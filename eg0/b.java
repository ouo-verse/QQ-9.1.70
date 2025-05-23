package eg0;

import com.tencent.ecommerce.base.network.api.ECRemoteResponse;
import com.tencent.mobileqq.transfile.predownload.schedule.PreDownloadConstants;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt__MapsKt;

/* compiled from: P */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0011\u0010\u0012J\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u001e\u0010\f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\nR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\t\u0010\u000f\u00a8\u0006\u0013"}, d2 = {"Leg0/b;", "", "", "method", "Lcom/tencent/ecommerce/base/network/api/e;", "response", "", "success", "", "a", "", PreDownloadConstants.RPORT_KEY_REQ_TIME, "b", "", "", "[Ljava/lang/Double;", "DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: b, reason: collision with root package name */
    public static final b f396238b = new b();

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private static final Double[] DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES = {Double.valueOf(5.0d), Double.valueOf(10.0d), Double.valueOf(25.0d), Double.valueOf(50.0d), Double.valueOf(75.0d), Double.valueOf(100.0d), Double.valueOf(250.0d), Double.valueOf(500.0d), Double.valueOf(750.0d), Double.valueOf(1000.0d), Double.valueOf(2500.0d), Double.valueOf(5000.0d), Double.valueOf(7500.0d), Double.valueOf(10000.0d)};

    b() {
    }

    public final void a(String method, ECRemoteResponse response, int success) {
        Map<String, String> mapOf;
        if (a.f396236c.b(method)) {
            return;
        }
        hg0.a aVar = hg0.a.f404850b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("service.method", method), TuplesKt.to("network.response.biz_code", String.valueOf(response.getCode())), TuplesKt.to("network.response.ch_code", String.valueOf(response.getChannelCode())), TuplesKt.to("network.response.success", String.valueOf(success)));
        aVar.a(1L, "ec_network_reachability", "1", "network reachability", mapOf);
    }

    public final void b(String method, ECRemoteResponse response, long reqTime) {
        Map<String, String> mapOf;
        if (a.f396236c.b(method)) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis() - reqTime;
        hg0.a aVar = hg0.a.f404850b;
        mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to("service.method", method), TuplesKt.to("network.response.biz_code", String.valueOf(response.getCode())), TuplesKt.to("network.response.ch_code", String.valueOf(response.getChannelCode())));
        aVar.d(currentTimeMillis, "ec_network_duration", "ms", "network request duration", mapOf, DEFAULT_HISTOGRAM_BUCKET_BOUNDARIES);
    }
}
