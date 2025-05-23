package com.tencent.trpcprotocol.kuolie.prompt.prompt;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes38.dex */
public final class Prompt$GetHomePageOfficeAnnouncementRsp extends MessageMicro<Prompt$GetHomePageOfficeAnnouncementRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 42, 48, 56}, new String[]{"ret_code", "homepage_rule", "homepage_name", "user_state", "experiment_group", "online_num"}, new Object[]{0, "", "", null, 0, 0L}, Prompt$GetHomePageOfficeAnnouncementRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBRepeatField<String> homepage_rule = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField homepage_name = PBField.initString("");
    public Prompt$UserState user_state = new MessageMicro<Prompt$UserState>() { // from class: com.tencent.trpcprotocol.kuolie.prompt.prompt.Prompt$UserState
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"state_id", "is_history_setted"}, new Object[]{0, Boolean.FALSE}, Prompt$UserState.class);
        public final PBUInt32Field state_id = PBField.initUInt32(0);
        public final PBBoolField is_history_setted = PBField.initBool(false);
    };
    public final PBEnumField experiment_group = PBField.initEnum(0);
    public final PBInt64Field online_num = PBField.initInt64(0);
}
