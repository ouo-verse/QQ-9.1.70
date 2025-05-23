package com.tencent.mobileqq.troop.api.config;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.troop.announcement.api.ITroopAnnouncementHelperApi;
import java.io.DataInputStream;

/* compiled from: P */
/* loaded from: classes19.dex */
public class c {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(AppInterface appInterface, long j3, long j16, int i3, ITroopAnnouncementHelperApi.a aVar, String str, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), aVar, str, Boolean.valueOf(z16));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(AppInterface appInterface, long j3, long j16, int i3, String str, int i16, boolean z16, DataInputStream dataInputStream) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, appInterface, Long.valueOf(j3), Long.valueOf(j16), Integer.valueOf(i3), str, Integer.valueOf(i16), Boolean.valueOf(z16), dataInputStream);
        }
    }
}
