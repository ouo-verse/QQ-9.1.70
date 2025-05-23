package gl4;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {
    public static long a(Context context) {
        Debug.MemoryInfo memoryInfo;
        ActivityManager activityManager = (ActivityManager) context.getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (activityManager == null) {
            return 0L;
        }
        if (Build.VERSION.SDK_INT > 28) {
            memoryInfo = new Debug.MemoryInfo();
            Debug.getMemoryInfo(memoryInfo);
        } else {
            memoryInfo = SystemMethodProxy.getProcessMemoryInfo(activityManager, new int[]{Process.myPid()})[0];
        }
        return memoryInfo.getTotalPss() / 1024.0f;
    }
}
