package com.tencent.mobileqq.sharepanel.repo.pb;

import androidx.core.app.NotificationCompat;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes18.dex */
public final class ServicePB$GetShareInfoRsp extends MessageMicro<ServicePB$GetShareInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"info", "template_data", "plat_data", NotificationCompat.CATEGORY_ERROR}, new Object[]{null, "", "", null}, ServicePB$GetShareInfoRsp.class);
    public ServicePB$ShareInfo info = new ServicePB$ShareInfo();
    public final PBStringField template_data = PBField.initString("");
    public final PBStringField plat_data = PBField.initString("");
    public ServicePB$BusiErr err = new ServicePB$BusiErr();
}
