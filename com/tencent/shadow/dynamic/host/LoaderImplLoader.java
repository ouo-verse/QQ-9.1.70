package com.tencent.shadow.dynamic.host;

import android.content.Context;
import com.tencent.shadow.core.common.InstalledApk;

/* compiled from: P */
/* loaded from: classes25.dex */
final class LoaderImplLoader extends ImplLoader {
    private static final String[] sInterfaces = {"com.tencent.shadow.core.runtime.container", BuildConfig.LIBRARY_PACKAGE_NAME, com.tencent.shadow.core.common.BuildConfig.LIBRARY_PACKAGE_NAME};
    private static final String sLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl";

    @Override // com.tencent.shadow.dynamic.host.ImplLoader
    String[] getCustomWhiteList() {
        return sInterfaces;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginLoaderImpl load(InstalledApk installedApk, String str, Context context) throws Exception {
        return ((LoaderFactory) new ApkClassLoader(installedApk, LoaderImplLoader.class.getClassLoader(), loadWhiteList(installedApk), 1).getInterface(LoaderFactory.class, sLoaderFactoryImplClassName)).buildLoader(str, context);
    }
}
