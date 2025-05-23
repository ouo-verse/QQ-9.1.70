package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$ExtensionReq extends MessageMicro<PttShortVideo$ExtensionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint32_sub_busi_type", "uint32_user_cnt"}, new Object[]{0, 0}, PttShortVideo$ExtensionReq.class);
    public final PBUInt32Field uint32_sub_busi_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_user_cnt = PBField.initUInt32(0);
}
