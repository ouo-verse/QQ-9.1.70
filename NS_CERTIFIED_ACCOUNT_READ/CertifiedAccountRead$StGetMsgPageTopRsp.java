package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StUser;
import NS_COMM.COMM;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetMsgPageTopRsp extends MessageMicro<CertifiedAccountRead$StGetMsgPageTopRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"extInfo", WadlProxyConsts.NOTICE_COUNT, "vecUser"}, new Object[]{null, 0, null}, CertifiedAccountRead$StGetMsgPageTopRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field noticeCount = PBField.initUInt32(0);
    public final PBRepeatMessageField<CertifiedAccountMeta$StUser> vecUser = PBField.initRepeatMessage(CertifiedAccountMeta$StUser.class);
}
