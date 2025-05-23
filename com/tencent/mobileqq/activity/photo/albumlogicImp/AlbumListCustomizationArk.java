package com.tencent.mobileqq.activity.photo.albumlogicImp;

import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationArk extends AlbumListCustomizationDefault {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final String f184371j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68902);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
        } else {
            f184371j = AlbumListCustomizationArk.class.getName();
        }
    }

    public AlbumListCustomizationArk(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
        }
    }
}
