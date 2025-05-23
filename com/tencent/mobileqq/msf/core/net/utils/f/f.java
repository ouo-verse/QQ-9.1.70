package com.tencent.mobileqq.msf.core.net.utils.f;

import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f249551e = "maxCrashNum";

    /* renamed from: f, reason: collision with root package name */
    private static final String f249552f = "crashType";

    /* renamed from: g, reason: collision with root package name */
    private static final String f249553g = "crashStack";

    /* renamed from: h, reason: collision with root package name */
    private static final String f249554h = "delayMill";

    /* renamed from: i, reason: collision with root package name */
    private static final int f249555i = 100;

    public f(String str, List<Pair<String, String>> list, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Boolean.valueOf(z16));
            return;
        }
        this.f249516a = str;
        this.f249517b = list;
        this.f249518c = z16;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(Pair<String, String> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
        }
        if (pair == null) {
            return false;
        }
        if ("enable".equals(pair.first) || f249551e.equals(pair.first) || f249552f.equals(pair.first) || f249553g.equals(pair.first) || f249554h.equals(pair.first)) {
            return ("enable".equals(pair.first) && TextUtils.isEmpty((CharSequence) pair.second)) ? false : true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean b() {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MsfCmdConfig.CMD_NOT_AUTO_RESTART.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
            return true;
        }
        return false;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(@NonNull String str, List<Pair<String, String>> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) list)).booleanValue();
        }
        if (list == null) {
            return true;
        }
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.NOT_AUTO_RESTART_CONTROL_FILE, 4);
        if (str.equals(sharedPreferences.getString(MsfCmdConfig.KEY_NOT_AUTO_RESTART_VERSION, ""))) {
            return false;
        }
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(MsfCmdConfig.KEY_NOT_AUTO_RESTART_VERSION, str);
        String str2 = null;
        int i3 = 100;
        int i16 = Integer.MAX_VALUE;
        boolean z16 = false;
        String str3 = null;
        for (Pair<String, String> pair : list) {
            if ("enable".equals(pair.first)) {
                z16 = Boolean.parseBoolean((String) pair.second);
            } else if (f249551e.equals(pair.first)) {
                Object obj = pair.second;
                i16 = obj == null ? Integer.MAX_VALUE : Integer.parseInt((String) obj);
            } else if (f249552f.equals(pair.first)) {
                Object obj2 = pair.second;
                str2 = obj2 == null ? "" : (String) obj2;
            } else if (f249553g.equals(pair.first)) {
                Object obj3 = pair.second;
                str3 = obj3 == null ? "" : (String) obj3;
            } else if (f249554h.equals(pair.first)) {
                Object obj4 = pair.second;
                i3 = obj4 == null ? 100 : Integer.parseInt((String) obj4);
            }
        }
        QLog.d(MsfCmdConfig.TAG, 1, "enable=" + z16 + ",maxCrashNum=" + i16 + ",crashType=" + str2 + ",crashStack=" + str3 + ",delayMill=" + i3);
        edit.putBoolean(MsfCmdConfig.KEY_NOT_AUTO_RESTART_ENABLE, z16);
        edit.putInt(MsfCmdConfig.KEY_NOT_AUTO_RESTART_MAX_CRASH_NUM, i16);
        edit.putString(MsfCmdConfig.KEY_NOT_AUTO_RESTART_CRASH_TYPE, str2);
        edit.putString(MsfCmdConfig.KEY_NOT_AUTO_RESTART_CRASH_STACK, str3);
        edit.putInt(MsfCmdConfig.KEY_NOT_AUTO_RESTART_DELAY_MILL, i3);
        edit.commit();
        return true;
    }
}
