package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$GetDailyQuestionRsp extends MessageMicro<QqstrangerUserInfoPB$GetDailyQuestionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "tacit_faqs"}, new Object[]{0, "", null}, QqstrangerUserInfoPB$GetDailyQuestionRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<QqstrangerUserInfoPB$TacitFAQ> tacit_faqs = PBField.initRepeatMessage(QqstrangerUserInfoPB$TacitFAQ.class);
}
