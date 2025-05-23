package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserAppInfoRsp extends MessageMicro<INTERFACE$StGetUserAppInfoRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "userAppList"}, new Object[]{null, null}, INTERFACE$StGetUserAppInfoRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<INTERFACE$StUserAppInfo> userAppList = PBField.initRepeatMessage(INTERFACE$StUserAppInfo.class);
}
