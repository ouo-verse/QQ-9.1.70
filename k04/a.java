package k04;

import com.tencent.bugly.common.utils.ContextUtil;
import com.tencent.bugly.common.utils.DeviceInfoUtil;
import com.tencent.bugly.common.utils.RMonitorFeatureHelper;
import com.tencent.bugly.library.BuglyMonitorName;
import com.tencent.opentelemetry.semconv.resource.attributes.ResourceAttributes;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.data.j;
import java.util.ArrayList;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes25.dex */
public class a {

    /* renamed from: d, reason: collision with root package name */
    private static volatile a f411373d;

    /* renamed from: a, reason: collision with root package name */
    private boolean f411374a = false;

    /* renamed from: b, reason: collision with root package name */
    private boolean f411375b = false;

    /* renamed from: c, reason: collision with root package name */
    private boolean f411376c = false;

    a() {
    }

    private ArrayList<String> a(boolean z16, boolean z17, boolean z18) {
        ArrayList<String> arrayList = new ArrayList<>();
        if (z16) {
            arrayList.add(BuglyMonitorName.NATIVE_MEMORY_ANALYZE);
        }
        if (z17) {
            arrayList.add(BuglyMonitorName.FD_ANALYZE);
        }
        if (z18) {
            arrayList.add(BuglyMonitorName.ASAN);
        }
        return arrayList;
    }

    public static a b() {
        if (f411373d == null) {
            synchronized (a.class) {
                if (f411373d == null) {
                    f411373d = new a();
                }
            }
        }
        return f411373d;
    }

    private String c() {
        if (this.f411375b) {
            return BuglyMonitorName.NATIVE_MEMORY_ANALYZE;
        }
        if (this.f411374a) {
            return BuglyMonitorName.FD_ANALYZE;
        }
        if (this.f411376c) {
            return BuglyMonitorName.ASAN;
        }
        return null;
    }

    private boolean d(boolean z16, boolean z17, boolean z18) {
        if (!z17 && !z16 && !z18) {
            return false;
        }
        return true;
    }

    public boolean e(String str) {
        String a16 = j.a(str);
        for (String str2 : Arrays.asList(j.a(BuglyMonitorName.NATIVE_MEMORY_ANALYZE), j.a(BuglyMonitorName.FD_ANALYZE), j.a(BuglyMonitorName.ASAN))) {
            if (!a16.equals(str2) && RMonitorFeatureHelper.getInstance().isPluginStarted(str2)) {
                return true;
            }
        }
        return false;
    }

    public boolean f() {
        String cpuAbiByLibDir = DeviceInfoUtil.getCpuAbiByLibDir(ContextUtil.getGlobalContext());
        if (!cpuAbiByLibDir.contains(ResourceAttributes.HostArchValues.X86) && !cpuAbiByLibDir.contains("fail")) {
            return false;
        }
        return true;
    }

    public String g() {
        ConfigProxy configProxy = ConfigProxy.INSTANCE;
        boolean z16 = configProxy.getConfig().k(BuglyMonitorName.NATIVE_MEMORY_ANALYZE).enabled;
        boolean z17 = configProxy.getConfig().k(BuglyMonitorName.FD_ANALYZE).enabled;
        boolean z18 = configProxy.getConfig().k(BuglyMonitorName.ASAN).enabled;
        if (!d(z16, z17, z18)) {
            return "none";
        }
        String c16 = c();
        if (c16 != null) {
            return c16;
        }
        String str = a(z16, z17, z18).get((int) (Math.random() * r0.size()));
        str.hashCode();
        char c17 = '\uffff';
        switch (str.hashCode()) {
            case -1009937852:
                if (str.equals(BuglyMonitorName.FD_ANALYZE)) {
                    c17 = 0;
                    break;
                }
                break;
            case -990809559:
                if (str.equals(BuglyMonitorName.NATIVE_MEMORY_ANALYZE)) {
                    c17 = 1;
                    break;
                }
                break;
            case 3003359:
                if (str.equals(BuglyMonitorName.ASAN)) {
                    c17 = 2;
                    break;
                }
                break;
        }
        switch (c17) {
            case 0:
                this.f411374a = true;
                break;
            case 1:
                this.f411375b = true;
                break;
            case 2:
                this.f411376c = true;
                break;
        }
        return str;
    }
}
