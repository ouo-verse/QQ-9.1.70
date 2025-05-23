package com.tencent.biz.bmqq.protocol;

import com.heytap.databaseengine.type.DeviceType;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes2.dex */
public final class mobileqq_bmqq$CorpcardRspBody extends MessageMicro<mobileqq_bmqq$CorpcardRspBody> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42, 50, 58, 66, 74, 82, 88}, new String[]{"retInfo", "uint64_qquin", "uint64_kfuin", "nickname", "remarkname", "jobs", DeviceType.DeviceCategory.MOBILE, "phone", "email", "corpname", "flag"}, new Object[]{null, 0L, 0L, "", "", "", "", "", "", "", 0}, mobileqq_bmqq$CorpcardRspBody.class);
    public mobileqq_bmqq$RetInfo retInfo = new mobileqq_bmqq$RetInfo();
    public final PBUInt64Field uint64_qquin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_kfuin = PBField.initUInt64(0);
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField remarkname = PBField.initString("");
    public final PBStringField jobs = PBField.initString("");
    public final PBStringField mobile = PBField.initString("");
    public final PBStringField phone = PBField.initString("");
    public final PBStringField email = PBField.initString("");
    public final PBStringField corpname = PBField.initString("");
    public final PBUInt32Field flag = PBField.initUInt32(0);
}
