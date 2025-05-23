package jm4;

import com.tencent.mobileqq.pb.MessageMicro;
import mqq.app.NewIntent;
import pl4.a;
import trpc.yes.common.UserProxyCmdOuterClass$GetUserRouteInfoReq;

/* compiled from: P */
/* loaded from: classes26.dex */
public class e extends pl4.a {
    public static NewIntent d(long j3) {
        return a.C11028a.a(new MessageMicro<UserProxyCmdOuterClass$GetUserRouteInfoReq>() { // from class: trpc.yes.common.UserProxyCmdOuterClass$GetUserRouteInfoReq
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UserProxyCmdOuterClass$GetUserRouteInfoReq.class);
        }, e.class);
    }

    @Override // pl4.a
    protected int b() {
        return 104;
    }
}
