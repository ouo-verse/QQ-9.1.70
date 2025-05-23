package NS_MINI_INTERFACE;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class INTERFACE$StPluginDetail extends MessageMicro<INTERFACE$StPluginDetail> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50, 58}, new String[]{"PluginNetWork", "brandiconurl", "headimgurl", "id", "last_version", "nickname", "signature"}, new Object[]{null, "", "", "", null, "", ""}, INTERFACE$StPluginDetail.class);
    public INTERFACE$StPluginNetWork PluginNetWork = new MessageMicro<INTERFACE$StPluginNetWork>() { // from class: NS_MINI_INTERFACE.INTERFACE$StPluginNetWork
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 42, 50}, new String[]{"RequestDomain", "UploadDomain", "DownloadDomain", "BizDomain", "UDPDomain", "WsRequestDomain"}, new Object[]{"", "", "", "", "", ""}, INTERFACE$StPluginNetWork.class);
        public final PBRepeatField<String> BizDomain;
        public final PBRepeatField<String> DownloadDomain;
        public final PBRepeatField<String> RequestDomain;
        public final PBRepeatField<String> UDPDomain;
        public final PBRepeatField<String> UploadDomain;
        public final PBRepeatField<String> WsRequestDomain;

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.RequestDomain = PBField.initRepeat(pBStringField);
            this.UploadDomain = PBField.initRepeat(pBStringField);
            this.DownloadDomain = PBField.initRepeat(pBStringField);
            this.BizDomain = PBField.initRepeat(pBStringField);
            this.UDPDomain = PBField.initRepeat(pBStringField);
            this.WsRequestDomain = PBField.initRepeat(pBStringField);
        }
    };
    public final PBStringField brandiconurl = PBField.initString("");
    public final PBStringField headimgurl = PBField.initString("");

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24965id = PBField.initString("");
    public INTERFACE$StLastVersion last_version = new MessageMicro<INTERFACE$StLastVersion>() { // from class: NS_MINI_INTERFACE.INTERFACE$StLastVersion
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40}, new String[]{"custom_version", "inner_version", "release_time", "source_md5", "source_size"}, new Object[]{"", "", 0, "", 0}, INTERFACE$StLastVersion.class);
        public final PBStringField custom_version = PBField.initString("");
        public final PBStringField inner_version = PBField.initString("");
        public final PBUInt32Field release_time = PBField.initUInt32(0);
        public final PBStringField source_md5 = PBField.initString("");
        public final PBUInt32Field source_size = PBField.initUInt32(0);
    };
    public final PBStringField nickname = PBField.initString("");
    public final PBStringField signature = PBField.initString("");
}
