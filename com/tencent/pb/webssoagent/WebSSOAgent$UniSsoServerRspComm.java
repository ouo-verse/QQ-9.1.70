package com.tencent.pb.webssoagent;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class WebSSOAgent$UniSsoServerRspComm extends MessageMicro<WebSSOAgent$UniSsoServerRspComm> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"delayms", "packagesize", "proctime"}, new Object[]{0, 0, 0}, WebSSOAgent$UniSsoServerRspComm.class);
    public final PBUInt32Field delayms = PBField.initUInt32(0);
    public final PBUInt32Field packagesize = PBField.initUInt32(0);
    public final PBInt32Field proctime = PBField.initInt32(0);
}
