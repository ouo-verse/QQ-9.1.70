package lj0;

import android.app.ActivityManager;
import android.os.Build;
import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.block.SystemMethodProxy;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u000b\u0010\fJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\bJ\u0006\u0010\n\u001a\u00020\b\u00a8\u0006\r"}, d2 = {"Llj0/a;", "", "Landroid/os/Debug$MemoryInfo;", "a", "", "pid", "d", "e", "", "c", "b", "<init>", "()V", "ecommerce_sdk_debug"}, k = 1, mv = {1, 4, 1})
/* loaded from: classes38.dex */
public final class a {

    /* renamed from: a, reason: collision with root package name */
    public static final a f414855a = new a();

    a() {
    }

    private final Debug.MemoryInfo a() {
        Debug.MemoryInfo memoryInfo = new Debug.MemoryInfo();
        Debug.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public final long b() {
        return Runtime.getRuntime().freeMemory();
    }

    public final long c() {
        return Runtime.getRuntime().totalMemory() - b();
    }

    public final Debug.MemoryInfo d(int pid) {
        if (Build.VERSION.SDK_INT > 28 && pid == Process.myPid()) {
            return a();
        }
        return e(pid);
    }

    public final Debug.MemoryInfo e(int pid) {
        Object systemService = wg0.a.a().getSystemService(WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY);
        if (systemService != null) {
            Debug.MemoryInfo[] processMemoryInfo = SystemMethodProxy.getProcessMemoryInfo((ActivityManager) systemService, new int[]{pid});
            if (processMemoryInfo.length == 0) {
                return new Debug.MemoryInfo();
            }
            return processMemoryInfo[0];
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.ActivityManager");
    }
}
