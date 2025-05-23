package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$RoomInfo extends MessageMicro<RoomManager$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 64}, new String[]{AudienceReportConst.ROOM_ID, "owner_uid", "uid_type", "name", "logo", "game_info", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "room_type"}, new Object[]{0L, "", 0, "", "", null, null, 0}, RoomManager$RoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField owner_uid = PBField.initString("");
    public final PBUInt32Field uid_type = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public RoomManager$GameInfo game_info = new RoomManager$GameInfo();
    public final PBRepeatMessageField<RoomManager$RoomTag> tags = PBField.initRepeatMessage(RoomManager$RoomTag.class);
    public final PBEnumField room_type = PBField.initEnum(0);
}
