package com.tencent.aelight.camera.zplan.api.impl;

import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoCommonBaseData;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \u000f2\u00020\u0001:\u0001\u0010B\u0011\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016J\u001a\u0010\n\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\t\u001a\u00020\bH\u0016\u00a8\u0006\u0011"}, d2 = {"Lcom/tencent/aelight/camera/zplan/api/impl/PhotoListCustomizationZPlan;", "Lcom/tencent/mobileqq/activity/photo/album/PhotoListCustomizationDefault;", "Landroid/content/Intent;", "intent", "", "E", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "position", "z0", "Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;)V", UserInfo.SEX_FEMALE, "a", "aelight_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes32.dex */
public final class PhotoListCustomizationZPlan extends PhotoListCustomizationDefault {
    public PhotoListCustomizationZPlan(AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void E(Intent intent) {
        super.E(intent);
        PhotoCommonBaseData<O> photoCommonBaseData = this.f184310e;
        if (photoCommonBaseData != 0) {
            photoCommonBaseData.isSingleMode = true;
            photoCommonBaseData.showMediaType = 1;
        }
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(LocalMediaInfo info, int position) {
        String str = info != null ? info.path : null;
        if (str == null || str.length() == 0) {
            QLog.e("PhotoListCustomizationZPlan", 1, "select an item with null info or empty path.");
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.PHOTO_PATHS", new String[]{str});
        BasePhotoListActivity basePhotoListActivity = this.D;
        if (basePhotoListActivity != null) {
            basePhotoListActivity.setResult(-1, intent);
            basePhotoListActivity.finish();
        }
    }
}
