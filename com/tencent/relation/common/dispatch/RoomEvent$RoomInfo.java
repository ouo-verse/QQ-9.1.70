package com.tencent.relation.common.dispatch;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.icgame.api.impl.room.report.AudienceReportConst;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.launcher.model.CrashRtInfoHolder;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class RoomEvent$RoomInfo extends MessageMicro<RoomEvent$RoomInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58}, new String[]{AudienceReportConst.ROOM_ID, "owner_uid", "uid_type", AudienceReportConst.ROOM_NAME, "room_logo", "game_info", ComicCancelRedPointPopItemData.JSON_KEY_TAGS}, new Object[]{0L, "", 0, "", "", null, null}, RoomEvent$RoomInfo.class);
    public final PBUInt64Field room_id = PBField.initUInt64(0);
    public final PBStringField owner_uid = PBField.initString("");
    public final PBUInt32Field uid_type = PBField.initUInt32(0);
    public final PBStringField room_name = PBField.initString("");
    public final PBStringField room_logo = PBField.initString("");
    public RoomEvent$GameInfo game_info = new MessageMicro<RoomEvent$GameInfo>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$GameInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"game_id", CrashRtInfoHolder.BeaconKey.GAME_NAME, "game_data", "game_ctrl"}, new Object[]{0, "", ByteStringMicro.EMPTY, null}, RoomEvent$GameInfo.class);
        public final PBInt32Field game_id = PBField.initInt32(0);
        public final PBStringField game_name = PBField.initString("");
        public final PBBytesField game_data = PBField.initBytes(ByteStringMicro.EMPTY);
        public RoomEvent$GameCtrl game_ctrl = new MessageMicro<RoomEvent$GameCtrl>() { // from class: com.tencent.relation.common.dispatch.RoomEvent$GameCtrl
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"game_versions", "room_types"}, new Object[]{null, 0}, RoomEvent$GameCtrl.class);
            public final PBRepeatMessageField<RoomEvent$GameVersion> game_versions = PBField.initRepeatMessage(RoomEvent$GameVersion.class);
            public final PBRepeatField<Integer> room_types = PBField.initRepeat(PBEnumField.__repeatHelper__);
        };
    };
    public final PBRepeatMessageField<RoomEvent$RoomTag> tags = PBField.initRepeatMessage(RoomEvent$RoomTag.class);
}
