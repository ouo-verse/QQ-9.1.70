package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.rich.node.Node;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$SetRoomInfoReq extends MessageMicro<RoomManager$SetRoomInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{AudienceReportConst.ROOM_ID, Node.ATTRS_ATTR}, new Object[]{0L, null}, RoomManager$SetRoomInfoReq.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBRepeatMessageField<RoomManager$TypeValue> attrs = PBField.initRepeatMessage(RoomManager$TypeValue.class);
}
