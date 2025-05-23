package feedcloud;

import com.heytap.databaseengine.apiv3.data.Element;
import com.huawei.hms.support.feature.result.CommonConstant;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes28.dex */
public final class FeedCloudMeta$StPoiInfoV2 extends MessageMicro<FeedCloudMeta$StPoiInfoV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 48, 58, 64, 72, 82, 90, 98, 106, 112, 120, 130, 138, 146, 154, 162}, new String[]{"poiId", "name", "poiType", "typeName", "address", "districtCode", "gps", Element.ELEMENT_NAME_DISTANCE, "hotValue", "phone", "country", "province", "city", "poiNum", "poiOrderType", "defaultName", "district", "dianPingId", "distanceText", CommonConstant.KEY_DISPLAY_NAME}, new Object[]{"", "", 0, "", "", 0, null, 0, 0, "", "", "", "", 0, 0, "", "", "", "", ""}, FeedCloudMeta$StPoiInfoV2.class);
    public final PBStringField poiId = PBField.initString("");
    public final PBStringField name = PBField.initString("");
    public final PBInt32Field poiType = PBField.initInt32(0);
    public final PBStringField typeName = PBField.initString("");
    public final PBStringField address = PBField.initString("");
    public final PBInt32Field districtCode = PBField.initInt32(0);
    public FeedCloudMeta$StGPSV2 gps = new FeedCloudMeta$StGPSV2();
    public final PBInt32Field distance = PBField.initInt32(0);
    public final PBInt32Field hotValue = PBField.initInt32(0);
    public final PBStringField phone = PBField.initString("");
    public final PBStringField country = PBField.initString("");
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBInt32Field poiNum = PBField.initInt32(0);
    public final PBInt32Field poiOrderType = PBField.initInt32(0);
    public final PBStringField defaultName = PBField.initString("");
    public final PBStringField district = PBField.initString("");
    public final PBStringField dianPingId = PBField.initString("");
    public final PBStringField distanceText = PBField.initString("");
    public final PBStringField displayName = PBField.initString("");
}
