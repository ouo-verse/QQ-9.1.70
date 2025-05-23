package com.tencent.ims;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class intchk$FetchCheckConfigRsp extends MessageMicro<intchk$FetchCheckConfigRsp> {
    public static final int RPT_MSG_CHECK_ITEM_FIELD_NUMBER = 3;
    public static final int UINT32_INTCHK_ID_FIELD_NUMBER = 2;
    public static final int UINT32_NEED_INTCHK_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"uint32_need_intchk", "uint32_intchk_id", "rpt_msg_check_item"}, new Object[]{0, 0, null}, intchk$FetchCheckConfigRsp.class);
    public final PBUInt32Field uint32_need_intchk = PBField.initUInt32(0);
    public final PBUInt32Field uint32_intchk_id = PBField.initUInt32(0);
    public final PBRepeatMessageField<intchk$CheckItem> rpt_msg_check_item = PBField.initRepeatMessage(intchk$CheckItem.class);
}
