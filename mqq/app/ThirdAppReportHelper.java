package mqq.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ThirdAppReportHelper {
    public static IThirdAppOpenReport sThirdAppReporter;

    public static void handleIntentForQQBrowser(Context context, Intent intent) {
        if (intent.getComponent() == null) {
            return;
        }
        try {
            String className = intent.getComponent().getClassName();
            if (className != null) {
                if ((className.contains("QQBrowserActivity") || className.contains("QQBrowserDelegationActivity")) && !intent.hasExtra("StartClickTime")) {
                    intent.putExtra("StartClickTime", SystemClock.elapsedRealtime());
                    intent.putExtra("SourceActivityName", context.getClass().getSimpleName());
                }
            }
        } catch (Throwable th5) {
            QLog.e("mqq", 1, "handleIntentForQQBrowser, ", th5);
        }
    }

    public static void reportThirdAppOpen(Context context, Intent intent, int i3) {
        IThirdAppOpenReport iThirdAppOpenReport = sThirdAppReporter;
        if (iThirdAppOpenReport != null) {
            iThirdAppOpenReport.report(context, intent, i3);
        }
        handleIntentForQQBrowser(context, intent);
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i3, Bundle bundle) {
        IThirdAppOpenReport iThirdAppOpenReport = sThirdAppReporter;
        if (iThirdAppOpenReport != null) {
            iThirdAppOpenReport.startActivityForResult(activity, intent, i3, bundle);
        }
        handleIntentForQQBrowser(activity, intent);
    }
}
