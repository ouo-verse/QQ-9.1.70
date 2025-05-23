package com.tencent.trpcprotocol.qqva.gift_midground_panel.gift_midground_panel;

import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes27.dex */
public final class giftMidgroundPanel$GiftItem extends MessageMicro<giftMidgroundPanel$GiftItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 56, 66, 74, 106}, new String[]{"id", "name", ReportDataBuilder.KEY_PRODUCT_ID, "business_id", "material_item", "tag_item", "tag_valid_time", "desc", "business_infos", "batch_send_info"}, new Object[]{0L, "", "", "", null, null, 0L, "", null, null}, giftMidgroundPanel$GiftItem.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBInt64Field f381624id = PBField.initInt64(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField product_id = PBField.initString("");
    public final PBStringField business_id = PBField.initString("");
    public giftMidgroundPanel$ItemInfo material_item = new giftMidgroundPanel$ItemInfo();
    public giftMidgroundPanel$TagInfo tag_item = new giftMidgroundPanel$TagInfo();
    public final PBInt64Field tag_valid_time = PBField.initInt64(0);
    public final PBStringField desc = PBField.initString("");
    public final PBRepeatMessageField<giftMidgroundPanel$MapFieldEntry> business_infos = PBField.initRepeatMessage(giftMidgroundPanel$MapFieldEntry.class);
    public giftMidgroundPanel$BatchPackage batch_send_info = new giftMidgroundPanel$BatchPackage();
}
