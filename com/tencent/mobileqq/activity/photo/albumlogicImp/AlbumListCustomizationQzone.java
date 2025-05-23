package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import cooperation.peak.PeakConstants;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationQzone extends AlbumListCustomizationDefault {
    static IPatchRedirector $redirector_;

    /* renamed from: k, reason: collision with root package name */
    public static final String f184373k;

    /* renamed from: j, reason: collision with root package name */
    boolean f184374j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68904);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f184373k = AlbumListCustomizationQzone.class.getName();
        }
    }

    protected AlbumListCustomizationQzone(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
        } else {
            this.f184374j = false;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.f(intent);
            this.f184374j = intent.getBooleanExtra(PeakConstants.IS_FROM_QZONE_AND_NEED_FILTER_RECENT_IMAGES, false);
        }
    }
}
