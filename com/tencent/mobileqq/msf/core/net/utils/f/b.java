package com.tencent.mobileqq.msf.core.net.utils.f;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.mobileqq.msf.core.net.utils.MsfCmdConfig;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qmmkv.QMMKV;
import com.tencent.mobileqq.qmmkv.v2.MMKVOptionEntityV2;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

/* compiled from: P */
/* loaded from: classes15.dex */
public class b extends a {
    static IPatchRedirector $redirector_ = null;

    /* renamed from: f, reason: collision with root package name */
    private static final String f249519f = "configType";

    /* renamed from: g, reason: collision with root package name */
    private static final String f249520g = "configKey1";

    /* renamed from: h, reason: collision with root package name */
    private static final String f249521h = "configKey2";

    /* renamed from: i, reason: collision with root package name */
    private static final String f249522i = "config_del_time";

    /* renamed from: j, reason: collision with root package name */
    private static final String f249523j = "key_config_delete_version_new";

    /* renamed from: k, reason: collision with root package name */
    private static final int f249524k = 1;

    /* renamed from: l, reason: collision with root package name */
    private static final int f249525l = 2;

    /* renamed from: m, reason: collision with root package name */
    private static final int f249526m = 3;

    /* renamed from: e, reason: collision with root package name */
    private boolean f249527e;

    public b(String str, List<Pair<String, String>> list, boolean z16, boolean z17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, list, Boolean.valueOf(z16), Boolean.valueOf(z17));
            return;
        }
        this.f249516a = str;
        this.f249517b = list;
        this.f249518c = z16;
        this.f249527e = z17;
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean a(Pair<String, String> pair) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) pair)).booleanValue();
        }
        if (pair == null || TextUtils.isEmpty((CharSequence) pair.first)) {
            return false;
        }
        return (f249519f.equals(pair.first) || f249520g.equals(pair.first) || f249521h.equals(pair.first)) && !TextUtils.isEmpty((CharSequence) pair.second);
    }

    @Override // com.tencent.mobileqq.msf.core.net.utils.f.a
    public boolean b() {
        List<Pair<String, String>> list;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Boolean) iPatchRedirector.redirect((short) 2, (Object) this)).booleanValue();
        }
        if (MsfCmdConfig.CMD_DELETE_CONFIG_KEY.equals(this.f249516a) && (list = this.f249517b) != null && list.size() > 0) {
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
            QLog.w(MsfCmdConfig.TAG, 1, "execute delete config faild with paramList is null");
            return true;
        }
        try {
            MMKVOptionEntityV2 fromV2 = QMMKV.fromV2(BaseApplication.getContext(), f249522i);
            String string = fromV2.getString(f249523j, "");
            if (this.f249527e) {
                if (str.equals(string)) {
                    QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,don't delete config one more times,localversion =" + string + ",version = " + str);
                    return false;
                }
                fromV2.putString(f249523j, str);
                fromV2.commit();
                QLog.d(MsfCmdConfig.TAG, 1, "One Time Mode,just delete config one times,localversion =" + string + ",version = " + str);
            }
            String str2 = "";
            String str3 = str2;
            int i3 = 0;
            for (Pair<String, String> pair : list) {
                if (f249519f.equals(pair.first)) {
                    i3 = Integer.parseInt((String) pair.second);
                } else if (f249520g.equals(pair.first)) {
                    Object obj = pair.second;
                    str2 = obj == null ? "" : (String) obj;
                } else if (f249521h.equals(pair.first)) {
                    Object obj2 = pair.second;
                    str3 = obj2 == null ? "" : (String) obj2;
                }
            }
            if (i3 == 0) {
                QLog.w(MsfCmdConfig.TAG, 1, "execute delete config faild with configType is 0");
                return false;
            }
            boolean clearConfigData = BaseApplication.getContext().getMSFInterfaceAdapter().clearConfigData(i3, str2, str3);
            QLog.d(MsfCmdConfig.TAG, 1, "delete config, result =" + clearConfigData + ",configType = " + i3 + ",deleteKey1 = " + str2 + ",deleteKey2 = " + str3);
            return clearConfigData;
        } catch (Throwable th5) {
            QLog.e(MsfCmdConfig.TAG, 1, "execute delete config faild", th5);
            return false;
        }
    }
}
