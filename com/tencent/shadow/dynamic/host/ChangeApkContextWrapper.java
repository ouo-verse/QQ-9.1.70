package com.tencent.shadow.dynamic.host;

import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* compiled from: P */
/* loaded from: classes25.dex */
class ChangeApkContextWrapper extends ContextWrapper {
    private final ClassLoader mClassloader;
    private LayoutInflater mLayoutInflater;
    private Resources mResources;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ChangeApkContextWrapper(Context context, String str, ClassLoader classLoader) {
        super(context);
        this.mClassloader = classLoader;
        this.mResources = createResources(str, context);
    }

    private Resources createResources(String str, Context context) {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = packageManager.getPackageArchiveInfo(str, 128).applicationInfo;
        applicationInfo.publicSourceDir = str;
        applicationInfo.sourceDir = str;
        try {
            return packageManager.getResourcesForApplication(applicationInfo);
        } catch (PackageManager.NameNotFoundException e16) {
            throw new RuntimeException(e16);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mClassloader;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mLayoutInflater == null) {
                this.mLayoutInflater = ((LayoutInflater) super.getSystemService(str)).cloneInContext(this);
            }
            return this.mLayoutInflater;
        }
        return super.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.mResources.newTheme();
    }
}
