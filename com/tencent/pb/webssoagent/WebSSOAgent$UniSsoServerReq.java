package com.tencent.pb.webssoagent;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WebSSOAgent$UniSsoServerReq extends MessageMicro<WebSSOAgent$UniSsoServerReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"comm", "reqdata", "pbReqData"}, new Object[]{null, "", ByteStringMicro.EMPTY}, WebSSOAgent$UniSsoServerReq.class);
    public WebSSOAgent$UniSsoServerReqComm comm = new WebSSOAgent$UniSsoServerReqComm();
    public final PBStringField reqdata = PBField.initString("");
    public final PBBytesField pbReqData = PBField.initBytes(ByteStringMicro.EMPTY);
}
