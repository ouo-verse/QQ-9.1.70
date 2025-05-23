package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import com.tencent.midas.comm.APLog;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.theme.SkinEngine;
import java.lang.reflect.Method;
import java.util.ArrayList;

/* loaded from: classes9.dex */
class APPluginContext extends ContextThemeWrapper {
    private AssetManager mAsset;
    private ClassLoader mClassLoader;
    private Resources mResources;
    private Resources.Theme mTheme;
    private int mThemeResId;

    public APPluginContext(Context context, int i3, String str, ClassLoader classLoader) {
        this(context, i3, str, classLoader, null);
    }

    private static String getApplicationPackageName(Context context) {
        if (context == null) {
            return "";
        }
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return "";
            }
            return InstalledAppListMonitor.getPackageInfo(packageManager, context.getPackageName(), 0).packageName;
        } catch (Exception e16) {
            APLog.i("APMidasCommMethod", "getApplicationPackageName error:" + e16.toString());
            return "";
        }
    }

    private int getInnerRIdValue(String str) {
        int i3 = -1;
        try {
            String substring = str.substring(0, str.indexOf(".R.") + 2);
            int lastIndexOf = str.lastIndexOf(".");
            String substring2 = str.substring(lastIndexOf + 1, str.length());
            String substring3 = str.substring(0, lastIndexOf);
            String str2 = substring + "$" + substring3.substring(substring3.lastIndexOf(".") + 1, substring3.length());
            i3 = Class.forName(str2).getDeclaredField(substring2).getInt(null);
            APLog.i("APPluginContext", "getInnderR rStrnig:" + substring3 + ", className:" + str2 + ", fieldName:" + substring2);
            return i3;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return i3;
        }
    }

    private AssetManager getSelfAssets(Context context, String str) {
        boolean z16;
        boolean z17;
        AssetManager assetManager = null;
        try {
            AssetManager assetManager2 = (AssetManager) AssetManager.class.newInstance();
            try {
                try {
                    String str2 = SkinEngine.ACTION_THEME_INVALIDATE;
                    SkinEngine.class.getMethod("getInstances", new Class[0]);
                    z16 = true;
                } catch (Exception e16) {
                    APLog.w("APPluginContext", " is not has com.tencent.theme.SkinEngine e:" + e16.toString());
                    z16 = false;
                }
                if (!z16) {
                    try {
                        Class.forName("com.tencent.component.theme.SkinEngine").getMethod("getInstances", new Class[0]);
                        z16 = true;
                    } catch (Exception e17) {
                        APLog.w("APPluginContext", " is not has com.tencent.component.theme.SkinEngine e:" + e17.toString());
                        z16 = false;
                    }
                }
                try {
                    z17 = "com.tencent.weread".equals(getApplicationPackageName(context));
                } catch (Exception unused) {
                    z17 = false;
                }
                if (z16 || z17) {
                    ArrayList<String> midasEmptyPaht = APPluginUtils.getMidasEmptyPaht(context);
                    APLog.i("APPluginContext", "loadEmptyResAPK emptyList.size:" + midasEmptyPaht.size());
                    for (int i3 = 0; i3 < midasEmptyPaht.size(); i3++) {
                        String str3 = midasEmptyPaht.get(i3);
                        APLog.i("APPluginContext", "loadEmptyResAPK emptyResFirstPath:" + str3);
                        if (!TextUtils.isEmpty(str3)) {
                            APLog.i("APPluginContext", "loadEmptyResAPK id:" + ((Integer) AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str3)).intValue());
                        }
                    }
                }
                AssetManager.class.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager2, str);
                try {
                    for (String str4 : context.getApplicationInfo().sharedLibraryFiles) {
                        if (str4.endsWith(".apk")) {
                            AssetManager.class.getDeclaredMethod("addAssetPathAsSharedLibrary", String.class).invoke(assetManager2, str4);
                        }
                    }
                    return assetManager2;
                } catch (Exception e18) {
                    e18.printStackTrace();
                    return assetManager2;
                }
            } catch (Throwable th5) {
                th = th5;
                assetManager = assetManager2;
                th.printStackTrace();
                return assetManager;
            }
        } catch (Throwable th6) {
            th = th6;
        }
    }

    private Resources getSelfRes(Context context, AssetManager assetManager) {
        return new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());
    }

    private Resources.Theme getSelfTheme(Context context, Resources resources) {
        Resources.Theme newTheme = resources.newTheme();
        int themeId = getThemeId(context);
        this.mThemeResId = themeId;
        newTheme.applyStyle(themeId, true);
        return newTheme;
    }

    private static int getThemeId(Context context) {
        try {
            Method method = ContextThemeWrapper.class.getMethod("getThemeResId", new Class[0]);
            method.setAccessible(true);
            return ((Integer) method.invoke(context, new Object[0])).intValue();
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mAsset;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        ClassLoader classLoader = this.mClassLoader;
        if (classLoader != null) {
            return classLoader;
        }
        return super.getClassLoader();
    }

    public Resources getRes() {
        return this.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        return this.mTheme;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    public APPluginContext(Context context, int i3, String str, ClassLoader classLoader, Resources resources) {
        super(context, i3);
        this.mAsset = null;
        this.mResources = null;
        this.mTheme = null;
        this.mClassLoader = classLoader;
        APLog.i("APPluginContext", "APPluginContext mClassLoader:" + this.mClassLoader + " apkPath:" + str);
        if (resources != null) {
            this.mAsset = resources.getAssets();
            APLog.i("APPluginContext", "APPluginActivity APPluginContext 1 mAsset:" + this.mAsset);
            this.mResources = resources;
        } else {
            AssetManager selfAssets = getSelfAssets(context, str);
            this.mAsset = selfAssets;
            this.mResources = getSelfRes(context, selfAssets);
            APLog.i("APPluginContext", "APPluginActivity APPluginContext 2 mAsset:" + this.mAsset + ", mResources:" + this.mResources);
        }
        this.mTheme = getSelfTheme(context, this.mResources);
    }
}
