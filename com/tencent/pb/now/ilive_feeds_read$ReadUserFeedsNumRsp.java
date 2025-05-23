package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadUserFeedsNumRsp extends MessageMicro<ilive_feeds_read$ReadUserFeedsNumRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"result", "err_msg", "total"}, new Object[]{0, "", 0}, ilive_feeds_read$ReadUserFeedsNumRsp.class);
    public final PBUInt32Field result = PBField.initUInt32(0);
    public final PBStringField err_msg = PBField.initString("");
    public final PBUInt32Field total = PBField.initUInt32(0);
}
