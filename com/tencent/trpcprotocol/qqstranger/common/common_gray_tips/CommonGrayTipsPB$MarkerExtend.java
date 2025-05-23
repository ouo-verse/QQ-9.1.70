package com.tencent.trpcprotocol.qqstranger.common.common_gray_tips;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes38.dex */
public final class CommonGrayTipsPB$MarkerExtend extends MessageMicro<CommonGrayTipsPB$MarkerExtend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"marker_id", "level"}, new Object[]{0, 0L}, CommonGrayTipsPB$MarkerExtend.class);
    public final PBUInt32Field marker_id = PBField.initUInt32(0);
    public final PBUInt64Field level = PBField.initUInt64(0);
}
