package com.tencent.protobuf.nearbyPeopleRecommend;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;

/* loaded from: classes22.dex */
public final class nearbyPeopleRecommend$QueryRecommendReq extends MessageMicro<nearbyPeopleRecommend$QueryRecommendReq> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 16, 26, 32, 40, 50}, new String[]{"lbs_info", "source", "query_list", "uint32_client_version", "uint32_client_type", "bytes_qq_version"}, new Object[]{null, 0, null, 0, 0, ByteStringMicro.EMPTY}, nearbyPeopleRecommend$QueryRecommendReq.class);
    public nearbyPeopleRecommend$LBSInfo lbs_info = new MessageMicro<nearbyPeopleRecommend$LBSInfo>() { // from class: com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend$LBSInfo
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"location"}, new Object[]{null}, nearbyPeopleRecommend$LBSInfo.class);
        public nearbyPeopleRecommend$Location location = new MessageMicro<nearbyPeopleRecommend$Location>() { // from class: com.tencent.protobuf.nearbyPeopleRecommend.nearbyPeopleRecommend$Location
            static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 16, 24}, new String[]{"int32_latitude", "int32_longitude", "int32_coordinate"}, new Object[]{0, 0, 0}, nearbyPeopleRecommend$Location.class);
            public final PBInt32Field int32_latitude = PBField.initInt32(0);
            public final PBInt32Field int32_longitude = PBField.initInt32(0);
            public final PBInt32Field int32_coordinate = PBField.initInt32(0);
        };
    };
    public final PBInt32Field source = PBField.initInt32(0);
    public final PBRepeatMessageField<nearbyPeopleRecommend$QueryReqItem> query_list = PBField.initRepeatMessage(nearbyPeopleRecommend$QueryReqItem.class);
    public final PBUInt32Field uint32_client_version = PBField.initUInt32(0);
    public final PBUInt32Field uint32_client_type = PBField.initUInt32(0);
    public final PBBytesField bytes_qq_version = PBField.initBytes(ByteStringMicro.EMPTY);
}
