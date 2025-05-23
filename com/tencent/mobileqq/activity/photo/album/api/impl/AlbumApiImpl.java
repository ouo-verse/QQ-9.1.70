package com.tencent.mobileqq.activity.photo.album.api.impl;

import com.tencent.image.ProtocolDownloader;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.api.IAlbumApi;
import com.tencent.mobileqq.activity.photo.albumlogicImp.AlbumListCustomizationAIO;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.transfile.AlbumPreviewThumbDownloader;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumApiImpl implements IAlbumApi {
    static IPatchRedirector $redirector_;

    public AlbumApiImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.api.IAlbumApi
    public String getAlbumListCustomizationAIOClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (String) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        return AlbumListCustomizationAIO.f184370j;
    }

    @Override // com.tencent.mobileqq.activity.photo.album.api.IAlbumApi
    public ProtocolDownloader getAlbumPreviewThumbDownloader() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (ProtocolDownloader) iPatchRedirector.redirect((short) 4, (Object) this);
        }
        return new AlbumPreviewThumbDownloader();
    }

    @Override // com.tencent.mobileqq.activity.photo.album.api.IAlbumApi
    public String getNewPhotoListActivityClassName() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (String) iPatchRedirector.redirect((short) 3, (Object) this);
        }
        return NewPhotoListActivity.class.getName();
    }
}
