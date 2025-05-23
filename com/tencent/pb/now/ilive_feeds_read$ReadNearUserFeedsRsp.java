package com.tencent.pb.now;

import com.tencent.luggage.wxa.c8.c;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadNearUserFeedsRsp extends MessageMicro<ilive_feeds_read$ReadNearUserFeedsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 40, 48}, new String[]{"result", "err_msg", "end_flag", "infos", "total", c.G}, new Object[]{0, "", 0, null, 0, 0}, ilive_feeds_read$ReadNearUserFeedsRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field end_flag = PBField.initUInt32(0);
    public final PBRepeatMessageField<ilive_feeds_read$FeedsInfo> infos = PBField.initRepeatMessage(ilive_feeds_read$FeedsInfo.class);
    public final PBUInt32Field total = PBField.initUInt32(0);
    public final PBUInt32Field pos = PBField.initUInt32(0);
}
