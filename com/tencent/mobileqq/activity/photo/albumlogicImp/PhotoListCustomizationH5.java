package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;

/* loaded from: classes10.dex */
public class PhotoListCustomizationH5 extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68926);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            F = PhotoListCustomizationH5.class.getName();
        }
    }

    PhotoListCustomizationH5(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        MediaFileFilter mediaFileFilter;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
            return;
        }
        super.E(intent);
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (photoCommonBaseData != 0 && (mediaFileFilter = photoCommonBaseData.filter) != null) {
            mediaFileFilter.needHeif = true;
        }
    }
}
