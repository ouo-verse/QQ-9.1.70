package com.tencent.mobileqq.activity.photo.album.preview.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.model.MainBrowserModel;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a extends MainBrowserModel {
    static IPatchRedirector $redirector_;

    public a(com.tencent.mobileqq.activity.photo.album.preview.presenter.c cVar) {
        super(cVar);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) cVar);
        }
    }
}
