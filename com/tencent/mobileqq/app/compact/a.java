package com.tencent.mobileqq.app.compact;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.os.Build;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.commonsdk.classload.DexClassLoaderUtil;
import com.tencent.commonsdk.zip.QZipInputStream;
import com.tencent.mobileqq.api.IBuildConfig;
import com.tencent.mobileqq.app.dd;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.pluginsdk.ApkFileParser;
import com.tencent.mobileqq.pluginsdk.PluginUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.plugin.InjectFailException;
import cooperation.plugin.m;
import cooperation.qzone.patch.QZonePatchService;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.io.Writer;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.zip.ZipEntry;

/* compiled from: P */
/* loaded from: classes11.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private Set<String> f195458a;

    /* renamed from: b, reason: collision with root package name */
    private ConcurrentHashMap<String, Object> f195459b;

    /* renamed from: c, reason: collision with root package name */
    private C7375a f195460c;

    /* renamed from: d, reason: collision with root package name */
    private Set<String> f195461d;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.app.compact.a$a, reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public class C7375a implements IGuardInterface {
        static IPatchRedirector $redirector_;

        C7375a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) a.this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationBackground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onApplicationForeground() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, j3);
                return;
            }
            if (j3 == 5 && !a.this.l()) {
                QLog.i("plugin_tag", 1, "trigger start oat service\uff01");
                try {
                    BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
                    baseApplicationImpl.startService(new Intent(baseApplicationImpl, (Class<?>) DFPluginOatService.class));
                } catch (Exception e16) {
                    QLog.e("plugin_tag", 1, "start DFPluginOatService error", e16);
                }
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onBackgroundUnguardTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                iPatchRedirector.redirect((short) 7, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onLiteTimeTick(long j3) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, j3);
            }
        }

        @Override // com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface
        public void onScreensStateChanged(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, z16);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: P */
    /* loaded from: classes11.dex */
    public static class b {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private static final a f195463a;

        static {
            IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70150);
            $redirector_ = redirector;
            if (redirector != null && redirector.hasPatch((short) 2)) {
                redirector.redirect((short) 2);
            } else {
                f195463a = new a();
            }
        }
    }

    a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f195458a = new HashSet();
        this.f195459b = new ConcurrentHashMap<>();
        this.f195460c = null;
        this.f195461d = new HashSet();
    }

    private void a(Context context, String str) {
        try {
            PackageInfo packageInfoWithException = ApkFileParser.getPackageInfoWithException(context, str, 129);
            SharedPreferences.Editor edit = context.getSharedPreferences("df_plugin_aty_info", 4).edit();
            ActivityInfo[] activityInfoArr = packageInfoWithException.activities;
            if (activityInfoArr != null) {
                for (ActivityInfo activityInfo : activityInfoArr) {
                    edit.putString(activityInfo.name, str);
                }
            }
            edit.apply();
        } catch (Throwable th5) {
            throw new RuntimeException("getPackageInfoWithException " + th5.getMessage(), th5);
        }
    }

    private boolean c(String str) {
        File g16 = g();
        long currentTimeMillis = System.currentTimeMillis();
        boolean q16 = q(new File(str), g16);
        QLog.i("plugin_tag", 1, "[extractFeatureApkSo] inject df plugin time cost: " + (System.currentTimeMillis() - currentTimeMillis));
        return q16;
    }

    private String d() {
        String str;
        String[] strArr = Build.SUPPORTED_ABIS;
        if (strArr != null && strArr.length > 0) {
            str = strArr[0];
        } else {
            str = null;
        }
        if (!TextUtils.isEmpty(str)) {
            if (str.contains("arm64-v8a")) {
                return "arm64-v8a";
            }
            if (str.contains("armeabi-v7a")) {
                return "armeabi-v7a";
            }
            return "armeabi";
        }
        return "armeabi";
    }

    private File e(String str) {
        return new File(new File(PluginUtils.getPluginInstallDir(BaseApplicationImpl.sApplication), AppSetting.f99543c + "_oDexed"), str + "_oDexed");
    }

    private File f(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(".");
        if (lastIndexOf >= 0) {
            name = name.substring(0, lastIndexOf);
        }
        File file2 = new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/feature_apk_dex/" + name);
        if (!file2.exists()) {
            file2.mkdirs();
        }
        return file2;
    }

    private File g() {
        return new File(BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/feature_apk_so");
    }

    private boolean h() {
        String absolutePath = g().getAbsolutePath();
        if (QLog.isColorLevel()) {
            QLog.d("[DynamicFeature] Load", 2, "[asset][so] injectFeatureApksSo: invoked. ", " soOutputDir: ", absolutePath);
        }
        if (TextUtils.isEmpty(absolutePath)) {
            return false;
        }
        File file = new File(absolutePath, "lib/" + d() + "/");
        try {
            long currentTimeMillis = System.currentTimeMillis();
            com.tencent.mobileqq.app.compact.b.b(BaseApplication.context.getClassLoader(), file);
            QLog.i("plugin_tag", 1, "[so] inject df plugin time cost: " + (System.currentTimeMillis() - currentTimeMillis));
            return true;
        } catch (Throwable th5) {
            QLog.e("[DynamicFeature] Load", 1, "injectFeatureApksSo: failed. ", th5);
            return false;
        }
    }

    public static a k() {
        return b.f195463a;
    }

    private boolean n() {
        if (Build.VERSION.SDK_INT >= 26) {
            return true;
        }
        return false;
    }

    public boolean b(Object obj) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Boolean) iPatchRedirector.redirect((short) 11, (Object) this, obj)).booleanValue();
        }
        if (obj == null) {
            return false;
        }
        try {
            if (obj instanceof InputStream) {
                ((InputStream) obj).close();
            } else if (obj instanceof OutputStream) {
                ((OutputStream) obj).close();
            } else if (obj instanceof Reader) {
                ((Reader) obj).close();
            } else if (obj instanceof Writer) {
                ((Writer) obj).close();
            } else {
                if (!(obj instanceof RandomAccessFile)) {
                    return false;
                }
                ((RandomAccessFile) obj).close();
            }
            return true;
        } catch (IOException e16) {
            QLog.e("[DynamicFeature] Load", 1, "closeDataObject: failed. ", e16);
            return false;
        }
    }

    public Resources i(Context context, List<String> list) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (Resources) iPatchRedirector.redirect((short) 6, (Object) this, (Object) context, (Object) list);
        }
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Resources b16 = m.b(context, list);
            QLog.i("plugin_tag", 1, "[resources] inject df plugin time cost: " + (System.currentTimeMillis() - currentTimeMillis));
            return b16;
        } catch (InjectFailException e16) {
            QLog.e("plugin_tag", 1, "inject plugin resource error: ", e16);
            return null;
        }
    }

    public boolean j(String str, Application application) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) application)).booleanValue();
        }
        File file = new File(PluginUtils.getPluginInstallDir(application), str);
        try {
            String absolutePath = file.getAbsolutePath();
            a(application, absolutePath);
            long currentTimeMillis = System.currentTimeMillis();
            boolean c16 = c(absolutePath);
            File e16 = e(str);
            if (e16.exists()) {
                e16.delete();
            }
            QLog.i("plugin_tag", 1, "install df plugin extractFeatureApkSo " + file.getName() + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
            return c16;
        } catch (Exception e17) {
            QLog.e("plugin_tag", 1, "install df plugin error. ", e17);
            return false;
        }
    }

    public boolean l() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return ((Boolean) iPatchRedirector.redirect((short) 7, (Object) this)).booleanValue();
        }
        Iterator<String> it = ((IBuildConfig) QRoute.api(IBuildConfig.class)).getDynamicFeaturePlugins().iterator();
        while (it.hasNext()) {
            if (!e(it.next()).exists()) {
                return false;
            }
        }
        return true;
    }

    public boolean m(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Boolean) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str)).booleanValue();
        }
        return this.f195458a.contains(str);
    }

    public synchronized boolean o(String str, Application application) {
        boolean z16;
        boolean z17;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return ((Boolean) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) application)).booleanValue();
        }
        if (this.f195458a.contains(str)) {
            return true;
        }
        File file = new File(PluginUtils.getPluginInstallDir(application), str);
        if (!file.exists()) {
            return false;
        }
        try {
            String absolutePath = file.getAbsolutePath();
            QLog.d("plugin_tag", 1, "load dynamic feature plugin: ", absolutePath);
            if (this.f195460c == null && GuardManager.sInstance != null) {
                C7375a c7375a = new C7375a();
                this.f195460c = c7375a;
                GuardManager.sInstance.registerCallBack(c7375a);
            }
            boolean exists = e(str).exists();
            long currentTimeMillis = System.currentTimeMillis();
            String h16 = dd.h(application, absolutePath, "", true, exists);
            QLog.i("plugin_tag", 1, "[dex] inject df plugin time " + file.getName() + " cost: " + (System.currentTimeMillis() - currentTimeMillis) + " , is oat mode: " + exists);
            if (i(application, Collections.singletonList(absolutePath)) != null) {
                z16 = true;
            } else {
                z16 = false;
            }
            QLog.d("plugin_tag", 1, "install df plugin success", " output: ", absolutePath, " clsRet: ", h16, " resRet: ", Boolean.valueOf(z16), " inject so: ", Boolean.valueOf(h()));
            if ("Success".equals(h16) && z16) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                this.f195458a.add(str);
            }
            return z17;
        } catch (Exception e16) {
            QLog.e("plugin_tag", 1, "install df plugin error. ", e16);
            return false;
        }
    }

    public void p(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        BaseApplicationImpl baseApplicationImpl = BaseApplicationImpl.sApplication;
        File file = new File(PluginUtils.getPluginInstallDir(baseApplicationImpl), str);
        File e16 = e(str);
        Object obj = this.f195459b.get(file.getAbsolutePath());
        if (obj == null) {
            obj = new Object();
            this.f195459b.put(file.getAbsolutePath(), obj);
        }
        synchronized (obj) {
            if (e16.exists()) {
                return;
            }
            if (!e16.getParentFile().exists()) {
                e16.getParentFile().mkdirs();
            }
            QLog.i("plugin_tag", 1, "start oat " + file.getName());
            long currentTimeMillis = System.currentTimeMillis();
            DexClassLoaderUtil.createDexClassLoader(file.getAbsolutePath(), baseApplicationImpl.getDir("dex", 0).getAbsolutePath(), file.getAbsolutePath(), baseApplicationImpl.getClassLoader());
            QLog.i("plugin_tag", 1, "[oat] inject df plugin time " + file.getName() + " cost: " + (System.currentTimeMillis() - currentTimeMillis));
            try {
                e16.createNewFile();
            } catch (IOException e17) {
                QLog.e("plugin_tag", 1, "oat " + file.getName() + " success, but create " + e16.getName() + " failed!", e17);
            }
        }
    }

    public boolean q(File file, File file2) {
        QZipInputStream qZipInputStream;
        BufferedOutputStream bufferedOutputStream;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return ((Boolean) iPatchRedirector.redirect((short) 10, (Object) this, (Object) file, (Object) file2)).booleanValue();
        }
        if (file == null || file.length() < 1 || !file.canRead()) {
            return false;
        }
        String d16 = d();
        if (!file2.exists()) {
            file2.mkdirs();
        }
        byte[] bArr = new byte[8192];
        Object obj = null;
        try {
            try {
                qZipInputStream = new QZipInputStream(new BufferedInputStream(new FileInputStream(file)));
                while (true) {
                    try {
                        ZipEntry nextEntry = qZipInputStream.getNextEntry();
                        if (nextEntry != null) {
                            String name = nextEntry.getName();
                            if (!name.contains("../") && !nextEntry.isDirectory()) {
                                boolean startsWith = name.startsWith("lib/" + d16 + "/");
                                boolean endsWith = name.endsWith(QZonePatchService.PATCH_SUFFIX_DEX);
                                if (startsWith) {
                                    File file3 = new File(file2, name);
                                    file3.getParentFile().mkdirs();
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file3));
                                    while (true) {
                                        try {
                                            int read = qZipInputStream.read(bArr, 0, 8192);
                                            if (-1 == read) {
                                                break;
                                            }
                                            bufferedOutputStream.write(bArr, 0, read);
                                        } catch (IOException e16) {
                                            e = e16;
                                            obj = bufferedOutputStream;
                                            e.printStackTrace();
                                            b(obj);
                                            b(qZipInputStream);
                                            return false;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            obj = bufferedOutputStream;
                                            b(obj);
                                            b(qZipInputStream);
                                            throw th;
                                        }
                                    }
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                } else if (endsWith && n()) {
                                    File file4 = new File(f(file), name);
                                    file4.getParentFile().mkdirs();
                                    bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file4));
                                    while (true) {
                                        int read2 = qZipInputStream.read(bArr, 0, 8192);
                                        if (-1 == read2) {
                                            break;
                                        }
                                        bufferedOutputStream.write(bArr, 0, read2);
                                    }
                                    bufferedOutputStream.flush();
                                    bufferedOutputStream.close();
                                }
                                obj = bufferedOutputStream;
                            }
                        } else {
                            qZipInputStream.closeEntry();
                            qZipInputStream.close();
                            b(obj);
                            b(qZipInputStream);
                            return true;
                        }
                    } catch (IOException e17) {
                        e = e17;
                    }
                }
            } catch (IOException e18) {
                e = e18;
                qZipInputStream = null;
            } catch (Throwable th6) {
                th = th6;
                qZipInputStream = null;
            }
        } catch (Throwable th7) {
            th = th7;
        }
    }
}
