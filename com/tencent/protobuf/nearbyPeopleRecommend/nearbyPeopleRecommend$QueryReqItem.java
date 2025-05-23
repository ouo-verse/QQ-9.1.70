package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;

/* loaded from: classes22.dex */
public final class nearbyPeopleRecommend$QueryReqItem extends MessageMicro<nearbyPeopleRecommend$QueryReqItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"msg_id"}, new Object[]{""}, nearbyPeopleRecommend$QueryReqItem.class);
    public final PBStringField msg_id = PBField.initString("");
}
