package com.tencent.pb.funcall;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class VipFunCallAndRing$TSsoRsp extends MessageMicro<VipFunCallAndRing$TSsoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42, 50, 58, 66, 74}, new String[]{"i32_ret", "str_msg", "st_cmd0x1_rsp", "st_cmd0x2_rsp", "st_cmd0x3_rsp", "st_cmd0x4_rsp", "st_cmd0x5_rsp", "str_url", "str_act_wording"}, new Object[]{0, "", null, null, null, null, null, "", ""}, VipFunCallAndRing$TSsoRsp.class);
    public final PBInt32Field i32_ret = PBField.initInt32(0);
    public final PBStringField str_msg = PBField.initString("");
    public VipFunCallAndRing$TSsoCmd0x1Rsp st_cmd0x1_rsp = new VipFunCallAndRing$TSsoCmd0x1Rsp();
    public VipFunCallAndRing$TSsoCmd0x2Rsp st_cmd0x2_rsp = new VipFunCallAndRing$TSsoCmd0x2Rsp();
    public VipFunCallAndRing$TSsoCmd0x3Rsp st_cmd0x3_rsp = new MessageMicro<VipFunCallAndRing$TSsoCmd0x3Rsp>() { // from class: com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x3Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"u64_server_ver"}, new Object[]{0L}, VipFunCallAndRing$TSsoCmd0x3Rsp.class);
        public final PBUInt64Field u64_server_ver = PBField.initUInt64(0);
    };
    public VipFunCallAndRing$TSsoCmd0x4Rsp st_cmd0x4_rsp = new MessageMicro<VipFunCallAndRing$TSsoCmd0x4Rsp>() { // from class: com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x4Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"u64_server_ver"}, new Object[]{0L}, VipFunCallAndRing$TSsoCmd0x4Rsp.class);
        public final PBUInt64Field u64_server_ver = PBField.initUInt64(0);
    };
    public VipFunCallAndRing$TSsoCmd0x5Rsp st_cmd0x5_rsp = new MessageMicro<VipFunCallAndRing$TSsoCmd0x5Rsp>() { // from class: com.tencent.pb.funcall.VipFunCallAndRing$TSsoCmd0x5Rsp
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"u64_server_ver"}, new Object[]{0L}, VipFunCallAndRing$TSsoCmd0x5Rsp.class);
        public final PBUInt64Field u64_server_ver = PBField.initUInt64(0);
    };
    public final PBStringField str_url = PBField.initString("");
    public final PBStringField str_act_wording = PBField.initString("");
}
