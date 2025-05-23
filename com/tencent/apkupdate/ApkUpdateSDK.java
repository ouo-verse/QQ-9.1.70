package com.tencent.apkupdate;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.obfuscated.d;
import com.tencent.apkupdate.obfuscated.g;
import com.tencent.apkupdate.obfuscated.h;
import com.tencent.apkupdate.obfuscated.l;
import com.tencent.apkupdate.obfuscated.n;
import com.tencent.apkupdate.obfuscated.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;

/* compiled from: P */
/* loaded from: classes3.dex */
public class ApkUpdateSDK {
    static IPatchRedirector $redirector_;
    private static ApkUpdateSDK instance;

    public ApkUpdateSDK() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static String about() {
        return "ApkUpdateSDK_20140409144158_release_31238";
    }

    public static synchronized ApkUpdateSDK getInstance() {
        ApkUpdateSDK apkUpdateSDK;
        synchronized (ApkUpdateSDK.class) {
            if (instance == null) {
                instance = new ApkUpdateSDK();
            }
            apkUpdateSDK = instance;
        }
        return apkUpdateSDK;
    }

    public void addListener(ApkUpdateListener apkUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) apkUpdateListener);
            return;
        }
        g a16 = g.a();
        if (!a16.f72526a.contains(apkUpdateListener)) {
            a16.f72526a.add(apkUpdateListener);
        }
    }

    public void checkUpdate(List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList();
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(new ApkUpdateParam(it.next(), 0, 0));
            }
            checkUpdateList(arrayList);
        }
    }

    public void checkUpdateList(List<ApkUpdateParam> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) list);
            return;
        }
        if (list != null && list.size() > 0) {
            Message obtainMessage = g.a().obtainMessage();
            obtainMessage.what = 5;
            obtainMessage.obj = list;
            obtainMessage.sendToTarget();
        }
    }

    public void destory() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            iPatchRedirector.redirect((short) 9, (Object) this);
            return;
        }
        h a16 = h.a();
        a16.getClass();
        Log.i("ProtocolHelper", "threadPool.shutdown()");
        ExecutorService executorService = a16.f72531b;
        if (executorService != null) {
            executorService.shutdown();
            a16.f72531b = null;
        }
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
            return;
        }
        h a16 = h.a();
        a16.getClass();
        a16.f72531b = ProxyExecutors.newFixedThreadPool(5);
        a16.f72530a = context;
        l.a().f72549a = context;
        o oVar = new o(context);
        n nVar = new n();
        nVar.f72557c = "100";
        nVar.f72558d = "";
        nVar.f72559e = "NA";
        StringBuffer stringBuffer = new StringBuffer();
        String str = Build.VERSION.RELEASE;
        if (TextUtils.isEmpty(str)) {
            stringBuffer.append("NA");
        } else {
            stringBuffer.append(str);
        }
        stringBuffer.append("_");
        stringBuffer.append(Build.VERSION.SDK_INT);
        nVar.f72560f = stringBuffer.toString();
        nVar.f72562h = oVar.f72564a.getResources().getDisplayMetrics().heightPixels;
        nVar.f72561g = oVar.f72564a.getResources().getDisplayMetrics().widthPixels;
        nVar.f72563i = 0;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append(oVar.a(Build.BRAND));
        stringBuffer2.append("_");
        stringBuffer2.append(oVar.a(DeviceInfoMonitor.getModel()));
        nVar.f72555a = stringBuffer2.toString();
        nVar.f72556b = "100";
        Log.i("vivianliao", " qua :" + nVar.a());
        l.f72546c = nVar.a();
    }

    public int patchNewApk(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, str3)).intValue();
        }
        PackageManager packageManager = h.a().f72530a.getPackageManager();
        try {
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, str, 0);
            if (packageInfo == null) {
                return -1;
            }
            int a16 = new d().a(packageInfo.applicationInfo.sourceDir, str2, str3);
            if (a16 == 0 && packageManager.getPackageArchiveInfo(str3, 1) == null) {
                return -11;
            }
            return a16;
        } catch (PackageManager.NameNotFoundException e16) {
            e16.printStackTrace();
            return -1;
        }
    }

    public int patchNewApkByPath(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Integer) iPatchRedirector.redirect((short) 6, this, str, str2, str3)).intValue();
        }
        PackageManager packageManager = h.a().f72530a.getPackageManager();
        int a16 = new d().a(str, str2, str3);
        if (a16 == 0 && packageManager.getPackageArchiveInfo(str3, 1) == null) {
            return -11;
        }
        return a16;
    }

    public void removeListener(ApkUpdateListener apkUpdateListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) apkUpdateListener);
            return;
        }
        g a16 = g.a();
        a16.getClass();
        if (apkUpdateListener != null) {
            Iterator<ApkUpdateListener> it = a16.f72526a.iterator();
            while (it.hasNext()) {
                if (it.next() == apkUpdateListener) {
                    it.remove();
                }
            }
        }
    }
}
