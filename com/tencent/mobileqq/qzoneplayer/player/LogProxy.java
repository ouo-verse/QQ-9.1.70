package com.tencent.mobileqq.qzoneplayer.player;

import com.google.android.exoplayer2.ext.mediaplayer.ILogger;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.oskplayer.util.QLog;

/* loaded from: classes16.dex */
public class LogProxy implements ILogger {
    static IPatchRedirector $redirector_;
    private QLog qLog;

    public LogProxy(QLog qLog) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) qLog);
        } else {
            this.qLog = qLog;
        }
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int d(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) ? this.qLog.d(str, str2) : ((Integer) iPatchRedirector.redirect((short) 4, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int e(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 11)) ? this.qLog.e(str, str2) : ((Integer) iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int i(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) ? this.qLog.i(str, str2) : ((Integer) iPatchRedirector.redirect((short) 6, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int v(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) ? this.qLog.v(str, str2) : ((Integer) iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 8)) ? this.qLog.w(str, str2) : ((Integer) iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int d(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? this.qLog.d(str, str2, th5) : ((Integer) iPatchRedirector.redirect((short) 5, this, str, str2, th5)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int e(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) ? this.qLog.i(str, str2, th5) : ((Integer) iPatchRedirector.redirect((short) 12, this, str, str2, th5)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int i(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) ? this.qLog.i(str, str2, th5) : ((Integer) iPatchRedirector.redirect((short) 7, this, str, str2, th5)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int v(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) ? this.qLog.v(str, str2, th5) : ((Integer) iPatchRedirector.redirect((short) 3, this, str, str2, th5)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, String str2, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) ? this.qLog.i(str, str2, th5) : ((Integer) iPatchRedirector.redirect((short) 9, this, str, str2, th5)).intValue();
    }

    @Override // com.google.android.exoplayer2.ext.mediaplayer.ILogger
    public int w(String str, Throwable th5) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) ? this.qLog.w(str, th5) : ((Integer) iPatchRedirector.redirect((short) 10, (Object) this, (Object) str, (Object) th5)).intValue();
    }
}
