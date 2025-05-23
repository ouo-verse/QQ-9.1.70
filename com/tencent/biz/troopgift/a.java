package com.tencent.biz.troopgift;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    protected static SharedPreferences a(String str) {
        return BaseApplicationImpl.getApplication().getSharedPreferences("troop_gift_config_" + str, 0);
    }

    public static int b(String str) {
        return a(str).getInt("configVersion", 0);
    }

    public static void c(QQAppInterface qQAppInterface, ConfigurationService$Config configurationService$Config) {
        int size;
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField;
        String stringUtf8;
        String jSONObject;
        String jSONObject2;
        try {
            String currentUin = qQAppInterface.getCurrentUin();
            int b16 = b(currentUin);
            int i3 = configurationService$Config.version.get();
            StringBuilder sb5 = new StringBuilder();
            sb5.append("handleGiftEntryConfig, local=");
            sb5.append(b16);
            sb5.append(" svr=");
            sb5.append(i3);
            sb5.append("content_list_size=");
            PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField2 = configurationService$Config.msg_content_list;
            if (pBRepeatMessageField2 == null) {
                size = 0;
            } else {
                size = pBRepeatMessageField2.size();
            }
            sb5.append(size);
            QLog.d("GiftConfigManager", 1, sb5.toString());
            if (b16 != i3 && (pBRepeatMessageField = configurationService$Config.msg_content_list) != null && pBRepeatMessageField.size() > 0) {
                for (int i16 = 0; i16 < configurationService$Config.msg_content_list.size(); i16++) {
                    QLog.d("GiftConfigManager", 1, "content task_id :" + i16 + ", " + configurationService$Config.msg_content_list.get(i16).task_id.get());
                }
                ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(0);
                if (configurationService$Content != null) {
                    if (configurationService$Content.compress.get() == 1) {
                        byte[] d16 = com.tencent.mobileqq.olympic.utils.a.d(configurationService$Content.content.get().toByteArray());
                        stringUtf8 = null;
                        if (d16 != null) {
                            try {
                                stringUtf8 = new String(d16, "UTF-8");
                            } catch (Exception e16) {
                                QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig|uncompress failed" + e16);
                            }
                        }
                    } else {
                        stringUtf8 = configurationService$Content.content.get().toStringUtf8();
                    }
                    if (stringUtf8 != null) {
                        if (QLog.isColorLevel()) {
                            QLog.i("GiftConfigManager", 2, "handleGiftEntryConfig content" + stringUtf8);
                        }
                        try {
                            JSONObject jSONObject3 = new JSONObject(stringUtf8);
                            JSONObject optJSONObject = jSONObject3.optJSONObject("activityInfo");
                            if (optJSONObject == null) {
                                jSONObject = "";
                            } else {
                                jSONObject = optJSONObject.toString();
                            }
                            d(currentUin, "activityTabInfo", jSONObject);
                            JSONObject optJSONObject2 = jSONObject3.optJSONObject("profileCard");
                            if (optJSONObject2 != null) {
                                JSONObject optJSONObject3 = optJSONObject2.optJSONObject("giftItem");
                                if (optJSONObject3 == null) {
                                    jSONObject2 = "";
                                } else {
                                    jSONObject2 = optJSONObject3.toString();
                                }
                                d(currentUin, "profileCardItem", jSONObject2);
                            } else {
                                d(currentUin, "profileCardItem", "");
                            }
                            JSONObject optJSONObject4 = jSONObject3.optJSONObject("panelEntry");
                            if (optJSONObject4 != null) {
                                d(currentUin, "panelEntry", optJSONObject4.toString());
                            } else {
                                d(currentUin, "panelEntry", "");
                            }
                            e(currentUin, i3);
                            return;
                        } catch (Exception e17) {
                            QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig failed" + e17);
                            return;
                        }
                    }
                    QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig config_content==null");
                }
            }
        } catch (Exception e18) {
            QLog.e("GiftConfigManager", 1, "handleGiftEntryConfig exp:", e18);
        }
    }

    protected static void d(String str, String str2, String str3) {
        a(str).edit().putString(str2, str3).commit();
    }

    protected static void e(String str, int i3) {
        a(str).edit().putInt("configVersion", i3).commit();
    }
}
