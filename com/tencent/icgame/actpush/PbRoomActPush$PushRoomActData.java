package com.tencent.icgame.actpush;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes7.dex */
public final class PbRoomActPush$PushRoomActData extends MessageMicro<PbRoomActPush$PushRoomActData> {
    public static final int ACT_ID_FIELD_NUMBER = 1;
    public static final int DATA_FIELD_NUMBER = 3;
    public static final int MATCH_VER_FIELD_NUMBER = 4;
    public static final int OP_TYPE_FIELD_NUMBER = 5;
    public static final int ROOMID_FIELD_NUMBER = 2;
    public static final int VIEW_ID_FIELD_NUMBER = 6;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48}, new String[]{"act_id", "roomid", "data", "match_ver", "op_type", "view_id"}, new Object[]{0, 0, "", 0, 0, 0}, PbRoomActPush$PushRoomActData.class);
    public final PBUInt32Field act_id = PBField.initUInt32(0);
    public final PBUInt32Field roomid = PBField.initUInt32(0);
    public final PBStringField data = PBField.initString("");
    public final PBUInt32Field match_ver = PBField.initUInt32(0);
    public final PBUInt32Field op_type = PBField.initUInt32(0);
    public final PBUInt32Field view_id = PBField.initUInt32(0);
}
