package com.tencent.smtt.export.external;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseTimer;
import cooperation.qzone.patch.QZonePatchService;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TimerTask;

/* loaded from: classes22.dex */
public class DexClassLoaderProvider extends DexClassLoader {
    private static final String IS_FIRST_LOAD_DEX_FLAG_FILE = "is_first_load_dex_flag_file";
    private static final String LAST_DEX_NAME = "tbs_jars_fusion_dex.jar";
    private static final long LOAD_DEX_DELAY = 3000;
    private static final String LOGTAG = "dexloader";
    protected static DexClassLoader mClassLoaderOriginal = null;
    private static Context mContext = null;
    private static boolean mForceLoadDexFlag = false;
    private static DexClassLoaderProvider mInstance;
    private static String mRealDexPath;
    protected static Service mService;
    private SpeedyDexClassLoader mClassLoader;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class SpeedyDexClassLoader extends BaseDexClassLoader {
        public SpeedyDexClassLoader(String str, File file, String str2, ClassLoader classLoader) {
            super(str, null, str2, classLoader);
        }

        @Override // java.lang.ClassLoader
        public Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Class<?> findClass(String str) throws ClassNotFoundException {
            return super.findClass(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public URL findResource(String str) {
            return super.findResource(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public Enumeration<URL> findResources(String str) {
            return super.findResources(str);
        }

        @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
        public synchronized Package getPackage(String str) {
            return super.getPackage(str);
        }

        @Override // java.lang.ClassLoader
        public Package[] getPackages() {
            return super.getPackages();
        }

        @Override // java.lang.ClassLoader
        public Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
            return super.loadClass(str, z16);
        }
    }

    DexClassLoaderProvider(String str, String str2, String str3, ClassLoader classLoader, boolean z16) {
        super(str, str2, str3, classLoader);
        this.mClassLoader = null;
        if (z16) {
            Log.e(LOGTAG, "SpeedyDexClassLoader: " + mRealDexPath);
            this.mClassLoader = new SpeedyDexClassLoader(mRealDexPath, null, str3, classLoader);
            return;
        }
        Log.e(LOGTAG, "DexClassLoader: " + mRealDexPath);
        this.mClassLoader = null;
    }

    public static DexClassLoader createDexClassLoader(String str, String str2, String str3, ClassLoader classLoader, Context context) {
        Log.i(LOGTAG, "new DexClassLoaderDelegate: " + str + ", context: " + context);
        mContext = context.getApplicationContext();
        mRealDexPath = str;
        int lastIndexOf = str.lastIndexOf("/") + 1;
        String str4 = str.substring(0, lastIndexOf) + "fake_dex.jar";
        String substring = str.substring(lastIndexOf);
        if (supportSpeedyClassLoader() && is_first_load_tbs_dex(str2, substring)) {
            Log.d(LOGTAG, "new DexClassLoaderDelegate -- fake: " + str4);
            set_first_load_tbs_dex(str2, substring);
            mInstance = new DexClassLoaderProvider(str4, str2, str3, classLoader, true);
            doAsyncDexLoad(substring, str, str2, str3, classLoader);
        } else {
            Log.d(LOGTAG, "new DexClassLoaderDelegate -- real: " + str);
            mInstance = new DexClassLoaderProvider(str, str2, str3, classLoader, false);
        }
        return mInstance;
    }

    private static void doAsyncDexLoad(final String str, final String str2, final String str3, final String str4, final ClassLoader classLoader) {
        if (shouldUseDexLoaderService()) {
            new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.1
                @Override // java.util.TimerTask, java.lang.Runnable
                public void run() {
                    try {
                        ArrayList<String> arrayList = new ArrayList<>(4);
                        arrayList.add(0, str);
                        arrayList.add(1, str2);
                        arrayList.add(2, str3);
                        arrayList.add(3, str4);
                        Intent intent = new Intent(DexClassLoaderProvider.mContext, (Class<?>) DexClassLoaderProviderService.class);
                        intent.putStringArrayListExtra("dex2oat", arrayList);
                        DexClassLoaderProvider.mContext.startService(intent);
                        Log.d(DexClassLoaderProvider.LOGTAG, "shouldUseDexLoaderService(" + str + ", " + intent + ")");
                    } catch (SecurityException e16) {
                        Log.e(DexClassLoaderProvider.LOGTAG, "start DexLoaderService exception", e16);
                    } catch (Throwable th5) {
                        Log.e(DexClassLoaderProvider.LOGTAG, "after shouldUseDexLoaderService exception: " + th5);
                    }
                }
            }, 3000L);
            return;
        }
        Log.d(LOGTAG, "Background real dex loading(" + str + ")");
        new BaseTimer().schedule(new TimerTask() { // from class: com.tencent.smtt.export.external.DexClassLoaderProvider.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                boolean z16;
                try {
                    File file = new File(str2.replace(QZonePatchService.PATCH_SUFFIX, QZonePatchService.PATCH_SUFFIX_DEX));
                    if (file.exists() && file.length() != 0) {
                        Log.d(DexClassLoaderProvider.LOGTAG, "" + file + " existed!");
                        z16 = true;
                    } else {
                        Log.d(DexClassLoaderProvider.LOGTAG, "" + file + " does not existed!");
                        z16 = false;
                    }
                    File file2 = new File(str3);
                    File file3 = new File(str2);
                    boolean exists = file2.exists();
                    boolean isDirectory = file2.isDirectory();
                    boolean exists2 = file3.exists();
                    if (exists && isDirectory && exists2) {
                        long currentTimeMillis = System.currentTimeMillis();
                        new DexClassLoader(str2, str3, str4, classLoader);
                        Log.d(DexClassLoaderProvider.LOGTAG, "" + String.format("load_dex completed -- cl_cost: %d, existed: %b", Long.valueOf(System.currentTimeMillis() - currentTimeMillis), Boolean.valueOf(z16)));
                        if (DexClassLoaderProvider.mForceLoadDexFlag && DexClassLoaderProvider.LAST_DEX_NAME.equals(str)) {
                            Log.d(DexClassLoaderProvider.LOGTAG, "Stop provider service after loading " + str);
                            if (DexClassLoaderProvider.mService != null) {
                                Log.d(DexClassLoaderProvider.LOGTAG, "##Stop service##... ");
                                DexClassLoaderProvider.mService.stopSelf();
                                return;
                            }
                            return;
                        }
                        return;
                    }
                    Log.d(DexClassLoaderProvider.LOGTAG, "dex loading exception(" + exists + ", " + isDirectory + ", " + exists2 + ")");
                } catch (Throwable th5) {
                    Log.e(DexClassLoaderProvider.LOGTAG, "@AsyncDexLoad task exception: " + th5);
                }
            }
        }, 3000L);
    }

    private static boolean is_first_load_tbs_dex(String str, String str2) {
        if (mForceLoadDexFlag) {
            return true;
        }
        if (!new File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE).exists()) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setForceLoadDexFlag(boolean z16, Service service) {
        mForceLoadDexFlag = z16;
        mService = service;
    }

    private static void set_first_load_tbs_dex(String str, String str2) {
        File file = new File(str, str2 + "_" + IS_FIRST_LOAD_DEX_FLAG_FILE);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (Throwable th5) {
                th5.printStackTrace();
            }
        }
    }

    private static boolean shouldUseDexLoaderService() {
        if (mForceLoadDexFlag || !DexLoader.mCanUseDexLoaderProviderService) {
            return false;
        }
        return true;
    }

    private static boolean supportSpeedyClassLoader() {
        return true;
    }

    private boolean useSelfClassloader() {
        if (this.mClassLoader == null) {
            return true;
        }
        return false;
    }

    @Override // java.lang.ClassLoader
    public void clearAssertionStatus() {
        if (useSelfClassloader()) {
            super.clearAssertionStatus();
        } else {
            this.mClassLoader.clearAssertionStatus();
        }
    }

    @Override // java.lang.ClassLoader
    protected Package definePackage(String str, String str2, String str3, String str4, String str5, String str6, String str7, URL url) throws IllegalArgumentException {
        if (useSelfClassloader()) {
            return super.definePackage(str, str2, str3, str4, str5, str6, str7, url);
        }
        return this.mClassLoader.definePackage(str, str2, str3, str4, str5, str6, str7, url);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Class<?> findClass(String str) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.findClass(str);
        }
        return this.mClassLoader.findClass(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    public String findLibrary(String str) {
        if (useSelfClassloader()) {
            return super.findLibrary(str);
        }
        return this.mClassLoader.findLibrary(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected URL findResource(String str) {
        if (useSelfClassloader()) {
            return super.findResource(str);
        }
        return this.mClassLoader.findResource(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected Enumeration<URL> findResources(String str) {
        if (useSelfClassloader()) {
            return super.findResources(str);
        }
        return this.mClassLoader.findResources(str);
    }

    @Override // dalvik.system.BaseDexClassLoader, java.lang.ClassLoader
    protected synchronized Package getPackage(String str) {
        if (useSelfClassloader()) {
            return super.getPackage(str);
        }
        return this.mClassLoader.getPackage(str);
    }

    @Override // java.lang.ClassLoader
    protected Package[] getPackages() {
        if (useSelfClassloader()) {
            return super.getPackages();
        }
        return this.mClassLoader.getPackages();
    }

    @Override // java.lang.ClassLoader
    public URL getResource(String str) {
        if (useSelfClassloader()) {
            return super.getResource(str);
        }
        return this.mClassLoader.getResource(str);
    }

    @Override // java.lang.ClassLoader
    public InputStream getResourceAsStream(String str) {
        if (useSelfClassloader()) {
            return getResourceAsStream(str);
        }
        return this.mClassLoader.getResourceAsStream(str);
    }

    @Override // java.lang.ClassLoader
    public Enumeration<URL> getResources(String str) throws IOException {
        if (useSelfClassloader()) {
            return super.getResources(str);
        }
        return this.mClassLoader.getResources(str);
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String str, boolean z16) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.loadClass(str, z16);
        }
        return this.mClassLoader.loadClass(str, z16);
    }

    @Override // java.lang.ClassLoader
    public void setClassAssertionStatus(String str, boolean z16) {
        if (useSelfClassloader()) {
            super.setClassAssertionStatus(str, z16);
        } else {
            this.mClassLoader.setClassAssertionStatus(str, z16);
        }
    }

    @Override // java.lang.ClassLoader
    public void setDefaultAssertionStatus(boolean z16) {
        if (useSelfClassloader()) {
            super.setDefaultAssertionStatus(z16);
        } else {
            this.mClassLoader.setDefaultAssertionStatus(z16);
        }
    }

    @Override // java.lang.ClassLoader
    public void setPackageAssertionStatus(String str, boolean z16) {
        if (useSelfClassloader()) {
            super.setPackageAssertionStatus(str, z16);
        } else {
            this.mClassLoader.setPackageAssertionStatus(str, z16);
        }
    }

    @Override // dalvik.system.BaseDexClassLoader
    public String toString() {
        if (useSelfClassloader()) {
            return super.toString();
        }
        return this.mClassLoader.toString();
    }

    @Override // java.lang.ClassLoader
    public Class<?> loadClass(String str) throws ClassNotFoundException {
        if (useSelfClassloader()) {
            return super.loadClass(str);
        }
        return this.mClassLoader.loadClass(str);
    }
}
