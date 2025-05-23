package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes7.dex */
public final class UserProxyCmdOuterClass$GetFansGroupRsp extends MessageMicro<UserProxyCmdOuterClass$GetFansGroupRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"group_data_list"}, new Object[]{null}, UserProxyCmdOuterClass$GetFansGroupRsp.class);
    public final PBRepeatMessageField<CommonOuterClass$GroupData> group_data_list = PBField.initRepeatMessage(CommonOuterClass$GroupData.class);
}
