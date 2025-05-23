package com.tencent.mars.mm;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes9.dex */
public class ConnectRecord implements Serializable {
    static IPatchRedirector $redirector_;
    public long beginTimestampMs;
    public int bizType;
    public boolean connectSucceed;
    public int costMs;
    public int netType;
    public int protoType;

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class BizType {
        static IPatchRedirector $redirector_ = null;
        public static final int CDN = 1;
        public static final int CGI = 0;

        public BizType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    /* compiled from: P */
    /* loaded from: classes9.dex */
    public static class ProtoType {
        static IPatchRedirector $redirector_ = null;
        public static final int QUIC = 1;
        public static final int TCP = 0;

        public ProtoType() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
            }
        }
    }

    public ConnectRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.bizType = 0;
        this.protoType = 0;
        this.connectSucceed = false;
        this.beginTimestampMs = 0L;
        this.costMs = 0;
        this.netType = 0;
    }
}
