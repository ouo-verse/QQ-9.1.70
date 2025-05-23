package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$BatchGetUserTagsReq extends MessageMicro<userInfo$BatchGetUserTagsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"open_ids", "tag_owner"}, new Object[]{"", 0}, userInfo$BatchGetUserTagsReq.class);
    public final PBRepeatField<String> open_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBEnumField tag_owner = PBField.initEnum(0);
}
