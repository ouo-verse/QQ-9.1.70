package com.tencent.icgame.trpc.qlive.trpc_user_info_svr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class TrpcUserInfoSvrOuterClass$BatchGetUserInfoRsp extends MessageMicro<TrpcUserInfoSvrOuterClass$BatchGetUserInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"user_infos"}, new Object[]{null}, TrpcUserInfoSvrOuterClass$BatchGetUserInfoRsp.class);
    public final PBRepeatMessageField<TrpcUserInfoSvrOuterClass$UserBaseInfo> user_infos = PBField.initRepeatMessage(TrpcUserInfoSvrOuterClass$UserBaseInfo.class);
}
