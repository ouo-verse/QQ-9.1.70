package com.tencent.replacemonitor.replace;

import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqpermission.QQPermissionConstants;
import com.tencent.replacemonitor.MonitorListener;
import com.tencent.replacemonitor.MonitorResult;
import com.tencent.replacemonitor.MonitorStep;
import com.tencent.replacemonitor.MonitorTask;
import com.tencent.replacemonitor.MonitorType;
import com.tencent.replacemonitor.replace.c.c;
import com.tencent.replacemonitor.replace.c.d;
import com.tencent.replacemonitor.replace.c.e;
import com.tencent.replacemonitor.replace.c.f;
import com.tencent.replacemonitor.replace.c.g;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.j;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes25.dex */
public class b implements Runnable {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private MonitorStep f364889a;

    /* renamed from: b, reason: collision with root package name */
    private MonitorListener f364890b;

    /* renamed from: c, reason: collision with root package name */
    private List<f> f364891c;

    /* renamed from: d, reason: collision with root package name */
    public MonitorTask f364892d;

    public b(MonitorTask monitorTask, MonitorStep monitorStep, MonitorListener monitorListener) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, monitorTask, monitorStep, monitorListener);
            return;
        }
        this.f364889a = monitorStep;
        this.f364890b = monitorListener;
        this.f364892d = monitorTask;
        b();
    }

    private void a(int i3, String str, MonitorType monitorType) {
        MonitorListener monitorListener = this.f364890b;
        if (monitorListener != null) {
            monitorListener.onMonitorFinish(this.f364892d, new MonitorResult(this.f364889a, i3, str, monitorType));
        }
    }

    private boolean c() {
        if (GlobalUtil.getInstance().getContext().checkSelfPermission(QQPermissionConstants.Permission.READ_EXTERNAL_STORAGE) == 0) {
            return true;
        }
        return false;
    }

    private void d() {
        PackageInfo b16 = j.b(this.f364892d.packageName);
        if (b16 == null) {
            b16 = j.a(this.f364892d.filePath);
        }
        if (b16 != null) {
            ApplicationInfo applicationInfo = b16.applicationInfo;
            MonitorTask monitorTask = this.f364892d;
            String str = monitorTask.filePath;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            monitorTask.appName = j.a(b16);
            com.tencent.replacemonitor.replace.d.a.c().f(this.f364892d);
        }
    }

    private void e() {
        PackageInfo b16 = j.b(this.f364892d.packageName);
        if (b16 != null) {
            int i3 = b16.versionCode;
            MonitorTask monitorTask = this.f364892d;
            if (i3 == monitorTask.versionCode) {
                monitorTask.installDir = b16.applicationInfo.sourceDir;
                com.tencent.replacemonitor.replace.d.a.c().f(this.f364892d);
            }
        }
    }

    private void f() {
        MonitorStep monitorStep = this.f364889a;
        if (monitorStep != MonitorStep.DOWNLOADING && monitorStep != MonitorStep.BEFORE_INSTALL) {
            PackageInfo b16 = j.b(this.f364892d.packageName);
            if (b16 != null) {
                this.f364892d.lastModifedTime = b16.lastUpdateTime;
            }
        } else {
            File file = new File(this.f364892d.filePath);
            if (file.exists()) {
                this.f364892d.lastModifedTime = file.lastModified();
            }
        }
        com.tencent.replacemonitor.replace.d.a.c().f(this.f364892d);
    }

    public void b() {
        boolean z16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.f364891c = arrayList;
        arrayList.add(new c());
        this.f364891c.add(new g());
        this.f364891c.add(new e());
        long j3 = com.tencent.replacemonitor.a.f364886a;
        if (j3 > 0 && this.f364892d.fileSize < j3) {
            z16 = true;
        } else {
            z16 = false;
        }
        if (this.f364892d.appType == 1 || z16) {
            this.f364891c.add(new d());
        }
        if (this.f364892d.appType == 2) {
            this.f364891c.add(new com.tencent.replacemonitor.replace.c.a());
        }
        if (this.f364892d.appType == 3) {
            this.f364891c.add(new com.tencent.replacemonitor.replace.c.b());
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        MonitorResult monitorResult;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (!a()) {
            if (!TextUtils.isEmpty(this.f364892d.filePath)) {
                f();
            }
            a(3, "\u666e\u901a\u68c0\u6d4b\u672a\u901a\u8fc7" + toString(), MonitorType.BY_COMMON);
            return;
        }
        if (!c()) {
            a(4, "\u6ca1\u6709SD\u5361\u8bfb\u6743\u9650", MonitorType.BY_COMMON);
            return;
        }
        e();
        d();
        Iterator<f> it = this.f364891c.iterator();
        while (it.hasNext()) {
            try {
                monitorResult = it.next().a(this.f364892d, this.f364889a);
            } catch (Exception e16) {
                e16.printStackTrace();
                monitorResult = null;
            }
            if (monitorResult != null && monitorResult.resultCode == 1) {
                MonitorListener monitorListener = this.f364890b;
                if (monitorListener != null) {
                    monitorListener.onMonitorFinish(this.f364892d, monitorResult);
                    return;
                }
                return;
            }
        }
        f();
        a(0, this.f364889a + "\u68c0\u6d4b\u901a\u8fc7", MonitorType.BY_COMMON);
    }

    private boolean a() {
        boolean z16 = !TextUtils.isEmpty(this.f364892d.packageName) && this.f364892d.versionCode > 0;
        boolean z17 = !TextUtils.isEmpty(this.f364892d.filePath);
        MonitorTask monitorTask = this.f364892d;
        return z16 && z17 && ((monitorTask.fileSize > 0L ? 1 : (monitorTask.fileSize == 0L ? 0 : -1)) > 0 || !TextUtils.isEmpty(monitorTask.fileMd5));
    }
}
