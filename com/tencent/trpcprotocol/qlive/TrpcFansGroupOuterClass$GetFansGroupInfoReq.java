package com.tencent.trpcprotocol.qlive;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class TrpcFansGroupOuterClass$GetFansGroupInfoReq extends MessageMicro<TrpcFansGroupOuterClass$GetFansGroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"anchor_uid"}, new Object[]{0L}, TrpcFansGroupOuterClass$GetFansGroupInfoReq.class);
    public final PBUInt64Field anchor_uid = PBField.initUInt64(0);
}
