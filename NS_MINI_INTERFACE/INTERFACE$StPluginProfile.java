package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class INTERFACE$StPluginProfile extends MessageMicro<INTERFACE$StPluginProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 64, 72}, new String[]{"plugin_id", "download_domain", "request_domain", "wsrequest_domain", "upload_domain", "host_sign", "noncestr", "timestamp", "running_flag_info"}, new Object[]{"", "", "", "", "", "", "", 0, 0}, INTERFACE$StPluginProfile.class);
    public final PBRepeatField<String> download_domain;
    public final PBStringField host_sign;
    public final PBStringField noncestr;
    public final PBStringField plugin_id = PBField.initString("");
    public final PBRepeatField<String> request_domain;
    public final PBUInt32Field running_flag_info;
    public final PBUInt32Field timestamp;
    public final PBRepeatField<String> upload_domain;
    public final PBRepeatField<String> wsrequest_domain;

    public INTERFACE$StPluginProfile() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.download_domain = PBField.initRepeat(pBStringField);
        this.request_domain = PBField.initRepeat(pBStringField);
        this.wsrequest_domain = PBField.initRepeat(pBStringField);
        this.upload_domain = PBField.initRepeat(pBStringField);
        this.host_sign = PBField.initString("");
        this.noncestr = PBField.initString("");
        this.timestamp = PBField.initUInt32(0);
        this.running_flag_info = PBField.initUInt32(0);
    }
}
