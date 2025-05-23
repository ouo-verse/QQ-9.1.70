package com.tencent.mobileqq.activity.photo.album.preview;

import android.content.Context;
import com.tencent.mobileqq.activity.photo.album.preview.view.PreviewVideoView;
import com.tencent.mobileqq.activity.photo.album.preview.view.WebPreviewPictureView;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.richmediabrowser.core.IMvpFactory;

/* compiled from: P */
/* loaded from: classes10.dex */
public class c implements IMvpFactory {
    static IPatchRedirector $redirector_;

    public c() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.richmediabrowser.core.IMvpFactory
    public f04.a createModel(int i3, f04.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (f04.a) iPatchRedirector.redirect((short) 3, (Object) this, i3, (Object) bVar);
        }
        switch (i3) {
            case 100:
            case 102:
                return new com.tencent.mobileqq.activity.photo.album.preview.model.b();
            case 101:
                return new com.tencent.mobileqq.activity.photo.album.preview.model.c();
            default:
                return null;
        }
    }

    @Override // com.tencent.richmediabrowser.core.IMvpFactory
    public f04.b createPresenter(int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (f04.b) iPatchRedirector.redirect((short) 2, (Object) this, i3);
        }
        switch (i3) {
            case 100:
            case 102:
                return new com.tencent.mobileqq.activity.photo.album.preview.presenter.b();
            case 101:
                return new com.tencent.mobileqq.activity.photo.album.preview.presenter.d();
            default:
                return null;
        }
    }

    @Override // com.tencent.richmediabrowser.core.IMvpFactory
    public f04.c createView(Context context, int i3, f04.b bVar) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (f04.c) iPatchRedirector.redirect((short) 4, this, context, Integer.valueOf(i3), bVar);
        }
        switch (i3) {
            case 100:
                if (!(bVar instanceof com.tencent.mobileqq.activity.photo.album.preview.presenter.b)) {
                    return null;
                }
                return new com.tencent.mobileqq.activity.photo.album.preview.view.b(context, (com.tencent.mobileqq.activity.photo.album.preview.presenter.b) bVar);
            case 101:
                if (!(bVar instanceof com.tencent.mobileqq.activity.photo.album.preview.presenter.d)) {
                    return null;
                }
                return new PreviewVideoView(context, (com.tencent.mobileqq.activity.photo.album.preview.presenter.d) bVar);
            case 102:
                if (!(bVar instanceof com.tencent.mobileqq.activity.photo.album.preview.presenter.b)) {
                    return null;
                }
                return new WebPreviewPictureView(context, (com.tencent.mobileqq.activity.photo.album.preview.presenter.b) bVar);
            default:
                return null;
        }
    }
}
