package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import cooperation.qqcircle.report.datong.QCircleDaTongConstant;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$NearbyUserFollowReq extends MessageMicro<NowSummaryCard$NearbyUserFollowReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{"target_id", "id_type", QCircleDaTongConstant.ElementParamValue.OPERATION, "from"}, new Object[]{0L, 0, 0, 0}, NowSummaryCard$NearbyUserFollowReq.class);
    public final PBUInt64Field target_id = PBField.initUInt64(0);
    public final PBUInt32Field id_type = PBField.initUInt32(0);
    public final PBUInt32Field operation = PBField.initUInt32(0);
    public final PBUInt32Field from = PBField.initUInt32(0);
}
