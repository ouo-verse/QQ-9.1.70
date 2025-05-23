package com.tencent.mobileqq.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.haoliyou.orion.XorCipher;
import com.tencent.mobileqq.haoliyou.orion.XorCipherException;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClientConstants;
import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class bg {

    /* renamed from: b, reason: collision with root package name */
    private static bg f307489b;

    /* renamed from: a, reason: collision with root package name */
    private ConcurrentHashMap<String, String> f307490a = new ConcurrentHashMap<>();

    public bg() {
        String e16 = e();
        int d16 = d();
        if (!TextUtils.isEmpty(e16)) {
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "LocalConfig: version= " + d16);
            }
            l(e16);
        }
    }

    public static HashSet<String> b(Activity activity) {
        ComponentName callingActivity;
        if (activity != null && !activity.isFinishing()) {
            HashSet<String> hashSet = new HashSet<>();
            try {
                Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                String str = (String) declaredField.get(activity);
                if (!TextUtils.isEmpty(str)) {
                    hashSet.add(str);
                }
            } catch (Exception unused) {
            }
            try {
                Uri referrer = activity.getReferrer();
                if (referrer != null) {
                    String authority = referrer.getAuthority();
                    if (!TextUtils.isEmpty(authority)) {
                        hashSet.add(authority);
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                String callingPackage = activity.getCallingPackage();
                if (TextUtils.isEmpty(callingPackage) && (callingActivity = activity.getCallingActivity()) != null) {
                    callingPackage = callingActivity.getPackageName();
                }
                if (!TextUtils.isEmpty(callingPackage)) {
                    hashSet.add(callingPackage);
                }
            } catch (Exception unused3) {
            }
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "getCallerReferrerPkg :");
            }
            return hashSet;
        }
        return null;
    }

    public static String c(Activity activity) {
        ComponentName callingActivity;
        if (activity != null && !activity.isFinishing()) {
            try {
                Field declaredField = Class.forName("android.app.Activity").getDeclaredField("mReferrer");
                declaredField.setAccessible(true);
                String g16 = f().g((String) declaredField.get(activity));
                if (!TextUtils.isEmpty(g16)) {
                    return g16;
                }
            } catch (Exception unused) {
            }
            try {
                Uri referrer = activity.getReferrer();
                if (referrer != null) {
                    String g17 = f().g(referrer.getAuthority());
                    if (!TextUtils.isEmpty(g17)) {
                        return g17;
                    }
                }
            } catch (Exception unused2) {
            }
            try {
                String callingPackage = activity.getCallingPackage();
                if (TextUtils.isEmpty(callingPackage) && (callingActivity = activity.getCallingActivity()) != null) {
                    callingPackage = callingActivity.getPackageName();
                }
                if (!TextUtils.isEmpty(callingPackage)) {
                    return f().g(callingPackage);
                }
            } catch (Exception unused3) {
            }
        }
        return null;
    }

    public static int d() {
        return h(BaseApplication.getContext(), "jump_pkg_toast_cfg_798", 4).getInt("jump_pkg_toast_cfg_version", 0);
    }

    private static String e() {
        SharedPreferences h16 = h(BaseApplication.getContext(), "jump_pkg_toast_cfg", 4);
        if (!TextUtils.isEmpty(h16.getString("short_video_res_config_key", ""))) {
            h16.edit().putString("short_video_res_config_key", "").commit();
        }
        String string = h(BaseApplication.getContext(), "jump_pkg_toast_cfg_798", 4).getString("short_video_res_config_key", "");
        if (!TextUtils.isEmpty(string)) {
            try {
                return XorCipher.decrypt(string);
            } catch (XorCipherException unused) {
                return "";
            }
        }
        return null;
    }

    public static bg f() {
        if (f307489b == null) {
            synchronized (bg.class) {
                if (f307489b == null) {
                    f307489b = new bg();
                }
            }
        }
        return f307489b;
    }

    private static SharedPreferences h(Context context, String str, int i3) {
        SharedPreferences fromSpAdapter = QMMKV.fromSpAdapter(context, str, "common_mmkv_configurations");
        if (!fromSpAdapter.getBoolean("_migrate_flag_", false)) {
            QMMKV.migrateToSpAdapter(context, str, i3, "common_mmkv_configurations");
            fromSpAdapter.edit().putBoolean("_migrate_flag_", true).apply();
        }
        return fromSpAdapter;
    }

    public static final boolean k(Activity activity) {
        if (activity == null || activity.isFinishing() || !f().j() || TextUtils.isEmpty(c(activity))) {
            return false;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "needHidePreview true");
            return true;
        }
        return true;
    }

    private boolean l(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            if (length <= 0) {
                return false;
            }
            this.f307490a.clear();
            for (int i3 = 0; i3 < length; i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                String optString = jSONObject.optString(PushClientConstants.TAG_PKG_NAME);
                String optString2 = jSONObject.optString("toastWording");
                if (!TextUtils.isEmpty(optString) && !TextUtils.isEmpty(optString2)) {
                    this.f307490a.put(optString, optString2);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "parseConfigData list size= " + this.f307490a.size());
                return true;
            }
            return true;
        } catch (Exception e16) {
            this.f307490a.clear();
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "parseConfigData[JSONException]", e16);
            }
            return false;
        }
    }

    private static boolean m(String str, int i3) {
        SharedPreferences.Editor edit = h(BaseApplication.getContext(), "jump_pkg_toast_cfg_798", 4).edit();
        try {
            edit.putString("short_video_res_config_key", XorCipher.encrypt(str));
            edit.putInt("jump_pkg_toast_cfg_version", i3);
            return edit.commit();
        } catch (XorCipherException e16) {
            e16.printStackTrace();
            return false;
        }
    }

    public void a(int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "clearConfig list size= " + this.f307490a.size());
        }
        this.f307490a.clear();
        m("", i3);
    }

    public String g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "getPkgShareToast: ");
        }
        ConcurrentHashMap<String, String> concurrentHashMap = this.f307490a;
        if (concurrentHashMap == null || concurrentHashMap.size() == 0) {
            return null;
        }
        return this.f307490a.get(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x003b A[Catch: all -> 0x0059, TryCatch #0 {all -> 0x0059, blocks: (B:3:0x0005, B:5:0x0013, B:8:0x001a, B:10:0x0021, B:12:0x0029, B:16:0x0035, B:18:0x003b, B:22:0x004c, B:24:0x0052), top: B:2:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean i(String str) {
        boolean z16;
        try {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(host)) {
                if (j()) {
                    if (!this.f307490a.containsKey(str) && !this.f307490a.containsKey(host)) {
                        z16 = false;
                        if (QLog.isColorLevel()) {
                            QLog.d("JumpForwardPkgManager", 2, "contain :", Boolean.valueOf(z16));
                        }
                        return z16;
                    }
                    z16 = true;
                    if (QLog.isColorLevel()) {
                    }
                    return z16;
                }
                if (QLog.isColorLevel()) {
                    QLog.d("JumpForwardPkgManager", 2, "needCheckPkg false");
                }
            }
            return false;
        } catch (Throwable th5) {
            QLog.e("JumpForwardPkgManager", 1, th5, new Object[0]);
            return false;
        }
    }

    public boolean j() {
        ConcurrentHashMap<String, String> concurrentHashMap = this.f307490a;
        if (concurrentHashMap != null && concurrentHashMap.size() > 0) {
            return true;
        }
        return false;
    }

    public void n(Context context, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer|received version: " + i3);
        }
        if (TextUtils.isEmpty(str)) {
            a(i3);
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| version=" + i3 + ",config_content is null, clear");
                return;
            }
            return;
        }
        if (l(str)) {
            boolean m3 = m(str, i3);
            if (QLog.isColorLevel()) {
                QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| saveContentOK=" + m3);
                return;
            }
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("JumpForwardPkgManager", 2, "updateConfigFromServer| parseConfigData false");
        }
    }
}
