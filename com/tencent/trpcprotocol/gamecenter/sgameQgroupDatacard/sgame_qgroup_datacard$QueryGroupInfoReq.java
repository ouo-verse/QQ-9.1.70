package com.tencent.trpcprotocol.gamecenter.sgameQgroupDatacard;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class sgame_qgroup_datacard$QueryGroupInfoReq extends MessageMicro<sgame_qgroup_datacard$QueryGroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"groupId"}, new Object[]{0L}, sgame_qgroup_datacard$QueryGroupInfoReq.class);
    public final PBInt64Field groupId = PBField.initInt64(0);
}
