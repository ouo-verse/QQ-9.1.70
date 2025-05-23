package com.tencent.biz.qqcircle.tedgers2.bean.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.tedger.outapi.proto.TEdgeCommon$MapEntry;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class TEdgeItem$Item extends MessageMicro<TEdgeItem$Item> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 82, 88, 96, 106, 114, 120}, new String[]{"item_id", "attributes", "item_type", "item_source", "category", "sub_category", "physical_duration"}, new Object[]{"", null, 0, 0, "", "", 0}, TEdgeItem$Item.class);
    public final PBStringField item_id = PBField.initString("");
    public final PBRepeatMessageField<TEdgeCommon$MapEntry> attributes = PBField.initRepeatMessage(TEdgeCommon$MapEntry.class);
    public final PBEnumField item_type = PBField.initEnum(0);
    public final PBEnumField item_source = PBField.initEnum(0);
    public final PBStringField category = PBField.initString("");
    public final PBStringField sub_category = PBField.initString("");
    public final PBInt32Field physical_duration = PBField.initInt32(0);
}
