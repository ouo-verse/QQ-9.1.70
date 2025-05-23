package com.tencent.mobileqq.guild.nt.misc.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Point;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.guild.nt.album.QQGuildPhotoListCustomizationCrop;
import com.tencent.mobileqq.guild.nt.misc.api.IGuildPhotoListApi;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.util.cu;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import cooperation.peak.PeakConstants;
import mqq.app.MobileQQ;

/* loaded from: classes14.dex */
public class GuildPhotoListApiImpl implements IGuildPhotoListApi {
    private static String getUploadPhotoTempPath() {
        StringBuilder sb5 = new StringBuilder();
        if (cu.e()) {
            sb5.append(AppConstants.SDCARD_PATH_TROOPPHOTO);
            sb5.append("tmp/");
            sb5.append(System.currentTimeMillis());
            sb5.append("_photo.tmp");
            return VFSAssistantUtils.getSDKPrivatePath(sb5.toString());
        }
        sb5.append(MobileQQ.sMobileQQ.getBaseContext().getFilesDir());
        sb5.append("/tmp/");
        sb5.append(System.currentTimeMillis());
        sb5.append("_photo.tmp");
        return sb5.toString();
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IGuildPhotoListApi
    @NonNull
    public String getGuildPhotoListCustomizationCropClassName() {
        return QQGuildPhotoListCustomizationCrop.H;
    }

    @Override // com.tencent.mobileqq.guild.nt.misc.api.IGuildPhotoListApi
    @NonNull
    public Intent newChooseCoverPhotoListIntent(@NonNull Activity activity, int i3, @NonNull Point point) {
        Intent intent = new Intent();
        intent.putExtra(IPhotoLogicFactory.KEY_PHOTO_LIST_CLASS_NAME, ((IGuildPhotoListApi) QRoute.api(IGuildPhotoListApi.class)).getGuildPhotoListCustomizationCropClassName());
        intent.putExtra(PeakConstants.PHOTO_LIST_SHOW_PREVIEW, true);
        intent.putExtra("Business_Origin", i3);
        intent.putExtra("BUSINESS_ORIGIN_NEW", i3);
        intent.putExtra("PhotoConst.PHOTOLIST_KEY_FILTER_GIF_VIDEO", true);
        intent.putExtra(PeakConstants.TARGET_SAMPLE_SIZE, 1024);
        intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
        intent.putExtra(PeakConstants.ORIGIN_WITH_CLIPINFO, false);
        intent.setClass(activity, NewPhotoListActivity.class);
        intent.putExtra(IPhotoLogicFactory.ENTER_FROM, 50);
        intent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", activity.getClass().getName());
        intent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
        intent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
        intent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
        intent.putExtra(PeakConstants.IS_SINGLE_NEED_EDIT, true);
        intent.putExtra(PeakConstants.TARGET_PATH, getUploadPhotoTempPath());
        intent.putExtra(PeakConstants.CLIP_WIDTH, point.x);
        intent.putExtra(PeakConstants.CLIP_HEIGHT, point.y);
        intent.putExtra(PeakConstants.TARGET_WIDTH, point.x);
        intent.putExtra(PeakConstants.TARGET_HEIGHT, point.y);
        intent.putExtra(QAlbumConstants.IS_RECODE_LAST_ALBUMPATH, true);
        intent.putExtra(PeakConstants.USE_32_BIT_CONFIG, true);
        return intent;
    }
}
