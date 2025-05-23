package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$QueryGroupMemberInfoRsp extends MessageMicro<sgame_qgroup_datacard$QueryGroupMemberInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"memberList"}, new Object[]{null}, sgame_qgroup_datacard$QueryGroupMemberInfoRsp.class);
    public final PBRepeatMessageField<sgame_qgroup_datacard$GroupMemberInfo> memberList = PBField.initRepeatMessage(sgame_qgroup_datacard$GroupMemberInfo.class);
}
