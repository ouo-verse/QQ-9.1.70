package com.tencent.mobileqq.tianshu.ui;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes18.dex */
public class b {
    static IPatchRedirector $redirector_;

    public static int a(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return 0;
        }
        try {
            return appInfo.num.get();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static int b(BusinessInfoCheckUpdate.RedTypeInfo redTypeInfo) {
        if (redTypeInfo == null) {
            return 0;
        }
        try {
            return Integer.valueOf(Integer.parseInt(redTypeInfo.red_content.get())).intValue();
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean c(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null || appInfo.iNewFlag.get() == 0 || appInfo.red_display_info.get() == null || appInfo.red_display_info.red_type_info.get() == null) {
            return false;
        }
        return true;
    }

    public static boolean d(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return false;
        }
        if ((c(appInfo) || e(appInfo).booleanValue()) && appInfo.extend.has()) {
            try {
                JSONObject jSONObject = new JSONObject(appInfo.extend.get());
                if (jSONObject.has("busi_id")) {
                    if (jSONObject.getString("busi_id").equals("tinyworld_guide")) {
                        return true;
                    }
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static Boolean e(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return Boolean.FALSE;
        }
        if (appInfo.type.get() == 8 && appInfo.num.get() > 0 && appInfo.iNewFlag.get() != 0) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public static String f(BusinessInfoCheckUpdate.AppInfo appInfo) {
        if (appInfo == null) {
            return "null appInfo";
        }
        StringBuilder sb5 = new StringBuilder(50);
        sb5.append("AppInfo");
        sb5.append("path=");
        sb5.append(appInfo.path.get());
        sb5.append(" ");
        sb5.append("type=");
        sb5.append(appInfo.type.get());
        sb5.append(" ");
        sb5.append("iNewFlag=");
        sb5.append(appInfo.iNewFlag.get());
        sb5.append(" ");
        sb5.append("click_max=");
        sb5.append(appInfo.click_max.get());
        sb5.append(" ");
        sb5.append("num=");
        sb5.append(appInfo.num.get());
        sb5.append(" ");
        sb5.append("mission_level=");
        sb5.append(appInfo.mission_level.get());
        sb5.append(" ");
        sb5.append("delay_show=");
        sb5.append(appInfo.delay_show.get());
        sb5.append(" ");
        sb5.append("exposure_max=");
        sb5.append(appInfo.exposure_max.get());
        return sb5.toString();
    }
}
