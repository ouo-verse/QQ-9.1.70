package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$GetGiftListRsp extends MessageMicro<ShopOuterClass$GetGiftListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42}, new String[]{"gift_common_conf", "gift_list", "bag_list", "gift_conf_list", "gift_tag_conf_list"}, new Object[]{null, null, null, null, null}, ShopOuterClass$GetGiftListRsp.class);
    public ShopOuterClass$GiftCommonConf gift_common_conf = new MessageMicro<ShopOuterClass$GiftCommonConf>() { // from class: com.tencent.icgame.trpc.yes.common.ShopOuterClass$GiftCommonConf
        static final MessageMicro.FieldMap __fieldMap__;
        public final PBBoolField is_show_entry_red_dot = PBField.initBool(false);
        public final PBBoolField is_show_tab_red_dot = PBField.initBool(false);
        public final PBBoolField is_show_reserve_pos = PBField.initBool(false);
        public final PBInt32Field anchor_profit_rate = PBField.initInt32(0);
        public final PBInt32Field is_show_entry_bubble = PBField.initInt32(0);
        public final PBStringField gift_cd_error_msg = PBField.initString("");
        public final PBStringField gift_profit_text = PBField.initString("");
        public final PBStringField entry_bubble_text = PBField.initString("");
        public ShopOuterClass$GiftNumItemList num_config = new MessageMicro<ShopOuterClass$GiftNumItemList>() { // from class: com.tencent.icgame.trpc.yes.common.ShopOuterClass$GiftNumItemList
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, ShopOuterClass$GiftNumItemList.class);
            public final PBRepeatMessageField<ShopOuterClass$GiftNumItem> data = PBField.initRepeatMessage(ShopOuterClass$GiftNumItem.class);
        };
        public final PBStringField entry_bubble_new_gift_text = PBField.initString("");
        public final PBInt32Field banner_click_count_down_time = PBField.initInt32(0);
        public final PBBoolField sound_switch = PBField.initBool(false);
        public final PBStringField entry_animation_url = PBField.initString("");

        static {
            Boolean bool = Boolean.FALSE;
            __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 50, 58, 66, 74, 82, 88, 96, 106}, new String[]{"is_show_entry_red_dot", "is_show_tab_red_dot", "is_show_reserve_pos", "anchor_profit_rate", "is_show_entry_bubble", "gift_cd_error_msg", "gift_profit_text", "entry_bubble_text", "num_config", "entry_bubble_new_gift_text", "banner_click_count_down_time", "sound_switch", "entry_animation_url"}, new Object[]{bool, bool, bool, 0, 0, "", "", "", null, "", 0, bool, ""}, ShopOuterClass$GiftCommonConf.class);
        }
    };
    public ShopOuterClass$GiftListConfList gift_list = new MessageMicro<ShopOuterClass$GiftListConfList>() { // from class: com.tencent.icgame.trpc.yes.common.ShopOuterClass$GiftListConfList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"data"}, new Object[]{null}, ShopOuterClass$GiftListConfList.class);
        public final PBRepeatMessageField<ShopOuterClass$GiftListConf> data = PBField.initRepeatMessage(ShopOuterClass$GiftListConf.class);
    };
    public ShopOuterClass$UserBagList bag_list = new MessageMicro<ShopOuterClass$UserBagList>() { // from class: com.tencent.icgame.trpc.yes.common.ShopOuterClass$UserBagList
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"bag_items"}, new Object[]{null}, ShopOuterClass$UserBagList.class);
        public final PBRepeatMessageField<ShopOuterClass$UserBagItem> bag_items = PBField.initRepeatMessage(ShopOuterClass$UserBagItem.class);
    };
    public ShopOuterClass$GiftConfList gift_conf_list = new ShopOuterClass$GiftConfList();
    public ShopOuterClass$GiftTagConfList gift_tag_conf_list = new ShopOuterClass$GiftTagConfList();
}
