package NS_MINI_INTERFACE;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.transfile.CarrierImgDownloader;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CONTAINER_INTERFACE$UserInfo extends MessageMicro<CONTAINER_INTERFACE$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 32, 40}, new String[]{"province", "city", QCircleSchemeAttr.Polymerize.LAT, "lon", CarrierImgDownloader.PROTOCAL_CARRIER_IMG}, new Object[]{"", "", 0, 0, 0}, CONTAINER_INTERFACE$UserInfo.class);
    public final PBStringField province = PBField.initString("");
    public final PBStringField city = PBField.initString("");
    public final PBInt32Field lat = PBField.initInt32(0);
    public final PBInt32Field lon = PBField.initInt32(0);
    public final PBInt32Field carrier = PBField.initInt32(0);
}
