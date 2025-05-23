package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$LocationInfo extends MessageMicro<NowSummaryCard$LocationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"longitude", "latitude"}, new Object[]{0L, 0L}, NowSummaryCard$LocationInfo.class);
    public final PBInt64Field longitude = PBField.initInt64(0);
    public final PBInt64Field latitude = PBField.initInt64(0);
}
