package com.tencent.could.component.common.ai.net;

import com.tencent.could.component.common.ai.eventreport.entry.NetWorkParam;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/* compiled from: P */
/* loaded from: classes5.dex */
public class HttpTask implements Runnable, Delayed {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    public String f99980a;

    /* renamed from: b, reason: collision with root package name */
    public IHttpRequest f99981b;

    /* renamed from: c, reason: collision with root package name */
    public int f99982c;

    /* renamed from: d, reason: collision with root package name */
    public long f99983d;

    /* renamed from: e, reason: collision with root package name */
    public boolean f99984e;

    public HttpTask(CallBackListener callBackListener, NetWorkParam netWorkParam) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) callBackListener, (Object) netWorkParam);
            return;
        }
        this.f99980a = "";
        this.f99982c = 0;
        this.f99984e = false;
        JsonHttpRequest jsonHttpRequest = new JsonHttpRequest();
        this.f99981b = jsonHttpRequest;
        jsonHttpRequest.setListener(callBackListener);
        this.f99981b.setNetWorkParam(netWorkParam);
        this.f99981b.setNeedUseDeputy(false);
        this.f99981b.setNeedIpBackUrl(false);
    }

    public void cleanRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 13)) {
            iPatchRedirector.redirect((short) 13, (Object) this);
            return;
        }
        this.f99984e = true;
        IHttpRequest iHttpRequest = this.f99981b;
        if (iHttpRequest != null) {
            iHttpRequest.cleanExecute();
        }
    }

    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return 0;
        }
        return ((Integer) iPatchRedirector.redirect((short) 9, (Object) this, (Object) delayed)).intValue();
    }

    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            return ((Long) iPatchRedirector.redirect((short) 11, (Object) this, (Object) timeUnit)).longValue();
        }
        return timeUnit.convert(getDelayTime() - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    public long getDelayTime() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            return ((Long) iPatchRedirector.redirect((short) 5, (Object) this)).longValue();
        }
        return this.f99983d;
    }

    public int getFailedNum() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, (Object) this)).intValue();
        }
        return this.f99982c;
    }

    public IHttpRequest getIHttpRequest() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (IHttpRequest) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return this.f99981b;
    }

    public NetWorkParam getRequestNetWorkParam() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 12)) {
            return (NetWorkParam) iPatchRedirector.redirect((short) 12, (Object) this);
        }
        return this.f99981b.getNetWorkParam();
    }

    public String getTaskError() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return this.f99980a;
    }

    @Override // java.lang.Runnable
    public void run() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            iPatchRedirector.redirect((short) 10, (Object) this);
            return;
        }
        try {
            this.f99981b.execute();
        } catch (Exception e16) {
            if (this.f99984e) {
                TxNetWorkHelper.getInstance().logDebug("HttpTask", "already stop , do not net retry");
                return;
            }
            this.f99980a = e16.getMessage();
            TxNetWorkHelper.getInstance().logDebug("HttpTask", "fail error: " + this.f99980a);
            if (this.f99982c == 1) {
                TxNetWorkHelper.getInstance().logDebug("HttpTask", "next try use deputy!");
                this.f99981b.setNeedUseDeputy(true);
            }
            if (this.f99982c == 2) {
                TxNetWorkHelper.getInstance().logDebug("HttpTask", "next try use back ip!");
                this.f99981b.setNeedIpBackUrl(true);
            }
            if (this.f99982c > 2) {
                TxNetWorkHelper.getInstance().logDebug("HttpTask", "next try use back ip array!");
                this.f99981b.setNeedIpBackUrls(true, this.f99982c - 3);
            }
            ThreadManager.getInstance().addFailedTask(this);
        }
    }

    public void setDelayTime(long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this, j3);
        } else {
            this.f99983d = j3 + System.currentTimeMillis();
        }
    }

    public void setFailedNum(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, i3);
        } else {
            this.f99982c = i3;
        }
    }

    public void setTaskError(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str);
        } else {
            this.f99980a = str;
        }
    }
}
