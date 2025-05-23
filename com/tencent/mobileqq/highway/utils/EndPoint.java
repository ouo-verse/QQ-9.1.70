package com.tencent.mobileqq.highway.utils;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes9.dex */
public class EndPoint implements Cloneable {
    static IPatchRedirector $redirector_ = null;
    public static final int COMMON_IP = 0;
    public static final String KEY_OF_APN = "";
    public static final int PROXY_IP = 1;
    public int connIndex;
    public int connResult;
    public long cost;
    public int failCount;
    public String host;
    public int ipIndex;
    public boolean isSameIsp;
    public String keyOfAPN;
    public int port;
    public int protoType;
    public long timestamp;
    public int type;

    public EndPoint(String str, int i3) {
        this(str, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this, (Object) str, i3);
    }

    public boolean isPorxyIp() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        if (this.type == 1) {
            return true;
        }
        return false;
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            return (String) iPatchRedirector.redirect((short) 7, (Object) this);
        }
        return this.host + ":" + this.port + ",type:" + this.type + " failCount:" + this.failCount + " isSameIPC:" + this.isSameIsp + " keyOfAPN:" + this.keyOfAPN + " timestamp:" + this.timestamp;
    }

    public EndPoint(String str, int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Integer.valueOf(i16));
            return;
        }
        this.ipIndex = 0;
        this.connResult = -1;
        this.cost = -1L;
        this.failCount = 0;
        this.protoType = 1;
        this.isSameIsp = true;
        this.keyOfAPN = "";
        this.host = str;
        this.port = i3;
        this.type = i16;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public EndPoint m196clone() throws CloneNotSupportedException {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? (EndPoint) super.clone() : (EndPoint) iPatchRedirector.redirect((short) 5, (Object) this);
    }

    public EndPoint(String str, int i3, boolean z16) {
        this(str, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            this.isSameIsp = z16;
        } else {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Boolean.valueOf(z16));
        }
    }

    public EndPoint(String str, int i3, long j3) {
        this(str, i3, 0);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            this.timestamp = j3;
        } else {
            iPatchRedirector.redirect((short) 4, this, str, Integer.valueOf(i3), Long.valueOf(j3));
        }
    }
}
