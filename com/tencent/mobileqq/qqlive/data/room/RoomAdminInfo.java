package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class RoomAdminInfo {
    static IPatchRedirector $redirector_;
    public String headUrl;
    public boolean isAdminInRoom;
    public boolean isPlatformAdmin;
    public boolean isRoomAdmin;
    public String nickname;
    public int sex;
    public String sign;
    public long uid;

    public RoomAdminInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
            return;
        }
        this.sex = 1;
        this.isAdminInRoom = false;
        this.isRoomAdmin = false;
        this.isPlatformAdmin = false;
    }
}
