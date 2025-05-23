package com.tencent.pb.emosm;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes22.dex */
public final class EmosmPb$SubCmd0x2ReqFetchTab extends MessageMicro<EmosmPb$SubCmd0x2ReqFetchTab> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16}, new String[]{"fixed32_timestamp", "int32_segment_flag"}, new Object[]{0, 0}, EmosmPb$SubCmd0x2ReqFetchTab.class);
    public final PBFixed32Field fixed32_timestamp = PBField.initFixed32(0);
    public final PBInt32Field int32_segment_flag = PBField.initInt32(0);
}
