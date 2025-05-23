package com.tencent.mobileqq.pluginsdk;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: classes16.dex */
public class ApkFileParser {
    static IPatchRedirector $redirector_;

    public ApkFileParser() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static Drawable getAPKIcon(Context context, String str) {
        PackageInfo packageArchiveInfo;
        ApplicationInfo applicationInfo;
        try {
            packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 1);
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
        if (packageArchiveInfo != null && (applicationInfo = packageArchiveInfo.applicationInfo) != null) {
            Class<?> cls = Class.forName("android.content.res.AssetManager");
            AssetManager assetManager = (AssetManager) cls.getConstructor(null).newInstance(null);
            cls.getDeclaredMethod("addAssetPath", String.class).invoke(assetManager, str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            Resources resources = new Resources(assetManager, displayMetrics, context.getResources().getConfiguration());
            int i3 = applicationInfo.icon;
            if (i3 != 0) {
                return resources.getDrawable(i3);
            }
            return null;
        }
        return null;
    }

    public static PackageInfo getPackageInfo(String str) throws Exception {
        PackageInfo packageInfo = new PackageInfo();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        applicationInfo.metaData = new Bundle();
        packageInfo.applicationInfo = applicationInfo;
        AssetManager assetManager = (AssetManager) AssetManager.class.newInstance();
        Method declaredMethod = AssetManager.class.getDeclaredMethod("addAssetPath", String.class);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(assetManager, str);
        XmlResourceParser openXmlResourceParser = assetManager.openXmlResourceParser("AndroidManifest.xml");
        if (openXmlResourceParser == null) {
            return null;
        }
        try {
            try {
                for (int eventType = openXmlResourceParser.getEventType(); eventType != 1; eventType = openXmlResourceParser.nextToken()) {
                    if (eventType == 2) {
                        String name = openXmlResourceParser.getName();
                        if (!TextUtils.isEmpty(name)) {
                            if (name.equals("manifest")) {
                                for (int i3 = 0; i3 < openXmlResourceParser.getAttributeCount(); i3++) {
                                    if (openXmlResourceParser.getAttributeName(i3).equals("package")) {
                                        String attributeValue = openXmlResourceParser.getAttributeValue(i3);
                                        packageInfo.packageName = attributeValue;
                                        packageInfo.applicationInfo.packageName = attributeValue;
                                    }
                                }
                            } else if (name.equals("application")) {
                                for (int i16 = 0; i16 < openXmlResourceParser.getAttributeCount(); i16++) {
                                    if (openXmlResourceParser.getAttributeName(i16).equals("name")) {
                                        packageInfo.applicationInfo.className = openXmlResourceParser.getAttributeValue(i16);
                                    }
                                }
                            } else {
                                String str2 = "";
                                if (name.equals("meta-data")) {
                                    String str3 = "";
                                    for (int i17 = 0; i17 < openXmlResourceParser.getAttributeCount(); i17++) {
                                        if (openXmlResourceParser.getAttributeName(i17).equals("name")) {
                                            str2 = openXmlResourceParser.getAttributeValue(i17);
                                        }
                                        if (openXmlResourceParser.getAttributeName(i17).equals("value")) {
                                            str3 = openXmlResourceParser.getAttributeValue(i17);
                                        }
                                    }
                                    packageInfo.applicationInfo.metaData.putString(str2, str3);
                                } else if (name.equals(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY)) {
                                    for (int i18 = 0; i18 < openXmlResourceParser.getAttributeCount(); i18++) {
                                        if (openXmlResourceParser.getAttributeName(i18).equals("name")) {
                                            str2 = openXmlResourceParser.getAttributeValue(i18);
                                        }
                                    }
                                    ActivityInfo activityInfo = new ActivityInfo();
                                    activityInfo.name = str2;
                                    ActivityInfo[] activityInfoArr = packageInfo.activities;
                                    if (activityInfoArr == null) {
                                        packageInfo.activities = new ActivityInfo[]{activityInfo};
                                    } else {
                                        int length = activityInfoArr.length;
                                        ActivityInfo[] activityInfoArr2 = (ActivityInfo[]) Arrays.copyOf(activityInfoArr, length + 1);
                                        packageInfo.activities = activityInfoArr2;
                                        activityInfoArr2[length] = activityInfo;
                                    }
                                }
                            }
                        }
                    }
                }
                try {
                    openXmlResourceParser.close();
                } catch (Exception unused) {
                }
                return packageInfo;
            } catch (Exception e16) {
                throw e16;
            }
        } catch (Throwable th5) {
            try {
                openXmlResourceParser.close();
            } catch (Exception unused2) {
            }
            throw th5;
        }
    }

    public static PackageInfo getPackageInfoWithException(Context context, String str, int i3) throws Throwable {
        PackageInfo packageInfo = getPackageInfo(str);
        if (packageInfo == null) {
            return InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), context.getPackageName(), 128);
        }
        return packageInfo;
    }

    public static Signature[] getSignaure(String str) {
        Method method;
        Field field;
        Object newInstance;
        Object invoke;
        try {
            Class<?> cls = Class.forName("android.content.pm.PackageParser");
            Class<?> cls2 = Class.forName("android.content.pm.PackageParser$Package");
            Constructor<?> constructor = cls.getConstructor(String.class);
            Class<?> cls3 = Integer.TYPE;
            Method method2 = cls.getMethod("parsePackage", File.class, String.class, DisplayMetrics.class, cls3);
            method = cls.getMethod("collectCertificates", cls2, cls3);
            field = cls2.getField("mSignatures");
            newInstance = constructor.newInstance(str);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            displayMetrics.setToDefaults();
            invoke = method2.invoke(newInstance, new File(str), str, displayMetrics, 0);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        if (invoke == null) {
            return null;
        }
        method.invoke(newInstance, invoke, 64);
        Object obj = field.get(invoke);
        if (obj != null && (obj instanceof Signature[])) {
            return (Signature[]) obj;
        }
        return null;
    }

    public static boolean isApkFileBroken(Context context, String str) {
        PackageInfo packageArchiveInfo = context.getPackageManager().getPackageArchiveInfo(str, 64);
        if (packageArchiveInfo != null && packageArchiveInfo.applicationInfo != null) {
            return false;
        }
        return true;
    }

    public static boolean isSignaturesSame(Signature[] signatureArr, Signature[] signatureArr2) {
        if (signatureArr == null || signatureArr2 == null) {
            return true;
        }
        HashSet hashSet = new HashSet();
        for (Signature signature : signatureArr) {
            hashSet.add(signature);
        }
        HashSet hashSet2 = new HashSet();
        for (Signature signature2 : signatureArr2) {
            hashSet2.add(signature2);
        }
        return hashSet.equals(hashSet2);
    }

    public static PackageInfo getPackageInfo(Context context, String str, int i3) throws Throwable {
        return context.getPackageManager().getPackageArchiveInfo(str, i3);
    }
}
