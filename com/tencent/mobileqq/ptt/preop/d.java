package com.tencent.mobileqq.ptt.preop;

import android.text.TextUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqaudio.audioprocessor.c;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

/* compiled from: P */
/* loaded from: classes16.dex */
public class d implements com.tencent.mobileqq.qqaudio.audioprocessor.d {
    static IPatchRedirector $redirector_;

    /* renamed from: d, reason: collision with root package name */
    String f261289d;

    public d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
    public void a(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, (Object) cVar, (Object) aVar);
        }
    }

    @Override // com.tencent.mobileqq.qqaudio.audioprocessor.d
    public void b(com.tencent.mobileqq.qqaudio.audioprocessor.c cVar, c.a aVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) cVar, (Object) aVar);
        }
    }

    public void c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("PttPreVoiceChanger", 2, "delete tempfile, path : " + this.f261289d);
        }
        if (!TextUtils.isEmpty(this.f261289d)) {
            File file = new File(this.f261289d);
            if (file.exists()) {
                file.delete();
            }
        }
    }
}
