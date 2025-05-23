package com.tencent.trpcprotocol.qqstranger.common.common_system_msg;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes38.dex */
public final class CommonSystemMsgPB$InterativeNoticeMsg extends MessageMicro<CommonSystemMsgPB$InterativeNoticeMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40}, new String[]{"user_info", "scene_id", "target_user_info", "unread_num", "interact_timestamp"}, new Object[]{null, 0, null, 0, 0L}, CommonSystemMsgPB$InterativeNoticeMsg.class);
    public CommonSystemMsgPB$UserInfo user_info = new CommonSystemMsgPB$UserInfo();
    public final PBEnumField scene_id = PBField.initEnum(0);
    public CommonSystemMsgPB$UserInfo target_user_info = new CommonSystemMsgPB$UserInfo();
    public final PBInt32Field unread_num = PBField.initInt32(0);
    public final PBInt64Field interact_timestamp = PBField.initInt64(0);
}
