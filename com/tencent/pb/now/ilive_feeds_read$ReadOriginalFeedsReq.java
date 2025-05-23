package com.tencent.pb.now;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadOriginalFeedsReq extends MessageMicro<ilive_feeds_read$ReadOriginalFeedsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uid", "type"}, new Object[]{0L, 0}, ilive_feeds_read$ReadOriginalFeedsReq.class);
    public final PBUInt64Field uid = PBField.initUInt64(0);
    public final PBInt32Field type = PBField.initInt32(0);
}
