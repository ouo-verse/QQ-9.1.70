package com.tencent.pb.profilecard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class SummaryCardBusiEntry$VisitorCountRsp extends MessageMicro<SummaryCardBusiEntry$VisitorCountRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48}, new String[]{"requireuin", "totalLike", "totalView", "hotValue", "redValue", "hotDiff"}, new Object[]{0, 0, 0, 0, 0, 0}, SummaryCardBusiEntry$VisitorCountRsp.class);
    public final PBUInt32Field requireuin = PBField.initUInt32(0);
    public final PBUInt32Field totalLike = PBField.initUInt32(0);
    public final PBUInt32Field totalView = PBField.initUInt32(0);
    public final PBUInt32Field hotValue = PBField.initUInt32(0);
    public final PBUInt32Field redValue = PBField.initUInt32(0);
    public final PBUInt32Field hotDiff = PBField.initUInt32(0);
}
