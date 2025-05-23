package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.raft.codegenmeta.utils.Constants;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetExtConfigDetailReq extends MessageMicro<INTERFACE$StGetExtConfigDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", Constants.Configs.CONFIGS}, new Object[]{null, null}, INTERFACE$StGetExtConfigDetailReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StExtConfigInfo> configs = PBField.initRepeatMessage(INTERFACE$StExtConfigInfo.class);
}
