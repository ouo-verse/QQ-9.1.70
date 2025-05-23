package com.tencent.icgame.trpc.yes.common;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class CommonOuterClass$GroupData extends MessageMicro<CommonOuterClass$GroupData> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 48, 56}, new String[]{"group_id", "group_head_url", "group_name", "group_member_num", "group_owner", "status", "add_to_fans_group_time"}, new Object[]{"", "", "", 0, 0L, 0, 0}, CommonOuterClass$GroupData.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBStringField group_head_url = PBField.initString("");
    public final PBStringField group_name = PBField.initString("");
    public final PBInt32Field group_member_num = PBField.initInt32(0);
    public final PBUInt64Field group_owner = PBField.initUInt64(0);
    public final PBInt32Field status = PBField.initInt32(0);
    public final PBUInt32Field add_to_fans_group_time = PBField.initUInt32(0);
}
