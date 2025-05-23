package com.tencent.util;

import android.support.annotation.NonNull;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: P */
/* loaded from: classes27.dex */
public class o implements com.tencent.mobileqq.app.identity.e {
    static IPatchRedirector $redirector_;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: P */
    /* loaded from: classes27.dex */
    public class a implements ZipUtils.UnzipCallback {
        static IPatchRedirector $redirector_;

        a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this, (Object) o.this);
            }
        }

        @Override // com.tencent.biz.common.util.ZipUtils.UnzipCallback
        public void onFileUnzip(File file, String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) file, (Object) str);
            } else {
                ZipReporter.b(file, ZipReporter.c());
            }
        }
    }

    public o() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void c(com.tencent.mobileqq.manager.c cVar) {
        int a16;
        if (cVar == null) {
            a16 = 20;
        } else {
            a16 = cVar.a();
        }
        ZipReporter.e(a16);
        ZipUtils.setUnzipCallback(new a());
    }

    @Override // com.tencent.mobileqq.app.identity.e
    public void a(@NonNull com.tencent.mobileqq.manager.c cVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) cVar);
        } else {
            cVar.e(20);
            c(cVar);
        }
    }

    @Override // com.tencent.mobileqq.app.identity.e
    public void b(@NonNull com.tencent.mobileqq.manager.c cVar, String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) cVar, (Object) str);
            return;
        }
        try {
            cVar.e(new JSONObject(str).optInt("zip_unusual_threshold"));
        } catch (JSONException e16) {
            QLog.d("ZipConfigCallback", 1, "onParsed JSONException : ", e16);
        }
        c(cVar);
    }
}
