package com.tencent.mobileqq.activity.photo.album.preview.presenter;

import com.tencent.mobileqq.activity.photo.album.preview.BasePreviewPresent;
import com.tencent.mobileqq.activity.photo.album.preview.model.PreviewPictureData;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.model.RichMediaBaseData;
import com.tencent.richmediabrowser.model.RichMediaBrowserInfo;
import com.tencent.richmediabrowser.presenter.MainBrowserPresenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class b extends BasePreviewPresent {
    static IPatchRedirector $redirector_;

    public b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public String j(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        RichMediaBrowserInfo item = getItem(i3);
        if (item != null) {
            RichMediaBaseData richMediaBaseData = item.baseData;
            if (richMediaBaseData instanceof PreviewPictureData) {
                return ((PreviewPictureData) richMediaBaseData).filePath;
            }
            return null;
        }
        return null;
    }

    public void k() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        MainBrowserPresenter mainBrowserPresenter = this.mainBrowserPresenter;
        if (mainBrowserPresenter instanceof c) {
            ((c) mainBrowserPresenter).f184344i.c(100);
        }
    }
}
