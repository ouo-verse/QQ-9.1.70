package com.tencent.mobileqq.msf.core.net.utils;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.f.f;
import com.tencent.mobileqq.msf.core.net.utils.f.g;
import com.tencent.mobileqq.msf.core.net.utils.f.h;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfCmdConfig {
    static IPatchRedirector $redirector_ = null;
    public static final String CMD_DELETE_CONFIG_KEY = "rm_config";
    public static final String CMD_DELETE_FILE = "rm";
    public static final String CMD_DELETE_MMKV_KEY = "rm_mmkv";
    public static final String CMD_DELETE_SP_KEY = "rm_kv";
    public static final String CMD_NOT_AUTO_RESTART = "not_auto_restart";
    public static final String CMD_NOT_EXIT = "not_exit";
    public static final String CMD_SAFE_MODE_TEST_FLAG = "test_flag";
    public static final String KEY_NOT_AUTO_RESTART_CRASH_STACK = "key_not_restart_crash_stack";
    public static final String KEY_NOT_AUTO_RESTART_CRASH_TYPE = "key_not_restart_crash_type";
    public static final String KEY_NOT_AUTO_RESTART_DELAY_MILL = "key_not_restart_delay_mill";
    public static final String KEY_NOT_AUTO_RESTART_ENABLE = "key_not_restart_enable";
    public static final String KEY_NOT_AUTO_RESTART_MAX_CRASH_NUM = "key_not_restart_max_crash";
    public static final String KEY_NOT_AUTO_RESTART_VERSION = "key_not_restart_version_new";
    public static final String KEY_NOT_EXIT_CRASH_STACK = "key_not_exit_crash_stack";
    public static final String KEY_NOT_EXIT_CRASH_TYPE = "key_not_exit_crash_type";
    public static final String KEY_NOT_EXIT_ENABLE = "key_not_exit_enable";
    public static final String KEY_NOT_EXIT_VERSION = "key_not_exit_version_new";
    public static final String NOT_AUTO_RESTART_CONTROL_FILE = "not_restart_control_file";
    public static final String SP_SAFEMODE_NOT_EXIT = "pref_safemode_not_exit";
    public static final String TAG = "MsfCmdConfig";
    private static final String VERSION_PREFIX_FREESIA = "f_";
    private static final String VERSION_PREFIX_MANAGE = "m_";

    /* compiled from: P */
    /* loaded from: classes15.dex */
    class a implements FilenameFilter {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f249471a;

        /* renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f249472b;

        /* renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f249473c;

        a(int i3, String str, String str2) {
            this.f249471a = i3;
            this.f249472b = str;
            this.f249473c = str2;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), str, str2);
            }
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str)).booleanValue();
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            if (this.f249471a > 0) {
                if (!str.endsWith("." + this.f249472b)) {
                    return false;
                }
            }
            if (this.f249471a != 0) {
                str = str.substring(0, str.length() - this.f249471a);
            }
            return Pattern.compile(this.f249473c).matcher(str).matches();
        }
    }

    public MsfCmdConfig() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static void executeFreesiaSafeModeCmd(int i3, String str) {
        executeSafeModeCmd(VERSION_PREFIX_FREESIA + i3, str);
    }

    public static void executeManageSafeModeCmd(int i3, String str) {
        executeSafeModeCmd(VERSION_PREFIX_MANAGE + i3, str);
    }

    @Deprecated
    public static void executeSafeModeCmd(int i3, String str) {
        executeManageSafeModeCmd(i3, str);
    }

    private static com.tencent.mobileqq.msf.core.net.utils.f.a getCmdFactory(JSONObject jSONObject) {
        String optString = jSONObject.optString("cmd", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("params");
        String optString2 = jSONObject.optString("multiprocess", "");
        String optString3 = jSONObject.optString("deleteonetimemode", "");
        boolean equals = optString2.equals("true");
        boolean equals2 = optString3.equals("true");
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < optJSONArray.length(); i3++) {
            try {
                JSONObject jSONObject2 = optJSONArray.getJSONObject(i3);
                String optString4 = jSONObject2.optString("key", "");
                String optString5 = jSONObject2.optString("value", "");
                if (!TextUtils.isEmpty(optString4) && !TextUtils.isEmpty(optString5)) {
                    arrayList.add(new Pair(optString4, optString5));
                }
            } catch (JSONException e16) {
                QLog.d(TAG, 1, "getCmdFactory JSONException=", e16);
            }
        }
        if (CMD_DELETE_FILE.equals(optString)) {
            return new com.tencent.mobileqq.msf.core.net.utils.f.c(optString, arrayList, equals, equals2);
        }
        if (CMD_DELETE_SP_KEY.equals(optString)) {
            return new com.tencent.mobileqq.msf.core.net.utils.f.e(optString, arrayList, equals, equals2);
        }
        if (CMD_DELETE_MMKV_KEY.equals(optString)) {
            return new com.tencent.mobileqq.msf.core.net.utils.f.d(optString, arrayList, equals, equals2);
        }
        if (CMD_NOT_EXIT.equals(optString)) {
            return new g(optString, arrayList, equals);
        }
        if (CMD_SAFE_MODE_TEST_FLAG.equals(optString)) {
            return new h(optString, arrayList, equals);
        }
        if (CMD_NOT_AUTO_RESTART.equals(optString)) {
            return new f(optString, arrayList, equals);
        }
        if (CMD_DELETE_CONFIG_KEY.equals(optString)) {
            return new com.tencent.mobileqq.msf.core.net.utils.f.b(optString, arrayList, equals, equals2);
        }
        return null;
    }

    public static File[] getFilesByConfigFilePath(@NonNull String str, @NonNull String str2, @NonNull String str3) {
        int length;
        if (str3.isEmpty()) {
            length = 0;
        } else {
            length = str3.length() + 1;
        }
        return new File(str).listFiles(new a(length, str3, str2));
    }

    public static void executeSafeModeCmd(String str, String str2) {
        com.tencent.mobileqq.msf.core.net.utils.f.a cmdFactory;
        if (str2 == null) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str2);
            boolean z16 = false;
            for (int i3 = 0; i3 < jSONArray.length(); i3++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i3);
                if (jSONObject != null && (cmdFactory = getCmdFactory(jSONObject)) != null) {
                    boolean a16 = cmdFactory.a(str);
                    z16 |= a16;
                    QLog.w(TAG, 1, "executeSafeModeCmd submitCmd=" + cmdFactory.a() + " |result = " + a16);
                }
            }
            if (QLog.isColorLevel()) {
                QLog.w(TAG, 2, "executeSafeModeCmd hasFix=" + z16);
            }
            b.a(2, 1000, z16);
        } catch (Throwable th5) {
            b.a(2, 1000, false);
            QLog.d(TAG, 1, "handleSafeModeCmd exception=", th5);
        }
    }
}
