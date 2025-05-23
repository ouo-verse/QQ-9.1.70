package com.tencent.mobileqq.pb.qwallet;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes16.dex */
public final class PayGatewayProto$ErrDetail extends MessageMicro<PayGatewayProto$ErrDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 42}, new String[]{"retmsg", "err_style", "button_style", "buttons", "title"}, new Object[]{"", 0, 0, null, ""}, PayGatewayProto$ErrDetail.class);
    public final PBStringField retmsg = PBField.initString("");
    public final PBEnumField err_style = PBField.initEnum(0);
    public final PBEnumField button_style = PBField.initEnum(0);
    public final PBRepeatMessageField<PayGatewayProto$ButtonInfo> buttons = PBField.initRepeatMessage(PayGatewayProto$ButtonInfo.class);
    public final PBStringField title = PBField.initString("");
}
