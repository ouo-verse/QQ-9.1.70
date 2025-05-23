package com.vivo.push.f;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes13.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f387675a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f387676b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f387677c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar, Context context, Map map) {
        this.f387677c = eVar;
        this.f387675a = context;
        this.f387676b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentName componentName;
        String packageName = this.f387675a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f387675a.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.u.d("NotifyOpenClientTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        e.b(intent, this.f387676b);
                        this.f387675a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e16) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "start recentIntent is error", e16);
        }
        Intent launchIntentForPackage = InstalledAppListMonitor.getLaunchIntentForPackage(this.f387675a.getPackageManager(), this.f387675a.getPackageName());
        if (launchIntentForPackage != null) {
            launchIntentForPackage.setFlags(268435456);
            e.b(launchIntentForPackage, this.f387676b);
            this.f387675a.startActivity(launchIntentForPackage);
            return;
        }
        com.vivo.push.util.u.a("NotifyOpenClientTask", "LaunchIntent is null");
    }
}
