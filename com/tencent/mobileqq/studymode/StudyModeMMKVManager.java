package com.tencent.mobileqq.studymode;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Map;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes18.dex */
public class StudyModeMMKVManager {
    static IPatchRedirector $redirector_;

    /* renamed from: c, reason: collision with root package name */
    private static volatile StudyModeMMKVManager f290945c;

    /* renamed from: a, reason: collision with root package name */
    private boolean f290946a;

    /* renamed from: b, reason: collision with root package name */
    private StudyModeMMKVTask f290947b;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes18.dex */
    public class StudyModeMMKVTask implements Runnable {
        static IPatchRedirector $redirector_;

        StudyModeMMKVTask() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) StudyModeMMKVManager.this);
            }
        }

        public boolean a(Context context, String str, int i3, String str2) {
            Map<String, ?> map;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return ((Boolean) iPatchRedirector.redirect((short) 3, this, context, str, Integer.valueOf(i3), str2)).booleanValue();
            }
            if (context == null) {
                return false;
            }
            SharedPreferences sharedPreferences = context.getSharedPreferences(str, i3);
            if (sharedPreferences != null) {
                map = sharedPreferences.getAll();
            } else {
                map = null;
            }
            if (map == null || map.size() <= 0) {
                return false;
            }
            Iterator<Map.Entry<String, ?>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                String key = it.next().getKey();
                if (!TextUtils.isEmpty(key) && !StudyModeMMKVManager.this.g(key)) {
                    it.remove();
                }
            }
            return QMMKV.migrateToSpAdapter(context, str, str2, map);
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            SharedPreferences c16 = StudyModeMMKVManager.this.c();
            a(BaseApplication.getContext(), StudyModeMMKVManager.e(), 4, "common_mmkv_configurations");
            c16.edit().putBoolean("mmkv_study_mode_sp_migrate", true).commit();
            StudyModeMMKVManager.this.f290946a = true;
            QLog.i("StudyModeMMKVTask", 1, "StudyModeMMKVTask execute complete");
        }
    }

    StudyModeMMKVManager() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else if (f()) {
            this.f290947b = new StudyModeMMKVTask();
            QLog.i("StudyModeMMKVManager", 1, "submit mmkv task");
            ThreadManagerV2.excute(this.f290947b, 16, null, false);
        }
    }

    public static StudyModeMMKVManager d() {
        if (f290945c == null) {
            synchronized (StudyModeMMKVManager.class) {
                if (f290945c == null) {
                    f290945c = new StudyModeMMKVManager();
                }
            }
        }
        return f290945c;
    }

    public static String e() {
        String defaultSharedPreferencesName;
        BaseApplication context = BaseApplication.getContext();
        if (Build.VERSION.SDK_INT >= 24) {
            defaultSharedPreferencesName = PreferenceManager.getDefaultSharedPreferencesName(context);
            return defaultSharedPreferencesName;
        }
        return context.getPackageName() + "_preferences";
    }

    private boolean f() {
        if (c().getBoolean("mmkv_study_mode_sp_migrate", false)) {
            QLog.d("StudyModeMMKVManager", 1, "data of studyMode has been migrated, return");
            this.f290946a = true;
            return false;
        }
        if (!MobileQQ.PACKAGE_NAME.equals(MobileQQ.processName)) {
            QLog.d("StudyModeMMKVManager", 1, MobileQQ.processName + " != " + MobileQQ.PACKAGE_NAME + ", forbid to migrate, return");
            return false;
        }
        if (this.f290947b != null) {
            QLog.d("StudyModeMMKVManager", 1, "the mmkvTask has been added to ThreadPool, return");
            return false;
        }
        QLog.d("StudyModeMMKVManager", 1, "need to migrate studyMode data");
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean g(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (!str.contains("study_mode_key_user_switch") && !str.contains("study_mode_key_student_mask") && !str.contains("kid_mode_key_need_verify_phone") && !str.contains("kid_mode_key_password_state") && !str.contains("kid_mode_key_password_salt") && !str.contains("last_diff_study_mode") && !str.contains("search_by_stranger_flag") && !str.contains("invite_to_troop_by_stranger_flag") && !str.contains("search_friend_flag") && !str.contains(AppConstants.Preferences.KID_MODE_ADVANCE_SETTING)) {
            return false;
        }
        return true;
    }

    public SharedPreferences c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return QMMKV.fromSpAdapter(BaseApplication.getContext(), e(), "common_mmkv_configurations");
    }

    public boolean h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        return this.f290946a;
    }
}
