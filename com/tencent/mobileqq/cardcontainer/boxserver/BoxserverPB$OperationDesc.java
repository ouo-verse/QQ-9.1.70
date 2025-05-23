package com.tencent.mobileqq.cardcontainer.boxserver;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.qcircle.api.constant.QCircleScheme;

/* loaded from: classes11.dex */
public final class BoxserverPB$OperationDesc extends MessageMicro<BoxserverPB$OperationDesc> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"op_type", QCircleScheme.AttrQQPublish.ADVERTISE_BIZ_ID, "item_id"}, new Object[]{0, "", ""}, BoxserverPB$OperationDesc.class);
    public final PBEnumField op_type = PBField.initEnum(0);
    public final PBStringField biz_id = PBField.initString("");
    public final PBStringField item_id = PBField.initString("");
}
