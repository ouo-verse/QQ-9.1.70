package com.tencent.nowsummarycard;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class NowSummaryCard$NearbyMiniCardRsp extends MessageMicro<NowSummaryCard$NearbyMiniCardRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "err_msg", "mini_card"}, new Object[]{0, ByteStringMicro.EMPTY, null}, NowSummaryCard$NearbyMiniCardRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBBytesField err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<NowSummaryCard$MiniCard> mini_card = PBField.initRepeatMessage(NowSummaryCard$MiniCard.class);
}
