package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataTLV {
    static IPatchRedirector $redirector_;
    public long longValue;
    public String strValue;
    public int tId;

    public QQLiveAnchorDataTLV() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataTLV(QQLiveAnchorDataTLV qQLiveAnchorDataTLV) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataTLV);
        } else {
            if (qQLiveAnchorDataTLV == null) {
                return;
            }
            this.tId = qQLiveAnchorDataTLV.tId;
            this.longValue = qQLiveAnchorDataTLV.longValue;
            this.strValue = qQLiveAnchorDataTLV.strValue;
        }
    }
}
