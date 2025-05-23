package com.tencent.ecommerce.repo.proto.ecom.qshop_sample_svr_sample_data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class ECSampleData$AbortReason extends MessageMicro<ECSampleData$AbortReason> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"reason_id", "msg"}, new Object[]{0, ""}, ECSampleData$AbortReason.class);
    public final PBUInt32Field reason_id = PBField.initUInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f105257msg = PBField.initString("");
}
