package com.tencent.mobileqq.qqalbum.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.aelight.camera.qqstory.api.IAELaunchEditPic;
import com.tencent.mobileqq.activity.photo.PhotoCropActivity;
import com.tencent.mobileqq.activity.photo.PhotoCropForPortraitActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.QAlbumConstants;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qqalbum.IPhotoTempUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.avatar.api.ITroopPhotoUtilsApi;
import com.tencent.mobileqq.util.ProfileCardUtil;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* loaded from: classes16.dex */
public class PhotoTempUtilsImpl implements IPhotoTempUtils {
    static IPatchRedirector $redirector_;

    public PhotoTempUtilsImpl() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoTempUtils
    public void sendPhoto(Activity activity, Intent intent, ArrayList<String> arrayList, int i3, boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, activity, intent, arrayList, Integer.valueOf(i3), Boolean.valueOf(z16));
        } else {
            PhotoUtils.sendPhoto(activity, intent, arrayList, i3, z16);
        }
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoTempUtils
    public Intent toCropActivity(Activity activity, Intent intent) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            return (Intent) iPatchRedirector.redirect((short) 4, (Object) this, (Object) activity, (Object) intent);
        }
        if (intent == null) {
            intent = new Intent();
        }
        int intExtra = intent.getIntExtra("Business_Origin", 0);
        if (100 != intExtra && 102 != intExtra && 103 != intExtra && 105 != intExtra) {
            intent.setClass(activity, PhotoCropActivity.class);
        } else {
            if (100 == intExtra) {
                int x16 = ProfileCardUtil.x(activity);
                intent.putExtra(PeakConstants.CLIP_WIDTH, x16);
                intent.putExtra(PeakConstants.CLIP_HEIGHT, x16);
            } else {
                intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
            }
            intent.setClass(activity, PhotoCropForPortraitActivity.class);
            intent.putExtra(PeakConstants.PHOTO_IS_WITH_PENDANT, false);
            intent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", ((ITroopPhotoUtilsApi) QRoute.api(ITroopPhotoUtilsApi.class)).getShapeOfBusi(intExtra));
            intent.putExtra(PeakConstants.TARGET_WIDTH, 640);
            intent.putExtra(PeakConstants.TARGET_HEIGHT, 640);
        }
        return intent;
    }

    @Override // com.tencent.mobileqq.qqalbum.IPhotoTempUtils
    public Intent toEditPicActivityIntent(Activity activity, Intent intent, String str, int i3, Bundle bundle) {
        Intent intent2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            return (Intent) iPatchRedirector.redirect((short) 3, this, activity, intent, str, Integer.valueOf(i3), bundle);
        }
        activity.getIntent().removeExtra(QAlbumConstants.PARAM_INITTIME);
        ReportController.o(null, "CliOper", "", "", "0x8004B39", "0x8004B39", 0, 0, "", "", "", "");
        if (intent == null) {
            intent2 = ((IAELaunchEditPic) QRoute.api(IAELaunchEditPic.class)).startEditPic(activity, str, true, true, true, true, true, i3, 142, 5, bundle);
        } else {
            intent2 = intent;
        }
        intent2.putExtra(PeakConstants.EANBLE_EDIT_PIC_TITLE_BAR, true);
        return intent2;
    }
}
