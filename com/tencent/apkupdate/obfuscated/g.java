package com.tencent.apkupdate.obfuscated;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.apkupdate.ApkUpdateListener;
import com.tencent.apkupdate.ApkUpdateParam;
import com.tencent.apkupdate.logic.protocol.jce.ApkFileInfo;
import com.tencent.apkupdate.logic.protocol.jce.AppInfoForUpdate;
import com.tencent.apkupdate.logic.protocol.jce.AppUpdateInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: P */
/* loaded from: classes3.dex */
public class g extends Handler {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    public static HandlerThread f72524d;

    /* renamed from: e, reason: collision with root package name */
    public static g f72525e;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList<ApkUpdateListener> f72526a;

    /* renamed from: b, reason: collision with root package name */
    public ConcurrentHashMap<String, String> f72527b;

    /* renamed from: c, reason: collision with root package name */
    public final HashMap<String, ApkFileInfo> f72528c;

    public g(Looper looper) {
        super(looper);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) looper);
            return;
        }
        this.f72526a = new ArrayList<>();
        this.f72527b = new ConcurrentHashMap<>();
        this.f72528c = new HashMap<>();
    }

    public static synchronized g a() {
        g gVar;
        synchronized (g.class) {
            if (f72525e == null) {
                BaseHandlerThread baseHandlerThread = new BaseHandlerThread("apkupdate_asyctask");
                f72524d = baseHandlerThread;
                baseHandlerThread.setPriority(10);
                f72524d.start();
                f72525e = new g(f72524d.getLooper());
            }
            gVar = f72525e;
        }
        return gVar;
    }

    public final synchronized void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
        } else {
            if (this.f72528c.size() <= 0) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            HashMap<String, ApkFileInfo> hashMap = this.f72528c;
            arrayList.add(hashMap.get(hashMap.keySet().iterator().next()));
            h.a().c(new j(arrayList));
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        PackageInfo packageInfo;
        ApplicationInfo applicationInfo;
        Bundle bundle;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) message);
            return;
        }
        super.handleMessage(message);
        int i16 = message.what;
        if (i16 != 1) {
            if (i16 != 2) {
                int i17 = 0;
                if (i16 != 5) {
                    if (i16 != 6) {
                        if (i16 != 7) {
                            if (i16 == 8) {
                                Object obj = message.obj;
                                if (obj == null) {
                                    b();
                                    return;
                                }
                                Iterator it = ((ArrayList) obj).iterator();
                                while (it.hasNext()) {
                                    a().f72528c.remove((String) it.next());
                                }
                                if (!a().f72528c.isEmpty()) {
                                    b();
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        ArrayList<AppUpdateInfo> arrayList = (ArrayList) message.obj;
                        synchronized (this) {
                            if (arrayList != null) {
                                if (arrayList.size() > 0) {
                                    PackageManager packageManager = h.a().f72530a.getPackageManager();
                                    for (AppUpdateInfo appUpdateInfo : arrayList) {
                                        if (!this.f72528c.containsKey(appUpdateInfo.packageName)) {
                                            try {
                                                PackageInfo packageInfo2 = InstalledAppListMonitor.getPackageInfo(packageManager, appUpdateInfo.packageName, 0);
                                                LinkedHashMap linkedHashMap = new LinkedHashMap();
                                                String str = packageInfo2.applicationInfo.sourceDir;
                                                f fVar = new f();
                                                try {
                                                    fVar.a(str);
                                                    Iterator<Map.Entry<String, b>> it5 = fVar.f72519b.entrySet().iterator();
                                                    while (it5.hasNext()) {
                                                        linkedHashMap.put(it5.next().getKey(), Long.valueOf(r9.getValue().f72490i | r9.getValue().f72488g));
                                                    }
                                                } catch (Throwable th5) {
                                                    th5.printStackTrace();
                                                }
                                                ApkFileInfo apkFileInfo = new ApkFileInfo();
                                                String str2 = packageInfo2.packageName;
                                                apkFileInfo.packageName = str2;
                                                apkFileInfo.apkId = appUpdateInfo.apkId;
                                                String str3 = this.f72527b.get(str2);
                                                if (TextUtils.isEmpty(str3)) {
                                                    str3 = "".toLowerCase();
                                                }
                                                apkFileInfo.manifestMd5 = str3;
                                                apkFileInfo.fileCRC32 = linkedHashMap;
                                                this.f72528c.put(apkFileInfo.packageName, apkFileInfo);
                                            } catch (PackageManager.NameNotFoundException e16) {
                                                e16.printStackTrace();
                                            }
                                        }
                                    }
                                    i17 = this.f72528c.size();
                                }
                            }
                        }
                        if (i17 > 0) {
                            Message obtainMessage = a().obtainMessage();
                            obtainMessage.what = 8;
                            obtainMessage.obj = null;
                            obtainMessage.sendToTarget();
                            return;
                        }
                        return;
                    }
                    h.a().c(new i((ArrayList) message.obj));
                    return;
                }
                List<ApkUpdateParam> list = (List) message.obj;
                if (list != null) {
                    ArrayList arrayList2 = new ArrayList();
                    PackageManager packageManager2 = h.a().f72530a.getPackageManager();
                    long currentTimeMillis = System.currentTimeMillis();
                    for (ApkUpdateParam apkUpdateParam : list) {
                        String str4 = apkUpdateParam.packageName;
                        int i18 = apkUpdateParam.actionFlag;
                        int i19 = apkUpdateParam.targetVersionCode;
                        int i26 = apkUpdateParam.targetGrayVersionCode;
                        if (!TextUtils.isEmpty(str4)) {
                            try {
                                packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager2, str4, i17);
                            } catch (PackageManager.NameNotFoundException e17) {
                                e17.printStackTrace();
                            }
                            if (packageInfo != null) {
                                AppInfoForUpdate appInfoForUpdate = new AppInfoForUpdate();
                                appInfoForUpdate.packageName = str4;
                                appInfoForUpdate.versionCode = packageInfo.versionCode;
                                appInfoForUpdate.signatureMd5 = h.a().b(str4);
                                String lowerCase = "".toLowerCase();
                                appInfoForUpdate.manifestMd5 = lowerCase;
                                this.f72527b.put(str4, lowerCase);
                                if ((packageInfo.applicationInfo.flags & 1) <= 0) {
                                    appInfoForUpdate.appType = (byte) 1;
                                } else {
                                    appInfoForUpdate.appType = (byte) 2;
                                }
                                appInfoForUpdate.versionName = packageInfo.versionName;
                                appInfoForUpdate.actionFlag = (byte) i18;
                                Context context = l.a().f72549a;
                                if (context != null) {
                                    try {
                                        applicationInfo = context.getPackageManager().getApplicationInfo(str4, 128);
                                    } catch (Exception e18) {
                                        e18.printStackTrace();
                                    }
                                    if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                                        i3 = bundle.getInt("com.tencent.android.qqdownloader.GRAY_CODE");
                                        appInfoForUpdate.grayVersionCode = i3;
                                        appInfoForUpdate.targetVersionCode = i19;
                                        appInfoForUpdate.targetGrayVersionCode = i26;
                                        arrayList2.add(appInfoForUpdate);
                                        i17 = 0;
                                    }
                                }
                                i3 = 0;
                                appInfoForUpdate.grayVersionCode = i3;
                                appInfoForUpdate.targetVersionCode = i19;
                                appInfoForUpdate.targetGrayVersionCode = i26;
                                arrayList2.add(appInfoForUpdate);
                                i17 = 0;
                            }
                        }
                    }
                    Log.i("updatecost----------", "updatecost=" + (System.currentTimeMillis() - currentTimeMillis));
                    if (arrayList2.size() > 0) {
                        Message obtainMessage2 = a().obtainMessage();
                        obtainMessage2.what = 6;
                        obtainMessage2.obj = arrayList2;
                        obtainMessage2.sendToTarget();
                        return;
                    }
                    Message obtainMessage3 = a().obtainMessage();
                    obtainMessage3.what = 2;
                    obtainMessage3.sendToTarget();
                    return;
                }
                return;
            }
            Iterator<ApkUpdateListener> it6 = this.f72526a.iterator();
            while (it6.hasNext()) {
                it6.next().onCheckUpdateFailed("UNKOWN");
            }
            return;
        }
        Iterator<ApkUpdateListener> it7 = this.f72526a.iterator();
        while (it7.hasNext()) {
            it7.next().onCheckUpdateSucceed((ArrayList) message.obj);
        }
    }
}
