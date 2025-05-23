package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$GetBindURLRsp extends MessageMicro<BindBank$GetBindURLRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"url", "method", "body", "header", "req_key", ServiceConst.PARA_SESSION_ID}, new Object[]{"", "", "", "", "", ""}, BindBank$GetBindURLRsp.class);
    public final PBStringField url = PBField.initString("");
    public final PBStringField method = PBField.initString("");
    public final PBStringField body = PBField.initString("");
    public final PBStringField header = PBField.initString("");
    public final PBStringField req_key = PBField.initString("");
    public final PBStringField session_id = PBField.initString("");
}
