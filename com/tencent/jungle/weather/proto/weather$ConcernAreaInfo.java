package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$ConcernAreaInfo extends MessageMicro<weather$ConcernAreaInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"adcode", "hasWarning"}, new Object[]{0, Boolean.FALSE}, weather$ConcernAreaInfo.class);
    public final PBUInt32Field adcode = PBField.initUInt32(0);
    public final PBBoolField hasWarning = PBField.initBool(false);
}
