package com.tencent.mobileqq.qqecommerce.biz.kuikly.export.modules.photo;

import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.activity.photo.albumlogicImp.PhotoListCustomizationCrop;
import cooperation.peak.PeakConstants;

/* loaded from: classes35.dex */
public class QQKuiklyPhotoListCustomizationCrop extends PhotoListCustomizationCrop {
    public QQKuiklyPhotoListCustomizationCrop(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void p(View view, int i3) {
        if (this.D.getIntent().getBooleanExtra(PeakConstants.KEY_CHOOSE_VIDEO_DIRECT_RETURN, false)) {
            Intent intent = new Intent();
            intent.putExtra(PeakConstants.KEY_CHOOSE_VIDEO_PATH, this.f184313i.Q.m0(i3).path);
            this.D.setResult(-1, intent);
            this.D.finish();
            return;
        }
        super.p(view, i3);
    }
}
