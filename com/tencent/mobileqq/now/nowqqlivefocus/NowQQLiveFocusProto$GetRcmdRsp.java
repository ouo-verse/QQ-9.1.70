package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetRcmdRsp extends MessageMicro<NowQQLiveFocusProto$GetRcmdRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"total_num", "info"}, new Object[]{0, null}, NowQQLiveFocusProto$GetRcmdRsp.class);
    public final PBUInt32Field total_num = PBField.initUInt32(0);
    public final PBRepeatMessageField<NowQQLiveFocusProto$RcmdAnchorInfo> info = PBField.initRepeatMessage(NowQQLiveFocusProto$RcmdAnchorInfo.class);
}
