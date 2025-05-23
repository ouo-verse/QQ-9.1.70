package ee2;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    private static volatile String f396204a;

    public static void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.d("PandoraEventSceneManager", 1, "enterEventScene: " + str + ", lastEventScene: " + f396204a);
        f396204a = str;
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        QLog.d("PandoraEventSceneManager", 1, "exitEventScene: " + str + ", currentEventScene: " + f396204a);
        if (str.equals(f396204a)) {
            f396204a = null;
        }
    }

    public static String c(String str) {
        return d(str, f396204a);
    }

    public static String d(String str, String str2) {
        String str3 = a.f396184b.get(str);
        String str4 = a.f396185c.get(f(str, str2));
        if (!TextUtils.isEmpty(str4)) {
            return str4;
        }
        return str3;
    }

    public static String e() {
        if (f396204a == null) {
            return "";
        }
        return f396204a;
    }

    public static String f(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str + "#" + str2;
    }
}
