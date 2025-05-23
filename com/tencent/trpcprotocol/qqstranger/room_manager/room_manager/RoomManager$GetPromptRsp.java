package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes27.dex */
public final class RoomManager$GetPromptRsp extends MessageMicro<RoomManager$GetPromptRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "room_prompt"}, new Object[]{0, "", null}, RoomManager$GetPromptRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public RoomManager$RoomPrompt room_prompt = new MessageMicro<RoomManager$RoomPrompt>() { // from class: com.tencent.trpcprotocol.qqstranger.room_manager.room_manager.RoomManager$RoomPrompt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"first_show", "content"}, new Object[]{Boolean.FALSE, ""}, RoomManager$RoomPrompt.class);
        public final PBBoolField first_show = PBField.initBool(false);
        public final PBStringField content = PBField.initString("");
    };
}
