package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;

/* loaded from: classes.dex */
public final class INTERFACE$GetPrivacyInfoResponse extends MessageMicro<INTERFACE$GetPrivacyInfoResponse> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26}, new String[]{"ret_code", "need_pop_out", "privacy_info"}, new Object[]{0, 0, null}, INTERFACE$GetPrivacyInfoResponse.class);
    public final PBInt32Field ret_code = PBField.initInt32(0);
    public final PBInt32Field need_pop_out = PBField.initInt32(0);
    public INTERFACE$PrivacyInfo privacy_info = new INTERFACE$PrivacyInfo();
}
