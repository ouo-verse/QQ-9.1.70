package com.tencent.mobileqq.vas.hippy.api.impl;

import com.tencent.hippy.qq.update.HippyQQConstants;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.api.IVasZplanApi;
import com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi;
import com.tencent.mtt.hippy.HippyAPIProvider;
import com.tencent.qphone.base.util.QLog;
import k13.d;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0007\u00a2\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/vas/hippy/api/impl/ZplanVasHippyApiImpl;", "Lcom/tencent/mobileqq/vas/hippy/api/IZplanVasHippyApi;", "Lcom/tencent/mtt/hippy/HippyAPIProvider;", "getVasZplanHippyAPIProvider", "", "moduleName", "", "isVasZplanSmallHomeModule", "Lorg/json/JSONObject;", "getBusinessData", "<init>", "()V", "Companion", "a", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class ZplanVasHippyApiImpl implements IZplanVasHippyApi {
    private static final String TAG = "ZplanVasHippyApiImpl";

    @Override // com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi
    public JSONObject getBusinessData() {
        int debugSsoId = ((IVasZplanApi) QRoute.api(IVasZplanApi.class)).getDebugSsoId();
        JSONObject jSONObject = new JSONObject();
        if (debugSsoId != 0) {
            try {
                jSONObject.put("env_id", debugSsoId);
            } catch (JSONException unused) {
                QLog.e(TAG, 1, "json put error");
            }
        }
        return jSONObject;
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi
    public HippyAPIProvider getVasZplanHippyAPIProvider() {
        return new d();
    }

    @Override // com.tencent.mobileqq.vas.hippy.api.IZplanVasHippyApi
    public boolean isVasZplanSmallHomeModule(String moduleName) {
        return Intrinsics.areEqual(HippyQQConstants.ModuleName.QQ_ZPLAN_VAS_SMALL_HOME, moduleName);
    }
}
