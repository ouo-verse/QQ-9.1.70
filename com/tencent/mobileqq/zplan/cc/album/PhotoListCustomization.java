package com.tencent.mobileqq.zplan.cc.album;

import android.content.Intent;
import android.view.View;
import android.widget.RelativeLayout;
import com.heytap.databaseengine.model.UserInfo;
import com.tencent.mobileqq.activity.photo.album.BasePhotoListActivity;
import com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault;
import com.tencent.mobileqq.activity.photo.album.photolist.AbstractPhotoListActivity;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import cooperation.qzone.QzoneIPCModule;
import id3.d;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0012\u001a\u00020\u0011\u00a2\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0012\u0010\u0006\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0007\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\"\u0010\r\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016R\u0014\u0010\u0010\u001a\u00020\u000e8\u0002X\u0082\u0004\u00a2\u0006\u0006\n\u0004\b\u0003\u0010\u000f\u00a8\u0006\u0015"}, d2 = {"Lcom/tencent/mobileqq/zplan/cc/album/PhotoListCustomization;", "Lcom/tencent/mobileqq/activity/photo/album/PhotoListCustomizationDefault;", "", UserInfo.SEX_FEMALE, "Landroid/view/View;", "v", "P", "O", "", "requestCode", QzoneIPCModule.RESULT_CODE, "Landroid/content/Intent;", "data", "G", "Lid3/d;", "Lid3/d;", "dtReportHelper", "Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Lcom/tencent/mobileqq/activity/photo/album/photolist/AbstractPhotoListActivity;)V", "zplan_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes35.dex */
public final class PhotoListCustomization extends PhotoListCustomizationDefault {

    /* renamed from: F, reason: from kotlin metadata */
    private final d dtReportHelper;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PhotoListCustomization(AbstractPhotoListActivity activity) {
        super(activity);
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.dtReportHelper = new d(null, 1, null);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void F() {
        super.F();
        d dVar = this.dtReportHelper;
        BasePhotoListActivity mActivity = this.D;
        Intrinsics.checkNotNullExpressionValue(mActivity, "mActivity");
        RelativeLayout relativeLayout = this.f184313i.f184280m;
        Intrinsics.checkNotNullExpressionValue(relativeLayout, "mScene.root");
        dVar.j(mActivity, relativeLayout, "pg_zplan_ai_picker", new LinkedHashMap());
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void G(int requestCode, int resultCode, Intent data) {
        super.G(requestCode, resultCode, data);
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void O(View v3) {
        super.O(v3);
        this.dtReportHelper.d("evt_zplan_ai_picker_confirm", new LinkedHashMap());
    }

    @Override // com.tencent.mobileqq.activity.photo.album.PhotoListCustomizationDefault, com.tencent.mobileqq.activity.photo.album.photolist.PhotoListCustomizationBase, com.tencent.mobileqq.activity.photo.album.photolist.f
    public void P(View v3) {
        super.P(v3);
        this.dtReportHelper.d("evt_zplan_ai_picker_back", new LinkedHashMap());
    }
}
