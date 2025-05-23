package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$ClickReplyCmdActionReqBody extends MessageMicro<mobileqq_qidian$ClickReplyCmdActionReqBody> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBStringField str_key = PBField.initString("");
    public final PBUInt32Field uint32_type = PBField.initUInt32(0);
    public final PBBoolField bool_is_need_lbs = PBField.initBool(false);
    public final PBDoubleField double_latitude = PBField.initDouble(0.0d);
    public final PBDoubleField double_longitude = PBField.initDouble(0.0d);
    public final PBUInt32Field uint32_src_type = PBField.initUInt32(0);
    public final PBStringField str_menu_title = PBField.initString("");
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pubno = PBField.initUInt32(0);

    static {
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 33, 41, 48, 58, 64, 72}, new String[]{"str_key", "uint32_type", "bool_is_need_lbs", "double_latitude", "double_longitude", "uint32_src_type", "str_menu_title", "uint32_terminal_type", "uint32_pubno"}, new Object[]{"", 0, Boolean.FALSE, valueOf, valueOf, 0, "", 0, 0}, mobileqq_qidian$ClickReplyCmdActionReqBody.class);
    }
}
