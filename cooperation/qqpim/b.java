package cooperation.qqpim;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qmethod.pandoraex.monitor.InstalledAppListMonitor;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {
    public static Intent a(Context context, String str, String str2) {
        try {
            if (InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpim", 1).versionCode < 1171) {
                Intent b16 = b(context);
                b16.putExtra("big_brother_source_key", "biz_src_qqpim");
                return b16;
            }
            Intent intent = new Intent();
            intent.setPackage("com.tencent.qqpim");
            intent.setAction("com.tencent.qqpim.action_open_qqpim");
            intent.putExtra("product_package", "com.tencent.mobileqq");
            intent.putExtra("model_name", str);
            if (!TextUtils.isEmpty(str2)) {
                intent.putExtra("account_name", str2);
            }
            intent.setFlags(67108864);
            intent.setFlags(268435456);
            intent.putExtra("big_brother_source_key", "biz_src_qqpim");
            return intent;
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static Intent b(Context context) {
        try {
            return InstalledAppListMonitor.getLaunchIntentForPackage(context.getPackageManager(), "com.tencent.qqpim");
        } catch (Throwable th5) {
            th5.printStackTrace();
            return null;
        }
    }

    public static boolean c(Context context) {
        PackageInfo packageInfo;
        try {
            packageInfo = InstalledAppListMonitor.getPackageInfo(context.getPackageManager(), "com.tencent.qqpim", 1);
        } catch (Throwable th5) {
            th5.printStackTrace();
            packageInfo = null;
        }
        if (packageInfo != null) {
            return true;
        }
        return false;
    }

    public void d(QQAppInterface qQAppInterface, Activity activity, Bundle bundle) {
        if (c(activity)) {
            ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006711", "0X8006711", 0, 0, "", "", "", "");
            Intent a16 = a(activity, a.f390818v, null);
            if (a16 != null) {
                activity.startActivity(a16);
                return;
            }
            return;
        }
        ReportController.o(qQAppInterface, "CliOper", "", "", "0X8006712", "0X8006712", 0, 0, "", "", "", "");
        Intent intent = new Intent();
        intent.setClass(activity, QQPimBridgeActivity.class);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }
}
