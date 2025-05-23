package dn1;

import com.tencent.mobileqq.guild.feed.personalbox.IGuildFeedPersonalBoxUnreadService;
import com.tencent.mobileqq.guild.message.base.f;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import tencent.im.group_pro_proto.synclogic.synclogic$FeedsEventNode;
import tencent.im.group_pro_proto.synclogic.synclogic$FirstViewRsp;

/* compiled from: P */
/* loaded from: classes13.dex */
public class a extends f {

    /* renamed from: a, reason: collision with root package name */
    private static String f394308a = "PersonalBoxForRegistProxy";

    @Override // com.tencent.mobileqq.guild.message.base.f
    public void b(AppRuntime appRuntime, boolean z16, synclogic$FirstViewRsp synclogic_firstviewrsp) {
        if (appRuntime != null && z16 && synclogic_firstviewrsp != null && synclogic_firstviewrsp.feeds_event_node.has()) {
            synclogic$FeedsEventNode synclogic_feedseventnode = synclogic_firstviewrsp.feeds_event_node.get();
            if (synclogic_feedseventnode.is_valid.get() == 0) {
                QLog.e(f394308a, 1, "onUpdateRegisterProxyReq is_valid false");
            } else {
                ((IGuildFeedPersonalBoxUnreadService) appRuntime.getRuntimeService(IGuildFeedPersonalBoxUnreadService.class, "")).onReceiveRegistProxy(synclogic_feedseventnode);
            }
        }
    }
}
