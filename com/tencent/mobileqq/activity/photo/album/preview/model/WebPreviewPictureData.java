package com.tencent.mobileqq.activity.photo.album.preview.model;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;

/* loaded from: classes10.dex */
public class WebPreviewPictureData extends PreviewPictureData {
    static IPatchRedirector $redirector_;

    public WebPreviewPictureData() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData, com.tencent.richmediabrowser.model.RichMediaBaseData
    public int getType() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return ((Integer) iPatchRedirector.redirect((short) 2, (Object) this)).intValue();
        }
        return 102;
    }
}
