package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StDomainConfig extends MessageMicro<INTERFACE$StDomainConfig> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "businessDomain", "udpIpList"}, new Object[]{"", "", "", "", "", ""}, INTERFACE$StDomainConfig.class);
    public final PBRepeatField<String> businessDomain;
    public final PBRepeatField<String> downloadFileDomain;
    public final PBRepeatField<String> requestDomain;
    public final PBRepeatField<String> socketDomain;
    public final PBRepeatField<String> udpIpList;
    public final PBRepeatField<String> uploadFileDomain;

    public INTERFACE$StDomainConfig() {
        PBStringField pBStringField = PBStringField.__repeatHelper__;
        this.requestDomain = PBField.initRepeat(pBStringField);
        this.socketDomain = PBField.initRepeat(pBStringField);
        this.uploadFileDomain = PBField.initRepeat(pBStringField);
        this.downloadFileDomain = PBField.initRepeat(pBStringField);
        this.businessDomain = PBField.initRepeat(pBStringField);
        this.udpIpList = PBField.initRepeat(pBStringField);
    }
}
