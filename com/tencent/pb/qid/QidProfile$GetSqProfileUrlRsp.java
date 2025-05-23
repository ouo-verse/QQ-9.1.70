package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QidProfile$GetSqProfileUrlRsp extends MessageMicro<QidProfile$GetSqProfileUrlRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"url"}, new Object[]{""}, QidProfile$GetSqProfileUrlRsp.class);
    public final PBStringField url = PBField.initString("");
}
