package com.tencent.mobileqq.nearbypro.media;

import android.app.Activity;
import android.content.Intent;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \f2\u00020\u0001:\u0001\rB\u0011\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b\u00a2\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u000e"}, d2 = {"Lcom/tencent/mobileqq/nearbypro/media/NBPPhotoListCustomization;", "Lcom/tencent/mobileqq/activity/photo/album/PhotoListCustomizationDefault;", "Lcom/tencent/mobileqq/activity/photo/LocalMediaInfo;", "info", "", "position", "", "z0", "Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;)V", UserInfo.SEX_FEMALE, "a", "qq_nearby_pro_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes15.dex */
public final class NBPPhotoListCustomization extends PhotoListCustomizationDefault {
    public NBPPhotoListCustomization(@Nullable AbstractPhotoListActivity abstractPhotoListActivity) {
        super(abstractPhotoListActivity);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault
    public void z0(@Nullable LocalMediaInfo info, int position) {
        String str;
        boolean z16;
        BasePhotoListActivity basePhotoListActivity = null;
        if (info != null) {
            str = info.path;
        } else {
            str = null;
        }
        if (str != null && str.length() != 0) {
            z16 = false;
        } else {
            z16 = true;
        }
        if (z16) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("PhotoConst.PHOTO_PATHS", new String[]{str});
        BasePhotoListActivity basePhotoListActivity2 = this.D;
        if (basePhotoListActivity2 instanceof Activity) {
            basePhotoListActivity = basePhotoListActivity2;
        }
        if (basePhotoListActivity != null) {
            basePhotoListActivity.setResult(-1, intent);
            basePhotoListActivity.finish();
        }
    }
}
