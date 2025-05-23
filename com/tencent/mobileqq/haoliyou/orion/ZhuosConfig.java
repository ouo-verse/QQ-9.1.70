package com.tencent.mobileqq.haoliyou.orion;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import java.util.Date;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: P */
/* loaded from: classes7.dex */
public class ZhuosConfig {
    static IPatchRedirector $redirector_;
    static ZhuosConfig EMPTY_CONFIG;
    final Date endTime;
    final boolean needBlock;
    final Date startTime;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(42476);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            EMPTY_CONFIG = new ZhuosConfig(false, new Date(0L), new Date(0L));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ZhuosConfig(boolean z16, @NonNull Date date, @NonNull Date date2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Boolean.valueOf(z16), date, date2);
            return;
        }
        this.needBlock = z16;
        this.startTime = date;
        this.endTime = date2;
    }

    private boolean timeValid() {
        long serverTime = NetConnInfoCenter.getServerTime() * 1000;
        if (this.startTime.getTime() <= serverTime && this.endTime.getTime() >= serverTime) {
            return true;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean needBlock() {
        if (timeValid() && this.needBlock) {
            return true;
        }
        return false;
    }
}
