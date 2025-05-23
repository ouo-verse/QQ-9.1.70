package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$UserTags extends MessageMicro<userInfo$UserTags> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"open_id", "tag_ids"}, new Object[]{"", 0}, userInfo$UserTags.class);
    public final PBStringField open_id = PBField.initString("");
    public final PBRepeatField<Integer> tag_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
