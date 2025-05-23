package cooperation.qzone.webviewplugin.personalize;

import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.webviewplugin.MapUtil;
import java.util.Map;

/* loaded from: classes38.dex */
public class QZonePersonalizeH5Service {
    public static final String AVATAR_SP_KEY = "key_personalize_prefix_19";
    public static final String CARDDECORATE_SP_KEY = "key_personalize_prefix_18";
    public static final String CUSTOM_VIP_KEY = "key_personalize_prefix_23";
    public static final String FACADE_SP_KEY = "key_personalize_prefix_20";
    public static final String FLOATOBJECT_SP_KEY = "key_personalize_prefix_21";
    private static final String KEY_PERSONALIZE_PREFIX = "key_personalize_prefix";
    public static final String NAVIDECO_SP_KEY = "key_personalize_prefix_22";
    private static final String QZONE_MALL_CLICK_TIME_MAP_KEY = "CTIME_MAP";
    private static final int mAvatarId = 19;
    private static final int mCardId = 18;
    private static final int mCustomVip = 23;
    private static final int mFacadeId = 20;
    private static final int mFloatObjectId = 21;
    private static final int mNaviDeco = 22;

    public static Map<Integer, Long> getCTime(Long l3) {
        return getCTimeByUin(l3.longValue());
    }

    private static Map<Integer, Long> getCTimeByUin(long j3) {
        Map<Integer, Long> stringToMap = MapUtil.stringToMap(LocalMultiProcConfig.getString(QZONE_MALL_CLICK_TIME_MAP_KEY + j3, ""));
        if (!stringToMap.containsKey(0)) {
            stringToMap.put(0, 0L);
        }
        return stringToMap;
    }

    public static void setCTime(Map<Integer, Long> map, Long l3) {
        LocalMultiProcConfig.putString(QZONE_MALL_CLICK_TIME_MAP_KEY + l3, MapUtil.mapToString(map));
    }

    public static void updateCTime(Integer num, Long l3) {
        Map<Integer, Long> cTime = getCTime(l3);
        cTime.put(num, Long.valueOf(System.currentTimeMillis() / 1000));
        if (QLog.isColorLevel()) {
            QLog.d("QZonePersonalizeH5Service", 2, "updateCTime: " + num + "timestamp: " + (System.currentTimeMillis() / 1000));
        }
        setCTime(cTime, l3);
    }
}
