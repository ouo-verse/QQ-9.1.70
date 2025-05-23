package ok3;

import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;
import com.tencent.mobileqq.zplan.smallhome.floatwindow.engine.ZPlanFloatEngineIPCImpl;
import kotlin.Metadata;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&\u00a8\u0006\u0006"}, d2 = {"Lok3/b;", "", "", "keepEngine", "resumeEngine", "releaseKeeping", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
@ServletImpl(impl = ZPlanFloatEngineIPCImpl.class)
/* loaded from: classes38.dex */
public interface b {
    void keepEngine();

    void releaseKeeping();

    void resumeEngine();
}
