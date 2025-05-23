package com.tencent.open.agent.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.image.DownloadParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qqconnect.wtlogin.AbstractOpenSdkAppInterface;
import com.tencent.qqconnect.wtlogin.IOpenSdkQQLiteBridgeApi;
import com.tencent.widget.ActionSheet;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes22.dex */
public class p {
    public static boolean a() {
        Object f16 = f(5);
        if (f16 instanceof Boolean) {
            return ((Boolean) f16).booleanValue();
        }
        return false;
    }

    public static void b(ActionSheet actionSheet) {
        hp3.f fVar = new hp3.f(10);
        fVar.f405832g = actionSheet;
        g(fVar);
    }

    public static String c(String str) {
        hp3.f fVar = new hp3.f(8);
        fVar.f405830e = str;
        return (String) g(fVar);
    }

    public static void d(Bundle bundle) {
        hp3.f fVar = new hp3.f(6);
        fVar.f405829d = bundle;
        g(fVar);
    }

    public static Uri e(Activity activity) {
        hp3.f fVar = new hp3.f(12);
        fVar.f405827b = activity;
        return (Uri) g(fVar);
    }

    private static Object f(int i3) {
        return g(new hp3.f(i3));
    }

    private static Object g(hp3.f fVar) {
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime instanceof AbstractOpenSdkAppInterface) {
            return ((AbstractOpenSdkAppInterface) peekAppRuntime).fetchQQLiteStatus(fVar);
        }
        return ((IOpenSdkQQLiteBridgeApi) QRoute.api(IOpenSdkQQLiteBridgeApi.class)).fetchQQLiteStatus(fVar);
    }

    public static String h(String str) {
        hp3.f fVar = new hp3.f(2);
        fVar.f405836k = str;
        return (String) g(fVar);
    }

    public static Drawable i(int i3) {
        hp3.f fVar = new hp3.f(1);
        fVar.f405835j = i3;
        return (Drawable) g(fVar);
    }

    public static DownloadParams.DecodeHandler j() {
        return (DownloadParams.DecodeHandler) f(3);
    }

    public static String k(Intent intent) {
        hp3.f fVar = new hp3.f(9);
        fVar.f405831f = intent;
        return (String) g(fVar);
    }

    public static boolean l(Context context) {
        hp3.f fVar = new hp3.f(7);
        fVar.f405828c = context;
        Object g16 = g(fVar);
        if (g16 instanceof Boolean) {
            return ((Boolean) g16).booleanValue();
        }
        return false;
    }

    public static boolean m() {
        Object f16 = f(4);
        if (f16 instanceof Boolean) {
            return ((Boolean) f16).booleanValue();
        }
        return false;
    }

    public static void n(int i3, Activity activity, Uri uri) {
        hp3.f fVar = new hp3.f(13);
        fVar.f405834i = i3;
        fVar.f405827b = activity;
        fVar.f405833h = uri;
        g(fVar);
    }

    public static void o(Activity activity) {
        hp3.f fVar = new hp3.f(11);
        fVar.f405827b = activity;
        g(fVar);
    }
}
