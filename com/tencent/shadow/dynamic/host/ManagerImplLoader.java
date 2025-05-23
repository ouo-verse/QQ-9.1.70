package com.tencent.shadow.dynamic.host;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;
import java.io.File;

/* compiled from: P */
/* loaded from: classes25.dex */
final class ManagerImplLoader extends ImplLoader {
    private static final String MANAGER_FACTORY_CLASS_NAME = "com.tencent.shadow.dynamic.impl.ManagerFactoryImpl";
    private static final String[] REMOTE_PLUGIN_MANAGER_INTERFACES = {com.tencent.shadow.core.common.BuildConfig.LIBRARY_PACKAGE_NAME, BuildConfig.LIBRARY_PACKAGE_NAME};
    private final Context applicationContext;
    private final InstalledApk installedApk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ManagerImplLoader(Context context, File file) {
        Context applicationContext = context.getApplicationContext();
        this.applicationContext = applicationContext;
        File file2 = new File(new File(applicationContext.getFilesDir(), "ManagerImplLoader"), Long.toString(file.lastModified(), 36));
        file2.mkdirs();
        this.installedApk = new InstalledApk(file.getAbsolutePath(), file2.getAbsolutePath(), null);
    }

    @Override // com.tencent.shadow.dynamic.host.ImplLoader
    String[] getCustomWhiteList() {
        return REMOTE_PLUGIN_MANAGER_INTERFACES;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginManagerImpl load() {
        ApkClassLoader apkClassLoader = new ApkClassLoader(this.installedApk, ManagerImplLoader.class.getClassLoader(), loadWhiteList(this.installedApk), 1);
        try {
            return ((ManagerFactory) apkClassLoader.getInterface(ManagerFactory.class, MANAGER_FACTORY_CLASS_NAME)).buildManager(new ChangeApkContextWrapper(this.applicationContext, this.installedApk.apkFilePath, apkClassLoader));
        } catch (Exception e16) {
            throw new RuntimeException(e16);
        }
    }
}
