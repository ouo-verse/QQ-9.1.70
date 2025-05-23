package com.tencent.mobileqq.qqlive.data.room.realtime;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveRealTimeInfo {
    static IPatchRedirector $redirector_;
    public long anchorId;
    public List<RealTimeData> items;
    public byte[] programId;
    public long roomId;

    public LiveRealTimeInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.items = new ArrayList();
        }
    }
}
