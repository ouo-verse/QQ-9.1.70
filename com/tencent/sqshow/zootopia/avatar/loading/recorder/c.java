package com.tencent.sqshow.zootopia.avatar.loading.recorder;

import android.graphics.Rect;
import com.tencent.mobileqq.transfile.dns.DomainData;
import com.tencent.qphone.base.util.QLog;
import com.tencent.sqshow.zootopia.utils.w;
import com.tencent.zplan.common.model.UploadConfig;
import com.tencent.zplan.meme.Priority;
import com.tencent.zplan.meme.action.MODE;
import com.tencent.zplan.record.model.SingleRecordRequestParams;
import common.config.service.QzoneConfig;
import kotlin.Metadata;
import tl.h;

/* compiled from: P */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \n2\u00020\u0001:\u0001\u000bB\u0007\u00a2\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0007\u001a\u00020\u0006H\u0016\u00a8\u0006\f"}, d2 = {"Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/c;", "Lcom/tencent/sqshow/zootopia/avatar/loading/recorder/BaseLoadingAvatarRecorder;", "", "reqFrom", "Lcom/tencent/zplan/record/model/SingleRecordRequestParams;", "i", "", DomainData.DOMAIN_NAME, "<init>", "()V", h.F, "a", "superqqshow-portal-impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes34.dex */
public final class c extends BaseLoadingAvatarRecorder {
    @Override // com.tencent.sqshow.zootopia.avatar.loading.recorder.BaseLoadingAvatarRecorder
    public String n() {
        return "FullPortalAvatarRecorder_";
    }

    public c() {
        super(1);
    }

    @Override // com.tencent.sqshow.zootopia.avatar.loading.recorder.BaseLoadingAvatarRecorder
    public SingleRecordRequestParams i(int reqFrom) {
        String b16 = w.f373306a.b();
        Rect d16 = e84.a.f395879a.d();
        QLog.i("FullPortalAvatarRecorder_", 1, "getRecordParam fullSize:" + d16);
        SingleRecordRequestParams singleRecordRequestParams = new SingleRecordRequestParams(QzoneConfig.DEFAULT_PHOTOVIEW_PHOTO_BYTES, b16, null, d16.width(), d16.height(), MODE.SHARPP, null, 103, null, Priority.MIDDLE, null, null, reqFrom, false, null, null, 60740, null);
        singleRecordRequestParams.getUploadConfig().setNeedUpload(true);
        singleRecordRequestParams.getUploadConfig().setTarget(UploadConfig.UploadTarget.CDN_AVATAR);
        singleRecordRequestParams.getUploadConfig().setCheckAppearanceKey(false);
        return singleRecordRequestParams;
    }
}
