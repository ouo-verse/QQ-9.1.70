package NS_CERTIFIED_ACCOUNT;

import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.winkreport.datong.WinkDaTongReportConstant;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StQQGroup extends MessageMicro<CertifiedAccountMeta$StQQGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24, 32, 40, 48, 58, 66, 72, 80, 90, 96}, new String[]{"id", "owner", WadlProxyConsts.CREATE_TIME, "memberMaxNum", "memberNum", "icon", "name", "desc", "joinState", "joinTime", WinkDaTongReportConstant.ElementParamValue.XSJ_OPERATION_TYPE_AUTH, "safeState"}, new Object[]{0L, 0L, 0, 0, 0, 0, "", "", 0, 0, "", 0}, CertifiedAccountMeta$StQQGroup.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f24927id = PBField.initUInt64(0);
    public final PBUInt64Field owner = PBField.initUInt64(0);
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field memberMaxNum = PBField.initUInt32(0);
    public final PBUInt32Field memberNum = PBField.initUInt32(0);
    public final PBUInt32Field icon = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBStringField desc = PBField.initString("");
    public final PBUInt32Field joinState = PBField.initUInt32(0);
    public final PBUInt32Field joinTime = PBField.initUInt32(0);
    public final PBStringField auth = PBField.initString("");
    public final PBUInt32Field safeState = PBField.initUInt32(0);
}
