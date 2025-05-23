package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorDataStreamInfo {
    static IPatchRedirector $redirector_;
    public String auxStreamId;
    public boolean isSelfInfo;
    public String mainStreamId;
    public long originRoomId;
    public long originUid;
    public long roomId;
    public long uid;

    public QQLiveAnchorDataStreamInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public QQLiveAnchorDataStreamInfo(QQLiveAnchorDataStreamInfo qQLiveAnchorDataStreamInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorDataStreamInfo);
            return;
        }
        if (qQLiveAnchorDataStreamInfo == null) {
            return;
        }
        this.uid = qQLiveAnchorDataStreamInfo.uid;
        this.roomId = qQLiveAnchorDataStreamInfo.roomId;
        this.mainStreamId = qQLiveAnchorDataStreamInfo.mainStreamId;
        this.auxStreamId = qQLiveAnchorDataStreamInfo.auxStreamId;
        this.isSelfInfo = qQLiveAnchorDataStreamInfo.isSelfInfo;
        this.originUid = qQLiveAnchorDataStreamInfo.originUid;
        this.originRoomId = qQLiveAnchorDataStreamInfo.originRoomId;
    }
}
