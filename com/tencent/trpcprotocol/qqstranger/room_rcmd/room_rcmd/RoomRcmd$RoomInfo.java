package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$RoomInfo extends MessageMicro<RoomRcmd$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 64}, new String[]{AudienceReportConst.ROOM_ID, "owner_uid", "uid_type", "name", "logo", "game_info", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "room_type"}, new Object[]{0L, "", 0, "", "", null, null, 0}, RoomRcmd$RoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField owner_uid = PBField.initString("");
    public final PBUInt32Field uid_type = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public RoomRcmd$GameInfo game_info = new MessageMicro<RoomRcmd$GameInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd.RoomRcmd$GameInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"game_type", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_data"}, new Object[]{0, "", ByteStringMicro.EMPTY}, RoomRcmd$GameInfo.class);
        public final PBInt32Field game_type = PBField.initInt32(0);
        public final PBStringField game_name = PBField.initString("");
        public final PBBytesField game_data = PBField.initBytes(ByteStringMicro.EMPTY);
    };
    public final PBRepeatMessageField<RoomRcmd$RoomTag> tags = PBField.initRepeatMessage(RoomRcmd$RoomTag.class);
    public final PBEnumField room_type = PBField.initEnum(0);
}
