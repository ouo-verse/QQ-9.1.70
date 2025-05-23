package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.data.anchor.camera.QQLiveAnchorStreamRecordType;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorRecord {
    static IPatchRedirector $redirector_;
    public long enterRoomTime;
    public long lastHeartTime;
    public String programId;
    public long recordTime;
    public QQLiveAnchorRoomConfig roomConfig;
    public long roomId;
    public QQLiveAnchorRoomInfo roomInfo;
    public QQLiveAnchorStreamRecordType streamType;
    public long uid;

    public QQLiveAnchorRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }
}
