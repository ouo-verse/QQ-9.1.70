package NS_CERTIFIED_ACCOUNT;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StAioMsg extends MessageMicro<CertifiedAccountMeta$StAioMsg> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34}, new String[]{"id", "sendUser", WadlProxyConsts.CREATE_TIME, RemoteMessageConst.MessageBody.MSG_CONTENT}, new Object[]{"", null, 0L, ""}, CertifiedAccountMeta$StAioMsg.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBStringField f24923id = PBField.initString("");
    public CertifiedAccountMeta$StUser sendUser = new CertifiedAccountMeta$StUser();
    public final PBUInt64Field createTime = PBField.initUInt64(0);
    public final PBStringField msgContent = PBField.initString("");
}
