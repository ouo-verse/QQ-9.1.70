package NS_MINI_INTERFACE;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes.dex */
public final class INTERFACE$StGetUserGroupInfoReq extends MessageMicro<INTERFACE$StGetUserGroupInfoReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32}, new String[]{"extInfo", "groupId", "appid", "groupClass"}, new Object[]{null, "", "", 0L}, INTERFACE$StGetUserGroupInfoReq.class);
    public COMM.StCommonExt extInfo = new COMM.StCommonExt();
    public final PBStringField groupId = PBField.initString("");
    public final PBStringField appid = PBField.initString("");
    public final PBInt64Field groupClass = PBField.initInt64(0);
}
