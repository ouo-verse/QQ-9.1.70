package com.tencent.trpcprotocol.sc_report.sso_data_recv.sso_data_recv;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes27.dex */
public final class DownloadApkReport$DownloadReply extends MessageMicro<DownloadApkReport$DownloadReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8}, new String[]{"error_code"}, new Object[]{0}, DownloadApkReport$DownloadReply.class);
    public final PBUInt32Field error_code = PBField.initUInt32(0);
}
