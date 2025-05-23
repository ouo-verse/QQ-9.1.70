package com.tencent.mobileqq.vas.config.business.qvip;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes20.dex */
public class QVipPrettyAccountConfig {
    public static final String TAG = "QVipPrettyAccountConfig";
    public boolean isEnable = true;

    public static QVipPrettyAccountConfig fromJson(String str) {
        QVipPrettyAccountConfig qVipPrettyAccountConfig = new QVipPrettyAccountConfig();
        if (TextUtils.isEmpty(str)) {
            return qVipPrettyAccountConfig;
        }
        try {
            qVipPrettyAccountConfig.isEnable = new JSONObject(str).optBoolean("isEnable", true);
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pretty_account config :" + qVipPrettyAccountConfig.isEnable);
            }
        } catch (JSONException e16) {
            if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "pretty_account config init error:" + e16);
            }
        }
        return qVipPrettyAccountConfig;
    }
}
