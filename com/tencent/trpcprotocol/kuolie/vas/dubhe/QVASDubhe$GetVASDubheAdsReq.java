package com.tencent.trpcprotocol.kuolie.vas.dubhe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QVASDubhe$GetVASDubheAdsReq extends MessageMicro<QVASDubhe$GetVASDubheAdsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"ad_ids"}, new Object[]{0}, QVASDubhe$GetVASDubheAdsReq.class);
    public final PBRepeatField<Integer> ad_ids = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
