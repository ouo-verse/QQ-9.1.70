package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes9.dex */
public class ProbeResponse {
    static IPatchRedirector $redirector_;

    /* renamed from: cb, reason: collision with root package name */
    public ProbeCallback f236834cb;
    public String errDesc;
    public HashMap<ProbeItem, ProbeItem.ProbeResult> mProbeItemResults;
    public long startTime;
    public boolean success;
    public int triggePoint;

    public ProbeResponse(int i3, ProbeCallback probeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, i3, (Object) probeCallback);
            return;
        }
        this.startTime = System.currentTimeMillis();
        this.f236834cb = probeCallback;
        this.success = false;
        this.errDesc = "";
        this.triggePoint = i3;
        this.mProbeItemResults = new HashMap<>();
    }

    public String getResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        String str = "---ProbeTask Strat " + new Timestamp(this.startTime).toString() + " from " + this.triggePoint + "---\n";
        Iterator<ProbeItem> it = this.mProbeItemResults.keySet().iterator();
        while (it.hasNext()) {
            str = str + this.mProbeItemResults.get(it.next()).getRdmReportMsg();
        }
        return str + "----ProbeTask End----\n";
    }
}
