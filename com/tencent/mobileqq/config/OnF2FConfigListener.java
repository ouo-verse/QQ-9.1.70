package com.tencent.mobileqq.config;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QMMKVMigrateHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.config.c;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class OnF2FConfigListener implements c.b {
    @Override // com.tencent.mobileqq.config.c.b
    public void onGetConfig(final QQAppInterface qQAppInterface, int i3, String str, final c.a aVar) {
        if (aVar != null && AppConstants.Preferences.QQSETTINGME_F2F_GUIDE_CONFIG.equals(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("OnF2FConfigListener", 2, "handleConfigForTag qqsettingme_f2f content = " + aVar.f202860d);
            }
            ThreadManagerV2.post(new Runnable() { // from class: com.tencent.mobileqq.config.OnF2FConfigListener.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObject = new JSONObject(aVar.f202860d);
                        int optInt = jSONObject.optInt("face2faceSwitchOn");
                        QMMKVMigrateHelper.getMMKVMigratedSharePreferencesSync(MobileQQ.sMobileQQ, qQAppInterface.getCurrentAccountUin() + AppConstants.Preferences.QQSETTINGME_F2F_GUIDE, 0).edit().putInt("qqsettingme_f2f_guide_switch", optInt).putString("qqsettingme_f2f_guide_tip", jSONObject.optString("face2faceTip")).apply();
                    } catch (JSONException e16) {
                        e16.printStackTrace();
                    } catch (Exception unused) {
                    }
                }
            }, 5, null, false);
        }
    }
}
