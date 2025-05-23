package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class h extends e {
    static IPatchRedirector $redirector_;

    public h(PhotoCropActivity photoCropActivity) {
        super(photoCropActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) photoCropActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.e
    public void a(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, i3);
        } else {
            this.f184454b.getIntent().putExtra(PeakConstants.QZONE_COVER_SYNC_FLAG, i3);
        }
    }
}
