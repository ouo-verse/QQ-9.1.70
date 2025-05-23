package com.tencent.trpcprotocol.kuolie.vas.dubhe;

import com.tencent.ark.ark;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class QVASDubhe$VASDubheAdRspModel extends MessageMicro<QVASDubhe$VASDubheAdRspModel> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"ad_id", ark.ARKMETADATA_JSON}, new Object[]{0, ""}, QVASDubhe$VASDubheAdRspModel.class);
    public final PBUInt32Field ad_id = PBField.initUInt32(0);
    public final PBStringField json = PBField.initString("");
}
