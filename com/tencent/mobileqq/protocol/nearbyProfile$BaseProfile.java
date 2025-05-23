package com.tencent.mobileqq.protocol;

import com.qzone.module.covercomponent.model.CoverDBCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.weiyun.poi.PoiDbManager;

/* loaded from: classes35.dex */
public final class nearbyProfile$BaseProfile extends MessageMicro<nearbyProfile$BaseProfile> {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 24, 34, 40, 802, 810}, new String[]{"nick", "logo", "gender", "birthday", "age", "location", CoverDBCacheData.PHOTO_WALL}, new Object[]{"", "", 0, ByteStringMicro.EMPTY, 0, null, null}, nearbyProfile$BaseProfile.class);
    public final PBStringField nick = PBField.initString("");
    public final PBStringField logo = PBField.initString("");
    public final PBUInt32Field gender = PBField.initUInt32(0);
    public final PBBytesField birthday = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field age = PBField.initUInt32(0);
    public nearbyProfile$Location location = new MessageMicro<nearbyProfile$Location>() { // from class: com.tencent.mobileqq.protocol.nearbyProfile$Location
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10, 18, 26, 34, 40, 48, 56}, new String[]{"country", "province", "city", PoiDbManager.COL_POI_CITY_ID, "city_zone_id", "latitude", "longitude"}, new Object[]{"", "", "", ByteStringMicro.EMPTY, 0, 0L, 0L}, nearbyProfile$Location.class);
        public final PBStringField country = PBField.initString("");
        public final PBStringField province = PBField.initString("");
        public final PBStringField city = PBField.initString("");
        public final PBBytesField city_id = PBField.initBytes(ByteStringMicro.EMPTY);
        public final PBUInt32Field city_zone_id = PBField.initUInt32(0);
        public final PBUInt64Field latitude = PBField.initUInt64(0);
        public final PBUInt64Field longitude = PBField.initUInt64(0);
    };
    public nearbyProfile$PhotoWall photo_wall = new MessageMicro<nearbyProfile$PhotoWall>() { // from class: com.tencent.mobileqq.protocol.nearbyProfile$PhotoWall
        static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[]{10}, new String[]{"photo"}, new Object[]{null}, nearbyProfile$PhotoWall.class);
        public final PBRepeatMessageField<nearbyProfile$Photo> photo = PBField.initRepeatMessage(nearbyProfile$Photo.class);
    };
}
