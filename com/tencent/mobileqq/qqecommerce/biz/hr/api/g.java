package com.tencent.mobileqq.qqecommerce.biz.hr.api;

import com.tencent.hippy.qq.module.HippyQQHttpModule;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0006\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H&J\u001c\u0010\b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0002H&J\u001c\u0010\u000b\u001a\u00020\u00052\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\r\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\u0002H&\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/qqecommerce/biz/hr/api/g;", "", "", "callback", "data", "", "invokeCallJS", HippyQQHttpModule.HTPP_ERROR_TEXT, "invokeErrorCallJS", "Lorg/json/JSONObject;", "result", "invokeJS", "callbackId", "popBack", "qqecommerce-api_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes16.dex */
public interface g {
    void invokeCallJS(@Nullable String callback, @Nullable Object data);

    void invokeErrorCallJS(@Nullable String callback, @Nullable String errorText);

    void invokeJS(@Nullable String callback, @Nullable JSONObject result);

    void popBack(@Nullable String callbackId);
}
