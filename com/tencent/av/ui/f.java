package com.tencent.av.ui;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.avcore.data.AVCoreSystemInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.openapi.offlineset.AEOfflineConfig;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a, reason: collision with root package name */
    private static String f75605a = "QAVPreSetting";

    /* renamed from: b, reason: collision with root package name */
    private static String f75606b = "BeautyFeature";

    /* renamed from: c, reason: collision with root package name */
    private static String f75607c = "BeautyConfig";

    /* renamed from: d, reason: collision with root package name */
    private static String f75608d = "BeautyV7Config";

    /* renamed from: e, reason: collision with root package name */
    private static String f75609e = "BeautyResetGuide";

    public static String a(String str) {
        String str2;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(f75605a, 0);
        if (d()) {
            str2 = f75608d + str;
        } else {
            str2 = f75607c + str;
        }
        return sharedPreferences.getString(str2, "");
    }

    public static int b(String str) {
        return BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(f75605a, 0).getInt(f75609e + str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v2, types: [int, boolean] */
    public static boolean c(String str) {
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences(f75605a, 0);
        String str2 = f75606b;
        int i3 = sharedPreferences.getInt(str2, -1);
        int i16 = i3;
        if (i3 == -1) {
            ?? isBeautySupported = AVCoreSystemInfo.isBeautySupported();
            sharedPreferences.edit().putInt(str2, isBeautySupported).commit();
            i16 = isBeautySupported;
        }
        if (i16 < 1) {
            return false;
        }
        return true;
    }

    public static boolean d() {
        if (AEModule.getContext() == null) {
            AEModule.setContext(BaseApplication.context);
        }
        int phonePerfLevel = AEOfflineConfig.getPhonePerfLevel();
        int t16 = com.tencent.av.utils.af.t();
        if (QLog.isColorLevel()) {
            QLog.i("BeautyConfigUtil", 2, "current phone perf level: " + phonePerfLevel + " current support level " + t16);
        }
        if (phonePerfLevel >= t16) {
            return true;
        }
        return false;
    }

    public static boolean e() {
        if (AEOfflineConfig.getPhonePerfLevel() <= 4) {
            return true;
        }
        return false;
    }

    public static void f(String str) {
        if (QLog.isColorLevel()) {
            QLog.i("BeautyConfigUtil", 2, "parseAndSave content: " + str);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                g(new JSONObject(str).getJSONObject("V7"));
            } catch (JSONException e16) {
                QLog.e("BeautyConfigUtil", 2, "parseAndSave exception: ", e16);
            }
        }
    }

    public static void g(JSONObject jSONObject) {
        if (jSONObject != null) {
            SharedPreferences.Editor edit = com.tencent.av.utils.af.d(com.tencent.luggage.wxa.uf.g.CTRL_INDEX, com.tencent.av.utils.af.f76962q).edit();
            Iterator<String> it = com.tencent.av.opengl.effects.f.f73973c.iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (jSONObject.has(next)) {
                    try {
                        int i3 = jSONObject.getInt(next);
                        edit.putInt("V7_" + next, i3);
                        if (QLog.isColorLevel()) {
                            QLog.i("BeautyConfigUtil", 2, "parseAndSaveV7 [V7_" + next + "] value: " + i3);
                        }
                    } catch (JSONException e16) {
                        QLog.e("BeautyConfigUtil", 2, "parseAndSaveV7 exception: ", e16);
                    }
                }
            }
            edit.apply();
        }
    }

    public static void h(String str, String str2) {
        String str3;
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(f75605a, 0);
        if (d()) {
            str3 = f75608d + str;
        } else {
            str3 = f75607c + str;
        }
        sharedPreferences.edit().putString(str3, str2).apply();
    }

    public static void i(String str, int i3) {
        BaseApplicationImpl.getApplication().getApplicationContext().getSharedPreferences(f75605a, 0).edit().putInt(f75609e + str, i3).apply();
    }
}
