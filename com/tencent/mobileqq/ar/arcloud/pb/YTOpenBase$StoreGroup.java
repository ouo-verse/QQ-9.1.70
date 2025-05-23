package com.tencent.mobileqq.ar.arcloud.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBStringField;

/* compiled from: P */
/* loaded from: classes11.dex */
public final class YTOpenBase$StoreGroup extends MessageMicro<YTOpenBase$StoreGroup> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26}, new String[]{"group_id", "person_ids", "tag"}, new Object[]{"", "", ""}, YTOpenBase$StoreGroup.class);
    public final PBStringField group_id = PBField.initString("");
    public final PBRepeatField<String> person_ids = PBField.initRepeat(PBStringField.__repeatHelper__);
    public final PBStringField tag = PBField.initString("");
}
