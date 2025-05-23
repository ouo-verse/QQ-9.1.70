package com.tencent.jungle.videohub.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes7.dex */
public final class GroupRoomManageProto$GetGameStatusByGroupCodeReq extends MessageMicro<GroupRoomManageProto$GetGameStatusByGroupCodeReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"group_code"}, new Object[]{0L}, GroupRoomManageProto$GetGameStatusByGroupCodeReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
}
