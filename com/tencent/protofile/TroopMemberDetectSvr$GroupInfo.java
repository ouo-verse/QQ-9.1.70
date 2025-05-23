package com.tencent.protofile;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class TroopMemberDetectSvr$GroupInfo extends MessageMicro<TroopMemberDetectSvr$GroupInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32}, new String[]{"group_id", "group_name", "group_face", "join_time"}, new Object[]{0L, "", "", 0L}, TroopMemberDetectSvr$GroupInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);
    public final PBStringField group_name = PBField.initString("");
    public final PBStringField group_face = PBField.initString("");
    public final PBUInt64Field join_time = PBField.initUInt64(0);
}
