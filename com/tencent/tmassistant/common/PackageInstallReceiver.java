package com.tencent.tmassistant.common;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistant.st.b;
import com.tencent.tmassistantbase.util.e;
import com.tencent.tmassistantbase.util.l;
import com.tencent.tmassistantbase.util.r;
import java.util.ArrayList;

/* loaded from: classes26.dex */
public class PackageInstallReceiver extends BroadcastReceiver {

    /* renamed from: b, reason: collision with root package name */
    private static PackageInstallReceiver f380371b;

    /* renamed from: a, reason: collision with root package name */
    protected boolean f380372a = false;

    /* loaded from: classes26.dex */
    class a implements Runnable {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f380373a;

        a(String str) {
            this.f380373a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (l.d()) {
                try {
                    PackageInstallReceiver.this.a(this.f380373a);
                } catch (Exception e16) {
                    r.a("DLSDK_PackageInstallReceiver", "halleytest installReport packageName = " + this.f380373a, e16);
                }
            }
        }
    }

    public PackageInstallReceiver() {
        new ArrayList();
    }

    public static synchronized PackageInstallReceiver a() {
        PackageInstallReceiver packageInstallReceiver;
        synchronized (PackageInstallReceiver.class) {
            if (f380371b == null) {
                f380371b = new PackageInstallReceiver();
            }
            packageInstallReceiver = f380371b;
        }
        return packageInstallReceiver;
    }

    public void b(Context context) {
        if (context != null && this.f380372a) {
            context.unregisterReceiver(this);
            this.f380372a = false;
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        String dataString = intent.getDataString();
        if (TextUtils.isEmpty(dataString)) {
            r.a("DLSDK_PackageInstallReceiver", "intentPkgNameString == null ");
            return;
        }
        String[] split = dataString.split(":");
        if (split.length == 2) {
            String str = split[1];
            Message obtain = Message.obtain();
            obtain.obj = str;
            if (intent.getAction().equals("android.intent.action.PACKAGE_REMOVED")) {
                obtain.what = 2;
                return;
            }
            if (intent.getAction().equals("android.intent.action.PACKAGE_REPLACED")) {
                obtain.what = 3;
                return;
            } else {
                if (intent.getAction().equals("android.intent.action.PACKAGE_ADDED")) {
                    obtain.what = 1;
                    e.a().post(new a(str));
                    return;
                }
                return;
            }
        }
        r.a("DLSDK_PackageInstallReceiver", "packageName == null " + intent.getDataString());
    }

    public void a(String str) {
        SDKReportManager2.getInstance().postReport(9, (System.currentTimeMillis() / 1000) + "||" + str + "|" + Build.MANUFACTURER + "|" + DeviceInfoMonitor.getModel());
        b.a().a(str);
    }

    public void a(Context context) {
        Context applicationContext = context.getApplicationContext();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addDataScheme("package");
        intentFilter.addAction("android.intent.action.PACKAGE_ADDED");
        intentFilter.addAction("android.intent.action.PACKAGE_REMOVED");
        intentFilter.addAction("android.intent.action.PACKAGE_REPLACED");
        applicationContext.registerReceiver(this, intentFilter);
        this.f380372a = true;
    }
}
