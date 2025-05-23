package com.tencent.mobileqq.weather.api.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.MMKVOptionEntity;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.weather.api.IWeatherRuntimeService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.observer.BusinessObserver;
import p43.a;

/* compiled from: P */
/* loaded from: classes20.dex */
public class WeatherRuntimeServiceImpl implements IWeatherRuntimeService, BusinessObserver {
    static IPatchRedirector $redirector_ = null;
    private static final String KEY_WEATHER_RES_VERSION = "key_weather_res_version";
    public static final String MINI_APP_WEATHER_URL = "mqqapi://miniapp/open?_atype=0&_mappid=1108323226&_mvid=&_path=pages%2Findex%2Findex&_vt=3&referer=2066&_sig=191577ab932c397857a3cb26aa1938bfa257d305ad390c43ae02ca77df0753e7";
    public static final String TAG = "weatherManager";
    private static final String WEATHER_RESOURCES_SP = "weather_resources";
    public static String WEATHER_RESOURCE_PATH;
    private boolean hasUpdate;
    private AppInterface mApp;
    private MMKVOptionEntity mMMKVEntity;
    private a mWeatherUpdateListener;

    public WeatherRuntimeServiceImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.hasUpdate = false;
        }
    }

    public static String getWeatherResource(String str) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(WEATHER_RESOURCE_PATH);
        String str2 = File.separator;
        sb5.append(str2);
        sb5.append("WeatherResource");
        sb5.append(str2);
        sb5.append(str);
        sb5.append("_bg.jpg");
        return sb5.toString();
    }

    private boolean isValidType(int i3) {
        if (i3 != 6666 && i3 != 8888) {
            return false;
        }
        return true;
    }

    public static boolean isWeatherResourceExist(String str) {
        if (QLog.isColorLevel()) {
            QLog.d("qq_weather", 2, "isWeatherResourceExist jpgfilepath: " + getWeatherResource(str));
        }
        return FileUtils.fileExistsAndNotEmpty(getWeatherResource(str));
    }

    private void storeWeatherInfo(Bundle bundle) {
        String str;
        String string = bundle.getString("KEY_TEMPER");
        String string2 = bundle.getString("area_info");
        int i3 = bundle.getInt("adcode");
        String string3 = bundle.getString("o_wea_code");
        String string4 = bundle.getString("wea_desc");
        String string5 = bundle.getString("drawer_up_text");
        String string6 = bundle.getString("drawer_up_simple_text");
        String string7 = bundle.getString("drawer_up_experiment_text");
        String string8 = bundle.getString("drawer_down_text");
        int i16 = bundle.getInt("drawer_up_type");
        int i17 = bundle.getInt("drawer_up_simple_type");
        int i18 = bundle.getInt("drawer_up_experiment_type");
        int i19 = bundle.getInt("show_flag");
        int i26 = bundle.getInt("drawer_warning_count");
        if (!QLog.isColorLevel()) {
            str = "drawer_warning_count";
        } else {
            StringBuilder sb5 = new StringBuilder();
            str = "drawer_warning_count";
            sb5.append("onReceive show_flag:");
            sb5.append(i19);
            sb5.append(",temp:");
            sb5.append(string);
            sb5.append(",area_name");
            sb5.append(string2);
            sb5.append("adcode");
            sb5.append(i3);
            sb5.append(",oWeaCode");
            sb5.append(string3);
            QLog.d("WeatherSetting", 2, sb5.toString());
        }
        if (i19 == 1) {
            if (string != null && !string.equals("") && !TextUtils.isEmpty(string2)) {
                Long valueOf = Long.valueOf(System.currentTimeMillis());
                this.mMMKVEntity.encodeLong("pa_send_time", valueOf.longValue());
                this.mMMKVEntity.encodeString("cur_temp", string);
                this.mMMKVEntity.encodeString("cur_code", string3);
                this.mMMKVEntity.encodeString("cur_city", string2);
                this.mMMKVEntity.encodeBool("show_flag", true);
                this.mMMKVEntity.encodeLong("drawer_last_success_time", valueOf.longValue());
                this.mMMKVEntity.encodeString("drawer_cur_city", string2);
                this.mMMKVEntity.encodeString("drawer_cur_temp", string);
                this.mMMKVEntity.encodeInt("drawer_cur_adcode", i3);
                this.mMMKVEntity.encodeString("drawer_cur_code", string3);
                this.mMMKVEntity.encodeString("drawer_cur_desc", string4);
                this.mMMKVEntity.encodeBool("drawer_show_flag", true);
                this.mMMKVEntity.encodeInt("drawer_up_type", i16);
                this.mMMKVEntity.encodeInt("drawer_up_simple_type", i17);
                this.mMMKVEntity.encodeInt("drawer_up_experiment_type", i18);
                this.mMMKVEntity.encodeString("drawer_up_text", string5);
                this.mMMKVEntity.encodeString("drawer_up_simple_text", string6);
                this.mMMKVEntity.encodeString("drawer_up_experiment_text", string7);
                this.mMMKVEntity.encodeString("drawer_down_text", string8);
                this.mMMKVEntity.encodeInt(str, i26);
                for (int i27 = 0; i27 < i26; i27++) {
                    String str2 = "drawer_warning_icon_" + i27;
                    String str3 = "drawer_warning_name_" + i27;
                    String str4 = "drawer_warning_color_" + i27;
                    String str5 = "drawer_warning_level_" + i27;
                    this.mMMKVEntity.encodeString(str2, bundle.getString(str2));
                    this.mMMKVEntity.encodeString(str3, bundle.getString(str3));
                    this.mMMKVEntity.encodeString(str4, bundle.getString(str4));
                    this.mMMKVEntity.encodeString(str5, bundle.getString(str5));
                }
                return;
            }
            return;
        }
        if (i19 == 0) {
            this.mMMKVEntity.encodeBool("show_flag", false);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherRuntimeService
    public long getConfigVersion() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        long decodeLong = this.mMMKVEntity.decodeLong(KEY_WEATHER_RES_VERSION, 0L);
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "getConfigVersion version=" + decodeLong);
        }
        return decodeLong;
    }

    @Override // mqq.app.api.IRuntimeService
    public void onCreate(AppRuntime appRuntime) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appRuntime);
            return;
        }
        this.mApp = (AppInterface) appRuntime;
        BaseApplication context = BaseApplication.getContext();
        WEATHER_RESOURCE_PATH = context.getFilesDir().getAbsoluteFile() + File.separator + "WeatherResource";
        this.mMMKVEntity = QMMKV.from(context.getApplicationContext(), "vas_mmkv_configurations");
        appRuntime.registObserver(this);
    }

    @Override // mqq.app.api.IRuntimeService
    public void onDestroy() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this);
            return;
        }
        AppInterface appInterface = this.mApp;
        if (appInterface != null) {
            appInterface.unRegistObserver(this);
            this.mApp = null;
        }
    }

    @Override // mqq.observer.BusinessObserver
    public void onReceive(int i3, boolean z16, Bundle bundle) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, this, Integer.valueOf(i3), Boolean.valueOf(z16), bundle);
            return;
        }
        if (bundle == null) {
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "WeatherManager onReceive type:" + i3, ",bundle:", bundle);
        }
        if (!isValidType(i3)) {
            return;
        }
        if (z16) {
            storeWeatherInfo(bundle);
        }
        a aVar = this.mWeatherUpdateListener;
        if (aVar != null) {
            aVar.a(i3, z16, bundle);
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherRuntimeService
    public void setWeatherUpdateListener(a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) aVar);
        } else {
            this.mWeatherUpdateListener = aVar;
        }
    }

    @Override // com.tencent.mobileqq.weather.api.IWeatherRuntimeService
    public boolean unzipResource(long j3, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        boolean z16 = true;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, this, Long.valueOf(j3), str)).booleanValue();
        }
        try {
            FileUtils.delete(WEATHER_RESOURCE_PATH, false);
            FileUtils.uncompressZip(str, WEATHER_RESOURCE_PATH, false);
        } catch (Exception e16) {
            e16.printStackTrace();
            if (QLog.isColorLevel()) {
                QLog.e(TAG, 2, "pareseRulesFromZip : delete and uncompress Exception=>", e16);
            }
            z16 = false;
        }
        if (z16) {
            updateResourceVersion(j3);
        } else if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "pareseRulesFromZip : delete and uncompressZip failure, parse from Res");
        }
        return z16;
    }

    public void updateResourceVersion(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, j3);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "updateResourceVersion version=" + j3);
        }
        this.mMMKVEntity.encodeLong(KEY_WEATHER_RES_VERSION, j3);
    }
}
