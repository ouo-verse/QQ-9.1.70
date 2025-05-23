package com.tencent.mobileqq.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class KplHelper {
    public static String getGameNickByUin(QQAppInterface qQAppInterface, String str) {
        String str2 = null;
        String string = qQAppInterface.getPreferences().getString("key_kpl_nick_table", null);
        if (!TextUtils.isEmpty(string)) {
            try {
                str2 = new JSONObject(string).optString(str);
                if (QLog.isColorLevel()) {
                    QLog.d("KplHelper", 2, "getGameNickByUin uin=" + str + " kpl_nick=" + str2);
                }
            } catch (JSONException e16) {
                if (QLog.isColorLevel()) {
                    QLog.d(KplRoleInfo.KPL_TAG, 2, "catch exception when getGameNickByUin json=" + string + " --uin=" + str);
                }
                e16.printStackTrace();
            }
        }
        return str2;
    }

    public static String getKplVerifyMsg(QQAppInterface qQAppInterface) {
        String string = qQAppInterface.getPreferences().getString("key_kpl_nick_table" + qQAppInterface.getCurrentAccountUin(), null);
        if (QLog.isColorLevel()) {
            QLog.d("KplHelper", 2, "getKplVerifyMsg uin=" + qQAppInterface.getCurrentUin() + " kpl_verify_msg=" + string);
        }
        return string;
    }

    public static void handleKplFlag(QQAppInterface qQAppInterface, String str) {
        if (!TextUtils.isEmpty(str)) {
            if (QLog.isColorLevel()) {
                QLog.d("KplHelper", 2, "handleKplFlag json=" + str);
            }
            qQAppInterface.getPreferences();
            try {
                JSONObject jSONObject = new JSONObject(str);
                Iterator keys = jSONObject.keys();
                if (QLog.isColorLevel()) {
                    QLog.d("KplHelper", 2, "handleKplFlag info: ----------------");
                }
                while (keys.hasNext()) {
                    String str2 = (String) keys.next();
                    saveGameNickWithUin(qQAppInterface, str2, jSONObject.optString(str2));
                }
                if (QLog.isColorLevel()) {
                    QLog.d("KplHelper", 2, "------------------------------------");
                }
            } catch (Exception e16) {
                if (QLog.isColorLevel()) {
                    QLog.d("KplHelper", 2, "handleKplFlag catch an exception");
                }
                e16.printStackTrace();
            }
        }
    }

    public static boolean isKplSession(QQAppInterface qQAppInterface, Context context, String str, int i3) {
        return false;
    }

    public static void saveGameNickWithUin(AppInterface appInterface, String str, String str2) {
        JSONObject jSONObject;
        SharedPreferences preferences = appInterface.getPreferences();
        String string = preferences.getString("key_kpl_nick_table", null);
        try {
            if (!TextUtils.isEmpty(string)) {
                jSONObject = new JSONObject(string);
            } else {
                jSONObject = new JSONObject();
            }
            jSONObject.put(str, str2);
            string = jSONObject.toString();
            if (!TextUtils.isEmpty(string)) {
                preferences.edit().putString("key_kpl_nick_table", string).commit();
                if (QLog.isColorLevel()) {
                    QLog.d("KplHelper", 2, "saveGameNickWithUin uin=" + str + " kpl_nick=" + str2);
                }
            }
        } catch (Exception unused) {
            if (QLog.isColorLevel()) {
                QLog.d(KplRoleInfo.KPL_TAG, 2, "catch exception when saveGameNickWithUin json=" + string + " --uin=" + str + " --gameNick=" + str2);
            }
        }
    }

    public static void saveKplVerifyMsg(AppInterface appInterface, String str) {
        if (!TextUtils.isEmpty(str)) {
            appInterface.getPreferences().edit().putString("key_kpl_nick_table" + appInterface.getCurrentAccountUin(), str).commit();
            if (QLog.isColorLevel()) {
                QLog.d("KplHelper", 2, "saveKplVerifyMsg uin=" + appInterface.getCurrentUin() + " kpl_verify_msg=" + str);
            }
        }
    }
}
