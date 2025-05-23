package com.tencent.mobileqq.activity.photo.album;

import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListFragment extends AbstractAlbumListFragment {
    static IPatchRedirector $redirector_;

    public AlbumListFragment() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment
    protected com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> ph() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (com.tencent.mobileqq.activity.photo.album.albumlist.b) iPatchRedirector.redirect((short) 2, (Object) this);
        }
        int intExtra = getActivity().getIntent().getIntExtra(IPhotoLogicFactory.ENTER_FROM, 0);
        com.tencent.mobileqq.activity.photo.album.albumlist.b<? extends OtherCommonData> createAlbumListLogic = ((IPhotoLogicFactory) QRoute.api(IPhotoLogicFactory.class)).createAlbumListLogic(this, getActivity().getIntent());
        if (QLog.isColorLevel()) {
            QLog.d("QQAlbum", 2, "generateLogic:" + createAlbumListLogic.getClass().getName() + " enterFrom:" + intExtra);
        }
        return createAlbumListLogic;
    }
}
