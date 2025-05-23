package com.tencent.mobileqq.qqlive.listener.trtc;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.trtc.QQLiveQuality;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public final /* synthetic */ class a {
    public static void a(ITRTCRemoteListener iTRTCRemoteListener, String str, int i3, String str2) {
        IPatchRedirector iPatchRedirector = ITRTCRemoteListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, iTRTCRemoteListener, str, Integer.valueOf(i3), str2);
        }
    }

    public static void b(ITRTCRemoteListener iTRTCRemoteListener, int i3, String str) {
        IPatchRedirector iPatchRedirector = ITRTCRemoteListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) iTRTCRemoteListener, i3, (Object) str);
        }
    }

    public static void c(ITRTCRemoteListener iTRTCRemoteListener, String str) {
        IPatchRedirector iPatchRedirector = ITRTCRemoteListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) iTRTCRemoteListener, (Object) str);
        }
    }

    public static void d(ITRTCRemoteListener iTRTCRemoteListener, String str, int i3, int i16, int i17) {
        IPatchRedirector iPatchRedirector = ITRTCRemoteListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, iTRTCRemoteListener, str, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17));
        }
    }

    public static void e(ITRTCRemoteListener iTRTCRemoteListener, QQLiveQuality qQLiveQuality, ArrayList arrayList) {
        IPatchRedirector iPatchRedirector = ITRTCRemoteListener.$redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) iTRTCRemoteListener, (Object) qQLiveQuality, (Object) arrayList);
        }
    }
}
