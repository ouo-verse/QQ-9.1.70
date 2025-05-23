package com.tencent.midas.plugin;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import java.util.HashSet;

/* loaded from: classes9.dex */
public class APApkFileParser {
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

    public static PackageInfo getPackageInfo(Context context, String str, int i3) {
        try {
            return context.getPackageManager().getPackageArchiveInfo(str, i3);
        } catch (Exception unused) {
            return null;
        }
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
}
