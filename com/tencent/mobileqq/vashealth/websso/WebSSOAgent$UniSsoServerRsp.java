package com.tencent.mobileqq.vashealth.websso;

import com.tencent.hippy.qq.utils.HippyReporter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes20.dex */
public final class WebSSOAgent$UniSsoServerRsp extends MessageMicro<WebSSOAgent$UniSsoServerRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"ret", HippyReporter.EXTRA_KEY_REPORT_ERRMSG, "comm", "rspdata", "pbRsqData"}, new Object[]{0L, "", null, "", ByteStringMicro.EMPTY}, WebSSOAgent$UniSsoServerRsp.class);
    public final PBInt64Field ret = PBField.initInt64(0);
    public final PBStringField errmsg = PBField.initString("");
    public WebSSOAgent$UniSsoServerRspComm comm = new WebSSOAgent$UniSsoServerRspComm();
    public final PBStringField rspdata = PBField.initString("");
    public final PBBytesField pbRsqData = PBField.initBytes(ByteStringMicro.EMPTY);
}
