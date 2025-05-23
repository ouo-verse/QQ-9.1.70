package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$OrderOperationRecord extends MessageMicro<ECOrderCommon$OrderOperationRecord> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50, 56, 66, 74, 82, 90}, new String[]{"id", "shop_id", "order_id", "update_timestamp", QCircleDaTongConstant.ElementParamValue.OPERATION, "operation_msg", "operation_scene", "trace_id", "operator_uid", "operator_staff", "operator_media_id"}, new Object[]{"", "", "", 0L, 0, "", 0, "", "", "", ""}, ECOrderCommon$OrderOperationRecord.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f105234id = PBField.initString("");
    public final PBStringField shop_id = PBField.initString("");
    public final PBStringField order_id = PBField.initString("");
    public final PBInt64Field update_timestamp = PBField.initInt64(0);
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBStringField operation_msg = PBField.initString("");
    public final PBUInt32Field operation_scene = PBField.initUInt32(0);
    public final PBStringField trace_id = PBField.initString("");
    public final PBStringField operator_uid = PBField.initString("");
    public final PBStringField operator_staff = PBField.initString("");
    public final PBStringField operator_media_id = PBField.initString("");
}
