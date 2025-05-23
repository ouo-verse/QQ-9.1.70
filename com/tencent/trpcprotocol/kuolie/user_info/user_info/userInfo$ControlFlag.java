package com.tencent.trpcprotocol.kuolie.user_info.user_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class userInfo$ControlFlag extends MessageMicro<userInfo$ControlFlag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"flag_id", "value", "wording", "document_config"}, new Object[]{0, 0, "", null}, userInfo$ControlFlag.class);
    public final PBUInt32Field flag_id = PBField.initUInt32(0);
    public final PBUInt32Field value = PBField.initUInt32(0);
    public final PBStringField wording = PBField.initString("");
    public userInfo$DocumentConfig document_config = new userInfo$DocumentConfig();
}
