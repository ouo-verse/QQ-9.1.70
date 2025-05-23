package com.tencent.jungle.weather.proto;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class weather$GetHotSearchRequest extends MessageMicro<weather$GetHotSearchRequest> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"types"}, new Object[]{0}, weather$GetHotSearchRequest.class);
    public final PBRepeatField<Integer> types = PBField.initRepeat(PBEnumField.__repeatHelper__);
}
