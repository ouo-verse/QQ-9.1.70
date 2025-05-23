package com.tencent.mobileqq.intervideo.impl;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerExecutor;
import com.tencent.mobileqq.intervideo.InvalidFileException;
import com.tencent.mobileqq.intervideo.c;
import com.tencent.mobileqq.intervideo.e;
import com.tencent.mobileqq.intervideo.f;
import com.tencent.mobileqq.intervideo.g;
import com.tencent.mobileqq.intervideo.groupvideo.IVPluginDataReporter;
import com.tencent.mobileqq.intervideo.i;
import com.tencent.qphone.base.util.QLog;
import com.tencent.shadow.core.common.LoggerFactory;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: P */
/* loaded from: classes33.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f238286a;

    /* renamed from: c, reason: collision with root package name */
    private static i f238288c;

    /* renamed from: b, reason: collision with root package name */
    public static final IVPluginDataReporter f238287b = new IVPluginDataReporter();

    /* renamed from: d, reason: collision with root package name */
    private static final Object f238289d = new Object();

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.intervideo.impl.a$a, reason: collision with other inner class name */
    /* loaded from: classes33.dex */
    class CallableC7945a implements Callable<g> {

        /* renamed from: d, reason: collision with root package name */
        final /* synthetic */ Context f238290d;

        /* renamed from: e, reason: collision with root package name */
        final /* synthetic */ String f238291e;

        CallableC7945a(Context context, String str) {
            this.f238290d = context;
            this.f238291e = str;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public g call() throws Exception {
            return a.c(this.f238290d, "Now", this.f238291e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes33.dex */
    public class b implements e {

        /* renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f238292a;

        b(String str) {
            this.f238292a = str;
        }

        @Override // com.tencent.mobileqq.intervideo.e
        public void a() {
            synchronized (a.f238289d) {
                a.f238288c = null;
                QLog.i("shadow::Shadow", 2, "pluginManagerWrapper pmUpdaterCallBcak : bizType:" + this.f238292a);
            }
        }
    }

    static {
        f();
    }

    public static g d(Context context, String str, String str2) throws InterruptedException, TimeoutException, ExecutionException {
        try {
            return (g) ThreadManagerExecutor.getExecutorService(192).submit(new CallableC7945a(context, str)).get(20L, TimeUnit.SECONDS);
        } catch (InterruptedException e16) {
            f238287b.opType("updateException").d1(e16.toString()).report();
            throw e16;
        } catch (ExecutionException e17) {
            f238287b.opType("updateException").d1(e17.toString()).report();
            throw e17;
        } catch (TimeoutException e18) {
            f238287b.opType("updateException").d1(e18.toString()).report();
            throw e18;
        }
    }

    private static i e(String str, com.tencent.mobileqq.intervideo.b bVar) {
        i iVar;
        QLog.i("shadow::Shadow", 2, "pluginManagerWrapper \uff0csPluginManagerWrapper = " + f238288c + " bizType:" + str);
        synchronized (f238289d) {
            if (f238288c == null) {
                f238288c = new i(str, bVar);
                QLog.i("shadow::Shadow", 2, "new pluginManagerWrapper : " + f238288c);
            }
            iVar = f238288c;
        }
        return iVar;
    }

    public static void f() {
        if (f238286a) {
            return;
        }
        try {
            LoggerFactory.setILoggerFactory(f.a());
        } catch (RuntimeException unused) {
        }
        f238286a = true;
    }

    public static g c(Context context, String str, String str2) throws ExecutionException, InterruptedException {
        String str3;
        i iVar;
        long currentTimeMillis = System.currentTimeMillis();
        f238287b.opDepartment("shadow").opName(str).opType("CdnGetBizPm").toUin(str2);
        c cVar = new c(str);
        if (cVar.getLatest() != null) {
            return new i(str, cVar);
        }
        com.tencent.mobileqq.intervideo.b bVar = new com.tencent.mobileqq.intervideo.b(context.getApplicationContext(), str, str2, "11_3");
        if (QLog.isColorLevel()) {
            QLog.i("shadow::Shadow", 2, "wasUpdating:" + bVar.wasUpdating() + " getLatest:" + bVar.getLatest());
        }
        boolean z16 = bVar.wasUpdating() || bVar.getLatest() == null;
        if (QLog.isColorLevel()) {
            QLog.i("shadow::Shadow", 2, "needWaitingUpdate:" + z16);
        }
        if (TextUtils.equals("GVideo", str)) {
            bVar.l(new b(str));
        }
        Future<File> update = bVar.update();
        if (z16) {
            try {
                update.get();
            } catch (InterruptedException e16) {
                f238287b.d1(Boolean.toString(z16)).d2(Long.toString(System.currentTimeMillis() - currentTimeMillis)).opResult(2).report();
                throw e16;
            } catch (ExecutionException e17) {
                f238287b.d1(Boolean.toString(z16)).d2(Long.toString(System.currentTimeMillis() - currentTimeMillis)).opResult(1).report();
                throw e17;
            }
        }
        PackageManager packageManager = context.getPackageManager();
        String str4 = "";
        if (bVar.getLatest() == null) {
            str3 = "";
        } else {
            str3 = bVar.getLatest().getAbsolutePath();
        }
        QLog.i("shadow::Shadow", 2, "getPackageArchiveInfo\uff0capkPath = " + str3);
        long currentTimeMillis2 = System.currentTimeMillis();
        PackageInfo packageInfo = null;
        try {
            packageInfo = packageManager.getPackageArchiveInfo(str3, 128);
            QLog.i("shadow::Shadow", 2, "getPackageArchiveInfo\uff0ctimespan = " + (System.currentTimeMillis() - currentTimeMillis2));
            if (packageInfo == null) {
                try {
                    str4 = com.tencent.qqprotect.singleupdate.a.d(bVar.getLatest());
                } catch (IOException unused) {
                }
                String str5 = str4;
                QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid\uff0capk = " + str3 + " md5 = " + str5);
                f238287b.d1(str3).d2("FileInvalid").d3(str5).opResult(1000).report();
                bVar.g();
                throw new InvalidFileException("pluginManager apk file is invalid!");
            }
        } catch (Exception unused2) {
            if (packageInfo == null) {
                try {
                    str4 = com.tencent.qqprotect.singleupdate.a.d(bVar.getLatest());
                } catch (IOException unused3) {
                }
                String str6 = str4;
                QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid\uff0capk = " + str3 + " md5 = " + str6);
                f238287b.d1(str3).d2("FileInvalid").d3(str6).opResult(1000).report();
                bVar.g();
                throw new InvalidFileException("pluginManager apk file is invalid!");
            }
        } catch (Throwable th5) {
            if (packageInfo == null) {
                try {
                    str4 = com.tencent.qqprotect.singleupdate.a.d(bVar.getLatest());
                } catch (IOException unused4) {
                }
                String str7 = str4;
                QLog.i("shadow::Shadow", 1, "pluginManager apk file is invalid\uff0capk = " + str3 + " md5 = " + str7);
                f238287b.d1(str3).d2("FileInvalid").d3(str7).opResult(1000).report();
                bVar.g();
                throw new InvalidFileException("pluginManager apk file is invalid!");
            }
            throw th5;
        }
        long currentTimeMillis3 = System.currentTimeMillis();
        if (TextUtils.equals("GVideo", str)) {
            iVar = e(str, bVar);
        } else {
            iVar = new i(str, bVar);
        }
        f238287b.d1(Boolean.toString(z16)).d2(Long.toString(currentTimeMillis3 - currentTimeMillis)).opResult(0).report();
        return iVar;
    }
}
