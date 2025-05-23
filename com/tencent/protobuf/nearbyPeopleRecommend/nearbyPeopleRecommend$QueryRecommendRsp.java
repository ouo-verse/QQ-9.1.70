package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class nearbyPeopleRecommend$QueryRecommendRsp extends MessageMicro<nearbyPeopleRecommend$QueryRecommendRsp> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26}, new String[]{"ret_code", "ret_msg", "query_list"}, new Object[]{0, "", null}, nearbyPeopleRecommend$QueryRecommendRsp.class);
    public final PBUInt32Field ret_code = PBField.initUInt32(0);
    public final PBStringField ret_msg = PBField.initString("");
    public final PBRepeatMessageField<nearbyPeopleRecommend$QueryRspItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend$QueryRspItem.class);
}
