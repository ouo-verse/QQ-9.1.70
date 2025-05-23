package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$InterestTagInfo extends MessageMicro<NowSummaryCard$InterestTagInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"flag", "tag_info"}, new Object[]{0, ByteStringMicro.EMPTY}, NowSummaryCard$InterestTagInfo.class);
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBBytesField tag_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
