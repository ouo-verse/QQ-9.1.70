package com.tencent.mobileqq.msf.core.net.utils.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.msf.core.net.utils.MsfPullConfigUtil;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class h extends a {
    static IPatchRedirector $redirector_;

    public h(String str, List<Pair<String, String>> list, boolean z16) {
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
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? (pair == null || !"enable".equals(pair.first) || TextUtils.isEmpty((CharSequence) pair.second)) ? false : true : ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean b() {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MsfCmdConfig.CMD_SAFE_MODE_TEST_FLAG.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
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
        for (Pair<String, String> pair : list) {
            if ("enable".equals(pair.first)) {
                BaseApplication.getContext().getSharedPreferences(MsfPullConfigUtil.SP_SAFEMODE_TEST_CRASH_CONFIG, 4).edit().putBoolean(MsfPullConfigUtil.KEY_TEST_CRASH_SWITCH, Boolean.parseBoolean((String) pair.second)).commit();
            }
        }
        return true;
    }
}
