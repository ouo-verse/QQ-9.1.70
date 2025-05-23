package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$GetGroupUserInfoReq extends MessageMicro<metadream_qgroup_datacard$GetGroupUserInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "to_uin"}, new Object[]{0L, 0L}, metadream_qgroup_datacard$GetGroupUserInfoReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
}
