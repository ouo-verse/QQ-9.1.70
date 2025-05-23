package cooperation.ilive.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes28.dex */
public final class LiveGroupTips$GetLiveGroupTipsReq extends MessageMicro<LiveGroupTips$GetLiveGroupTipsReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"anchor_uid", "group_id"}, new Object[]{"", 0L}, LiveGroupTips$GetLiveGroupTipsReq.class);
    public final PBStringField anchor_uid = PBField.initString("");
    public final PBUInt64Field group_id = PBField.initUInt64(0);
}
