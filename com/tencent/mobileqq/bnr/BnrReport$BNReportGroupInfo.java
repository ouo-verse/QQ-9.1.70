package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$BNReportGroupInfo extends MessageMicro<BnrReport$BNReportGroupInfo> {
    public static final int ID_FIELD_NUMBER = 1;
    public static final int SEQNO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"id", "seqno"}, new Object[]{0, 0}, BnrReport$BNReportGroupInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f200525id = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
}
