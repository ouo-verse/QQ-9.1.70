package com.tencent.mobileqq.reminder.pb;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes18.dex */
public final class BirthdayBlessingPB$TimeCallbackEvent extends MessageMicro<BirthdayBlessingPB$TimeCallbackEvent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 120}, new String[]{QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "pid", "uid", "schedule_time", "p_transparent", "u_transparent", Element.ELEMENT_NAME_TIMES}, new Object[]{"", "", "", 0L, "", "", 0L}, BirthdayBlessingPB$TimeCallbackEvent.class);
    public final PBStringField biz_id = PBField.initString("");
    public final PBStringField pid = PBField.initString("");
    public final PBStringField uid = PBField.initString("");
    public final PBInt64Field schedule_time = PBField.initInt64(0);
    public final PBStringField p_transparent = PBField.initString("");
    public final PBStringField u_transparent = PBField.initString("");
    public final PBUInt64Field times = PBField.initUInt64(0);
}
