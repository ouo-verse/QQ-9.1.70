package com.tencent.trpcprotocol.qqlog.qqlog_server;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class QqlogServer$SsoReportRsp extends MessageMicro<QqlogServer$SsoReportRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"seq"}, new Object[]{0}, QqlogServer$SsoReportRsp.class);
    public final PBUInt32Field seq = PBField.initUInt32(0);
}
