package com.tencent.mobileqq.vas.hippy;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class d {
    public static HippyMap a(int i3, String str, Object obj) {
        HippyMap hippyMap = new HippyMap();
        try {
            hippyMap.pushInt("result", i3);
            if (!TextUtils.isEmpty(str)) {
                hippyMap.pushString("message", str);
            }
            if (obj != null) {
                if (obj instanceof JSONObject) {
                    hippyMap.pushJSONObject(new JSONObject().put("data", obj));
                } else {
                    hippyMap.pushObject("data", obj);
                }
            }
        } catch (Exception e16) {
            QLog.e("VasHippyUtils", 1, "newRspObj error" + e16);
        }
        return hippyMap;
    }
}
