package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.miniapp.widget.CanvasView;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$GetDressKeyRsp extends MessageMicro<AvatarDressInfo$GetDressKeyRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42, 50, 58, 66, 74, 80, 90, 98}, new String[]{"is_register_user", "dress_key", "gender", "male_avatar_character", "female_avatar_character", "male_default_avatar_character", "female_default_avatar_character", "male_default_dress_key", "female_default_dress_key", "update_time", "store_camera_cfg", "portal_bg_img"}, new Object[]{Boolean.FALSE, null, 0, null, null, null, null, null, null, 0L, null, ""}, AvatarDressInfo$GetDressKeyRsp.class);
    public final PBBoolField is_register_user = PBField.initBool(false);
    public AvatarDressInfo$DressKey dress_key = new AvatarDressInfo$DressKey();
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public AvatarDressInfo$AvatarCharacter male_avatar_character = new AvatarDressInfo$AvatarCharacter();
    public AvatarDressInfo$AvatarCharacter female_avatar_character = new AvatarDressInfo$AvatarCharacter();
    public AvatarDressInfo$AvatarCharacter male_default_avatar_character = new AvatarDressInfo$AvatarCharacter();
    public AvatarDressInfo$AvatarCharacter female_default_avatar_character = new AvatarDressInfo$AvatarCharacter();
    public AvatarDressInfo$DressKey male_default_dress_key = new AvatarDressInfo$DressKey();
    public AvatarDressInfo$DressKey female_default_dress_key = new AvatarDressInfo$DressKey();
    public final PBUInt64Field update_time = PBField.initUInt64(0);
    public AvatarDressInfo$StoreCameraCfg store_camera_cfg = new MessageMicro<AvatarDressInfo$StoreCameraCfg>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$StoreCameraCfg
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32, 40, 48, 58, 64, 74, 80, 88, 101, 104}, new String[]{"id", "group_id", "camera_name", CanvasView.ACTION_ROTATE, "auto_revert", "shoes_revert", "tag_1", "dynamic_shadow_distance_movable_light_1", "tag_2", "dynamic_shadow_distance_movable_light_2", "anim_type", "blend_time", "body_item_id"}, new Object[]{0, 0, "", 0, Boolean.FALSE, 0, "", 0, "", 0, 0, Float.valueOf(0.0f), 0}, AvatarDressInfo$StoreCameraCfg.class);

        /* renamed from: id, reason: collision with root package name */
        public final PBUInt32Field f106419id = PBField.initUInt32(0);
        public final PBUInt32Field group_id = PBField.initUInt32(0);
        public final PBStringField camera_name = PBField.initString("");
        public final PBUInt32Field rotate = PBField.initUInt32(0);
        public final PBBoolField auto_revert = PBField.initBool(false);
        public final PBUInt32Field shoes_revert = PBField.initUInt32(0);
        public final PBStringField tag_1 = PBField.initString("");
        public final PBUInt32Field dynamic_shadow_distance_movable_light_1 = PBField.initUInt32(0);
        public final PBStringField tag_2 = PBField.initString("");
        public final PBUInt32Field dynamic_shadow_distance_movable_light_2 = PBField.initUInt32(0);
        public final PBUInt32Field anim_type = PBField.initUInt32(0);
        public final PBFloatField blend_time = PBField.initFloat(0.0f);
        public final PBUInt32Field body_item_id = PBField.initUInt32(0);
    };
    public final PBStringField portal_bg_img = PBField.initString("");
}
