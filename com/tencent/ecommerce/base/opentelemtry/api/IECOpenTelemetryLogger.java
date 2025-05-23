package com.tencent.ecommerce.base.opentelemtry.api;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\tH&\u00a8\u0006\n"}, d2 = {"Lcom/tencent/ecommerce/base/opentelemtry/api/IECOpenTelemetryLogger;", "", "logMessage", "", TtmlNode.TAG_SPAN, "Lcom/tencent/ecommerce/base/opentelemtry/api/IECSpan;", "message", "", "attributes", "", "ecommerce_api_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes5.dex */
public interface IECOpenTelemetryLogger {
    void logMessage(@NotNull IECSpan span, @NotNull String message, @NotNull Map<String, String> attributes);
}
