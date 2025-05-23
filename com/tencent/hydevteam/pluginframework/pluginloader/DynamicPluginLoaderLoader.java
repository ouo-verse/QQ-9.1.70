package com.tencent.hydevteam.pluginframework.pluginloader;

import com.tencent.hydevteam.common.classloader.ApkClassLoader;
import com.tencent.hydevteam.pluginframework.pluginloader.exceptions.DynamicPluginLoaderLoadException;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.File;

/* loaded from: classes7.dex */
class DynamicPluginLoaderLoader {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private final File f114742a;

    /* renamed from: b, reason: collision with root package name */
    private final String f114743b;

    /* renamed from: c, reason: collision with root package name */
    private final String f114744c;

    /* renamed from: d, reason: collision with root package name */
    private final String[] f114745d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public DynamicPluginLoaderLoader(String str, File file, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, file, str2, strArr);
            return;
        }
        this.f114743b = str;
        this.f114742a = file;
        this.f114744c = str2;
        this.f114745d = strArr;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PluginLoader a() throws DynamicPluginLoaderLoadException {
        if (this.f114742a.exists()) {
            if (this.f114742a.canRead()) {
                File file = new File(this.f114742a.getParent(), "DynamicPluginLoader_" + this.f114743b);
                if (file.exists() && !file.isDirectory()) {
                    throw new DynamicPluginLoaderLoadException("odexDir\u76ee\u6807\u8def\u5f84" + file.getAbsolutePath() + "\u5df2\u88ab\u5176\u4ed6\u6587\u4ef6\u5360\u7528");
                }
                if (!file.exists() && !file.mkdir()) {
                    throw new DynamicPluginLoaderLoadException("odexDir\u76ee\u6807\u8def\u5f84" + file.getAbsolutePath() + "\u521b\u5efa\u76ee\u5f55\u5931\u8d25");
                }
                File file2 = new File(this.f114742a.getParent(), "DynamicPluginLoader_lib_" + this.f114743b);
                if (!file2.exists() && !file2.mkdirs()) {
                    throw new DynamicPluginLoaderLoadException("libDir\u76ee\u6807\u8def\u5f84" + file2.getAbsolutePath() + "\u521b\u5efa\u76ee\u5f55\u5931\u8d25");
                }
                try {
                    return (PluginLoader) new ApkClassLoader(this.f114742a.getAbsolutePath(), file.getAbsolutePath(), file2.getAbsolutePath(), DynamicPluginLoaderLoader.class.getClassLoader(), this.f114745d).a(PluginLoader.class, this.f114744c);
                } catch (Exception e16) {
                    throw new DynamicPluginLoaderLoadException(e16);
                }
            }
            throw new DynamicPluginLoaderLoadException("\u6587\u4ef6" + this.f114742a.getAbsolutePath() + "\u4e0d\u53ef\u8bfb");
        }
        throw new DynamicPluginLoaderLoadException("\u6587\u4ef6" + this.f114742a.getAbsolutePath() + "\u4e0d\u5b58\u5728");
    }
}
