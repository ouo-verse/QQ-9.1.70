package ge1;

import com.tencent.imcore.message.adder.i;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.qa.api.IQQGameQARobotTemp;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.qroute.QRoute;
import mqq.app.AppRuntime;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a implements i {
    @Override // com.tencent.imcore.message.adder.i
    public boolean[] a(AppRuntime appRuntime, IMessageFacade iMessageFacade, MessageRecord messageRecord, EntityManager entityManager, RecentUserProxy recentUserProxy, String str, int i3, boolean z16, int i16) {
        ((IQQGameQARobotTemp) QRoute.api(IQQGameQARobotTemp.class)).reportMessageReach(messageRecord);
        return new boolean[]{z16, false};
    }
}
