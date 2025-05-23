package com.tencent.mobileqq.qqlive.data.heart;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QLBroadCastFreeLove {
    static IPatchRedirector $redirector_;
    public ArrayList<FreeLove> freeLoves;
    public String headImg;
    public long roomId;
    public String roomMsg;
    public long uid;
    public String userNick;

    public QLBroadCastFreeLove() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "QLBroadCastFreeLove{roomId=" + this.roomId + ", uid=" + this.uid + ", userNick='" + this.userNick + "', headImg='" + this.headImg + "', roomMsg='" + this.roomMsg + "'}";
    }
}
