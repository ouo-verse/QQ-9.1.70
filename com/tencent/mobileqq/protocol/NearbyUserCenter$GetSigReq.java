package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoConstants;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyUserCenter$GetSigReq extends MessageMicro<NearbyUserCenter$GetSigReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32}, new String[]{ShortVideoConstants.FROM_UIN, "to_uin", "from_tiny_id", "to_tiny_id"}, new Object[]{0L, 0L, 0L, 0L}, NearbyUserCenter$GetSigReq.class);
    public final PBUInt64Field from_uin = PBField.initUInt64(0);
    public final PBUInt64Field to_uin = PBField.initUInt64(0);
    public final PBUInt64Field from_tiny_id = PBField.initUInt64(0);
    public final PBUInt64Field to_tiny_id = PBField.initUInt64(0);
}
