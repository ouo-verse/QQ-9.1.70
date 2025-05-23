package com.tencent.pb.scupdate;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class SCUpdatePB$ItemExtend extends MessageMicro<SCUpdatePB$ItemExtend> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"app_version"}, new Object[]{""}, SCUpdatePB$ItemExtend.class);
    public final PBStringField app_version = PBField.initString("");
}
