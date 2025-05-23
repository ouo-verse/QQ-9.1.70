package com.tencent.mobileqq.gamecenter.protocols;

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
/* loaded from: classes12.dex */
public final class WebSSOAgent$UniSsoServerRsp extends MessageMicro<WebSSOAgent$UniSsoServerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "comm", "rspdata", "pbRsqData"}, new Object[]{0L, "", null, "", ByteStringMicro.EMPTY}, WebSSOAgent$UniSsoServerRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public final PBStringField rspdata = PBField.initString("");
    public final PBBytesField pbRsqData = PBField.initBytes(ByteStringMicro.EMPTY);
    public WebSSOAgent$UniSsoServerRspComm comm = new MessageMicro<WebSSOAgent$UniSsoServerRspComm>() { // from class: com.tencent.mobileqq.gamecenter.protocols.WebSSOAgent$UniSsoServerRspComm
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"delayms", "packagesize", "proctime"}, new Object[]{0, 0, 0}, WebSSOAgent$UniSsoServerRspComm.class);
        public final PBUInt32Field delayms = PBField.initUInt32(0);
        public final PBUInt32Field packagesize = PBField.initUInt32(0);
        public final PBInt32Field proctime = PBField.initInt32(0);
    };
}
