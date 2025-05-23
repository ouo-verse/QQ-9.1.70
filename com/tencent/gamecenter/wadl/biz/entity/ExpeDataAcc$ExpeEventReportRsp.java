package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class ExpeDataAcc$ExpeEventReportRsp extends MessageMicro<ExpeDataAcc$ExpeEventReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"retInfo"}, new Object[]{null}, ExpeDataAcc$ExpeEventReportRsp.class);
    public ExpeDataAcc$RetInfo retInfo = new MessageMicro<ExpeDataAcc$RetInfo>() { // from class: com.tencent.gamecenter.wadl.biz.entity.ExpeDataAcc$RetInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"retCode", "retMsg"}, new Object[]{0, ""}, ExpeDataAcc$RetInfo.class);
        public final PBInt32Field retCode = PBField.initInt32(0);
        public final PBStringField retMsg = PBField.initString("");
    };
}
