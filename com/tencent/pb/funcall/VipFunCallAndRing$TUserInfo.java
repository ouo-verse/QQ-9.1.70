package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TUserInfo extends MessageMicro<VipFunCallAndRing$TUserInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{"i32_common_id", "i32_ring_id", "rpt_user_groups", "st_src_info"}, new Object[]{0, 0, null, null}, VipFunCallAndRing$TUserInfo.class);
    public final PBInt32Field i32_common_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public final PBRepeatMessageField<VipFunCallAndRing$TGroupInfo> rpt_user_groups = PBField.initRepeatMessage(VipFunCallAndRing$TGroupInfo.class);
    public VipFunCallAndRing$TSourceInfo st_src_info = new VipFunCallAndRing$TSourceInfo();
}
