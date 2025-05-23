package com.tencent.mobileqq.now.nowqqlivefocus;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* loaded from: classes9.dex */
public final class NowQQLiveFocusProto$MedalInfo extends MessageMicro<NowQQLiveFocusProto$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time;
    public final PBStringField logo_full_url;
    public final PBUInt32Field medal_bg;
    public final PBBytesField medal_bg_img;
    public final PBBytesField medal_desc;
    public final PBUInt64Field medal_end_time;
    public final PBBytesField medal_face_bigger;
    public final PBBytesField medal_face_small;
    public final PBUInt32Field medal_frame;
    public final PBUInt32Field medal_id = PBField.initUInt32(0);
    public final PBUInt32Field medal_index;
    public final PBUInt32Field medal_level;
    public final PBBytesField medal_name;
    public final PBUInt32Field medal_point;
    public final PBUInt32Field medal_priority_level;
    public final PBUInt64Field medal_start_time;
    public final PBUInt32Field medal_type;
    public final PBUInt64Field medal_uid;
    public final PBBytesField medal_url;
    public final PBUInt32Field medal_version;
    public final PBUInt64Field update_time;
    public final PBStringField user_nick;

    static {
        String[] strArr = {"medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", AlbumCacheData.CREATE_TIME, "update_time", "medal_bg", "medal_frame", "medal_bg_img", "medal_uid", "user_nick", "logo_full_url"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154, 160, 170, 178}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0L, 0L, 0, 0, byteStringMicro, 0L, "", ""}, NowQQLiveFocusProto$MedalInfo.class);
    }

    public NowQQLiveFocusProto$MedalInfo() {
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        this.medal_name = PBField.initBytes(byteStringMicro);
        this.medal_face_small = PBField.initBytes(byteStringMicro);
        this.medal_type = PBField.initUInt32(0);
        this.medal_start_time = PBField.initUInt64(0L);
        this.medal_end_time = PBField.initUInt64(0L);
        this.medal_priority_level = PBField.initUInt32(0);
        this.medal_desc = PBField.initBytes(byteStringMicro);
        this.medal_url = PBField.initBytes(byteStringMicro);
        this.medal_face_bigger = PBField.initBytes(byteStringMicro);
        this.medal_version = PBField.initUInt32(0);
        this.medal_index = PBField.initUInt32(0);
        this.medal_level = PBField.initUInt32(0);
        this.medal_point = PBField.initUInt32(0);
        this.create_time = PBField.initUInt64(0L);
        this.update_time = PBField.initUInt64(0L);
        this.medal_bg = PBField.initUInt32(0);
        this.medal_frame = PBField.initUInt32(0);
        this.medal_bg_img = PBField.initBytes(byteStringMicro);
        this.medal_uid = PBField.initUInt64(0L);
        this.user_nick = PBField.initString("");
        this.logo_full_url = PBField.initString("");
    }
}
