package com.tencent.ecommerce.base.opentelemtry.api;

import android.util.Log;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\b\u0000\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007\u00a2\u0006\u0004\b\u0015\u0010\u0016J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0016J \u0010\b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016J$\u0010\f\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016J,\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u00022\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\tH\u0016J\u0018\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\u0004\u001a\u00020\u00028VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006\u0018"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/d;", "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "", "spanName", "serviceName", "", "startSpan", "parentSpanName", "startSpanWithParent", "", "attributes", "setAttribute", "updateAttribute", "event", "addEvent", "", HiAnalyticsConstant.HaKey.BI_KEY_RESULT, "endSpan", "getTraceInfo", "getServiceName", "()Ljava/lang/String;", "<init>", "()V", "a", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public final class d implements IECSpan {
    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void addEvent(@NotNull String spanName, @NotNull String event, @NotNull Map<String, String> attributes) {
        Log.i("ECDefaultSpan", "IECSpan startSpan not implement, use default addEvent");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void endSpan(@NotNull String spanName, int statusCode) {
        Log.i("ECDefaultSpan", "IECSpan startSpan not implement, use default endSpan");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    @NotNull
    public String getServiceName() {
        return "defaultSpan";
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    @NotNull
    public String getTraceInfo(@NotNull String spanName) {
        Log.i("ECDefaultSpan", "IECSpan getTraceInfo not implement, use default endSpan");
        return "";
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void setAttribute(@NotNull String spanName, @NotNull Map<String, String> attributes) {
        Log.i("ECDefaultSpan", "IECSpan startSpan not implement, use default setAttribute");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void startSpan(@NotNull String spanName, @NotNull String serviceName) {
        Log.i("ECDefaultSpan", "IECSpan startSpan not implement, use default startSpan");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void startSpanWithParent(@NotNull String spanName, @NotNull String serviceName, @NotNull String parentSpanName) {
        Log.i("ECDefaultSpan", "IECSpan startSpanWithParent not implement, use default startSpanWithParent");
    }

    @Override // com.tencent.ecommerce.base.opentelemtry.api.IECSpan
    public void updateAttribute(@NotNull String spanName, @NotNull Map<String, String> attributes) {
        Log.i("ECDefaultSpan", "IECSpan startSpan not implement, use default updateAttribute");
    }
}
