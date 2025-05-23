package com.tencent.mobileqq.qqlive.data.room;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes17.dex */
public class AdminListData {
    static IPatchRedirector $redirector_;
    public List<RoomAdminInfo> adminList;
    public boolean isEnd;

    public AdminListData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.adminList = new ArrayList();
            this.isEnd = true;
        }
    }
}
