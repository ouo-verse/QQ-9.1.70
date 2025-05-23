package com.tencent.mobileqq.qqlive.data.room;

import android.os.Bundle;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class LiveRoomInfo implements BaseRoomInfo {
    static IPatchRedirector $redirector_;
    public String enterRoomSystemNotice;
    public Bundle extData;
    public int giftFlag;
    public int goodsFlag;
    public long ownerId;
    public String programId;
    public long roomId;
    public String roomLogo;
    public String roomName;
    public int roomType;
    public List<RoomTag> tags;

    public LiveRoomInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.tags = new ArrayList();
            this.extData = new Bundle();
        }
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public String getProgramId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return this.programId;
    }

    @Override // com.tencent.mobileqq.qqlive.data.room.BaseRoomInfo
    public long getRoomId() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Long) iPatchRedirector.redirect((short) 2, (Object) this)).longValue();
        }
        return this.roomId;
    }
}
