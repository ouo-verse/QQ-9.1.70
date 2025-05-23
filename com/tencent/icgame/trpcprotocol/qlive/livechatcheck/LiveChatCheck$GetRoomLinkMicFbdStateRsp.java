package com.tencent.icgame.trpcprotocol.qlive.livechatcheck;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class LiveChatCheck$GetRoomLinkMicFbdStateRsp extends MessageMicro<LiveChatCheck$GetRoomLinkMicFbdStateRsp> {
    public static final int LINK_STATE_FIELD_NUMBER = 2;
    public static final int OP_STATE_FIELD_NUMBER = 3;
    public static final int RET_CODE_FIELD_NUMBER = 1;
    public static final int USER_UID_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"ret_code", "link_state", "op_state", "user_uid"}, new Object[]{0, 0, 0, 0L}, LiveChatCheck$GetRoomLinkMicFbdStateRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBUInt32Field link_state = PBField.initUInt32(0);
    public final PBUInt32Field op_state = PBField.initUInt32(0);
    public final PBUInt64Field user_uid = PBField.initUInt64(0);
}
