package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetAppInfoByLinkReq extends MessageMicro<INTERFACE$StGetAppInfoByLinkReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"extInfo", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "linkType"}, new Object[]{null, "", 0}, INTERFACE$StGetAppInfoByLinkReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
    public final PBInt32Field linkType = PBField.initInt32(0);
}
