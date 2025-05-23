package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* loaded from: classes17.dex */
public class QQLiveAnchorDataPrepare extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public String popupDialogUrl;
    public QQLiveAnchorDataRoomAttr roomAttr;
    public QQLiveAnchorDataRoomInfo roomInfo;

    public QQLiveAnchorDataPrepare() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataPrepare(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataPrepare(QQLiveAnchorDataPrepare qQLiveAnchorDataPrepare) {
        super(qQLiveAnchorDataPrepare);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataPrepare);
        } else {
            if (qQLiveAnchorDataPrepare == null) {
                return;
            }
            this.roomAttr = new QQLiveAnchorDataRoomAttr(qQLiveAnchorDataPrepare.roomAttr);
            this.roomInfo = new QQLiveAnchorDataRoomInfo(qQLiveAnchorDataPrepare.roomInfo);
            this.popupDialogUrl = qQLiveAnchorDataPrepare.popupDialogUrl;
        }
    }
}
