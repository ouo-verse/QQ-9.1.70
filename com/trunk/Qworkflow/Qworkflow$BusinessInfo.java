package com.trunk.Qworkflow;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class Qworkflow$BusinessInfo extends MessageMicro<Qworkflow$BusinessInfo> {
    public static final int JIAXIAO_GROUP = 1;
    public static final int TIM_TODO = 2;
    public static final int UNDEFINED = 0;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"enum_busi_type", "bytes_userdef"}, new Object[]{0, ByteStringMicro.EMPTY}, Qworkflow$BusinessInfo.class);
    public final PBEnumField enum_busi_type = PBField.initEnum(0);
    public final PBBytesField bytes_userdef = PBField.initBytes(ByteStringMicro.EMPTY);
}
