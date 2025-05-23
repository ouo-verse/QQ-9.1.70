package com.tencent.mobileqq.qqvideoedit.api.impl;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.activity.photo.album.NewPhotoPreviewActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoPreviewCustomizationAIO;
import com.tencent.mobileqq.qqalbum.IPhotoLogicFactory;
import com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi;
import cooperation.peak.PeakConstants;
import java.util.ArrayList;

/* compiled from: P */
/* loaded from: classes17.dex */
public class VideoExportApiImpl implements IVideoExportApi {
    @Override // com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi
    public void fillPreviewAndSendVideoParams(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        bundle.remove(PeakConstants.IS_WAIT_DEST_RESULT);
        bundle.putString(IPhotoLogicFactory.KEY_PHOTO_PREVIEW_CLASS_NAME, PhotoPreviewCustomizationAIO.R);
        bundle.putBoolean(PeakConstants.IS_SEND_TO_AIO, true);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi
    public void previewVideo(Activity activity, Intent intent) {
        intent.addFlags(603979776);
        intent.setClass(activity, NewPhotoPreviewActivity.class);
        activity.startActivity(intent);
    }

    @Override // com.tencent.mobileqq.qqvideoedit.api.IVideoExportApi
    public void sendVideo(Activity activity, Intent intent, ArrayList<String> arrayList, int i3, boolean z16) {
        intent.removeExtra(PeakConstants.IS_WAIT_DEST_RESULT);
        PhotoUtils.sendPhoto(activity, intent, arrayList, i3, z16);
    }
}
