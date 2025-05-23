package com.tencent.ecommerce.repo.proto.ecom.common_qshop_common_order_common;

import com.heytap.databaseengine.apiv3.data.Element;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECOrderCommon$TimeRange extends MessageMicro<ECOrderCommon$TimeRange> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{Element.ELEMENT_NAME_START_TIMESTAMP, "end_timerange"}, new Object[]{0L, 0L}, ECOrderCommon$TimeRange.class);
    public final PBInt64Field start_timestamp = PBField.initInt64(0);
    public final PBInt64Field end_timerange = PBField.initInt64(0);
}
