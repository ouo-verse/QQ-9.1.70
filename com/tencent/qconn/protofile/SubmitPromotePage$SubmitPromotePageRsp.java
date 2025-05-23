package com.tencent.qconn.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;

/* loaded from: classes22.dex */
public final class SubmitPromotePage$SubmitPromotePageRsp extends MessageMicro<SubmitPromotePage$SubmitPromotePageRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"result", "appid"}, new Object[]{null, 0L}, SubmitPromotePage$SubmitPromotePageRsp.class);
    public OpenSdkRecCommon$Result result = new OpenSdkRecCommon$Result();
    public final PBInt64Field appid = PBField.initInt64(0);
}
