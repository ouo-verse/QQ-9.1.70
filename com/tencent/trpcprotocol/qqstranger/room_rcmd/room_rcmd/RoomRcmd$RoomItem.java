package com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qcircle.weseevideo.common.constants.QzoneCameraConst;
import com.tencent.qqlive.common.api.AegisLogger;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomRcmd$RoomItem extends MessageMicro<RoomRcmd$RoomItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34}, new String[]{AegisLogger.ROOM_INFO, "item_type", "stage_info", "roomExpand_info"}, new Object[]{null, 0, null, null}, RoomRcmd$RoomItem.class);
    public RoomRcmd$RoomInfo room_info = new RoomRcmd$RoomInfo();
    public final PBUInt32Field item_type = PBField.initUInt32(0);
    public RoomRcmd$StageInfo stage_info = new MessageMicro<RoomRcmd$StageInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd.RoomRcmd$StageInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24}, new String[]{"stage_user", "male_num", "female_num"}, new Object[]{null, 0L, 0L}, RoomRcmd$StageInfo.class);
        public final PBRepeatMessageField<RoomRcmd$StageUser> stage_user = PBField.initRepeatMessage(RoomRcmd$StageUser.class);
        public final PBUInt64Field male_num = PBField.initUInt64(0);
        public final PBUInt64Field female_num = PBField.initUInt64(0);
    };
    public RoomRcmd$RoomExpandInfo roomExpand_info = new MessageMicro<RoomRcmd$RoomExpandInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd.RoomRcmd$RoomExpandInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58}, new String[]{QzoneCameraConst.Tag.ARG_PARAM_MUSIC_NAME, "music_cover", "dynamic_cover", "color", "room_type_name", "sub_title", "icon_info"}, new Object[]{"", "", "", 0, "", "", null}, RoomRcmd$RoomExpandInfo.class);
        public final PBStringField music_name = PBField.initString("");
        public final PBStringField music_cover = PBField.initString("");
        public final PBStringField dynamic_cover = PBField.initString("");
        public final PBEnumField color = PBField.initEnum(0);
        public final PBStringField room_type_name = PBField.initString("");
        public final PBStringField sub_title = PBField.initString("");
        public RoomRcmd$IconInfo icon_info = new MessageMicro<RoomRcmd$IconInfo>() { // from class: com.tencent.trpcprotocol.qqstranger.room_rcmd.room_rcmd.RoomRcmd$IconInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"icon_style", "text", "pic_url"}, new Object[]{0, "", ""}, RoomRcmd$IconInfo.class);
            public final PBEnumField icon_style = PBField.initEnum(0);
            public final PBStringField text = PBField.initString("");
            public final PBStringField pic_url = PBField.initString("");
        };
    };
}
