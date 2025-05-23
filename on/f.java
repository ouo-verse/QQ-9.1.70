package on;

import com.qzone.common.account.LoginData;
import com.tencent.mobileqq.winkpublish.result.ImageResult;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import qzonemoment.QZMomentMeta$StGPSV2;
import qzonemoment.QZMomentMeta$StImage;
import qzonemoment.QZMomentMeta$StPoiInfo;

/* compiled from: P */
/* loaded from: classes38.dex */
public class f {
    public static String a() {
        String str = LoginData.getInstance().getUinString() + "_" + new SimpleDateFormat("MMddHHmmssSSS").format(new Date(System.currentTimeMillis())) + "_" + UUID.randomUUID();
        QLog.d("QZMPublish", 1, "traceId:" + str);
        return str;
    }

    public static QZMomentMeta$StImage b(ImageResult imageResult) {
        QZMomentMeta$StImage qZMomentMeta$StImage = new QZMomentMeta$StImage();
        qZMomentMeta$StImage.width.set(imageResult.getBigWidth());
        qZMomentMeta$StImage.height.set(imageResult.getBigHeight());
        qZMomentMeta$StImage.picUrl.set(imageResult.getBigUrl());
        return qZMomentMeta$StImage;
    }

    public static QZMomentMeta$StPoiInfo c(LbsDataV2.PoiInfo poiInfo) {
        QZMomentMeta$StPoiInfo qZMomentMeta$StPoiInfo = new QZMomentMeta$StPoiInfo();
        if (poiInfo == null) {
            return qZMomentMeta$StPoiInfo;
        }
        qZMomentMeta$StPoiInfo.poiId.set(String.valueOf(poiInfo.poiId));
        qZMomentMeta$StPoiInfo.name.set(String.valueOf(poiInfo.poiName));
        qZMomentMeta$StPoiInfo.poiType.set(poiInfo.poiType);
        qZMomentMeta$StPoiInfo.typeName.set(String.valueOf(poiInfo.poiTypeName));
        qZMomentMeta$StPoiInfo.defaultName.set(String.valueOf(poiInfo.poiDefaultName));
        qZMomentMeta$StPoiInfo.address.set(String.valueOf(poiInfo.address));
        qZMomentMeta$StPoiInfo.districtCode.set(poiInfo.districtCode);
        qZMomentMeta$StPoiInfo.distance.set(poiInfo.distance);
        qZMomentMeta$StPoiInfo.hotValue.set(poiInfo.hotValue);
        qZMomentMeta$StPoiInfo.phone.set(String.valueOf(poiInfo.phoneNumber));
        qZMomentMeta$StPoiInfo.poiOrderType.set(poiInfo.poiOrderType);
        qZMomentMeta$StPoiInfo.poiNum.set(poiInfo.poiNum);
        qZMomentMeta$StPoiInfo.dianPingId.set(String.valueOf(poiInfo.dianPingId));
        qZMomentMeta$StPoiInfo.country.set(String.valueOf(poiInfo.country));
        qZMomentMeta$StPoiInfo.province.set(String.valueOf(poiInfo.province));
        qZMomentMeta$StPoiInfo.city.set(String.valueOf(poiInfo.city));
        qZMomentMeta$StPoiInfo.district.set(String.valueOf(poiInfo.district));
        QZMomentMeta$StGPSV2 qZMomentMeta$StGPSV2 = new QZMomentMeta$StGPSV2();
        qZMomentMeta$StGPSV2.lat.set(poiInfo.gpsInfo.lat);
        qZMomentMeta$StGPSV2.lon.set(poiInfo.gpsInfo.lon);
        qZMomentMeta$StGPSV2.eType.set(poiInfo.gpsInfo.gpsType);
        qZMomentMeta$StGPSV2.alt.set(poiInfo.gpsInfo.alt);
        qZMomentMeta$StPoiInfo.gps.set(qZMomentMeta$StGPSV2);
        return qZMomentMeta$StPoiInfo;
    }
}
