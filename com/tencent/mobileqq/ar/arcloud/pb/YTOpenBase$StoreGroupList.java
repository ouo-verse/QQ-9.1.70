package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenBase$StoreGroupList extends MessageMicro<YTOpenBase$StoreGroupList> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"app_id", "group_ids"}, new Object[]{"", ""}, YTOpenBase$StoreGroupList.class);
    public final PBStringField app_id = PBField.initString("");
    public final PBRepeatField<String> group_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
}
