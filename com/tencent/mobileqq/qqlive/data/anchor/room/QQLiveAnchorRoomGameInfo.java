package com.tencent.mobileqq.qqlive.data.anchor.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAnchorRoomGameInfo {
    static IPatchRedirector $redirector_;
    public String icon;

    /* renamed from: id, reason: collision with root package name */
    public int f271211id;
    public String name;
    public int secondTagId;

    public QQLiveAnchorRoomGameInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.f271211id = 0;
        this.name = "";
        this.icon = "";
        this.secondTagId = 0;
    }

    public QQLiveAnchorRoomGameInfo(QQLiveAnchorRoomGameInfo qQLiveAnchorRoomGameInfo) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) qQLiveAnchorRoomGameInfo);
            return;
        }
        this.f271211id = 0;
        this.name = "";
        this.icon = "";
        this.secondTagId = 0;
        if (qQLiveAnchorRoomGameInfo == null) {
            return;
        }
        this.f271211id = qQLiveAnchorRoomGameInfo.f271211id;
        this.name = qQLiveAnchorRoomGameInfo.name;
        this.icon = qQLiveAnchorRoomGameInfo.icon;
        this.secondTagId = qQLiveAnchorRoomGameInfo.secondTagId;
    }
}
