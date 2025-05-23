package pttcenterservice;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes29.dex */
public final class PttShortVideo$DataHole extends MessageMicro<PttShortVideo$DataHole> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"uint64_begin", "uint64_end"}, new Object[]{0L, 0L}, PttShortVideo$DataHole.class);
    public final PBUInt64Field uint64_begin = PBField.initUInt64(0);
    public final PBUInt64Field uint64_end = PBField.initUInt64(0);
}
