package com.tencent.mobileqq.vas.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.vas.VasLogReportProxy;
import com.tencent.mobileqq.vas.VasLogReporter;
import com.tencent.mobileqq.vas.VasMMKV;
import com.tencent.mobileqq.vas.quickupdate.ChatBackgroundBusiness;
import com.tencent.mobileqq.vas.report.VasCommonReporter;
import com.tencent.mobileqq.vas.theme.diy.ThemeDiyStyleLogic;
import com.tencent.mobileqq.vas.updatesystem.business.QQVasUpdateBusiness;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;
import java.util.regex.Pattern;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ChatBackgroundUtil {
    public static final String CUSTOM = "custom";
    public static final String DEFAULT = "null";
    public static final String IS_C2C_SET = "_is_c2c_set";
    public static final String UIN_TYPE = "_uinType";

    public static String getChatBackgroundPath(Context context, String str, String str2) {
        SharedPreferences mMKVData = getMMKVData(context, str);
        if (TextUtils.isEmpty(str2)) {
            String string = mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, null);
            if (TextUtils.isEmpty(string)) {
                return "null";
            }
            return ThemeDiyStyleLogic.getDiyVFSPath(string);
        }
        String string2 = mMKVData.getString(str2, null);
        if (string2 == null && (string2 = mMKVData.getString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, null)) == null) {
            string2 = "null";
        }
        if (string2.trim().length() == 0 || string2.equals("null") || string2.equals("none")) {
            return "null";
        }
        return ThemeDiyStyleLogic.getDiyVFSPath(string2);
    }

    public static String getId(String str) {
        if (str == null || str.trim().length() == 0 || str.equals("null") || str.equals("none")) {
            return "null";
        }
        String idFromPath = ChatBackgroundBusiness.getIdFromPath(str);
        if (TextUtils.isEmpty(idFromPath)) {
            return "custom";
        }
        return idFromPath;
    }

    public static SharedPreferences getMMKVData(Context context, String str) {
        boolean z16;
        SharedPreferences chatBg = VasMMKV.getChatBg(context, "chat_background_path_" + str);
        if (DiySecureFileHelper.getVersion(DiySecureFileHelper.KEY_CHAT_BACKGROUND, str) < 1) {
            SharedPreferences.Editor edit = chatBg.edit();
            QLog.d(DiySecureFileHelper.TAG, 1, "Move Chatbackground SharedPreferences");
            if (chatBg.getAll() != null) {
                z16 = false;
                for (Map.Entry<String, ?> entry : chatBg.getAll().entrySet()) {
                    if (entry.getValue() instanceof String) {
                        String str2 = (String) entry.getValue();
                        if (str2 != null) {
                            if (str2.contains("/custom_background/" + str + "/")) {
                                edit.putString(entry.getKey(), str2.replace("/custom_background/" + str + "/", "/custom_background/" + DiySecureFileHelper.secureUin(str) + "/"));
                                z16 = true;
                            }
                        }
                        if (str2 != null) {
                            if (str2.contains("/" + str + "/custom_background/")) {
                                edit.putString(entry.getKey(), str2.replace("/" + str + "/custom_background/", "/custom_background/" + DiySecureFileHelper.secureUin(str) + "/"));
                                z16 = true;
                            }
                        }
                    } else {
                        String key = entry.getKey();
                        if (key != null) {
                            if (key.contains("/custom_background/" + str + "/")) {
                                if (entry.getValue() instanceof Integer) {
                                    edit.putInt(key.replace("/custom_background/" + str + "/", "/custom_background/" + DiySecureFileHelper.secureUin(str) + "/"), ((Integer) entry.getValue()).intValue());
                                    z16 = true;
                                } else {
                                    QLog.e(DiySecureFileHelper.TAG, 1, "value not int : " + entry.getValue());
                                }
                            }
                        }
                        if (key != null) {
                            if (key.contains("/" + str + "/custom_background/")) {
                                if (entry.getValue() instanceof Integer) {
                                    edit.putInt(key.replace("/" + str + "/custom_background/", "/custom_background/" + DiySecureFileHelper.secureUin(str) + "/"), ((Integer) entry.getValue()).intValue());
                                    z16 = true;
                                } else {
                                    QLog.e(DiySecureFileHelper.TAG, 1, "value not int : " + entry.getValue());
                                }
                            }
                        }
                    }
                }
            } else {
                QLog.e(DiySecureFileHelper.TAG, 1, "sf.getAll is null");
                z16 = false;
            }
            if (z16) {
                edit.commit();
                VasCommonReporter.getHistoryFeature().setValue1("chat_backgroud_sp_move").setValue2("sp").report(false);
            }
            DiySecureFileHelper.commitVersion(DiySecureFileHelper.KEY_CHAT_BACKGROUND, str, 1);
        }
        return chatBg;
    }

    public static String getShopBgPath(String str) {
        return ((ChatBackgroundBusiness) QQVasUpdateBusiness.getBusiness(ChatBackgroundBusiness.class)).getPicturePath(Integer.parseInt(str));
    }

    public static final void setChatBackground(Context context, String str, String str2, String str3) {
        setChatBackground(context, str, str2, str3, -1);
    }

    public static final void setChatBackground(Context context, String str, String str2, String str3, int i3) {
        setChatBackground(context, str, str2, str3, 0, i3);
    }

    public static final void setChatBackground(Context context, String str, String str2, String str3, int i3, int i16) {
        if (QLog.isColorLevel()) {
            QLog.d(VasLogReporter.getChatBackground().getReportTag(), 1, new Throwable(), new Object[0]);
        }
        VasLogReportProxy chatBackground = VasLogReporter.getChatBackground();
        StringBuilder sb5 = new StringBuilder();
        sb5.append("set : friendUin=");
        sb5.append(!TextUtils.isEmpty(str2));
        sb5.append(", path=");
        sb5.append(str3);
        chatBackground.reportDebug(sb5.toString());
        SharedPreferences mMKVData = getMMKVData(context, str);
        SharedPreferences.Editor edit = mMKVData.edit();
        if (TextUtils.isEmpty(str2)) {
            edit.putString(AppConstants.Preferences.CHAT_UNIFORM_BG_PATH, str3);
            edit.putInt(AppConstants.Preferences.CHAT_BG_EFFECT, i3);
            Map<String, ?> all = mMKVData.getAll();
            if (all != null) {
                for (String str4 : all.keySet()) {
                    if (Pattern.compile("[0-9]*").matcher(str4).matches()) {
                        String string = mMKVData.getString(str4, "null");
                        boolean z16 = mMKVData.getBoolean(str4 + IS_C2C_SET, false);
                        if (string == null || string.trim().length() == 0 || string.equals("null") || string.equals("none") || !z16) {
                            edit.putString(str4, str3);
                            edit.putInt(str4 + AppConstants.Preferences.CHAT_BG_EFFECT, i3);
                        }
                    }
                }
            }
        } else {
            edit.putString(str2, str3);
            edit.putInt(str2 + UIN_TYPE, i16);
            if (str3.equals("null")) {
                edit.putBoolean(str2 + IS_C2C_SET, false);
                edit.remove(str2 + AppConstants.Preferences.CHAT_BG_EFFECT);
            } else {
                edit.putBoolean(str2 + IS_C2C_SET, true);
                edit.putInt(str2 + AppConstants.Preferences.CHAT_BG_EFFECT, i3);
            }
        }
        edit.commit();
    }
}
