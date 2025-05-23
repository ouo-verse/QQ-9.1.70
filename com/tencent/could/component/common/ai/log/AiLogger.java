package com.tencent.could.component.common.ai.log;

import android.content.Context;
import android.os.HandlerThread;
import android.util.Log;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AiLogger {
    static IPatchRedirector $redirector_;
    private AiLogConfig config;
    private b printer;

    public AiLogger(Context context, AiLogConfig aiLogConfig) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context, (Object) aiLogConfig);
        } else {
            this.config = aiLogConfig;
            this.printer = new b(context, aiLogConfig);
        }
    }

    private String formatString(String str, Object... objArr) {
        if (str != null) {
            return String.format(str, objArr);
        }
        StringBuilder sb5 = new StringBuilder();
        int length = objArr.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (i3 != 0) {
                sb5.append(", ");
            }
            sb5.append(objArr[i3]);
        }
        return sb5.toString();
    }

    public void asset(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 17)) {
            iPatchRedirector.redirect((short) 17, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(7, str, str2);
        }
    }

    public void debug(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(3, str, str2);
        }
    }

    public void error(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 14)) {
            iPatchRedirector.redirect((short) 14, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(6, str, str2);
        }
    }

    public void info(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(4, str, str2);
        }
    }

    public void release() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 20)) {
            iPatchRedirector.redirect((short) 20, (Object) this);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            c cVar = bVar.f99956e;
            if (cVar == null) {
                Log.e("FilePrinter", "writeHandler is null");
            } else {
                cVar.removeMessages(1);
                c cVar2 = bVar.f99956e;
                f fVar = cVar2.f99961d;
                if (fVar != null) {
                    fVar.a();
                }
                cVar2.f99961d = null;
                bVar.f99956e = null;
                HandlerThread handlerThread = bVar.f99957f;
                if (handlerThread != null && handlerThread.isAlive()) {
                    bVar.f99957f.quitSafely();
                }
            }
        }
        this.printer = null;
    }

    public void verbose(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(3, str, str2);
        }
    }

    public void warn(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 11)) {
            iPatchRedirector.redirect((short) 11, (Object) this, (Object) str, (Object) str2);
            return;
        }
        b bVar = this.printer;
        if (bVar != null) {
            bVar.a(5, str, str2);
        }
    }

    public void asset(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 18)) {
            asset(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 18, (Object) this, (Object) str);
        }
    }

    public void debug(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            debug(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 6, (Object) this, (Object) str);
        }
    }

    public void error(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 15)) {
            error(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 15, (Object) this, (Object) str);
        }
    }

    public void info(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            info(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 9, (Object) this, (Object) str);
        }
    }

    public void verbose(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            verbose(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
        }
    }

    public void warn(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 12)) {
            warn(this.config.getDefaultTag(), str);
        } else {
            iPatchRedirector.redirect((short) 12, (Object) this, (Object) str);
        }
    }

    public void asset(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 19)) {
            asset(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 19, this, str, str2, objArr);
        }
    }

    public void debug(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 7)) {
            debug(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 7, this, str, str2, objArr);
        }
    }

    public void error(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 16)) {
            error(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 16, this, str, str2, objArr);
        }
    }

    public void info(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 10)) {
            info(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 10, this, str, str2, objArr);
        }
    }

    public void verbose(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            verbose(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 4, this, str, str2, objArr);
        }
    }

    public void warn(String str, String str2, Object... objArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 13)) {
            warn(str, formatString(str2, objArr));
        } else {
            iPatchRedirector.redirect((short) 13, this, str, str2, objArr);
        }
    }
}
