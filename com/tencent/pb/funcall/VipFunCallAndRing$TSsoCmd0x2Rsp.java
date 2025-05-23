package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TSsoCmd0x2Rsp extends MessageMicro<VipFunCallAndRing$TSsoCmd0x2Rsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"i32_funcall_id", "i32_ring_id", "st_src_info"}, new Object[]{0, 0, null}, VipFunCallAndRing$TSsoCmd0x2Rsp.class);
    public final PBInt32Field i32_funcall_id = PBField.initInt32(0);
    public final PBInt32Field i32_ring_id = PBField.initInt32(0);
    public VipFunCallAndRing$TSourceInfo st_src_info = new VipFunCallAndRing$TSourceInfo();
}
