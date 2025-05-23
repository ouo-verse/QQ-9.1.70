package com.tencent.mobileqq.qqlive.data;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes17.dex */
public class QQLiveAudienceDtReportData {
    static IPatchRedirector $redirector_;
    public int gameId;
    public int roomType;
    public String source;
    public String traceInfo;
    public long videoSource;

    public QQLiveAudienceDtReportData(int i3, long j3, int i16, String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i16), str, str2);
            return;
        }
        this.roomType = i3;
        this.videoSource = j3;
        this.gameId = i16;
        this.source = str;
        this.traceInfo = str2;
    }
}
