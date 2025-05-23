package com.tencent.ilive_user_basic_info;

import com.qzone.album.data.model.AlbumCacheData;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

/* compiled from: P */
/* loaded from: classes7.dex */
public final class ilive_user_basic_info$MedalInfo extends MessageMicro<ilive_user_basic_info$MedalInfo> {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt64Field create_time;
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
    public final PBBytesField medal_url;
    public final PBUInt32Field medal_version;
    public final PBUInt64Field update_time;

    static {
        String[] strArr = {"medal_id", "medal_name", "medal_face_small", "medal_type", "medal_start_time", "medal_end_time", "medal_priority_level", "medal_desc", "medal_url", "medal_face_bigger", "medal_version", "medal_index", "medal_level", "medal_point", AlbumCacheData.CREATE_TIME, "update_time", "medal_bg", "medal_frame", "medal_bg_img"};
        ByteStringMicro byteStringMicro = ByteStringMicro.EMPTY;
        __fieldMap__ = MessageMicro.initFieldMap(new int[]{8, 18, 26, 32, 40, 48, 56, 66, 74, 82, 88, 96, 104, 112, 120, 128, 136, 144, 154}, strArr, new Object[]{0, byteStringMicro, byteStringMicro, 0, 0L, 0L, 0, byteStringMicro, byteStringMicro, byteStringMicro, 0, 0, 0, 0, 0L, 0L, 0, 0, byteStringMicro}, ilive_user_basic_info$MedalInfo.class);
    }

    public ilive_user_basic_info$MedalInfo() {
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
    }
}
