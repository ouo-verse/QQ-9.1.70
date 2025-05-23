package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.c;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class ag implements c.b {
    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(QQAppInterface qQAppInterface, int i3, String str, c.a aVar) {
        BaseApplication context;
        StringBuilder sb5;
        SharedPreferences.Editor putInt;
        if (aVar != null && AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG.equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("OnSmartDeviceDiscoveryCfgListener", 2, "handleConfigForTag smartDeviceDiscoverCfg content = " + aVar.f202860d);
            }
            try {
                try {
                    int optInt = new JSONObject(aVar.f202860d).optInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH);
                    putInt = BaseApplication.getContext().getSharedPreferences(qQAppInterface.getCurrentAccountUin() + AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_FILE, 0).edit().putInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, optInt);
                } catch (JSONException e16) {
                    e16.printStackTrace();
                    context = BaseApplication.getContext();
                    sb5 = new StringBuilder();
                    sb5.append(qQAppInterface.getCurrentAccountUin());
                    sb5.append(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_FILE);
                    putInt = context.getSharedPreferences(sb5.toString(), 0).edit().putInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, 1);
                    putInt.apply();
                } catch (Exception unused) {
                    context = BaseApplication.getContext();
                    sb5 = new StringBuilder();
                    sb5.append(qQAppInterface.getCurrentAccountUin());
                    sb5.append(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_FILE);
                    putInt = context.getSharedPreferences(sb5.toString(), 0).edit().putInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, 1);
                    putInt.apply();
                }
                putInt.apply();
            } catch (Throwable th5) {
                BaseApplication.getContext().getSharedPreferences(qQAppInterface.getCurrentAccountUin() + AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_FILE, 0).edit().putInt(AppConstants.Preferences.SMART_DEVICE_DISCOVERY_CONFIG_SWITCH, 1).apply();
                throw th5;
            }
        }
    }
}
