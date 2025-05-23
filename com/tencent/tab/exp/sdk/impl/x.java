package com.tencent.tab.exp.sdk.impl;

import android.app.Application;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import com.tencent.tab.exp.sdk.export.config.TabEnvironment;
import java.util.Arrays;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes26.dex */
public final class x {

    /* renamed from: a, reason: collision with root package name */
    private static String f374184a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(TabEnvironment tabEnvironment, String str, String str2, String str3, String str4) {
        return "[environment = " + d(TabEnvironment.toStorageName(tabEnvironment), "EmptyEnvironment") + ", appId = " + d(str, "EmptyAppId") + ", sceneId = " + d(str2, "EmptySceneId") + ", guid = " + d(str3, "EmptyGuid") + "]-----" + d(str4, "EmptyContent");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String b() {
        String str = f374184a;
        if (str != null) {
            return str;
        }
        try {
            Application a16 = b.a();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(a16.getPackageManager(), a16.getPackageName(), 0);
            String str2 = packageInfo.versionName;
            f374184a = str2;
            int i3 = packageInfo.versionCode;
            if (TextUtils.isEmpty(str2)) {
                f374184a = String.valueOf(i3);
            }
            String replace = f374184a.trim().replace('\n', TokenParser.SP).replace('\r', TokenParser.SP).replace("|", "%7C");
            f374184a = replace;
            return replace;
        } catch (Exception unused) {
            return f374184a;
        }
    }

    public static int c(int i3, int i16) {
        if (i3 <= 0) {
            return i16;
        }
        return i3;
    }

    public static String d(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        return str;
    }

    public static <T> T e(T t16, T t17) {
        if (t16 == null) {
            return t17;
        }
        return t16;
    }

    public static String f(String str, String str2) {
        return d(str, "EmptyAppId") + "_" + d(str2, "EmptySceneId");
    }

    public static boolean g(Object obj, Object obj2) {
        if (obj != obj2 && (obj == null || !obj.equals(obj2))) {
            return false;
        }
        return true;
    }

    public static int h(Object... objArr) {
        return Arrays.hashCode(objArr);
    }
}
