package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.data.MessageForBirthdayNotice;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StSubmitVersionRsp extends MessageMicro<INTERFACE$StSubmitVersionRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"extInfo", MessageForBirthdayNotice.MSG_BIRTHDAY_NOTICE_LINK, "versionid"}, new Object[]{null, "", ""}, INTERFACE$StSubmitVersionRsp.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField link = PBField.initString("");
    public final PBStringField versionid = PBField.initString("");
}
