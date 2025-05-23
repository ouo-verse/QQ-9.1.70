package com.qzone.reborn.layer.share;

import android.app.Activity;
import com.tencent.biz.pubaccount.util.api.impl.PublicAccountMessageUtilImpl;
import com.tencent.mobileqq.transfile.report.ReportConstant;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.winkreport.datong.WinkPublishMediaRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.model.PhotoInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \t2\u00020\u0001:\u0001\u000eB\u0011\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0016J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\u000f"}, d2 = {"Lcom/qzone/reborn/layer/share/e;", "Lcom/qzone/reborn/layer/share/QZoneBaseShareAction;", "", ReportConstant.COSTREPORT_PREFIX, "Lcom/qzone/reborn/layer/share/f;", "shareContext", "Lcom/tencent/mobileqq/utils/ShareActionSheetBuilder$ActionSheetItem;", PublicAccountMessageUtilImpl.ITEM_STRUCT_FIRST_LEVEL_NAME, "", "j", "Landroid/app/Activity;", WinkPublishMediaRecord.WINK_REPORT_TYPE_ACTIVITY, "<init>", "(Landroid/app/Activity;)V", "a", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class e extends QZoneBaseShareAction {
    public e(Activity activity) {
        super(activity);
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public void j(f shareContext, ShareActionSheetBuilder.ActionSheetItem item) {
        Intrinsics.checkNotNullParameter(shareContext, "shareContext");
        Intrinsics.checkNotNullParameter(item, "item");
        if (shareContext.f58179c == null) {
            QLog.e("QZonePhotoRepairAction", 1, "[doAction] shareContext\uff1a " + shareContext);
            return;
        }
        com.qzone.reborn.util.i.b().l("QZONE_LAYER_SHARE_PHOTO_REPAIR_RED_DOT", false);
        PhotoInfo photoInfo = shareContext.f58179c;
        Intrinsics.checkNotNullExpressionValue(photoInfo, "shareContext.mCurrentInfo");
        wn.b bVar = new wn.b(photoInfo, shareContext.f58180d, 3);
        Activity activity = n();
        Intrinsics.checkNotNullExpressionValue(activity, "activity");
        new p018do.i(activity, bVar).show();
    }

    @Override // com.qzone.reborn.layer.share.QZoneBaseShareAction
    public int[] s() {
        return new int[]{230};
    }
}
