package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$GetUserTacitHistoryRsp extends MessageMicro<userInfo$GetUserTacitHistoryRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"ret_code", "err_msg", "tacit_faqs", "total_num"}, new Object[]{0, "", null, 0}, userInfo$GetUserTacitHistoryRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<userInfo$TacitFAQ> tacit_faqs = PBField.initRepeatMessage(userInfo$TacitFAQ.class);
    public final PBUInt32Field total_num = PBField.initUInt32(0);
}
