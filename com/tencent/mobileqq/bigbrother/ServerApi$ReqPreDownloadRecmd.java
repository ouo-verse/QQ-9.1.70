package com.tencent.mobileqq.bigbrother;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes11.dex */
public final class ServerApi$ReqPreDownloadRecmd extends MessageMicro<ServerApi$ReqPreDownloadRecmd> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 34, 42}, new String[]{"uin", "source", "platform", "pkg_name", "scene"}, new Object[]{0L, "", "", "", ""}, ServerApi$ReqPreDownloadRecmd.class);
    public final PBUInt64Field uin = PBField.initUInt64(0);
    public final PBStringField source = PBField.initString("");
    public final PBStringField platform = PBField.initString("");
    public final PBStringField pkg_name = PBField.initString("");
    public final PBStringField scene = PBField.initString("");
}
