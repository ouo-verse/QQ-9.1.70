package com.tencent.mobileqq.troop.org.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes19.dex */
public final class oidb_0x496$RobotSubscribeCategory extends MessageMicro<oidb_0x496$RobotSubscribeCategory> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 24, 34, 42}, new String[]{"id", "name", "type", "next_wording", "next_content"}, new Object[]{0, "", 0, "", ""}, oidb_0x496$RobotSubscribeCategory.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f298093id = PBField.initUInt32(0);
    public final PBStringField name = PBField.initString("");
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBStringField next_wording = PBField.initString("");
    public final PBStringField next_content = PBField.initString("");
}
