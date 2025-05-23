package com.tencent.icgame.trpc.qlive.trpc_user_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcUserInfoSvrOuterClass$BatchGetUserInfoReq extends MessageMicro<TrpcUserInfoSvrOuterClass$BatchGetUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"uids"}, new Object[]{0L}, TrpcUserInfoSvrOuterClass$BatchGetUserInfoReq.class);
    public final PBRepeatField<Long> uids = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
}
