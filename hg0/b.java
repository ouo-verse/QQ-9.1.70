package hg0;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.ecommerce.base.QQEcommerceSdk;
import com.tencent.ecommerce.base.opentelemtry.api.IECSpan;
import java.util.Map;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u0002J\"\u0010\t\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007J*\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0007J\u0016\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\fJ\u000e\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0012\u001a\u00020\u00108\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u000b\u0010\u0011\u00a8\u0006\u0015"}, d2 = {"Lhg0/b;", "", "", "spanName", "serviceName", "", "e", "", "attributes", "d", "event", "a", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "b", "c", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "spanProxy", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    private final IECSpan spanProxy = QQEcommerceSdk.INSTANCE.getGlobalInternalSdk().getOpenTelemetry().getSpanManager();

    public final void a(String spanName, String event, Map<String, String> attributes) {
        this.spanProxy.addEvent(spanName, event, attributes);
    }

    public final void b(String spanName, int statusCode) {
        this.spanProxy.endSpan(spanName, statusCode);
    }

    public final String c(String spanName) {
        return this.spanProxy.getTraceInfo(spanName);
    }

    public final void d(String spanName, Map<String, String> attributes) {
        this.spanProxy.setAttribute(spanName, attributes);
    }

    public final void e(String spanName, String serviceName) {
        this.spanProxy.startSpan(spanName, serviceName);
    }

    public static /* synthetic */ void f(b bVar, String str, String str2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        bVar.e(str, str2);
    }
}
