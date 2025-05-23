package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$Tag extends MessageMicro<userInfo$Tag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50}, new String[]{"tag_id", "tag_name", "tag_icons", "same_tag_name", "tacit_name", "no_tacit_name"}, new Object[]{0, "", "", "", "", ""}, userInfo$Tag.class);
    public final PBUInt32Field tag_id = PBField.initUInt32(0);
    public final PBStringField tag_name = PBField.initString("");
    public final PBRepeatField<String> tag_icons = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField same_tag_name = PBField.initString("");
    public final PBStringField tacit_name = PBField.initString("");
    public final PBStringField no_tacit_name = PBField.initString("");
}
