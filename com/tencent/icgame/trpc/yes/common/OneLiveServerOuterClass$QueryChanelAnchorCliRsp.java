package com.tencent.icgame.trpc.yes.common;

import com.tencent.intervideo.nowproxy.NowProxyConstants;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class OneLiveServerOuterClass$QueryChanelAnchorCliRsp extends MessageMicro<OneLiveServerOuterClass$QueryChanelAnchorCliRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{NowProxyConstants.AccountInfoKey.UID, "AnchorID", "RoomID"}, new Object[]{0L, 0L, 0L}, OneLiveServerOuterClass$QueryChanelAnchorCliRsp.class);
    public final PBUInt64Field UIN = PBField.initUInt64(0);
    public final PBUInt64Field AnchorID = PBField.initUInt64(0);
    public final PBUInt64Field RoomID = PBField.initUInt64(0);
}
