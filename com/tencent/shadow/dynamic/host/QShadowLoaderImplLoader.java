package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.util.Log;
import com.tencent.shadow.core.common.InstalledApk;

/* compiled from: P */
/* loaded from: classes25.dex */
public class QShadowLoaderImplLoader extends ImplLoader {
    private static final String TAG = "ShadowTag.QShadowLoader";
    private static final String[] sInterfaces = {"com.tencent.shadow.core.runtime.container", BuildConfig.LIBRARY_PACKAGE_NAME, com.tencent.shadow.core.common.BuildConfig.LIBRARY_PACKAGE_NAME};
    private static final String sLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.LoaderFactoryImpl";
    private static final String sQShadowLoaderFactoryImplClassName = "com.tencent.shadow.dynamic.loader.impl.QShadowCoreLoaderFactoryImpl";

    @Override // com.tencent.shadow.dynamic.host.ImplLoader
    String[] getCustomWhiteList() {
        return sInterfaces;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public PluginLoaderImpl load(InstalledApk installedApk, String str, Context context) throws Exception {
        ChangeApkContextWrapper changeApkContextWrapper;
        Log.w(TAG, "load uuid = " + str);
        ApkClassLoader apkClassLoader = new ApkClassLoader(installedApk, LoaderImplLoader.class.getClassLoader(), loadWhiteList(installedApk), 1);
        Log.w(TAG, "loadLoader loadNormalFactory");
        LoaderFactory loaderFactory = (LoaderFactory) apkClassLoader.getInterface(LoaderFactory.class, sLoaderFactoryImplClassName);
        Log.w(TAG, "loadLoader loadTryQShadowFactory");
        try {
            apkClassLoader.loadClass(sQShadowLoaderFactoryImplClassName);
            Log.w(TAG, "ChangeApkContextWrapper");
            changeApkContextWrapper = new ChangeApkContextWrapper(context, installedApk.apkFilePath, apkClassLoader);
        } catch (ClassNotFoundException unused) {
            Log.w(TAG, "\u4e0d\u5b58\u5728QShadowCoreLoaderFactoryImpl\uff0c\u4e3ashadow\u539f\u751f\u63d2\u4ef6\uff0cbuildLoader\u4f20\u5165\u5bbf\u4e3bContext");
            changeApkContextWrapper = null;
        }
        Log.w(TAG, "loadLoader buildLoader");
        if (changeApkContextWrapper != null) {
            context = changeApkContextWrapper;
        }
        return loaderFactory.buildLoader(str, context);
    }
}
