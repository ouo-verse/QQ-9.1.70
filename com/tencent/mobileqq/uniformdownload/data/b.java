package com.tencent.mobileqq.uniformdownload.data;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.aelight.camera.constants.AECameraConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes17.dex */
public class b {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private a d(String str) {
        if (str == null) {
            QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] rBobjectOfString err, str=null");
            return null;
        }
        String[] split = str.split("\\^");
        if (split.length < 4) {
            QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] rBobjectOfString err,l=" + split.length + " str=" + str);
            return null;
        }
        a aVar = new a();
        aVar.f305878a = Integer.parseInt(split[0]);
        aVar.f305879b = split[1];
        aVar.f305881d = Long.parseLong(split[2]);
        aVar.f305882e = Boolean.parseBoolean(split[3]);
        if (split.length > 4) {
            aVar.f305880c = split[4];
        } else {
            aVar.f305880c = aVar.f305879b;
        }
        return aVar;
    }

    private String g(a aVar) {
        if (aVar == null) {
            QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] stringOfRbObject err, obj=null");
            return null;
        }
        return String.valueOf(aVar.f305878a) + AECameraConstants.WIDGETINFO_SEPARATE + aVar.f305879b + AECameraConstants.WIDGETINFO_SEPARATE + String.valueOf(aVar.f305881d) + AECameraConstants.WIDGETINFO_SEPARATE + String.valueOf(aVar.f305882e) + AECameraConstants.WIDGETINFO_SEPARATE + aVar.f305880c;
    }

    public void a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        try {
            QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] clearDownloadingRbResmeInfo...");
            SharedPreferences.Editor edit = c().edit();
            edit.clear();
            edit.apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public Map<String, a> b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Map) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        HashMap hashMap = new HashMap();
        try {
            Map<String, ?> all = c().getAll();
            if (all != null) {
                QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, size:[" + all.size() + "]");
            }
            if (all != null && all.size() > 0) {
                Iterator<T> it = all.entrySet().iterator();
                while (it.hasNext()) {
                    Map.Entry entry = (Map.Entry) it.next();
                    String str = (String) entry.getKey();
                    a d16 = d((String) entry.getValue());
                    if (d16 != null) {
                        QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, url:[" + str + "]] nId:[" + d16.f305878a + "] w:[" + d16.f305882e + "]");
                        hashMap.put(str, d16);
                    } else {
                        QLog.e("DownloadingRbResmeInfoMgr", 1, "[UniformDL] getDownloadingRbResmeInfo, value error. url:[" + str + "]");
                    }
                }
            }
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return hashMap;
    }

    public SharedPreferences c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (SharedPreferences) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return BaseApplication.getContext().getSharedPreferences("downloading_rb_resume_info", 0);
    }

    public void e(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
            return;
        }
        try {
            QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] removeDownloadingRbResmeInfo, url:[" + str + "]");
            SharedPreferences.Editor edit = c().edit();
            edit.remove(str);
            edit.apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }

    public void f(String str, String str2, String str3, long j3, Bundle bundle, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, str, str2, str3, Long.valueOf(j3), bundle, Integer.valueOf(i3), Boolean.valueOf(z16));
            return;
        }
        try {
            QLog.i("DownloadingRbResmeInfoMgr", 1, "[UniformDL] saveDownloadingRbResmeInfo, url:[" + str + "] nId:[" + i3 + "] w:[" + z16 + "]");
            SharedPreferences.Editor edit = c().edit();
            a aVar = new a();
            aVar.f305878a = i3;
            aVar.f305879b = str2;
            if (!TextUtils.isEmpty(str3)) {
                aVar.f305880c = str3;
            } else {
                aVar.f305880c = str2;
            }
            aVar.f305881d = j3;
            aVar.f305882e = z16;
            aVar.f305883f = bundle;
            edit.putString(str, g(aVar));
            edit.apply();
        } catch (Exception e16) {
            e16.printStackTrace();
        }
    }
}
