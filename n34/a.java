package n34;

import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.api.ac;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.Nullable;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/api/ac;", "a", "robot-business-impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes25.dex */
public final class a {
    @Nullable
    public static final ac a() {
        IRuntimeService iRuntimeService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        if (peekAppRuntime != null) {
            iRuntimeService = peekAppRuntime.getRuntimeService(IKernelService.class, "");
        } else {
            iRuntimeService = null;
        }
        IKernelService iKernelService = (IKernelService) iRuntimeService;
        if (iKernelService == null) {
            return null;
        }
        return iKernelService.getRobotService();
    }
}
