package com.tencent.mobileqq.troopAddFrd.strategy;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.relationx.batchAdd.d;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static a a(int i3) {
        d.f280711a.a();
        if (i3 != 1) {
            if (i3 != 4) {
                return null;
            }
            return new TroopAddFriendTipsNewComerStrategy();
        }
        return new b();
    }
}
