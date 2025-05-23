package com.tencent.could.huiyansdk.operate;

import com.google.gson.annotations.SerializedName;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.List;

/* compiled from: P */
/* loaded from: classes5.dex */
public abstract class CloudOperateBody {
    static IPatchRedirector $redirector_;

    @SerializedName("Actions")
    public List<CloudOperateItem> actions;

    public CloudOperateBody() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.actions = new ArrayList();
            initDate();
        }
    }

    public abstract void initDate();

    public abstract void reset();

    public void updateInfo(String str, int i3, long j3, long j16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            updateInfo(str, i3, j3, j16, "");
        } else {
            iPatchRedirector.redirect((short) 2, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16));
        }
    }

    public void updateInfo(String str, int i3, long j3, long j16, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, this, str, Integer.valueOf(i3), Long.valueOf(j3), Long.valueOf(j16), str2);
            return;
        }
        for (CloudOperateItem cloudOperateItem : this.actions) {
            if (cloudOperateItem.getAction().equals(str)) {
                cloudOperateItem.updateInfo(i3, j3, j16);
                cloudOperateItem.setInfo(str2);
            }
        }
    }
}
