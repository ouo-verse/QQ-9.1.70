package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes3.dex */
public final class UnclaimedHbPB$GetUpForGrabsRsp extends MessageMicro<UnclaimedHbPB$GetUpForGrabsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"hb_aio_infos"}, new Object[]{null}, UnclaimedHbPB$GetUpForGrabsRsp.class);
    public final PBRepeatMessageField<UnclaimedHbPB$HbAioInfo> hb_aio_infos = PBField.initRepeatMessage(UnclaimedHbPB$HbAioInfo.class);
}
