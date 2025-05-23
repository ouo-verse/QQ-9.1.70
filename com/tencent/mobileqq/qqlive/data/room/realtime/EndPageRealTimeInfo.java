package com.tencent.mobileqq.qqlive.data.room.realtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes17.dex */
public class EndPageRealTimeInfo {
    static IPatchRedirector $redirector_;
    public List<RealTimeData> items;
    public String logoURL;
    public String nickName;
    public String programID;
    public long roomID;

    public EndPageRealTimeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.items = new ArrayList();
        }
    }
}
