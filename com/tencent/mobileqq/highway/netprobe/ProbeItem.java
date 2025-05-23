package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public abstract class ProbeItem implements Comparable<ProbeItem> {
    static IPatchRedirector $redirector_;

    /* renamed from: cb, reason: collision with root package name */
    public ProbeCallback f236831cb;
    protected ProbeRequest mRequest;
    public ProbeResult mResult;
    int priority;
    protected ProbeItem successor;

    /* loaded from: classes9.dex */
    public static class ProbeResult {
        static IPatchRedirector $redirector_;

        /* renamed from: cb, reason: collision with root package name */
        public ProbeCallback f236832cb;
        public int errCode;
        public String errDesc;
        public Object extra;
        public String probeName;
        protected StringBuilder result;
        public boolean success;

        public ProbeResult(String str, ProbeCallback probeCallback) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, (Object) probeCallback);
                return;
            }
            this.success = false;
            this.result = new StringBuilder();
            this.f236832cb = probeCallback;
            this.probeName = str;
            this.errCode = 0;
        }

        public ProbeResult appendResult(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                return (ProbeResult) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
            }
            this.result.append(str);
            ProbeCallback probeCallback = this.f236832cb;
            if (probeCallback != null) {
                probeCallback.onProbeProgress(str);
            }
            return this;
        }

        public String getRdmReportMsg() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                return (String) iPatchRedirector.redirect((short) 3, (Object) this);
            }
            return ("<" + this.probeName + " start>") + "succ:" + this.success + ",result:" + this.result.toString() + ",errDesc:" + this.errDesc + ("<" + this.probeName + " end>");
        }

        public String getResult() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                return (String) iPatchRedirector.redirect((short) 4, (Object) this);
            }
            return this.result.toString();
        }
    }

    public ProbeItem() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.priority = 5;
            this.successor = null;
        }
    }

    public abstract void doProbe();

    public abstract String getProbeName();

    public ProbeResult getProbeResult(ProbeRequest probeRequest, ProbeCallback probeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProbeResult) iPatchRedirector.redirect((short) 4, (Object) this, (Object) probeRequest, (Object) probeCallback);
        }
        return new ProbeResult(getProbeName(), probeCallback);
    }

    public ProbeItem getSuccessor() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (ProbeItem) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.successor;
    }

    public void probe(ProbeRequest probeRequest, ProbeCallback probeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) probeRequest, (Object) probeCallback);
            return;
        }
        this.mRequest = probeRequest;
        this.f236831cb = probeCallback;
        this.mResult = getProbeResult(probeRequest, probeCallback);
        doProbe();
        transferReqToNext(this.mResult.success);
    }

    public void setSuccessor(ProbeItem probeItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) probeItem);
        } else {
            this.successor = probeItem;
        }
    }

    public void transferReqToNext(boolean z16) {
        ProbeItem probeItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, z16);
        } else if (z16 && (probeItem = this.successor) != null) {
            probeItem.probe(this.mRequest, this.f236831cb);
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(ProbeItem probeItem) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.priority - probeItem.priority : ((Integer) iPatchRedirector.redirect((short) 5, (Object) this, (Object) probeItem)).intValue();
    }

    public ProbeItem(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.successor = null;
            this.priority = i3;
        }
    }
}
