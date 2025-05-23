package com.tencent.trpcprotocol.gamecenter.metadream;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class metadream_qgroup_datacard$SetGroupUserSwitchReq extends MessageMicro<metadream_qgroup_datacard$SetGroupUserSwitchReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"group_code", "status"}, new Object[]{0L, 0}, metadream_qgroup_datacard$SetGroupUserSwitchReq.class);
    public final PBUInt64Field group_code = PBField.initUInt64(0);
    public final PBEnumField status = PBField.initEnum(0);
}
