package com.tencent.mobileqq.qwallet.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import cooperation.qzone.remote.ServiceConst;

/* compiled from: P */
/* loaded from: classes16.dex */
public final class BindBank$QueryBindReq extends MessageMicro<BindBank$QueryBindReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{ServiceConst.PARA_SESSION_ID, "req_key", "bank_type", "agreement"}, new Object[]{"", "", "", null}, BindBank$QueryBindReq.class);
    public final PBStringField session_id = PBField.initString("");
    public final PBStringField req_key = PBField.initString("");
    public final PBStringField bank_type = PBField.initString("");
    public final PBRepeatMessageField<BindBank$ProtoFile> agreement = PBField.initRepeatMessage(BindBank$ProtoFile.class);
}
