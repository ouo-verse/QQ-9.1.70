package com.tencent.luggage.wxa.uk;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import com.tencent.luggage.wxa.tk.l;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import org.apache.httpcore.message.TokenParser;

/* compiled from: P */
/* loaded from: classes8.dex */
public abstract class j {

    /* renamed from: a, reason: collision with root package name */
    public static final Set f142734a = new HashSet();

    /* renamed from: b, reason: collision with root package name */
    public static final char[] f142735b = {Typography.less, Typography.greater, '\"', '\'', Typography.amp, TokenParser.SP, '\''};

    /* renamed from: c, reason: collision with root package name */
    public static final String[] f142736c = {"&lt;", "&gt;", "&quot;", "&apos;", "&amp;", "&nbsp;", "&#39;"};

    public static String a(int i3, Object... objArr) {
        return com.tencent.luggage.wxa.tn.z.j().getString(i3, objArr);
    }

    public static void a(Object obj) {
        if (obj == null) {
            return;
        }
        f142734a.remove(obj);
    }

    public static l.a a() {
        return com.tencent.luggage.wxa.tk.l.a();
    }

    public static String a(String str) {
        if (str == null) {
            return null;
        }
        return str.replace('\u2028', '\n').replace('\u2029', '\n');
    }

    public static String a(ComponentName componentName) {
        PackageManager packageManager;
        if (componentName == null || (packageManager = com.tencent.luggage.wxa.tn.z.c().getPackageManager()) == null) {
            return "[UNKNOWN]";
        }
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            if (activityInfo != null) {
                return activityInfo.taskAffinity;
            }
        } catch (Exception e16) {
            com.tencent.luggage.wxa.tn.w.b("MicroMsg.AppBrandUtil", "getActivityTaskAffinity e = %s", e16);
        }
        return "[UNKNOWN]";
    }
}
