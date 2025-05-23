package com.tencent.hydevteam.pluginframework.pluginmanager;

import android.content.Context;
import com.tencent.hydevteam.common.annotation.API;
import com.tencent.hydevteam.common.classloader.ApkClassLoader;
import com.tencent.hydevteam.common.progress.ProgressFuture;
import com.tencent.hydevteam.pluginframework.installedplugin.InstalledPlugin;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

@API
/* loaded from: classes7.dex */
public class UpgradeablePluginManager implements PluginManager {
    static IPatchRedirector $redirector_;

    /* renamed from: e, reason: collision with root package name */
    private static final File f114782e;

    /* renamed from: g, reason: collision with root package name */
    private static final String f114783g;

    /* renamed from: h, reason: collision with root package name */
    private static String[] f114784h;

    /* renamed from: a, reason: collision with root package name */
    private File f114785a;

    /* renamed from: b, reason: collision with root package name */
    private File f114786b;

    /* renamed from: c, reason: collision with root package name */
    private PluginManager f114787c;

    /* renamed from: d, reason: collision with root package name */
    private final Object f114788d;

    /* renamed from: f, reason: collision with root package name */
    private final File f114789f;

    /* renamed from: i, reason: collision with root package name */
    private final String f114790i;

    /* renamed from: j, reason: collision with root package name */
    private boolean f114791j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(11846);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        f114782e = new File("/data/local/tmp");
        f114783g = UpgradeablePluginManager.class.getSimpleName() + "\u6ca1\u6709\u521d\u59cb\u5316\u3002\u8bf7\u5148\u7528upgradeIfNeededThenInit\u65b9\u6cd5\u3002";
        f114784h = new String[]{"com.tencent.hydevteam.common.annotation", "com.tencent.hydevteam.common.progress", "com.tencent.hydevteam.pluginframework.installedplugin", "com.tencent.hydevteam.pluginframework.pluginmanager", "com.tencent.qphone.base.util"};
    }

    public UpgradeablePluginManager(File file, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, file, str, Boolean.valueOf(z16));
            return;
        }
        this.f114788d = new Object();
        this.f114785a = file;
        this.f114790i = str;
        this.f114786b = new File(this.f114785a, "PluginManager_" + str);
        this.f114789f = new File(this.f114786b, "pluginmanager1_4.apk");
        this.f114791j = z16;
    }

    private String a(File file, File file2, int i3) throws Exception {
        String[] strArr = f114784h;
        if (file2.exists() && !file2.isDirectory()) {
            throw new IOException(file2.getAbsolutePath() + "\u5df2\u5b58\u5728\u4e14\u4e0d\u662f\u76ee\u5f55");
        }
        if (i3 == 1) {
            file2.mkdirs();
            MinFileUtils.c(file2);
        }
        ApkClassLoader apkClassLoader = new ApkClassLoader(file.getAbsolutePath(), file2.getAbsolutePath(), null, UpgradeablePluginManager.class.getClassLoader(), strArr);
        Downloader downloader = (Downloader) apkClassLoader.a(Downloader.class, "com.tencent.hydevteam.pluginframework.pluginmanager.DownloaderImpl");
        VersionChecker versionChecker = (VersionChecker) apkClassLoader.a(VersionChecker.class, "com.tencent.hydevteam.pluginframework.pluginmanager.VersionCheckerImpl");
        synchronized (this.f114788d) {
            this.f114787c = (PluginManager) apkClassLoader.a(PluginManager.class, "com.tencent.hydevteam.pluginframework.pluginmanager.PluginManagerImpl", new Class[]{File.class, Downloader.class, VersionChecker.class}, new Object[]{this.f114785a, downloader, versionChecker});
        }
        return "\u4f7f\u7528" + this.f114789f.getAbsolutePath() + ".";
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public final List<InstalledPlugin> getCachedLatestPlugin(String str) {
        boolean z16;
        List<InstalledPlugin> cachedLatestPlugin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return (List) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
        }
        synchronized (this.f114788d) {
            if (this.f114787c == null) {
                try {
                    initWithoutUpgrade();
                    z16 = true;
                } catch (Exception unused) {
                    return null;
                }
            } else {
                z16 = false;
            }
            cachedLatestPlugin = this.f114787c.getCachedLatestPlugin(str);
            if (z16) {
                this.f114787c = null;
            }
        }
        return cachedLatestPlugin;
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public final VersionChecker getVersionChecker() {
        VersionChecker versionChecker;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (VersionChecker) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        synchronized (this.f114788d) {
            PluginManager pluginManager = this.f114787c;
            if (pluginManager != null) {
                versionChecker = pluginManager.getVersionChecker();
            } else {
                throw new IllegalStateException(f114783g);
            }
        }
        return versionChecker;
    }

    @API
    public void initWithoutUpgrade() throws Exception {
        File file;
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        File file2 = new File(f114782e, "pluginmanager1_4.apk");
        if (file2.exists()) {
            file = new File(this.f114786b, "pluginmanager1_4_odex");
            i3 = 1;
        } else {
            file2 = this.f114789f;
            file = new File(file2.getParentFile(), "pluginmanager1_4_odex");
            i3 = -1;
        }
        a(file2, file, i3);
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public final ProgressFuture preloadApk(Context context, InstalledPlugin installedPlugin, boolean z16) {
        ProgressFuture preloadApk;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ProgressFuture) iPatchRedirector.redirect((short) 7, this, context, installedPlugin, Boolean.valueOf(z16));
        }
        synchronized (this.f114788d) {
            PluginManager pluginManager = this.f114787c;
            if (pluginManager != null) {
                preloadApk = pluginManager.preloadApk(context, installedPlugin, z16);
            } else {
                throw new IllegalStateException(f114783g);
            }
        }
        return preloadApk;
    }

    @Override // com.tencent.hydevteam.pluginframework.pluginmanager.PluginManager
    @API
    public final List<ProgressFuture<InstalledPlugin>> updatePlugin(String str, TargetDownloadInfo targetDownloadInfo, String str2) {
        List<ProgressFuture<InstalledPlugin>> updatePlugin;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (List) iPatchRedirector.redirect((short) 6, this, str, targetDownloadInfo, str2);
        }
        synchronized (this.f114788d) {
            PluginManager pluginManager = this.f114787c;
            if (pluginManager != null) {
                updatePlugin = pluginManager.updatePlugin(str, targetDownloadInfo, str2);
            } else {
                throw new IllegalStateException(f114783g);
            }
        }
        return updatePlugin;
    }

    @API
    public int upgradeIfNeededThenInit(long j3, TimeUnit timeUnit) throws Exception {
        File file;
        File file2;
        File file3;
        File file4;
        long j16;
        StringBuilder sb5;
        IPatchRedirector iPatchRedirector = $redirector_;
        int i3 = 0;
        int i16 = 1;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), timeUnit)).intValue();
        }
        try {
            file3 = new File(f114782e, "pluginmanager1_4.apk");
            if (file3.exists()) {
                try {
                    file4 = new File(this.f114786b, "pluginmanager1_4_odex");
                    try {
                        file3.getAbsolutePath();
                    } catch (Exception e16) {
                        e = e16;
                        file2 = file4;
                        i3 = -1;
                        file = file3;
                        e.toString();
                        file3 = file;
                        i16 = i3;
                        file4 = file2;
                        a(file3, file4, i16);
                        return i16;
                    }
                } catch (Exception e17) {
                    e = e17;
                    i3 = -1;
                    file = file3;
                    file2 = null;
                    e.toString();
                    file3 = file;
                    i16 = i3;
                    file4 = file2;
                    a(file3, file4, i16);
                    return i16;
                }
            } else {
                if (this.f114789f.lastModified() != 0) {
                    j16 = 1500;
                } else {
                    j16 = j3;
                }
                if (this.f114791j) {
                    sb5 = new StringBuilder("https://dldir1.qq.com/huayang/Android/PluginManager1_4_");
                    sb5.append(this.f114790i);
                    sb5.append("_test");
                } else {
                    sb5 = new StringBuilder("https://dldir1.qq.com/huayang/Android/PluginManager1_4_");
                    sb5.append(this.f114790i);
                }
                try {
                    file3 = new LengthHashURLConnectionDownloader().download(new TargetDownloadInfo(sb5.toString(), "", 0L), this.f114789f, new File(this.f114789f.getParentFile(), "pluginmanager1_4.apk.downloading")).get(j16, timeUnit);
                    i3 = 1;
                } catch (Exception e18) {
                    e18.toString();
                    try {
                        file3 = this.f114789f;
                    } catch (Exception e19) {
                        e = e19;
                        file = null;
                        file2 = null;
                        e.toString();
                        file3 = file;
                        i16 = i3;
                        file4 = file2;
                        a(file3, file4, i16);
                        return i16;
                    }
                }
                try {
                    i16 = i3;
                    file4 = new File(file3.getParentFile(), "pluginmanager1_4_odex");
                } catch (Exception e26) {
                    e = e26;
                    file = file3;
                    file2 = null;
                    e.toString();
                    file3 = file;
                    i16 = i3;
                    file4 = file2;
                    a(file3, file4, i16);
                    return i16;
                }
            }
        } catch (Exception e27) {
            e = e27;
            i3 = -1;
        }
        a(file3, file4, i16);
        return i16;
    }
}
