package NS_CERTIFIED_ACCOUNT;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CertifiedAccountMeta$StPushSet extends MessageMicro<CertifiedAccountMeta$StPushSet> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34}, new String[]{WadlProxyConsts.CREATE_TIME, RemoteMessageConst.SEND_TIME, "pFeeds", "pushSetID"}, new Object[]{0, 0, null, ""}, CertifiedAccountMeta$StPushSet.class);
    public final PBUInt32Field createTime = PBField.initUInt32(0);
    public final PBUInt32Field sendTime = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StPushFeed> pFeeds = PBField.initRepeatMessage(CertifiedAccountMeta$StPushFeed.class);
    public final PBStringField pushSetID = PBField.initString("");
}
