package NS_MINI_META;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StVersionAuditInfo extends MessageMicro<META_PROTOCOL$StVersionAuditInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50}, new String[]{"versionId", WadlProxyConsts.CREATE_TIME, "updateTime", "updateInstruction", "testAccount", "rejectReason"}, new Object[]{"", 0, 0, "", null, ""}, META_PROTOCOL$StVersionAuditInfo.class);
    public final PBStringField versionId = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
    public final PBStringField updateInstruction = PBField.initString("");
    public final PBRepeatMessageField<META_PROTOCOL$StTestAccount> testAccount = PBField.initRepeatMessage(META_PROTOCOL$StTestAccount.class);
    public final PBStringField rejectReason = PBField.initString("");
}
