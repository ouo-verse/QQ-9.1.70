package com.tencent.mobileqq.highway.netprobe;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.ref.WeakReference;

/* loaded from: classes9.dex */
public class ProbeTask {
    static IPatchRedirector $redirector_;

    /* renamed from: cb, reason: collision with root package name */
    public ProbeCallback f236835cb;
    WeakReference<WeakNetLearner> learner;
    public ProbeRequest req;
    public ProbeResponse resp;

    public ProbeTask(ProbeRequest probeRequest, ProbeCallback probeCallback) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) probeRequest, (Object) probeCallback);
            return;
        }
        this.req = probeRequest;
        this.f236835cb = probeCallback;
        this.resp = new ProbeResponse(probeRequest.trigglePoint, probeCallback);
    }

    public void collectResult() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        this.resp.success = true;
        for (ProbeItem probeItem = this.req.root; probeItem != null; probeItem = probeItem.getSuccessor()) {
            this.resp.mProbeItemResults.put(probeItem, probeItem.mResult);
            if (!probeItem.mResult.success) {
                ProbeResponse probeResponse = this.resp;
                probeResponse.success = false;
                probeResponse.errDesc = probeItem.getProbeName() + ":" + probeItem.mResult.errDesc;
                return;
            }
        }
    }

    public String getKey() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return (String) iPatchRedirector.redirect((short) 6, (Object) this);
        }
        return this.req.toString();
    }

    public void onTaskFinish() {
        ProbeResponse probeResponse;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        ProbeCallback probeCallback = this.f236835cb;
        if (probeCallback != null && (probeResponse = this.resp) != null) {
            probeCallback.onProbeFinish(probeResponse);
        }
        if (this.learner.get() != null) {
            this.learner.get().onTaskFinish(this);
        }
    }

    public void startProbe() {
        ProbeRequest probeRequest;
        ProbeItem probeItem;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            probeRequest = this.req;
            probeItem = probeRequest.root;
        } catch (Throwable th5) {
            th5.printStackTrace();
            ProbeResponse probeResponse = this.resp;
            probeResponse.success = false;
            probeResponse.errDesc = th5.toString();
        }
        if (probeItem != null) {
            probeItem.probe(probeRequest, this.f236835cb);
            collectResult();
            onTaskFinish();
            return;
        }
        throw new Exception("at lease one probe item need\uff01");
    }

    public ProbeTask(ProbeRequest probeRequest) {
        this(probeRequest, null);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) probeRequest);
    }
}
