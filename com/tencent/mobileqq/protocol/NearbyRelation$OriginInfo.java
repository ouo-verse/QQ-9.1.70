package com.tencent.mobileqq.protocol;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes35.dex */
public final class NearbyRelation$OriginInfo extends MessageMicro<NearbyRelation$OriginInfo> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18}, new String[]{"id", "tag_text"}, new Object[]{0L, ""}, NearbyRelation$OriginInfo.class);

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f261123id = PBField.initUInt64(0);
    public final PBStringField tag_text = PBField.initString("");
}
