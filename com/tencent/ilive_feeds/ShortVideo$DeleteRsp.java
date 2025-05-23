package com.tencent.ilive_feeds;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ShortVideo$DeleteRsp extends MessageMicro<ShortVideo$DeleteRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"seq", "retcode"}, new Object[]{0, 0}, ShortVideo$DeleteRsp.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBInt32Field retcode = PBField.initInt32(0);
}
