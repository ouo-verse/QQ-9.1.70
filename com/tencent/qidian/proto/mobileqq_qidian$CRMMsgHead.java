package com.tencent.qidian.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class mobileqq_qidian$CRMMsgHead extends MessageMicro<mobileqq_qidian$CRMMsgHead> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64, 72, 80, 88}, new String[]{"uint32_crm_sub_cmd", "uint32_ver_no", "uint64_kf_uin", "uint32_seq", "uint32_pack_num", "uint32_cur_pack", "uint64_ext_uin", "uint64_puin", "uint64_kfaccount", "uint32_terminal_version", "uint32_terminal_type"}, new Object[]{0, 0, 0L, 0, 0, 0, 0L, 0L, 0L, 0, 0}, mobileqq_qidian$CRMMsgHead.class);
    public final PBUInt32Field uint32_crm_sub_cmd = PBField.initUInt32(0);
    public final PBUInt32Field uint32_ver_no = PBField.initUInt32(0);
    public final PBUInt64Field uint64_kf_uin = PBField.initUInt64(0);
    public final PBUInt32Field uint32_seq = PBField.initUInt32(0);
    public final PBUInt32Field uint32_pack_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_cur_pack = PBField.initUInt32(0);
    public final PBUInt64Field uint64_ext_uin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_puin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_kfaccount = PBField.initUInt64(0);
    public final PBUInt32Field uint32_terminal_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_terminal_type = PBField.initUInt32(0);
}
