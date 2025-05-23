package mqq.util;

import android.app.ActivityManager;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import java.util.List;
import mqq.app.Foreground;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes28.dex */
public class ForegroundUtil {
    public static boolean isAppOnForeground() {
        if (Foreground.getActivityCount() > 0) {
            return true;
        }
        ActivityManager activityManager = (ActivityManager) MobileQQ.sMobileQQ.getBaseContext().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        String packageName = MobileQQ.sMobileQQ.getBaseContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = SystemMethodProxy.getRunningAppProcesses(activityManager);
        if (runningAppProcesses == null) {
            return false;
        }
        for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
            if (runningAppProcessInfo != null && runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(packageName)) {
                return true;
            }
        }
        return false;
    }
}
