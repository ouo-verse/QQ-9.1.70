package com.tencent.mobileqq.activity.photo.incompatiblephoto;

import com.tencent.image.Utils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends b {
    static IPatchRedirector $redirector_;

    public a(String str) {
        super(str);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) str);
        } else {
            this.f184461a = "PhotoIncompatibleWebp";
            this.f184462b = "reportGenerateHeif";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c(String str) {
        return Utils.isHeifFile(str);
    }
}
