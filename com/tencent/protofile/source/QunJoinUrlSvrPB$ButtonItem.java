package com.tencent.protofile.source;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class QunJoinUrlSvrPB$ButtonItem extends MessageMicro<QunJoinUrlSvrPB$ButtonItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"wording", "jump_url", "tip"}, new Object[]{"", "", ""}, QunJoinUrlSvrPB$ButtonItem.class);
    public final PBStringField wording = PBField.initString("");
    public final PBStringField jump_url = PBField.initString("");
    public final PBStringField tip = PBField.initString("");
}
