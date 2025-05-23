package com.tencent.qqprotect.common.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes25.dex */
public final class SafeReport$LogItem extends MessageMicro<SafeReport$LogItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"uint32_rpt_id", "bytes_rpt_data"}, new Object[]{0, ByteStringMicro.EMPTY}, SafeReport$LogItem.class);
    public final PBUInt32Field uint32_rpt_id = PBField.initUInt32(0);
    public final PBBytesField bytes_rpt_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
