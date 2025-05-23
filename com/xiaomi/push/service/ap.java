package com.xiaomi.push.service;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ap {
    public static ComponentName a(Context context, Intent intent) {
        String str;
        if (intent == null) {
            return null;
        }
        try {
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
            if (resolveActivity == null) {
                return null;
            }
            if (TextUtils.isEmpty(resolveActivity.activityInfo.targetActivity)) {
                str = resolveActivity.activityInfo.name;
            } else {
                str = resolveActivity.activityInfo.targetActivity;
            }
            return new ComponentName(resolveActivity.activityInfo.packageName, str);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(Context context, ComponentName componentName) {
        try {
            new Intent().setComponent(componentName);
            context.getPackageManager().getActivityInfo(componentName, 128);
            return true;
        } catch (Exception unused) {
            return false;
        }
    }
}
