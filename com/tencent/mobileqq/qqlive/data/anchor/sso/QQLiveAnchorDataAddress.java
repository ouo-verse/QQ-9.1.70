package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataAddress {
    static IPatchRedirector $redirector_;
    public int bitrate;
    public String format;
    public String url;

    public QQLiveAnchorDataAddress() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataAddress(QQLiveAnchorDataAddress qQLiveAnchorDataAddress) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataAddress);
        } else {
            if (qQLiveAnchorDataAddress == null) {
                return;
            }
            this.url = qQLiveAnchorDataAddress.url;
            this.bitrate = qQLiveAnchorDataAddress.bitrate;
            this.format = qQLiveAnchorDataAddress.format;
        }
    }
}
