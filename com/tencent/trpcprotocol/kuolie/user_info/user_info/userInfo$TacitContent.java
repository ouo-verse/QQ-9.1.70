package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$TacitContent extends MessageMicro<userInfo$TacitContent> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"faq_type", "title", "options"}, new Object[]{0, "", null}, userInfo$TacitContent.class);
    public final PBEnumField faq_type = PBField.initEnum(0);
    public final PBStringField title = PBField.initString("");
    public final PBRepeatMessageField<userInfo$TacitOption> options = PBField.initRepeatMessage(userInfo$TacitOption.class);
}
