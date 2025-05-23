package com.tencent.hippy.qq.utils;

import android.text.TextUtils;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes7.dex */
public class VasHippyUtils {
    private static final String TAG = "VasHippyUtils";

    public static HippyMap newRspObj(int i3, String str, Object obj) {
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
            QLog.e(TAG, 1, "newRspObj error" + e16);
        }
        return hippyMap;
    }
}
