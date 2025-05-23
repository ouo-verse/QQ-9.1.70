package l05;

import com.tencent.mobileqq.qqlive.api.IQQLiveSDK;
import com.tencent.mobileqq.qqlive.api.IQQLiveSDKManager;
import com.tencent.mobileqq.qqlive.api.config.QQLiveSDKConfigHelper;
import com.tencent.mobileqq.qqlive.data.record.QQLiveCurRoomInfo;
import com.tencent.mobileqq.qroute.QRoute;

/* compiled from: P */
/* loaded from: classes28.dex */
public class a {
    public static boolean a() {
        QQLiveCurRoomInfo curRoomInfo;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl == null || (curRoomInfo = sDKImpl.getCurRoomInfo()) == null || curRoomInfo.roomType != 1) {
            return false;
        }
        return true;
    }

    public static String b() {
        QQLiveCurRoomInfo curRoomInfo;
        IQQLiveSDK sDKImpl = ((IQQLiveSDKManager) QRoute.api(IQQLiveSDKManager.class)).getSDKImpl(QQLiveSDKConfigHelper.getQQLiveAppId());
        if (sDKImpl != null && (curRoomInfo = sDKImpl.getCurRoomInfo()) != null) {
            return String.valueOf(curRoomInfo.roomId);
        }
        return "";
    }

    public static String c() {
        return "571ab62646abd99881be652d3e250a39";
    }
}
