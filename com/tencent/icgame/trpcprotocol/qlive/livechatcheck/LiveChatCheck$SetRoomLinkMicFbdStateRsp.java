package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$SetRoomLinkMicFbdStateRsp extends MessageMicro<LiveChatCheck$SetRoomLinkMicFbdStateRsp> {
    public static final int ERR_MSG_FIELD_NUMBER = 3;
    public static final int FBD_REASON_FIELD_NUMBER = 4;
    public static final int OP_STATE_FIELD_NUMBER = 2;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"ret_code", "op_state", "err_msg", "fbd_reason"}, new Object[]{0, 0, "", 0}, LiveChatCheck$SetRoomLinkMicFbdStateRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBUInt32Field op_state = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field fbd_reason = PBField.initUInt32(0);
}
