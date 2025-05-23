package NS_CERTIFIED_ACCOUNT;

import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StGPSV2 extends MessageMicro<CertifiedAccountMeta$StGPSV2> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{QCircleSchemeAttr.Polymerize.LAT, "lon", "eType", QCircleSchemeAttr.Polymerize.ALT}, new Object[]{0L, 0L, 0L, 0L}, CertifiedAccountMeta$StGPSV2.class);
    public final PBInt64Field lat = PBField.initInt64(0);
    public final PBInt64Field lon = PBField.initInt64(0);
    public final PBInt64Field eType = PBField.initInt64(0);
    public final PBInt64Field alt = PBField.initInt64(0);
}
