package com.tenpay.api;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.util.pm.PackageUtil;

/* loaded from: classes27.dex */
public class PackageUtilWrap {
    public static PackageInfo getPackageInfo(Context context, String str) throws PackageManager.NameNotFoundException {
        return PackageUtil.getPackageInfo(context, str);
    }
}
