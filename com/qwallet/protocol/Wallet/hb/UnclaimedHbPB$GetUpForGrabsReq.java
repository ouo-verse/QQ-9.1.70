package com.qwallet.protocol.Wallet.hb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes3.dex */
public final class UnclaimedHbPB$GetUpForGrabsReq extends MessageMicro<UnclaimedHbPB$GetUpForGrabsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"group_id"}, new Object[]{""}, UnclaimedHbPB$GetUpForGrabsReq.class);
    public final PBStringField group_id = PBField.initString("");
}
