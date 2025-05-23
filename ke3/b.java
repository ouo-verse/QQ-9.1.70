package ke3;

import com.tencent.mobileqq.zplan.aio.miniaio.ZPlanMiniAioIPCImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanMiniAioIPCImpl.class)
/* loaded from: classes38.dex */
public interface b {
    void getUnreadCount(c cVar);
}
