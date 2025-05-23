package com.tencent.mobileqq.audiotrans;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class AudioTransCommon$NetAddr extends MessageMicro<AudioTransCommon$NetAddr> {
    public static final int PT_TCP = 1;
    public static final int PT_UDP = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{13, 16, 24, 37}, new String[]{"fixed32_IP", "uint32_port", "enum_proto_type", "fixed32_inner_IP"}, new Object[]{0, 0, 1, 0}, AudioTransCommon$NetAddr.class);
    public final PBFixed32Field fixed32_IP = PBField.initFixed32(0);
    public final PBUInt32Field uint32_port = PBField.initUInt32(0);
    public final PBEnumField enum_proto_type = PBField.initEnum(1);
    public final PBFixed32Field fixed32_inner_IP = PBField.initFixed32(0);
}
