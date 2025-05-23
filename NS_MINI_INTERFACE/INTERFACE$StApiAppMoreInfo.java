package NS_MINI_INTERFACE;

import NS_MINI_META.META_PROTOCOL$StAppInfo;
import NS_MINI_META.META_PROTOCOL$StDeveloperInfo;
import NS_MINI_META.META_PROTOCOL$StServerDomainInfo;
import com.heytap.mcssdk.a.a;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StApiAppMoreInfo extends MessageMicro<INTERFACE$StApiAppMoreInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"appInfo", "developerInfo", "serverDomainInfo", "updateTime"}, new Object[]{null, null, null, 0}, INTERFACE$StApiAppMoreInfo.class);
    public META_PROTOCOL$StAppInfo appInfo = new MessageMicro<META_PROTOCOL$StAppInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StAppInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58, 66}, new String[]{"appid", a.f36103m, "developerId", "appname", "appIcon", "appDesc", "serviceCategory", "baselibMiniVersion"}, new Object[]{"", "", "", "", "", "", "", ""}, META_PROTOCOL$StAppInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBStringField appSecret = PBField.initString("");
        public final PBStringField developerId = PBField.initString("");
        public final PBStringField appname = PBField.initString("");
        public final PBStringField appIcon = PBField.initString("");
        public final PBStringField appDesc = PBField.initString("");
        public final PBRepeatField<String> serviceCategory = PBField.initRepeat(PBStringField.__repeatHelper__);
        public final PBStringField baselibMiniVersion = PBField.initString("");
    };
    public META_PROTOCOL$StDeveloperInfo developerInfo = new MessageMicro<META_PROTOCOL$StDeveloperInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StDeveloperInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 34, 40, 48, 56, 66, 74, 82, 90, 98, 106, 112}, new String[]{"developerId", "createTimestamp", "updateTimestamp", "email", "type", "auditState", "IDType", "IDName", "IDNum", "IDImg", "contactPhoneNum", "contactAddress", "administratorInfo", "appNum"}, new Object[]{"", 0, 0, "", 0, 0, 0, "", "", "", "", "", null, 0}, META_PROTOCOL$StDeveloperInfo.class);
        public final PBStringField developerId = PBField.initString("");
        public final PBUInt32Field createTimestamp = PBField.initUInt32(0);
        public final PBUInt32Field updateTimestamp = PBField.initUInt32(0);
        public final PBStringField email = PBField.initString("");
        public final PBUInt32Field type = PBField.initUInt32(0);
        public final PBUInt32Field auditState = PBField.initUInt32(0);
        public final PBUInt32Field IDType = PBField.initUInt32(0);
        public final PBStringField IDName = PBField.initString("");
        public final PBStringField IDNum = PBField.initString("");
        public final PBStringField IDImg = PBField.initString("");
        public final PBStringField contactPhoneNum = PBField.initString("");
        public final PBStringField contactAddress = PBField.initString("");
        public META_PROTOCOL$StAdministratorInfo administratorInfo = new MessageMicro<META_PROTOCOL$StAdministratorInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StAdministratorInfo
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34}, new String[]{"uin", "IDName", "IDNum", "phoneNum"}, new Object[]{"", "", "", ""}, META_PROTOCOL$StAdministratorInfo.class);
            public final PBStringField uin = PBField.initString("");
            public final PBStringField IDName = PBField.initString("");
            public final PBStringField IDNum = PBField.initString("");
            public final PBStringField phoneNum = PBField.initString("");
        };
        public final PBUInt32Field appNum = PBField.initUInt32(0);
    };
    public META_PROTOCOL$StServerDomainInfo serverDomainInfo = new MessageMicro<META_PROTOCOL$StServerDomainInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StServerDomainInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 48, 56}, new String[]{"appid", "requestDomain", "socketDomain", "uploadFileDomain", "downloadFileDomain", "createTimestamp", "updateTimestamp"}, new Object[]{"", "", "", "", "", 0, 0}, META_PROTOCOL$StServerDomainInfo.class);
        public final PBStringField appid = PBField.initString("");
        public final PBUInt32Field createTimestamp;
        public final PBRepeatField<String> downloadFileDomain;
        public final PBRepeatField<String> requestDomain;
        public final PBRepeatField<String> socketDomain;
        public final PBUInt32Field updateTimestamp;
        public final PBRepeatField<String> uploadFileDomain;

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.requestDomain = PBField.initRepeat(pBStringField);
            this.socketDomain = PBField.initRepeat(pBStringField);
            this.uploadFileDomain = PBField.initRepeat(pBStringField);
            this.downloadFileDomain = PBField.initRepeat(pBStringField);
            this.createTimestamp = PBField.initUInt32(0);
            this.updateTimestamp = PBField.initUInt32(0);
        }
    };
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
}
