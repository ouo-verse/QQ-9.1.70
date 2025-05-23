package com.tencent.mobileqq.zplan.api.impl;

import com.tencent.mobileqq.zplan.api.IZplanHandleApi;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\"\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0002H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/zplan/api/impl/ZplanHandleApiImpl;", "Lcom/tencent/mobileqq/zplan/api/IZplanHandleApi;", "", "business", "method", "params", "", "handleDataToUE", "", "handleDataToMain", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanHandleApiImpl implements IZplanHandleApi {
    public static final String TAG = "HandlerManager";

    @Override // com.tencent.mobileqq.zplan.api.IZplanHandleApi
    public boolean handleDataToMain(String business, String method, String params) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i(TAG, 1, "handleDataToNative business:" + business + " method:" + method + " params:" + params);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("business", business);
        jSONObject.put("method", method);
        jSONObject.put("params", params);
        jSONObject.put("isToUE", false);
        return ((hc3.a) k74.i.INSTANCE.a(hc3.a.class)).toMain(jSONObject);
    }

    @Override // com.tencent.mobileqq.zplan.api.IZplanHandleApi
    public void handleDataToUE(String business, String method, String params) {
        Intrinsics.checkNotNullParameter(business, "business");
        Intrinsics.checkNotNullParameter(method, "method");
        QLog.i(TAG, 1, "handleDataToUE business:" + business + " method:" + method + " params:" + params);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("business", business);
        jSONObject.put("method", method);
        jSONObject.put("params", params);
        jSONObject.put("isToUE", true);
        ((hc3.a) k74.i.INSTANCE.a(hc3.a.class)).toMain(jSONObject);
    }
}
