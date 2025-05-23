package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes5.dex */
public final class qqstory_service$POI extends MessageMicro<qqstory_service$POI> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16}, new String[]{"address", "poi_type"}, new Object[]{null, 0}, qqstory_service$POI.class);
    public qqstory_struct$Address address = new qqstory_struct$Address();
    public final PBUInt32Field poi_type = PBField.initUInt32(0);
}
