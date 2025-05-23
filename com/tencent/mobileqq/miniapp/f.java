package com.tencent.mobileqq.miniapp;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.utils.ah;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes15.dex */
public class f {
    static IPatchRedirector $redirector_;

    public f() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private boolean a(a aVar, MiniAppOptions miniAppOptions) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppLauncher", 2, "checkMemory. cacheKey=", aVar.f246786b.f246807p);
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public a b(MiniAppActivity miniAppActivity, String str, int i3) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppLauncher", 2, "createApp type=", Integer.valueOf(i3));
        }
        if (i3 != 0 && i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
            QLog.e("MiniAppLauncher", 1, "createApp error. unknown appType");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(d dVar, @NonNull b bVar) {
        if (QLog.isColorLevel()) {
            QLog.d("MiniAppLauncher", 2, "downloadApp. cacheKey=", dVar.f246807p);
        }
        bVar.a(dVar.f246801j, "MiniAppLauncher", dVar.f246807p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(a aVar, MiniAppOptions miniAppOptions) {
        if (!a(aVar, miniAppOptions)) {
            return;
        }
        ah.q();
        aVar.d();
    }
}
