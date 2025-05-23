package NS_MINI_META;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.mini.servlet.MiniAppGetPrivacyDetailServlet;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* loaded from: classes.dex */
public final class META_PROTOCOL$StMemberInfo extends MessageMicro<META_PROTOCOL$StMemberInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 42, 50, 58, 66, 74}, new String[]{"appid", WadlProxyConsts.CREATE_TIME, "updateTime", "state", "uin", "nick", "avatar", "remark", MiniAppGetPrivacyDetailServlet.KEY_AUTHORITY_NAME}, new Object[]{"", 0, 0, 0, "", "", "", "", null}, META_PROTOCOL$StMemberInfo.class);
    public final PBStringField appid = PBField.initString("");
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field updateTime = PBField.initUInt32(0);
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBStringField uin = PBField.initString("");
    public final PBStringField nick = PBField.initString("");
    public final PBStringField avatar = PBField.initString("");
    public final PBStringField remark = PBField.initString("");
    public META_PROTOCOL$StAuthorityInfo authority = new MessageMicro<META_PROTOCOL$StAuthorityInfo>() { // from class: NS_MINI_META.META_PROTOCOL$StAuthorityInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 56, 64}, new String[]{"develop", WinkDaTongReportConstant.ElementParamValue.XSJ_QZONE_MODE_EXPERIENCE, "loginAdmin", "dataAnalyze", "developManage", "developSetup", "pauseService", "gameOperate"}, new Object[]{0, 0, 0, 0, 0, 0, 0, 0}, META_PROTOCOL$StAuthorityInfo.class);
        public final PBUInt32Field develop = PBField.initUInt32(0);
        public final PBUInt32Field experience = PBField.initUInt32(0);
        public final PBUInt32Field loginAdmin = PBField.initUInt32(0);
        public final PBUInt32Field dataAnalyze = PBField.initUInt32(0);
        public final PBUInt32Field developManage = PBField.initUInt32(0);
        public final PBUInt32Field developSetup = PBField.initUInt32(0);
        public final PBUInt32Field pauseService = PBField.initUInt32(0);
        public final PBUInt32Field gameOperate = PBField.initUInt32(0);
    };
}
