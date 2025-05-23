package com.tencent.mobileqq.bnr;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class BnrReport$BNReportConfig extends MessageMicro<BnrReport$BNReportConfig> {
    public static final int DICLIST_FIELD_NUMBER = 3;
    public static final int IDLIST_FIELD_NUMBER = 4;
    public static final int ID_FIELD_NUMBER = 1;
    public static final int SEQNO_FIELD_NUMBER = 2;
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 32}, new String[]{"id", "seqno", "dicList", "idList"}, new Object[]{0, 0, "", 0}, BnrReport$BNReportConfig.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f200524id = PBField.initUInt32(0);
    public final PBUInt32Field seqno = PBField.initUInt32(0);
    public final PBRepeatField<String> dicList = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBRepeatField<Integer> idList = PBField.initRepeat(PBUInt32Field.__repeatHelper__);
}
