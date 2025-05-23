package com.tencent.mobileqq.utils;

import android.content.Context;
import com.tencent.avcore.config.ConfigUtil;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.confess.ConfessConfig;
import com.tencent.mobileqq.confess.ConfessHandler;
import com.tencent.mobileqq.confess.ConfessManager;
import com.tencent.mobileqq.config.c;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Locale;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class y {
    public static String a(Context context, String str, String str2) {
        Object readObject = FileUtils.readObject(String.format(Locale.getDefault(), "%s_%s_config_content", str, str2));
        if (readObject == null) {
            return null;
        }
        return (String) readObject;
    }

    public static void b(QQAppInterface qQAppInterface, String str, c.a aVar, int i3) {
        boolean z16;
        String currentUin = qQAppInterface.getCurrentUin();
        if (AppConstants.Preferences.CONFESS_CONFIG.equals(str)) {
            int i16 = QQManagerFactory.CONFESS_MANAGER;
            if (qQAppInterface.isCreateManager(i16)) {
                ConfessConfig h16 = ((ConfessManager) qQAppInterface.getManager(i16)).h();
                aVar.f202862f = h16.i(aVar.f202860d);
                ((ConfessHandler) qQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFESS_HANDLER)).H2(qQAppInterface, h16);
            } else {
                aVar.f202862f = ConfessConfig.k(aVar.f202860d);
            }
            aVar.f202861e = true;
            return;
        }
        if (AppConstants.Preferences.SOSOINTERFACE_CONFIG.equals(str)) {
            aVar.f202862f = ((ISosoInterfaceApi) QRoute.api(ISosoInterfaceApi.class)).saveSosoInterfaceConfig(aVar.f202860d);
            aVar.f202861e = true;
            return;
        }
        if (AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG.equals(str)) {
            try {
                JSONObject jSONObject = new JSONObject(aVar.f202860d);
                if (jSONObject.optInt("isShowEntrance") == 1) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                String optString = jSONObject.optString("webUrl");
                String optString2 = jSONObject.optString("successText");
                String optString3 = jSONObject.optString("boldText");
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_URL, optString);
                ea.I3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_ENTRANCE, z16);
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_SUCCESS_TEXT, optString2);
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_BOLD_TEXT, optString3);
                MMKVOptionEntity from = QMMKV.from(qQAppInterface.getApp(), "common_mmkv_configurations");
                from.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_URL, optString);
                from.encodeBool(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_ENTRANCE, z16);
                from.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_SUCCESS_TEXT, optString2);
                from.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_BOLD_TEXT, optString3);
                if (QLog.isColorLevel()) {
                    QLog.d(ConfigUtil.TAG, 2, String.format("update account logout config, showEntrance:%s, webUrl: %s, successText: %s, boldText: %s", Boolean.valueOf(z16), optString, optString2, optString3));
                }
            } catch (Exception e16) {
                QLog.e(ConfigUtil.TAG, 1, e16.getMessage(), e16);
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_URL, "");
                ea.I3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_ENTRANCE, false);
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_SUCCESS_TEXT, "");
                ea.J3(qQAppInterface.getApp(), currentUin, AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_BOLD_TEXT, "");
                MMKVOptionEntity from2 = QMMKV.from(qQAppInterface.getApp(), "common_mmkv_configurations");
                from2.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_URL, "");
                from2.encodeBool(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_ENTRANCE, false);
                from2.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_SUCCESS_TEXT, "");
                from2.encodeString(currentUin + AppConstants.Preferences.ACCOUNT_RELEASE_CONFIG_BOLD_TEXT, "");
            }
            aVar.f202861e = false;
            aVar.f202862f = true;
        }
    }

    public static void c(Context context, String str, String str2, String str3) {
        FileUtils.writeObject(String.format(Locale.getDefault(), "%s_%s_config_content", str, str2), str3);
    }
}
