package com.tencent.now_proxy;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class pb_now_proxy$AuthInfo extends MessageMicro<pb_now_proxy$AuthInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24}, new String[]{"original_id", "original_key", "original_id_type"}, new Object[]{"", "", 0}, pb_now_proxy$AuthInfo.class);
    public final PBStringField original_id = PBField.initString("");
    public final PBStringField original_key = PBField.initString("");
    public final PBUInt32Field original_id_type = PBField.initUInt32(0);
}
