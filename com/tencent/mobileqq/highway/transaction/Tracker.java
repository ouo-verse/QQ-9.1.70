package com.tencent.mobileqq.highway.transaction;

import android.os.SystemClock;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* compiled from: P */
/* loaded from: classes9.dex */
public class Tracker {
    static IPatchRedirector $redirector_ = null;
    public static final String CANCL = "CANCL";
    public static final String FAIL = "FAIL";
    public static final String INITI = "INITI";
    public static final String PAUSE = "PAUSE";
    public static final String PRGRS = "PRGRS";
    public static final String QUERY = "QUERY";
    public static final String QUEUE = "QUEUE";
    public static final String RESPN = "RESPN";
    public static final String REUPLOAD = "REUPLOAD";
    public static final String SLICE = "SLICE";
    public static final String SND_E = "SND_E";
    public static final String SND_F = "SND_F";
    public static final String SND_R = "SND_R";
    public static final String SND_S = "SND_S";
    public static final String SUCES = "SUCES";
    public static final boolean TRACE = true;
    public boolean bLogTime;
    List<String> logStrings;

    public Tracker(int i3, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3));
            return;
        }
        this.bLogTime = false;
        this.logStrings = Collections.synchronizedList(new ArrayList());
        if (j3 < 204800) {
            this.bLogTime = true;
        }
        this.logStrings.add("TransId:" + i3 + "\tStartTime:" + SystemClock.uptimeMillis() + "\tFileSize:" + j3 + "\n");
    }

    public String dumpTrackerInfo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        StringBuilder sb5 = new StringBuilder("_TRACKER_");
        try {
            Iterator<String> it = this.logStrings.iterator();
            while (it.hasNext()) {
                sb5.append(it.next());
            }
        } catch (Exception unused) {
            sb5 = null;
        }
        this.logStrings.clear();
        if (sb5 != null) {
            return sb5.toString();
        }
        return "_TRACKER_FAIL.";
    }

    public void logStep(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        if (!this.bLogTime) {
            return;
        }
        this.logStrings.add(SystemClock.uptimeMillis() + "\tStep:" + str + "\tInfo:" + str2 + "\n");
    }
}
