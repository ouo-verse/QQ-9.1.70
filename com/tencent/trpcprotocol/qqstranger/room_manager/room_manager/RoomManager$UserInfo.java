package com.tencent.trpcprotocol.qqstranger.room_manager.room_manager;

import com.tencent.comic.data.ComicCancelRedPointPopItemData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class RoomManager$UserInfo extends MessageMicro<RoomManager$UserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 56, 66}, new String[]{"uid", "uid_type", "enter_ts", "heart_ts", "nick", "logo", "role", "user_ext"}, new Object[]{"", 0, 0L, 0L, "", "", 0, null}, RoomManager$UserInfo.class);
    public final PBStringField uid = PBField.initString("");
    public final PBUInt32Field uid_type = PBField.initUInt32(0);
    public final PBUInt64Field enter_ts = PBField.initUInt64(0);
    public final PBUInt64Field heart_ts = PBField.initUInt64(0);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBEnumField role = PBField.initEnum(0);
    public RoomManager$UserExt user_ext = new MessageMicro<RoomManager$UserExt>() { // from class: com.tencent.trpcprotocol.qqstranger.room_manager.room_manager.RoomManager$UserExt
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32}, new String[]{"gender", ComicCancelRedPointPopItemData.JSON_KEY_TAGS, "on_stage", "play_status"}, new Object[]{0, "", Boolean.FALSE, 0}, RoomManager$UserExt.class);
        public final PBUInt32Field gender = PBField.initUInt32(0);
        public final PBRepeatField<String> tags = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBBoolField on_stage = PBField.initBool(false);
        public final PBUInt32Field play_status = PBField.initUInt32(0);
    };
}
