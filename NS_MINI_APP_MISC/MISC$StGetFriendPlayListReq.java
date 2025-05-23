package NS_MINI_APP_MISC;

import NS_COMM.COMM;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes.dex */
public final class MISC$StGetFriendPlayListReq extends MessageMicro<MISC$StGetFriendPlayListReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26}, new String[]{"friendUin", "pageSize", "ext"}, new Object[]{"", 0, null}, MISC$StGetFriendPlayListReq.class);
    public final PBStringField friendUin = PBField.initString("");
    public final PBUInt32Field pageSize = PBField.initUInt32(0);
    public COMM.StCommonExt ext = new COMM.StCommonExt();
}
