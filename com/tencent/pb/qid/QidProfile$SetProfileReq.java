package com.tencent.pb.qid;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qwallet.preload.IPreloadServiceProxy;

/* loaded from: classes22.dex */
public final class QidProfile$SetProfileReq extends MessageMicro<QidProfile$SetProfileReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"imgurl", "qid_type", "resource", IPreloadServiceProxy.KEY_RESID}, new Object[]{"", 0, "", 0}, QidProfile$SetProfileReq.class);
    public final PBStringField imgurl = PBField.initString("");
    public final PBInt32Field qid_type = PBField.initInt32(0);
    public final PBStringField resource = PBField.initString("");
    public final PBInt32Field res_id = PBField.initInt32(0);
}
