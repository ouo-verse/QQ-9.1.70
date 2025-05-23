package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSubmitVersionReq extends MessageMicro<INTERFACE$StSubmitVersionReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 42, 50, 58, 64, 74, 82, 88, 96, 104, 114, 122}, new String[]{"extInfo", "appid", "version", "versionType", "intro", "mainPkg", "subPkgs", "pkgType", "firstPage", "roomId", "supportOffline", "skipDomainCheck", "property", "usePlugin", "ideConfig"}, new Object[]{null, "", "", 0, "", null, null, 0, "", "", 0, 0, 0, null, null}, INTERFACE$StSubmitVersionReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField appid = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBInt32Field versionType = PBField.initInt32(0);
    public final PBStringField intro = PBField.initString("");
    public INTERFACE$StMainPkgInfo mainPkg = new MessageMicro<INTERFACE$StMainPkgInfo>() { // from class: NS_MINI_INTERFACE.INTERFACE$StMainPkgInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"fileId", "pages", "file_size", "file_md5"}, new Object[]{"", "", 0, ""}, INTERFACE$StMainPkgInfo.class);
        public final PBStringField fileId = PBField.initString("");
        public final PBRepeatField<String> file_md5;
        public final PBInt32Field file_size;
        public final PBRepeatField<String> pages;

        {
            PBStringField pBStringField = PBStringField.__repeatHelper__;
            this.pages = PBField.initRepeat(pBStringField);
            this.file_size = PBField.initInt32(0);
            this.file_md5 = PBField.initRepeat(pBStringField);
        }
    };
    public final PBRepeatMessageField<INTERFACE$StSplitPkgInfo> subPkgs = PBField.initRepeatMessage(INTERFACE$StSplitPkgInfo.class);
    public final PBUInt32Field pkgType = PBField.initUInt32(0);
    public final PBStringField firstPage = PBField.initString("");
    public final PBStringField roomId = PBField.initString("");
    public final PBInt32Field supportOffline = PBField.initInt32(0);
    public final PBInt32Field skipDomainCheck = PBField.initInt32(0);
    public final PBInt32Field property = PBField.initInt32(0);
    public INTERFACE$StUsePlugin usePlugin = new MessageMicro<INTERFACE$StUsePlugin>() { // from class: NS_MINI_INTERFACE.INTERFACE$StUsePlugin
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"pluginId", "pluginVersion", "pluginName"}, new Object[]{"", "", ""}, INTERFACE$StUsePlugin.class);
        public final PBStringField pluginId = PBField.initString("");
        public final PBStringField pluginVersion = PBField.initString("");
        public final PBStringField pluginName = PBField.initString("");
    };
    public INTERFACE$StIdeConfig ideConfig = new INTERFACE$StIdeConfig();
}
