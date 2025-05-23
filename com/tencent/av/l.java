package com.tencent.av;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.av.utils.af;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Config;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Content;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfig;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.utils.ea;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.nio.charset.StandardCharsets;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class l {
    /* JADX WARN: Removed duplicated region for block: B:10:0x0094  */
    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(int i3, String str, ConfigurationService$Config configurationService$Config) {
        int r16;
        String c16;
        int i16;
        String str2 = "QAVConfig_" + i3;
        int i17 = configurationService$Config.version.get();
        QQAppInterface qQAppInterface = (QQAppInterface) BaseApplicationImpl.getApplication().getRuntime();
        if (i3 != 149) {
            if (i3 != 180) {
                if (i3 != 218) {
                    c16 = HardCodeUtil.qqStr(R.string.f172346pq0);
                    i16 = -1;
                } else {
                    int g16 = af.g(i3, af.f76962q);
                    String c17 = c(configurationService$Config, g16, i3);
                    if (c17 != null) {
                        af.M(i3, af.f76962q, i17, c17);
                    }
                    c16 = c17;
                    i16 = g16;
                }
                if (!QLog.isDevelopLevel()) {
                    QLog.w(str2, 1, "receiveAllConfigs, ver[" + i16 + "->" + i17 + "], content[\n" + c16 + "\n]");
                    return;
                }
                return;
            }
            r16 = af.g(i3, af.f76962q);
            c16 = c(configurationService$Config, r16, i3);
            if (c16 != null) {
                com.tencent.av.opengl.effects.h.f(qQAppInterface.getApplication(), c16, i17, true);
            }
        } else {
            r16 = ea.r(qQAppInterface.getApplication());
            c16 = c(configurationService$Config, r16, i3);
            if (c16 != null) {
                ea.y3(qQAppInterface.getApplication(), i17);
                SharedPreferences V1 = ea.V1(qQAppInterface.getCurrentAccountUin());
                if (V1 != null) {
                    V1.edit().putString(AppConstants.Preferences.AV_WEAK_NET_VIDEO_CONFIG_CONTENT, c16).commit();
                }
            }
        }
        i16 = r16;
        if (!QLog.isDevelopLevel()) {
        }
    }

    public static void b(int i3, String str, ConfigurationService$ConfigSeq configurationService$ConfigSeq) {
        String str2 = "QAVConfig_" + i3;
        if (i3 != 149) {
            if (i3 == 180 || i3 == 218) {
                configurationService$ConfigSeq.version.set(af.g(i3, af.f76962q));
                configurationService$ConfigSeq.compress.set(1);
            }
        } else {
            configurationService$ConfigSeq.version.set(ea.r(BaseApplication.getContext()));
            configurationService$ConfigSeq.compress.set(1);
        }
        if (QLog.isDevelopLevel()) {
            QLog.w(str2, 1, "addAllConfigs, version[" + configurationService$ConfigSeq.version.get() + "]");
        }
    }

    public static String c(ConfigurationService$Config configurationService$Config, int i3, int i16) {
        int i17;
        String str;
        int i18;
        boolean z16;
        String str2 = "QAVConfig_" + i16;
        PBRepeatMessageField<ConfigurationService$Content> pBRepeatMessageField = configurationService$Config.msg_content_list;
        if (pBRepeatMessageField != null) {
            i17 = pBRepeatMessageField.size();
        } else {
            i17 = -1;
        }
        int i19 = configurationService$Config.version.get();
        QLog.w(str2, 1, "handleCompressConfig, serverVersion[" + i19 + "], localVersion[" + i3 + "], size[" + i17 + "]");
        if (i19 == i3) {
            return null;
        }
        if (i17 <= 0) {
            return "";
        }
        String str3 = null;
        for (int i26 = 0; i26 < i17; i26++) {
            ConfigurationService$Content configurationService$Content = configurationService$Config.msg_content_list.get(i26);
            if (configurationService$Content != null) {
                int i27 = configurationService$Content.task_id.get();
                byte[] byteArray = configurationService$Content.content.get().toByteArray();
                if (configurationService$Content.compress.get() == 1 && (byteArray = com.tencent.mobileqq.ar.i.c(byteArray)) == null && QLog.isDevelopLevel()) {
                    QLog.w(str2, 1, "handleCompressConfig, \u89e3\u538b\u5931\u8d25");
                }
                if (byteArray != null) {
                    str = new String(byteArray, StandardCharsets.UTF_8);
                } else {
                    str = null;
                }
                if (i17 > 1 && !TextUtils.isEmpty(str)) {
                    i18 = d(str);
                } else {
                    i18 = 0;
                }
                StringBuilder sb5 = new StringBuilder();
                sb5.append("handleCompressConfig, task_id[");
                sb5.append(i27);
                sb5.append("|");
                sb5.append(i18);
                sb5.append("], jsonContent[");
                if (str != null) {
                    z16 = true;
                } else {
                    z16 = false;
                }
                sb5.append(z16);
                sb5.append("]");
                QLog.w(str2, 1, sb5.toString());
                if (i18 == i27) {
                    return str;
                }
                str3 = str;
            }
        }
        return str3;
    }

    private static int d(String str) {
        try {
            return new JSONObject(str).optInt("task_id");
        } catch (Exception unused) {
            return 0;
        }
    }

    public static void e(int i3, String str, ConfigurationService$Config configurationService$Config) {
        String str2 = "QAVConfig_" + i3;
        try {
            a(i3, str, configurationService$Config);
        } catch (Exception unused) {
            if (QLog.isDevelopLevel()) {
                QLog.w(str2, 1, "receiveAllConfigs, Exception");
            }
        }
    }

    public static void f(int i3, boolean z16, ConfigurationService$RespGetConfig configurationService$RespGetConfig) {
        String str = "QAVConfig_" + i3;
        if (!z16) {
            QLog.d(str, 2, "receiveConfigFail, timeout");
            return;
        }
        if (configurationService$RespGetConfig.result.get() != 0) {
            QLog.d(str, 2, "receiveConfigFail, result[" + configurationService$RespGetConfig.result.get() + "]");
            return;
        }
        PBRepeatMessageField<ConfigurationService$Config> pBRepeatMessageField = configurationService$RespGetConfig.config_list;
        if (pBRepeatMessageField == null || pBRepeatMessageField.size() == 0) {
            QLog.d(str, 2, "receiveConfigFail, config_list is null");
        }
    }
}
