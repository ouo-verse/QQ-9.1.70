package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$AvatarCharacter extends MessageMicro<AvatarDressInfo$AvatarCharacter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40}, new String[]{"avatar_info", "face_info", "makeup_info", "color_info", "gender"}, new Object[]{null, null, null, null, 0}, AvatarDressInfo$AvatarCharacter.class);
    public AvatarDressInfo$AvatarInfo avatar_info = new MessageMicro<AvatarDressInfo$AvatarInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$AvatarInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"version", "slot_arr", "has_timelimit"}, new Object[]{0, null, Boolean.FALSE}, AvatarDressInfo$AvatarInfo.class);
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvatarDressInfo$SlotInfo> slot_arr = PBField.initRepeatMessage(AvatarDressInfo$SlotInfo.class);
        public final PBBoolField has_timelimit = PBField.initBool(false);
    };
    public AvatarDressInfo$FaceInfo face_info = new AvatarDressInfo$FaceInfo();
    public AvatarDressInfo$MakeupInfo makeup_info = new MessageMicro<AvatarDressInfo$MakeupInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$MakeupInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "slot_arr"}, new Object[]{0, null}, AvatarDressInfo$MakeupInfo.class);
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvatarDressInfo$SlotInfo> slot_arr = PBField.initRepeatMessage(AvatarDressInfo$SlotInfo.class);
    };
    public AvatarDressInfo$ColorInfo color_info = new MessageMicro<AvatarDressInfo$ColorInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$ColorInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"version", "slot_arr"}, new Object[]{0, null}, AvatarDressInfo$ColorInfo.class);
        public final PBUInt32Field version = PBField.initUInt32(0);
        public final PBRepeatMessageField<AvatarDressInfo$ColorSlotInfo> slot_arr = PBField.initRepeatMessage(AvatarDressInfo$ColorSlotInfo.class);
    };
    public final PBEnumField gender = PBField.initEnum(0);
}
