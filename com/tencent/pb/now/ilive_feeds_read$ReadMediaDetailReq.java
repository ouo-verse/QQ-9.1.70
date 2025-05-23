package com.tencent.pb.now;

import com.qzone.proxy.personalitycomponent.model.WidgetCacheConstellationData;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes22.dex */
public final class ilive_feeds_read$ReadMediaDetailReq extends MessageMicro<ilive_feeds_read$ReadMediaDetailReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 24, 32, 40}, new String[]{"feedid", "start", WidgetCacheConstellationData.NUM, "type", "follow_uid"}, new Object[]{"", 0, 0, 0, 0L}, ilive_feeds_read$ReadMediaDetailReq.class);
    public final PBStringField feedid = PBField.initString("");
    public final PBUInt32Field start = PBField.initUInt32(0);
    public final PBUInt32Field num = PBField.initUInt32(0);
    public final PBUInt32Field type = PBField.initUInt32(0);
    public final PBUInt64Field follow_uid = PBField.initUInt64(0);
}
