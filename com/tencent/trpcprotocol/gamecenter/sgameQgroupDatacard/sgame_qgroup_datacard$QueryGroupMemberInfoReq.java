package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.state.data.SquareJSConst;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$QueryGroupMemberInfoReq extends MessageMicro<sgame_qgroup_datacard$QueryGroupMemberInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"groupId", SquareJSConst.Params.PARAMS_UIN_LIST}, new Object[]{0L, 0L}, sgame_qgroup_datacard$QueryGroupMemberInfoReq.class);
    public final PBInt64Field groupId = PBField.initInt64(0);
    public final PBRepeatField<Long> uinList = PBField.initRepeat(PBInt64Field.__repeatHelper__);
}
