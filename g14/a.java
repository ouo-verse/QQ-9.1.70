package g14;

import android.os.Debug;
import com.tencent.bugly.common.utils.AndroidVersion;
import com.tencent.rmonitor.common.logger.Logger;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static long a() {
        try {
            if (AndroidVersion.isOverM()) {
                long parseLong = Long.parseLong(Debug.getRuntimeStat("art.gc.gc-count"));
                if (parseLong >= 0) {
                    return parseLong;
                }
            }
        } catch (Throwable th5) {
            Logger.f365497g.c("Bugly_GcGuard", th5);
        }
        return 0L;
    }
}
