package com.tencent.biz.qqstory.network.pb;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;

/* loaded from: classes5.dex */
public final class qqstory_service$RspGetPOIPosters extends MessageMicro<qqstory_service$RspGetPOIPosters> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"result", "poi_posters"}, new Object[]{null, null}, qqstory_service$RspGetPOIPosters.class);
    public qqstory_struct$ErrorInfo result = new qqstory_struct$ErrorInfo();
    public final PBRepeatMessageField<qqstory_struct$POIPosterData> poi_posters = PBField.initRepeatMessage(qqstory_struct$POIPosterData.class);
}
