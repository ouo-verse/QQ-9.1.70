package com.tencent.gdtad.basics.motivevideo.hippy.method;

import android.text.TextUtils;
import com.tencent.ad.tangram.json.AdJSONUtil;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.ams.dsdk.event.DKMethodHandler;
import com.tencent.ams.xsad.rewarded.dynamic.method.AdCommonMethodHandler;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class c implements DKMethodHandler {
    private void a(DKMethodHandler.Callback callback) {
        GdtLog.i("GdtMotiveHippyInitMethodHandler ", "handleHippyInitFinished ");
        if (callback != null) {
            callback.onResult(null);
        }
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public String getModuleId() {
        return "Common";
    }

    @Override // com.tencent.ams.dsdk.event.DKMethodHandler
    public boolean invoke(DKEngine dKEngine, String str, JSONObject jSONObject, DKMethodHandler.Callback callback) {
        if (TextUtils.isEmpty(str)) {
            GdtLog.i("GdtMotiveHippyInitMethodHandler ", "methodName is empty.");
            return false;
        }
        QLog.i("GdtMotiveHippyInitMethodHandler ", 1, "[invoke] methodName:" + str + " params:" + AdJSONUtil.toString(jSONObject));
        str.hashCode();
        if (!str.equals(AdCommonMethodHandler.AdCommonEvent.HIPPY_INIT_FINISHED)) {
            return false;
        }
        a(callback);
        return true;
    }
}
