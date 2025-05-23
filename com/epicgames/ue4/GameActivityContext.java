package com.epicgames.ue4;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
/* loaded from: classes2.dex */
public class GameActivityContext extends Context {
    Context mBase;

    public GameActivityContext(Context context) {
        this.mBase = context;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void attachBaseContext(Context context) {
        this.mBase = context;
    }

    @Override // android.content.Context
    public boolean bindIsolatedService(Intent intent, int i3, String str, Executor executor, ServiceConnection serviceConnection) {
        boolean bindIsolatedService;
        bindIsolatedService = this.mBase.bindIsolatedService(intent, i3, str, executor, serviceConnection);
        return bindIsolatedService;
    }

    @Override // android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        return this.mBase.bindService(intent, serviceConnection, i3);
    }

    @Override // android.content.Context
    public boolean bindServiceAsUser(Intent intent, ServiceConnection serviceConnection, int i3, UserHandle userHandle) {
        boolean bindServiceAsUser;
        bindServiceAsUser = this.mBase.bindServiceAsUser(intent, serviceConnection, i3, userHandle);
        return bindServiceAsUser;
    }

    @Override // android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        return this.mBase.checkCallingOrSelfPermission(str);
    }

    @Override // android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i3) {
        return this.mBase.checkCallingOrSelfUriPermission(uri, i3);
    }

    @Override // android.content.Context
    public int checkCallingPermission(String str) {
        return this.mBase.checkCallingPermission(str);
    }

    @Override // android.content.Context
    public int checkCallingUriPermission(Uri uri, int i3) {
        return this.mBase.checkCallingUriPermission(uri, i3);
    }

    @Override // android.content.Context
    public int checkPermission(String str, int i3, int i16) {
        return this.mBase.checkPermission(str, i3, i16);
    }

    @Override // android.content.Context
    public int checkSelfPermission(String str) {
        return this.mBase.checkSelfPermission(str);
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, int i3, int i16, int i17) {
        return this.mBase.checkUriPermission(uri, i3, i16, i17);
    }

    @Override // android.content.Context
    @Deprecated
    public void clearWallpaper() throws IOException {
        this.mBase.clearWallpaper();
    }

    @Override // android.content.Context
    public Context createAttributionContext(@Nullable String str) {
        Context createAttributionContext;
        createAttributionContext = this.mBase.createAttributionContext(str);
        return createAttributionContext;
    }

    @Override // android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        return this.mBase.createConfigurationContext(configuration);
    }

    @Override // android.content.Context
    public Context createContextForSplit(String str) throws PackageManager.NameNotFoundException {
        Context createContextForSplit;
        createContextForSplit = this.mBase.createContextForSplit(str);
        return createContextForSplit;
    }

    @Override // android.content.Context
    public Context createDeviceProtectedStorageContext() {
        Context createDeviceProtectedStorageContext;
        createDeviceProtectedStorageContext = this.mBase.createDeviceProtectedStorageContext();
        return createDeviceProtectedStorageContext;
    }

    @Override // android.content.Context
    public Context createDisplayContext(Display display) {
        return this.mBase.createDisplayContext(display);
    }

    @Override // android.content.Context
    public Context createPackageContext(String str, int i3) throws PackageManager.NameNotFoundException {
        return this.mBase.createPackageContext(str, i3);
    }

    @Override // android.content.Context
    public Context createWindowContext(int i3, @Nullable Bundle bundle) {
        Context createWindowContext;
        createWindowContext = this.mBase.createWindowContext(i3, bundle);
        return createWindowContext;
    }

    @Override // android.content.Context
    public String[] databaseList() {
        return this.mBase.databaseList();
    }

    @Override // android.content.Context
    public boolean deleteDatabase(String str) {
        return this.mBase.deleteDatabase(str);
    }

    @Override // android.content.Context
    public boolean deleteFile(String str) {
        return this.mBase.deleteFile(str);
    }

    @Override // android.content.Context
    public boolean deleteSharedPreferences(String str) {
        boolean deleteSharedPreferences;
        deleteSharedPreferences = this.mBase.deleteSharedPreferences(str);
        return deleteSharedPreferences;
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        this.mBase.enforceCallingOrSelfPermission(str, str2);
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i3, String str) {
        this.mBase.enforceCallingOrSelfUriPermission(uri, i3, str);
    }

    @Override // android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        this.mBase.enforceCallingPermission(str, str2);
    }

    @Override // android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i3, String str) {
        this.mBase.enforceCallingUriPermission(uri, i3, str);
    }

    @Override // android.content.Context
    public void enforcePermission(String str, int i3, int i16, String str2) {
        this.mBase.enforcePermission(str, i3, i16, str2);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, int i3, int i16, int i17, String str) {
        this.mBase.enforceUriPermission(uri, i3, i16, i17, str);
    }

    @Override // android.content.Context
    public String[] fileList() {
        return this.mBase.fileList();
    }

    @Override // android.content.Context
    public Context getApplicationContext() {
        return this.mBase.getApplicationContext();
    }

    @Override // android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mBase.getApplicationInfo();
    }

    @Override // android.content.Context
    public AssetManager getAssets() {
        return this.mBase.getAssets();
    }

    @Override // android.content.Context
    @Nullable
    public String getAttributionTag() {
        String attributionTag;
        attributionTag = this.mBase.getAttributionTag();
        return attributionTag;
    }

    public Context getBaseContext() {
        return this.mBase;
    }

    @Override // android.content.Context
    public File getCacheDir() {
        return this.mBase.getCacheDir();
    }

    @Override // android.content.Context
    public ClassLoader getClassLoader() {
        return this.mBase.getClassLoader();
    }

    @Override // android.content.Context
    public File getCodeCacheDir() {
        return this.mBase.getCodeCacheDir();
    }

    @Override // android.content.Context
    public ContentResolver getContentResolver() {
        return this.mBase.getContentResolver();
    }

    @Override // android.content.Context
    public File getDataDir() {
        File dataDir;
        dataDir = this.mBase.getDataDir();
        return dataDir;
    }

    @Override // android.content.Context
    public File getDatabasePath(String str) {
        return this.mBase.getDatabasePath(str);
    }

    @Override // android.content.Context
    public File getDir(String str, int i3) {
        return this.mBase.getDir(str, i3);
    }

    @Override // android.content.Context
    @Nullable
    public Display getDisplay() {
        Display display;
        display = this.mBase.getDisplay();
        return display;
    }

    @Override // android.content.Context
    public File getExternalCacheDir() {
        return this.mBase.getExternalCacheDir();
    }

    @Override // android.content.Context
    public File[] getExternalCacheDirs() {
        return this.mBase.getExternalCacheDirs();
    }

    @Override // android.content.Context
    public File getExternalFilesDir(String str) {
        return this.mBase.getExternalFilesDir(str);
    }

    @Override // android.content.Context
    public File[] getExternalFilesDirs(String str) {
        return this.mBase.getExternalFilesDirs(str);
    }

    @Override // android.content.Context
    public File[] getExternalMediaDirs() {
        return this.mBase.getExternalMediaDirs();
    }

    @Override // android.content.Context
    public File getFileStreamPath(String str) {
        return this.mBase.getFileStreamPath(str);
    }

    @Override // android.content.Context
    public File getFilesDir() {
        return this.mBase.getFilesDir();
    }

    @Override // android.content.Context
    public Executor getMainExecutor() {
        Executor mainExecutor;
        mainExecutor = this.mBase.getMainExecutor();
        return mainExecutor;
    }

    @Override // android.content.Context
    public Looper getMainLooper() {
        return this.mBase.getMainLooper();
    }

    @Override // android.content.Context
    public File getNoBackupFilesDir() {
        return this.mBase.getNoBackupFilesDir();
    }

    @Override // android.content.Context
    public File getObbDir() {
        return this.mBase.getObbDir();
    }

    @Override // android.content.Context
    public File[] getObbDirs() {
        return this.mBase.getObbDirs();
    }

    @Override // android.content.Context
    public String getOpPackageName() {
        String opPackageName;
        opPackageName = this.mBase.getOpPackageName();
        return opPackageName;
    }

    @Override // android.content.Context
    public String getPackageCodePath() {
        return this.mBase.getPackageCodePath();
    }

    @Override // android.content.Context
    public PackageManager getPackageManager() {
        return this.mBase.getPackageManager();
    }

    @Override // android.content.Context
    public String getPackageName() {
        return this.mBase.getPackageName();
    }

    @Override // android.content.Context
    public String getPackageResourcePath() {
        return this.mBase.getPackageResourcePath();
    }

    @Override // android.content.Context
    public Resources getResources() {
        return this.mBase.getResources();
    }

    @Override // android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        return this.mBase.getSharedPreferences(str, i3);
    }

    @Override // android.content.Context
    public Object getSystemService(String str) {
        return this.mBase.getSystemService(str);
    }

    @Override // android.content.Context
    public String getSystemServiceName(Class<?> cls) {
        return this.mBase.getSystemServiceName(cls);
    }

    @Override // android.content.Context
    public Resources.Theme getTheme() {
        return this.mBase.getTheme();
    }

    @Override // android.content.Context
    @Deprecated
    public Drawable getWallpaper() {
        return this.mBase.getWallpaper();
    }

    @Override // android.content.Context
    @Deprecated
    public int getWallpaperDesiredMinimumHeight() {
        return this.mBase.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.Context
    @Deprecated
    public int getWallpaperDesiredMinimumWidth() {
        return this.mBase.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.content.Context
    public void grantUriPermission(String str, Uri uri, int i3) {
        this.mBase.grantUriPermission(str, uri, i3);
    }

    @Override // android.content.Context
    public boolean isDeviceProtectedStorage() {
        boolean isDeviceProtectedStorage;
        isDeviceProtectedStorage = this.mBase.isDeviceProtectedStorage();
        return isDeviceProtectedStorage;
    }

    @Override // android.content.Context
    public boolean isRestricted() {
        return this.mBase.isRestricted();
    }

    @Override // android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        boolean moveDatabaseFrom;
        moveDatabaseFrom = this.mBase.moveDatabaseFrom(context, str);
        return moveDatabaseFrom;
    }

    @Override // android.content.Context
    public boolean moveSharedPreferencesFrom(Context context, String str) {
        boolean moveSharedPreferencesFrom;
        moveSharedPreferencesFrom = this.mBase.moveSharedPreferencesFrom(context, str);
        return moveSharedPreferencesFrom;
    }

    @Override // android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return this.mBase.openFileInput(str);
    }

    @Override // android.content.Context
    public FileOutputStream openFileOutput(String str, int i3) throws FileNotFoundException {
        return this.mBase.openFileOutput(str, i3);
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        return this.mBase.openOrCreateDatabase(str, i3, cursorFactory);
    }

    @Override // android.content.Context
    @Deprecated
    public Drawable peekWallpaper() {
        return this.mBase.peekWallpaper();
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.Context
    @Deprecated
    public void removeStickyBroadcast(Intent intent) {
        this.mBase.removeStickyBroadcast(intent);
    }

    @Override // android.content.Context
    @Deprecated
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.removeStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    public void revokeUriPermission(Uri uri, int i3) {
        this.mBase.revokeUriPermission(uri, i3);
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent) {
        this.mBase.sendBroadcast(intent);
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        this.mBase.sendOrderedBroadcast(intent, str);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcastAsUser(intent, userHandle, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // android.content.Context
    @Deprecated
    public void sendStickyBroadcast(Intent intent) {
        this.mBase.sendStickyBroadcast(intent);
    }

    @Deprecated
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle, Bundle bundle) {
    }

    @Override // android.content.Context
    @Deprecated
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        this.mBase.sendStickyOrderedBroadcastAsUser(intent, userHandle, broadcastReceiver, handler, i3, str, bundle);
    }

    @Override // android.content.Context
    public void setTheme(int i3) {
        this.mBase.setTheme(i3);
    }

    @Override // android.content.Context
    @Deprecated
    public void setWallpaper(Bitmap bitmap) throws IOException {
        this.mBase.setWallpaper(bitmap);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr) {
        this.mBase.startActivities(intentArr);
    }

    @Override // android.content.Context
    public void startActivity(Intent intent) {
        this.mBase.startActivity(intent);
    }

    @Override // android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        ComponentName startForegroundService;
        startForegroundService = this.mBase.startForegroundService(intent);
        return startForegroundService;
    }

    @Override // android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return this.mBase.startInstrumentation(componentName, str, bundle);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i3, i16, i17);
    }

    @Override // android.content.Context
    public ComponentName startService(Intent intent) {
        return this.mBase.startService(intent);
    }

    @Override // android.content.Context
    public boolean stopService(Intent intent) {
        return this.mBase.stopService(intent);
    }

    @Override // android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        this.mBase.unbindService(serviceConnection);
    }

    @Override // android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        this.mBase.unregisterReceiver(broadcastReceiver);
    }

    @Override // android.content.Context
    public void updateServiceGroup(ServiceConnection serviceConnection, int i3, int i16) {
        this.mBase.updateServiceGroup(serviceConnection, i3, i16);
    }

    @Override // android.content.Context
    public boolean bindService(Intent intent, int i3, Executor executor, ServiceConnection serviceConnection) {
        boolean bindService;
        bindService = this.mBase.bindService(intent, i3, executor, serviceConnection);
        return bindService;
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17) {
        return this.mBase.checkUriPermission(uri, str, str2, i3, i16, i17);
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3) {
        this.mBase.enforceUriPermission(uri, str, str2, i3, i16, i17, str3);
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return this.mBase.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i3) {
        Intent registerReceiver;
        registerReceiver = this.mBase.registerReceiver(broadcastReceiver, intentFilter, i3);
        return registerReceiver;
    }

    @Override // android.content.Context
    public void revokeUriPermission(String str, Uri uri, int i3) {
        this.mBase.revokeUriPermission(str, uri, i3);
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        this.mBase.sendBroadcast(intent, str);
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
        this.mBase.sendBroadcastAsUser(intent, userHandle, str);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        this.mBase.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
    }

    @Override // android.content.Context
    @Deprecated
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
        this.mBase.sendStickyBroadcastAsUser(intent, userHandle);
    }

    @Override // android.content.Context
    @Deprecated
    public void setWallpaper(InputStream inputStream) throws IOException {
        this.mBase.setWallpaper(inputStream);
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
        this.mBase.startActivities(intentArr, bundle);
    }

    @Override // android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
        this.mBase.startActivity(intent, bundle);
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17, Bundle bundle) throws IntentSender.SendIntentException {
        this.mBase.startIntentSender(intentSender, intent, i3, i16, i17, bundle);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return this.mBase.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, @Nullable String str, @Nullable String str2, @Nullable BroadcastReceiver broadcastReceiver, @Nullable Handler handler, int i3, @Nullable String str3, @Nullable Bundle bundle) {
        this.mBase.sendOrderedBroadcast(intent, str, str2, broadcastReceiver, handler, i3, str3, bundle);
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i3) {
        Intent registerReceiver;
        registerReceiver = this.mBase.registerReceiver(broadcastReceiver, intentFilter, str, handler, i3);
        return registerReceiver;
    }

    @Override // android.content.Context
    @Deprecated
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
    }
}
