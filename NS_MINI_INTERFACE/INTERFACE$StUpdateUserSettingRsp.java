package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StUpdateUserSettingRsp extends MessageMicro<INTERFACE$StUpdateUserSettingRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"extInfo"}, new Object[]{null}, INTERFACE$StUpdateUserSettingRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
}
