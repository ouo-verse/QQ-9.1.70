package com.tencent.mobileqq.guild.nt.album;

import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.activity.photo.album.j;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.guild.util.bi;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;
import cooperation.peak.PeakConstants;

/* loaded from: classes14.dex */
public class QQGuildPhotoListCustomizationCrop extends PhotoListCustomizationDefault {
    public static final String H = "com.tencent.mobileqq.guild.nt.album.QQGuildPhotoListCustomizationCrop";
    private int F;
    private int G;

    public QQGuildPhotoListCustomizationCrop(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
        this.F = bi.b(16);
        this.G = bi.b(16);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        super.E(intent);
        this.G = intent.getIntExtra(PeakConstants.CLIP_HEIGHT, this.G);
        this.F = intent.getIntExtra(PeakConstants.CLIP_WIDTH, this.F);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo localMediaInfo, int i3) {
        String str = localMediaInfo.path;
        Intent cropActivity = ((IPhotoTempUtils) QRoute.api(IPhotoTempUtils.class)).toCropActivity(this.D, this.D.getIntent());
        cropActivity.putExtra(QAlbumConstants.ALBUM_NAME, this.f184310e.albumName);
        cropActivity.putExtra(QAlbumConstants.ALBUM_ID, this.f184310e.albumId);
        cropActivity.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        cropActivity.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.selectedPhotoList);
        cropActivity.putExtra("PhotoConst.SINGLE_PHOTO_PATH", str);
        cropActivity.putExtra(ShortVideoConstants.MEDIA_INFO, (Parcelable) localMediaInfo);
        if (cropActivity.getBooleanExtra(PeakConstants.MULTI_PREVIEW_IN_SINGLE_MODE, false)) {
            cropActivity.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", this.f184310e.mediaPathsList);
            cropActivity.putExtra(QAlbumConstants.CURRENT_SELECTED_INDEX, localMediaInfo.position);
        }
        if (102 == cropActivity.getIntExtra("Business_Origin", 0)) {
            cropActivity.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 1);
            j.i(cropActivity, this.f184310e.albumId, str, this.C.f184305p);
            cropActivity.putExtra("PHOTOLIST_START_POSITION", this.f184313i.I.findFirstVisibleItemPosition());
            cropActivity.putExtra("FROM_WHERE", PhotoCommonBaseData.FROM_PHOTO_LIST);
            cropActivity.putExtra("PhotoConst.SOURCE_FROM", "FROM_SELECT_PHOTO");
            cropActivity.addFlags(603979776);
            cropActivity.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
            cropActivity.putExtra(PeakConstants.TARGET_WIDTH, this.F);
            cropActivity.putExtra(PeakConstants.TARGET_HEIGHT, this.G);
        }
        this.D.startActivity(cropActivity);
        this.D.finish();
    }
}
