package com.tencent.mobileqq.qqlive.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqlive.sail.model.common.RoomCoverInfo;
import java.io.Serializable;

/* compiled from: P */
/* loaded from: classes17.dex */
public class CoverInfo implements Serializable {
    static IPatchRedirector $redirector_;
    public boolean edit;
    public String roomLogo;
    public String roomLogo16v9;
    public String roomLogo3v4;
    public long roomLogoTime;
    public long roomLogoTime16v9;
    public long roomLogoTime3v4;

    public CoverInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.edit = false;
        this.roomLogo = "";
        this.roomLogo16v9 = "";
        this.roomLogo3v4 = "";
    }

    public RoomCoverInfo toRoomCoverInfo(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (RoomCoverInfo) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str);
        }
        return new RoomCoverInfo(1, this.roomLogo16v9, this.roomLogoTime16v9, str, this.roomLogoTime, this.roomLogo3v4, this.roomLogoTime3v4);
    }
}
