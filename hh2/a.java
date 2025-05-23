package hh2;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.qqgamepub.api.IGamePubAccountMsgService;
import com.tencent.mobileqq.qqgamepub.data.QQGameMsgInfo;
import com.tencent.mobileqq.qqgamepub.data.c;
import com.tencent.mobileqq.qqgamepub.nt.api.IQQGamePubMsgApi;
import com.tencent.mobileqq.qroute.QRoute;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import mqq.app.MobileQQ;

/* compiled from: P */
/* loaded from: classes16.dex */
public class a implements Observer {
    public void a(ArrayList<QQGameMsgInfo> arrayList) {
        if (!(MobileQQ.sMobileQQ.waitAppRuntime(null) instanceof BaseQQAppInterface)) {
            return;
        }
        ((IQQGamePubMsgApi) QRoute.api(IQQGamePubMsgApi.class)).setMsgRead();
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        Object obj2;
        if (!(observable instanceof IGamePubAccountMsgService)) {
            return;
        }
        try {
            if (obj instanceof c) {
                c cVar = (c) obj;
                if ("action_qgame_tool_messgae".equals(cVar.f264502a) && (obj2 = cVar.f264503b) != null) {
                    a((ArrayList) obj2);
                }
            }
        } catch (Throwable th5) {
            th5.printStackTrace();
        }
    }
}
