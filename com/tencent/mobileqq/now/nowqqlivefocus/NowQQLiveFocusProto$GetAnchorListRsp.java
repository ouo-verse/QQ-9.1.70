package com.tencent.mobileqq.now.nowqqlivefocus;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$GetAnchorListRsp extends MessageMicro<NowQQLiveFocusProto$GetAnchorListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"anchor_info", "ret_info"}, new Object[]{null, null}, NowQQLiveFocusProto$GetAnchorListRsp.class);
    public final PBRepeatMessageField<NowQQLiveFocusProto$AnchorInfo> anchor_info = PBField.initRepeatMessage(NowQQLiveFocusProto$AnchorInfo.class);
    public NowQQLiveFocusProto$RetInfo ret_info = new NowQQLiveFocusProto$RetInfo();
}
