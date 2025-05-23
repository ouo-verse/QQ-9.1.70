package com.tencent.mobileqq.reminder.data;

import com.google.gson.annotations.SerializedName;
import com.tencent.freesia.IConfigData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes18.dex */
public class a implements IConfigData {
    static IPatchRedirector $redirector_;

    @SerializedName("game_center_reminder_interval")
    public int mRequestIntervalInSec;

    public a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        } else {
            this.mRequestIntervalInSec = 300;
        }
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return "ReminderConfigBean{mRequestIntervalInSec=" + this.mRequestIntervalInSec + '}';
    }
}
