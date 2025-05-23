package com.tencent.trpcprotocol.minigame.basicaudit;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;

/* compiled from: P */
/* loaded from: classes38.dex */
public final class ReportLaunchEventReq extends MessageMicro<ReportLaunchEventReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"report_data"}, new Object[]{ByteStringMicro.EMPTY}, ReportLaunchEventReq.class);
    public final PBBytesField report_data = PBField.initBytes(ByteStringMicro.EMPTY);
}
