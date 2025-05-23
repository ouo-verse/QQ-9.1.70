package com.tencent.biz.qqstory.base;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.biz.qqcircle.QCircleSchemeAttr;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBDoubleField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes5.dex */
public final class SerializationPB$PicInfo extends MessageMicro<SerializationPB$PicInfo> {
    static final MessageMicro.FieldMap __fieldMap__;

    /* renamed from: id, reason: collision with root package name */
    public final PBUInt64Field f93964id = PBField.initUInt64(0);
    public final PBStringField path = PBField.initString("");
    public final PBStringField thumb = PBField.initString("");
    public final PBUInt32Field width = PBField.initUInt32(0);
    public final PBUInt32Field height = PBField.initUInt32(0);
    public final PBUInt32Field orientation = PBField.initUInt32(0);
    public final PBUInt64Field create_time = PBField.initUInt64(0);
    public final PBDoubleField lat = PBField.initDouble(0.0d);
    public final PBDoubleField lng = PBField.initDouble(0.0d);
    public final PBStringField geo_hash = PBField.initString("");
    public final PBUInt32Field state = PBField.initUInt32(0);
    public final PBStringField mime = PBField.initString("");
    public final PBUInt64Field size = PBField.initUInt64(0);
    public final PBUInt64Field db_create_time = PBField.initUInt64(0);

    static {
        String[] strArr = {"id", "path", "thumb", "width", "height", "orientation", AlbumCacheData.CREATE_TIME, QCircleSchemeAttr.Polymerize.LAT, "lng", "geo_hash", "state", "mime", "size", "db_create_time"};
        Double valueOf = Double.valueOf(0.0d);
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 65, 73, 82, 88, 98, 104, 112}, strArr, new Object[]{0L, "", "", 0, 0, 0, 0L, valueOf, valueOf, "", 0, "", 0L, 0L}, SerializationPB$PicInfo.class);
    }
}
