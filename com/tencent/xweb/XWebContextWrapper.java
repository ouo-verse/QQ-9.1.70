package com.tencent.xweb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.luggage.wxa.tq.c;
import com.tencent.xweb.internal.ConstValue;
import com.tencent.xweb.util.WebViewExtensionListener;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes27.dex */
public abstract class XWebContextWrapper extends ContextWrapper implements c {
    private static final String TAG = "XWebContextWrapper";
    private static String sLastPackageInfoPath;
    private static PackageInfo sPackageInfo;
    private static Resources sResources;
    private static HashMap<Long, Integer> sResourcesKeyIdMap;
    protected ApplicationInfo mApplicationInfo;
    private ClassLoader mClassLoader;
    protected Context mContext;
    protected boolean mHasAddFilterResources;
    protected LayoutInflater mLayoutInflater;
    protected Resources mResources;
    protected Resources.Theme mTheme;

    public XWebContextWrapper(Context context) {
        super(context);
        this.mHasAddFilterResources = false;
    }

    public final ApplicationInfo a(Context context, String str) {
        x0.d(TAG, "getApplicationInfoFromApkPath, path:" + str);
        PackageInfo packageInfo = getPackageInfo(context, str);
        if (packageInfo != null) {
            ApplicationInfo applicationInfo = packageInfo.applicationInfo;
            this.mApplicationInfo = applicationInfo;
            if (applicationInfo != null) {
                applicationInfo.sourceDir = str;
                applicationInfo.publicSourceDir = str;
            }
        }
        return this.mApplicationInfo;
    }

    public boolean addFilterResources(Resources resources, Map<Long, Integer> map) {
        WebViewExtensionListener webViewExtensionListener = XWalkEnvironment.getWebViewExtensionListener();
        if (webViewExtensionListener != null) {
            Object onMiscCallBack = webViewExtensionListener.onMiscCallBack(ConstValue.EXTENSION_ADD_FILTER_RESOURCES, resources, map);
            if (onMiscCallBack instanceof Boolean) {
                return ((Boolean) onMiscCallBack).booleanValue();
            }
        }
        return false;
    }

    public final Resources b(Context context, String str) {
        try {
            AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
            assetManager.getClass().getMethod("addAssetPath", String.class).invoke(assetManager, str);
            Resources resources = super.getResources();
            return new Resources(assetManager, resources.getDisplayMetrics(), resources.getConfiguration());
        } catch (Throwable th5) {
            x0.a(TAG, "getResourcesWithReflect error", th5);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        return XWalkEnvironment.convertContextToApplication(this.mContext);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        Resources resources = getResources();
        if (resources != null) {
            return resources.getAssets();
        }
        return super.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        return this.mContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        if (this.mClassLoader != null) {
            x0.d(TAG, "getClassLoader, customized class loader:" + this.mClassLoader);
            return this.mClassLoader;
        }
        ClassLoader webViewCoreClassLoader = getWebViewCoreClassLoader();
        if (webViewCoreClassLoader != null) {
            x0.d(TAG, "getClassLoader, webview core class loader:" + webViewCoreClassLoader);
            return webViewCoreClassLoader;
        }
        x0.d(TAG, "getClassLoader, super class loader");
        return super.getClassLoader();
    }

    public LayoutInflater getLayoutInflater() {
        return this.mLayoutInflater;
    }

    public synchronized PackageInfo getPackageInfo(Context context, String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(sLastPackageInfoPath)) {
            return sPackageInfo;
        }
        sLastPackageInfoPath = str;
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 0);
        sPackageInfo = packageArchiveInfo;
        return packageArchiveInfo;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public String getPackageName() {
        return this.mContext.getPackageName();
    }

    public Resources getResources(Context context, String str) {
        if (sResources != null) {
            a(context, str);
            return sResources;
        }
        if (a(str)) {
            ApplicationInfo a16 = a(context, str);
            this.mApplicationInfo = a16;
            if (a16 != null) {
                a16.sourceDir = str;
                a16.publicSourceDir = str;
                try {
                    Resources resourcesForApplication = context.getPackageManager().getResourcesForApplication(this.mApplicationInfo);
                    if (resourcesForApplication != null) {
                        sResources = resourcesForApplication;
                        x0.d(TAG, "getResources, use application resources");
                        return sResources;
                    }
                } catch (Throwable th5) {
                    x0.c(TAG, "getResources, error:" + th5.getMessage());
                }
            }
            x0.d(TAG, "getResources failed, try getResourcesWithReflect");
            sResources = b(context, str);
        }
        x0.d(TAG, "getResources, resources:" + sResources);
        return sResources;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0117 A[Catch: ClassNotFoundException -> 0x0125, all -> 0x015b, TRY_LEAVE, TryCatch #7 {ClassNotFoundException -> 0x0125, blocks: (B:21:0x008b, B:24:0x0096, B:27:0x009b, B:28:0x010d, B:30:0x0117, B:37:0x00bb, B:41:0x00d6, B:39:0x00f4), top: B:20:0x008b }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public HashMap<Long, Integer> getResourcesKeyIdMap(Resources resources) {
        HashMap<Long, Integer> hashMap;
        Class<?>[] clsArr;
        int i3;
        TypedValue typedValue;
        int i16;
        if (sResourcesKeyIdMap != null) {
            return new HashMap<>(sResourcesKeyIdMap);
        }
        x0.d(TAG, "getResourcesKeyIdMap start");
        String str = sPackageInfo.packageName + ".R";
        x0.d(TAG, "getResourcesKeyIdMap, clazzR:" + str);
        HashMap<Long, Integer> hashMap2 = new HashMap<>();
        HashMap<Long, Integer> hashMap3 = null;
        try {
            try {
                Class<?>[] classes = getClassLoader().loadClass(str).getClasses();
                int length = classes.length;
                int i17 = 0;
                while (i17 < length) {
                    Class<?> cls = classes[i17];
                    if (cls.getSimpleName().equals("drawable")) {
                        Field[] fields = cls.getFields();
                        int length2 = fields.length;
                        int i18 = 0;
                        while (i18 < length2) {
                            Field field = fields[i18];
                            if (Modifier.isFinal(field.getModifiers())) {
                                field.setAccessible(true);
                            }
                            try {
                                typedValue = new TypedValue();
                                i16 = field.getInt(hashMap3);
                            } catch (Resources.NotFoundException e16) {
                                e = e16;
                                clsArr = classes;
                                i3 = i17;
                            } catch (IllegalAccessException e17) {
                                e = e17;
                                clsArr = classes;
                                i3 = i17;
                            } catch (IllegalArgumentException e18) {
                                e = e18;
                                clsArr = classes;
                                i3 = i17;
                            }
                            try {
                                resources.getValue(i16, typedValue, true);
                                i3 = i17;
                                try {
                                    clsArr = classes;
                                } catch (Resources.NotFoundException e19) {
                                    e = e19;
                                    clsArr = classes;
                                } catch (IllegalAccessException e26) {
                                    e = e26;
                                    clsArr = classes;
                                } catch (IllegalArgumentException e27) {
                                    e = e27;
                                    clsArr = classes;
                                }
                                try {
                                    hashMap2.put(Long.valueOf(typedValue.data | (typedValue.assetCookie << 32)), Integer.valueOf(i16));
                                } catch (Resources.NotFoundException e28) {
                                    e = e28;
                                    x0.a(TAG, field.getName() + " is not found, error", e);
                                    if (!Modifier.isFinal(field.getModifiers())) {
                                    }
                                    i18++;
                                    classes = clsArr;
                                    i17 = i3;
                                    hashMap3 = null;
                                } catch (IllegalAccessException e29) {
                                    e = e29;
                                    x0.a(TAG, field.getName() + " is not accessible, error", e);
                                    if (!Modifier.isFinal(field.getModifiers())) {
                                    }
                                    i18++;
                                    classes = clsArr;
                                    i17 = i3;
                                    hashMap3 = null;
                                } catch (IllegalArgumentException e36) {
                                    e = e36;
                                    x0.a(TAG, field.getName() + " is not int, error", e);
                                    if (!Modifier.isFinal(field.getModifiers())) {
                                    }
                                    i18++;
                                    classes = clsArr;
                                    i17 = i3;
                                    hashMap3 = null;
                                }
                                if (!Modifier.isFinal(field.getModifiers())) {
                                    field.setAccessible(false);
                                }
                                i18++;
                                classes = clsArr;
                                i17 = i3;
                                hashMap3 = null;
                            } catch (ClassNotFoundException e37) {
                                e = e37;
                                hashMap = null;
                                x0.a(TAG, str + " is not found, error", e);
                                return hashMap;
                            }
                        }
                    }
                    i17++;
                    classes = classes;
                    hashMap3 = null;
                }
                sResourcesKeyIdMap = hashMap2;
                x0.d(TAG, "getResourcesKeyIdMap end, size:" + sResourcesKeyIdMap.keySet().size());
                return new HashMap<>(sResourcesKeyIdMap);
            } catch (Throwable th5) {
                x0.a(TAG, "getResourcesKeyIdMap error", th5);
                return null;
            }
        } catch (ClassNotFoundException e38) {
            e = e38;
            hashMap = hashMap3;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (str.equals("layout_inflater")) {
            x0.d(TAG, "getSystemService, layoutInflater:" + getLayoutInflater());
            return getLayoutInflater();
        }
        try {
            x0.d(TAG, "getSystemService, context:" + this.mContext + ", activity? " + (this.mContext instanceof Activity));
            return this.mContext.getSystemService(str);
        } catch (Throwable th5) {
            x0.a(TAG, "getSystemService error", th5);
            return null;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources.Theme getTheme() {
        Resources.Theme theme = this.mTheme;
        if (theme != null) {
            return theme;
        }
        return super.getTheme();
    }

    public ClassLoader getWebViewCoreClassLoader() {
        return null;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.mClassLoader = classLoader;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void setTheme(int i3) {
        if (this.mContext.getTheme() != null) {
            this.mContext.getTheme().applyStyle(i3, true);
        } else {
            super.setTheme(i3);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void startActivity(Intent intent) {
        super.startActivity(a(intent));
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ComponentName startService(Intent intent) {
        return super.startService(a(intent));
    }

    @Override // com.tencent.luggage.wxa.tq.c
    public void updateResourceLocale(Locale locale) {
        try {
            Resources resources = this.mResources;
            if (resources == null) {
                x0.c(TAG, "updateResourceLocale, resources is null");
                return;
            }
            Configuration configuration = resources.getConfiguration();
            x0.d(TAG, "updateResourceLocale, resources:" + resources + ", new locale:" + locale + ", old locale:" + configuration.locale);
            configuration.setLocale(locale);
            resources.updateConfiguration(configuration, resources.getDisplayMetrics());
        } catch (Throwable th5) {
            x0.a(TAG, "updateResourceLocale, error", th5);
        }
    }

    public final boolean a(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        File file = new File(str);
        return file.exists() && file.isFile();
    }

    public final Intent a(Intent intent) {
        ComponentName component = intent.getComponent();
        if (component != null) {
            intent.setComponent(new ComponentName(getBaseContext(), component.getClassName()));
        }
        return intent;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        if (!this.mHasAddFilterResources) {
            HashMap<Long, Integer> resourcesKeyIdMap = getResourcesKeyIdMap(this.mResources);
            if (resourcesKeyIdMap != null && addFilterResources(this.mResources, resourcesKeyIdMap)) {
                this.mHasAddFilterResources = true;
            } else {
                XWalkEnvironment.getBuildConfigThirdPartyRelease();
            }
        }
        Resources resources = this.mResources;
        return resources != null ? resources : super.getResources();
    }
}
