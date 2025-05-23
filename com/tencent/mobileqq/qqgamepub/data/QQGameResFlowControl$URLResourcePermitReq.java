package com.tencent.mobileqq.qqgamepub.data;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes16.dex */
public final class QQGameResFlowControl$URLResourcePermitReq extends MessageMicro<QQGameResFlowControl$URLResourcePermitReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"resource_list", "scene_id"}, new Object[]{null, 0}, QQGameResFlowControl$URLResourcePermitReq.class);
    public final PBRepeatMessageField<QQGameResFlowControl$URLResourceItem> resource_list = PBField.initRepeatMessage(QQGameResFlowControl$URLResourceItem.class);
    public final PBInt32Field scene_id = PBField.initInt32(0);
}
