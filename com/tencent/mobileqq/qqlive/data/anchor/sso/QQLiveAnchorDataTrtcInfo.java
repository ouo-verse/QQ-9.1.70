package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataTrtcInfo {
    static IPatchRedirector $redirector_;
    public String businessInfo;
    public String sig;
    public QQLiveAnchorDataStreamInfo streamInfo;
    public long timeout;
    public String trtcStr;

    public QQLiveAnchorDataTrtcInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            this.streamInfo = new QQLiveAnchorDataStreamInfo();
        } else {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public QQLiveAnchorDataTrtcInfo(QQLiveAnchorDataTrtcInfo qQLiveAnchorDataTrtcInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataTrtcInfo);
            return;
        }
        this.streamInfo = new QQLiveAnchorDataStreamInfo();
        if (qQLiveAnchorDataTrtcInfo == null) {
            return;
        }
        this.sig = qQLiveAnchorDataTrtcInfo.sig;
        this.timeout = qQLiveAnchorDataTrtcInfo.timeout;
        this.businessInfo = qQLiveAnchorDataTrtcInfo.businessInfo;
        this.trtcStr = qQLiveAnchorDataTrtcInfo.trtcStr;
        this.streamInfo = new QQLiveAnchorDataStreamInfo(qQLiveAnchorDataTrtcInfo.streamInfo);
    }
}
