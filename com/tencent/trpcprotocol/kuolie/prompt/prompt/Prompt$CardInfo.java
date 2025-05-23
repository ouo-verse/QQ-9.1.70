package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.trpcprotocol.kuolie.user_info.user_info.userInfo$MiniInfo;

/* loaded from: classes38.dex */
public final class Prompt$CardInfo extends MessageMicro<Prompt$CardInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 56}, new String[]{"content", "background", "mini_info", "card_type", "jump_url", "recm_trace", "emoji_id"}, new Object[]{"", "", null, 0, "", "", 0}, Prompt$CardInfo.class);
    public final PBStringField content = PBField.initString("");
    public final PBStringField background = PBField.initString("");
    public userInfo$MiniInfo mini_info = new userInfo$MiniInfo();
    public final PBEnumField card_type = PBField.initEnum(0);
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField recm_trace = PBField.initString("");
    public final PBUInt32Field emoji_id = PBField.initUInt32(0);
}
