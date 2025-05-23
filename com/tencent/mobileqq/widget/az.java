package com.tencent.mobileqq.widget;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.QQTheme;
import com.tencent.qphone.base.util.BaseApplication;

/* compiled from: P */
/* loaded from: classes20.dex */
public class az {

    /* renamed from: a, reason: collision with root package name */
    public static boolean f316687a = false;

    /* renamed from: b, reason: collision with root package name */
    public static boolean f316688b = AppSetting.f99565y;

    /* renamed from: c, reason: collision with root package name */
    public static boolean f316689c = AppSetting.f99566z;

    /* renamed from: d, reason: collision with root package name */
    public static a f316690d;

    /* compiled from: P */
    /* loaded from: classes20.dex */
    public interface a {
        String a(int i3);
    }

    public static int a(Context context, float f16) {
        return com.tencent.mobileqq.util.x.c(BaseApplication.getContext(), f16);
    }

    public static String b() {
        return QQTheme.getCurrentThemeId();
    }

    public static int c(Context context) {
        return com.tencent.mobileqq.util.x.e(context);
    }

    public static boolean d() {
        return QQTheme.isDefaultOrDIYTheme();
    }

    public static boolean e(Context context) {
        if (com.tencent.mobileqq.util.x.g(context) && com.tencent.mobileqq.util.x.a(context)) {
            return true;
        }
        return false;
    }

    public static boolean f() {
        return QQTheme.isNowThemeIsNight();
    }

    public static String g(int i3) {
        a aVar = f316690d;
        if (aVar != null) {
            String a16 = aVar.a(i3);
            if (!TextUtils.isEmpty(a16)) {
                return a16;
            }
        }
        return HardCodeUtil.qqStr(i3);
    }
}
