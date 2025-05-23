package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$BatchGetUserTagsRsp extends MessageMicro<userInfo$BatchGetUserTagsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "user_tags"}, new Object[]{0, "", null}, userInfo$BatchGetUserTagsRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBRepeatMessageField<userInfo$UserTags> user_tags = PBField.initRepeatMessage(userInfo$UserTags.class);
}
