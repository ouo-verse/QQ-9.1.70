package com.tencent.protofile.group_homework;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class value$UserIdentityInfo extends MessageMicro<value$UserIdentityInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 26, 34, 42, 48, 56, 66}, new String[]{"group_id", "id", "course", "title", "name", "ts", "type", "tmp_info"}, new Object[]{0L, 0, "", "", "", 0, 0, null}, value$UserIdentityInfo.class);
    public final PBUInt64Field group_id = PBField.initUInt64(0);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt32Field f342201id = PBField.initUInt32(0);
    public final PBStringField course = PBField.initString("");
    public final PBStringField title = PBField.initString("");
    public final PBStringField name = PBField.initString("");

    /* renamed from: ts, reason: collision with root package name */
    public final PBUInt32Field f342202ts = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public value$UserIdentityInfo tmp_info = new value$UserIdentityInfo();
}
