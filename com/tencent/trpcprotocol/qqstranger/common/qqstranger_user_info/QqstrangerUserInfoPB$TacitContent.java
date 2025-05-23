package com.tencent.trpcprotocol.qqstranger.common.qqstranger_user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes38.dex */
public final class QqstrangerUserInfoPB$TacitContent extends MessageMicro<QqstrangerUserInfoPB$TacitContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"faq_type", "title", "options"}, new Object[]{0, "", null}, QqstrangerUserInfoPB$TacitContent.class);
    public final PBEnumField faq_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<QqstrangerUserInfoPB$TacitOption> options = PBField.initRepeatMessage(QqstrangerUserInfoPB$TacitOption.class);
}
