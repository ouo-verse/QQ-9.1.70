package com.tencent.filament.zplanservice.pbjava.wowoconn;

import com.tencent.filament.zplanservice.pbjava.huateng.HuatengSvr$FlowerData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qqlive.common.api.AegisLogger;
import com.tencent.qzonehub.api.webview.IQzoneWebViewPluginHelper;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WowoConnMapServer$GetBlockInfoRsp extends MessageMicro<WowoConnMapServer$GetBlockInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"map_field"}, new Object[]{null}, WowoConnMapServer$GetBlockInfoRsp.class);
    public WowoConnMapServer$BlockInfo map_field = new MessageMicro<WowoConnMapServer$BlockInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnMapServer$BlockInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{24, 34, 42, 50, 58}, new String[]{"block_type", "minixw_info", "effect_res", "facility_res", "effect_res_list"}, new Object[]{0, null, "", "", ""}, WowoConnMapServer$BlockInfo.class);
        public final PBEnumField block_type = PBField.initEnum(0);
        public WowoConnMapServer$MiniXwInfo minixw_info = new MessageMicro<WowoConnMapServer$MiniXwInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnMapServer$MiniXwInfo
            static final MessageMicro.FieldMap __fieldMap__;
            public final PBUInt64Field uin = PBField.initUInt64(0);
            public WowoConnEmtity$TextDesc nick_name = new WowoConnEmtity$TextDesc();
            public final PBStringField status = PBField.initString("");
            public final PBEnumField relationship_type = PBField.initEnum(0);
            public final PBUInt64Field relationship_value = PBField.initUInt64(0);
            public final PBStringField dress_jump_url = PBField.initString("");
            public final PBStringField relationship_jump_url = PBField.initString("");
            public final PBStringField room_info = PBField.initString("");
            public final PBStringField avatar_info = PBField.initString("");
            public WowoConnEmtity$DoorPlate door_plate_info = new WowoConnEmtity$DoorPlate();
            public WowoConnEmtity$BubbleInfo collection_info = new MessageMicro<WowoConnEmtity$BubbleInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$BubbleInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"token", "icon_res", "anim_res", "click_anim_res"}, new Object[]{0, "", "", ""}, WowoConnEmtity$BubbleInfo.class);
                public final PBInt32Field token = PBField.initInt32(0);
                public final PBStringField icon_res = PBField.initString("");
                public final PBStringField anim_res = PBField.initString("");
                public final PBStringField click_anim_res = PBField.initString("");
            };
            public WowoConnEmtity$GiftInfo gift_info = new MessageMicro<WowoConnEmtity$GiftInfo>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$GiftInfo
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"token", "gift_res", "gift_anim"}, new Object[]{0, "", ""}, WowoConnEmtity$GiftInfo.class);
                public final PBInt32Field token = PBField.initInt32(0);
                public final PBStringField gift_res = PBField.initString("");
                public final PBStringField gift_anim = PBField.initString("");
            };
            public final PBBoolField is_dragon_year_logo = PBField.initBool(false);
            public final PBBoolField is_create_mini_xw = PBField.initBool(false);
            public final PBStringField avatar_anim_single = PBField.initString("");
            public WowoConnEmtity$MutualMark mutual_mark_info = new MessageMicro<WowoConnEmtity$MutualMark>() { // from class: com.tencent.filament.zplanservice.pbjava.wowoconn.WowoConnEmtity$MutualMark
                static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"icon_res", "icon_url"}, new Object[]{"", ""}, WowoConnEmtity$MutualMark.class);
                public final PBStringField icon_res = PBField.initString("");
                public final PBStringField icon_url = PBField.initString("");
            };
            public final PBBoolField is_friend = PBField.initBool(false);
            public final PBUInt64Field enter_room_id = PBField.initUInt64(0);
            public HuatengSvr$FlowerData flower_data = new HuatengSvr$FlowerData();

            static {
                String[] strArr = {"uin", IQzoneWebViewPluginHelper.EXTRA_FAMOUS_SHARE_NICKNAME, "status", "relationship_type", "relationship_value", "dress_jump_url", "relationship_jump_url", AegisLogger.ROOM_INFO, "avatar_info", "door_plate_info", "collection_info", "gift_info", "is_dragon_year_logo", "is_create_mini_xw", "avatar_anim_single", "mutual_mark_info", "is_friend", "enter_room_id", "flower_data"};
                Boolean bool = Boolean.FALSE;
                __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 50, 58, 66, 74, 82, 90, 98, 104, 112, 122, 130, 136, 144, 154}, strArr, new Object[]{0L, null, "", 0, 0L, "", "", "", "", null, null, null, bool, bool, "", null, bool, 0L, null}, WowoConnMapServer$MiniXwInfo.class);
            }
        };
        public final PBStringField effect_res = PBField.initString("");
        public final PBStringField facility_res = PBField.initString("");
        public final PBRepeatField<String> effect_res_list = PBField.initRepeat(PBStringField.__repeatHelper__);
    };
}
