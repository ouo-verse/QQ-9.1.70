package e14;

import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.d;
import com.tencent.rmonitor.base.config.data.h;
import com.tencent.rmonitor.base.config.data.i;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {
    public static d a() {
        return ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.MEMORY_JAVA_CEILING);
    }

    public static float b() {
        return c().threshold / 100.0f;
    }

    public static h c() {
        return (h) a().com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
    }

    public static d d() {
        return ConfigProxy.INSTANCE.getConfig().i(BuglyMonitorName.MEMORY_JAVA_LEAK);
    }

    public static i e() {
        return (i) d().com.tencent.mobileqq.shortvideo.gesture.DownloadInfo.spKey_Config java.lang.String;
    }
}
