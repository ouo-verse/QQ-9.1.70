package com.tencent.gcloud.netinterface;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes6.dex */
public class EventMsg {
    static IPatchRedirector $redirector_ = null;
    public static final int CMD_BIND = 2;
    public static final int CMD_INIT_CM = 255;
    public static final int CMD_WARM = 1;
    public int arg1;
    public int arg2;
    public int cmd;
    public byte[] data;
    public String strarg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public EventMsg(int i3, int i16, int i17, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Integer.valueOf(i16), Integer.valueOf(i17), str);
            return;
        }
        this.cmd = i3;
        this.arg1 = i16;
        this.arg2 = i17;
        this.strarg = str;
    }
}
