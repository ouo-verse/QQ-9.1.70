package com.tencent.mobileqq.vas.theme;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.mobileqq.vas.theme.api.ThemeLocator;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.mobileqq.vas.toggle.VasNormalToggle;
import com.tencent.mobileqq.vas.updatesystem.VasUpdateUtil;
import com.tencent.mobileqq.vas.util.VasTextUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes20.dex */
public class ThemeCleaner extends BroadcastReceiver implements Runnable {
    private static final HashSet<String> CLEAN_LIST;
    private static final AtomicBoolean INIT = new AtomicBoolean(false);
    private static final AtomicBoolean IS_CLEANING = new AtomicBoolean(false);
    public static final String MOVE_PREFIX = "theme_move_";
    private static final String TAG = "ThemeCleaner";
    private static final HashSet<String> WHITE_LIST;

    static {
        HashSet<String> hashSet = new HashSet<>();
        hashSet.add("1103");
        hashSet.add("2971");
        hashSet.add("2921");
        hashSet.add("3064");
        hashSet.add("3063");
        hashSet.add("3066");
        hashSet.add("3065");
        hashSet.add("3067");
        hashSet.add("2920");
        hashSet.add("3491");
        hashSet.add("1001");
        WHITE_LIST = hashSet;
        CLEAN_LIST = new HashSet<>();
    }

    public static void addThemeToClean(String str) {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e(TAG, 1, "addThemeToClean null appRuntime");
            return;
        }
        if (!shouldClean(waitAppRuntime, str)) {
            QLog.e(TAG, 1, str + " should not clean");
            return;
        }
        QLog.e(TAG, 1, "addThemeToClean: " + str);
        HashSet<String> hashSet = CLEAN_LIST;
        synchronized (hashSet) {
            load(waitAppRuntime);
            hashSet.add(str);
            commitCleanList(waitAppRuntime);
        }
    }

    public static void asyncCleanTheme(final AppRuntime appRuntime, final String str) {
        ThreadManagerV2.executeOnFileThread(new Runnable() { // from class: com.tencent.mobileqq.vas.theme.ThemeCleaner.1
            @Override // java.lang.Runnable
            public void run() {
                ThemeCleaner.clean(new File(new ThemeLocator().setThemeId(str).getBasePath(appRuntime.getApplication())));
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void clean(File file) {
        VasUpdateUtil.safeDeleteFile(file, MOVE_PREFIX);
        QLog.e(TAG, 1, "clean " + file.getName() + ", remain " + ThemeUtil.getFileNumInFile(file));
    }

    private static void cleanTheme(AppRuntime appRuntime, String str) {
        if (!TextUtils.isEmpty(str) && VasTextUtil.isNumeral(str)) {
            if (str.equals(ThemeUtil.getCurrentThemeId())) {
                QLog.e(TAG, 1, str + " is current, should not clean");
                return;
            }
            clean(new File(new ThemeLocator().setThemeId(str).getBasePath(appRuntime.getApplication())));
            return;
        }
        QLog.e(TAG, 1, "cleanTheme error id: " + str);
    }

    public static void cleanUnusedTheme() {
        File[] listFiles;
        if (VasNormalToggle.VAS_THEME_CLEAN_IGNORE.isEnable(false)) {
            QLog.d(TAG, 1, "cleanUnusedTheme ignored");
            return;
        }
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime == null) {
            QLog.d(TAG, 1, "cleanUnusedTheme appRuntime null");
            return;
        }
        File dir = peekAppRuntime.getApplication().getDir(QQTheme.INTERNAL_THEME_DIR_810, 0);
        if (dir.exists() && dir.isDirectory() && (listFiles = dir.listFiles()) != null) {
            for (File file : listFiles) {
                if (file.exists()) {
                    String name = file.getName();
                    addThemeToClean(name);
                    QLog.d(TAG, 1, "cleanUnusedTheme add:" + name);
                }
            }
            new ThemeCleaner().run();
        }
    }

    private static void commitCleanList(AppRuntime appRuntime) {
        JSONArray jSONArray = new JSONArray();
        Iterator<String> it = CLEAN_LIST.iterator();
        while (it.hasNext()) {
            jSONArray.mo162put(it.next());
        }
        ThemeUtil.getUinThemePreferences(appRuntime).edit().putString("cleanList", jSONArray.toString()).commit();
    }

    private static void load(AppRuntime appRuntime) {
        if (INIT.compareAndSet(false, true)) {
            SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(appRuntime);
            try {
                JSONArray jSONArray = new JSONArray(uinThemePreferences.getString("cleanList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                    CLEAN_LIST.add(jSONArray.getString(i3));
                }
            } catch (JSONException e16) {
                QLog.e(TAG, 1, "load: ", e16);
                uinThemePreferences.edit().putString("cleanList", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI).commit();
            }
        }
    }

    private static boolean shouldClean(AppRuntime appRuntime, String str) {
        String str2;
        if (!TextUtils.isEmpty(str) && VasTextUtil.isNumeral(str) && !"1000".equals(str) && !WHITE_LIST.contains(str)) {
            SharedPreferences uinThemePreferences = ThemeUtil.getUinThemePreferences(appRuntime);
            try {
                String string = uinThemePreferences.getString("themeArray", null);
                if (!TextUtils.isEmpty(uinThemePreferences.getString("seriesID", null)) && !TextUtils.isEmpty(string)) {
                    JSONArray jSONArray = new JSONArray(string);
                    for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i3);
                        if (jSONObject != null) {
                            str2 = jSONObject.getString("id");
                        } else {
                            str2 = null;
                        }
                        if (str.equals(str2)) {
                            return false;
                        }
                    }
                }
                return true;
            } catch (Exception e16) {
                QLog.e(TAG, 1, "shouldClean: ", e16);
            }
        }
        return false;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent.getIntExtra("pid", Process.myPid()) != Process.myPid()) {
            return;
        }
        ThreadManagerV2.excute(this, 64, null, false);
    }

    @Override // java.lang.Runnable
    public void run() {
        ArrayList arrayList;
        if (!IS_CLEANING.compareAndSet(false, true)) {
            QLog.e(TAG, 1, "another thread is cleaning");
            return;
        }
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
        if (waitAppRuntime == null) {
            QLog.e(TAG, 1, "cleanList null appRuntime");
        } else {
            HashSet<String> hashSet = CLEAN_LIST;
            synchronized (hashSet) {
                load(waitAppRuntime);
                arrayList = new ArrayList(hashSet);
            }
            if (arrayList.isEmpty()) {
                QLog.e(TAG, 1, "empty list");
            } else {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    cleanTheme(waitAppRuntime, (String) it.next());
                }
                synchronized (CLEAN_LIST) {
                    Iterator it5 = arrayList.iterator();
                    while (it5.hasNext()) {
                        CLEAN_LIST.remove((String) it5.next());
                    }
                    commitCleanList(waitAppRuntime);
                }
            }
        }
        IS_CLEANING.set(false);
    }
}
