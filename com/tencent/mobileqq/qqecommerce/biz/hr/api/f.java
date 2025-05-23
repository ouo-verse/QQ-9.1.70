package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import com.tencent.ad.tangram.statistics.metric.AdMetricTag;
import com.tencent.ecommerce.richtext.annotation.JSMethod;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H'J\u001a\u0010\t\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H'\u00a8\u0006\n"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/f;", "", "", "code", "Lorg/json/JSONObject;", "params", "", "a", AdMetricTag.EVENT_NAME, "b", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface f {
    @JSMethod(uiThread = false)
    void a(@NotNull String code, @NotNull JSONObject params);

    @JSMethod(uiThread = false)
    void b(@NotNull String eventName, @Nullable JSONObject params);
}
