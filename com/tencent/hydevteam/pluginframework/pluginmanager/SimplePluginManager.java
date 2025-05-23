package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.progress.Progress;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.common.progress.ProgressFutureImpl;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.hydevteam.pluginframework.installedplugin.PluginRunningPath;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.ProxyExecutors;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import org.json.JSONException;

@API
/* loaded from: classes7.dex */
public class SimplePluginManager implements PluginManager {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public static final Map<String, Object> f114749a;

    /* renamed from: i, reason: collision with root package name */
    private static final File f114750i;

    /* renamed from: b, reason: collision with root package name */
    private final File f114751b;

    /* renamed from: c, reason: collision with root package name */
    private final File f114752c;

    /* renamed from: d, reason: collision with root package name */
    private final Downloader f114753d;

    /* renamed from: e, reason: collision with root package name */
    private final VersionChecker f114754e;

    /* renamed from: f, reason: collision with root package name */
    private final TargetManager f114755f;

    /* renamed from: g, reason: collision with root package name */
    private final UnpackManager f114756g;

    /* renamed from: h, reason: collision with root package name */
    private final ExecutorService f114757h;

    /* renamed from: j, reason: collision with root package name */
    private File f114758j;

    /* loaded from: classes7.dex */
    private class GetPluginTask implements Progress, Callable<InstalledPlugin> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private TargetDownloadInfo f114759a;

        /* renamed from: b, reason: collision with root package name */
        private boolean f114760b;

        /* renamed from: c, reason: collision with root package name */
        private volatile ProgressFuture<File> f114761c;

        /* renamed from: d, reason: collision with root package name */
        private volatile int f114762d;

        GetPluginTask(TargetDownloadInfo targetDownloadInfo, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SimplePluginManager.this, targetDownloadInfo, Boolean.valueOf(z16));
                return;
            }
            this.f114762d = 0;
            this.f114760b = z16;
            this.f114759a = targetDownloadInfo;
        }

        private void a(int i3) {
            this.f114762d += i3;
        }

        private InstalledPlugin b() throws ExecutionException, InterruptedException, IOException, JSONException {
            InstalledPlugin c16;
            Map<String, Object> map = SimplePluginManager.f114749a;
            Object obj = map.get(this.f114759a.hash);
            if (obj == null) {
                obj = new Object();
                map.put(this.f114759a.hash, obj);
            }
            synchronized (obj) {
                File file = new File(SimplePluginManager.this.f114755f.f114779a, this.f114759a.hash);
                try {
                    c16 = SimplePluginManager.this.f114756g.c(file);
                } catch (Exception unused) {
                    if (file.exists()) {
                        file.delete();
                    }
                    TargetManager targetManager = SimplePluginManager.this.f114755f;
                    String str = this.f114759a.hash;
                    ProgressFuture<File> download = SimplePluginManager.this.f114753d.download(this.f114759a, file, new File(targetManager.f114780b, "downloading." + str));
                    a(5);
                    this.f114761c = download;
                    file = download.get();
                    a(5);
                    c16 = SimplePluginManager.this.f114756g.c(file);
                    file.delete();
                    a(5);
                }
                file.delete();
                this.f114762d = 100;
            }
            return c16;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ InstalledPlugin call() throws Exception {
            if (this.f114760b) {
                return a();
            }
            if (this.f114759a != null) {
                return b();
            }
            throw new InvalidParameterException("\u4e0d\u4f7f\u7528\u672c\u5730\u7f13\u5b58\uff0c\u4e5f\u6ca1\u6709\u66f4\u65b0\u4fe1\u606f");
        }

        @Override // com.tencent.hydevteam.common.progress.Progress
        public double getProgress() {
            double d16;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
            }
            if (this.f114761c != null) {
                d16 = this.f114762d + ((100 - this.f114762d) * this.f114761c.getProgress());
            } else {
                d16 = this.f114762d;
            }
            return d16 / 100.0d;
        }

        private InstalledPlugin a() throws Exception {
            InstalledPlugin a16 = SimplePluginManager.this.f114756g.a();
            a(10);
            List<File> arrayList = new ArrayList();
            if (a16 == null) {
                arrayList = MinFileUtils.b(SimplePluginManager.this.f114755f.f114779a);
            }
            a(10);
            if (a16 == null && this.f114759a != null) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    File file = (File) it.next();
                    if (!SimplePluginManager.this.f114756g.b(file) && file.getName().equals(this.f114759a.hash)) {
                        try {
                            a16 = SimplePluginManager.this.f114756g.c(file);
                            break;
                        } catch (IOException | JSONException unused) {
                            a(5);
                        }
                    }
                }
            }
            if (a16 == null) {
                for (File file2 : arrayList) {
                    if (!SimplePluginManager.this.f114756g.b(file2)) {
                        try {
                            a16 = SimplePluginManager.this.f114756g.c(file2);
                            break;
                        } catch (IOException | JSONException unused2) {
                            a(5);
                        }
                    }
                }
            }
            this.f114762d = 100;
            if (a16 != null) {
                return a16;
            }
            throw new Exception("\u627e\u4e0d\u5230\u672c\u5730\u63d2\u4ef6");
        }
    }

    /* loaded from: classes7.dex */
    private class GetTestPluginTask implements Progress, Callable<InstalledPlugin> {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private boolean f114764a;

        GetTestPluginTask(boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, SimplePluginManager.this, Boolean.valueOf(z16));
            } else {
                this.f114764a = z16;
            }
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ InstalledPlugin call() throws Exception {
            if (!this.f114764a) {
                File a16 = SimplePluginManager.this.f114756g.a(SimplePluginManager.this.f114758j);
                if (a16.exists()) {
                    MinFileUtils.c(a16);
                    a16.delete();
                }
                return SimplePluginManager.this.f114756g.c(SimplePluginManager.this.f114758j);
            }
            throw new Exception("TestPlugin\u65e0\u9700\u66f4\u65b0");
        }

        @Override // com.tencent.hydevteam.common.progress.Progress
        public double getProgress() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return ((Double) iPatchRedirector.redirect((short) 2, (Object) this)).doubleValue();
            }
            return 1.0d;
        }
    }

    /* loaded from: classes7.dex */
    private class PluginPreloadTask implements Runnable {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private File f114766a;

        /* renamed from: b, reason: collision with root package name */
        private Context f114767b;

        /* renamed from: c, reason: collision with root package name */
        private String f114768c;

        /* renamed from: d, reason: collision with root package name */
        private String f114769d;

        /* renamed from: e, reason: collision with root package name */
        private boolean f114770e;

        PluginPreloadTask(Context context, File file, String str, String str2, boolean z16) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, this, context, file, str, str2, Boolean.valueOf(z16));
                return;
            }
            this.f114767b = context;
            this.f114766a = file;
            this.f114768c = str;
            this.f114769d = str2;
            this.f114770e = z16;
        }

        @Override // java.lang.Runnable
        public void run() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this);
                return;
            }
            if (!this.f114770e) {
                String pluginOptDexDir = PluginRunningPath.getPluginOptDexDir(this.f114767b, this.f114768c, this.f114769d);
                new DexClassLoader(this.f114766a.getAbsolutePath(), pluginOptDexDir, PluginRunningPath.getPluginNewLibDir(this.f114767b, this.f114768c, this.f114769d), this.f114767b.getClassLoader());
                try {
                    new File(pluginOptDexDir, this.f114766a.getName() + ".preload").createNewFile();
                } catch (IOException e16) {
                    e16.printStackTrace();
                }
            }
        }
    }

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11785);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 6)) {
            redirector.redirect((short) 6);
        } else {
            f114750i = new File("/data/local/tmp");
            f114749a = new HashMap();
        }
    }

    public SimplePluginManager(File file, Downloader downloader, VersionChecker versionChecker, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, downloader, versionChecker, str);
            return;
        }
        this.f114757h = ProxyExecutors.newSingleThreadExecutor();
        this.f114751b = file;
        File file2 = new File(file, "PluginManager_" + str);
        this.f114752c = file2;
        this.f114755f = new TargetManager(file2);
        if (file2.exists() && !file2.isDirectory()) {
            throw new IllegalArgumentException(file2.getAbsolutePath() + "\u5df2\u5b58\u5728\u4e14\u4e0d\u662f\u76ee\u5f55");
        }
        this.f114756g = new UnpackManager(file2);
        this.f114753d = downloader;
        this.f114754e = versionChecker;
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public List<InstalledPlugin> getCachedLatestPlugin(String str) {
        Callable getPluginTask;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (List) iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
        ArrayList arrayList = new ArrayList();
        if (a(str)) {
            getPluginTask = new GetTestPluginTask(false);
        } else {
            getPluginTask = new GetPluginTask(null, true);
        }
        try {
            arrayList.add((InstalledPlugin) this.f114757h.submit(getPluginTask).get());
            return arrayList;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public VersionChecker getVersionChecker() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (VersionChecker) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f114754e;
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public ProgressFuture preloadApk(Context context, InstalledPlugin installedPlugin, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (ProgressFuture) iPatchRedirector.redirect((short) 5, this, context, installedPlugin, Boolean.valueOf(z16));
        }
        return new ProgressFutureImpl(this.f114757h.submit(new PluginPreloadTask(context, installedPlugin.pluginFile, installedPlugin.pluginPackageName, installedPlugin.pluginVersionForPluginLoaderManage, z16)), null);
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public List<ProgressFuture<InstalledPlugin>> updatePlugin(String str, TargetDownloadInfo targetDownloadInfo, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (List) iPatchRedirector.redirect((short) 4, this, str, targetDownloadInfo, str2);
        }
        ArrayList arrayList = new ArrayList();
        if (a(str)) {
            GetTestPluginTask getTestPluginTask = new GetTestPluginTask(true);
            arrayList.add(new ProgressFutureImpl(this.f114757h.submit(getTestPluginTask), getTestPluginTask));
            return arrayList;
        }
        GetPluginTask getPluginTask = new GetPluginTask(targetDownloadInfo, false);
        arrayList.add(new ProgressFutureImpl(this.f114757h.submit(getPluginTask), getPluginTask));
        return arrayList;
    }

    private boolean a(String str) {
        File file = new File(f114750i, str + ".zip");
        this.f114758j = file;
        return file.exists();
    }
}
