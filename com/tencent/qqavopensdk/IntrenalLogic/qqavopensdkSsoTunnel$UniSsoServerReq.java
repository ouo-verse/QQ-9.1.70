package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.thumbplayer.report.reportv1.TPReportKeys;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$UniSsoServerReq extends MessageMicro<qqavopensdkSsoTunnel$UniSsoServerReq> {
    public static final int COMM_FIELD_NUMBER = 1;
    public static final int PBREQDATA_FIELD_NUMBER = 3;
    public static final int REQDATA_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"comm", "reqdata", "pbReqData"}, new Object[]{null, "", ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$UniSsoServerReq.class);
    public qqavopensdkSsoTunnel$UniSsoServerReqComm comm = new MessageMicro<qqavopensdkSsoTunnel$UniSsoServerReqComm>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$UniSsoServerReqComm
        public static final int MQQVER_FIELD_NUMBER = 3;
        public static final int OSVER_FIELD_NUMBER = 2;
        public static final int PLATFORM_FIELD_NUMBER = 1;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"platform", TPReportKeys.Common.COMMON_OS_VERSION, "mqqver"}, new Object[]{0L, "", ""}, qqavopensdkSsoTunnel$UniSsoServerReqComm.class);
        public final PBInt64Field platform = PBField.initInt64(0);
        public final PBStringField osver = PBField.initString("");
        public final PBStringField mqqver = PBField.initString("");
    };
    public final PBStringField reqdata = PBField.initString("");
    public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}
