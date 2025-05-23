package com.tencent.av.mcqq.api.impl;

import com.tencent.av.mcqq.api.IAVPadOrientationSwitchApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes32.dex */
public class AVPadOrientationSwitchApiImpl implements IAVPadOrientationSwitchApi {
    private static final String KEY_DEVICE_WHITE_LIST = "whiteList";
    private static final String TAG = "AVPadOrientationSwitch";
    private static final String WHITE_LIST_MODEL_GROUP_ID = "103200";
    private static boolean sHasInit = false;
    private static boolean sNeedRotate90MC = false;

    private static JSONObject getSwitchJsonData(String str) {
        String str2;
        byte[] loadRawConfig = ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).loadRawConfig(str, new byte[0]);
        if (loadRawConfig != null && loadRawConfig.length != 0) {
            try {
                str2 = new String(loadRawConfig, StandardCharsets.UTF_8);
                try {
                    return new JSONObject(str2);
                } catch (Exception e16) {
                    e = e16;
                    QLog.e(TAG, 1, "parse raw config failed!!! str: " + str2 + "\n", e);
                    return null;
                }
            } catch (Exception e17) {
                e = e17;
                str2 = null;
            }
        } else {
            QLog.e(TAG, 1, "get null raw config!!! groupId: " + str);
            return null;
        }
    }

    @Override // com.tencent.av.mcqq.api.IAVPadOrientationSwitchApi
    public Boolean isNeedRotate90() {
        if (sHasInit) {
            return Boolean.valueOf(sNeedRotate90MC);
        }
        try {
            JSONObject switchJsonData = getSwitchJsonData(WHITE_LIST_MODEL_GROUP_ID);
            if (switchJsonData == null) {
                QLog.d(TAG, 1, "isNeedRotate90 json is null.");
                return null;
            }
            sHasInit = true;
            QLog.d(TAG, 1, "isNeedRotate90 model=" + DeviceInfoMonitor.getModel());
            List<String> jsonArrayToList = jsonArrayToList(switchJsonData.optJSONArray(KEY_DEVICE_WHITE_LIST));
            if (jsonArrayToList != null) {
                String model = DeviceInfoMonitor.getModel();
                Iterator<String> it = jsonArrayToList.iterator();
                while (it.hasNext()) {
                    if (model.equals(it.next())) {
                        QLog.i(TAG, 2, "isNeedRotate90 switch on: phone is whitelisted");
                        sNeedRotate90MC = false;
                        return Boolean.FALSE;
                    }
                }
            }
            QLog.d(TAG, 1, "isNeedRotate90 not in list");
            sNeedRotate90MC = true;
            return Boolean.TRUE;
        } catch (Exception e16) {
            QLog.d(TAG, 1, "isWhiteModel exception: " + e16);
            return null;
        }
    }

    private static List<String> jsonArrayToList(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < jSONArray.length(); i3++) {
            arrayList.add(jSONArray.optString(i3));
        }
        return arrayList;
    }
}
