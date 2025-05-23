package ac0;

import com.tencent.biz.qqcircle.beans.QCircleInitBean;
import com.tencent.biz.qqcircle.immersive.utils.y;
import com.tencent.biz.richframework.delegate.impl.RFWLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.unitedconfig_android.api.IUnitedConfigManager;

/* compiled from: P */
/* loaded from: classes5.dex */
public class a {
    public static boolean a(QCircleInitBean qCircleInitBean) {
        if (y.c(qCircleInitBean)) {
            RFWLog.e("FeedLine_QFSFastPlayExp", RFWLog.USR, "getEnableFastPlay return error,reason for fetch history");
            return false;
        }
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_layer_fast_play", true);
    }

    public static boolean b() {
        return ((IUnitedConfigManager) QRoute.api(IUnitedConfigManager.class)).isSwitchOn("qqcircle_enable_pre_download_video_when_sdk_not_ready_exp", true);
    }
}
