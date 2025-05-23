package bn4;

import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.UserProxyCmdOuterClass$ShareArkToGuildReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class f extends pl4.a {
    public static NewIntent d(long j3, long j16, int i3, String str) {
        UserProxyCmdOuterClass$ShareArkToGuildReq userProxyCmdOuterClass$ShareArkToGuildReq = new UserProxyCmdOuterClass$ShareArkToGuildReq();
        userProxyCmdOuterClass$ShareArkToGuildReq.guild_id.set(j3);
        userProxyCmdOuterClass$ShareArkToGuildReq.channel_id.set(j16);
        userProxyCmdOuterClass$ShareArkToGuildReq.game_id.set(i3);
        userProxyCmdOuterClass$ShareArkToGuildReq.meta.set(str);
        return a.C11028a.a(userProxyCmdOuterClass$ShareArkToGuildReq, f.class);
    }

    @Override // pl4.a
    protected int b() {
        return 1211;
    }
}
