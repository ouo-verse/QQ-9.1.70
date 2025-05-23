package com.tencent.aelight.camera.ae.util;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.SplashActivity;

/* compiled from: P */
/* loaded from: classes32.dex */
public class r {

    /* renamed from: a, reason: collision with root package name */
    public static final String f65828a = SplashActivity.class.getPackage().getName();

    /* renamed from: b, reason: collision with root package name */
    public static final String f65829b = SplashActivity.class.getSimpleName();

    public static boolean a(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith(f65828a) && str.endsWith(f65829b);
    }
}
