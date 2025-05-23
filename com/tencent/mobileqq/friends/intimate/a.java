package com.tencent.mobileqq.friends.intimate;

import com.tencent.biz.ProtoUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import mqq.app.AppRuntime;
import tencent.im.oidb.oidb_0xcf3.oidb_0xcf3$ReqBody;

/* compiled from: P */
/* loaded from: classes12.dex */
public class a {
    static IPatchRedirector $redirector_;

    public static void a(AppRuntime appRuntime, long j3, int i3, ProtoUtils.TroopProtocolObserver troopProtocolObserver) {
        if (j3 > 0 && i3 > 0 && appRuntime != null) {
            oidb_0xcf3$ReqBody oidb_0xcf3_reqbody = new oidb_0xcf3$ReqBody();
            oidb_0xcf3_reqbody.sub_cmd.set(2);
            oidb_0xcf3_reqbody.target_uin.set(j3);
            oidb_0xcf3_reqbody.intimate_type.set(i3);
            ProtoUtils.a(appRuntime, troopProtocolObserver, oidb_0xcf3_reqbody.toByteArray(), "OidbSvc.0xcf3", 3315, 0);
        }
    }
}
