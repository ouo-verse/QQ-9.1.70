package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.mini.forward.ForwardMiniChooseFriendOption;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StBatchGetSchemaRsp extends MessageMicro<INTERFACE$StBatchGetSchemaRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", ForwardMiniChooseFriendOption.RESULT_LIST}, new Object[]{null, null}, INTERFACE$StBatchGetSchemaRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StSchemeResult> results = PBField.initRepeatMessage(INTERFACE$StSchemeResult.class);
}
