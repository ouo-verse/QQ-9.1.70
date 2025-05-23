package h45;

import android.content.Context;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes29.dex */
public class g {
    public static boolean a(Context context, int i3) {
        if (context == null) {
            q.q.q.e.w.e.c("SDKUtil", "context is null", true);
            return false;
        }
        if (b(context) >= i3) {
            return false;
        }
        return true;
    }

    public static int b(Context context) {
        try {
            int i3 = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), e.a(context).b(), 0).versionCode;
            q.q.q.e.w.e.c("SDKUtil", "versionCode " + i3, true);
            return i3;
        } catch (PackageManager.NameNotFoundException unused) {
            q.q.q.e.w.e.b("SDKUtil", "NameNotFoundException error", true);
            return 0;
        } catch (Exception unused2) {
            q.q.q.e.w.e.b("SDKUtil", "Exception error", true);
            return 0;
        }
    }

    public static boolean c(Context context, int i3) {
        if (context == null) {
            q.q.q.e.w.e.c("SDKUtil", "context is null", true);
            return false;
        }
        if (b(context) < i3) {
            return false;
        }
        return true;
    }

    public static boolean d(Context context, int i3) {
        if (context == null) {
            q.q.q.e.w.e.c("SDKUtil", "context is null", true);
            return false;
        }
        if (b(context) > i3) {
            return false;
        }
        return true;
    }
}
