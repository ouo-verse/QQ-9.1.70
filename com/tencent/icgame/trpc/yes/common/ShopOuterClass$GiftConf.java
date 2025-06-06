package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShopOuterClass$GiftConf extends MessageMicro<ShopOuterClass$GiftConf> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBInt32Field gift_id = PBField.initInt32(0);
    public final PBStringField gift_name = PBField.initString("");
    public final PBInt32Field money_type = PBField.initInt32(0);
    public final PBInt32Field gift_price = PBField.initInt32(0);
    public final PBStringField gift_icon = PBField.initString("");
    public final PBStringField resource_url = PBField.initString("");
    public final PBStringField banner_url = PBField.initString("");
    public final PBStringField digit_url = PBField.initString("");
    public final PBStringField desc_img = PBField.initString("");
    public final PBStringField desc_link = PBField.initString("");
    public final PBInt32Field desc_show_type = PBField.initInt32(0);
    public final PBBoolField desc_is_time_limit = PBField.initBool(false);
    public final PBUInt32Field desc_start_time = PBField.initUInt32(0);
    public final PBUInt32Field desc_end_time = PBField.initUInt32(0);
    public final PBBoolField is_free = PBField.initBool(false);
    public final PBBoolField is_show_in_bag = PBField.initBool(false);
    public final PBInt32Field count_down_time = PBField.initInt32(0);
    public final PBBoolField is_special_gift = PBField.initBool(false);
    public final PBStringField special_gift_url = PBField.initString("");
    public final PBInt32Field gift_value = PBField.initInt32(0);
    public final PBBoolField special_gift_to_see = PBField.initBool(false);
    public final PBInt32Field send_type = PBField.initInt32(0);

    static {
        Boolean bool = Boolean.FALSE;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 32, 42, 50, 58, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160, 168, 800}, new String[]{"gift_id", "gift_name", "money_type", "gift_price", "gift_icon", "resource_url", "banner_url", "digit_url", "desc_img", "desc_link", "desc_show_type", "desc_is_time_limit", "desc_start_time", "desc_end_time", "is_free", "is_show_in_bag", "count_down_time", "is_special_gift", "special_gift_url", "gift_value", "special_gift_to_see", "send_type"}, new Object[]{0, "", 0, 0, "", "", "", "", "", "", 0, bool, 0, 0, bool, bool, 0, bool, "", 0, bool, 0}, ShopOuterClass$GiftConf.class);
    }
}
