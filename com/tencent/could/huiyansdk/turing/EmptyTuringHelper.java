package com.tencent.could.huiyansdk.turing;

import android.content.Context;
import android.view.View;
import com.tencent.could.aicamare.CameraHolder;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes5.dex */
public class EmptyTuringHelper extends b {
    static IPatchRedirector $redirector_;

    public EmptyTuringHelper() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String a() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 9)) {
            return null;
        }
        return (String) iPatchRedirector.redirect((short) 9, (Object) this);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public JSONObject b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 10)) {
            return (JSONObject) iPatchRedirector.redirect((short) 10, (Object) this);
        }
        return null;
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            return (String) iPatchRedirector.redirect((short) 8, (Object) this);
        }
        return "";
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void d() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        }
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public String a(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        return (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 5)) ? "" : (String) iPatchRedirector.redirect((short) 5, (Object) this, (Object) str, (Object) str2);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 6)) {
            return;
        }
        iPatchRedirector.redirect((short) 6, (Object) this, (Object) context);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 4)) {
            return;
        }
        iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public void a(byte[] bArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 2)) {
            return;
        }
        iPatchRedirector.redirect((short) 2, (Object) this, (Object) bArr);
    }

    @Override // com.tencent.could.huiyansdk.turing.b
    public int a(View view, CameraHolder cameraHolder, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Integer) iPatchRedirector.redirect((short) 3, this, view, cameraHolder, str)).intValue();
        }
        c cVar = this.f100269a;
        if (cVar == null) {
            return 0;
        }
        ((d) cVar).a(0L, null);
        return 0;
    }
}
