package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataRichTitleElement {
    static IPatchRedirector $redirector_;
    public String text;
    public int type;
    public String url;

    public QQLiveAnchorDataRichTitleElement() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataRichTitleElement(QQLiveAnchorDataRichTitleElement qQLiveAnchorDataRichTitleElement) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataRichTitleElement);
        } else {
            if (qQLiveAnchorDataRichTitleElement == null) {
                return;
            }
            this.type = qQLiveAnchorDataRichTitleElement.type;
            this.text = qQLiveAnchorDataRichTitleElement.text;
            this.url = qQLiveAnchorDataRichTitleElement.url;
        }
    }
}
