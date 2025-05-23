package com.tencent.mobileqq.config.business;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mini.api.ISplashMiniGameStarterService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.app.AppRuntime;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes10.dex */
public class MiniAppConfBean {

    /* renamed from: a, reason: collision with root package name */
    private boolean f202438a = true;

    /* renamed from: b, reason: collision with root package name */
    private int f202439b = 60;

    /* renamed from: c, reason: collision with root package name */
    private boolean f202440c = false;

    /* renamed from: d, reason: collision with root package name */
    private boolean f202441d = false;

    /* renamed from: e, reason: collision with root package name */
    private boolean f202442e = false;

    /* renamed from: f, reason: collision with root package name */
    private boolean f202443f = false;

    /* renamed from: g, reason: collision with root package name */
    private ArrayList<Integer> f202444g = new ArrayList<Integer>() { // from class: com.tencent.mobileqq.config.business.MiniAppConfBean.1
        {
            add(1044);
            add(1007);
            add(1008);
            add(2003);
        }
    };

    /* renamed from: h, reason: collision with root package name */
    private String f202445h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f202446i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f202447j = "";

    /* renamed from: k, reason: collision with root package name */
    private String f202448k = "";

    /* renamed from: l, reason: collision with root package name */
    private String f202449l = "";

    /* renamed from: m, reason: collision with root package name */
    private String f202450m = "";

    public static MiniAppConfBean f(com.tencent.mobileqq.config.ai[] aiVarArr) {
        String str;
        String str2;
        String[] strArr;
        String str3;
        boolean z16;
        boolean z17;
        boolean z18;
        boolean z19;
        boolean z26;
        com.tencent.mobileqq.config.ai[] aiVarArr2 = aiVarArr;
        String str4 = "back_to_home_scene_list";
        String str5 = "mini_app_refresh_time";
        MiniAppConfBean miniAppConfBean = new MiniAppConfBean();
        StringBuilder sb5 = new StringBuilder();
        int i3 = 0;
        while (i3 < aiVarArr2.length) {
            try {
                String str6 = aiVarArr2[i3].f202268b;
                if (str6 == null) {
                    str2 = str4;
                    str = str5;
                } else {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (jSONObject.has("mini_app_local_search")) {
                        if (jSONObject.optInt("mini_app_local_search", 1) == 1) {
                            z26 = true;
                        } else {
                            z26 = false;
                        }
                        miniAppConfBean.f202438a = z26;
                    }
                    if (jSONObject.has(str5)) {
                        miniAppConfBean.f202439b = jSONObject.optInt(str5, 60);
                    }
                    str = str5;
                    if (jSONObject.has("popBarShowMiniAppStore")) {
                        if (jSONObject.optInt("popBarShowMiniAppStore", 0) == 1) {
                            z19 = true;
                        } else {
                            z19 = false;
                        }
                        miniAppConfBean.f202440c = z19;
                    }
                    if (jSONObject.has("minigame_splash")) {
                        ((ISplashMiniGameStarterService) QRoute.api(ISplashMiniGameStarterService.class)).saveConfigData(str6);
                    }
                    if (jSONObject.has("mini_app_entry_auto_show")) {
                        if (jSONObject.optInt("mini_app_entry_auto_show", 0) == 1) {
                            z18 = true;
                        } else {
                            z18 = false;
                        }
                        miniAppConfBean.f202441d = z18;
                    }
                    if (jSONObject.has("contact_mini_app_on")) {
                        if (jSONObject.optInt("contact_mini_app_on", 0) == 1) {
                            z17 = true;
                        } else {
                            z17 = false;
                        }
                        miniAppConfBean.f202443f = z17;
                    }
                    if (jSONObject.has("more_mini_app_on")) {
                        if (jSONObject.optInt("more_mini_app_on", 0) == 1) {
                            z16 = true;
                        } else {
                            z16 = false;
                        }
                        miniAppConfBean.f202442e = z16;
                    }
                    if (jSONObject.has(str4)) {
                        if (miniAppConfBean.f202444g == null) {
                            miniAppConfBean.f202444g = new ArrayList<>();
                        }
                        miniAppConfBean.f202444g.clear();
                        String[] split = jSONObject.optString(str4, "1044|1007|1008|2003").split("\\|");
                        int length = split.length;
                        int i16 = 0;
                        while (i16 < length) {
                            String str7 = split[i16];
                            if (!TextUtils.isEmpty(str7)) {
                                strArr = split;
                                str3 = str4;
                                miniAppConfBean.f202444g.add(Integer.valueOf(str7));
                            } else {
                                strArr = split;
                                str3 = str4;
                            }
                            i16++;
                            split = strArr;
                            str4 = str3;
                        }
                    }
                    str2 = str4;
                    if (1 == jSONObject.optInt("enable_c2c_plus_panel", 0)) {
                        miniAppConfBean.f202445h = jSONObject.optString("url", "");
                        miniAppConfBean.f202446i = jSONObject.optString("icon", "");
                        miniAppConfBean.f202447j = jSONObject.optString("icon_night", "");
                        miniAppConfBean.f202448k = jSONObject.optString("simple_icon", "");
                        miniAppConfBean.f202449l = jSONObject.optString("simple_icon_night", "");
                        miniAppConfBean.f202450m = jSONObject.optString("name", BaseApplicationImpl.sApplication.getString(R.string.f7c));
                        AppRuntime runtime = BaseApplicationImpl.getApplication().getRuntime();
                        if (runtime instanceof QQAppInterface) {
                        }
                    }
                    sb5.append("config: ");
                    sb5.append(str6);
                    sb5.append(",");
                }
                i3++;
                aiVarArr2 = aiVarArr;
                str5 = str;
                str4 = str2;
            } catch (Exception e16) {
                QLog.d("MiniAppConfProcessor", 2, "parse, failed!");
                e16.printStackTrace();
                return null;
            }
        }
        QLog.e("MiniAppConfProcessor", 2, "parse, content:" + sb5.toString());
        return miniAppConfBean;
    }

    public ArrayList<Integer> a() {
        return this.f202444g;
    }

    public int b() {
        return this.f202439b;
    }

    public boolean c() {
        return this.f202438a;
    }

    public boolean d() {
        return this.f202443f;
    }

    public boolean e() {
        return this.f202440c;
    }

    public String toString() {
        return super.toString();
    }
}
