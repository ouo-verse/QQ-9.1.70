package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$UpdateOrderStatusReport extends MessageMicro<ECSampleData$UpdateOrderStatusReport> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 58, 66, 72, 80}, new String[]{"uin", "order_id", "shop_id", "sku_id", "order_status", "terminate_reason", "related_feed_id", "related_room_id", "in_progress", "task_finished"}, new Object[]{"", "", "", "", 0, 0, "", "", 0, 0}, ECSampleData$UpdateOrderStatusReport.class);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField order_id = PBField.initString("");
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField sku_id = PBField.initString("");
    public final PBInt32Field order_status = PBField.initInt32(0);
    public final PBInt32Field terminate_reason = PBField.initInt32(0);
    public final PBStringField related_feed_id = PBField.initString("");
    public final PBStringField related_room_id = PBField.initString("");
    public final PBInt32Field in_progress = PBField.initInt32(0);
    public final PBInt32Field task_finished = PBField.initInt32(0);
}
