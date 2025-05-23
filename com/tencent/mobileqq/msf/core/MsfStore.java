package com.tencent.mobileqq.msf.core;

import android.content.Context;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.msf.boot.config.NativeConfigStore;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes15.dex */
public class MsfStore {
    static IPatchRedirector $redirector_ = null;
    static NativeConfigStore nativeConfigStore = null;
    public static int sLoadCfg = 0;
    private static String tag = "MSF.C.MsfStore";

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(28485);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        }
    }

    public MsfStore() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static NativeConfigStore getNativeConfigStore() {
        return nativeConfigStore;
    }

    public String get(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        return null;
    }

    public String[] getArray(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        return null;
    }

    public synchronized boolean init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) context)).booleanValue();
        }
        nativeConfigStore = new NativeConfigStore(context);
        String i3 = c.i(context);
        if (i3 == null) {
            if (QLog.isColorLevel()) {
                QLog.w(tag, 2, "can not load data");
            }
            nativeConfigStore.loadSaveRootSucc.set(false);
        } else {
            try {
                nativeConfigStore.setSaveRootPath(i3);
                sLoadCfg = nativeConfigStore.loadConfig(context, !BaseApplication.getContext().getMSFInterfaceAdapter().isReleaseVersion());
                return true;
            } catch (Throwable th5) {
                QLog.d(tag, 1, "setSaveRootPath or loadConfig failed." + th5, th5);
            }
        }
        return false;
    }

    public void reportLoadCfgTempFile() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
            return;
        }
        if (sLoadCfg != 0) {
            HashMap hashMap = new HashMap(8);
            hashMap.put("ret", sLoadCfg + "");
            MsfCore.sCore.statReporter.a(com.tencent.mobileqq.msf.core.c0.g.V2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
            QLog.d(tag, 1, "check load config find temp file");
        }
    }

    public void save(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2);
        }
    }
}
