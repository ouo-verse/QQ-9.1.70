package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.sqshow.zootopia.publish.ZPlanPublishSource;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$ReqJumpCheckRecmd extends MessageMicro<ServerApi$ReqJumpCheckRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74, 82}, new String[]{"uin", "source", "platform", "pkg_name", ZPlanPublishSource.FROM_SCHEME, "url", "action", "extra_info", "ref_source", "caller"}, new Object[]{0L, "", "", "", "", "", "", "", "", ""}, ServerApi$ReqJumpCheckRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField source = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBRepeatField<String> pkg_name = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField scheme = PBField.initString("");
    public final PBStringField url = PBField.initString("");
    public final PBStringField action = PBField.initString("");
    public final PBStringField extra_info = PBField.initString("");
    public final PBStringField ref_source = PBField.initString("");
    public final PBStringField caller = PBField.initString("");
}
