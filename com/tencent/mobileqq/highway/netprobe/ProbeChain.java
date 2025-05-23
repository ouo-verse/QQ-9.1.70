package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.highway.netprobe.ProbeItem;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;

/* loaded from: classes9.dex */
public class ProbeChain extends ProbeItem {
    static IPatchRedirector $redirector_ = null;
    public static final String PROBE_NAME = "ProbeChain";
    public ArrayList<ProbeItem> chain;

    /* loaded from: classes9.dex */
    public static class ProbeChainResult extends ProbeItem.ProbeResult {
        static IPatchRedirector $redirector_;
        public ArrayList<ProbeItem.ProbeResult> subResults;

        public ProbeChainResult(String str, ProbeCallback probeCallback) {
            super(str, probeCallback);
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) probeCallback);
            } else {
                this.subResults = new ArrayList<>();
            }
        }

        @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem.ProbeResult
        public String getRdmReportMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (String) iPatchRedirector.redirect((short) 2, (Object) this);
            }
            String str = "<" + this.probeName + " start >";
            String str2 = "<" + this.probeName + " end >";
            int size = this.subResults.size();
            for (int i3 = 0; i3 < size; i3++) {
                str = str + this.subResults.get(i3).getRdmReportMsg();
            }
            return str + str2;
        }
    }

    public ProbeChain(ProbeItem[] probeItemArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) probeItemArr);
        } else {
            this.chain = new ArrayList<>();
            addProbeItems(probeItemArr);
        }
    }

    public static ProbeChain getDefaultProbeChain() {
        ProbeChain probeChain = new ProbeChain();
        probeChain.addProbeItem(new LoginWifiProbe());
        probeChain.addProbeItem(new MtuProbe());
        probeChain.addProbeItem(new DefaultProbe());
        return probeChain;
    }

    public ProbeChain addProbeItem(ProbeItem probeItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (ProbeChain) iPatchRedirector.redirect((short) 7, (Object) this, (Object) probeItem);
        }
        if (probeItem != null) {
            this.chain.add(probeItem);
        }
        return this;
    }

    public ProbeChain addProbeItems(ProbeItem[] probeItemArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (ProbeChain) iPatchRedirector.redirect((short) 8, (Object) this, (Object) probeItemArr);
        }
        if (probeItemArr != null && probeItemArr.length > 0) {
            for (ProbeItem probeItem : probeItemArr) {
                this.chain.add(probeItem);
            }
        }
        return this;
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public void doProbe() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        if (this.chain.isEmpty()) {
            ProbeItem.ProbeResult probeResult = this.mResult;
            probeResult.success = false;
            probeResult.errDesc = "at lease one probe item need!";
        } else {
            if (this.chain.size() > 1) {
                initProbeSequence();
            }
            ProbeItem probeItem = this.chain.get(0);
            if (probeItem != null) {
                probeItem.probe(this.mRequest, this.f236831cb);
            }
            onSubItemsFinish();
        }
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public String getProbeName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (String) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return PROBE_NAME;
    }

    @Override // com.tencent.mobileqq.highway.netprobe.ProbeItem
    public ProbeItem.ProbeResult getProbeResult(ProbeRequest probeRequest, ProbeCallback probeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 9)) {
            return (ProbeItem.ProbeResult) iPatchRedirector.redirect((short) 9, (Object) this, (Object) probeRequest, (Object) probeCallback);
        }
        return new ProbeChainResult(getProbeName(), probeCallback);
    }

    public void initProbeSequence() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        Collections.sort(this.chain);
        int size = this.chain.size();
        for (int i3 = 1; i3 < size; i3++) {
            this.chain.get(i3 - 1).setSuccessor(this.chain.get(i3));
        }
    }

    public void onSubItemsFinish() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
            return;
        }
        ProbeItem.ProbeResult probeResult = this.mResult;
        ProbeChainResult probeChainResult = (ProbeChainResult) probeResult;
        probeResult.success = true;
        int size = this.chain.size();
        for (int i3 = 0; i3 < size; i3++) {
            ProbeItem probeItem = this.chain.get(i3);
            probeChainResult.subResults.add(probeItem.mResult);
            if (!probeItem.mResult.success) {
                ProbeItem.ProbeResult probeResult2 = this.mResult;
                probeResult2.success = false;
                probeResult2.errDesc = probeItem.getProbeName() + ":" + probeItem.mResult.errDesc;
                return;
            }
        }
    }

    public ProbeChain() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            this.chain = new ArrayList<>();
        } else {
            iPatchRedirector.redirect((short) 2, (Object) this);
        }
    }

    public ProbeChain(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, i3);
        } else {
            this.chain = new ArrayList<>();
            this.priority = i3;
        }
    }
}
