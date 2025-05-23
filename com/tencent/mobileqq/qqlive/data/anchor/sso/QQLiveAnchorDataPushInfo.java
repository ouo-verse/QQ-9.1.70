package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* loaded from: classes17.dex */
public class QQLiveAnchorDataPushInfo extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public int expireTs;
    public String rtmpUrl;
    public String serverPart;
    public String streamParam;

    public QQLiveAnchorDataPushInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "QQLiveAnchorDataGetPush{\nrtmpUrl='" + this.rtmpUrl + "'\n, serverPart='" + this.serverPart + "'\n, streamParam='" + this.streamParam + "'\n, expireTs=" + this.expireTs + "\n, isSuccess=" + this.isSuccess + "\n, errorMsg='" + this.errorMsg + "'\n}";
    }

    public QQLiveAnchorDataPushInfo(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataPushInfo(QQLiveAnchorDataPushInfo qQLiveAnchorDataPushInfo) {
        super(qQLiveAnchorDataPushInfo);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataPushInfo);
        } else {
            if (qQLiveAnchorDataPushInfo == null) {
                return;
            }
            this.rtmpUrl = qQLiveAnchorDataPushInfo.rtmpUrl;
            this.serverPart = qQLiveAnchorDataPushInfo.serverPart;
            this.streamParam = qQLiveAnchorDataPushInfo.streamParam;
            this.expireTs = qQLiveAnchorDataPushInfo.expireTs;
        }
    }
}
