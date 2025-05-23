package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$GroupInfo extends MessageMicro<NowSummaryCard$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"group_id", "group_name"}, new Object[]{0L, ""}, NowSummaryCard$GroupInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField group_name = PBField.initString("");
}
