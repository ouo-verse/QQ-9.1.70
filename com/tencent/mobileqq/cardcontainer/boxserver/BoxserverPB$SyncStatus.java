package com.tencent.mobileqq.cardcontainer.boxserver;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes11.dex */
public final class BoxserverPB$SyncStatus extends MessageMicro<BoxserverPB$SyncStatus> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"op_desc"}, new Object[]{null}, BoxserverPB$SyncStatus.class);
    public final PBRepeatMessageField<BoxserverPB$OperationDesc> op_desc = PBField.initRepeatMessage(BoxserverPB$OperationDesc.class);
}
