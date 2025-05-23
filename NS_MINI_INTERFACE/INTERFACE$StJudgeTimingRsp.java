package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StJudgeTimingRsp extends MessageMicro<INTERFACE$StJudgeTimingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 42, 50}, new String[]{"extInfo", "timingTraceId", "nextDuration", "loginInstructions", "loginTraceId", "timingInstructions"}, new Object[]{null, "", 0, null, "", null}, INTERFACE$StJudgeTimingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField timingTraceId = PBField.initString("");
    public final PBInt32Field nextDuration = PBField.initInt32(0);
    public final PBRepeatMessageField<INTERFACE$GuardInstruction> loginInstructions = PBField.initRepeatMessage(INTERFACE$GuardInstruction.class);
    public final PBStringField loginTraceId = PBField.initString("");
    public final PBRepeatMessageField<INTERFACE$GuardInstruction> timingInstructions = PBField.initRepeatMessage(INTERFACE$GuardInstruction.class);
}
