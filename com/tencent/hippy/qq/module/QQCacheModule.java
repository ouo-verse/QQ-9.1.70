package com.tencent.hippy.qq.module;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.hippy.qq.api.impl.HippyDomNodeManagerImpl;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class QQCacheModule extends com.tencent.mobileqq.qqecommerce.biz.hr.api.b {
    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.b
    public void cacheBody(@NonNull String str) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("module", HippyDomNodeManagerImpl.FILE_TYPE);
            jSONObject.put("method", "createBody");
            JSONObject jSONObject2 = new JSONObject(str);
            com.tencent.mobileqq.qqecommerce.biz.hr.api.b.handleBody(jSONObject2);
            jSONObject.put("args", jSONObject2);
            jSONArray.mo162put(jSONObject);
        } catch (JSONException unused) {
        }
    }

    public void getItem(@NonNull String str, Promise promise) {
        String str2 = null;
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e(com.tencent.mobileqq.qqecommerce.biz.hr.api.b.TAG, 1, "failed to getItem");
            if (promise != null && promise.isCallback()) {
                HippyMap hippyMap = new HippyMap();
                hippyMap.pushString("retmsg", "failed to getItem");
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        Object readObject = FileUtils.readObject(com.tencent.mobileqq.qqecommerce.biz.hr.api.b.VIOLA_CACHE_FILE_NAME + str + "_" + waitAppRuntime.getAccount());
        if (readObject instanceof String) {
            str2 = (String) readObject;
        }
        if (TextUtils.isEmpty(str2)) {
            str2 = new JSONObject().toString();
        }
        if (promise != null && promise.isCallback()) {
            promise.resolve(str2);
        }
    }

    public void multiGet(@NonNull JSONObject jSONObject, Promise promise) {
        String str;
        HippyMap hippyMap = new HippyMap();
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e(com.tencent.mobileqq.qqecommerce.biz.hr.api.b.TAG, 1, "failed to getItem");
            if (promise != null && promise.isCallback()) {
                hippyMap.pushString("retmsg", "failed to getItem");
                promise.resolve(hippyMap);
                return;
            }
            return;
        }
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            JSONArray jSONArray = jSONObject.getJSONArray("keys");
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                String string = jSONArray.getString(i3);
                Object readObject = FileUtils.readObject(com.tencent.mobileqq.qqecommerce.biz.hr.api.b.VIOLA_CACHE_FILE_NAME + string + "_" + waitAppRuntime.getAccount());
                if (readObject instanceof String) {
                    str = (String) readObject;
                } else {
                    str = null;
                }
                if (TextUtils.isEmpty(str)) {
                    str = "";
                }
                jSONObject3.put(string, str);
            }
            jSONObject2.put("data", jSONObject3);
        } catch (JSONException e16) {
            QLog.e(com.tencent.mobileqq.qqecommerce.biz.hr.api.b.TAG, 1, "CacheModule multiGet:", e16);
        }
        if (promise != null && promise.isCallback()) {
            hippyMap.pushJSONObject(jSONObject2);
            promise.resolve(hippyMap);
        }
    }

    @Override // com.tencent.mobileqq.qqecommerce.biz.hr.api.b
    public void destroy() {
    }
}
