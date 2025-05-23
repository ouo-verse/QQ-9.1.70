package of2;

import com.tencent.common.app.AppInterface;
import com.tencent.qqnt.kernel.api.IKernelService;
import com.tencent.qqnt.kernel.nativeinterface.IQQNTWrapperSession;
import kotlin.Metadata;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

/* compiled from: P */
@Metadata(d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\b\u0010\u0001\u001a\u0004\u0018\u00010\u0000\u00a8\u0006\u0002"}, d2 = {"Lcom/tencent/qqnt/kernel/nativeinterface/IQQNTWrapperSession;", "a", "qqecommerce_impl_release"}, k = 2, mv = {1, 7, 1})
/* loaded from: classes38.dex */
public final class bi {
    public static final IQQNTWrapperSession a() {
        IKernelService iKernelService;
        AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
        AppInterface appInterface = peekAppRuntime instanceof AppInterface ? (AppInterface) peekAppRuntime : null;
        if (appInterface == null || (iKernelService = (IKernelService) appInterface.getRuntimeService(IKernelService.class, "all")) == null) {
            return null;
        }
        return iKernelService.getWrapperSession();
    }
}
