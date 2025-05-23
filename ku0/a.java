package ku0;

import android.text.TextUtils;
import com.tencent.icgame.common.api.IAegisLogApi;
import com.tencent.mobileqq.icgame.api.room.AudienceRoomConfig;
import com.tencent.mobileqq.icgame.data.room.LiveInfo;
import com.tencent.mobileqq.qqlive.data.room.LiveWatchMediaInfo;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {
    public static void a(LiveInfo liveInfo, AudienceRoomConfig.VideoFormat videoFormat) {
        IAegisLogApi iAegisLogApi = (IAegisLogApi) QRoute.api(IAegisLogApi.class);
        if (liveInfo == null) {
            iAegisLogApi.w("ICGameLiveInfoResultCheckReport", "checkAndPrintLiveInfoValid liveInfo is null!");
            return;
        }
        LiveWatchMediaInfo liveWatchMediaInfo = liveInfo.watchMediaInfo;
        if (liveWatchMediaInfo == null) {
            iAegisLogApi.w("ICGameLiveInfoResultCheckReport", "checkAndPrintLiveInfoValid watchMediaInfo is null!");
            return;
        }
        String str = liveWatchMediaInfo.mUrl;
        if (TextUtils.isEmpty(str)) {
            iAegisLogApi.w("ICGameLiveInfoResultCheckReport", "checkAndPrintLiveInfoValid playUrl is empty!");
            return;
        }
        iAegisLogApi.i("ICGameLiveInfoResultCheckReport", "format:" + videoFormat + " playUrl:" + str);
        if (videoFormat == AudienceRoomConfig.VideoFormat.FLV) {
            if (!nu0.a.a(str)) {
                iAegisLogApi.a("ICGameLiveInfoResultCheckReport", 1, "url is err.\u5f53\u524d\u7684\u64ad\u653e\u5668\u7c7b\u578b\u662fFLV,\u4f46\u662f\u94fe\u63a5\u662f:" + str);
                return;
            }
            return;
        }
        if (videoFormat == AudienceRoomConfig.VideoFormat.RTMP && !nu0.a.b(str)) {
            iAegisLogApi.a("ICGameLiveInfoResultCheckReport", 1, "url is err.\u5f53\u524d\u7684\u64ad\u653e\u5668\u7c7b\u578b\u662fRTMP,\u4f46\u662f\u94fe\u63a5\u662f:" + str);
        }
    }
}
