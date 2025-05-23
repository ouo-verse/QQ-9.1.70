package fg4;

import android.text.TextUtils;
import com.tencent.timi.game.utils.l;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoReq;
import trpc.yes.common.UserProxyCmdOuterClass$GetTgpaVersionInfoRsp;

/* compiled from: P */
/* loaded from: classes26.dex */
public class j extends pl4.a {
    private static NewIntent d(String str, int i3, boolean z16) {
        UserProxyCmdOuterClass$GetTgpaVersionInfoReq userProxyCmdOuterClass$GetTgpaVersionInfoReq = new UserProxyCmdOuterClass$GetTgpaVersionInfoReq();
        userProxyCmdOuterClass$GetTgpaVersionInfoReq.xid.set(str);
        userProxyCmdOuterClass$GetTgpaVersionInfoReq.game_id.set(i3);
        userProxyCmdOuterClass$GetTgpaVersionInfoReq.has_update.set(z16);
        return a.C11028a.a(userProxyCmdOuterClass$GetTgpaVersionInfoReq, j.class);
    }

    public static void e(String str, int i3, boolean z16, pl4.d<UserProxyCmdOuterClass$GetTgpaVersionInfoRsp> dVar) {
        l.h("NetCore_BaseTimiGameServlet_", 1, "GetTgpaGameVersionServlet- " + i3 + " - " + z16 + " - " + str);
        if (!TextUtils.isEmpty(str) && i3 > 0) {
            ((pl4.c) mm4.b.b(pl4.c.class)).F1(d(str, i3, z16), UserProxyCmdOuterClass$GetTgpaVersionInfoRsp.class, dVar);
        } else if (dVar != null) {
            dVar.b(true, 0, -1000, 0, "", "\u53c2\u6570\u5f02\u5e38", null, null);
        }
    }

    @Override // pl4.a
    protected int b() {
        return 106;
    }
}
