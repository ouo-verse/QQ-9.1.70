package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import tencent.im.oidb.cmd0x8dd.oidb_0x8dd$NearbyPeople;

/* loaded from: classes22.dex */
public final class nearbyPeopleRecommend$QueryRspItem extends MessageMicro<nearbyPeopleRecommend$QueryRspItem> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18}, new String[]{"msg_id", "rd_people"}, new Object[]{"", null}, nearbyPeopleRecommend$QueryRspItem.class);
    public final PBStringField msg_id = PBField.initString("");
    public final PBRepeatMessageField<oidb_0x8dd$NearbyPeople> rd_people = PBField.initRepeatMessage(oidb_0x8dd$NearbyPeople.class);
}
