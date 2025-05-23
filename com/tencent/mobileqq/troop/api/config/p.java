package com.tencent.mobileqq.troop.api.config;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;
import tencent.im.s2c.msgtype0x210.submsgtype0x26.submsgtype0x26$MsgBody;

/* compiled from: P */
/* loaded from: classes19.dex */
public class p {
    static IPatchRedirector $redirector_;

    public p() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(@NonNull AppInterface appInterface, @NonNull String str, @NonNull String str2, @NonNull TroopInfo troopInfo, @NonNull ArrayList<String> arrayList) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, appInterface, str, str2, troopInfo, arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(@NonNull AppInterface appInterface, @NonNull String str, @NonNull String str2, TroopInfo troopInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, this, appInterface, str, str2, troopInfo);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(String str, List<String> list, List<String> list2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, str, list, list2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void d(@NonNull AppInterface appInterface, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) appInterface, (Object) str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void e(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar, submsgtype0x26$MsgBody.SubCmd0x1UpdateAppUnreadNum subCmd0x1UpdateAppUnreadNum, long[] jArr, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, this, appInterface, aVar, subCmd0x1UpdateAppUnreadNum, jArr, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void f(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.unreadmsg.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) appInterface, (Object) aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void g(@NonNull AppInterface appInterface, com.tencent.mobileqq.troop.entereffect.f fVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) appInterface, (Object) fVar);
        }
    }
}
