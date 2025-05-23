package com.tencent.trpcprotocol.minibox.basicinfo;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes27.dex */
public final class VMBasicInfo$GetVMAppRecentPlayRsp extends MessageMicro<VMBasicInfo$GetVMAppRecentPlayRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"games"}, new Object[]{null}, VMBasicInfo$GetVMAppRecentPlayRsp.class);
    public final PBRepeatMessageField<VMBasicInfo$RecentGame> games = PBField.initRepeatMessage(VMBasicInfo$RecentGame.class);
}
