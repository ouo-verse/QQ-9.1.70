package NS_MINI_META;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StVersionInfo extends MessageMicro<META_PROTOCOL$StVersionInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 34, 42, 50, 58, 66, 72, 80, 90, 96, 104}, new String[]{"versionId", "type", "creater", "appid", "version", "versionDesc", "resourceName", "resourceUrl", WadlProxyConsts.CREATE_TIME, "updateTime", "restoreIp", "releaseRate", "hasSubPkg"}, new Object[]{"", 0, "", "", "", "", "", "", 0, 0, "", 0, 0}, META_PROTOCOL$StVersionInfo.class);
    public final PBStringField versionId = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField creater = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBStringField version = PBField.initString("");
    public final PBStringField versionDesc = PBField.initString("");
    public final PBStringField resourceName = PBField.initString("");
    public final PBStringField resourceUrl = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
    public final PBStringField restoreIp = PBField.initString("");
    public final PBUInt32Field releaseRate = PBField.initUInt32(0);
    public final PBInt32Field hasSubPkg = PBField.initInt32(0);
}
