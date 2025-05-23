package kcsdk.shell;

import android.app.Service;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.os.IBinder;
import android.os.Process;
import android.text.TextUtils;
import b25.a;
import b25.p;
import b25.r;
import java.io.File;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes28.dex */
public class KcShellService extends Service {

    /* renamed from: d, reason: collision with root package name */
    private IBinder f412035d;

    private boolean a(Intent intent, Context context, ClassLoader classLoader) {
        Class<?> loadClass;
        boolean z16 = false;
        try {
            loadClass = classLoader.loadClass("tmsdk.common.KcBaseService");
            p.a("KcSdkShellManager", "aClass class is:" + loadClass);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (loadClass == null) {
            return false;
        }
        Service service = (Service) loadClass.newInstance();
        Method declaredMethod = ContextWrapper.class.getDeclaredMethod("attachBaseContext", Context.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(service, context);
        service.onCreate();
        this.f412035d = service.onBind(intent);
        z16 = true;
        p.a("KcSdkShellManager", "initServiceBinder :" + z16);
        return z16;
    }

    public boolean b(Intent intent, boolean z16) {
        if (a.h().l()) {
            p.a("KcSdkShellManager", "initImpl");
        }
        Context applicationContext = getApplicationContext();
        try {
            File file = new File(applicationContext.getFilesDir(), "kingcard/kcsdk.jar");
            String canonicalPath = file.getCanonicalPath();
            if (file.exists()) {
                canonicalPath = file.getCanonicalPath();
            }
            if (TextUtils.isEmpty(canonicalPath)) {
                if (a.h().l()) {
                    p.a("KcSdkShellManager", "kcsdkPath is null ");
                }
                return false;
            }
            r.a(getApplicationContext());
            p.a("KcSdkShellManager", "loadJPatch in shell service ");
            ClassLoader i3 = a.h().i();
            if (i3 != null) {
                boolean a16 = a(intent, applicationContext, i3);
                if (a.h().l()) {
                    p.a("KcSdkShellManager", "has loader " + a16);
                }
                return a16;
            }
            boolean m3 = a.h().m(getApplicationContext(), canonicalPath);
            p.a("KcSdkShellManager", "init result: " + m3);
            if (!m3) {
                return false;
            }
            return a(intent, applicationContext, a.h().i());
        } catch (Throwable th5) {
            th5.printStackTrace();
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String str;
        boolean z16 = true;
        p.a("KcSdkShellManager", "shell service onBind " + String.format(" process id [%d]", Integer.valueOf(Process.myPid())));
        if (a.h().l()) {
            p.a("KcSdkShellManager", "onBind");
        }
        if (!a.f27762j) {
            long currentTimeMillis = System.currentTimeMillis();
            if (intent != null) {
                z16 = intent.getBooleanExtra("hasPermmision", true);
            }
            a.f27762j = b(intent, z16);
            str = "initImpl: " + (System.currentTimeMillis() - currentTimeMillis);
        } else {
            if (this.f412035d == null) {
                boolean a16 = a(intent, this, a.h().i());
                if (a.h().l()) {
                    str = "initServiceBinder: " + a16;
                }
            }
            return this.f412035d;
        }
        p.a("KcSdkShellManager", str);
        return this.f412035d;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }
}
