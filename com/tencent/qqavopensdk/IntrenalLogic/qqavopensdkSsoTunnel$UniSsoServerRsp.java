package com.tencent.qqavopensdk.IntrenalLogic;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class qqavopensdkSsoTunnel$UniSsoServerRsp extends MessageMicro<qqavopensdkSsoTunnel$UniSsoServerRsp> {
    public static final int COMM_FIELD_NUMBER = 3;
    public static final int ERRMSG_FIELD_NUMBER = 2;
    public static final int PBRSPDATA_FIELD_NUMBER = 5;
    public static final int RET_FIELD_NUMBER = 1;
    public static final int RSPDATA_FIELD_NUMBER = 4;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "comm", "rspdata", "pbRspData"}, new Object[]{0L, "", null, "", ByteStringMicro.EMPTY}, qqavopensdkSsoTunnel$UniSsoServerRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public qqavopensdkSsoTunnel$UniSsoServerRspComm comm = new MessageMicro<qqavopensdkSsoTunnel$UniSsoServerRspComm>() { // from class: com.tencent.qqavopensdk.IntrenalLogic.qqavopensdkSsoTunnel$UniSsoServerRspComm
        public static final int DELAYMS_FIELD_NUMBER = 1;
        public static final int PACKAGESIZE_FIELD_NUMBER = 2;
        public static final int PROCTIME_FIELD_NUMBER = 3;
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"delayms", "packagesize", "proctime"}, new Object[]{0, 0, 0}, qqavopensdkSsoTunnel$UniSsoServerRspComm.class);
        public final PBUInt32Field delayms = PBField.initUInt32(0);
        public final PBUInt32Field packagesize = PBField.initUInt32(0);
        public final PBInt32Field proctime = PBField.initInt32(0);
    };
    public final PBStringField rspdata = PBField.initString("");
    public final PBBytesField pbRspData = PBField.initBytes(ByteStringMicro.EMPTY);
}
