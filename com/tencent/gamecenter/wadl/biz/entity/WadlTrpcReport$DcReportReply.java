package com.tencent.gamecenter.wadl.biz.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes6.dex */
public final class WadlTrpcReport$DcReportReply extends MessageMicro<WadlTrpcReport$DcReportReply> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24}, new String[]{"code", "msg", "succNum"}, new Object[]{0, "", 0}, WadlTrpcReport$DcReportReply.class);
    public final PBInt32Field code = PBField.initInt32(0);

    /* renamed from: msg, reason: collision with root package name */
    public final PBStringField f106745msg = PBField.initString("");
    public final PBInt32Field succNum = PBField.initInt32(0);
}
