package com.tencent.mobileqq.gamecenter.trpcprotocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes12.dex */
public final class SgamePartnerSvr$SendMsgRsp extends MessageMicro<SgamePartnerSvr$SendMsgRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"left_times", "ret"}, new Object[]{0L, 0}, SgamePartnerSvr$SendMsgRsp.class);
    public final PBInt64Field left_times = PBField.initInt64(0);
    public final PBInt32Field ret = PBField.initInt32(0);
}
