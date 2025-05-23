package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$SendArkMsgReq extends MessageMicro<UserProxyCmdOuterClass$SendArkMsgReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"type", "info", "game_id"}, new Object[]{0, null, 0}, UserProxyCmdOuterClass$SendArkMsgReq.class);
    public final PBInt32Field type = PBField.initInt32(0);
    public UserProxyCmdOuterClass$ArkMsgInfo info = new MessageMicro<UserProxyCmdOuterClass$ArkMsgInfo>() { // from class: com.tencent.icgame.trpc.yes.common.UserProxyCmdOuterClass$ArkMsgInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"text_msg", "recv_info_list", "send_uin", "meta_json"}, new Object[]{"", null, 0L, ""}, UserProxyCmdOuterClass$ArkMsgInfo.class);
        public final PBStringField text_msg = PBField.initString("");
        public final PBRepeatMessageField<UserProxyCmdOuterClass$ArkMsgRecvInfo> recv_info_list = PBField.initRepeatMessage(UserProxyCmdOuterClass$ArkMsgRecvInfo.class);
        public final PBUInt64Field send_uin = PBField.initUInt64(0);
        public final PBStringField meta_json = PBField.initString("");
    };
    public final PBInt32Field game_id = PBField.initInt32(0);
}
