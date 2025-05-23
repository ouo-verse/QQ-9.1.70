package com.tencent.mobileqq.qqecommerce.repo.pbfile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.vashealth.api.impl.QQHealthReportApiImpl;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class sellerMsgConfig$MsgTypeItem extends MessageMicro<sellerMsgConfig$MsgTypeItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{QQHealthReportApiImpl.MSG_TYPE_KEY, "msg_name", "status", "enable_switch"}, new Object[]{0, "", 0, Boolean.FALSE}, sellerMsgConfig$MsgTypeItem.class);
    public final PBUInt32Field msg_type = PBField.initUInt32(0);
    public final PBStringField msg_name = PBField.initString("");
    public final PBUInt32Field status = PBField.initUInt32(0);
    public final PBBoolField enable_switch = PBField.initBool(false);
}
