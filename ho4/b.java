package ho4;

import java.util.List;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.UserProxyCmdOuterClass$BatchGetUidByTinyIdReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b extends pl4.a {
    public static NewIntent d(List<Long> list) {
        UserProxyCmdOuterClass$BatchGetUidByTinyIdReq userProxyCmdOuterClass$BatchGetUidByTinyIdReq = new UserProxyCmdOuterClass$BatchGetUidByTinyIdReq();
        userProxyCmdOuterClass$BatchGetUidByTinyIdReq.tiny_id_list.set(list);
        return a.C11028a.a(userProxyCmdOuterClass$BatchGetUidByTinyIdReq, b.class);
    }

    @Override // pl4.a
    protected int b() {
        return 112;
    }
}
