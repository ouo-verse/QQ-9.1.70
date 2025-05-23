package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserSettingRsp extends MessageMicro<INTERFACE$StGetUserSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "setting"}, new Object[]{null, null}, INTERFACE$StGetUserSettingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public INTERFACE$StUserSettingInfo setting = new INTERFACE$StUserSettingInfo();
}
