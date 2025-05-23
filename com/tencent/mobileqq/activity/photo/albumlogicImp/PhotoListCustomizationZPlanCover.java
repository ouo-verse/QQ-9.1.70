package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.utils.e;

/* loaded from: classes10.dex */
public class PhotoListCustomizationZPlanCover extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68953);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 4)) {
            redirector.redirect((short) 4);
        } else {
            F = PhotoListCustomizationZPlanCover.class.getName();
        }
    }

    protected PhotoListCustomizationZPlanCover(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent);
        } else {
            super.E(intent);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) localMediaInfo, i3);
            return;
        }
        e.e();
        String str = localMediaInfo.path;
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        intent.setClass(this.D, PhotoCropActivity.class);
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra("PhotoConst.SUB_SOURCE_FROM", "FROM_ZPLAN_BG_EDIT");
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        intent.addFlags(603979776);
        this.D.startActivity(intent);
        this.D.finish();
        QAlbumUtil.anim(this.D, true, true);
    }
}
