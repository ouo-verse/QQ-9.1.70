package com.tencent.mobileqq.mp;

import com.tencent.biz.pubaccount.api.IPublicAccountBrowser;
import com.tencent.biz.pubaccount.api.IPublicAccountMsgExtMrg;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes15.dex */
public final class mobileqq_mp$PAInfoElem extends MessageMicro<mobileqq_mp$PAInfoElem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58}, new String[]{IPublicAccountBrowser.KEY_PUB_UIN, "account_type", "index", "uin_seq", "time", "unread_num", IPublicAccountMsgExtMrg.PA_MSG_ID}, new Object[]{0L, 0, 0, 0L, 0L, 0, ""}, mobileqq_mp$PAInfoElem.class);
    public final PBUInt64Field puin = PBField.initUInt64(0);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBUInt32Field index = PBField.initUInt32(0);
    public final PBUInt64Field uin_seq = PBField.initUInt64(0);
    public final PBUInt64Field time = PBField.initUInt64(0);
    public final PBUInt32Field unread_num = PBField.initUInt32(0);
    public final PBStringField pa_msg_id = PBField.initString("");
}
