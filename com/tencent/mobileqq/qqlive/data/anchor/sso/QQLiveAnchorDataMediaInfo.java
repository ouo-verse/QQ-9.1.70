package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.Arrays;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataMediaInfo {
    static IPatchRedirector $redirector_;
    public String serverPat;
    public byte[] sig;
    public String streamParam;
    public long timeout;
    public long type;

    public QQLiveAnchorDataMediaInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataMediaInfo(QQLiveAnchorDataMediaInfo qQLiveAnchorDataMediaInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataMediaInfo);
            return;
        }
        if (qQLiveAnchorDataMediaInfo == null) {
            return;
        }
        if (this.sig != null) {
            byte[] bArr = qQLiveAnchorDataMediaInfo.sig;
            this.sig = Arrays.copyOf(bArr, bArr.length);
        }
        this.timeout = qQLiveAnchorDataMediaInfo.timeout;
        this.type = qQLiveAnchorDataMediaInfo.type;
        this.serverPat = qQLiveAnchorDataMediaInfo.serverPat;
        this.streamParam = qQLiveAnchorDataMediaInfo.streamParam;
    }
}
