package com.tencent.filament.zplanservice.pbjava.avatar_info;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFloatField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqmini.sdk.report.MiniAppReportManager2;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class AvatarDressInfo$SlotInfo extends MessageMicro<AvatarDressInfo$SlotInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 34, 42}, new String[]{MiniAppReportManager2.KEY_SLOT_ID, "item_id", "inst_id", "custom_data", "item_data"}, new Object[]{0, 0, 0L, null, null}, AvatarDressInfo$SlotInfo.class);
    public final PBUInt32Field slot_id = PBField.initUInt32(0);
    public final PBUInt32Field item_id = PBField.initUInt32(0);
    public final PBUInt64Field inst_id = PBField.initUInt64(0);
    public AvatarDressInfo$CustomSlotData custom_data = new MessageMicro<AvatarDressInfo$CustomSlotData>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$CustomSlotData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"color_config_id", "custom_color", "control_points", "ugc_id"}, new Object[]{0, 0, null, 0L}, AvatarDressInfo$CustomSlotData.class);
        public final PBUInt32Field color_config_id = PBField.initUInt32(0);
        public final PBInt32Field custom_color = PBField.initInt32(0);
        public final PBRepeatMessageField<AvatarDressInfo$FaceControlData> control_points = PBField.initRepeatMessage(AvatarDressInfo$FaceControlData.class);
        public final PBUInt64Field ugc_id = PBField.initUInt64(0);
    };
    public AvatarDressInfo$SlotItemData item_data = new MessageMicro<AvatarDressInfo$SlotItemData>() { // from class: com.tencent.filament.zplanservice.pbjava.avatar_info.AvatarDressInfo$SlotItemData
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 74, 85, 88, 98, 106, 114, 120, 130, 184, 192, 202, 210, 218, 226, 234, 242, 250, 258, 264, 274}, new String[]{"model", "model_full_dose", "override_material_slots", "override_material_assets", "animation_bp", "avatar_type", "additional_info", "shoe_height", "is_ugc", "color_tex", "normal_tex", "mask_tex", "offset_scale", "slot_name", "contain_avatars", "anim_group_id", "relax_head_nan", "relax_body_nan", "relax_head_nv", "relax_body_nv", "ugc_texture_path", "ugc_texture_cfg_path", "head_montage_path", "body_montage_path", "hide_glove_section", "ext_data"}, new Object[]{"", "", "", "", "", 0, "", Float.valueOf(0.0f), Boolean.FALSE, "", "", "", 0, "", 0, 0, "", "", "", "", "", "", "", "", 0, ""}, AvatarDressInfo$SlotItemData.class);
        public final PBStringField additional_info;
        public final PBUInt32Field anim_group_id;
        public final PBStringField animation_bp;
        public final PBUInt32Field avatar_type;
        public final PBStringField body_montage_path;
        public final PBStringField color_tex;
        public final PBRepeatField<Integer> contain_avatars;
        public final PBStringField ext_data;
        public final PBStringField head_montage_path;
        public final PBUInt32Field hide_glove_section;
        public final PBBoolField is_ugc;
        public final PBStringField mask_tex;
        public final PBStringField model = PBField.initString("");
        public final PBStringField model_full_dose = PBField.initString("");
        public final PBStringField normal_tex;
        public final PBRepeatField<Integer> offset_scale;
        public final PBRepeatField<String> override_material_assets;
        public final PBRepeatField<String> override_material_slots;
        public final PBRepeatField<String> relax_body_nan;
        public final PBRepeatField<String> relax_body_nv;
        public final PBRepeatField<String> relax_head_nan;
        public final PBRepeatField<String> relax_head_nv;
        public final PBFloatField shoe_height;
        public final PBStringField slot_name;
        public final PBStringField ugc_texture_cfg_path;
        public final PBStringField ugc_texture_path;

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.override_material_slots = PBField.initRepeat(pBStringField);
            this.override_material_assets = PBField.initRepeat(pBStringField);
            this.animation_bp = PBField.initString("");
            this.avatar_type = PBField.initUInt32(0);
            this.additional_info = PBField.initString("");
            this.shoe_height = PBField.initFloat(0.0f);
            this.is_ugc = PBField.initBool(false);
            this.color_tex = PBField.initString("");
            this.normal_tex = PBField.initString("");
            this.mask_tex = PBField.initString("");
            PBUInt32Field pBUInt32Field = PBUInt32Field.__repeatHelper__;
            this.offset_scale = PBField.initRepeat(pBUInt32Field);
            this.slot_name = PBField.initString("");
            this.contain_avatars = PBField.initRepeat(pBUInt32Field);
            this.anim_group_id = PBField.initUInt32(0);
            this.relax_head_nan = PBField.initRepeat(pBStringField);
            this.relax_body_nan = PBField.initRepeat(pBStringField);
            this.relax_head_nv = PBField.initRepeat(pBStringField);
            this.relax_body_nv = PBField.initRepeat(pBStringField);
            this.ugc_texture_path = PBField.initString("");
            this.ugc_texture_cfg_path = PBField.initString("");
            this.head_montage_path = PBField.initString("");
            this.body_montage_path = PBField.initString("");
            this.hide_glove_section = PBField.initUInt32(0);
            this.ext_data = PBField.initString("");
        }
    };
}
