package com.tencent.trpcprotocol.kuolie.vas.dubhe;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QVASDubhe$GetVASDubheAdsRsp extends MessageMicro<QVASDubhe$GetVASDubheAdsRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"ads"}, new Object[]{null}, QVASDubhe$GetVASDubheAdsRsp.class);
    public final PBRepeatMessageField<QVASDubhe$VASDubheAdRspModel> ads = PBField.initRepeatMessage(QVASDubhe$VASDubheAdRspModel.class);
}
