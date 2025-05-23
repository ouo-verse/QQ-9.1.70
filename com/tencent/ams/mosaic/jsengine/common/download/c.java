package com.tencent.ams.mosaic.jsengine.common.download;

import com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager;
import com.tencent.ams.mosaic.utils.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* compiled from: P */
/* loaded from: classes3.dex */
public class c implements IMosaicDownloadManager.a {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void a(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) str);
            return;
        }
        f.e("SampleDownloadCallback", "onDownloadComplete, path: " + str);
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void b(int i3, int i16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, this, Integer.valueOf(i3), Integer.valueOf(i16));
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void onDownloadPause() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, (Object) this);
        } else {
            f.e("SampleDownloadCallback", "onDownloadPause");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void onDownloadResume() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this);
        } else {
            f.e("SampleDownloadCallback", "onDownloadResume");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void onDownloadStart() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            f.e("SampleDownloadCallback", "onDownloadStart");
        }
    }

    @Override // com.tencent.ams.mosaic.jsengine.common.download.IMosaicDownloadManager.a
    public void onFailed(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this, i3);
            return;
        }
        f.e("SampleDownloadCallback", "onFailed, errorCode: " + i3);
    }
}
