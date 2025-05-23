package ke3;

import com.tencent.mobileqq.zplan.aio.miniaio.ZPlanMiniAioIPCImpl;
import com.tencent.mobileqq.zplan.ipc.annotation.ServletImpl;

/* compiled from: P */
@ServletImpl(impl = ZPlanMiniAioIPCImpl.class, process = "com.tencent.mobileqq:zplan")
/* loaded from: classes38.dex */
public interface a {
    void notifyCloseMiniAIO();

    void notifyOpenAIO();

    void notifyUnreadCount(int i3);
}
