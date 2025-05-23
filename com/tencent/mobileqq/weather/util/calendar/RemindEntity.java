package com.tencent.mobileqq.weather.util.calendar;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes20.dex */
public class RemindEntity extends Entity {
    static IPatchRedirector $redirector_ = null;
    public static final String TAG = "RemindEntity";
    public String jumpUrl;

    @unique
    public long remindTime;
    public String title;

    public RemindEntity() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public RemindEntity(long j3, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Long.valueOf(j3), str, str2);
            return;
        }
        this.remindTime = j3;
        this.title = str;
        this.jumpUrl = str2;
    }
}
