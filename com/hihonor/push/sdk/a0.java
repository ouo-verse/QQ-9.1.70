package com.hihonor.push.sdk;

import com.hihonor.push.sdk.common.data.ApiException;
import com.hihonor.push.sdk.common.data.UpMsgType;

/* compiled from: P */
/* loaded from: classes2.dex */
public class a0 {
    public Void a(boolean z16) throws ApiException {
        String str;
        try {
            if (z16) {
                str = UpMsgType.TURN_ON_PUSH;
            } else {
                str = UpMsgType.TURN_OFF_PUSH;
            }
            g1 g1Var = new g1(str, null);
            g1Var.f36383e = b.a();
            b.a(z.f36460c.a(g1Var));
            return null;
        } catch (Exception e16) {
            throw b.a(e16);
        }
    }
}
