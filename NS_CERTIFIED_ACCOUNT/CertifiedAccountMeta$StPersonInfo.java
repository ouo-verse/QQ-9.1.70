package NS_CERTIFIED_ACCOUNT;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qzone.report.lp.LpReport_UserInfo_dc02148;

/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StPersonInfo extends MessageMicro<CertifiedAccountMeta$StPersonInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42}, new String[]{"sex", "birthday", LpReport_UserInfo_dc02148.CONSTELLATION, "school", "location"}, new Object[]{0, 0L, "", "", ""}, CertifiedAccountMeta$StPersonInfo.class);
    public final PBUInt32Field sex = PBField.initUInt32(0);
    public final PBUInt64Field birthday = PBField.initUInt64(0);
    public final PBStringField constellation = PBField.initString("");
    public final PBStringField school = PBField.initString("");
    public final PBStringField location = PBField.initString("");
}
