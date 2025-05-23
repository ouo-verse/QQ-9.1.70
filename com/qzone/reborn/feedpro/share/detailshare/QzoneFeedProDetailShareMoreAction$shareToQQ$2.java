package com.qzone.reborn.feedpro.share.detailshare;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.qzone.reborn.albumx.common.convert.bean.CommonStUser;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QzoneIPCModule;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014\u00a8\u0006\b"}, d2 = {"com/qzone/reborn/feedpro/share/detailshare/QzoneFeedProDetailShareMoreAction$shareToQQ$2", "Landroid/os/ResultReceiver;", "", QzoneIPCModule.RESULT_CODE, "Landroid/os/Bundle;", "resultData", "", "onReceiveResult", "qzone_df_impl_release"}, k = 1, mv = {1, 7, 1})
/* loaded from: classes37.dex */
public final class QzoneFeedProDetailShareMoreAction$shareToQQ$2 extends ResultReceiver {
    @Override // android.os.ResultReceiver
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        Intrinsics.checkNotNullParameter(resultData, "resultData");
        QLog.w("QzoneFeedProDetailShareQQAction", 1, "onReceiveResult");
        ArrayList<ResultRecord> parcelableArrayList = resultData.getParcelableArrayList("selected_target_list");
        ArrayList arrayList = new ArrayList();
        if (parcelableArrayList != null) {
            for (ResultRecord resultRecord : parcelableArrayList) {
                if (resultRecord.uinType == 0) {
                    CommonStUser commonStUser = new CommonStUser();
                    String str = resultRecord.uin;
                    Intrinsics.checkNotNullExpressionValue(str, "it.uin");
                    commonStUser.g(str);
                    arrayList.add(commonStUser);
                }
            }
        }
    }
}
