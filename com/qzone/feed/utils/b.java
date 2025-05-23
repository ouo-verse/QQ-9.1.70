package com.qzone.feed.utils;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.qzone.common.activities.base.QZoneFragmentHolderActivity;
import com.qzone.common.activities.base.QZoneFragmentHolderInMainProcessActivity;
import com.qzone.common.activities.base.QZoneTransparentFragmentHolderActivity;
import com.qzone.common.activities.base.QZoneTransparentFragmentHolderInMainProcessActivity;
import com.qzone.reborn.base.QZoneShellActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.api.QZoneApiProxy;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes39.dex */
public class b {

    /* renamed from: b, reason: collision with root package name */
    private static long f47466b;

    /* renamed from: a, reason: collision with root package name */
    private static final long f47465a = TimeUnit.SECONDS.toNanos(1);

    /* renamed from: c, reason: collision with root package name */
    private static String f47467c = null;

    private static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains(QZoneShellActivity.class.getName()) || str.contains(QZoneFragmentHolderActivity.class.getName()) || str.contains(QZoneFragmentHolderInMainProcessActivity.class.getName()) || str.contains(QZoneTransparentFragmentHolderActivity.class.getName()) || str.contains(QZoneTransparentFragmentHolderInMainProcessActivity.class.getName());
    }

    private static boolean c(Intent intent) {
        ComponentName component;
        if (!QZoneApiProxy.isInQZoneEnvironment() && (component = intent.getComponent()) != null) {
            String className = component.getClassName();
            QZLog.i("JumpCompatUtils", "parsePluginIntent: " + className);
            if (className.startsWith("com.qzone.")) {
                intent.putExtra("jump_from_main_process", true);
                QzonePluginProxyActivity.setActivityNameToIntent(intent, className);
                QZoneHelper.setUserInfoToIntent(intent, QZoneHelper.UserInfo.getInstance());
                return true;
            }
        }
        return false;
    }

    public static void e(Activity activity, Intent intent, int i3) {
        if (activity != null && intent != null) {
            if (c(intent)) {
                if (b(intent)) {
                    return;
                }
                QzonePluginProxyActivity.launchPluingActivityForResult(activity, BaseApplicationImpl.getApplication().getRuntime().getAccount(), intent, i3);
                return;
            } else {
                try {
                    activity.startActivityForResult(intent, i3);
                    return;
                } catch (Throwable th5) {
                    QZLog.w("JumpCompatUtils", "startActivityForResult: ", th5);
                    return;
                }
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startActivityForResult: null param ");
        sb5.append(activity == null);
        sb5.append(" ");
        sb5.append(intent == null);
        QZLog.w("JumpCompatUtils", sb5.toString(), new Throwable());
    }

    public static void f(Activity activity, Intent intent, int i3) {
        if (activity != null && intent != null) {
            if (b(intent)) {
                return;
            }
            try {
                activity.startActivityForResult(intent, i3);
                return;
            } catch (Throwable th5) {
                QZLog.w("JumpCompatUtils", "startActivityForResult: ", th5);
                return;
            }
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startActivityForResult: null param ");
        sb5.append(activity == null);
        sb5.append(" ");
        sb5.append(intent == null);
        QZLog.w("JumpCompatUtils", sb5.toString(), new Throwable());
    }

    private static void g(Context context, Intent intent) {
        try {
            if (!(context instanceof Activity)) {
                if (QLog.isColorLevel()) {
                    QLog.w("JumpCompatUtils", 2, "startActivity use application context: " + Log.getStackTraceString(new Throwable()));
                }
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Throwable th5) {
            QZLog.w("JumpCompatUtils", "startActivity: ", th5);
        }
    }

    public static boolean b(Intent intent) {
        ComponentName component;
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        String className = component.getClassName();
        if (a(className)) {
            return false;
        }
        long nanoTime = System.nanoTime();
        QZLog.d("JumpCompatUtils", 4, "isJumpTooOften: " + className + " " + nanoTime + " " + f47467c + " " + f47466b);
        if (className.equals(f47467c) && nanoTime - f47466b < f47465a) {
            QZLog.i("JumpCompatUtils", "isJumpTooOften: jump ignore " + f47467c + " " + (nanoTime - f47466b));
            return true;
        }
        f47467c = className;
        f47466b = System.nanoTime();
        return false;
    }

    public static void d(Context context, Intent intent) {
        if (context != null && intent != null) {
            if (c(intent)) {
                if (context instanceof Activity) {
                    if (b(intent)) {
                        return;
                    }
                    QzonePluginProxyActivity.launchPluingActivityForResult((Activity) context, BaseApplicationImpl.getApplication().getRuntime().getAccount(), intent, 0);
                    return;
                }
                g(context, intent);
                return;
            }
            g(context, intent);
            return;
        }
        StringBuilder sb5 = new StringBuilder();
        sb5.append("startActivity: null param ");
        sb5.append(context == null);
        sb5.append(" ");
        sb5.append(intent == null);
        QZLog.w("JumpCompatUtils", sb5.toString(), new Throwable());
    }
}
