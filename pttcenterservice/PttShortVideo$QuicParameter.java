package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$QuicParameter extends MessageMicro<PttShortVideo$QuicParameter> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"uint32_enable_quic", "uint32_encryption_ver", "uint32_fec_ver"}, new Object[]{0, 1, 0}, PttShortVideo$QuicParameter.class);
    public final PBUInt32Field uint32_enable_quic = PBField.initUInt32(0);
    public final PBUInt32Field uint32_encryption_ver = PBField.initUInt32(1);
    public final PBUInt32Field uint32_fec_ver = PBField.initUInt32(0);
}
