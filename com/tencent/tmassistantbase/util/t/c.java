package com.tencent.tmassistantbase.util.t;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.tmassistant.st.SDKReportManager2;
import com.tencent.tmassistantbase.util.GlobalUtil;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: P */
/* loaded from: classes26.dex */
public class c extends com.tencent.tmassistantbase.util.t.a {

    /* renamed from: d, reason: collision with root package name */
    private a f380527d;

    /* renamed from: e, reason: collision with root package name */
    private Context f380528e;

    /* compiled from: P */
    /* loaded from: classes26.dex */
    public static class a extends com.tencent.tmassistantbase.util.t.b {

        /* renamed from: b, reason: collision with root package name */
        private Context f380529b;

        /* compiled from: P */
        /* renamed from: com.tencent.tmassistantbase.util.t.c$a$a, reason: collision with other inner class name */
        /* loaded from: classes26.dex */
        class RunnableC9997a implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ PackageInfo f380530a;

            RunnableC9997a(a aVar, PackageInfo packageInfo) {
                this.f380530a = packageInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                SDKReportManager2.getInstance().postReport(2003, Build.MANUFACTURER + "|" + DeviceInfoMonitor.getModel() + "|do_hook_install|pkg=" + this.f380530a.packageName);
            }
        }

        /* compiled from: P */
        /* loaded from: classes26.dex */
        class b implements Runnable {

            /* renamed from: a, reason: collision with root package name */
            final /* synthetic */ PackageInfo f380531a;

            b(a aVar, PackageInfo packageInfo) {
                this.f380531a = packageInfo;
            }

            @Override // java.lang.Runnable
            public void run() {
                SDKReportManager2.getInstance().postReport(2002, Build.MANUFACTURER + "|" + DeviceInfoMonitor.getModel() + "|do_hook_install|pkg=" + this.f380531a.packageName);
            }
        }

        public a(Context context) {
            this.f380529b = context;
        }

        @Override // com.tencent.tmassistantbase.util.t.b
        public String a() {
            return "startActivity";
        }

        @Override // com.tencent.tmassistantbase.util.t.b
        public Object b(Object obj, Method method, Object... objArr) {
            System.currentTimeMillis();
            Intent intent = (Intent) objArr[com.tencent.tmassistantbase.util.t.a.a(objArr, (Class<?>) Intent.class)];
            if (intent != null) {
                if (!"android.intent.action.INSTALL_PACKAGE".equals(intent.getAction()) && (!CommonConstant.ACTION.HWID_SCHEME_URL.equals(intent.getAction()) || !"application/vnd.android.package-archive".equals(intent.getType()))) {
                    a(false);
                } else {
                    Uri data = intent.getData();
                    try {
                        if (this.f380529b == null) {
                            Context context = GlobalUtil.getInstance().getContext();
                            this.f380529b = context;
                            if (context == null) {
                                return method.invoke(obj, objArr);
                            }
                        }
                        PackageManager packageManager = this.f380529b.getPackageManager();
                        if (packageManager != null && data != null) {
                            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(data.getPath(), 1);
                            if (packageArchiveInfo == null) {
                                return method.invoke(obj, objArr);
                            }
                            if (!d.a(packageArchiveInfo.packageName)) {
                                com.tencent.tmassistantbase.util.e.a().post(new RunnableC9997a(this, packageArchiveInfo));
                                return method.invoke(obj, objArr);
                            }
                            if (objArr.length > 1 && objArr[1] != null) {
                                objArr[1] = c.b();
                                intent.putExtra("caller_package", c.b());
                                if (GlobalUtil.isOppo()) {
                                    intent.putExtra("oppo_extra_pkg_name", c.b());
                                }
                            }
                            com.tencent.tmassistantbase.util.e.a().post(new b(this, packageArchiveInfo));
                        }
                        return method.invoke(obj, objArr);
                    } catch (Exception unused) {
                    }
                }
            } else {
                a(false);
            }
            return method.invoke(obj, objArr);
        }

        @Override // com.tencent.tmassistantbase.util.t.b
        public boolean a(Object obj, Method method, Object... objArr) {
            return false;
        }

        @Override // com.tencent.tmassistantbase.util.t.b
        public Object a(Object obj, Method method, Object[] objArr, Object obj2) {
            return super.a(obj, method, objArr, obj2);
        }
    }

    public c(Context context) {
        this.f380528e = context;
        a aVar = new a(context);
        this.f380527d = aVar;
        a((b) aVar);
    }

    public static String b() {
        if (GlobalUtil.isVivo()) {
            return "com.bbk.appstore";
        }
        if (GlobalUtil.isOppo()) {
            return "com.oppo.market";
        }
        return "com.google.launcher";
    }

    @Override // com.tencent.tmassistantbase.util.t.e
    public void a() {
        try {
            Field declaredField = Class.forName("android.app.ActivityManagerNative").getDeclaredField("gDefault");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(null);
            Class<?> cls = Class.forName("android.util.Singleton");
            Method declaredMethod = cls.getDeclaredMethod("get", new Class[0]);
            declaredMethod.setAccessible(true);
            Field declaredField2 = cls.getDeclaredField("mInstance");
            declaredField2.setAccessible(true);
            if (cls.isInstance(obj)) {
                this.f380522a = declaredMethod.invoke(obj, new Object[0]);
            } else {
                this.f380522a = obj;
            }
            this.f380523b = a(this.f380522a);
            if (cls.isInstance(obj)) {
                declaredField2.set(obj, this.f380523b);
            } else {
                declaredField.set(obj, this.f380523b);
            }
        } catch (Throwable th5) {
            Log.e("HookManager_AMHook", "inject MActivityManagerService exception!");
            th5.printStackTrace();
        }
    }

    public boolean c() {
        a aVar = this.f380527d;
        if (aVar != null) {
            return aVar.b();
        }
        return false;
    }

    public void a(boolean z16) {
        a aVar = this.f380527d;
        if (aVar != null) {
            aVar.a(z16);
        }
    }
}
