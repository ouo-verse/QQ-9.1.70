package com.tencent.protofile.source;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes22.dex */
public final class QunJoinUrlSvrPB$GetInfoRsp extends MessageMicro<QunJoinUrlSvrPB$GetInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"items", "button"}, new Object[]{null, null}, QunJoinUrlSvrPB$GetInfoRsp.class);
    public final PBRepeatMessageField<QunSourceSvrPB$SourceItem> items = PBField.initRepeatMessage(QunSourceSvrPB$SourceItem.class);
    public QunJoinUrlSvrPB$ButtonItem button = new QunJoinUrlSvrPB$ButtonItem();
}
