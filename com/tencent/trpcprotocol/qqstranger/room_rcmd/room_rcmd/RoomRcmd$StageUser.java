package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$StageUser extends MessageMicro<RoomRcmd$StageUser> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"logo"}, new Object[]{""}, RoomRcmd$StageUser.class);
    public final PBStringField logo = PBField.initString("");
}
