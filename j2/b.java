package j2;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;
import h45.e;

/* compiled from: P */
/* loaded from: classes2.dex */
public class b {
    public static boolean a(Context context) {
        PackageManager packageManager = context.getPackageManager();
        try {
            String b16 = e.a(context).b();
            PackageInfo packageInfo = InstalledAppListMonitor.getPackageInfo(packageManager, b16, 0);
            q.q.q.e.w.e.c("PackageUtils", "packageName " + b16, true);
            return packageInfo.versionName.contains("oversea");
        } catch (PackageManager.NameNotFoundException unused) {
            q.q.q.e.w.e.b("PackageUtils", "NameNotFoundException error", true);
            return false;
        } catch (Exception unused2) {
            q.q.q.e.w.e.b("PackageUtils", "Exception error", true);
            return false;
        }
    }
}
