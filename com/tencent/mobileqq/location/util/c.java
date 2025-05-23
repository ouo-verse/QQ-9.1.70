package com.tencent.mobileqq.location.util;

import com.tencent.mobileqq.location.data.LocationRoom;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes15.dex */
public class c {
    static IPatchRedirector $redirector_;

    public static int a(LocationRoom.b bVar) {
        LocationRoom J2;
        if (bVar == null || (J2 = LocationHandler.K2().J2(bVar)) == null) {
            return 0;
        }
        if (J2.l() == null) {
            return 1;
        }
        if (J2.i() == -1) {
            return 2;
        }
        if (J2.i() == -1) {
            return 0;
        }
        return 3;
    }
}
