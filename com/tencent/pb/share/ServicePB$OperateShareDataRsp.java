package com.tencent.pb.share;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class ServicePB$OperateShareDataRsp extends MessageMicro<ServicePB$OperateShareDataRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{NotificationCompat.CATEGORY_ERROR, "plat_data"}, new Object[]{null, ""}, ServicePB$OperateShareDataRsp.class);
    public ServicePB$BusiErr err = new ServicePB$BusiErr();
    public final PBStringField plat_data = PBField.initString("");
}
