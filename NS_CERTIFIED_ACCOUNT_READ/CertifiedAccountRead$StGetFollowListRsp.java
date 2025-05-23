package NS_CERTIFIED_ACCOUNT_READ;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import tencent.im.oidb.cmd0xcf8.oidb_cmd0xcf8$PublicAccountInfo;

/* compiled from: P */
/* loaded from: classes.dex */
public final class CertifiedAccountRead$StGetFollowListRsp extends MessageMicro<CertifiedAccountRead$StGetFollowListRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"extInfo", "seq", "attach_info", "refresh", "has_next", "account_list"}, new Object[]{null, 0, "", 0, 0, null}, CertifiedAccountRead$StGetFollowListRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBUInt32Field seq = PBField.initUInt32(0);
    public final PBStringField attach_info = PBField.initString("");
    public final PBUInt32Field refresh = PBField.initUInt32(0);
    public final PBUInt32Field has_next = PBField.initUInt32(0);
    public final PBRepeatMessageField<oidb_cmd0xcf8$PublicAccountInfo> account_list = PBField.initRepeatMessage(oidb_cmd0xcf8$PublicAccountInfo.class);
}
