package com.tencent.biz.qqcircle.utils;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;

/* compiled from: P */
/* loaded from: classes5.dex */
public class ak {
    public static boolean a(Activity activity) {
        if (activity == null || activity.getIntent() == null) {
            return false;
        }
        Intent intent = activity.getIntent();
        if (!TextUtils.equals("android.intent.action.MAIN", intent.getAction()) || !intent.hasCategory("android.intent.category.LAUNCHER")) {
            return false;
        }
        return true;
    }
}
