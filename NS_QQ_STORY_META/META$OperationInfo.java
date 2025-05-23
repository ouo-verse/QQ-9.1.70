package NS_QQ_STORY_META;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class META$OperationInfo extends MessageMicro<META$OperationInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32}, new String[]{"extInfo", "opActionType", "opUser", "opTime"}, new Object[]{null, 1, null, 0}, META$OperationInfo.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBEnumField opActionType = PBField.initEnum(1);
    public META$StUser opUser = new META$StUser();
    public final PBUInt32Field opTime = PBField.initUInt32(0);
}
