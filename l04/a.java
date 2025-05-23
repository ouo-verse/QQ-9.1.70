package l04;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class a {
    public static float a() {
        float f16 = ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.MEMORY_BIG_BITMAP).com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String.threshold / 100.0f;
        if (f16 < 1.5f) {
            return 1.5f;
        }
        return f16;
    }
}
