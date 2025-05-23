package NS_CERTIFIED_ACCOUNT_READ;

import NS_CERTIFIED_ACCOUNT.CertifiedAccountMeta$StQQGroup;
import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFansGroupListRsp extends MessageMicro<CertifiedAccountRead$StGetFansGroupListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"extInfo", "vecGroup"}, new Object[]{null, null}, CertifiedAccountRead$StGetFansGroupListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBRepeatMessageField<CertifiedAccountMeta$StQQGroup> vecGroup = PBField.initRepeatMessage(CertifiedAccountMeta$StQQGroup.class);
}
