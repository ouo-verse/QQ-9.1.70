package com.tencent.msf.boot.config;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.mobileqq.msf.core.MsfCore;
import com.tencent.mobileqq.msf.core.c0.g;
import com.tencent.mobileqq.msf.core.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qphone.base.util.StringUtils;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: P */
/* loaded from: classes21.dex */
public class NativeConfigStore {
    static IPatchRedirector $redirector_ = null;
    public static boolean isLoaded = false;
    public static int soLoadResultCode = 0;
    private static String tag = "MSF.C.NativeConfigStore";
    Context context;
    public AtomicBoolean loadSaveRootSucc;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(23530);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            loadSo();
        }
    }

    public NativeConfigStore(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
        } else {
            this.loadSaveRootSucc = new AtomicBoolean(true);
            this.context = context;
        }
    }

    public static String getConfigIMEI() {
        String str;
        if (!TextUtils.isEmpty(o.e())) {
            str = o.e();
        } else {
            str = null;
        }
        if (QLog.isColorLevel()) {
            QLog.d(tag, 2, "[getConfigIMEI], imei = " + str);
        }
        return str;
    }

    public static void loadSo() {
        ApplicationInfo applicationInfo;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int msfLoadSo = StringUtils.msfLoadSo(tag, StringUtils.MSF_LIB_BOOTV2);
        soLoadResultCode = msfLoadSo;
        boolean loadResult = StringUtils.getLoadResult(msfLoadSo);
        isLoaded = loadResult;
        if (!loadResult) {
            String str = null;
            try {
                applicationInfo = BaseApplication.getContext().getApplicationInfo();
            } catch (Exception e16) {
                QLog.e(tag, 1, "load msfbootV2 failed getApplicationInfo exception=" + e16);
                applicationInfo = null;
            }
            if (applicationInfo != null) {
                try {
                    Field declaredField = applicationInfo.getClass().getDeclaredField("primaryCpuAbi");
                    declaredField.setAccessible(true);
                    str = (String) declaredField.get(applicationInfo);
                } catch (IllegalAccessException e17) {
                    QLog.e(tag, 1, "load msfbootV2 failed get primaryCpuAbi IllegalAccessException=" + e17);
                } catch (NoSuchFieldException e18) {
                    QLog.e(tag, 1, "load msfbootV2 failed get primaryCpuAbi NoSuchFieldException=" + e18);
                }
                QLog.e(tag, 1, "load msfbootV2 failed CPU_ABI=" + Build.CPU_ABI + ", CPU_ABI2=" + Build.CPU_ABI2 + ", nativeLibraryDir=" + applicationInfo.nativeLibraryDir + ", primaryCpuAbi=" + str + ", classLoader=" + BaseApplication.getContext().getClassLoader());
            }
        }
        QLog.e(tag, 1, "loadso msfbootV2 " + isLoaded + " resultCode=" + soLoadResultCode + " cost=" + (SystemClock.elapsedRealtime() - elapsedRealtime));
    }

    public native synchronized String getConfig(String str);

    public native synchronized String[] getConfigList(String str);

    public native synchronized int loadConfig(Context context, boolean z16);

    public synchronized String[] n_getConfigList(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String[]) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
        if (!this.loadSaveRootSucc.get()) {
            QLog.w(tag, 1, "loadSaveRootFailed,return");
            return new String[0];
        }
        return getConfigList(str);
    }

    public synchronized void n_removeConfig(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str);
        } else if (!this.loadSaveRootSucc.get()) {
            QLog.w(tag, 1, "loadSaveRootFailed,return");
        } else {
            removeConfig(str);
        }
    }

    public synchronized void n_setConfig(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
        } else if (!this.loadSaveRootSucc.get()) {
            QLog.w(tag, 1, "loadSaveRootFailed,return");
        } else {
            setConfig(str, str2);
        }
    }

    public synchronized int removeConfig(String str) {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return ((Integer) iPatchRedirector.redirect((short) 12, (Object) this, (Object) str)).intValue();
        }
        try {
            i3 = removeConfigNative(str);
        } catch (UnsatisfiedLinkError e16) {
            QLog.e(tag, 2, "removeConfig fail ", e16);
            i3 = -10000;
        }
        if (i3 != 0) {
            HashMap hashMap = new HashMap(8);
            hashMap.put("ret", i3 + "");
            MsfCore.sCore.statReporter.a(g.U2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
        return i3;
    }

    public native int removeConfigNative(String str);

    public synchronized int setConfig(String str, String str2) {
        int i3;
        MsfCore msfCore;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) str, (Object) str2)).intValue();
        }
        try {
            i3 = setConfigNative(str, str2);
        } catch (UnsatisfiedLinkError e16) {
            QLog.e(tag, 1, "setConfig error:", e16);
            if (new Random().nextInt(100) < 1) {
                BaseApplication.getContext().getMSFInterfaceAdapter().handleCatchException(Thread.currentThread(), e16, "NativeConfigStoreCatchedException", null);
            }
            i3 = -1;
        }
        if (i3 != 0 && (msfCore = MsfCore.sCore) != null && msfCore.statReporter != null) {
            HashMap hashMap = new HashMap(8);
            hashMap.put("ret", i3 + "");
            MsfCore.sCore.statReporter.a(g.T2, true, 0L, 0L, (Map<String, String>) hashMap, false, false);
        }
        return i3;
    }

    public native int setConfigNative(String str, String str2);

    public native synchronized void setSaveRootPath(String str);
}
