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
public class g extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: e, reason: collision with root package name */
    private static final String f249556e = "crashType";

    /* renamed from: f, reason: collision with root package name */
    private static final String f249557f = "crashStack";

    public g(String str, List<Pair<String, String>> list, boolean z16) {
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
        if ("enable".equals(pair.first) || f249556e.equals(pair.first) || f249557f.equals(pair.first)) {
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
        if (MsfCmdConfig.CMD_NOT_EXIT.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
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
        boolean z16 = false;
        SharedPreferences sharedPreferences = BaseApplication.getContext().getSharedPreferences(MsfCmdConfig.SP_SAFEMODE_NOT_EXIT, 0);
        if (!str.equals(sharedPreferences.getString(MsfCmdConfig.KEY_NOT_EXIT_VERSION, ""))) {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString(MsfCmdConfig.KEY_NOT_EXIT_VERSION, str);
            String str2 = null;
            String str3 = null;
            for (Pair<String, String> pair : list) {
                if ("enable".equals(pair.first)) {
                    z16 = Boolean.parseBoolean((String) pair.second);
                } else if (f249556e.equals(pair.first)) {
                    Object obj = pair.second;
                    str2 = obj == null ? "" : (String) obj;
                } else if (f249557f.equals(pair.first)) {
                    Object obj2 = pair.second;
                    str3 = obj2 == null ? "" : (String) obj2;
                }
            }
            QLog.d(MsfCmdConfig.TAG, 1, "noExitEnable=" + z16 + ",noExitCrashType=" + str2 + ",noExitCrashStack=" + str3);
            edit.putBoolean(MsfCmdConfig.KEY_NOT_EXIT_ENABLE, z16);
            edit.putString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_TYPE, str2);
            edit.putString(MsfCmdConfig.KEY_NOT_EXIT_CRASH_STACK, str3);
            edit.commit();
            edit.apply();
        }
        return z16;
    }
}
