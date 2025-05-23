package gv1;

import android.os.Debug;
import android.os.Process;
import com.tencent.mobileqq.perf.tool.CpuUtil;
import com.tencent.mobileqq.perf.tool.MemoryUtil;

/* compiled from: P */
/* loaded from: classes14.dex */
public class a implements fv1.a {
    @Override // fv1.a
    public Debug.MemoryInfo a() {
        return MemoryUtil.l(Process.myPid());
    }

    @Override // fv1.a
    public float getCpuUsage() {
        return CpuUtil.f258160a.g(Process.myPid());
    }
}
