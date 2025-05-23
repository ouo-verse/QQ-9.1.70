package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumCustomAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.albumlist.AbstractAlbumListFragment;
import com.tencent.mobileqq.activity.photo.album.h;
import com.tencent.mobileqq.data.QQAlbumInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.ReportController;

/* compiled from: P */
/* loaded from: classes10.dex */
public class AlbumListCustomizationAIO extends AlbumListCustomizationDefault {
    static IPatchRedirector $redirector_;

    /* renamed from: j, reason: collision with root package name */
    public static final String f184370j;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(26820);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            f184370j = AlbumListCustomizationAIO.class.getName();
        }
    }

    protected AlbumListCustomizationAIO(AbstractAlbumListFragment abstractAlbumListFragment) {
        super(abstractAlbumListFragment);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractAlbumListFragment);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public void f(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.f(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.AlbumListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.albumlist.AlbumListCustomizationBase, com.tencent.mobileqq.activity.photo.album.albumlist.b
    public boolean g(QQAlbumInfo qQAlbumInfo, int i3, Intent intent) {
        int i16;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return ((Boolean) iPatchRedirector.redirect((short) 3, this, qQAlbumInfo, Integer.valueOf(i3), intent)).booleanValue();
        }
        if (qQAlbumInfo.f203112id.equals(QAlbumCustomAlbumConstants.RECENT_ALBUM_ID)) {
            i16 = 1;
        } else if (qQAlbumInfo.f203112id.equals("qzone_album")) {
            i16 = 2;
        } else {
            i16 = 3;
        }
        ReportController.o(null, "CliOper", "", ((h) this.f184223c).f184249h, "0X800A917", "0X800A917", i16, 0, "", "", "", "");
        return super.g(qQAlbumInfo, i3, intent);
    }
}
