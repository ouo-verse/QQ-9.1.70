package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$RoomTag extends MessageMicro<RoomRcmd$RoomTag> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"tag_id", "tag_name"}, new Object[]{0, ""}, RoomRcmd$RoomTag.class);
    public final PBInt32Field tag_id = PBField.initInt32(0);
    public final PBStringField tag_name = PBField.initString("");
}
