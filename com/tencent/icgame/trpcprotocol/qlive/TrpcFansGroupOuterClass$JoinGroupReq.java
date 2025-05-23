package com.tencent.icgame.trpcprotocol.qlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcFansGroupOuterClass$JoinGroupReq extends MessageMicro<TrpcFansGroupOuterClass$JoinGroupReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"anchor_uid"}, new Object[]{0L}, TrpcFansGroupOuterClass$JoinGroupReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
}
