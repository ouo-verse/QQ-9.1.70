package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class ServerApi$ReqUpdateDownCountRecmd extends MessageMicro<ServerApi$ReqUpdateDownCountRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34}, new String[]{"uin", "source", "pkg_name", "scene"}, new Object[]{0L, "", "", ""}, ServerApi$ReqUpdateDownCountRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField source = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
}
