package cooperation.qqcircle.utils;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.IQZoneGetQFSRedPointInfoApi;
import qqcircle.QQCircleCounter$RedPointInfo;

/* loaded from: classes28.dex */
public class QFSGalleryEntranceRedPointInfoUtil {
    private static final String TAG = "QFSGalleryEntranceRedPointInfoUtil";

    public static void updateGalleryEntranceRedPointInfo(QQCircleCounter$RedPointInfo qQCircleCounter$RedPointInfo) {
        if (qQCircleCounter$RedPointInfo == null) {
            QLog.d(TAG, 1, "gallery entrance red point info is null ");
            return;
        }
        int i3 = qQCircleCounter$RedPointInfo.redType.get();
        long j3 = qQCircleCounter$RedPointInfo.outLayerInfo.combineRedTypes.get();
        int i16 = qQCircleCounter$RedPointInfo.redTotalNum.get();
        int i17 = 0;
        if (i3 == 10) {
            if ((j3 & 4) > 0) {
                QLog.d(TAG, 1, "gallery entrance red point info is num red point");
                IQZoneGetQFSRedPointInfoApi iQZoneGetQFSRedPointInfoApi = (IQZoneGetQFSRedPointInfoApi) QRoute.api(IQZoneGetQFSRedPointInfoApi.class);
                if (i16 > 0) {
                    i17 = 2;
                }
                iQZoneGetQFSRedPointInfoApi.updateQFSGalleryRedPointInfo(i16, i17);
                return;
            }
            QLog.d(TAG, 1, "gallery entrance red point info is small red point");
            ((IQZoneGetQFSRedPointInfoApi) QRoute.api(IQZoneGetQFSRedPointInfoApi.class)).updateQFSGalleryRedPointInfo(i16, 1);
            return;
        }
        QLog.d(TAG, 1, "is not gallery entrance red type");
        ((IQZoneGetQFSRedPointInfoApi) QRoute.api(IQZoneGetQFSRedPointInfoApi.class)).updateQFSGalleryRedPointInfo(i16, 0);
    }
}
