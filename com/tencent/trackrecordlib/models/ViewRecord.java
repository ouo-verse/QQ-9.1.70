package com.tencent.trackrecordlib.models;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ViewRecord {
    static IPatchRedirector $redirector_;
    public int mRecentDecorViewHashcode;
    public long mRecentHookTime;
    public int mRecentTotalViewNum;

    public ViewRecord() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 1)) {
            return;
        }
        iPatchRedirector.redirect((short) 1, (Object) this);
    }

    public String toString() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (String) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return "ViewRecord{mRecentDecorViewHashcode=" + this.mRecentDecorViewHashcode + ", mRecentTotalViewNum=" + this.mRecentTotalViewNum + ", mRecentHookTime=" + this.mRecentHookTime + '}';
    }

    public ViewRecord(int i3, int i16, long j3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, Integer.valueOf(i3), Integer.valueOf(i16), Long.valueOf(j3));
            return;
        }
        this.mRecentDecorViewHashcode = i3;
        this.mRecentTotalViewNum = i16;
        this.mRecentHookTime = j3;
    }

    public ViewRecord(ViewRecord viewRecord) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) viewRecord);
            return;
        }
        this.mRecentDecorViewHashcode = viewRecord.mRecentDecorViewHashcode;
        this.mRecentTotalViewNum = viewRecord.mRecentTotalViewNum;
        this.mRecentHookTime = viewRecord.mRecentHookTime;
    }
}
