package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$GiftInfo extends MessageMicro<NowSummaryCard$GiftInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"open_flag", "gift_info"}, new Object[]{0, ByteStringMicro.EMPTY}, NowSummaryCard$GiftInfo.class);
    public final PBUInt32Field open_flag = PBField.initUInt32(0);
    public final PBBytesField gift_info = PBField.initBytes(ByteStringMicro.EMPTY);
}
