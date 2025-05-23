package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* compiled from: P */
/* loaded from: classes5.dex */
public final class qqstory_struct$CompInfoBase extends MessageMicro<qqstory_struct$CompInfoBase> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 32, 40, 50}, new String[]{"title", "backgroud_url", "compared_vid", "is_compared_able", "oa_task_id", "icon_url"}, new Object[]{"", "", "", 0, 0, ""}, qqstory_struct$CompInfoBase.class);
    public final PBStringField title = PBField.initString("");
    public final PBStringField backgroud_url = PBField.initString("");
    public final PBStringField compared_vid = PBField.initString("");
    public final PBUInt32Field is_compared_able = PBField.initUInt32(0);
    public final PBUInt32Field oa_task_id = PBField.initUInt32(0);
    public final PBStringField icon_url = PBField.initString("");
}
