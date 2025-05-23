package com.tencent.mobileqq.qfix;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.ComponentCallbacks;
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
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: P */
/* loaded from: classes16.dex */
public class ApplicationDelegate extends Application {
    protected QFixApplication mApplicationReal;

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.bindService(intent, serviceConnection, i3);
        }
        return qFixApplication.bindService(intent, serviceConnection, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkCallingOrSelfPermission(str);
        }
        return qFixApplication.checkCallingOrSelfPermission(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkCallingOrSelfUriPermission(uri, i3);
        }
        return qFixApplication.checkCallingOrSelfUriPermission(uri, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingPermission(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkCallingPermission(str);
        }
        return qFixApplication.checkCallingPermission(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkCallingUriPermission(Uri uri, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkCallingUriPermission(uri, i3);
        }
        return qFixApplication.checkCallingUriPermission(uri, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkPermission(String str, int i3, int i16) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkPermission(str, i3, i16);
        }
        return qFixApplication.checkPermission(str, i3, i16);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, int i3, int i16, int i17) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkUriPermission(uri, i3, i16, i17);
        }
        return qFixApplication.checkUriPermission(uri, i3, i16, i17);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void clearWallpaper() throws IOException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.clearWallpaper();
        } else {
            qFixApplication.clearWallpaper();
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createPackageContext(String str, int i3) throws PackageManager.NameNotFoundException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.createPackageContext(str, i3);
        }
        return qFixApplication.createPackageContext(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] databaseList() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.databaseList();
        }
        return qFixApplication.databaseList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteDatabase(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.deleteDatabase(str);
        }
        return qFixApplication.deleteDatabase(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean deleteFile(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.deleteFile(str);
        }
        return qFixApplication.deleteFile(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceCallingOrSelfPermission(str, str2);
        } else {
            qFixApplication.enforceCallingOrSelfPermission(str, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i3, String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceCallingOrSelfUriPermission(uri, i3, str);
        } else {
            qFixApplication.enforceCallingOrSelfUriPermission(uri, i3, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingPermission(String str, String str2) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceCallingPermission(str, str2);
        } else {
            qFixApplication.enforceCallingPermission(str, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i3, String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceCallingUriPermission(uri, i3, str);
        } else {
            qFixApplication.enforceCallingUriPermission(uri, i3, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforcePermission(String str, int i3, int i16, String str2) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforcePermission(str, i3, i16, str2);
        } else {
            qFixApplication.enforcePermission(str, i3, i16, str2);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, int i3, int i16, int i17, String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceUriPermission(uri, i3, i16, i17, str);
        } else {
            qFixApplication.enforceUriPermission(uri, i3, i16, i17, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String[] fileList() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.fileList();
        }
        return qFixApplication.fileList();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getApplicationContext();
        }
        return qFixApplication.getApplicationContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getApplicationInfo();
        }
        return qFixApplication.getApplicationInfo();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getAssets();
        }
        return qFixApplication.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getBaseContext();
        }
        return qFixApplication.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getCacheDir() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getCacheDir();
        }
        return qFixApplication.getCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getClassLoader();
        }
        return qFixApplication.getClassLoader();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ContentResolver getContentResolver() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getContentResolver();
        }
        return qFixApplication.getContentResolver();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDatabasePath(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getDatabasePath(str);
        }
        return qFixApplication.getDatabasePath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getDir(String str, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getDir(str, i3);
        }
        return qFixApplication.getDir(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalCacheDir() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getExternalCacheDir();
        }
        return qFixApplication.getExternalCacheDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getExternalFilesDir(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getExternalFilesDir(str);
        }
        return qFixApplication.getExternalFilesDir(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFileStreamPath(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getFileStreamPath(str);
        }
        return qFixApplication.getFileStreamPath(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getFilesDir() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getFilesDir();
        }
        return qFixApplication.getFilesDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Looper getMainLooper() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getMainLooper();
        }
        return qFixApplication.getMainLooper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public File getObbDir() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getObbDir();
        }
        return qFixApplication.getObbDir();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageCodePath() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getPackageCodePath();
        }
        return qFixApplication.getPackageCodePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public PackageManager getPackageManager() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getPackageManager();
        }
        return qFixApplication.getPackageManager();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getPackageName();
        }
        return qFixApplication.getPackageName();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageResourcePath() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getPackageResourcePath();
        }
        return qFixApplication.getPackageResourcePath();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getResources();
        }
        return qFixApplication.getResources();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getSharedPreferences(str, i3);
        }
        return qFixApplication.getSharedPreferences(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getSystemService(str);
        }
        return qFixApplication.getSystemService(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getTheme();
        }
        return qFixApplication.getTheme();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable getWallpaper() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getWallpaper();
        }
        return qFixApplication.getWallpaper();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getWallpaperDesiredMinimumHeight();
        }
        return qFixApplication.getWallpaperDesiredMinimumHeight();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.getWallpaperDesiredMinimumWidth();
        }
        return qFixApplication.getWallpaperDesiredMinimumWidth();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void grantUriPermission(String str, Uri uri, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.grantUriPermission(str, uri, i3);
        } else {
            qFixApplication.grantUriPermission(str, uri, i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean isRestricted() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.isRestricted();
        }
        return qFixApplication.isRestricted();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.openFileInput(str);
        }
        return qFixApplication.openFileInput(str);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public FileOutputStream openFileOutput(String str, int i3) throws FileNotFoundException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.openFileOutput(str, i3);
        }
        return qFixApplication.openFileOutput(str, i3);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.openOrCreateDatabase(str, i3, cursorFactory);
        }
        return qFixApplication.openOrCreateDatabase(str, i3, cursorFactory);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Drawable peekWallpaper() {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.peekWallpaper();
        }
        return qFixApplication.peekWallpaper();
    }

    public void proxyAttachBaseContext(Context context, QFixApplication qFixApplication) {
        this.mApplicationReal = qFixApplication;
        attachBaseContext(context);
    }

    @Override // android.app.Application
    public void registerActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            qFixApplication.registerActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.registerComponentCallbacks(componentCallbacks);
        } else {
            qFixApplication.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.registerReceiver(broadcastReceiver, intentFilter);
        }
        return qFixApplication.registerReceiver(broadcastReceiver, intentFilter);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void removeStickyBroadcast(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.removeStickyBroadcast(intent);
        } else {
            qFixApplication.removeStickyBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void revokeUriPermission(Uri uri, int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.revokeUriPermission(uri, i3);
        } else {
            qFixApplication.revokeUriPermission(uri, i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendBroadcast(intent);
        } else {
            qFixApplication.sendBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendBroadcast(intent, str);
        } else {
            qFixApplication.sendOrderedBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyBroadcast(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendStickyBroadcast(intent);
        } else {
            qFixApplication.sendStickyBroadcast(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str, Bundle bundle) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i3, str, bundle);
        } else {
            qFixApplication.sendStickyOrderedBroadcast(intent, broadcastReceiver, handler, i3, str, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.setTheme(i3);
        } else {
            qFixApplication.setTheme(i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.setWallpaper(bitmap);
        } else {
            qFixApplication.setWallpaper(bitmap);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivities(Intent[] intentArr) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.startActivities(intentArr);
        } else {
            qFixApplication.startActivities(intentArr);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.startActivity(intent);
        } else {
            qFixApplication.startActivity(intent);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.startInstrumentation(componentName, str, bundle);
        }
        return qFixApplication.startInstrumentation(componentName, str, bundle);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i3, int i16, int i17) throws IntentSender.SendIntentException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.startIntentSender(intentSender, intent, i3, i16, i17);
        } else {
            qFixApplication.startIntentSender(intentSender, intent, i3, i16, i17);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.startService(intent);
        }
        return qFixApplication.startService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public boolean stopService(Intent intent) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.stopService(intent);
        }
        return qFixApplication.stopService(intent);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.unbindService(serviceConnection);
        } else {
            qFixApplication.unbindService(serviceConnection);
        }
    }

    @Override // android.app.Application
    public void unregisterActivityLifecycleCallbacks(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        } else {
            qFixApplication.unregisterActivityLifecycleCallbacks(activityLifecycleCallbacks);
        }
    }

    @Override // android.app.Application, android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.unregisterComponentCallbacks(componentCallbacks);
        } else {
            qFixApplication.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.unregisterReceiver(broadcastReceiver);
        } else {
            qFixApplication.unregisterReceiver(broadcastReceiver);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.checkUriPermission(uri, str, str2, i3, i16, i17);
        }
        return qFixApplication.checkUriPermission(uri, str, str2, i3, i16, i17);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i3, int i16, int i17, String str3) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.enforceUriPermission(uri, str, str2, i3, i16, i17, str3);
        } else {
            qFixApplication.enforceUriPermission(uri, str, str2, i3, i16, i17, str3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i3, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
        }
        return qFixApplication.openOrCreateDatabase(str, i3, cursorFactory, databaseErrorHandler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            return super.registerReceiver(broadcastReceiver, intentFilter, str, handler);
        }
        return qFixApplication.registerReceiver(broadcastReceiver, intentFilter, str, handler);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendBroadcast(Intent intent, String str) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendBroadcast(intent, str);
        } else {
            qFixApplication.sendBroadcast(intent, str);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i3, String str2, Bundle bundle) {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        } else {
            qFixApplication.sendOrderedBroadcast(intent, str, broadcastReceiver, handler, i3, str2, bundle);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
        QFixApplication qFixApplication = this.mApplicationReal;
        if (qFixApplication == null) {
            super.setWallpaper(inputStream);
        } else {
            qFixApplication.setWallpaper(inputStream);
        }
    }
}
