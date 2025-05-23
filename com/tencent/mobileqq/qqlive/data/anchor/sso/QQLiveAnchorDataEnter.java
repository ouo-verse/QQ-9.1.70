package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataEnter extends QQLiveAnchorDataBase {
    static IPatchRedirector $redirector_;
    public QQLiveAnchorDataConfigInfo configInfo;
    public QQLiveAnchorDataMediaInfo mediaInfo;
    public QQLiveAnchorDataRoomInfo roomInfo;
    public QQLiveAnchorDataTrtcInfo trtcInfo;
    public QQLiveAnchorDataUserInfo userInfo;

    public QQLiveAnchorDataEnter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataEnter(boolean z16, QQLiveErrorMsg qQLiveErrorMsg) {
        super(z16, qQLiveErrorMsg);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, this, Boolean.valueOf(z16), qQLiveErrorMsg);
    }

    public QQLiveAnchorDataEnter(QQLiveAnchorDataEnter qQLiveAnchorDataEnter) {
        super(qQLiveAnchorDataEnter);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) qQLiveAnchorDataEnter);
        } else {
            if (qQLiveAnchorDataEnter == null) {
                return;
            }
            this.roomInfo = new QQLiveAnchorDataRoomInfo(qQLiveAnchorDataEnter.roomInfo);
            this.userInfo = new QQLiveAnchorDataUserInfo(qQLiveAnchorDataEnter.userInfo);
            this.mediaInfo = new QQLiveAnchorDataMediaInfo(qQLiveAnchorDataEnter.mediaInfo);
            this.trtcInfo = new QQLiveAnchorDataTrtcInfo(qQLiveAnchorDataEnter.trtcInfo);
        }
    }
}
