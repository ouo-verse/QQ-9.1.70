package com.tencent.mobileqq.soload.entity;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes18.dex */
public final class ResourceLimit$HippyDownLoadAllowRsp extends MessageMicro<ResourceLimit$HippyDownLoadAllowRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16}, new String[]{"success", "next_time"}, new Object[]{Boolean.FALSE, 0L}, ResourceLimit$HippyDownLoadAllowRsp.class);
    public final PBBoolField success = PBField.initBool(false);
    public final PBUInt64Field next_time = PBField.initUInt64(0);
}
