package com.tencent.qcircle.shadow.core.runtime;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.MixResources;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import android.view.LayoutInflater;
import com.tencent.qcircle.shadow.core.runtime.qcircle.container.HostActivityDelegator;
import com.tencent.qcircle.shadow.core.runtime.remoteview.ShadowRemoteViewCreatorProvider;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/* compiled from: P */
/* loaded from: classes22.dex */
public class ShadowContext extends SubDirContextThemeWrapper {
    ApplicationInfo mApplicationInfo;
    private String mBusinessName;
    LayoutInflater mLayoutInflater;
    Resources mMixResources;
    protected String mPartKey;
    ClassLoader mPluginClassLoader;
    PluginComponentLauncher mPluginComponentLauncher;
    Resources mPluginResources;
    private ShadowRemoteViewCreatorProvider mRemoteViewCreatorProvider;
    ShadowApplication mShadowApplication;

    /* compiled from: P */
    /* loaded from: classes22.dex */
    public interface PluginComponentLauncher {
        Pair<Boolean, Boolean> bindService(ShadowContext shadowContext, Intent intent, ServiceConnection serviceConnection, int i3);

        Intent convertPluginActivityIntent(Intent intent);

        boolean startActivity(ShadowContext shadowContext, Intent intent, Bundle bundle);

        boolean startActivityForResult(HostActivityDelegator hostActivityDelegator, Intent intent, int i3, Bundle bundle, ComponentName componentName);

        Pair<Boolean, ComponentName> startService(ShadowContext shadowContext, Intent intent);

        Pair<Boolean, Boolean> stopService(ShadowContext shadowContext, Intent intent);

        Pair<Boolean, ?> unbindService(ShadowContext shadowContext, ServiceConnection serviceConnection);
    }

    public ShadowContext() {
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        if (intent.getComponent() == null) {
            return super.bindService(intent, serviceConnection, i3);
        }
        Pair<Boolean, Boolean> bindService = this.mPluginComponentLauncher.bindService(this, intent, serviceConnection, i3);
        if (!((Boolean) bindService.first).booleanValue()) {
            return super.bindService(intent, serviceConnection, i3);
        }
        return ((Boolean) bindService.second).booleanValue();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ String[] databaseList() {
        return super.databaseList();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ boolean deleteDatabase(String str) {
        return super.deleteDatabase(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ boolean deleteFile(String str) {
        return super.deleteFile(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ boolean deleteSharedPreferences(String str) {
        return super.deleteSharedPreferences(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return this.mShadowApplication;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mApplicationInfo;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mPluginResources.getAssets();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getCacheDir() {
        return super.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPluginClassLoader;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getCodeCacheDir() {
        return super.getCodeCacheDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getDataDir() {
        return super.getDataDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getDatabasePath(String str) {
        return super.getDatabasePath(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getDir(String str, int i3) {
        return super.getDir(str, i3);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getExternalCacheDir() {
        return super.getExternalCacheDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File[] getExternalCacheDirs() {
        return super.getExternalCacheDirs();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getExternalFilesDir(String str) {
        return super.getExternalFilesDir(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File[] getExternalFilesDirs(String str) {
        return super.getExternalFilesDirs(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File[] getExternalMediaDirs() {
        return super.getExternalMediaDirs();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getFilesDir() {
        return super.getFilesDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getNoBackupFilesDir() {
        return super.getNoBackupFilesDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File getObbDir() {
        return super.getObbDir();
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ File[] getObbDirs() {
        return super.getObbDirs();
    }

    public PluginComponentLauncher getPendingIntentConverter() {
        return this.mPluginComponentLauncher;
    }

    public final ShadowRemoteViewCreatorProvider getRemoteViewCreatorProvider() {
        return this.mRemoteViewCreatorProvider;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        Resources resources;
        if (Build.VERSION.SDK_INT > 27) {
            return this.mPluginResources;
        }
        if (this.mMixResources == null) {
            Context baseContext = getBaseContext();
            if (baseContext instanceof HostActivityDelegator) {
                resources = ((HostActivityDelegator) baseContext).superGetResources();
            } else {
                resources = baseContext.getResources();
            }
            this.mMixResources = new MixResources(resources, this.mPluginResources);
        }
        return this.mMixResources;
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ SharedPreferences getSharedPreferences(String str, int i3) {
        return super.getSharedPreferences(str, i3);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper
    String getSubDirName() {
        if (this.mBusinessName == null) {
            return null;
        }
        return "ShadowPlugin_" + this.mBusinessName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if ("layout_inflater".equals(str)) {
            if (this.mLayoutInflater == null) {
                this.mLayoutInflater = ShadowLayoutInflater.build((LayoutInflater) super.getSystemService(str), this, this.mPartKey);
            }
            return this.mLayoutInflater;
        }
        return super.getSystemService(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ boolean moveDatabaseFrom(Context context, String str) {
        return super.moveDatabaseFrom(context, str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ FileInputStream openFileInput(String str) throws FileNotFoundException {
        return super.openFileInput(str);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ FileOutputStream openFileOutput(String str, int i3) throws FileNotFoundException {
        return super.openFileOutput(str, i3);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return super.openOrCreateDatabase(str, i3, cursorFactory);
    }

    public void setApplicationInfo(ApplicationInfo applicationInfo) {
        ApplicationInfo applicationInfo2 = new ApplicationInfo(applicationInfo);
        applicationInfo2.metaData = null;
        this.mApplicationInfo = applicationInfo2;
    }

    public void setBusinessName(String str) {
        if (TextUtils.isEmpty(str)) {
            str = null;
        }
        this.mBusinessName = str;
    }

    public final void setPluginClassLoader(ClassLoader classLoader) {
        this.mPluginClassLoader = classLoader;
    }

    public void setPluginComponentLauncher(PluginComponentLauncher pluginComponentLauncher) {
        this.mPluginComponentLauncher = pluginComponentLauncher;
    }

    public void setPluginPartKey(String str) {
        this.mPartKey = str;
    }

    public final void setPluginResources(Resources resources) {
        this.mPluginResources = resources;
    }

    public final void setRemoteViewCreatorProvider(ShadowRemoteViewCreatorProvider shadowRemoteViewCreatorProvider) {
        this.mRemoteViewCreatorProvider = shadowRemoteViewCreatorProvider;
    }

    public void setShadowApplication(ShadowApplication shadowApplication) {
        this.mShadowApplication = shadowApplication;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        startActivity(intent, null);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        if (intent.getComponent() == null) {
            return super.startService(intent);
        }
        Pair<Boolean, ComponentName> startService = this.mPluginComponentLauncher.startService(this, intent);
        if (!((Boolean) startService.first).booleanValue()) {
            return super.startService(intent);
        }
        return (ComponentName) startService.second;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        if (intent.getComponent() == null) {
            return super.stopService(intent);
        }
        Pair<Boolean, Boolean> stopService = this.mPluginComponentLauncher.stopService(this, intent);
        if (!((Boolean) stopService.first).booleanValue()) {
            return super.stopService(intent);
        }
        return ((Boolean) stopService.second).booleanValue();
    }

    public void superStartActivity(Intent intent, Bundle bundle) {
        super.startActivity(intent, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        if (!((Boolean) this.mPluginComponentLauncher.unbindService(this, serviceConnection).first).booleanValue()) {
            super.unbindService(serviceConnection);
        }
    }

    public ShadowContext(Context context, int i3) {
        super(context, i3);
    }

    @Override // com.tencent.qcircle.shadow.core.runtime.SubDirContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public /* bridge */ /* synthetic */ SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return super.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        Intent intent2 = new Intent(intent);
        intent2.setExtrasClassLoader(this.mPluginClassLoader);
        if (this.mPluginComponentLauncher.startActivity(this, intent2, bundle)) {
            return;
        }
        super.startActivity(intent, bundle);
    }
}
