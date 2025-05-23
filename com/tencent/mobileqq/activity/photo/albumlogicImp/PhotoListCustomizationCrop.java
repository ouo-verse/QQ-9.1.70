package com.tencent.mobileqq.activity.photo.albumlogicImp;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.QAlbumUtil;
import com.tencent.mobileqq.activity.photo.album.j;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.e;
import cooperation.peak.PeakConstants;

/* loaded from: classes10.dex */
public class PhotoListCustomizationCrop extends PhotoListCustomizationDefault {
    static IPatchRedirector $redirector_;
    public static final String F;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(68914);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            F = PhotoListCustomizationCrop.class.getName();
        }
    }

    public PhotoListCustomizationCrop(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) abstractPhotoListActivity);
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) localMediaInfo, i3);
            return;
        }
        e.e();
        String str = localMediaInfo.path;
        Intent intent = this.D.getIntent();
        intent.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        intent.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        intent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        intent.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        if (intent.getBooleanExtra(PeakConstants.MULTI_PREVIEW_IN_SINGLE_MODE, false)) {
            intent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.mediaPathsList);
            intent.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, localMediaInfo.position);
        }
        int intExtra = intent.getIntExtra("Business_Origin", 0);
        if (100 != intExtra && 102 != intExtra && 103 != intExtra && 105 != intExtra && 107 != intExtra) {
            intent.setClass(this.D, PhotoCropActivity.class);
        } else {
            if (100 == intExtra) {
                int x16 = ProfileCardUtil.x(this.D);
                intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
                intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
                intent.putExtra(PeakConstants.TARGET_WIDTH, 1080);
                intent.putExtra(PeakConstants.TARGET_HEIGHT, 1080);
                intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1620);
            } else {
                intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
                intent.putExtra(PeakConstants.TARGET_WIDTH, 640);
                intent.putExtra(PeakConstants.TARGET_HEIGHT, 640);
            }
            intent.setClass(this.D, PhotoCropForPortraitActivity.class);
            intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(intExtra));
        }
        j.i(intent, this.f184310e.albumId, str, this.C.f184305p);
        intent.putExtra("PHOTOLIST_START_POSITION", this.f184313i.I.findFirstVisibleItemPosition());
        intent.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
        intent.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
        intent.addFlags(603979776);
        if (intent.getBooleanExtra(PeakConstants.IS_START_ACTIVITY_FOR_RESULT, false)) {
            this.D.setResult(-1, intent);
        } else {
            this.D.startActivity(intent);
        }
        this.D.finish();
        QAlbumUtil.anim(this.D, true, true);
    }
}
