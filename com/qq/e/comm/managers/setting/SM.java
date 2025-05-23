package com.qq.e.comm.managers.setting;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.constants.Constants;
import com.qq.e.comm.managers.GDTADManager;
import com.qq.e.comm.managers.setting.c;
import com.qq.e.comm.util.GDTLogger;
import com.qq.e.comm.util.StringUtil;
import com.qq.e.comm.util.SystemUtil;
import com.qq.e.comm.util.TimeRecorder;
import java.io.File;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class SM {

    /* renamed from: b, reason: collision with root package name */
    private String f38221b;

    /* renamed from: c, reason: collision with root package name */
    private c f38222c;

    /* renamed from: e, reason: collision with root package name */
    private String f38224e;

    /* renamed from: f, reason: collision with root package name */
    private b f38225f;

    /* renamed from: h, reason: collision with root package name */
    private Context f38227h;

    /* renamed from: a, reason: collision with root package name */
    private c f38220a = new c();

    /* renamed from: d, reason: collision with root package name */
    private c f38223d = new c();

    /* renamed from: g, reason: collision with root package name */
    private b f38226g = new a();

    /* renamed from: i, reason: collision with root package name */
    private String f38228i = SystemUtil.buildNewPathByProcessName(Constants.SETTING.SETTINGDIR);

    public SM(Context context) {
        this.f38227h = context;
        if (GDTLogger.isEnableConsoleLog()) {
            GDTLogger.d("TimeStap_BEFORE_SettingManager_INIT:" + System.currentTimeMillis());
        }
        if (GDTLogger.isEnableConsoleLog()) {
            GDTLogger.d("TimeStap_AFTER_SettingManager_INIT:" + System.currentTimeMillis());
        }
    }

    private void a() {
        c.b b16 = c.b(this.f38227h);
        if (b16 != null) {
            this.f38224e = b16.a();
            this.f38225f = b16.b();
        } else {
            GDTLogger.d("Load Local SDK Cloud setting fail");
        }
    }

    private void b() {
        c.a a16 = c.a(this.f38227h);
        if (a16 != null) {
            this.f38222c = a16.b();
            this.f38221b = a16.a();
        } else {
            GDTLogger.d("Load Local DEV Cloud setting fail");
        }
    }

    public void doLoadConfig() {
        a();
        b();
    }

    public Object get(String str) {
        Object a16;
        Object a17;
        Object a18;
        Object a19;
        if (StringUtil.isEmpty(str)) {
            return null;
        }
        try {
            c cVar = this.f38220a;
            if (cVar != null && (a19 = cVar.a(str)) != null) {
                return a19;
            }
            c cVar2 = this.f38222c;
            if (cVar2 != null && (a18 = cVar2.a(str)) != null) {
                return a18;
            }
            c cVar3 = this.f38223d;
            if (cVar3 != null && (a17 = cVar3.a(str)) != null) {
                return a17;
            }
            b bVar = this.f38225f;
            if (bVar != null && (a16 = bVar.a(str)) != null) {
                return a16;
            }
            b bVar2 = this.f38226g;
            if (bVar2 != null) {
                return bVar2.a(str);
            }
            return null;
        } catch (Throwable th5) {
            GDTLogger.report("Exception in settingManager.get Setting for key:" + str, th5);
            return null;
        }
    }

    public Object getCloudSetting() {
        if (GDTLogger.isEnableConsoleLog()) {
            return this.f38225f;
        }
        return null;
    }

    public String getDevCloudSettingSig() {
        return this.f38221b;
    }

    public Object getForPlacement(String str, String str2) {
        Object a16;
        Object a17;
        Object a18;
        if (!StringUtil.isEmpty(str) && !StringUtil.isEmpty(str2)) {
            try {
                c cVar = this.f38220a;
                if (cVar != null && (a18 = cVar.a(str, str2)) != null) {
                    return a18;
                }
                c cVar2 = this.f38222c;
                if (cVar2 != null && (a17 = cVar2.a(str, str2)) != null) {
                    return a17;
                }
                c cVar3 = this.f38223d;
                if (cVar3 != null && (a16 = cVar3.a(str, str2)) != null) {
                    return a16;
                }
                return get(str);
            } catch (Throwable th5) {
                GDTLogger.report("Exception in settingManager.getForPlacement", th5);
            }
        }
        return null;
    }

    public int getInteger(String str, int i3) {
        Object obj = get(str);
        if (obj != null && (obj instanceof Integer)) {
            return ((Integer) obj).intValue();
        }
        return i3;
    }

    public int getIntegerForPlacement(String str, String str2, int i3) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement != null && (forPlacement instanceof Integer)) {
            return ((Integer) forPlacement).intValue();
        }
        return i3;
    }

    public long getLong(String str, long j3) {
        Object obj = get(str);
        if (obj != null && (obj instanceof Long)) {
            return ((Long) obj).longValue();
        }
        return j3;
    }

    public long getLongForPlacement(String str, String str2, long j3) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement != null && (forPlacement instanceof Long)) {
            return ((Long) forPlacement).longValue();
        }
        return j3;
    }

    public Object getOnlyForPlacement(String str, String str2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            c cVar = this.f38222c;
            if (cVar != null && (jSONObject = (JSONObject) cVar.a(str)) != null) {
                return jSONObject.get(str2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return null;
    }

    public String getSdkCloudSettingSig() {
        return this.f38224e;
    }

    public String getSettingDir() {
        return this.f38228i;
    }

    public String getString(String str) {
        Object obj = get(str);
        if (obj == null) {
            return null;
        }
        return obj.toString();
    }

    public String getStringForPlacement(String str, String str2) {
        Object forPlacement = getForPlacement(str, str2);
        if (forPlacement == null) {
            return null;
        }
        return forPlacement.toString();
    }

    public int loadWujiSeqConfig() {
        try {
            GDTLogger.d("Load wuji seq config");
            File dir = GDTADManager.getInstance().getAppContext().getDir(GDTADManager.getInstance().getSM().getSettingDir(), 0);
            if (!dir.exists()) {
                return 0;
            }
            String readAll = StringUtil.readAll(new File(dir, "gdt_config_wuji.ncfg"));
            if (TextUtils.isEmpty(readAll)) {
                GDTLogger.d("Empty local seq encrypt config");
                return 0;
            }
            int optInt = new JSONObject(readAll).optInt("seq", 0);
            GDTLogger.d("Load wuji_seq: " + optInt);
            return optInt;
        } catch (Exception e16) {
            GDTLogger.e("Exception while load seq", e16);
            return 0;
        }
    }

    public void reset() {
        this.f38225f.a();
    }

    public void setDEVCodeSetting(String str, Object obj) {
        this.f38223d.a(str, obj);
    }

    public void updateDEVCloudSetting(String str, String str2) {
        TimeRecorder.getInstance().record("config_update_start0");
        com.qq.e.comm.a.a(0);
        if (c.b(this.f38227h, str, str2)) {
            b();
            com.qq.e.comm.a.b(TimeRecorder.getInstance().costFrom("config_update_start0"), 0);
        } else {
            com.qq.e.comm.a.c(TimeRecorder.getInstance().costFrom("config_update_start0"), 1009);
        }
    }

    public void updateSDKCloudSetting(String str, String str2) {
        TimeRecorder.getInstance().record("config_update_start1");
        com.qq.e.comm.a.a(1);
        if (c.a(this.f38227h, str, str2)) {
            a();
            com.qq.e.comm.a.b(TimeRecorder.getInstance().costFrom("config_update_start1"), 1);
        } else {
            com.qq.e.comm.a.c(TimeRecorder.getInstance().costFrom("config_update_start1"), 1010);
        }
    }

    public Object get(String str, String str2) {
        JSONObject jSONObject;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            c cVar = this.f38222c;
            if (cVar != null && (jSONObject = (JSONObject) cVar.a(str)) != null) {
                return jSONObject.get(str2);
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return get(str2);
    }

    public void setDEVCodeSetting(String str, Object obj, String str2) {
        this.f38223d.a(str, obj, str2);
    }
}
